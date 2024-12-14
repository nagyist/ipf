/*
 * Copyright 2020 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.openehealth.ipf.commons.audit.server;

import lombok.Setter;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.netty.DisposableChannel;

import java.io.Closeable;
import java.net.SocketAddress;
import java.time.Duration;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Abstract base class for TLS and UDP syslog servers. Received Syslog frames must be
 * handled by a consumer; the frames are parsed into a Map with keys as specified in
 * {@link com.github.palindromicity.syslog.DefaultKeyProvider}. If parsing fails (e.g.
 * due to incomplete syslog frames, the map is populated with the raw content and the
 * expection that has been thrown by the parser.
 * <p>
 * One example for a consumer is {@link org.openehealth.ipf.commons.audit.server.support.SyslogEventCollector}
 * that is practical for tests. With this respect, note that SyslogServer is {@link Closeable}, so it can easily
 * be started and stopped by using a try-with-resources statement.
 *
 * @param <T>
 * @author Christian Ohr
 * @since 4.0
 */
public abstract class SyslogServer<T extends DisposableChannel> implements Closeable {

    static final int TIMEOUT = 10;

    protected T channel;
    protected final Consumer<? super Map<String, Object>> consumer;
    protected final Consumer<Throwable> errorConsumer;
    @Setter
    protected int timeoutSeconds = TIMEOUT;

    /**
     * @param consumer      consumer for handled syslog frames
     * @param errorConsumer consumer for errors
     */
    public SyslogServer(Consumer<? super Map<String, Object>> consumer,
                        Consumer<Throwable> errorConsumer) {
        this.consumer = consumer;
        this.errorConsumer = errorConsumer;
    }

    /**
     * Starts the server and returns when started within 10 seconds. Requests are handled
     * on the receiver thread.
     *
     * @param host exposed host
     * @param port port
     * @return this instance
     */
    public SyslogServer<T> start(String host, int port) {
        if (channel != null) {
            throw new IllegalStateException("Syslog server is already running");
        }
        return doStart(host, port);
    }

    public SocketAddress address() {
        return channel.address();
    }

    protected abstract SyslogServer<T> doStart(String host, int port);


    /**
     * Stops the server if it was started before, and returns when stopped within 10 seconds.
     */
    public void stop() {
        if (channel != null) {
            channel.disposeNow(Duration.ofSeconds(timeoutSeconds));
        }
        channel = null;
    }

    /**
     * Asynchronously consumes syslog records. This trick is described at
     * https://levelup.gitconnected.com/reactive-asynchronous-programming-in-java-using-reactor-core-part-2-e9c6caeb8833.
     * It generates a Mono from a potentially blocking call and subscribes using a scheduler.
     *
     * @param map syslog map
     * @return nothing
     */
    protected Mono<Object> handleMap(Map<String, Object> map) {
        return Mono
                .fromRunnable(() -> consumer.accept(map))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public void close() {
        stop();
    }
}
