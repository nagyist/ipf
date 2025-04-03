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
package org.openehealth.ipf.commons.ihe.hl7v3;

import org.apache.cxf.helpers.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.core.modules.api.ValidationException;
import org.openehealth.ipf.commons.xml.CombinedXmlValidator;

public class HL7v3ValidatorTest {

	@Test
	public void testValidateOk() throws Exception {
		var message = IOUtils.readStringFromStream(
                getClass().getResourceAsStream("/xsd/prpa-valid.xml"));
		var validator = new CombinedXmlValidator();
        validator.validate(message, PIXV3.Interactions.ITI_44_PIX.getRequestValidationProfile());
	}
	
	@Test
	public void testValidateError() throws Exception {
		var message = IOUtils.readStringFromStream(
                getClass().getResourceAsStream("/xsd/prpa-invalid.xml"));
		var validator = new CombinedXmlValidator();
		Assertions.assertThrows(ValidationException.class, () -> validator.validate(message, PIXV3.Interactions.ITI_44_PIX.getRequestValidationProfile()));
	}

	/**
	 * With namespace prefix, correct value.
	 */
	@Test
	public void testQnameComparisonNsGood() throws Exception {
		var message = IOUtils.readStringFromStream(
				getClass().getResourceAsStream("/validation/type-ns-good.xml"));
		var validator = new CombinedXmlValidator();
		validator.validate(message, XCPD.Interactions.ITI_55.getResponseValidationProfile());
	}

	/**
	 * Without namespace prefix, correct value.
	 */
	@Test
	public void testQnameComparisonNoNsGood() throws Exception {
		var message = IOUtils.readStringFromStream(
				getClass().getResourceAsStream("/validation/type-nons-good.xml"));
		var validator = new CombinedXmlValidator();
		validator.validate(message, XCPD.Interactions.ITI_55.getResponseValidationProfile());
	}

	/**
	 * With namespace prefix, wrong value.
	 */
	@Test
	public void testQnameComparisonNsWrong() throws Exception {
		var message = IOUtils.readStringFromStream(
				getClass().getResourceAsStream("/validation/type-ns-wrong.xml"));
		var validator = new CombinedXmlValidator();
		Assertions.assertThrows(ValidationException.class, () -> validator.validate(message, XCPD.Interactions.ITI_55.getResponseValidationProfile()));
	}

	/**
	 * Without namespace prefix, wrong value.
	 */
	@Test
	public void testQnameComparisonNoNsWrong() throws Exception {
		var message = IOUtils.readStringFromStream(
				getClass().getResourceAsStream("/validation/type-nons-wrong.xml"));
		var validator = new CombinedXmlValidator();
		Assertions.assertThrows(ValidationException.class, () -> validator.validate(message, XCPD.Interactions.ITI_55.getResponseValidationProfile()));
	}

    /**
     * Multiple patients in an ITI-44 request.
     */
    @Test
    public void testMultiplePatientsIn44Request() throws Exception {
        var message = IOUtils.readStringFromStream(
            getClass().getResourceAsStream("/validation/iti44-multipatient-request-1.xml"));
        var validator = new CombinedXmlValidator();
        Assertions.assertThrows(ValidationException.class, () -> validator.validate(
            message,
            PIXV3.Interactions.ITI_44_PIX.getRequestValidationProfile()));
        Assertions.assertThrows(ValidationException.class, () -> validator.validate(
            message.replaceAll("IN201301UV02", "IN201302UV02"),
            PIXV3.Interactions.ITI_44_PIX.getRequestValidationProfile()));
    }

}
