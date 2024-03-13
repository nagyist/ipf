/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openehealth.ipf.platform.camel.ihe.fhir.iti83;

import ca.uhn.fhir.rest.server.exceptions.InvalidRequestException;
import org.hl7.fhir.dstu3.model.OperationOutcome;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.servlet.ServletException;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 */
public class TestIti83UnknownSource extends AbstractTestIti83 {

    private static final String CONTEXT_DESCRIPTOR = "iti-83-unknown-source.xml";

    @BeforeAll
    public static void setUpClass() throws ServletException {
        startServer(CONTEXT_DESCRIPTOR);
    }

    @Test
    public void testSendManualPixm() {
        assertThrows(InvalidRequestException.class, ()->{
            try {
                sendManuallyOnType(validQueryParameters());
            } catch (InvalidRequestException e) {
                assertAndRethrow(e, OperationOutcome.IssueType.CODEINVALID);
            }
        });
    }


}
