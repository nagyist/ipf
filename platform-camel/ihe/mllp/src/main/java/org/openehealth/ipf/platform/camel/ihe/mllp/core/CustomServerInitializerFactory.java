/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openehealth.ipf.platform.camel.ihe.mllp.core;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.ssl.SslHandler;
import io.netty.util.concurrent.EventExecutorGroup;
import org.apache.camel.CamelContext;
import org.apache.camel.RuntimeCamelException;
import org.apache.camel.component.netty.ChannelHandlerFactory;
import org.apache.camel.component.netty.NettyConsumer;
import org.apache.camel.component.netty.NettyServerBootstrapConfiguration;
import org.apache.camel.component.netty.ServerInitializerFactory;
import org.apache.camel.component.netty.handlers.ServerChannelHandler;
import org.apache.camel.component.netty.ssl.SSLEngineFactory;
import org.apache.camel.support.jsse.ClientAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;

/**
 * This is mostly a copy of {@link org.apache.camel.component.netty.DefaultServerInitializerFactory} with the exception
 * that SSL Decoding errors are handled with ATNA audit
 *
 * @see AuditAwareSslHandler
 */
class CustomServerInitializerFactory extends ServerInitializerFactory {

    private static final Logger log = LoggerFactory.getLogger(CustomServerInitializerFactory.class);

    private NettyConsumer consumer;
    private SSLContext sslContext;
    private final MllpEndpointConfiguration config;

    CustomServerInitializerFactory(MllpEndpointConfiguration config) {
        this.config = config;
    }

    private CustomServerInitializerFactory(NettyConsumer consumer, MllpEndpointConfiguration config) {
        this.consumer = consumer;
        this.config = config;
        try {
            this.sslContext = createSSLContext(consumer.getContext(), consumer.getConfiguration());
            if (sslContext != null) {
                log.info("Created SslContext {}", sslContext);
            }
        } catch (Exception e) {
            throw RuntimeCamelException.wrapRuntimeCamelException(e);
        }
    }

    @Override
    protected void initChannel(Channel ch) {
        // create a new pipeline
        var channelPipeline = ch.pipeline();

        var sslHandler = configureServerSSLOnDemand();
        if (sslHandler != null) {
            log.debug("Server SSL handler configured and added as an interceptor against the ChannelPipeline: {}", sslHandler);
            addToPipeline("ssl", channelPipeline, sslHandler);
        }

        var encoders = consumer.getConfiguration().getEncodersAsList();
        for (var i = 0; i < encoders.size(); i++) {
            var encoder = encoders.get(i);
            if (encoder instanceof ChannelHandlerFactory channelHandlerFactory) {
                // use the factory to create a new instance of the channel as it may not be shareable
                encoder = channelHandlerFactory.newChannelHandler();
            }
            addToPipeline("encoder-" + i, channelPipeline, encoder);
        }

        var decoders = consumer.getConfiguration().getDecodersAsList();
        for (var i = 0; i < decoders.size(); i++) {
            var decoder = decoders.get(i);
            if (decoder instanceof ChannelHandlerFactory channelHandlerFactory) {
                // use the factory to create a new instance of the channel as it may not be shareable
                decoder = channelHandlerFactory.newChannelHandler();
            }
            addToPipeline("decoder-" + i, channelPipeline, decoder);
        }

        if (consumer.getConfiguration().isUsingExecutorService()) {
            // Just use EventExecutorGroup from the Netty Component
            var applicationExecutor = consumer.getEndpoint().getComponent().getExecutorService();
            addToPipeline("handler", channelPipeline, applicationExecutor, new ServerChannelHandler(consumer));
        } else {
            // still use the worker event loop group here
            addToPipeline("handler", channelPipeline, new ServerChannelHandler(consumer));

        }
        log.trace("Created ChannelPipeline: {}", channelPipeline);
    }

    private void addToPipeline(String name, ChannelPipeline pipeline, ChannelHandler handler) {
        pipeline.addLast(name, handler);
    }

    private void addToPipeline(String name, ChannelPipeline pipeline, EventExecutorGroup executor, ChannelHandler handler) {
        pipeline.addLast(executor, name, handler);
    }

    private SSLContext createSSLContext(CamelContext camelContext, NettyServerBootstrapConfiguration configuration)
            throws Exception {
        if (!configuration.isSsl()) {
            return null;
        }

        SSLContext answer;

        // create ssl context once
        if (configuration.getSslContextParameters() != null) {
            answer = configuration.getSslContextParameters().createSSLContext(camelContext);
        } else {
            if (configuration.getKeyStoreFile() == null && configuration.getKeyStoreResource() == null) {
                log.debug("keystore file is null");
            }
            if (configuration.getTrustStoreFile() == null && configuration.getTrustStoreResource() == null) {
                log.debug("truststore file is null");
            }
            if (configuration.getPassphrase() == null) {
                log.debug("passphrase is null");
            }

            SSLEngineFactory sslEngineFactory;
            if (configuration.getKeyStoreFile() != null || configuration.getTrustStoreFile() != null) {
                sslEngineFactory = new SSLEngineFactory();
                answer = sslEngineFactory.createSSLContext(camelContext,
                        configuration.getKeyStoreFormat(),
                        configuration.getSecurityProvider(),
                        "file:" + configuration.getKeyStoreFile().getPath(),
                        "file:" + configuration.getTrustStoreFile().getPath(),
                        configuration.getPassphrase().toCharArray());
            } else {
                sslEngineFactory = new SSLEngineFactory();
                answer = sslEngineFactory.createSSLContext(camelContext,
                        configuration.getKeyStoreFormat(),
                        configuration.getSecurityProvider(),
                        configuration.getKeyStoreResource(),
                        configuration.getTrustStoreResource(),
                        configuration.getPassphrase().toCharArray());
            }
        }

        return answer;
    }

    private SslHandler configureServerSSLOnDemand() {
        if (!consumer.getConfiguration().isSsl()) {
            return null;
        }
        if (sslContext != null) {
            var engine = sslContext.createSSLEngine();
            engine.setUseClientMode(consumer.getConfiguration().isClientMode());

            var sslContextParameters = consumer.getConfiguration().getSslContextParameters();
            if (sslContextParameters != null && sslContextParameters.getServerParameters() != null) {
                var clientAuthentication = sslContextParameters.getServerParameters().getClientAuthentication();
                if (clientAuthentication != null) {
                    var clientAuthValue = ClientAuthentication.valueOf(clientAuthentication);
                    switch (clientAuthValue) {
                        case NONE:
                            engine.setWantClientAuth(false);
                            engine.setNeedClientAuth(false);
                            break;
                        case WANT:
                            engine.setWantClientAuth(true);
                            break;
                        case REQUIRE:
                            engine.setNeedClientAuth(true);
                            break;
                    }
                }
            }

            engine.setNeedClientAuth(engine.getNeedClientAuth() || consumer.getConfiguration().isNeedClientAuth());

            if (consumer.getConfiguration().isHostnameVerification()) {
                var sslParams = engine.getSSLParameters();
                sslParams.setEndpointIdentificationAlgorithm("HTTPS");
                engine.setSSLParameters(sslParams);
            }
            if (consumer.getConfiguration().getSslContextParameters() == null) {
                // just set the enabledProtocols if the SslContextParameter doesn't set
                engine.setEnabledProtocols(consumer.getConfiguration().getEnabledProtocols().split(","));
            }
            return new AuditAwareSslHandler(engine, config);
        }

        return null;
    }

    @Override
    public ServerInitializerFactory createPipelineFactory(NettyConsumer consumer) {
        return new CustomServerInitializerFactory(consumer, config);
    }
}
