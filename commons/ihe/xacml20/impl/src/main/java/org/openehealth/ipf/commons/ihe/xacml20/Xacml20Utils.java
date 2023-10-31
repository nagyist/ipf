/*
 * Copyright 2018 the original author or authors.
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
package org.openehealth.ipf.commons.ihe.xacml20;

import org.apache.commons.lang3.StringUtils;
import org.herasaf.xacml.core.context.impl.RequestType;
import org.herasaf.xacml.core.policy.Evaluatable;
import org.herasaf.xacml.core.policy.impl.IdReferenceType;
import org.herasaf.xacml.core.simplePDP.initializers.InitializerExecutor;
import org.herasaf.xacml.core.simplePDP.initializers.api.Initializer;
import org.openehealth.ipf.commons.ihe.xacml20.herasaf.Hl7v3DataTypesInitializer;
import org.openehealth.ipf.commons.ihe.xacml20.herasaf.Hl7v3FunctionsInitializer;
import org.openehealth.ipf.commons.ihe.xacml20.herasaf.types.IiDataTypeAttribute;
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.*;
import org.openehealth.ipf.commons.ihe.xacml20.stub.hl7v3.II;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.protocol.ResponseType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.xacml20.saml.assertion.XACMLPolicyStatementType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.xacml20.saml.protocol.XACMLPolicyQueryType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @since 3.5.1
 * @author Dmytro Rud
 */
public class Xacml20Utils {

    public static final String ATTRIBUTE_TYPE_PATIENT_ID = "urn:e-health-suisse:2015:epr-spid";
    public static final String ELEMENT_NAME_PATIENT_ID = "InstanceIdentifier";

    public static final QName QUERY_REQUEST_QNAME = new QName("urn:oasis:names:tc:xacml:2.0:context:schema:os", "Request");
    public static final QName QUERY_POLICY_ID_QNAME = new QName("urn:oasis:names:tc:xacml:2.0:policy:schema:os", "PolicyIdReference");
    public static final QName QUERY_POLICY_SET_ID_QNAME = new QName("urn:oasis:names:tc:xacml:2.0:policy:schema:os", "PolicySetIdReference");

    public static final JAXBContext JAXB_CONTEXT;

    static {
        try {
            JAXB_CONTEXT = JAXBContext.newInstance(
                    org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.ObjectFactory.class,
                    org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.ObjectFactory.class,
                    org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.protocol.ObjectFactory.class,
                    org.herasaf.xacml.core.policy.impl.ObjectFactory.class,
                    org.herasaf.xacml.core.context.impl.ObjectFactory.class,
                    org.openehealth.ipf.commons.ihe.xacml20.stub.xacml20.saml.protocol.ObjectFactory.class,
                    org.openehealth.ipf.commons.ihe.xacml20.stub.xacml20.saml.assertion.ObjectFactory.class,
                    org.openehealth.ipf.commons.ihe.xacml20.stub.hl7v3.ObjectFactory.class,
                    org.apache.xml.security.binding.xmlenc.ObjectFactory.class,
                    org.apache.xml.security.binding.xmldsig.ObjectFactory.class,
                    org.apache.xml.security.binding.xop.ObjectFactory.class);
        } catch (JAXBException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Configures the HERAS-AF framework to use HL7v3 data types and functions
     * and provides the possibility to run user-defined custom initialization routines.
     * <p/>
     * This function is idempotent, it is safe to run it multiple times.
     *
     * @param customInitializers additional optional user-defined custom initializers.
     */
    public static void initializeHerasaf(Initializer... customInitializers) {
        var initializers = new HashSet<>(InitializerExecutor.getDefaultInitializers());
        initializers.add(new Hl7v3DataTypesInitializer());
        initializers.add(new Hl7v3FunctionsInitializer());
        initializers.addAll(Arrays.asList(customInitializers));
        InitializerExecutor.setInitalizers(initializers);
        InitializerExecutor.runInitializers();
    }

    /**
     * Creates a stream of all policies and policy sets contained in the given PPQ response object.
     *
     * @param response PPQ response.
     * @return resulting stream, may be ampty but never <code>null</code>.
     */
    public static Stream<Evaluatable> toStream(ResponseType response) {
        Stream<Evaluatable> result = Stream.of();
        if (response != null) {
            for (var object : response.getAssertionOrEncryptedAssertion()) {
                if (object instanceof AssertionType) {
                    var assertion = (AssertionType) object;
                    for (var statement : assertion.getStatementOrAuthnStatementOrAuthzDecisionStatement()) {
                        if (statement instanceof XACMLPolicyStatementType) {
                            var policyStatement = (XACMLPolicyStatementType) statement;
                            result = Stream.concat(result, policyStatement.getPolicyOrPolicySet().stream().map(x -> (Evaluatable) x));
                        }
                    }
                }
            }
        }
        return result;
    }

    private static Stream<Evaluatable> toStream(AssertionBasedRequestType request) {
        Stream<Evaluatable> result = Stream.of();
        if (request != null) {
            for (var abstractStatement : request.getAssertion().getStatementOrAuthnStatementOrAuthzDecisionStatement()) {
                if (abstractStatement instanceof XACMLPolicyStatementType) {
                    var policyStatement = (XACMLPolicyStatementType) abstractStatement;
                    result = Stream.concat(result, policyStatement.getPolicyOrPolicySet().stream().map(x -> (Evaluatable) x));
                }
            }
        }
        return result;
    }

    /**
     * Creates a stream of all policies and policy sets contained in the given PPQ Add Policy request.
     *
     * @param request PPQ Add Policy request.
     * @return resulting stream, may be empty but never <code>null</code>.
     */
    public static Stream<Evaluatable> toStream(AddPolicyRequest request) {
        return toStream((AssertionBasedRequestType) request);
    }

    /**
     * Creates a stream of all policies and policy sets contained in the given PPQ Update Policy request.
     *
     * @param request PPQ Update Policy request.
     * @return resulting stream, may be empty but never <code>null</code>.
     */
    public static Stream<Evaluatable> toStream(UpdatePolicyRequest request) {
        return toStream((AssertionBasedRequestType) request);
    }

    /**
     * Creates a stream of all policy and policy set IDs contained in the given PPQ Delete Policy request.
     *
     * @param request PPQ Delete Policy request.
     * @return resulting stream, may be empty but never <code>null</code>.
     */
    public static Stream<IdReferenceType> toStream(DeletePolicyRequest request) {
        Stream<IdReferenceType> result = Stream.of();
        if ((request != null) && (request.getAssertion() != null)) {
            for (var abstractStatement : request.getAssertion().getStatementOrAuthnStatementOrAuthzDecisionStatement()) {
                if (abstractStatement instanceof XACMLPolicySetIdReferenceStatementType) {
                    var xacmlStatement = (XACMLPolicySetIdReferenceStatementType) abstractStatement;
                    result = Stream.concat(result, xacmlStatement.getPolicySetIdReference().stream());
                }
            }
        }
        return result;
    }

    public static Optional<String> extractPatientId(XACMLPolicyQueryType request) {
        for (var jaxbElement : request.getRequestOrPolicySetIdReferenceOrPolicyIdReference()) {
            if (QUERY_REQUEST_QNAME.equals(jaxbElement.getName()) && (jaxbElement.getValue() instanceof RequestType)) {
                var requestType = (RequestType) jaxbElement.getValue();
                for (var resourceType : requestType.getResources()) {
                    for (var attributeType : resourceType.getAttributes()) {
                        if (Xacml20Utils.ATTRIBUTE_TYPE_PATIENT_ID.equals(attributeType.getAttributeId()) && (attributeType.getDataType() instanceof IiDataTypeAttribute)) {
                            for (var attributeValueType : attributeType.getAttributeValues()) {
                                for (var valueObject : attributeValueType.getContent()) {
                                    if (valueObject instanceof JAXBElement) {
                                        var jaxbElement1 = (JAXBElement) valueObject;
                                        if (Xacml20Utils.ELEMENT_NAME_PATIENT_ID.equals(jaxbElement1.getName().getLocalPart()) && (jaxbElement1.getValue() instanceof II)) {
                                            var ii = (II) jaxbElement1.getValue();
                                            var root = StringUtils.trimToEmpty(ii.getRoot());
                                            var extension = StringUtils.trimToEmpty(ii.getExtension());
                                            return Optional.of(extension + "^^^&" + root + "&ISO");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return Optional.empty();
    }

    public static Optional<IdReferenceType> extractPolicyId(XACMLPolicyQueryType request) {
        for (var jaxbElement : request.getRequestOrPolicySetIdReferenceOrPolicyIdReference()) {
            if ((QUERY_POLICY_SET_ID_QNAME.equals(jaxbElement.getName()) || QUERY_POLICY_ID_QNAME.equals(jaxbElement.getName()))
                    && (jaxbElement.getValue() instanceof IdReferenceType))
            {
                return Optional.of((IdReferenceType) jaxbElement.getValue());
            }
        }
        return Optional.empty();
    }

}