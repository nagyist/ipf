/*
 * Copyright 2013 the original author or authors.
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
package org.openehealth.ipf.platform.camel.ihe.xds.iti57

import org.apache.cxf.headers.Header
import org.apache.cxf.jaxb.JAXBDataBinding
import org.apache.cxf.transport.servlet.CXFServlet
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openehealth.ipf.commons.audit.codes.EventActionCode
import org.openehealth.ipf.commons.audit.codes.EventOutcomeIndicator
import org.openehealth.ipf.commons.audit.model.AuditMessage
import org.openehealth.ipf.commons.ihe.xds.core.SampleData
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Association
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssociationType
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentAvailability
import org.openehealth.ipf.commons.ihe.xds.core.metadata.LocalizedString
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Version
import org.openehealth.ipf.commons.ihe.xds.core.responses.Response
import org.openehealth.ipf.platform.camel.ihe.ws.AbstractWsEndpoint
import org.openehealth.ipf.platform.camel.ihe.xds.XdsStandardTestContainer

import javax.xml.namespace.QName

import static org.openehealth.ipf.commons.ihe.xds.core.responses.Status.FAILURE
import static org.openehealth.ipf.commons.ihe.xds.core.responses.Status.SUCCESS

/**
 * Tests the ITI-57 transaction with a webservice and client adapter defined via URIs.
 * @author Boris Stanojevic
 */
class TestIti57 extends XdsStandardTestContainer {
    
    def static CONTEXT_DESCRIPTOR = 'iti-57.xml'
    
    def SERVICE1 = "xds-iti57://localhost:${port}/xds-iti57-service1"
    def SERVICE2 = "xds-iti57://localhost:${port}/xds-iti57-service2"
    def SERVICE3 = "xds-iti57://localhost:${port}/xds-iti57-service3"

    def SERVICE2_ADDR = "http://localhost:${port}/xds-iti57-service2"
    
    def request
    def docEntry
    def folder

    static void main(args) {
        startServer(new CXFServlet(), CONTEXT_DESCRIPTOR, false, DEMO_APP_PORT)
    }
    
    @BeforeAll
    static void classSetUp() {
        startServer(new CXFServlet(), CONTEXT_DESCRIPTOR)
    }
    
    @BeforeEach
    void setUp() {
        request = SampleData.createRegisterDocumentSet()
        docEntry = request.documentEntries[0]
        docEntry.logicalUuid = 'urn:uuid:20744602-ba65-44e9-87ee-a52303a5183e'
        docEntry.version = new Version('123')
        docEntry.documentAvailability = DocumentAvailability.ONLINE
        folder = request.folders[0]
        folder.logicalUuid = 'urn:uuid:9d3c87c2-dfbb-4188-94f0-9b7440737bce'
        folder.version = new Version('124')
    }
    
    @Test
    void testIti57() {
        assert SUCCESS == sendIt(SERVICE1, 'service 1').status
        assert SUCCESS == sendIt(SERVICE2, 'service 2').status
        assert auditSender.messages.size() == 4

        checkAudit(EventOutcomeIndicator.Success)
    }

    @Test
    void testIti57WithNonStandardElgaAssociation() {
        Association association = new Association(AssociationType.NON_VERSIONING_UPDATE,
            "urn:uuid:" + UUID.randomUUID().toString(),
            "urn:uuid:" + UUID.randomUUID().toString(),
            "urn:uuid:" + UUID.randomUUID().toString())
        association.setAvailabilityStatus(AvailabilityStatus.APPROVED)
        request.associations.add(association)
        assert SUCCESS == sendIt(SERVICE1, 'service 1').status
        assert SUCCESS == sendIt(SERVICE2, 'service 2').status
        assert auditSender.messages.size() == 4

        checkAudit(EventOutcomeIndicator.Success)
    }

    @Test
    void testSoapHeaders() {
        Header header1 = new Header(new QName("http://acme.org", "MyHeader1"), "header 1 contents", new JAXBDataBinding(String.class))
        Header header2 = new Header(new QName("http://openehealth.org", "MyHeader2"), "header 2 contents", new JAXBDataBinding(String.class))

        Collection<Header> headerCollection = [header1, header2]
        Map<QName, Header> headerMap = [
                (header1.name) : header1,
                (header2.name) : header2,
        ]

        assert SUCCESS == sendIt(SERVICE3, 'service 3', headerCollection).status
        assert SUCCESS == sendIt(SERVICE3, 'service 3', headerMap).status

        assert FAILURE == sendIt(SERVICE3, 'service 3', header1).status
        assert FAILURE == sendIt(SERVICE3, 'service 3', 'garbage').status
        assert FAILURE == sendIt(SERVICE3, 'service 3', null).status
    }

    @Test
    void testIti57FailureAudit() {
        assert FAILURE == sendIt(SERVICE1, 'falsch').status
        assert auditSender.messages.size() == 2
    }

    void checkAudit(EventOutcomeIndicator outcome) {
        AuditMessage message = getAudit(EventActionCode.Update, SERVICE2_ADDR)[0]

        assert message.activeParticipants.size() == 2
        assert message.participantObjectIdentifications.size() == 2

        checkEvent(message.eventIdentification, '110107', 'ITI-57', EventActionCode.Update, outcome)
        checkSource(message.activeParticipants[0], true)
        checkDestination(message.activeParticipants[1], SERVICE2_ADDR, false)
        checkAuditSource(message.auditSourceIdentification, 'sourceId')
        checkPatient(message.participantObjectIdentifications[0])
        checkSubmissionSet(message.participantObjectIdentifications[1])

        message = getAudit(EventActionCode.Update, SERVICE2_ADDR)[1]

        assert message.activeParticipants.size() == 2
        assert message.participantObjectIdentifications.size() == 2

        checkEvent(message.eventIdentification, '110106', 'ITI-57', EventActionCode.Update, outcome)
        checkSource(message.activeParticipants[0], true)
        checkDestination(message.activeParticipants[1], SERVICE2_ADDR, false)
        checkAuditSource(message.auditSourceIdentification, 'sourceId')
        checkPatient(message.participantObjectIdentifications[0])
        checkSubmissionSet(message.participantObjectIdentifications[1])
    }

    def sendIt(endpoint, value, soapHeaders = null) {
        docEntry.comments = new LocalizedString(value)
        Map camelHeaders = soapHeaders ? [(AbstractWsEndpoint.OUTGOING_SOAP_HEADERS) : soapHeaders] : null
        return send(endpoint, request, Response.class, camelHeaders)
    }

}