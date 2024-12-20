/*
 * Copyright 2008 the original author or authors.
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
package org.openehealth.ipf.platform.camel.core.extend;

import org.apache.camel.ExchangePattern;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Martin Krasser
 */
@ContextConfiguration(locations = { "/context-core-extend-dataformat.xml" })
public class DataFormatExtensionTest extends AbstractExtensionTest {

    @Test
    public void testUnmarshalObject() {
        var result = (String) producerTemplate.sendBody("direct:external1",
                ExchangePattern.InOut, "message");
        assertEquals("stream: message", result);
    }

    @Test
    public void testMarshalObject() {
        var result = (String) producerTemplate.sendBody("direct:internal1",
                ExchangePattern.InOut, "message");
        assertEquals("message", result);
    }

    @Test
    public void testUnmarshalBean() {
        var result = (String) producerTemplate.sendBody("direct:external2",
                ExchangePattern.InOut, "message");
        assertEquals("stream: message", result);
    }

    @Test
    public void testMarshalBean() {
        var result = (String) producerTemplate.sendBody("direct:internal2",
                ExchangePattern.InOut, "message");
        assertEquals("message", result);
    }

}
