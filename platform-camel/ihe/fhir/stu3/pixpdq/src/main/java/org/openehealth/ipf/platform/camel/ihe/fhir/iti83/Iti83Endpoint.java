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

import org.apache.camel.Category;
import org.apache.camel.spi.UriEndpoint;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;
import org.openehealth.ipf.platform.camel.ihe.fhir.core.FhirEndpoint;
import org.openehealth.ipf.platform.camel.ihe.fhir.core.FhirEndpointConfiguration;

/**
 * PIXM Query endpoint (ITI-83)
 *
 * @author Christian Ohr
 * @since 3.1
 */
@UriEndpoint(scheme = "pixm-iti83", title = "ITI-83 PIXm", syntax = "pixm-iti83:host:port", category = Category.HTTP)
public class Iti83Endpoint extends FhirEndpoint<FhirQueryAuditDataset, Iti83Component> {

    public Iti83Endpoint(String uri, Iti83Component fhirComponent, FhirEndpointConfiguration<FhirQueryAuditDataset> config) {
        super(uri, fhirComponent, config);
    }

    @Override
    protected String createEndpointUri() {
        return "pixm-iti83:" + "not-implemented yet";
    }
}
