/*
 * Copyright 2009 the original author or authors.
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
package org.openehealth.ipf.commons.ihe.xds.core.transform.ebxml;

import static java.util.Objects.requireNonNull;

import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLAssociation;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLFactory;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLObjectLibrary;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Association;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssociationLabel;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Vocabulary;

/**
 * Transforms an {@link Association} to its ebXML representation.
 * @author Jens Riemschneider
 */
public class AssociationTransformer {
    private final EbXMLFactory factory;
    private final CodeTransformer codeTransformer;

    /**
     * Constructs the transformer
     * @param factory
     *          factory for version independent ebXML objects.
     */
    public AssociationTransformer(EbXMLFactory factory) {
        this.factory = requireNonNull(factory, "factory cannot be null");
        codeTransformer = new CodeTransformer(factory);
    }

    /**
     * Transforms the given association to its ebXML representation.
     * @param association
     *          the association to transform. Can be <code>null</code>.
     * @param objectLibrary
     *          the object library.
     * @return the ebXML representation. <code>null</code> if the input was <code>null</code>.
     */
    public EbXMLAssociation toEbXML(Association association, EbXMLObjectLibrary objectLibrary) {
        requireNonNull(objectLibrary, "objectLibrary cannot be null");
        if (association == null) {
            return null;
        }

        var result = factory.createAssociation(association.getEntryUuid(), objectLibrary);
        result.setAssociationType(association.getAssociationType());
        result.setSource(association.getSourceUuid());
        result.setTarget(association.getTargetUuid());

        var label = AssociationLabel.toOpcode(association.getLabel());
        result.addSlot(Vocabulary.SLOT_NAME_SUBMISSION_SET_STATUS, label);

        var previousVersion = association.getPreviousVersion();
        result.addSlot(Vocabulary.SLOT_NAME_PREVIOUS_VERSION, previousVersion);

        var originalStatus = association.getOriginalStatus();
        result.addSlot(Vocabulary.SLOT_NAME_ORIGINAL_STATUS, AvailabilityStatus.toQueryOpcode(originalStatus));

        var newStatus = association.getNewStatus();
        result.addSlot(Vocabulary.SLOT_NAME_NEW_STATUS, AvailabilityStatus.toQueryOpcode(newStatus));

        result.setAssociationPropagation(association.getAssociationPropagation());

        var contentType = codeTransformer.toEbXML(association.getDocCode(), objectLibrary);
        result.addClassification(contentType, Vocabulary.ASSOCIATION_DOC_CODE_CLASS_SCHEME);

        result.setExtraMetadata(association.getExtraMetadata());
        result.setStatus(association.getAvailabilityStatus());

        return result;
    }

    /**
     * Transforms the given ebXML representation into an {@link Association}.
     * @param association
     *          the ebXML association. Can be <code>null</code>.
     * @return the created {@link Association} instance. <code>null</code> if the input
     *          was <code>null</code>.
     */
    public Association fromEbXML(EbXMLAssociation association) {
        if (association == null) {
            return null;
        }
        var result = new Association();
        result.setAssociationType(association.getAssociationType());
        result.setTargetUuid(association.getTarget());
        result.setSourceUuid(association.getSource());
        result.setEntryUuid(association.getId());

        var label = association.getSingleSlotValue(Vocabulary.SLOT_NAME_SUBMISSION_SET_STATUS);
        result.setLabel(AssociationLabel.fromOpcode(label));

        var previousVersion = association.getSingleSlotValue(Vocabulary.SLOT_NAME_PREVIOUS_VERSION);
        result.setPreviousVersion(previousVersion);

        var originalStatus = association.getSingleSlotValue(Vocabulary.SLOT_NAME_ORIGINAL_STATUS);
        result.setOriginalStatus(AvailabilityStatus.valueOfOpcode(originalStatus));

        var newStatus = association.getSingleSlotValue(Vocabulary.SLOT_NAME_NEW_STATUS);
        result.setNewStatus(AvailabilityStatus.valueOfOpcode(newStatus));

        result.setAssociationPropagation(association.getAssociationPropagation());

        var docCode = association.getSingleClassification(Vocabulary.ASSOCIATION_DOC_CODE_CLASS_SCHEME);
        result.setDocCode(codeTransformer.fromEbXML(docCode));

        result.setExtraMetadata(association.getExtraMetadata());
        result.setAvailabilityStatus(association.getStatus());

        return result;
    }
}
