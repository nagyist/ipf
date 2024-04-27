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

import static org.openehealth.ipf.commons.ihe.xds.core.metadata.Vocabulary.*;
import static org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp.toHL7;

import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLFactory;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLObjectLibrary;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLRegistryPackage;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Folder;

/**
 * Transforms between a {@link Folder} and its ebXML 2.1 representation.
 * @author Jens Riemschneider
 */
public class FolderTransformer extends XDSMetaClassTransformer<EbXMLRegistryPackage, Folder> {
    private final CodeTransformer codeTransformer;

    /**
     * Constructs the transformer
     * @param factory
     *          factory for version independent ebXML objects.
     */
    public FolderTransformer(EbXMLFactory factory) {
        super(FOLDER_PATIENT_ID_EXTERNAL_ID,
                FOLDER_LOCALIZED_STRING_PATIENT_ID,
                FOLDER_UNIQUE_ID_EXTERNAL_ID,
                FOLDER_LOCALIZED_STRING_UNIQUE_ID,
                FOLDER_LIMITED_METADATA_CLASS_NODE,
                factory);

        codeTransformer = new CodeTransformer(factory);
    }

    @Override
    protected EbXMLRegistryPackage createEbXMLInstance(String id, EbXMLObjectLibrary objectLibrary) {
        return factory.createRegistryPackage(id, objectLibrary);
    }

    @Override
    protected Folder createMetaClassInstance() {
        return new Folder();
    }

    @Override
    protected void addAttributes(Folder metaData, EbXMLRegistryPackage ebXML, EbXMLObjectLibrary objectLibrary) {
        super.addAttributes(metaData, ebXML, objectLibrary);
        ebXML.setStatus(metaData.getAvailabilityStatus());
        ebXML.setHome(metaData.getHomeCommunityId());
    }

    @Override
    protected void addAttributesFromEbXML(Folder metaData, EbXMLRegistryPackage ebXML) {
        super.addAttributesFromEbXML(metaData, ebXML);
        metaData.setAvailabilityStatus(ebXML.getStatus());
        metaData.setHomeCommunityId(ebXML.getHome());
    }

    @Override
    protected void addSlotsFromEbXML(Folder folder, EbXMLRegistryPackage regPackage) {
        super.addSlotsFromEbXML(folder, regPackage);

        folder.setLastUpdateTime(regPackage.getSingleSlotValue(SLOT_NAME_LAST_UPDATE_TIME));
    }

    @Override
    protected void addSlots(Folder folder, EbXMLRegistryPackage regPackage, EbXMLObjectLibrary objectLibrary) {
        super.addSlots(folder, regPackage, objectLibrary);

        regPackage.addSlot(SLOT_NAME_LAST_UPDATE_TIME, toHL7(folder.getLastUpdateTime()));
    }

    @Override
    protected void addClassificationsFromEbXML(Folder folder, EbXMLRegistryPackage regPackage) {
        super.addClassificationsFromEbXML(folder, regPackage);

        var codes = folder.getCodeList();
        codes.addAll(regPackage.getClassifications(FOLDER_CODE_LIST_CLASS_SCHEME).stream()
                .map(codeTransformer::fromEbXML)
                .toList());
    }

    @Override
    protected void addClassifications(Folder folder, EbXMLRegistryPackage regPackage, EbXMLObjectLibrary objectLibrary) {
        super.addClassifications(folder, regPackage, objectLibrary);

        folder.getCodeList().stream()
                .map(codeListElem -> codeTransformer.toEbXML(codeListElem, objectLibrary))
                .forEach(code -> regPackage.addClassification(code, FOLDER_CODE_LIST_CLASS_SCHEME));
    }
}
