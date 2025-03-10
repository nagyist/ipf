/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.openehealth.ipf.commons.ihe.xacml20.chppq

import groovy.transform.CompileStatic
import org.herasaf.xacml.core.context.impl.*
import org.herasaf.xacml.core.policy.impl.IdReferenceType
import org.herasaf.xacml.core.policy.impl.PolicySetType
import org.openehealth.ipf.commons.ihe.xacml20.Xacml20MessageCreator
import org.openehealth.ipf.commons.ihe.xacml20.Xacml20Status
import org.openehealth.ipf.commons.ihe.xacml20.herasaf.types.IiDataTypeAttribute
import org.openehealth.ipf.commons.ihe.xacml20.model.EprConstants.AttributeIds
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.AddPolicyRequest
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.DeletePolicyRequest
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.UpdatePolicyRequest
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.XACMLPolicySetIdReferenceStatementType
import org.openehealth.ipf.commons.ihe.xacml20.stub.hl7v3.II
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.protocol.ResponseType
import org.openehealth.ipf.commons.ihe.xacml20.stub.xacml20.saml.assertion.XACMLPolicyStatementType
import org.openehealth.ipf.commons.ihe.xacml20.stub.xacml20.saml.protocol.XACMLPolicyQueryType

@CompileStatic
class ChPpqMessageCreator extends Xacml20MessageCreator {

    ChPpqMessageCreator(String homeCommunityId) {
        super(homeCommunityId)
    }

    private AssertionType createSubmitAssertion(Collection<PolicySetType> policySets) {
        def assertion = createAssertion()
        assertion.statementOrAuthnStatementOrAuthzDecisionStatement << new XACMLPolicyStatementType(
                policyOrPolicySet: policySets as List<Object>,
        )
        return assertion
    }

    private AssertionType createDeleteAssertion(Collection<String> policySetIds) {
        def assertion = createAssertion()
        assertion.statementOrAuthnStatementOrAuthzDecisionStatement << new XACMLPolicySetIdReferenceStatementType(
                policySetIdReference: policySetIds.collect { new IdReferenceType(value: it) }
        )
        return assertion
    }

    AddPolicyRequest createAddPolicyRequest(Collection<PolicySetType> policySets) {
        return new AddPolicyRequest(assertion: createSubmitAssertion(policySets))
    }

    UpdatePolicyRequest createUpdatePolicyRequest(Collection<PolicySetType> policySets) {
        return new UpdatePolicyRequest(assertion: createSubmitAssertion(policySets))
    }

    DeletePolicyRequest createDeletePolicyRequest(Collection<String> policySetIds) {
        return new DeletePolicyRequest(assertion: createDeleteAssertion(policySetIds))
    }

    private static XACMLPolicyQueryType createPolicyQueryElement() {
        return new XACMLPolicyQueryType(
                ID: '_' + UUID.randomUUID(),
                issueInstant: XML_OBJECT_FACTORY.newXMLGregorianCalendar(new GregorianCalendar()),
                version: '2.0',
        )
    }

    XACMLPolicyQueryType createPolicyQuery(II patientId) {
        def query = createPolicyQueryElement()
        query.requestOrPolicySetIdReferenceOrPolicyIdReference << XACML_CONTEXT_OBJECT_FACTORY.createRequest(
                new RequestType(
                        subjects: [
                                new SubjectType(),
                        ],
                        resources: [
                                new ResourceType(
                                        attributes: [
                                                new AttributeType(
                                                        attributeId: AttributeIds.EHEALTH_SUISSSE_2015_EPR_SPID,
                                                        dataType: new IiDataTypeAttribute(),
                                                        attributeValues: [
                                                                new AttributeValueType(
                                                                        content: [
                                                                                HL7V3_OBJECT_FACTORY.createInstanceIdentifier(patientId),
                                                                        ] as List<Object>,
                                                                ),
                                                        ],
                                                ),
                                        ],
                                ),
                        ],
                        action: new ActionType(),
                        environment: new EnvironmentType(),
                )
        )
        return query
    }

    XACMLPolicyQueryType createPolicyQuery(List<String> policySetIds) {
        def query = createPolicyQueryElement()
        for (policySetId in policySetIds) {
            def reference = XACML_POLICY_OBJECT_FACTORY.createPolicySetIdReference(new IdReferenceType(value: policySetId))
            query.requestOrPolicySetIdReferenceOrPolicyIdReference << reference
        }
        return query
    }

  ResponseType createPositivePolicyQueryResponse(List<PolicySetType> policySets, String requestId) {
        def assertion = createAssertion()
        assertion.statementOrAuthnStatementOrAuthzDecisionStatement << new XACMLPolicyStatementType(
                policyOrPolicySet: policySets as List<Object>,
        )
        return createResponse(Xacml20Status.SUCCESS, null, assertion, requestId)
    }

}
