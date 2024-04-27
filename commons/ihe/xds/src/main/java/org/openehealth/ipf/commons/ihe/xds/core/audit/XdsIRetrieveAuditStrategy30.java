/*
 * Copyright 2012 the original author or authors.
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
package org.openehealth.ipf.commons.ihe.xds.core.audit;

import org.openehealth.ipf.commons.ihe.xds.core.stub.xdsi.RetrieveImagingDocumentSetRequestType;
import org.openehealth.ipf.commons.ihe.xds.core.audit.XdsNonconstructiveDocumentSetRequestAuditDataset.Document;

import java.util.Map;

/**
 * Basis for Strategy pattern implementation for ATNA Auditing
 * in ebXML 3.0-based retrieval-related XDS-I transactions.
 *
 * @author Clay Sebourn
 */
abstract public class XdsIRetrieveAuditStrategy30 extends XdsRetrieveAuditStrategy30 {

    public XdsIRetrieveAuditStrategy30(boolean serverSide) {
        super(serverSide);
    }

    @Override
    public XdsNonconstructiveDocumentSetRequestAuditDataset enrichAuditDatasetFromRequest(XdsNonconstructiveDocumentSetRequestAuditDataset auditDataset, Object pojo, Map<String, Object> parameters) {
        if (pojo instanceof RetrieveImagingDocumentSetRequestType request) {
            var requestedStudies = request.getStudyRequest();
            if (requestedStudies != null) {
                for (var studyRequest : requestedStudies) {
                    var requestedSeries = studyRequest.getSeriesRequest();
                    if (requestedSeries != null) {
                        for (var seriesRequest : requestedSeries) {
                            var requestedDocuments = seriesRequest.getDocumentRequests();
                            if (requestedDocuments != null) {
                                for (var document : requestedDocuments) {
                                    auditDataset.getDocuments().add(new Document(
                                            document.getDocumentUniqueId(),
                                            document.getRepositoryUniqueId(),
                                            document.getHomeCommunityId(),
                                            studyRequest.getStudyInstanceUID(),
                                            seriesRequest.getSeriesInstanceUID(),
                                            getDefaultDocumentStatus()));
                                }
                            }
                        }
                    }
                }
            }
        }
        return auditDataset;
    }

}
