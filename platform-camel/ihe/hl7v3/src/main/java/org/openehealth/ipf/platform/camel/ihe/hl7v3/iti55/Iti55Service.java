/*
 * Copyright 2010 the original author or authors.
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
package org.openehealth.ipf.platform.camel.ihe.hl7v3.iti55;

import groovy.xml.slurpersupport.GPathResult;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.apache.cxf.jaxws.context.WebServiceContextImpl;
import org.apache.cxf.jaxws.context.WrappedMessageContext;
import org.apache.cxf.ws.addressing.AddressingProperties;
import org.apache.cxf.ws.addressing.AttributedURIType;
import org.openehealth.ipf.commons.ihe.hl7v3.Hl7v3Exception;
import org.openehealth.ipf.commons.ihe.hl7v3.Hl7v3Utils;
import org.openehealth.ipf.commons.ihe.hl7v3.Hl7v3WsTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.hl7v3.iti55.Iti55PortType;
import org.openehealth.ipf.commons.ihe.hl7v3.iti55.Iti55Utils;
import org.openehealth.ipf.commons.ihe.ws.cxf.audit.AbstractAuditInterceptor;
import org.openehealth.ipf.commons.ihe.ws.cxf.audit.WsAuditDataset;
import org.openehealth.ipf.platform.camel.core.util.Exchanges;
import org.openehealth.ipf.platform.camel.ihe.hl7v3.AbstractHl7v3WebService;
import org.openehealth.ipf.platform.camel.ihe.hl7v3.Hl7v3Endpoint;
import org.openehealth.ipf.platform.camel.ihe.ws.AbstractWsEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.concurrent.ExecutorService;

import static org.apache.cxf.ws.addressing.JAXWSAConstants.ADDRESSING_PROPERTIES_INBOUND;
import static org.apache.cxf.ws.addressing.JAXWSAConstants.ADDRESSING_PROPERTIES_OUTBOUND;
import static org.openehealth.ipf.commons.ihe.hl7v3.Hl7v3NakFactory.response;
import static org.openehealth.ipf.commons.ihe.hl7v3.XCPD.Interactions.ITI_55;
import static org.openehealth.ipf.platform.camel.ihe.hl7v3.iti55.deferredresponse.Iti55DeferredResponseComponent.THREAD_POOL_NAME;

/**
 * Service implementation for the Responding Gateway actor
 * of the IHE ITI-55 transaction (XCPD)
 * with support for the Deferred Response option.
 *
 * @author Dmytro Rud
 */
public class Iti55Service extends AbstractHl7v3WebService implements Iti55PortType {
    private static final Logger log = LoggerFactory.getLogger(Iti55Service.class);

    private final ProducerTemplate producerTemplate;
    private final ExecutorService executorService;
    private final Hl7v3Endpoint<Hl7v3WsTransactionConfiguration> endpoint;
    private final CamelContext camelContext;


    /**
     * Constructor.
     * @param endpoint
     *      Camel endpoint instance this Web Service corresponds to.
     */
    Iti55Service(Hl7v3Endpoint<Hl7v3WsTransactionConfiguration> endpoint) {
        super(ITI_55);
        this.endpoint = endpoint;
        this.camelContext = endpoint.getCamelContext();
        this.producerTemplate = this.camelContext.createProducerTemplate();
        this.executorService = getDeferredResponseExecutorService();
    }

    private ExecutorService getDeferredResponseExecutorService(){
        var manager = this.camelContext.getExecutorServiceManager();

        //Try to get one from the registry
        var result = manager.newThreadPool(this, THREAD_POOL_NAME, THREAD_POOL_NAME);
        
        //Create a default one with non-daemon threads
        if (result == null){
            result = manager.newDefaultThreadPool(this, THREAD_POOL_NAME);
        }
        return result;
    }


    @Override
    public String discoverPatients(String requestString) {
        return doProcess(requestString);
    }

    @Override
    public String discoverPatientsDeferred(String requestString) {
        return doProcess(requestString);
    }


    @Override
    protected String doProcess(String request) {
        final var requestString = request;
        final var requestXml = Hl7v3Utils.slurp(requestString);
        final var processingMode = Iti55Utils.processingMode(requestXml);

        // process regular requests in a synchronous route
        if ("I".equals(processingMode)) {
            var response = doProcess0(requestString, requestXml);
            configureWsaAction(Iti55PortType.REGULAR_REQUEST_OUTPUT_ACTION);
            return response;
        }

        else if ("D".equals(processingMode)) {
            // check whether deferred response URI is specified
            final var deferredResponseUri = Iti55Utils.normalizedDeferredResponseUri(requestXml);
            if (deferredResponseUri == null) {
                var hl7v3Exception = new Hl7v3Exception("Deferred response URI is missing or not HTTP(S)");
                hl7v3Exception.setTypeCode("AE");
                hl7v3Exception.setAcknowledgementDetailCode("SYN105");
                hl7v3Exception.setQueryResponseCode("AE");
                return createNak(requestXml, hl7v3Exception);
            }

            // determine original request message ID
            final var messageContext = (WrappedMessageContext) new WebServiceContextImpl().getMessageContext();
            var apropos = (AddressingProperties) messageContext.get(ADDRESSING_PROPERTIES_INBOUND);
            final var requestMessageId = ((apropos != null) && (apropos.getMessageID() != null)) ?
                    apropos.getMessageID().getValue() : null;
            if (requestMessageId == null) {
                log.warn("Cannot determine WS-Addressing ID of the request message");
            }

            final var auditDataset = (WsAuditDataset) messageContext.getWrappedMessage()
                    .getContextualProperty(AbstractAuditInterceptor.DATASET_CONTEXT_KEY);

            // in a separate thread: run the route, send its result synchronously
            // to the deferred response URI, ignore all errors and ACKs
            var mdcContextMap = MDC.getCopyOfContextMap();
            var processRouteAndNotifyTask = (Runnable) () -> {
                try {
                    MDC.setContextMap(mdcContextMap);

                    // Message context is a thread local object, so we need to propagate in into
                    // this new thread.  Note that the producer (see producerTemplate below) will
                    // get its own message context, precisely spoken a freshly created one.
                    WebServiceContextImpl.setMessageContext(messageContext);

                    // run the route
                    Object result = doProcess0(requestString, requestXml);

                    // prepare and send deferred response.
                    // NB: Camel message headers will be used in Iti55DeferredResponseProducer
                    Exchange exchange = new DefaultExchange(camelContext);
                    exchange.getIn().setBody(result);
                    exchange.getIn().setHeader("iti55.deferred.requestMessageId", requestMessageId);
                    exchange.getIn().setHeader("iti55.deferred.auditDataset", auditDataset);

                    var responseEndpoint = (AbstractWsEndpoint<?, ?>) camelContext.getEndpoint(deferredResponseUri);
                    responseEndpoint.setAuditContext(endpoint.getAuditContext());

                    exchange = producerTemplate.send(responseEndpoint, exchange);
                    var exception = Exchanges.extractException(exchange);
                    if (exception != null) {
                        log.error("Sending deferred response failed", exception);
                    }
                } finally {
                    MDC.clear();
                }
           };

            executorService.submit(processRouteAndNotifyTask);

            // return an immediate MCCI ACK
            configureWsaAction(Iti55PortType.DEFERRED_REQUEST_OUTPUT_ACTION);
            return response(requestXml, null, "MCCI_IN000002UV01", null, false,
                            getWsTransactionConfiguration().isIncludeQuantities());
        }

        else {
            var hl7v3Exception = new Hl7v3Exception(String.format("Unsupported processing mode '%s'", processingMode));
            hl7v3Exception.setTypeCode("AE");
            hl7v3Exception.setAcknowledgementDetailCode("NS250");
            hl7v3Exception.setQueryResponseCode("AE");
            return createNak(requestXml, hl7v3Exception);
        }
    }


    private String doProcess0(String requestString, GPathResult requestXml) {
        var result = process(requestString);
        var exception = Exchanges.extractException(result);
        return (exception != null) ?
            nak(exception, requestXml) :
            result.getMessage().getBody(String.class);
    }


    /**
     * Generates an XCPD-specific NAK from the given exception.
     * @param exception
     *      occurred exception.
     * @param requestXml
     *      original request as GPath object.
     * @return
     *      NAK as XML string.
     */
    private String nak(Exception exception, GPathResult requestXml) {
        Hl7v3Exception hl7v3Exception;
        if (exception instanceof Hl7v3Exception e) {
            hl7v3Exception = e;
        } else {
            hl7v3Exception = new Hl7v3Exception(exception.getMessage(), exception);
            hl7v3Exception.setDetectedIssueManagementCode("InternalError");
            hl7v3Exception.setDetectedIssueManagementCodeSystem("1.3.6.1.4.1.19376.1.2.27.3");
        }
        return createNak(requestXml, hl7v3Exception);
    }


    /**
     * Configures outbound WS-Addressing header "Action".
     * @param action
     *      WS-Addressing action.
     */
    private static void configureWsaAction(String action) {
        var messageContext = (WrappedMessageContext) new WebServiceContextImpl().getMessageContext();
        var outMessage = messageContext.getWrappedMessage().getExchange().getOutMessage();

        // when WS-Addressing headers were missing from the beginning
        // TODO: is this check still necessary under CXF 2.5?
        if (outMessage == null) {
            return;
        }

        var apropos = (AddressingProperties) outMessage.get(ADDRESSING_PROPERTIES_OUTBOUND);
        if (apropos == null) {
            apropos = new AddressingProperties();
            outMessage.put(ADDRESSING_PROPERTIES_OUTBOUND, apropos);
        }

        var actionHolder = new AttributedURIType();
        actionHolder.setValue(action);
        apropos.setAction(actionHolder);
    }

}
