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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author Christian Ohr
 */
public class SchematronValidatorTest {

    private SchematronValidator v;

    @BeforeEach
    public void setUp() {
        v = new SchematronValidator();
    }

    @Test
    public void testValidate() {
        Source testXml = new StreamSource(getClass().getResourceAsStream("/schematron/schematron-test.xml"));
        v.validate(testXml, new SchematronProfile("/schematron/schematron-test-rules.xml"));
    }

    @Test
    public void testValidateFail() {
        Source testXml = new StreamSource(getClass().getResourceAsStream(
                "/schematron/schematron-test-fail.xml"));
        try {
            v.validate(testXml, new SchematronProfile("/schematron/schematron-test-rules.xml"));
            fail("This line shall be not reachable");
        } catch (SchematronValidationException e) {
            var cause = e.getCauses();
            assertEquals(3, cause.length);
            assertEquals(10, e.getSvrl().getActivePatternAndFiredRuleAndFailedAssert().size());
        }
    }

}
