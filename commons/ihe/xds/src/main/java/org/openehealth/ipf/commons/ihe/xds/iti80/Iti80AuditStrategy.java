/*
 * Copyright 2017 the original author or authors.
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
package org.openehealth.ipf.commons.ihe.xds.iti80;

import org.openehealth.ipf.commons.ihe.xds.core.audit.XdsSubmitAuditDataset;
import org.openehealth.ipf.commons.ihe.xds.core.audit.XdsSubmitAuditStrategy30;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLSubmitObjectsRequest;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.ebxml30.EbXMLSubmitObjectsRequest30;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.ebxml30.ProvideAndRegisterDocumentSetRequestType;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.lcm.SubmitObjectsRequest;

import java.util.Map;

/**
 * Audit strategy for ITI-80.
 * @author Remco Overdevest
 * @since 3.3
 */
abstract class Iti80AuditStrategy extends XdsSubmitAuditStrategy30 {

    /**
     * Constructs the audit strategy.
     * @param serverSide
     *      whether this is a server-side or a client-side strategy.
     */
    public Iti80AuditStrategy(boolean serverSide) {
        super(serverSide);
    }

    @Override
    public XdsSubmitAuditDataset enrichAuditDatasetFromRequest(XdsSubmitAuditDataset auditDataset, Object pojo, Map<String, Object> parameters) {
        var request = (ProvideAndRegisterDocumentSetRequestType)pojo;
        var submitObjectsRequest = request.getSubmitObjectsRequest();
        if (submitObjectsRequest != null) {
            EbXMLSubmitObjectsRequest<SubmitObjectsRequest> ebXML = new EbXMLSubmitObjectsRequest30(submitObjectsRequest);
            enrichDatasetFromSubmitObjectsRequest(auditDataset, ebXML);
        }
        return auditDataset;
    }

}
