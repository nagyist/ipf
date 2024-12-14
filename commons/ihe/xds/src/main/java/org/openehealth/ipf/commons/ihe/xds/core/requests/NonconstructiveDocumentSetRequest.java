/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openehealth.ipf.commons.ihe.xds.core.requests;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;

import jakarta.xml.bind.annotation.XmlElementRef;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Base class for non-constructive operations (Read+Delete as opposed to Create+Update in CRUD)
 * on document sets in an XDS Repository.
 * <p>
 * Lists are pre-created and can therefore never be <code>null</code>.
 * @since 3.3
 */
@EqualsAndHashCode(doNotUseGetters = true)
@ToString(doNotUseGetters = true)
abstract public class NonconstructiveDocumentSetRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 4812212416179958948L;

    @XmlElementRef
    @Getter private final List<DocumentReference> documents = new ArrayList<>();

    /**
     * Adds the document, represented by the given document entry, to the list of referenced documents.
     * @param documentEntry document entry.
     */
    public void addReferenceTo(DocumentEntry documentEntry) {
        documents.add(new DocumentReference(
                documentEntry.getRepositoryUniqueId(),
                documentEntry.getUniqueId(),
                documentEntry.getHomeCommunityId()));
    }
}
