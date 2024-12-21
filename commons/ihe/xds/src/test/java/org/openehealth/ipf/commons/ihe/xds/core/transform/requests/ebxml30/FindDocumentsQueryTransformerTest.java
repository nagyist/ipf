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
import org.openehealth.ipf.commons.ihe.xds.core.SampleData;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLAdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.ebxml30.EbXMLFactory30;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindDocumentsForMultiplePatientsQuery;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindDocumentsQuery;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryType;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.query.AdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.FindDocumentsForMultiplePatientsQueryTransformer;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.FindDocumentsQueryTransformer;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for {@link FindDocumentsQueryTransformer} and {@link FindDocumentsForMultiplePatientsQueryTransformer}
 * @author Jens Riemschneider
 * @author Michael Ottati
 */
public class FindDocumentsQueryTransformerTest {
    private FindDocumentsQueryTransformer transformer;
    private FindDocumentsForMultiplePatientsQueryTransformer multiplePatientsQueryTransformer;
    private FindDocumentsForMultiplePatientsQuery multiplePatientsQuery;
    private FindDocumentsQuery query;
    private EbXMLAdhocQueryRequest<AdhocQueryRequest> ebXML;
    
    @BeforeEach
    public void setUp() {
        transformer = FindDocumentsQueryTransformer.getInstance();
        query = (FindDocumentsQuery)SampleData.createFindDocumentsQuery().getQuery();
        multiplePatientsQueryTransformer = FindDocumentsForMultiplePatientsQueryTransformer.getInstance();
        multiplePatientsQuery = (FindDocumentsForMultiplePatientsQuery)SampleData.createFindDocumentsForMultiplePatientsQuery().getQuery();

        ebXML = new EbXMLFactory30().createAdhocQueryRequest();
    }

    @Test
    public void testToEbXML() {
        transformer.toEbXML(query, ebXML);
        assertEquals(QueryType.FIND_DOCUMENTS.getId(), ebXML.getId());
        assertEquals("urn:oid:1.21.41", ebXML.getHome());
        assertEquals(Collections.singletonList("'id3^^^&1.3&ISO'"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_PATIENT_ID.getSlotName()));
        checkEbXML(ebXML, 21);
    }

    @Test
    public void testToEbXML_MPQ() {
        multiplePatientsQueryTransformer.toEbXML(multiplePatientsQuery, ebXML);
        assertEquals(QueryType.FIND_DOCUMENTS_MPQ.getId(), ebXML.getId());
        assertEquals(Arrays.asList("('id3^^^&1.3&ISO')", "('id4^^^&1.4&ISO')"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_PATIENT_ID.getSlotName()));
        checkEbXML(ebXML, 19);
    }

    private static void checkEbXML(EbXMLAdhocQueryRequest<?> ebXML, int expectedSlots) {
        assertEquals("urn:oid:1.21.41", ebXML.getHome());

        assertEquals(Arrays.asList("('code1^^scheme1')", "('code2^^scheme2')"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_CLASS_CODE.getSlotName()));

        assertEquals(Arrays.asList("('codet1^^schemet1')", "('codet2^^schemet2')"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_TYPE_CODE.getSlotName()));

        assertEquals(Arrays.asList("('code3^^scheme3')", "('code4^^scheme4')"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_PRACTICE_SETTING_CODE.getSlotName()));
        
        assertEquals(Collections.singletonList("1980"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_CREATION_TIME_FROM.getSlotName()));
        assertEquals(Collections.singletonList("1981"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_CREATION_TIME_TO.getSlotName()));

        assertEquals(Collections.singletonList("1982"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_SERVICE_START_TIME_FROM.getSlotName()));
        assertEquals(Collections.singletonList("1983"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_SERVICE_START_TIME_TO.getSlotName()));

        assertEquals(Collections.singletonList("1984"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_SERVICE_STOP_TIME_FROM.getSlotName()));
        assertEquals(Collections.singletonList("1985"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_SERVICE_STOP_TIME_TO.getSlotName()));
        
        assertEquals(Arrays.asList("('code5^^scheme5')", "('code6^^scheme6')"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_HEALTHCARE_FACILITY_TYPE_CODE.getSlotName()));

        var slots = ebXML.getSlots(QueryParameter.DOC_ENTRY_EVENT_CODE.getSlotName());
        assertEquals(2, slots.size());
        assertEquals(Arrays.asList("('code7^^scheme7')", "('code8^^scheme8')"), slots.get(0).getValueList());
        assertEquals(Collections.singletonList("('code9^^scheme9')"), slots.get(1).getValueList());
        
        slots = ebXML.getSlots(QueryParameter.DOC_ENTRY_CONFIDENTIALITY_CODE.getSlotName());
        assertEquals(2, slots.size());
        assertEquals(Arrays.asList("('code10^^scheme10')", "('code11^^scheme11')"), slots.get(0).getValueList());
        assertEquals(Collections.singletonList("('code12^^scheme12')"), slots.get(1).getValueList());
        
        assertEquals(Arrays.asList("('per''son1')", "('person2')"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_AUTHOR_PERSON.getSlotName()));

        assertEquals(Arrays.asList("('code13^^scheme13')", "('code14^^scheme14')"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_FORMAT_CODE.getSlotName()));
        
        assertEquals(Arrays.asList("('urn:oasis:names:tc:ebxml-regrep:StatusType:Approved')", "('urn:oasis:names:tc:ebxml-regrep:StatusType:Submitted')"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_STATUS.getSlotName()));

        assertEquals(Collections.singletonList("('urn:uuid:7edca82f-054d-47f2-a032-9b2a5b5186c1')"),
                ebXML.getSlotValues(QueryParameter.DOC_ENTRY_TYPE.getSlotName()));

        assertEquals(expectedSlots, ebXML.getSlots().size());
    }
    
    @Test
    public void testToEbXMLNull() {
        transformer.toEbXML(null, ebXML);
        assertEquals(0, ebXML.getSlots().size());
    }

    @Test
    public void testToEbXMLNull_MPQ() {
        multiplePatientsQueryTransformer.toEbXML(null,ebXML);
        assertEquals(0, ebXML.getSlots().size());
    }
    
    @Test
    public void testToEbXMLEmpty() {
        transformer.toEbXML(new FindDocumentsQuery(), ebXML);
        assertEquals(0, ebXML.getSlots().size());
    }
    @Test
    public void testToEbXMLEmpty_MPQ() {
        multiplePatientsQueryTransformer.toEbXML(new FindDocumentsForMultiplePatientsQuery(),ebXML);
        assertEquals(0, ebXML.getSlots().size());
    }

    @Test
    public void testFromEbXML() {
        transformer.toEbXML(query, ebXML);
        var result = new FindDocumentsQuery();
        transformer.fromEbXML(result, ebXML);
        assertEquals(query, result);
    }

    @Test
    public void testFromEbXML_MPQ() {
        multiplePatientsQueryTransformer.toEbXML(multiplePatientsQuery,ebXML);
        var mpResult = new FindDocumentsForMultiplePatientsQuery();
        multiplePatientsQueryTransformer.fromEbXML(mpResult,ebXML);
        assertEquals(multiplePatientsQuery,mpResult);
    }
    
    @Test
    public void testFromEbXMLNull() {
        var result = new FindDocumentsQuery();
        transformer.fromEbXML(result, null);        
        assertEquals(new FindDocumentsQuery(), result);
    }

    @Test
    public void testFromEbXMLNull_MPQ() {
        var result = new FindDocumentsForMultiplePatientsQuery();
        multiplePatientsQueryTransformer.fromEbXML(result, null);
        assertEquals(new FindDocumentsForMultiplePatientsQuery(), result);
    }
        
    @Test
    public void testFromEbXMLEmpty() {
        var result = new FindDocumentsQuery();
        transformer.fromEbXML(result, ebXML);        
        assertEquals(new FindDocumentsQuery(), result);
    }

    @Test
    public void testFromEbXMLEmpty_MPQ() {
        var result = new FindDocumentsForMultiplePatientsQuery();
        multiplePatientsQueryTransformer.fromEbXML(result, ebXML);
        assertEquals(new FindDocumentsForMultiplePatientsQuery(), result);
    }
}
