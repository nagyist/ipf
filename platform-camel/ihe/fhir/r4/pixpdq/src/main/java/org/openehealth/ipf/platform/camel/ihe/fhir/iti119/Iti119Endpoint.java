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

package org.openehealth.ipf.platform.camel.ihe.fhir.iti119;

import org.apache.camel.Category;
import org.apache.camel.spi.UriEndpoint;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;
import org.openehealth.ipf.platform.camel.ihe.fhir.core.FhirEndpoint;
import org.openehealth.ipf.platform.camel.ihe.fhir.core.FhirEndpointConfiguration;

/**
 * PDQm Match endpoint (ITI-119)
 *
 * @author Christian Ohr
 * @since 5.0
 */
@UriEndpoint(scheme = "pdqm-iti119", title = "ITI-119 PDQm", syntax = "pdqm-iti119:host:port", category = Category.HTTP)
public class Iti119Endpoint extends FhirEndpoint<FhirQueryAuditDataset, Iti119Component> {

    public Iti119Endpoint(String uri, Iti119Component fhirComponent, FhirEndpointConfiguration<FhirQueryAuditDataset> config) {
        super(uri, fhirComponent, config);
    }

    @Override
    protected String createEndpointUri() {
        return "pdqm-iti119:" + "not-implemented yet";
    }
}
