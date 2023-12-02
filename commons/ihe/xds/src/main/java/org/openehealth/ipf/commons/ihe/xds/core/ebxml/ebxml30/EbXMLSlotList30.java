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
package org.openehealth.ipf.commons.ihe.xds.core.ebxml.ebxml30;

import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLSlot;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLSlotList;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.SlotType1;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * Represents a list of slots.
 * @author Jens Riemschneider
 */
public class EbXMLSlotList30 implements EbXMLSlotList {
    private final List<SlotType1> slotListObj;

    /**
     * Constructs the slot list by wrapping the given ebXML 3.0 object.
     * @param slotListObj
     *          the object to wrap.
     */
    public EbXMLSlotList30(List<SlotType1> slotListObj) {
        this.slotListObj = requireNonNull(slotListObj, "slotListObj cannot be null");
    }

    @Override
    public void addSlot(String slotName, String... slotValues) {
        if (slotValues == null || slotValues.length == 0) {
            return;
        }

        var valueList = EbXMLFactory30.RIM_FACTORY.createValueListType();
        var values = valueList.getValue();
        for (var slotValue : slotValues) {
            if (slotValue != null) {
                values.add(slotValue);
            }
        }

        var slotEbXML = EbXMLFactory30.RIM_FACTORY.createSlotType1();
        slotEbXML.setName(slotName);
        slotEbXML.setValueList(valueList);
        var slot = new EbXMLSlot30(slotEbXML);

        if (!slot.getValueList().isEmpty()) {
            slotListObj.add(slotEbXML);
        }
    }

    @Override
    public List<String> getSlotValues(String slotName) {
        requireNonNull(slotName, "slotName cannot be null");
        for (var slot30 : slotListObj) {
            if (slotName.equals(slot30.getName())) {
                return slot30.getValueList().getValue();
            }
        }

        return Collections.emptyList();
    }

    @Override
    public String getSingleSlotValue(String slotName) {
        var slotValues = getSlotValues(slotName);
        return slotValues.size() > 0 ? slotValues.get(0) : null;
    }

    @Override
    public List<EbXMLSlot> getSlots() {
        return slotListObj.stream()
                .map(EbXMLSlot30::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<EbXMLSlot> getSlots(String slotName) {
        requireNonNull(slotName, "slotName cannot be null");
        return slotListObj.stream()
                .filter(slot30 -> slotName.equals(slot30.getName()))
                .map(EbXMLSlot30::new)
                .collect(Collectors.toList());
    }
}
