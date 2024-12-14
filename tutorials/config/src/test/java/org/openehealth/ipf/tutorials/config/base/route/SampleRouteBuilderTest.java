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
package org.openehealth.ipf.tutorials.config.base.route;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.http.base.HttpOperationFailedException;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.charset.Charset;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Boris Stanojevic
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "/base-context.xml",
        "/extender-context.xml",
        "/extension-context.xml",
        "/mock-interceptor-context.xml"})
public class SampleRouteBuilderTest {

    @Autowired
    ProducerTemplate producerTemplate;
    
    @EndpointInject(value = "mock:file")
    MockEndpoint mockFile;
    
    private final String JETTY_URI = "http://localhost:8800";
    
    @BeforeEach
    public void setUp(){
        mockFile.reset();
    }
    
    @Test
    public void testReverse() throws Exception {
        mockFile.expectedMessageCount(1);
        var request = "BLAH";
        var response = producerTemplate.requestBody(JETTY_URI + "/reverse", request, String.class);
        assertEquals("reversed response: HALB", response);
        mockFile.assertIsSatisfied();
        assertEquals(request, mockFile.getExchanges().get(0).getIn().getBody(String.class));
    }

    @Test
    public void testMap() throws Exception {
        mockFile.expectedMessageCount(1);
        var hl7 = IOUtils.toString(
            Objects.requireNonNull(this.getClass().getResourceAsStream("/message.hl7")),
            Charset.defaultCharset());
        var response = producerTemplate.requestBody(JETTY_URI + "/map", hl7, String.class);
        assertTrue(response.contains("Nachname||W|||Blahplatz"));
        mockFile.assertIsSatisfied();
    }
    
    @Test
    public void testMapError() {
        try {
            producerTemplate.requestBody(JETTY_URI + "/map", "BLAH");
            fail();
        } catch (Exception e) {
            assertInstanceOf(HttpOperationFailedException.class, e.getCause());
            var response = ((HttpOperationFailedException)e.getCause()).getResponseBody();
            assertTrue(response.startsWith("Message encoding is not recognized"));
            assertEquals(400, ((HttpOperationFailedException)e.getCause()).getStatusCode());
        }
    }
}
