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
package org.openehealth.ipf.commons.ihe.xds.core.validate.requests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.SampleData;
import org.openehealth.ipf.commons.ihe.xds.core.XdsRuntimeException;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLAdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssigningAuthority;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;
import org.openehealth.ipf.commons.ihe.xds.core.requests.QueryRegistry;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.*;
import org.openehealth.ipf.commons.ihe.xds.core.responses.ErrorCode;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.query.AdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryRegistryTransformer;
import org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage;
import org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationProfile;
import org.openehealth.ipf.commons.ihe.xds.core.validate.XDSMetaDataException;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.openehealth.ipf.commons.ihe.xds.XCA.Interactions.ITI_38;
import static org.openehealth.ipf.commons.ihe.xds.XDS.Interactions.ITI_18;
import static org.openehealth.ipf.commons.ihe.xds.XDS.Interactions.ITI_51;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage.*;

/**
 * Tests for {@link AdhocQueryRequestValidator}.
 * @author Jens Riemschneider
 * @author Michael Ottati
 * @author Joerg Rueckert
 */
public class AdhocQueryRequestValidatorTest {
    private AdhocQueryRequestValidator validator;
    private QueryRegistry request, requestMpq, folderRequest, folderRequestMpq;
    private QueryRegistryTransformer transformer;

    @BeforeEach
    public void setUp() {
        validator = AdhocQueryRequestValidator.getInstance();
        transformer = new QueryRegistryTransformer();
        request = SampleData.createFindDocumentsQuery();
        requestMpq = SampleData.createFindDocumentsForMultiplePatientsQuery();
        folderRequest = SampleData.createFindFoldersQuery();
        folderRequestMpq = SampleData.createFindFoldersForMultiplePatientsQuery();
    }
    
    @Test
    public void testGoodCase() throws XDSMetaDataException {
        validator.validate(transformer.toEbXML(request), ITI_18);
    }
    
    @Test
    public void testUnknownReturnType() {
        var ebXML = transformer.toEbXML(request);
        ebXML.setReturnType("lol");
        expectFailure(UNKNOWN_RETURN_TYPE, ebXML, ITI_18);
    }

    @Test
    public void testMissingRequiredQueryParameter() {
        ((FindDocumentsQuery)request.getQuery()).setPatientId(null);
        expectFailure(MISSING_REQUIRED_QUERY_PARAMETER, ITI_18);
    }

    @Test
    public void testTooManyQueryParameterValues() {
        var ebXML = transformer.toEbXML(request);
        ebXML.getSlots(QueryParameter.DOC_ENTRY_PATIENT_ID.getSlotName()).get(0).getValueList().add("'lol'");
        expectFailure(TOO_MANY_VALUES_FOR_QUERY_PARAMETER, ebXML, ITI_18);
    }

    @Test
    public void testParameterValueNotString() {
        var ebXML = transformer.toEbXML(request);
        ebXML.getSlots(QueryParameter.DOC_ENTRY_PATIENT_ID.getSlotName()).get(0).getValueList().set(0, "lol");
        expectFailure(PARAMETER_VALUE_NOT_STRING, ebXML, ITI_18);
    }

    @Test
    public void testParameterValueNotStringList() {
        var ebXML = transformer.toEbXML(request);
        ebXML.getSlots(QueryParameter.DOC_ENTRY_CLASS_CODE.getSlotName()).get(0).getValueList().add("lol");
        expectFailure(PARAMETER_VALUE_NOT_STRING_LIST, ebXML, ITI_18);
    }

    @Test
    public void testCodeListNotEnoughSchemes() {
        var ebXML = transformer.toEbXML(request);
        ebXML.getSlots(QueryParameter.DOC_ENTRY_CLASS_CODE.getSlotName()).get(0).getValueList().add("('code^^')");
        expectFailure(INVALID_QUERY_PARAMETER_VALUE, ebXML, ITI_18);
    }

    @Test
    public void testCodeListOldStyleNotEnoughSchemes() {
        var ebXML = transformer.toEbXML(request);
        ebXML.getSlots(QueryParameter.DOC_ENTRY_CLASS_CODE.getSlotName()).get(0).getValueList().set(0, "('code1')");
        ebXML.getSlots(QueryParameter.DOC_ENTRY_CLASS_CODE.getSlotName()).get(0).getValueList().set(1, "('code2')");
        ebXML.addSlot(QueryParameter.DOC_ENTRY_CLASS_CODE_SCHEME.getSlotName(), "('scheme1')");
        expectFailure(INVALID_QUERY_PARAMETER_VALUE, ebXML, ITI_18);
    }

    @Test
    public void testUnknownStatusCodes() {
        var ebXML = transformer.toEbXML(request);
        var valueList = ebXML.getSlots(QueryParameter.DOC_ENTRY_STATUS.getSlotName()).get(0).getValueList();

        // no codes at all -- should fail
        valueList.clear();
        expectFailure(MISSING_REQUIRED_QUERY_PARAMETER, ebXML, ITI_18);

        // only unknown codes -- should fail
        valueList.clear();
        valueList.add("('lol')");
        valueList.add("('foo')");
        expectFailure(INVALID_QUERY_PARAMETER_VALUE, ebXML, ITI_18);

        // at least one code -- should pass
        valueList.set(0, "('bar')");
        valueList.set(1, "('Approved')");
        validator.validate(ebXML, ITI_18);
    }
    
    @Test public void testUnknownFormatCode() {
        var ebXML = transformer.toEbXML(request);
        var valueList = ebXML.getSlots(QueryParameter.DOC_ENTRY_FORMAT_CODE.getSlotName()).get(0).getValueList();

        // invalid code without code -- should fail
        valueList.clear();
        valueList.add("('^^gablorg')");
        expectFailure(INVALID_QUERY_PARAMETER_VALUE, ebXML, ITI_18);

        // invalid code without scheme -- should fail
        valueList.clear();
        valueList.add("('x^')");
        expectFailure(INVALID_QUERY_PARAMETER_VALUE, ebXML, ITI_18);

        // empty code -- should fail
        valueList.clear();
        valueList.add("('')");
        expectFailure(INVALID_QUERY_PARAMETER_VALUE, ebXML, ITI_18);
    }
    
    @Test
    public void testQueryParametersCannotBeSetTogether() {
        request = SampleData.createGetDocumentsQuery();        
        ((GetDocumentsQuery)request.getQuery()).setUniqueIds(Collections.singletonList("1.2.3"));
        var exceptionOccurred = false;
        try {
            validator.validate(transformer.toEbXML(request), ITI_18);
        } catch (XdsRuntimeException e) {
            exceptionOccurred = true;
            assertEquals(ErrorCode.STORED_QUERY_PARAM_NUMBER, e.getErrorCode());
            assertTrue(e.getMessage().contains("[$XDSDocumentEntryEntryUUID, $XDSDocumentEntryUniqueId, $XDSDocumentEntryLogicalID]"));
        }
        assertTrue(exceptionOccurred);
    }

    @Test
    public void testQueryParametersEitherOrChoiceMissing() {
        request = SampleData.createGetDocumentsQuery();
        ((GetDocumentsQuery)request.getQuery()).setUuids(null);
        var exceptionOccurred = false;
        try {
            validator.validate(transformer.toEbXML(request), ITI_18);
        } catch (XDSMetaDataException e) {
            exceptionOccurred = true;
            assertEquals(ValidationMessage.MISSING_REQUIRED_QUERY_PARAMETER, e.getValidationMessage());
            assertTrue(e.getMessage().contains("one of [$XDSDocumentEntryEntryUUID, $XDSDocumentEntryUniqueId, $XDSDocumentEntryLogicalID]"));
        }
        assertTrue(exceptionOccurred);
    }

    /*
        The validation profiles for ITI-18 and ITI-51 are identical except for how they handle
        PatientId data. The ITI-18 queries MUST contain exactly 1 PatientId. The ITI-51 Mutli
        Patient Queries MAY contain a (possibly empty) list of patient IDs. The Following set
        of tests suffixed with "MPQ" test the MPQ PatientId validation code.
    */

    @Test
    public void testGoodCaseMPQ() throws XDSMetaDataException {
        validator.validate(transformer.toEbXML(requestMpq), ITI_51);
    }

    @Test
    public void testMissingPatientIdsMPQ() {
        ((FindDocumentsForMultiplePatientsQuery) requestMpq.getQuery()).setPatientIds(null);
        validator.validate(transformer.toEbXML(requestMpq), ITI_51);
    }

    @Test
    public void testPatientIdMustBeISO_MPQ() {
        var ebXML = transformer.toEbXML(requestMpq);
        ebXML.getSlots(QueryParameter.DOC_ENTRY_PATIENT_ID.getSlotName()).get(0).getValueList().add("('Invalid ISO Patient ID')");
        expectFailure(UNIVERSAL_ID_TYPE_MUST_BE_ISO, ebXML, ITI_51);
    }

    @Test
    public void testAtLeastOneOfPresentMPQ() {
        var query = (FindDocumentsForMultiplePatientsQuery) requestMpq.getQuery();
        query.setPatientIds(null);
        query.setClassCodes(null);
        query.setEventCodes(null);
        query.setHealthcareFacilityTypeCodes(null);
        expectFailure(MISSING_REQUIRED_QUERY_PARAMETER, transformer.toEbXML(requestMpq), ITI_51);
    }

    // Folder and FolderMPQ test cases
    @Test
    public void testGoodCaseFolder() throws XDSMetaDataException {
        validator.validate(transformer.toEbXML(folderRequest), ITI_18);
    }

    @Test
    public void testMissingPatientIdFolder() throws XDSMetaDataException {
        ((FindFoldersQuery)folderRequest.getQuery()).setPatientId(null);
        expectFailure(MISSING_REQUIRED_QUERY_PARAMETER, transformer.toEbXML(folderRequest), ITI_18);
    }

    @Test
    public void testAtLeastOnePresentFolderMPQ() {
        var query = (FindFoldersForMultiplePatientsQuery) folderRequestMpq.getQuery();
        query.setPatientIds(null);
        assertNotNull(query.getCodes());
        validator.validate(transformer.toEbXML(folderRequestMpq), ITI_51);

        query.setCodes(null);
        expectFailure(MISSING_REQUIRED_QUERY_PARAMETER, transformer.toEbXML(folderRequestMpq), ITI_51);
    }

    @Test
    public void testGoodCaseFolderMPQ() throws XDSMetaDataException {
        validator.validate(transformer.toEbXML(folderRequestMpq), ITI_51);
    }

    @Test
    public void testPatientIdMustBeISOFolder_MPQ() {
        var ebXML = transformer.toEbXML(folderRequestMpq);
        ebXML.getSlots(QueryParameter.FOLDER_PATIENT_ID.getSlotName()).get(0).getValueList().add("('Invalid ISO Patient ID')");
        expectFailure(UNIVERSAL_ID_TYPE_MUST_BE_ISO, ebXML, ITI_51);
    }
    
    @Test
    public void testUnknownQueryType() {
        var ebXML = transformer.toEbXML(request);
        ebXML.setId("lol");
        expectFailure(UNKNOWN_QUERY_TYPE, ebXML, ITI_18);
    }

    @Test
    public void testHomeCommunityIdAttributeValidation() {
        request = SampleData.createGetDocumentsQuery();
        // without prefix
        ((GetDocumentsQuery)request.getQuery()).setHomeCommunityId("1.2.3");
        expectFailure(INVALID_OID, ITI_18);
        // wrong suffix
        ((GetDocumentsQuery)request.getQuery()).setHomeCommunityId("urn:oid:foo");
        expectFailure(INVALID_OID, ITI_18);
    }

    @Test
    public void testHomeCommunityIdAttributeValidationIti38() {
        // neither patient ID nor home community ID are present -- shall fail
        request = SampleData.createGetDocumentsQuery();
        ((GetDocumentsQuery)request.getQuery()).setHomeCommunityId(null);
        expectFailure(HOME_COMMUNITY_ID_MUST_BE_SPECIFIED, ITI_38);

        // patient ID is not present, but the home community ID is present -- shall succeed
        request = SampleData.createGetDocumentsQuery();
        ((GetDocumentsQuery)request.getQuery()).setHomeCommunityId("urn:oid:1.2.3");
        validator.validate(transformer.toEbXML(request), ITI_38);

        // patient ID is present, but the home community ID is not -- shall succeed
        request = SampleData.createFindDocumentsQuery();
        ((FindDocumentsQuery)request.getQuery()).setHomeCommunityId(null);
        validator.validate(transformer.toEbXML(request), ITI_38);
    }

    private void expectFailure(ValidationMessage expectedMessage, ValidationProfile profile) {
        expectFailure(expectedMessage, transformer.toEbXML(request), profile);
    }

    @Test
    public void testDuplicateSlotForFindDocumentsQueryValidationWithFailure() {
        var query = new FindDocumentsQuery();
        var ebXML = transformer.toEbXML(new QueryRegistry(query));
        ebXML.addSlot(QueryParameter.DOC_ENTRY_CLASS_CODE.getSlotName(), "('class-code-1^^class-code-scheme-1')");
        ebXML.addSlot(QueryParameter.DOC_ENTRY_CLASS_CODE.getSlotName(), "('class-code-2^^class-code-scheme-2')");
        expectFailure(DUPLICATE_SLOT_NAME, ebXML, ITI_18);
    }

    @Test
    public void testDuplicateSlotForFindDocumentsQueryValidationWithSuccess() {
        var query = new FindDocumentsQuery();
        query.setPatientId(new Identifiable("id3", new AssigningAuthority("1.3")));
        var ebXML = transformer.toEbXML(request);
        ebXML.addSlot(QueryParameter.DOC_ENTRY_EVENT_CODE.getSlotName(), "('event-code-1^^event-code-scheme-1')");
        ebXML.addSlot(QueryParameter.DOC_ENTRY_EVENT_CODE.getSlotName(), "('event-code-2^^event-code-scheme-2')");

        try {
            validator.validate(ebXML, ITI_18);
        }
        catch (XDSMetaDataException e) {
            fail("Test should succeed, but failed with exception: " + XDSMetaDataException.class);
        }
    }

    @Test
    public void testDuplicateSlotForGetDocumentsQueryValidationWithFailure() {
        var query = new GetDocumentsQuery();
        var ebXML = transformer.toEbXML(new QueryRegistry(query));
        ebXML.addSlot(QueryParameter.DOC_ENTRY_UUID.getSlotName(), "('urn:uuid:5678-9012-3456-7890-1234-1')");
        ebXML.addSlot(QueryParameter.DOC_ENTRY_UUID.getSlotName(), "('urn:uuid:6543-2109-8765-4321-0987-2')");
        expectFailure(DUPLICATE_SLOT_NAME, ebXML, ITI_18);
    }

    private void expectFailure(ValidationMessage expectedMessage, EbXMLAdhocQueryRequest<AdhocQueryRequest> request, ValidationProfile profile) {
        try {
            validator.validate(request, profile);
            fail("Expected exception: " + XDSMetaDataException.class);
        }
        catch (XDSMetaDataException e) {
            assertEquals(expectedMessage, e.getValidationMessage());
        }
    }

    @Test
    public void testTargetCommunityIdsConflict() {
        var query = new FindDocumentsQuery();
        query.setPatientId(new Identifiable("id3", new AssigningAuthority("1.3")));
        query.setStatus(List.of(AvailabilityStatus.APPROVED));
        query.setHomeCommunityId("urn:oid:1.2.3");
        query.setTargetCommunityIds(List.of("urn:oid:2.3.4", "urn:oid:3.4.5"));
        var ebXML = transformer.toEbXML(new QueryRegistry(query));
        expectFailure(QUERY_PARAMETERS_CANNOT_BE_SET_TOGETHER, ebXML, ITI_18);
    }

    @Test
    public void testTargetCommunityIdList() {
        var query = new FindDocumentsQuery();
        query.setPatientId(new Identifiable("id3", new AssigningAuthority("1.3")));
        query.setStatus(List.of(AvailabilityStatus.APPROVED));
        query.setTargetCommunityIds(List.of("urn:oid:2.3.4", "urn:oid:3.4.5"));
        var ebXML = transformer.toEbXML(new QueryRegistry(query));
        validator.validate(ebXML, ITI_18);
    }

}
