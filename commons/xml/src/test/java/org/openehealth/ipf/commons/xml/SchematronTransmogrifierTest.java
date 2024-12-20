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
package org.openehealth.ipf.commons.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SchematronTransmogrifierTest {

    private SchematronTransmogrifier<String> svi;

    @BeforeEach
    public void setUp() {
        svi = new SchematronTransmogrifier<>(String.class);
    }

    @Test
    public void testConvert() {
        Source testXml = new StreamSource(getClass().getResourceAsStream("/schematron/schematron-test.xml"));
        var result = svi.zap(testXml, "/schematron/schematron-test-rules.xml");
        assertFalse(result.contains("svrl:failed-assert"));
    }

    @Test
    public void testConvertFail() {
        Source testXml = new StreamSource(getClass().getResourceAsStream("/schematron/schematron-test-fail.xml"));
        var result = svi.zap(testXml, "/schematron/schematron-test-rules.xml");
        assertTrue(result.contains("<svrl:failed-assert")); // 3 occurrences
    }
}
