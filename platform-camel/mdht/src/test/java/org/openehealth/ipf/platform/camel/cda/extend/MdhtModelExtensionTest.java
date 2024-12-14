/*
 * Copyright 2013 the original author or authors.
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
package org.openehealth.ipf.platform.camel.cda.extend;

import org.apache.camel.EndpointInject;
import org.apache.camel.Message;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.modules.cda.CDAR2Parser;
import org.openehealth.ipf.modules.cda.CDAR2Renderer;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.springframework.test.context.ContextConfiguration;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Christian Ohr
 */
@ContextConfiguration(locations = { "/config/context-extend.xml" })
public class MdhtModelExtensionTest extends AbstractExtensionTest {

    private final String cdaExample = "/message/SampleCDADocument.xml";
    private final String ccdExample = "/message/SampleCCDDocument.xml";

    @EndpointInject(value="mock:error")
    protected MockEndpoint mockError;
    
    
    @Test
    public void testMarshalDefault() throws Exception {
        testMarshalCDA("direct:input1", cdaExample);
        testMarshalCDA("direct:input1", ccdExample);
    }
    
    @Test
    public void testUnmarshalDefault() throws Exception {
        testUnmarshalCDA("direct:input2", cdaExample);
        testUnmarshalCDA("direct:input2", ccdExample);
    }

    @Test
    public void testValidateDefault() throws Exception {
        testValidateCDA("direct:input3", cdaExample);
        testValidateCDA("direct:input3", ccdExample);
    }

    

    private void testMarshalCDA(String endpoint, String file) throws Exception {
        mockOutput.reset();
        mockError.reset();
        var message = inputMessage(file);
        mockOutput.expectedMessageCount(1);
        producerTemplate.sendBody(endpoint, message);
        mockOutput.assertIsSatisfied();
        assertTrue(resultString().contains("<ClinicalDocument"));
    }
    
    private void testUnmarshalCDA(String endpoint, String file) throws Exception {
        mockOutput.reset();
        mockError.reset();
        var stream = inputStream(file);
        mockOutput.expectedMessageCount(1);
        producerTemplate.sendBody(endpoint, stream);
        mockOutput.assertIsSatisfied();
        assertTrue(messageAsString(resultAdapter()).contains("<ClinicalDocument"));
    }
    
    private void testValidateCDA(String endpoint, String file) throws Exception {
        mockOutput.reset();
        mockError.reset();
        var stream = inputStream(file);
        mockOutput.expectedMessageCount(1);
        producerTemplate.sendBody(endpoint, stream);
        mockOutput.assertIsSatisfied();
    }

    private String resultString() {
        return resultMessage().getBody(String.class);
    }

    private ClinicalDocument resultAdapter() {
        return resultMessage().getBody(ClinicalDocument.class);
    }

    private Message resultMessage() {
        return mockOutput.getExchanges().get(0).getIn();
    }   
    
    private static InputStream inputStream(String resource) {
        return MdhtModelExtensionTest.class.getResourceAsStream(resource);
    }

    private ClinicalDocument inputMessage(String resource) {
        return new CDAR2Parser().parse(inputStream(resource), (Object[])null);
    }
    
    private String messageAsString(ClinicalDocument message) {
        return new CDAR2Renderer().render(message, (Object[])null);
    }
    
}
