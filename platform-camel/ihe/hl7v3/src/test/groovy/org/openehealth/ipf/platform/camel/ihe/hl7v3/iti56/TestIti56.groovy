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
package org.openehealth.ipf.platform.camel.ihe.hl7v3.iti56

import org.apache.camel.ExchangePattern
import org.apache.camel.support.DefaultExchange
import org.apache.cxf.binding.soap.SoapFault
import org.apache.cxf.transport.servlet.CXFServlet
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.openehealth.ipf.platform.camel.ihe.hl7v3.HL7v3StandardTestContainer
import org.openehealth.ipf.platform.camel.ihe.ws.AbstractWsEndpoint
import org.springframework.test.annotation.DirtiesContext

import java.util.concurrent.TimeUnit

/**
 * Tests for ITI-56.
 * @author Dmytro Rud
 */
@DirtiesContext
@TestMethodOrder(MethodOrderer.MethodName)
class TestIti56 extends HL7v3StandardTestContainer {
    
    def static CONTEXT_DESCRIPTOR = 'iti56/iti-56.xml'
    
    final String SERVICE1_URI =    "xcpd-iti56://localhost:${port}/iti56service?correlator=#correlator" 
    final String SERVICE1_RESPONSE_URI = "http://localhost:${port}/iti56service-response" 
    final String SERVICE_URI_ERROR = "xcpd-iti56://localhost:${port}/iti56service-error?correlator=#correlator" 
    
    static final String REQUEST = readFile('iti56/iti56-sample-request.xml')

    static final long AWAIT_DELAY = 20 * 1000L

    static void main(args) {
        startServer(new CXFServlet(), CONTEXT_DESCRIPTOR, false, DEMO_APP_PORT)
    }
    
    @BeforeAll
    static void setUpClass() {
        startServer(new CXFServlet(), CONTEXT_DESCRIPTOR)
    }
    
    
    /**
     * Test whether:
     * <ol>
     *   <li> sync and async requests are possible...
     *   <li> ...and not influence each other (they shouldn't),
     *   <li> async requests are really async (exchanges are InOnly and delays do not matter),
     *   <li> SOAP headers (WSA ReplyTo + TTL) can be set and read,
     *   <li> XSD and Schematron validations work...
     *   <li> ...and the messages are valid either,
     *   <li> ATNA auditing works.
     * </ol>
     */
    @Test @Disabled
    void testIti56() {
        final int N = Iti56TestRouteBuilder.TASKS_COUNT
        int i = 0
        
        N.times {
            send(SERVICE1_URI, i++, SERVICE1_RESPONSE_URI)
            send(SERVICE1_URI, i++)
        }

        // wait for completion of asynchronous routes
        Iti56TestRouteBuilder routeBuilder = appContext.getBean(Iti56TestRouteBuilder.class)

        routeBuilder.countDownLatch.await(AWAIT_DELAY, TimeUnit.MILLISECONDS)
        routeBuilder.asyncCountDownLatch.await(AWAIT_DELAY, TimeUnit.MILLISECONDS)

        assert Iti56TestRouteBuilder.responseCount.get() == N * 2
        assert Iti56TestRouteBuilder.asyncResponseCount.get() == N
        
        assert auditSender.messages.size() == N * 4
    }
    
    
    @Test
    void testWithErrorSync() {
        def requestExchange = new DefaultExchange(camelContext)
        requestExchange.in.body = REQUEST
        def responseExchange = producerTemplate.send(SERVICE_URI_ERROR, requestExchange)
        assert responseExchange.exception instanceof SoapFault
        assert responseExchange.exception.message == 'abcd'
    }
    
    
    @Test
    void testWithErrorAsync() {
        def requestExchange = new DefaultExchange(camelContext)
        requestExchange.in.body = REQUEST
        requestExchange.in.headers[AbstractWsEndpoint.WSA_REPLYTO_HEADER_NAME] = SERVICE1_RESPONSE_URI
        def responseExchange = producerTemplate.send(SERVICE_URI_ERROR, requestExchange)
        assert responseExchange.exception == null
        assert responseExchange.pattern == ExchangePattern.InOnly
    }
    
    
    private static void send(
        String endpointUri,
        int n,
        String responseEndpointUri = null)
    {
        def requestExchange = new DefaultExchange(camelContext)
        requestExchange.in.body = REQUEST
        
        // set WSA ReplyTo header, when necessary
        if (responseEndpointUri) {
            requestExchange.in.headers[AbstractWsEndpoint.WSA_REPLYTO_HEADER_NAME] = responseEndpointUri
        }
        
        // set correlation key
        requestExchange.in.headers[AbstractWsEndpoint.CORRELATION_KEY_HEADER_NAME] = "corr ${n}"
        
        // send and check timing
        long startTimestamp = System.currentTimeMillis()
        def resultMessage = producerTemplate.send(endpointUri, requestExchange).message
        // TODO: reactivate test
        //assert (System.currentTimeMillis() - startTimestamp < Iti55TestRouteBuilder.ASYNC_DELAY)
    }
    
}
