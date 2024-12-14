/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openehealth.ipf.platform.camel.hl7;

import org.apache.camel.EndpointInject;
import org.apache.camel.Message;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.platform.camel.hl7.extend.AbstractExtensionTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 */
@ContextConfiguration(locations = { "/config/context-sample2.xml" })
public class SampleRouteBuilder2Test extends AbstractExtensionTest {

    private static final String MSH_EXPECTED_1 = "MSH|^~\\&|SAP-ISH|HZL|blah||20040805152637||ADT^A01|123456|T|2.2|||ER";
    private static final String MSH_EXPECTED_2 = "MSH|^~\\&|SAP-ISH|HZL|blub||20040805152637||ADT^A01|123456|T|2.2|||ER";
    
    @EndpointInject(value="mock:output1")
    private MockEndpoint mockOutput1;
    
    @EndpointInject(value="mock:output2")
    private MockEndpoint mockOutput2;
    
    private final String resource = "message/msg-01.hl7";
    
    @AfterEach
    public void myTearDown() {
        mockOutput1.reset();
        mockOutput2.reset();
    }

    @Test
    public void testRoute1() throws Exception {
        var message = inputMessage(resource);
        mockOutput1.expectedMessageCount(1);
        producerTemplate.sendBodyAndHeader("direct:input1", message, "foo", "blah");
        mockOutput1.assertIsSatisfied();
        assertTrue(resultString(mockOutput1).contains(MSH_EXPECTED_1));
    }

    @Test
    public void testRoute2() throws Exception {
        var message = inputMessage(resource);
        mockOutput2.expectedMessageCount(1);
        producerTemplate.sendBodyAndHeader("direct:input1", message, "foo", "blub");
        mockOutput2.assertIsSatisfied();
        assertTrue(resultString(mockOutput2).contains(MSH_EXPECTED_2));
    }

    private static String resultString(MockEndpoint mock) {
        return resultMessage(mock).getBody(String.class);
    }

    private static Message resultMessage(MockEndpoint mock) {
        return mock.getExchanges().get(0).getIn();
    }

    private static String inputMessage(String resource) {
        return new Scanner(SampleRouteBuilder2Test.class.getResourceAsStream("/" + resource)).useDelimiter("\\A").next();
    }
    
}
