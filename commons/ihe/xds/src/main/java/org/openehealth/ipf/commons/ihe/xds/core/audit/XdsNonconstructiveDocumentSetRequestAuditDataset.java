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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.openehealth.ipf.commons.audit.codes.EventOutcomeIndicator;


/**
 * Audit dataset specific for non-constructive operations (Read+Delete as opposed to Create+Update in CRUD)
 * on document sets in an XDS Repository.
 *
 * @author Dmytro Rud
 */
public class XdsNonconstructiveDocumentSetRequestAuditDataset extends XdsAuditDataset {
    private static final long serialVersionUID = -8776033207572005899L;

    public enum Status {SUCCESSFUL, NOT_SUCCESSFUL}

    @AllArgsConstructor
    public static class Document implements Serializable {
        private static final long serialVersionUID = -2386699338508892135L;

        @Getter private final String documentUniqueId;
        @Getter private final String repositoryUniqueId;
        @Getter private final String homeCommunityId;
        @Getter private final String studyInstanceUID;
        @Getter private final String seriesInstanceUID;
        @Getter @Setter private Status status;

        public boolean matches(String documentUniqueId, String repositoryUniqueId, String homeCommunityId) {
            return Objects.equals(this.documentUniqueId, documentUniqueId)
                    && Objects.equals(this.repositoryUniqueId, repositoryUniqueId)
                    && Objects.equals(this.homeCommunityId, homeCommunityId);
        }
    }

    @Getter private final List<Document> documents = new ArrayList<>();

    public XdsNonconstructiveDocumentSetRequestAuditDataset(boolean serverSide) {
        super(serverSide);
    }

    public boolean hasDocuments(Status status) {
        return documents.stream().anyMatch(x -> x.status == status);
    }

    public EventOutcomeIndicator getEventOutcomeIndicator(Status status) {
        return (status == Status.SUCCESSFUL)
                ? EventOutcomeIndicator.Success
                : EventOutcomeIndicator.SeriousFailure;
    }

    @Override
    public EventOutcomeIndicator getEventOutcomeIndicator() {
        throw new UnsupportedOperationException("Call getEventOutcomeIndicator(Status status) instead");
    }

    public void registerProcessedDocument(String documentUniqueId, String repositoryUniqueId, String homeCommunityId) {
        documents.stream()
                .filter(x -> x.matches(documentUniqueId, repositoryUniqueId, homeCommunityId))
                .forEach(x -> x.setStatus(Status.SUCCESSFUL));
    }

    private String[] extract(Status status, Function<Document, String> fieldExtractor) {
        return documents.stream()
                .filter(x -> x.status == status)
                .map(fieldExtractor)
                .toArray(String[]::new);
    }

    public String[] getDocumentIds      (Status status) { return extract(status, x -> x.documentUniqueId); }
    public String[] getRepositoryIds    (Status status) { return extract(status, x -> x.repositoryUniqueId); }
    public String[] getHomeCommunityIds (Status status) { return extract(status, x -> x.homeCommunityId); }
    public String[] getStudyInstanceIds (Status status) { return extract(status, x -> x.studyInstanceUID); }
    public String[] getSeriesInstanceIds(Status status) { return extract(status, x -> x.seriesInstanceUID); }

}
