/*
 * Copyright 2018 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.openehealth.ipf.commons.ihe.fhir.audit;

import ca.uhn.fhir.context.FhirContext;
import lombok.Getter;
import lombok.Setter;
import org.openehealth.ipf.commons.audit.utils.AuditUtils;
import org.openehealth.ipf.commons.ihe.core.atna.AuditDataset;
import org.openehealth.ipf.commons.ihe.fhir.audit.auth.BalpJwtDataSet;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


/**
 * Generic audit dataset for FHIR-based IHE transactions.
 *
 * @author Christian Ohr
 * @since 3.1
 */
public class FhirAuditDataset extends AuditDataset {

    /**
     * Request payload.
     */
    @Getter @Setter
    private String requestPayload;

    /**
     * Local address
     */
    @Setter
    private String localAddress;

    /**
     * Remote address
     */
    @Setter @Getter
    private String remoteAddress;

    /**
     * Service endpoint URL
     */
    @Getter @Setter
    private String serviceEndpointUrl;

    /**
     * Patient IDs
     */
    @Getter
    private final Set<String> patientIds = new LinkedHashSet<>();

    @Getter
    private final List<HumanUser> humanUsers = new ArrayList<>();

    @Getter @Setter
    private String sourceUserId;

    @Getter @Setter
    private String destinationUserId;

    @Getter @Setter
    private FhirContext fhirContext;

    @Getter @Setter
    private String authorization;

    public FhirAuditDataset(boolean serverSide) {
        super(serverSide);
    }

    /**
     * @return the first present patient ID
     * or <code>null</code> when no patient IDs have been collected.
     */
    public String getPatientId() {
        return patientIds.isEmpty() ? null : patientIds.iterator().next();
    }

    /**
     * @return The machine name or IP address
     */
    @Override
    public String getLocalAddress() {
        return localAddress != null ? localAddress : AuditUtils.getLocalIPAddress();
    }

}
