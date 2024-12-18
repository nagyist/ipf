/*
 * Copyright 2009 the original author or authors.
 * 
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
package org.openehealth.ipf.platform.camel.ihe.ws;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.cxf.binding.soap.SoapFault;
import org.apache.cxf.jaxws.context.WebServiceContextImpl;
import org.openehealth.ipf.platform.camel.core.util.Exchanges;

import java.util.Map;

import static java.util.Objects.requireNonNull;
import static org.openehealth.ipf.platform.camel.ihe.ws.HeaderUtils.processIncomingHeaders;
import static org.openehealth.ipf.platform.camel.ihe.ws.HeaderUtils.processUserDefinedOutgoingHeaders;

/**
 * Base class for web services that are aware of a {@link DefaultWsConsumer}.
 *
 * @author Jens Riemschneider
 */
@Slf4j
abstract public class AbstractWebService {
    private DefaultWsConsumer consumer;

    /**
     * Calls the consumer for processing via Camel.
     *
     * @param body
     *          contents of the in-message body to be processed.
     * @param additionalHeaders
     *          additional in-message headers (can be <code>null</code>).
     * @param exchangePattern
     *          pattern of the exchange put into the route.
     * @return the resulting exchange.
     */
    protected Exchange process(
            Object body, 
            Map<String, Object> additionalHeaders,
            ExchangePattern exchangePattern) {
        requireNonNull(consumer);
        var messageContext = new WebServiceContextImpl().getMessageContext();
        var exchange = consumer.getEndpoint().createExchange(exchangePattern);
        
        // prepare input message & headers
        var inputMessage = exchange.getIn();
        inputMessage.setBody(body);
        processIncomingHeaders(messageContext, inputMessage);
        if (additionalHeaders != null) {
            inputMessage.getHeaders().putAll(additionalHeaders);
        }

        // set Camel exchange property based on request encoding
        exchange.setProperty(Exchange.CHARSET_NAME,
                messageContext.get(org.apache.cxf.message.Message.ENCODING));

        // process
        consumer.process(exchange);

        var exception = Exchanges.extractException(exchange, false);
        if (exception instanceof SoapFault soapFault) {
            log.debug("Rethrowing SOAP fault occurred in the route", soapFault);
            throw soapFault;
        }

        // handle resulting message and headers
        processUserDefinedOutgoingHeaders(messageContext, exchange.getMessage(), false);

        // set response encoding based on Camel exchange property
        var responseEncoding = exchange.getProperty(Exchange.CHARSET_NAME, String.class);
        if (responseEncoding != null) {
            messageContext.put(org.apache.cxf.message.Message.ENCODING, responseEncoding);
        }
        return exchange;
    }

    /**
     * Calls the consumer for synchronous (InOut) processing via Camel
     * without additional in-message headers.
     *
     * @param body
     *          contents of the in-message body to be processed.
     * @return the resulting exchange.
     */
    protected Exchange process(Object body) {
        return process(body, null, ExchangePattern.InOut);
    }
    
    /**
     * Sets the consumer to be used to process exchanges
     * @param consumer
     *          the consumer to be used
     */
    public void setConsumer(DefaultWsConsumer consumer) {
        this.consumer = requireNonNull(consumer, "consumer");
    }

    /**
     * Returns the configured ITI consumer instance.
     */
    protected DefaultWsConsumer getConsumer() {
        return consumer;
    }

}
