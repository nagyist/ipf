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

package org.openehealth.ipf.commons.ihe.xds.core.audit.codes;

import lombok.Getter;
import org.openehealth.ipf.commons.audit.types.EnumeratedCodedValue;
import org.openehealth.ipf.commons.audit.types.EventType;

/**
 * EventTypes for the XDS transactions in this module
 *
 * @author Christian Ohr
 * @since 3.5
 */
public enum XdsEventTypeCode implements EventType, EnumeratedCodedValue<EventType> {

    RegistryStoredQuery("ITI-18", "Registry Stored Query"),
    DistributeDocumentSetOnMedia("ITI-32", "Distribute Document Set on Media"),
    CrossGatewayQuery("ITI-38", "Cross Gateway Query"),
    CrossGatewayRetrieve("ITI-39", "Cross Gateway Retrieve"),
    ProvideAndRegisterDocumentSetB("ITI-41", "Provide and Register Document Set-b"),
    RegisterDocumentSetB("ITI-42", "Register Document Set-b"),
    RetrieveDocumentSet("ITI-43", "Retrieve Document Set"),
    RetrieveValueSet("ITI-48", "Retrieve Value Set"),
    MultiPatientStoredQuery("ITI-51", "Multi-Patient Stored Query"),
    UpdateDocumentSet("ITI-57", "Update Document Set"),
    RegisterOnDemandDocumentEntry("ITI-61", "Register On-Demand Document Entry"),
    RemoveMetadata("ITI-62", "Remove Metadata"),
    CrossCommunityFetch("ITI-63", "XCF Fetch"),
    CrossGatewayDocumentProvide("ITI-80", "CrossGatewayDocumentProvide"),
    RemoveDocuments("ITI-86", "Remove Documents"),
    RestrictedUpdateDocumentSet("ITI-92", "Restricted Update Document Set"),
    QueryPharmacyDocuments("PHARM-1", "Query Pharmacy Documents"),
    RetrieveImagingDocumentSet("RAD-69", "Retrieve Imaging Document Set"),
    CrossGatewayRetrieveImagingDocumentSet("RAD-75", "Cross Gateway Retrieve Imaging Document Set");

    @Getter
    private final EventType value;

    XdsEventTypeCode(String code, String displayName) {
        this.value = EventType.of(code, CODE_SYSTEM_NAME_IHE_TRANSACTIONS, displayName);
    }

}


