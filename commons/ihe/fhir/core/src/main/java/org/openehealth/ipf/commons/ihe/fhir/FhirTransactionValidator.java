/*
 * Copyright 2016 the original author or authors.
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

package org.openehealth.ipf.commons.ihe.fhir;

import ca.uhn.fhir.context.FhirContext;

import java.util.Map;
import java.util.function.Function;

/**
 * Instances of {@link FhirTransactionValidator} are used in order to have FHIR request and response validated.
 *
 * @author Christian Ohr
 */
public interface FhirTransactionValidator {

    Function<FhirContext, FhirTransactionValidator> NO_VALIDATION = fhirContext -> new Support();

    /**
     * Validates a FHIR request, throwing an {@link ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException}
     * on validation failure
     *
     * @param payload    request payload
     * @param parameters request parameters
     */
    void validateRequest(Object payload, Map<String, Object> parameters);

    /**
     * Validates a FHIR response, throwing an appropriate subclass of
     * {@link ca.uhn.fhir.rest.server.exceptions.BaseServerResponseException} on
     * validation failure
     *
     * @param payload    response payload
     * @param parameters response parameters
     */
    void validateResponse(Object payload, Map<String, Object> parameters);

    class Support implements FhirTransactionValidator {

        @Override
        public void validateRequest(Object payload, Map<String, Object> parameters) {
        }

        @Override
        public void validateResponse(Object payload, Map<String, Object> parameters) {
        }
    }
}


