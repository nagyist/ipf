/*
 * Copyright 2011 the original author or authors.
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
package org.openehealth.ipf.platform.camel.ihe.hl7v2ws.pcd01;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.util.CastUtils;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.hl7v2.Hl7v2AcceptanceException;
import org.openehealth.ipf.commons.ihe.hl7v2.definitions.HapiContextFactory;
import org.openehealth.ipf.gazelle.validation.profile.pcd.PcdTransactions;
import org.openehealth.ipf.platform.camel.ihe.core.Interceptor;
import org.openehealth.ipf.platform.camel.ihe.core.Interceptor2ProducerAdapter;
import org.openehealth.ipf.platform.camel.ihe.ws.StandardTestContainer;

import javax.management.ObjectName;
import java.util.Scanner;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @author Mitko Kolev
 */
public class Pcd01Test extends StandardTestContainer {
    public static final String CONTEXT_DESCRIPTOR = "pcd-01.xml";

    public static final String PCD_01_SPEC_REQUEST = load(
            HapiContextFactory.createHapiContext(PcdTransactions.PCD1),
            "pcd01/pcd01-request.hl7").toString();

    public static final String PCD_01_SPEC_RESPONSE = load(
            HapiContextFactory.createHapiContext(PcdTransactions.PCD1),
            "pcd01/pcd01-response.hl7").toString();

    public static void main(String... args) {
        startServer(new CXFServlet(), CONTEXT_DESCRIPTOR, false, DEMO_APP_PORT);
    }

    @BeforeAll
    public static void setUpClass() {
        startServer(new CXFServlet(), CONTEXT_DESCRIPTOR);
    }

    @BeforeEach
    public void setUp() {
        MyRejectionHandlingStrategy.resetCounter();
    }

    @Test
    public void testHappyCase() {
        var uri = "pcd-pcd01://localhost:" + getPort() + "/devicedata";
        var response = requestBody(uri, PCD_01_SPEC_REQUEST);
        assertResponseEquals(PCD_01_SPEC_RESPONSE, response);
        assertEquals(0, MyRejectionHandlingStrategy.getCount());
    }

    @Test
    public void testHappyCaseInboundValidation() {
        var uri = "pcd-pcd01://localhost:" + getPort() + "/route_inbound_validation";
        var response = requestBody(uri, PCD_01_SPEC_REQUEST);
        assertResponseEquals(PCD_01_SPEC_RESPONSE, response);
        assertEquals(0, MyRejectionHandlingStrategy.getCount());
    }

    @Test
    public void testHappyCaseInboundAndOutboundValidation() {
        var uri = "pcd-pcd01://localhost:" + getPort() + "/route_inbound_and_outbound_validation";
        var response = requestBody(uri, PCD_01_SPEC_REQUEST);
        assertResponseEquals(PCD_01_SPEC_RESPONSE, response);
        assertEquals(0, MyRejectionHandlingStrategy.getCount());
    }

    @Test
    public void testInacceptableRequestOnProducer() {
        var uri = "pcd-pcd01://localhost:" + getPort() + "/devicedata";
        assertThrows(Hl7v2AcceptanceException.class, ()->
            requestBody(uri, PCD_01_SPEC_REQUEST.replace("|2.6|", "|2.5|"))
        );
        assertEquals(0, MyRejectionHandlingStrategy.getCount());
    }

    @Test
    public void testInacceptableRequestOnConsumer() throws Exception {
        var uri = "pcd-pcd01://localhost:" + getPort() + "/devicedata";
        var endpoint = camelContext.getEndpoint(uri);
        Processor processor = endpoint.createProducer();
        processor = ((Interceptor2ProducerAdapter) processor).getProcessor();
        while (processor instanceof Interceptor) {
            processor = ((Interceptor) processor).getWrappedProcessor();
        }
        Exchange exchange = new DefaultExchange(camelContext);
        exchange.getIn().setBody(PCD_01_SPEC_REQUEST.replace("|2.6|", "|2.5|"));
        processor.process(exchange);
        assertEquals(1, MyRejectionHandlingStrategy.getCount());
    }

    @Test
    public void testApplicationError() {
        var uri = "pcd-pcd01://localhost:" + getPort() + "/route_throws_exception";
        var response = requestBody(uri, PCD_01_SPEC_REQUEST);
        assertTrue(response.startsWith("MSH|^~\\&|"));
        assertTrue(response.contains("java.lang.RuntimeException"), "The response message must contain the cause");
        assertTrue(response.contains("MSA|AE|MSGID1234"), "On application error the request message id must be returned.");
        assertEquals(0, MyRejectionHandlingStrategy.getCount());
    }

    @Test
    public void testInboundValidation() {
        var uri = "pcd-pcd01://localhost:" + getPort() + "/route_inbound_validation";
        var response = requestBody(uri, PCD_01_SPEC_REQUEST);
        assertTrue(response.startsWith("MSH|^~\\&|"));
        assertResponseEquals(PCD_01_SPEC_RESPONSE, response);
        assertEquals(0, MyRejectionHandlingStrategy.getCount());
    }

    @Test
    public void testInboundValidationError() {
        var uri = "pcd-pcd01://localhost:" + getPort() + "/route_inbound_validation";
        //this must be a validation error
        var invalidMSG = PCD_01_SPEC_REQUEST.replace("|1.0.1|", "||");
        var response = requestBody(uri, invalidMSG);
        assertTrue(response.startsWith("MSH|^~\\&|"));
        assertTrue(response.contains("MSA|AE"));
        assertTrue(response.contains("Observation Sub-ID"));
        assertEquals(0, MyRejectionHandlingStrategy.getCount());
    }

    @Test
    public void testInboundAndOutboundValidationError() {
        var uri = "pcd-pcd01://localhost:" + getPort() + "/route_inbound_and_outbound_validation";
        //this must be a validation error
        var response = requestBody(uri, PCD_01_SPEC_REQUEST);
        assertTrue(response.startsWith("MSH|^~\\&|"));
        assertResponseEquals(PCD_01_SPEC_RESPONSE, response);
        assertEquals(0, MyRejectionHandlingStrategy.getCount());
    }

    @Test
    public void testDefaultAcceptedResponse() {
        var uri = "pcd-pcd01://localhost:" + getPort()
                + "/route_unacceptable_response";
        var response = requestBody(uri, PCD_01_SPEC_REQUEST);
        assertTrue(response.startsWith("MSH|^~\\&|"));
        assertTrue(response.contains("|ACK^R01^ACK|"));
        assertTrue(response.contains("MSA|AR|MSGID1234"));
        assertTrue(response.contains("ERR|||203^Unsupported version id^HL70357"));
        assertEquals(1, MyRejectionHandlingStrategy.getCount());
    }

    @Test
    public void testJmxAttribute() throws Exception {
        var mbsc = camelContext.getManagementStrategy().getManagementAgent()
                .getMBeanServer();
        Set<ObjectName> s = CastUtils.cast(mbsc.queryNames(new ObjectName(
                "org.apache.camel:*,type=endpoints,name=\"pcd-pcd01://devicedata\\?rejectionHandlingStrategy=%23rejectionHandlingStrategy\""), null));
        assertEquals(1, s.size());
        var object = (ObjectName) s.toArray()[0];
        assertNotNull(object);
        assertTrue((Boolean) mbsc.getAttribute(object, "Addressing"));
    }

    private String requestBody(String uri, String msg) {
        var response = send(uri, msg);
        return ((Exchange) response).getMessage().getBody(String.class);
    }

    private void assertResponseEquals(String expected, String response) {
        //use the same algorithm to parse the String message
        //assertEquals(expected, MessageAdapters.make(response).toString());
        assertEquals(expected, response);
    }

    private static <T extends Message> T load(HapiContext context, String fileName) {
        try {
            return (T) context.getPipeParser().parse(
                    new Scanner(Pcd01RouteBuilder.class.getResourceAsStream("/" + fileName)).useDelimiter("\\A").next());
        } catch (HL7Exception e) {
            return null;
        }
    }

}
