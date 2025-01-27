/*
 * Copyright 2020 the original author or authors.
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
package org.openehealth.ipf.commons.ihe.xds.core.transform.requests.ebxml30;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.ebxml30.EbXMLFactory30;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssigningAuthority;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Code;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindPrescriptionsForDispenseQuery;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryType;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.AbstractQueryTransformerTest;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.FindPrescriptionsForDispenseQueryTransformer;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for {@link FindPrescriptionsForDispenseQueryTransformer}.
 * @author Quentin Ligier
 * @since 3.7
 */
public class FindPrescriptionsForDispenseQueryTransformerTest extends AbstractQueryTransformerTest<FindPrescriptionsForDispenseQuery, FindPrescriptionsForDispenseQueryTransformer> {

    @BeforeEach
    public void setUp() {
        transformer = FindPrescriptionsForDispenseQueryTransformer.getInstance();

        query = emptyQuery();
        query.setPatientId(new Identifiable("id1", new AssigningAuthority("uni1", "uniType1")));
        query.setHomeCommunityId("12.21.41");
        query.setConfidentialityCodes(Arrays.asList(new Code("code10", null, "scheme10"), new Code("code11", null, "scheme11")));
        query.getCreationTime().setFrom("1980");
        query.getCreationTime().setTo("1981");
        query.getServiceStartTime().setFrom("1982");
        query.getServiceStartTime().setTo("1983");
        query.getServiceStopTime().setFrom("1984");
        query.getServiceStopTime().setTo("1985");
        query.setStatus(Arrays.asList(AvailabilityStatus.APPROVED, AvailabilityStatus.DEPRECATED));
        query.setUuids(Arrays.asList("uuid1", "uuid2"));
        query.setUniqueIds(Arrays.asList("uniqueId1", "uniqueId2"));
        query.setPracticeSettingCodes(Arrays.asList(new Code("code3", null, "scheme3"), new Code("code4", null, "scheme4")));
        query.setHealthcareFacilityTypeCodes(Arrays.asList(new Code("code5", null, "scheme5"), new Code("code6", null, "scheme6")));
        query.setEventCodes(Arrays.asList(new Code("code7", null, "scheme7"), new Code("code8", null, "scheme8")));
        query.setAuthorPersons(Arrays.asList("per'son1", "person2"));

        ebXML = new EbXMLFactory30().createAdhocQueryRequest();
    }

    @Test
    public void testToEbXML() {
        transformer.toEbXML(query, ebXML);

        assertEquals(QueryType.FIND_PRESCRIPTIONS_FOR_DISPENSE.getId(), ebXML.getId());
        assertEquals("12.21.41", ebXML.getHome());
        assertEquals(Collections.singletonList("'id1^^^&uni1&uniType1'"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_PATIENT_ID.getSlotName()));
        assertEquals(Arrays.asList("('code10^^scheme10')", "('code11^^scheme11')"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_CONFIDENTIALITY_CODE.getSlotName()));
        assertEquals(Collections.singletonList("1980"), ebXML.getSlotValues(QueryParameter.DOC_ENTRY_CREATION_TIME_FROM.getSlotName()));
        assertEquals(Collections.singletonList("1981"), ebXML.getSlotValues(QueryParameter.DOC_ENTRY_CREATION_TIME_TO.getSlotName()));
        assertEquals(Collections.singletonList("1982"), ebXML.getSlotValues(QueryParameter.DOC_ENTRY_SERVICE_START_TIME_FROM.getSlotName()));
        assertEquals(Collections.singletonList("1983"), ebXML.getSlotValues(QueryParameter.DOC_ENTRY_SERVICE_START_TIME_TO.getSlotName()));
        assertEquals(Collections.singletonList("1984"), ebXML.getSlotValues(QueryParameter.DOC_ENTRY_SERVICE_STOP_TIME_FROM.getSlotName()));
        assertEquals(Collections.singletonList("1985"), ebXML.getSlotValues(QueryParameter.DOC_ENTRY_SERVICE_STOP_TIME_TO.getSlotName()));
        assertEquals(Arrays.asList("('urn:oasis:names:tc:ebxml-regrep:StatusType:Approved')", "('urn:oasis:names:tc:ebxml-regrep:StatusType:Deprecated')"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_STATUS.getSlotName()));
        assertEquals(Arrays.asList("('uuid1')", "('uuid2')"), ebXML.getSlotValues(QueryParameter.DOC_ENTRY_UUID.getSlotName()));
        assertEquals(Arrays.asList("('uniqueId1')", "('uniqueId2')"), ebXML.getSlotValues(QueryParameter.DOC_ENTRY_UNIQUE_ID.getSlotName()));
        assertEquals(Arrays.asList("('code3^^scheme3')", "('code4^^scheme4')"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_PRACTICE_SETTING_CODE.getSlotName()));
        assertEquals(Arrays.asList("('code5^^scheme5')", "('code6^^scheme6')"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_HEALTHCARE_FACILITY_TYPE_CODE.getSlotName()));
        assertEquals(Arrays.asList("('code7^^scheme7')", "('code8^^scheme8')"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_EVENT_CODE.getSlotName()));
        assertEquals(Arrays.asList("('per''son1')", "('person2')"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_AUTHOR_PERSON.getSlotName()));
    }

    @Override
    protected FindPrescriptionsForDispenseQuery emptyQuery() {
        return new FindPrescriptionsForDispenseQuery();
    }
}
