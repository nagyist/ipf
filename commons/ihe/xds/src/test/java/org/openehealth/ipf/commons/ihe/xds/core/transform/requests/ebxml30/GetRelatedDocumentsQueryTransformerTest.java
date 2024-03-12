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
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLAdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.ebxml30.EbXMLFactory30;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssociationType;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntryType;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetRelatedDocumentsQuery;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryType;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.query.AdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.AbstractQueryTransformerTest;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.GetDocumentsQueryTransformer;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.GetRelatedDocumentsQueryTransformer;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for {@link GetDocumentsQueryTransformer}.
 * @author Jens Riemschneider
 */
public class GetRelatedDocumentsQueryTransformerTest extends AbstractQueryTransformerTest<GetRelatedDocumentsQuery, GetRelatedDocumentsQueryTransformer> {
    
    @BeforeEach
    public void setUp() {
        transformer = GetRelatedDocumentsQueryTransformer.getInstance();
        query = emptyQuery();

        query.setUuid("uuid1");
        query.setUniqueId("uniqueId1");
        query.setHomeCommunityId("home");
        query.setAssociationTypes(Arrays.asList(AssociationType.HAS_MEMBER, AssociationType.TRANSFORM_AND_REPLACE));
        query.setDocumentEntryTypes(Collections.singletonList(DocumentEntryType.STABLE));

        ebXML = new EbXMLFactory30().createAdhocQueryRequest();
    }
    
    @Test
    public void testToEbXML() {
        transformer.toEbXML(query, ebXML);
        assertEquals(QueryType.GET_RELATED_DOCUMENTS.getId(), ebXML.getId());
        
        assertEquals(Collections.singletonList("'uuid1'"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_UUID.getSlotName()));
        
        assertEquals(Collections.singletonList("'uniqueId1'"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_UNIQUE_ID.getSlotName()));

        assertEquals("home", ebXML.getHome());

        assertEquals(Arrays.asList("('urn:oasis:names:tc:ebxml-regrep:AssociationType:HasMember')", "('urn:ihe:iti:2007:AssociationType:XFRM_RPLC')"),
                ebXML.getSlotValues(QueryParameter.ASSOCIATION_TYPE.getSlotName()));

        assertEquals(Collections.singletonList("('urn:uuid:7edca82f-054d-47f2-a032-9b2a5b5186c1')"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_TYPE.getSlotName()));

        assertEquals(4, ebXML.getSlots().size());
    }

    @Override
    protected GetRelatedDocumentsQuery emptyQuery() {
        return new GetRelatedDocumentsQuery();
    }
}
