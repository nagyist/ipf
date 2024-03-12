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
package org.openehealth.ipf.commons.ihe.xds.core.validate;

import org.apache.commons.lang3.StringUtils;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLObjectContainer;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLRegistryObject;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLSlot;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLSlotList;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static java.util.Collections.emptySet;
import static org.openehealth.ipf.commons.ihe.xds.core.XdsJaxbDataBinding.isExtraMetadataSlotName;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage.DUPLICATE_SLOT_NAME;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage.MISSING_SLOT_NAME;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage.SLOT_VALUE_TOO_LONG;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage.WRONG_QUERY_SLOT_NAME;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidatorAssertions.metaDataAssert;

/**
 * Validates lengths of ebXML slot values and uniqueness of slot names.
 *
 * @author Jens Riemschneider
 * @author Dmytro Rud
 */
public abstract class SlotLengthAndNameUniquenessValidator {

    /**
     * Validates slot lengths and name uniqueness
     * for the given ebXML object container.
     *
     * @param container the container of ebXML objects.
     * @throws XDSMetaDataException if a slot length validation failed.
     */
    public static void validateContainer(EbXMLObjectContainer container) throws XDSMetaDataException {
        validateRegistryObjects(container.getAssociations());
        validateRegistryObjects(container.getExtrinsicObjects());
        validateRegistryObjects(container.getRegistryPackages());
        validateSlotLists(container.getClassifications());
    }

    private static void validateRegistryObjects(List<? extends EbXMLRegistryObject> regObjects) throws XDSMetaDataException {
        validateSlotLists(regObjects);
        for (EbXMLRegistryObject regObj : regObjects) {
            validateSlotLists(regObj.getClassifications());
        }
    }

    private static void validateSlotLists(List<? extends EbXMLSlotList> slotListContainers) throws XDSMetaDataException {
        for (EbXMLSlotList slotList : slotListContainers) {
            doValidateSlots(slotList.getSlots(), false, emptySet());
        }
    }

    public static void validateQuerySlots(
            List<? extends EbXMLSlot> slots,
            Set<String> allowedSlotNamesMultiple) throws XDSMetaDataException {
        doValidateSlots(slots, true, allowedSlotNamesMultiple);
    }

    /**
     * Validates uniqueness of slot names and maximal lengths of slot values in the given collection.
     *
     * @param slots                    ebXML slot collection.
     * @param queryMode                <code>true</code> iff the given slots represent parameters of a stored query.
     * @param allowedSlotNamesMultiple names of slots which are allowed to be present more than once (only for queries).
     * @throws XDSMetaDataException when the validation fails.
     */
    private static void doValidateSlots(
            List<? extends EbXMLSlot> slots,
            boolean queryMode,
            Set<String> allowedSlotNamesMultiple) throws XDSMetaDataException {
        var names = new HashSet<String>();
        for (EbXMLSlot slot : slots) {
            // validate format and uniqueness of slot names
            var name = slot.getName();
            metaDataAssert(StringUtils.isNotEmpty(name), MISSING_SLOT_NAME);

            if (queryMode) {
                metaDataAssert((name.length() > 1) && (name.charAt(0) == '$'), WRONG_QUERY_SLOT_NAME, name);
                metaDataAssert(names.add(name)
                                || allowedSlotNamesMultiple.contains(name)
                                || isExtraMetadataSlotName(name.substring(1)),
                        DUPLICATE_SLOT_NAME, name);
            } else {
                metaDataAssert(names.add(name), DUPLICATE_SLOT_NAME, name);
            }

            // validate lengths of slot values
            slot.getValueList().stream()
                    .filter(Objects::nonNull)
                    .forEach(value -> metaDataAssert(value.length() <= slot.getValueLengthLimit(), SLOT_VALUE_TOO_LONG, name));
        }
    }

}
