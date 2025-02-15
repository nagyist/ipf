/*
 * Copyright 2023 the original author or authors.
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
package org.openehealth.ipf.commons.ihe.fhir.iti66;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.param.ReferenceAndListParam;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.openehealth.ipf.commons.ihe.fhir.FhirSearchAndSortParameters;

/**
 * Common SearchParameter base class for ITI-66 transactions
 * @param <T>
 */
public abstract class Iti66SearchParameters<T extends IBaseResource> extends FhirSearchAndSortParameters<T> {

    public abstract Iti66SearchParameters<T> setAuthor(ReferenceAndListParam author);

    public abstract FhirContext getFhirContext();

}
