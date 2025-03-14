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
package org.openehealth.ipf.commons.ihe.xds.core.validate.responses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.SampleData;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLFactory;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLQueryResponse;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.ebxml30.EbXMLFactory30;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.*;
import org.openehealth.ipf.commons.ihe.xds.core.responses.QueryResponse;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.query.AdhocQueryResponse;
import org.openehealth.ipf.commons.ihe.xds.core.transform.responses.QueryResponseTransformer;
import org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage;
import org.openehealth.ipf.commons.ihe.xds.core.validate.XDSMetaDataException;

import static org.junit.jupiter.api.Assertions.*;
import static org.openehealth.ipf.commons.ihe.xds.XDS.Interactions.ITI_18;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage.*;

/**
 * Test for {@link QueryResponseValidator}.
 * @author Jens Riemschneider
 */
public class QueryResponseValidatorTest {
    private QueryResponseValidator validator;
    private QueryResponse response;
    private QueryResponseTransformer transformer;
    private DocumentEntry docEntry;

    @BeforeEach
    public void setUp() {
        validator = QueryResponseValidator.getInstance();
        EbXMLFactory factory = new EbXMLFactory30();
        
        response = SampleData.createQueryResponseWithLeafClass();
        transformer = new QueryResponseTransformer(factory);

        docEntry = response.getDocumentEntries().get(0);
    }
    
    @Test
    public void testValidateGoodCase() {
        validator.validate(transformer.toEbXML(response), ITI_18);
    }

    @Test
    public void testQueryResponseDoesNotHaveSubmissionSetLimitations() {
        response.getSubmissionSets().clear();
        validator.validate(transformer.toEbXML(response), ITI_18);
    }
    
    @Test
    public void testQueryResponseMultiplePatientIdsDueToDocEntry() {
        var otherId = new Identifiable("idbla", new AssigningAuthority("1.6"));
        var docEntryOtherPatientId = SampleData.createDocumentEntry(otherId);
        response.getDocumentEntries().add(docEntryOtherPatientId);
        expectFailure(RESULT_NOT_SINGLE_PATIENT);
    }

    @Test
    public void testQueryResponseMultiplePatientIdsDueToFolder() {
        var otherId = new Identifiable("idbla", new AssigningAuthority("1.6"));
        var folderOtherPatientId = SampleData.createFolder(otherId);
        response.getFolders().add(folderOtherPatientId);
        expectFailure(RESULT_NOT_SINGLE_PATIENT);
    }

    @Test
    public void testQueryResponseMultiplePatientIdsDueToSubmissionSet() {
        var otherId = new Identifiable("idbla", new AssigningAuthority("1.6"));
        var submissionSetOtherPatientId = SampleData.createSubmissionSet(otherId);
        response.getSubmissionSets().add(submissionSetOtherPatientId);
        expectFailure(RESULT_NOT_SINGLE_PATIENT);
    }

    @Test
    public void testValidateDelegatesToSubmitObjectsRequestValidator() {
        // Try a failure that is produced by the SubmitObjectsRequestValidator
        docEntry.getAuthors().get(0).getAuthorInstitution().add(new Organization(null, "LOL", null));
        expectFailure(ORGANIZATION_NAME_MISSING);            
    }
    
    @Test
    public void testValidateDelegatesToRegistryResponseValidator() {
        // Try a failure that is produced by the RegistryResponseValidator
        response.setStatus(null);
        expectFailure(INVALID_STATUS_IN_RESPONSE);
    }
    
    @Test
    public void testMissingObjRef() {
        response.getReferences().add(new ObjectReference());        
        expectFailure(MISSING_OBJ_REF);
    }

    @Test
    public void testValidateDocumentEntryHasInvalidAvailabilityStatus() {
        docEntry.setAvailabilityStatus(null);
        expectFailure(DOC_ENTRY_INVALID_AVAILABILITY_STATUS);
    }

    /**
     * Test the case when a Query returned an On-Demand Document Entry.
     */
    @Test
    public void testOnDemandDocumentEntryValidation() {
        assertNotNull(docEntry.getSize());
        assertNotNull(docEntry.getHash());
        docEntry.setType(DocumentEntryType.ON_DEMAND);
        expectFailure(WRONG_NUMBER_OF_SLOT_VALUES);

        docEntry.setSize(null);
        docEntry.setHash(null);
        expectFailure(WRONG_NUMBER_OF_SLOT_VALUES);

        docEntry.setCreationTime((Timestamp) null);
        docEntry.setLegalAuthenticator(null);
        validator.validate(transformer.toEbXML(response), ITI_18);
    }

    private void expectFailure(ValidationMessage expectedMessage) {
        expectFailure(expectedMessage, transformer.toEbXML(response));
    }

    private void expectFailure(ValidationMessage expectedMessage, EbXMLQueryResponse<AdhocQueryResponse> ebXMLQueryResponse) {
        try {
            validator.validate(ebXMLQueryResponse, ITI_18);
            fail("Expected exception: " + XDSMetaDataException.class);
        }
        catch (XDSMetaDataException e) {
            assertEquals(expectedMessage, e.getValidationMessage());
        }
    }
}
