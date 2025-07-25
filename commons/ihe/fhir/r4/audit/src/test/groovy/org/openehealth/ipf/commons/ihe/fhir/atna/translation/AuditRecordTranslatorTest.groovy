/*
 * Copyright 2020 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.openehealth.ipf.commons.ihe.fhir.atna.translation

import ca.uhn.fhir.context.FhirContext
import groovy.util.logging.Slf4j
import org.apache.commons.io.IOUtils
import org.easymock.EasyMock
import org.hl7.fhir.common.hapi.validation.validator.FhirInstanceValidator
import org.hl7.fhir.r4.model.AuditEvent
import org.hl7.fhir.r4.model.OperationOutcome
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openehealth.ipf.commons.audit.codes.*
import org.openehealth.ipf.commons.audit.model.*
import org.openehealth.ipf.commons.audit.unmarshal.dicom.DICOMAuditParser
import org.openehealth.ipf.commons.core.config.ContextFacade
import org.openehealth.ipf.commons.core.config.Registry
import org.openehealth.ipf.commons.map.BidiMappingService
import org.openehealth.ipf.commons.map.MappingService

import java.nio.charset.StandardCharsets
import java.time.Instant

/**
 * @author Dmytro Rud
 */
@Slf4j
class AuditRecordTranslatorTest {

    private static final FhirContext FHIR_CONTEXT = FhirContext.forR4()

    static MappingService mappingService

    @BeforeAll
    static void beforeClass() throws Exception {
        mappingService = new BidiMappingService(
                mappingScript: AuditRecordTranslatorTest.class.classLoader.getResource('META-INF/map/atna2fhir.map')
        )
        Registry registry = EasyMock.createMock(Registry)
        ContextFacade.setRegistry(registry)
        EasyMock.expect(registry.bean(MappingService)).andReturn(mappingService).anyTimes()
        EasyMock.replay(registry)
    }

    @Test
    void testAuditRecordTranslation1() throws Exception {
        def auditMessage = createAuditMessage1()
        log.debug('ATNA Record:\n{}\n', auditMessage.toString())

        AuditRecordTranslator translator = new AuditRecordTranslator()
        AuditEvent auditEvent = translator.translate(auditMessage)
        log.debug('FHIR Resource:\n{}\n', FHIR_CONTEXT.newXmlParser().setPrettyPrint(true).encodeResourceToString(auditEvent))

        auditEvent.entity.each { entity ->
            assert entity.what.identifier.type != null
        }
        assert auditEvent.entity[2].query.length == 47
    }

    static AuditMessage createAuditMessage1() {
        new AuditMessage(
                eventIdentification: new EventIdentificationType(
                        EventIdCode.DICOMInstancesTransferred,
                        Instant.ofEpochMilli(System.currentTimeMillis()),
                        EventOutcomeIndicator.Success).with(true)
                        {
                            eventActionCode = EventActionCode.Create
                        },
                activeParticipants: [
                        new ActiveParticipantType('123', false).with(true) {
                            alternativeUserID = 'AETITLE=AEFOO'
                            networkAccessPointID = '192.168.1.2'
                            networkAccessPointTypeCode = NetworkAccessPointTypeCode.IPAddress
                            roleIDCodes << ActiveParticipantRoleIdCode.Source
                        },
                        new ActiveParticipantType('67562', false).with(true) {
                            alternativeUserID = 'AETITLE=AEPACS'
                            networkAccessPointID = '192.168.1.5'
                            networkAccessPointTypeCode = NetworkAccessPointTypeCode.IPAddress
                            roleIDCodes << ActiveParticipantRoleIdCode.Destination
                        },
                        new ActiveParticipantType('smitty@readingroom.hospital.org', true).with(true) {
                            userName = 'Dr. Smith'
                            alternativeUserID = 'smith@nema'
                            networkAccessPointID = '192.168.1.2'
                            networkAccessPointTypeCode = NetworkAccessPointTypeCode.IPAddress
                            roleIDCodes << ActiveParticipantRoleIdCode.Source
                        },
                ],
                auditSourceIdentification: new AuditSourceIdentificationType('ReadingRoom').with(true) {
                    auditEnterpriseSiteID = 'Hospital'
                    auditSourceType << AuditSourceType.EndUserInterface
                },
                participantObjectIdentifications: [
                        new ParticipantObjectIdentificationType('1.2.840.10008.2.3.4.5.6.7.78.8', ParticipantObjectIdTypeCode.StudyInstanceUID).with(true) {
                            participantObjectTypeCode = ParticipantObjectTypeCode.System
                            participantObjectTypeCodeRole = ParticipantObjectTypeCodeRole.Report
                            participantObjectDataLifeCycle = ParticipantObjectDataLifeCycle.Origination
                            participantObjectDescriptions << new DicomObjectDescriptionType().with(true) {
                                getMPPS() << '1.2.840.10008.1.2.3.4.5'
                                accession << '12341234'
                                getSOPClasses() << new DicomObjectDescriptionType.SOPClass(1500).with(true) {
                                    uid = '1.2.840.10008.5.1.4.1.1.2'
                                }
                                getSOPClasses() << new DicomObjectDescriptionType.SOPClass(3).with(true) {
                                    uid = '1.2.840.10008.5.1.4.1.1.11.1'
                                }
                            }
                        },
                        new ParticipantObjectIdentificationType('ptid12345', ParticipantObjectIdTypeCode.PatientNumber).with(true) {
                            participantObjectTypeCode = ParticipantObjectTypeCode.Person
                            participantObjectTypeCodeRole = ParticipantObjectTypeCodeRole.Patient
                            participantObjectName = 'John Doe'
                        },
                        new ParticipantObjectIdentificationType('queryId', ParticipantObjectIdTypeCode.SearchCriteria).with(true) {
                            participantObjectTypeCode = ParticipantObjectTypeCode.Other
                            participantObjectTypeCodeRole = ParticipantObjectTypeCodeRole.Query
                            participantObjectQuery = 'SELECT * FROM documents WHERE type="TOP SECRET"'.bytes
                        },
                ]
        )
    }

    @Test
    void testAuditTranslation2() {
        def parser = FHIR_CONTEXT.newJsonParser().setPrettyPrint(true)

        def atnaString = IOUtils.toString(AuditRecordTranslatorTest.class.classLoader.getResourceAsStream('atna-record-2.xml'), StandardCharsets.UTF_8)
        def atna = new DICOMAuditParser().parse(atnaString, true)
        def fhir = new AuditRecordTranslator().translate(atna)
        log.debug('FHIR resource:\n{}', parser.encodeResourceToString(fhir))

        def validator = FHIR_CONTEXT.newValidator()
        validator.registerValidatorModule(new FhirInstanceValidator(FHIR_CONTEXT))

        def validationResult = validator.validateWithResult(fhir)
        def operationOutcome = new OperationOutcome()
        validationResult.populateOperationOutcome(operationOutcome)
        log.debug('FHIR validation result:\n{}', parser.encodeResourceToString(operationOutcome))

        assert validationResult.successful

        assert fhir.agent.size() == 4

        assert fhir.agent[0].type.coding[0].code == '110153'
        assert fhir.agent[0].who.identifier.value == 'https://community.epr.ch/Repository'
        assert !fhir.agent[0].hasRole()

        assert fhir.agent[1].type.coding[0].code == '110152'
        assert fhir.agent[1].who.identifier.value == '1234'
        assert !fhir.agent[1].hasRole()

        assert !fhir.agent[2].hasType()
        assert fhir.agent[2].who.identifier.value == '7601002860123'
        assert !fhir.agent[2].hasRole()

        assert fhir.agent[3].type.coding[0].code == 'HCP'
        assert fhir.agent[3].who.identifier.value == '7601002860123'
        assert fhir.agent[3].role[0].coding[0].code == '223366009'
    }

}
