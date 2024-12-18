/*
 * Copyright 2014 the original author or authors.
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
import org.openehealth.ipf.commons.xml.SchematronProfile;
import org.openehealth.ipf.commons.xml.SchematronValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.util.HashMap;
import java.util.Map;

import static org.openehealth.ipf.modules.cda.constants.CDAR2Constants.CCDA_SCHEMATRON_RULES;

/**
 * @author Boris Stanojevic
 */
public class CCDASchematronValidationTest {

    protected static final Logger log = LoggerFactory.getLogger(CCDASchematronValidationTest.class);

    private SchematronValidator schematron;
    private Map<String, Object> params;

    private static final String[] ccdaFiles = new String[]{"CCD 1", "Consult 1", "DIR.sample", "Discharge Summary 1",
                                                           "HandP 1", "Op Note 1", "Proc Note 1", "Progress Note 1",
                                                           "UD 1", "UD 2"};

    @BeforeEach
    public void setUp() {
        params = new HashMap<>();
        params.put("phase", "errors");
        schematron = new SchematronValidator();
    }

    @Test
    public void validateSchemaGoodSamples() {
        for (var ccdaFile: ccdaFiles){
            var ccdaFilePathFormat = "/ccda/%s.xml";
            var ccdaFilePath = String.format(ccdaFilePathFormat, ccdaFile);
            Source testXml = new StreamSource(getClass().getResourceAsStream(ccdaFilePath));
            log.info("Testing {} ...", ccdaFile);
            schematron.validate(testXml, new SchematronProfile(CCDA_SCHEMATRON_RULES, params));
            log.info("{} - OK", ccdaFile);
        }
    }

}
