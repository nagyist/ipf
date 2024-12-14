/*
 * Copyright 2012 the original author or authors.
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
package org.openehealth.ipf.modules.cda.support;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.core.modules.api.ValidationException;
import org.openehealth.ipf.commons.xml.SchematronProfile;
import org.openehealth.ipf.commons.xml.SchematronValidator;
import org.openehealth.ipf.commons.xml.XsdValidator;
import org.openehealth.ipf.modules.cda.constants.CDAR2Constants;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Validates the LabCDA 2.0 schematron rule set.
 * 
 * @author Stefan Ivanov
 * 
 */
public class LabCDA20ValidationTest {

    private XsdValidator validator;
    private SchematronValidator schematron;
    private Map<String, Object> params;

    private static final String sample = "/IHE_LabReport_20070816.xml";
    private static final String sample_errored = "/IHE_LabReport_20070816_Errored.xml";

    @BeforeEach
    public void setUp() {
        validator = new XsdValidator();
        schematron = new SchematronValidator();
        params = new HashMap<>();
        params.put("phase", "errors");
    }

    @Test
    public void testSchemaValidate() {
        Source testXml = new StreamSource(getClass().getResourceAsStream(sample));
        validator.validate(testXml, CDAR2Constants.IHE_LAB_SCHEMA);
    }

    @Test
    public void testValidateErrors() {
        Source testXml = new StreamSource(getClass().getResourceAsStream(sample));
        schematron.validate(testXml, new SchematronProfile(CDAR2Constants.IHE_LAB_20_SCHEMATRON_RULES, params));
    }

    @Test
    public void validateBodyPositive() {
        Source testXml = new StreamSource(getClass().getResourceAsStream(sample));
        validator.validate(testXml, CDAR2Constants.IHE_LAB_SCHEMA);
        testXml = new StreamSource(getClass().getResourceAsStream(sample));
        schematron.validate(testXml, new SchematronProfile(
                "/schematron/ihe_lab_v20_20070816/templates/1.3.6.1.4.1.19376.1.3.1.sch", params));
    }

    @Test
    public void validateBodyErrors() {
        Source testXml = new StreamSource(getClass().getResourceAsStream(sample_errored));
        try {
            schematron.validate(testXml, new SchematronProfile(
                    "/schematron/ihe_lab_v20_20070816/templates/1.3.6.1.4.1.19376.1.3.1.sch", params));
            fail();
        } catch (ValidationException ex) {
            assertEquals(9, ex.getCauses().length);
        }
    }

    @Test
    public void validateHeaderPositive() {
        Source testXml = new StreamSource(getClass().getResourceAsStream(sample));
        validator.validate(testXml, CDAR2Constants.IHE_LAB_SCHEMA);
        testXml = new StreamSource(getClass().getResourceAsStream(sample));
        schematron.validate(testXml, new SchematronProfile(
                "/schematron/ihe_lab_v20_20070816/templates/1.3.6.1.4.1.19376.1.3.3.sch", params));
    }

}
