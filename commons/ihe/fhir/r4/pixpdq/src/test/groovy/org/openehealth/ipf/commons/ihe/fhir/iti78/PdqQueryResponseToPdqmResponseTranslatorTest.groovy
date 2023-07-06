/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openehealth.ipf.commons.ihe.fhir.iti78

import ca.uhn.hl7v2.HapiContext
import org.apache.commons.io.IOUtils
import org.easymock.EasyMock
import org.hl7.fhir.r4.model.ContactPoint
import org.hl7.fhir.r4.model.Enumerations
import org.hl7.fhir.r4.model.HumanName
import org.hl7.fhir.r4.model.codesystems.AdministrativeGender
import org.hl7.fhir.r4.model.codesystems.GenderIdentity
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openehealth.ipf.commons.core.config.ContextFacade
import org.openehealth.ipf.commons.core.config.Registry
import org.openehealth.ipf.commons.ihe.fhir.translation.DefaultUriMapper
import org.openehealth.ipf.commons.ihe.fhir.translation.UriMapper
import org.openehealth.ipf.commons.ihe.hl7v2.definitions.CustomModelClassUtils
import org.openehealth.ipf.commons.ihe.hl7v2.definitions.HapiContextFactory
import org.openehealth.ipf.commons.ihe.hl7v2.definitions.pdq.v25.message.RSP_K21
import org.openehealth.ipf.commons.map.BidiMappingService
import org.openehealth.ipf.commons.map.MappingService
import org.openehealth.ipf.gazelle.validation.profile.pixpdq.PixPdqTransactions

import java.nio.charset.StandardCharsets

import static org.junit.jupiter.api.Assertions.assertEquals
/**
 *
 */
class PdqQueryResponseToPdqmResponseTranslatorTest {

    private static final HapiContext PDQ_QUERY_CONTEXT = HapiContextFactory.createHapiContext(
            CustomModelClassUtils.createFactory("pdq", "2.5"),
            PixPdqTransactions.ITI21)

    private PdqResponseToPdqmResponseTranslator translator
    MappingService mappingService

    @BeforeEach
    void setup() {
        mappingService = new BidiMappingService()
        mappingService.setMappingScripts(
                [ getClass().getClassLoader().getResource('mapping.map'),
                  getClass().getResource('/META-INF/map/fhir-hl7v2-translation.map') ] as URL[])
        UriMapper mapper = new DefaultUriMapper(mappingService, 'uriToOid', 'uriToNamespace')
        translator = new PdqResponseToPdqmResponseTranslator(mapper)
        translator.setPdqSupplierResourceIdentifierUri('urn:oid:1.2.3.4')
        translator.setNationalIdentifierUri('urn:oid:1.3.4.5.6')

        Registry registry = EasyMock.createMock(Registry)
        ContextFacade.setRegistry(registry)
        EasyMock.expect(registry.bean(MappingService)).andReturn(mappingService).anyTimes()
        EasyMock.replay(registry)
    }

    @Test
    void testTranslateRegularSearchResponse() {
        RSP_K21 message = loadMessage('ok-1_Response')
        List<PdqPatient> patients = translator.translateToFhir(message, new HashMap<String, Object>())
        assertEquals(9, patients.size())
    }

    @Test
    void testTranslateRegularGetResponse() {
        RSP_K21 message = loadMessage('ok-2_Response')
        List<PdqPatient> patients = translator.translateToFhir(message, new HashMap<String, Object>())
        assertEquals(1, patients.size())

        PdqPatient patient = ++patients.iterator()

        assertEquals('http://org.openehealth/ipf/commons/ihe/fhir/1', patient.identifier[0].system)
        assertEquals('79007', patient.identifierFirstRep.value)

        patient.nameFirstRep.with {
            assertEquals('Beckenbauer', it.family)
            assertEquals('Michael', it.given[0].value)
            assertEquals('Joachim', it.given[1].value)
            assertEquals(HumanName.NameUse.OFFICIAL, it.use)
        }
        patient.addressFirstRep.with {
            assertEquals('Muenchner Freiheit 1', it.line[0].value)
            assertEquals('Muenchen', it.city)
            assertEquals('89000', it.postalCode)
            assertEquals('DE', it.country)
        }

        assertEquals(ContactPoint.ContactPointUse.MOBILE, patient.telecomFirstRep.use)
        assertEquals(ContactPoint.ContactPointSystem.PHONE, patient.telecomFirstRep.system)
        assertEquals(Enumerations.AdministrativeGender.MALE, patient.gender)
        assertEquals(GenderIdentity.MALE.toCode(), patient.genderIdentity.codingFirstRep.code)
        assertEquals('http://hl7.org/fhir/StructureDefinition/patient-genderIdentity', patient.genderIdentity.codingFirstRep.system)
        assertEquals('01511134556', patient.telecomFirstRep.value)
        assertEquals('Paukenbecker', patient.mothersMaidenName.family)
        assertEquals('Passau', patient.birthPlace.city)
        assertEquals('deu',patient.citizenshipFirstRep.code.codingFirstRep.code)
        assertEquals('1041', patient.religionFirstRep.codingFirstRep.code)
        assertEquals('M', patient.maritalStatus.codingFirstRep.code)
        assertEquals(2, patient.multipleBirthIntegerType.value)
    }

    RSP_K21 loadMessage(String name) {
        String resourceName = "pdqquery/v2/${name}.hl7"
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourceName)
        String content = IOUtils.toString(inputStream, StandardCharsets.UTF_8)
        return (RSP_K21)PDQ_QUERY_CONTEXT.getPipeParser().parse(content)
    }
}
