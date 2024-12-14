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

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.openehealth.ipf.modules.cda.constants.CDAR2Constants.HITSP_37_SCHEMATRON_RULES;
import static org.openehealth.ipf.modules.cda.constants.CDAR2Constants.IHE_LAB_SCHEMA;

/**
 * Validates the HITSP C37 schematron rule set.
 * 
 * @author Stefan Ivanov
 * 
 */
public class HITSPC37ValidationTest {

	private XsdValidator validator;
	private SchematronValidator schematron;
	private Map<String, Object> params;

	private static final String sample_good = "/HITSP_C37_With_CBC_GTT_GS_Sensitivity.xml";
	private static final String sample_lab = "/IHE_LabReport_20080103.xml";
	private static final String sample_wrong = "/CDA_PHMR_WRONG.xml";

	@BeforeEach
	public void setUp() {
		validator = new XsdValidator();
		schematron = new SchematronValidator();
		params = new HashMap<>();
		params.put("phase", "errors");
	}

	@Test
	public void validateSchemaGoodSample() {
		Source testXml = new StreamSource(getClass().getResourceAsStream(sample_good));
		validator.validate(testXml, IHE_LAB_SCHEMA);
	}

	@Test
	public void validateComplete() {
        Source testXml = new StreamSource(getClass().getResourceAsStream(sample_good));
		schematron.validate(testXml, new SchematronProfile(
				HITSP_37_SCHEMATRON_RULES, params));
	}

	@Test
	public void validateCompleteWrong() {
		try {
            Source testXml = new StreamSource(getClass().getResourceAsStream(sample_wrong));
			schematron.validate(testXml, new SchematronProfile(
					HITSP_37_SCHEMATRON_RULES, params));
			fail();
		} catch (ValidationException ex) {
			assertEquals(148, ex.getCauses().length);
		}
	}

	@Test
	public void validateLab() {
        Source testXml = new StreamSource(getClass().getResourceAsStream(sample_lab));
		schematron.validate(testXml, new SchematronProfile(
				HITSP_37_SCHEMATRON_RULES, params));
	}

}
