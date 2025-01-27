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
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindSubmissionSetsQuery;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryType;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.AbstractQueryTransformerTest;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.FindSubmissionSetsQueryTransformer;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for {@link FindSubmissionSetsQueryTransformer}.
 * @author Jens Riemschneider
 */
public class FindSubmissionSetsQueryTransformerTest extends AbstractQueryTransformerTest<FindSubmissionSetsQuery, FindSubmissionSetsQueryTransformer> {

    
    @BeforeEach
    public void setUp() {
        transformer = FindSubmissionSetsQueryTransformer.getInstance();
        query = emptyQuery();
        
        query.setPatientId(new Identifiable("id1", new AssigningAuthority("uni1", "uniType1")));
        query.setContentTypeCodes(Arrays.asList(new Code("code1", null, "system1"), new Code("code2", null, "system2")));
        query.getSubmissionTime().setFrom("20150102030405");
        query.getSubmissionTime().setTo("20150102030406");
        query.setAuthorPerson("per'son1");
        query.setStatus(Arrays.asList(AvailabilityStatus.APPROVED, AvailabilityStatus.DEPRECATED));
        query.setHomeCommunityId("12.21.41");

        ebXML = new EbXMLFactory30().createAdhocQueryRequest();
    }
    
    @Test
    public void testToEbXML() {
        transformer.toEbXML(query, ebXML);
        assertEquals(QueryType.FIND_SUBMISSION_SETS.getId(), ebXML.getId());
        assertEquals("12.21.41", ebXML.getHome());

        assertEquals(Collections.singletonList("'id1^^^&uni1&uniType1'"),
                ebXML.getSlotValues(QueryParameter.SUBMISSION_SET_PATIENT_ID.getSlotName()));
        
        assertEquals(Arrays.asList("('code1^^system1')", "('code2^^system2')"),
                ebXML.getSlotValues(QueryParameter.SUBMISSION_SET_CONTENT_TYPE_CODE.getSlotName()));

        assertEquals(Collections.singletonList("20150102030405"),
                ebXML.getSlotValues(QueryParameter.SUBMISSION_SET_SUBMISSION_TIME_FROM.getSlotName()));
        assertEquals(Collections.singletonList("20150102030406"),
                ebXML.getSlotValues(QueryParameter.SUBMISSION_SET_SUBMISSION_TIME_TO.getSlotName()));

        assertEquals(Collections.singletonList("'per''son1'"),
                ebXML.getSlotValues(QueryParameter.SUBMISSION_SET_AUTHOR_PERSON.getSlotName()));

        assertEquals(Arrays.asList("('urn:oasis:names:tc:ebxml-regrep:StatusType:Approved')", "('urn:oasis:names:tc:ebxml-regrep:StatusType:Deprecated')"),
                ebXML.getSlotValues(QueryParameter.SUBMISSION_SET_STATUS.getSlotName()));
        
        assertEquals(6, ebXML.getSlots().size());
    }

    @Override
    protected FindSubmissionSetsQuery emptyQuery() {
        return new FindSubmissionSetsQuery();
    }
}
