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
package org.openehealth.ipf.commons.ihe.xds.core.transform.requests.ebxml30;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.ebxml30.EbXMLFactory30;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssigningAuthority;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Code;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindFoldersQuery;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryList;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryType;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.AbstractQueryTransformerTest;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.FindFoldersQueryTransformer;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for {@link FindFoldersQueryTransformer}.
 * @author Jens Riemschneider
 */
public class FindFoldersQueryTransformerTest extends AbstractQueryTransformerTest<FindFoldersQuery, FindFoldersQueryTransformer> {
    
    @BeforeEach
    public void setUp() {
        transformer = FindFoldersQueryTransformer.getInstance();
        query = emptyQuery();
        
        query.setPatientId(new Identifiable("id1", new AssigningAuthority("uni1", "uniType1")));
        query.getLastUpdateTime().setFrom("20150102030405");
        query.getLastUpdateTime().setTo("20150102030406");
        var codes = new QueryList<Code>();
        codes.getOuterList().add(
                Arrays.asList(new Code("code7", null, "scheme7"), new Code("code8", null, "scheme8")));
        codes.getOuterList().add(
                Collections.singletonList(new Code("code9", null, "scheme9")));
        query.setCodes(codes);
        query.setStatus(Arrays.asList(AvailabilityStatus.APPROVED, AvailabilityStatus.DEPRECATED));
        query.setHomeCommunityId("12.21.41");

        ebXML = new EbXMLFactory30().createAdhocQueryRequest();
    }
    
    @Test
    public void testToEbXML() {
        transformer.toEbXML(query, ebXML);
        assertEquals(QueryType.FIND_FOLDERS.getId(), ebXML.getId());
        assertEquals("12.21.41", ebXML.getHome());

        assertEquals(Collections.singletonList("'id1^^^&uni1&uniType1'"),
                ebXML.getSlotValues(QueryParameter.FOLDER_PATIENT_ID.getSlotName()));
        
        assertEquals(Collections.singletonList("20150102030405"),
                ebXML.getSlotValues(QueryParameter.FOLDER_LAST_UPDATE_TIME_FROM.getSlotName()));
        assertEquals(Collections.singletonList("20150102030406"),
                ebXML.getSlotValues(QueryParameter.FOLDER_LAST_UPDATE_TIME_TO.getSlotName()));

        var slots = ebXML.getSlots(QueryParameter.FOLDER_CODES.getSlotName());
        assertEquals(2, slots.size());
        assertEquals(Arrays.asList("('code7^^scheme7')", "('code8^^scheme8')"), slots.get(0).getValueList());
        assertEquals(Collections.singletonList("('code9^^scheme9')"), slots.get(1).getValueList());
        
        assertEquals(Arrays.asList("('urn:oasis:names:tc:ebxml-regrep:StatusType:Approved')", "('urn:oasis:names:tc:ebxml-regrep:StatusType:Deprecated')"),
                ebXML.getSlotValues(QueryParameter.FOLDER_STATUS.getSlotName()));
        
        assertEquals(6, ebXML.getSlots().size());
    }
    
    @Test
    public void testFromEbXMLLineBreakInAValueList() {
        transformer.toEbXML(query, ebXML);
        ebXML.getSlots().get(5).getValueList().clear();
        ebXML.getSlots().get(5).getValueList().add("('urn:oasis:names:tc:ebxml-regrep:StatusType:Approved',\n'urn:oasis:names:tc:ebxml-regrep:StatusType:Deprecated')");
        var result = new FindFoldersQuery();
        transformer.fromEbXML(result, ebXML);
        
        assertEquals(query, result);
    }

    @Override
    protected FindFoldersQuery emptyQuery() {
        return new FindFoldersQuery();
    }
}
