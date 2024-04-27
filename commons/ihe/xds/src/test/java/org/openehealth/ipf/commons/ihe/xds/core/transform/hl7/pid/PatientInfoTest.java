/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openehealth.ipf.commons.ihe.xds.core.transform.hl7.pid;

import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.XDS;
import org.openehealth.ipf.commons.ihe.xds.core.SampleData;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.ebxml30.EbXMLFactory30;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.*;
import org.openehealth.ipf.commons.ihe.xds.core.requests.RegisterDocumentSet;
import org.openehealth.ipf.commons.ihe.xds.core.transform.hl7.PatientInfoTransformer;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.RegisterDocumentSetTransformer;
import org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage;
import org.openehealth.ipf.commons.ihe.xds.core.validate.XDSMetaDataException;
import org.openehealth.ipf.commons.ihe.xds.core.validate.requests.SubmitObjectsRequestValidator;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dmytro Rud
 */
public class PatientInfoTest {

    private static final SubmitObjectsRequestValidator SUBMIT_OBJECTS_REQUEST_VALIDATOR = SubmitObjectsRequestValidator.getInstance();
    private static final RegisterDocumentSetTransformer REGISTER_DOCUMENT_SET_TRANSFORMER = new RegisterDocumentSetTransformer(new EbXMLFactory30());
    private static final PatientInfoTransformer PATIENT_INFO_TRANSFORMER = new PatientInfoTransformer();

    private static void assertValidationFailure(RegisterDocumentSet request, ValidationMessage expectedValidationMessage) {
        var failed = false;
        try {
            SUBMIT_OBJECTS_REQUEST_VALIDATOR.validate(REGISTER_DOCUMENT_SET_TRANSFORMER.toEbXML(request), XDS.Interactions.ITI_42);
        } catch (XDSMetaDataException e) {
            assertEquals(expectedValidationMessage, e.getValidationMessage());
            failed = true;
        }
        assertTrue(failed);
    }

    private static List<String> getRenderedStrings(List<String> strings, String fieldName, int expectedCount) {
        var result = strings.stream()
                .filter(s -> s.startsWith(fieldName + '|'))
                .toList();
        assertEquals(expectedCount, result.size(), "Expected " + expectedCount + " lines for " + fieldName);
        return result;
    }

    private static List<String> getRenderedStrings(PatientInfo patientInfo, String fieldName, int expectedCount) {
        return getRenderedStrings(PATIENT_INFO_TRANSFORMER.toHL7(patientInfo), fieldName, expectedCount);
    }

    @Test
    public void testNonPidFields() {
        var request = SampleData.createRegisterDocumentSet();
        var patientInfo = request.getDocumentEntries().get(0).getSourcePatientInfo();
        patientInfo.getHl7FieldIterator("OBX-5").add("abc");
        assertValidationFailure(request, ValidationMessage.INVALID_PID);
    }

    @Test
    public void testRawNamesHandling() {
        var request = SampleData.createRegisterDocumentSet();
        var patientInfo = request.getDocumentEntries().get(0).getSourcePatientInfo();
        var rawIterator = patientInfo.getHl7FieldIterator("PID-5");
        assertTrue(rawIterator.hasNext());

        // clear the list
        while (rawIterator.hasNext()) {
            rawIterator.next();
            rawIterator.remove();
        }
        assertFalse(rawIterator.hasNext());

        // fill the list with some values
        rawIterator.add("Krause^Peter^^^^Dr.^^^^^^");
        rawIterator.add(null);
        rawIterator.add("Schmitt^Jens^Klaus Heinz^^Ritter^^^^^^");
        rawIterator.add("");
        rawIterator.add("^^^^^");

        // check using other iterator type
        var xdsIterator = patientInfo.getNames();
        assertEquals(new XcnName("Krause", "Peter", null, null, null, "Dr."), xdsIterator.next());
        assertNull(xdsIterator.next());
        assertEquals(new XpnName("Schmitt", "Jens", "Klaus Heinz", null, "Ritter", null), xdsIterator.next());
        assertNull(xdsIterator.next());
        assertNull(xdsIterator.next());
        assertFalse(xdsIterator.hasNext());

        // check rendering
        var renderedStrings = getRenderedStrings(patientInfo, "PID-5", 1);
        assertEquals("PID-5|Krause^Peter^^^^Dr.^^^^^^~~Schmitt^Jens^Klaus Heinz^^Ritter^^^^^^~~^^^^^", renderedStrings.get(0));
    }

    @Test
    public void testXdsNamesHandling() {
        var request = SampleData.createRegisterDocumentSet();
        var patientInfo = request.getDocumentEntries().get(0).getSourcePatientInfo();
        var xdsIterator = patientInfo.getNames();
        assertTrue(xdsIterator.hasNext());

        // clear the list
        while (xdsIterator.hasNext()) {
            xdsIterator.next();
            xdsIterator.remove();
        }
        assertFalse(xdsIterator.hasNext());

        // fill the list with some values
        xdsIterator.add(new XcnName("Krause", "Peter", null, null, null, "Dr."));
        xdsIterator.add(null);
        xdsIterator.add(new XpnName("Schmitt", "Jens", "Klaus Heinz", null, "Ritter", null));
        xdsIterator.add(null);

        // check using other iterator type
        var rawIterator = patientInfo.getHl7FieldIterator("PID-5");
        assertEquals("Krause^Peter^^^^Dr.", rawIterator.next());
        assertEquals("", rawIterator.next());
        assertEquals("Schmitt^Jens^Klaus Heinz^^Ritter", rawIterator.next());
        assertEquals("", rawIterator.next());
        assertFalse(rawIterator.hasNext());
    }

    @Test
    public void testRawBirthDateHandling() {
        var request = SampleData.createRegisterDocumentSet();
        var patientInfo = request.getDocumentEntries().get(0).getSourcePatientInfo();
        var rawIterator = patientInfo.getHl7FieldIterator("PID-7");
        assertTrue(rawIterator.hasNext());

        // clear the list
        while (rawIterator.hasNext()) {
            rawIterator.next();
            rawIterator.remove();
        }
        assertFalse(rawIterator.hasNext());

        // fill the list with some values
        rawIterator.add("");
        rawIterator.add(null);
        rawIterator.add("20010203040506");

        // check
        assertNull(patientInfo.getDateOfBirth());
        var renderedStrings = getRenderedStrings(patientInfo, "PID-7", 1);
        assertEquals("PID-7|~~20010203040506", renderedStrings.get(0));

        // delete the first value and check again
        rawIterator = patientInfo.getHl7FieldIterator("PID-7");
        rawIterator.next();
        rawIterator.remove();
        assertNull(patientInfo.getDateOfBirth());
        renderedStrings = getRenderedStrings(patientInfo, "PID-7", 1);
        assertEquals("PID-7|~20010203040506", renderedStrings.get(0));

        // delete the first value and check again
        rawIterator = patientInfo.getHl7FieldIterator("PID-7");
        rawIterator.next();
        rawIterator.remove();
        assertEquals(new Timestamp(ZonedDateTime.of(2001, 2, 3, 4, 5, 6,0, ZoneId.of("UTC")), Timestamp.Precision.SECOND), patientInfo.getDateOfBirth());
        renderedStrings = getRenderedStrings(patientInfo, "PID-7", 1);
        assertEquals("PID-7|20010203040506", renderedStrings.get(0));
    }

    @Test
    public void testXdsBirthDateHandling() {
        var request = SampleData.createRegisterDocumentSet();
        var patientInfo = request.getDocumentEntries().get(0).getSourcePatientInfo();
        var rawIterator = patientInfo.getHl7FieldIterator("PID-7");
        assertTrue(rawIterator.hasNext());

        // clear the list
        while (rawIterator.hasNext()) {
            rawIterator.next();
            rawIterator.remove();
        }
        assertFalse(rawIterator.hasNext());

        // fill the list with some values
        rawIterator.add("");
        rawIterator.add(null);
        rawIterator.add("20010203040506");

        // overwrite the value using metadata mechanisms 1
        patientInfo.setDateOfBirth("20010203");
        rawIterator = patientInfo.getHl7FieldIterator("PID-7");
        assertEquals("20010203", rawIterator.next());
        assertFalse(rawIterator.hasNext());
        var renderedStrings = getRenderedStrings(patientInfo, "PID-7", 1);
        assertEquals("PID-7|20010203", renderedStrings.get(0));
        assertEquals(new Timestamp(ZonedDateTime.of(2001, 2, 3, 4, 5, 6,0, ZoneId.of("UTC")), Timestamp.Precision.DAY), patientInfo.getDateOfBirth());

        // overwrite the value using metadata mechanisms 2
        patientInfo.setDateOfBirth("");
        rawIterator = patientInfo.getHl7FieldIterator("PID-7");
        assertFalse(rawIterator.hasNext());
        assertNull(patientInfo.getDateOfBirth());

        // overwrite the value using metadata mechanisms 3
        patientInfo.setDateOfBirth((String) null);
        rawIterator = patientInfo.getHl7FieldIterator("PID-7");
        assertFalse(rawIterator.hasNext());
        assertNull(patientInfo.getDateOfBirth());

        // overwrite the value using metadata mechanisms 4
        patientInfo.setDateOfBirth((Timestamp) null);
        rawIterator = patientInfo.getHl7FieldIterator("PID-7");
        assertFalse(rawIterator.hasNext());
        assertNull(patientInfo.getDateOfBirth());
    }

    @Test
    public void testRawGenderHandling() {
        var request = SampleData.createRegisterDocumentSet();
        var patientInfo = request.getDocumentEntries().get(0).getSourcePatientInfo();
        var rawIterator = patientInfo.getHl7FieldIterator("PID-8");
        assertTrue(rawIterator.hasNext());

        // clear the list
        while (rawIterator.hasNext()) {
            rawIterator.next();
            rawIterator.remove();
        }
        assertFalse(rawIterator.hasNext());

        // fill the list with some values
        rawIterator.add("");
        rawIterator.add(null);
        rawIterator.add("M");

        // check
        assertNull(patientInfo.getGender());
        var renderedStrings = getRenderedStrings(patientInfo, "PID-8", 1);
        assertEquals("PID-8|~~M", renderedStrings.get(0));

        // delete the first value and check again
        rawIterator = patientInfo.getHl7FieldIterator("PID-8");
        rawIterator.next();
        rawIterator.remove();
        assertNull(patientInfo.getGender());
        renderedStrings = getRenderedStrings(patientInfo, "PID-8", 1);
        assertEquals("PID-8|~M", renderedStrings.get(0));

        // delete the first value and check again
        rawIterator = patientInfo.getHl7FieldIterator("PID-8");
        rawIterator.next();
        rawIterator.remove();
        assertEquals("M", patientInfo.getGender());
        renderedStrings = getRenderedStrings(patientInfo, "PID-8", 1);
        assertEquals("PID-8|M", renderedStrings.get(0));
    }

    @Test
    public void testXdsGenderHandling() {
        var request = SampleData.createRegisterDocumentSet();
        var patientInfo = request.getDocumentEntries().get(0).getSourcePatientInfo();
        var rawIterator = patientInfo.getHl7FieldIterator("PID-8");
        assertTrue(rawIterator.hasNext());

        // clear the list
        while (rawIterator.hasNext()) {
            rawIterator.next();
            rawIterator.remove();
        }
        assertFalse(rawIterator.hasNext());

        // fill the list with some values
        rawIterator.add("");
        rawIterator.add(null);
        rawIterator.add("M");

        // overwrite the value using metadata mechanisms 1
        patientInfo.setGender("F");
        rawIterator = patientInfo.getHl7FieldIterator("PID-8");
        assertEquals("F", rawIterator.next());
        assertFalse(rawIterator.hasNext());
        var renderedStrings = getRenderedStrings(patientInfo, "PID-8", 1);
        assertEquals("PID-8|F", renderedStrings.get(0));
        assertEquals("F", patientInfo.getGender());

        // overwrite the value using metadata mechanisms 2
        patientInfo.setGender("");
        rawIterator = patientInfo.getHl7FieldIterator("PID-8");
        assertFalse(rawIterator.hasNext());
        assertNull(patientInfo.getGender());

        // overwrite the value using metadata mechanisms 3
        patientInfo.setGender(null);
        rawIterator = patientInfo.getHl7FieldIterator("PID-8");
        assertFalse(rawIterator.hasNext());
        assertNull(patientInfo.getGender());
    }

    @Test
    public void testInPlaceModification() {
        var request = SampleData.createRegisterDocumentSet();
        var patientInfo = request.getDocumentEntries().get(0).getSourcePatientInfo();
        var xdsIterator = patientInfo.getNames();
        assertTrue(xdsIterator.hasNext());

        // clear the list
        while (xdsIterator.hasNext()) {
            xdsIterator.next();
            xdsIterator.remove();
        }
        assertFalse(xdsIterator.hasNext());

        // fill the list with some values
        xdsIterator.add(new XcnName("Krause", "Peter", null, null, null, "Dr."));
        xdsIterator.add(null);
        xdsIterator.add(new XpnName("Schmitt", "Jens", "Klaus Heinz", null, "Ritter", null));
        xdsIterator.add(null);

        // check using other iterator type
        var rawIterator = patientInfo.getHl7FieldIterator("PID-5");
        assertEquals("Krause^Peter^^^^Dr.", rawIterator.next());
        assertEquals("", rawIterator.next());
        assertEquals("Schmitt^Jens^Klaus Heinz^^Ritter", rawIterator.next());
        assertEquals("", rawIterator.next());
        assertFalse(rawIterator.hasNext());

        // modify values in place -- shall be NOT propagated to HL7 strings
        xdsIterator = patientInfo.getNames();
        var name = xdsIterator.next();
        assertEquals(new XcnName("Krause", "Peter", null, null, null, "Dr."), name);
        name.setFamilyName("Mueller");
        assertEquals(new XcnName("Mueller", "Peter", null, null, null, "Dr."), name);
        rawIterator = patientInfo.getHl7FieldIterator("PID-5");
        assertEquals("Krause^Peter^^^^Dr.", rawIterator.next());

        // modify values by calling xdsIterator.set() -- SHALL be propagated to HL7 strings
        xdsIterator = patientInfo.getNames();
        name = xdsIterator.next();
        assertEquals(new XcnName("Mueller", "Peter", null, null, null, "Dr."), name);
        name.setFamilyName("Krusenstern");
        assertEquals(new XcnName("Krusenstern", "Peter", null, null, null, "Dr."), name);
        // --------------------
        xdsIterator.set(name);
        // --------------------
        rawIterator = patientInfo.getHl7FieldIterator("PID-5");
        assertEquals("Krusenstern^Peter^^^^Dr.", rawIterator.next());
    }

    @Test
    public void testToString() {
        var request = SampleData.createRegisterDocumentSet();
        var patientInfo = request.getDocumentEntries().get(0).getSourcePatientInfo();

        // standard fields
        patientInfo.getIds().add(new Identifiable("123", new AssigningAuthority("1.2.3")));
        patientInfo.getIds().add(new Identifiable("124", new AssigningAuthority("1.2.3")));
        patientInfo.getNames().add(new XcnName("Krause", "Peter", null, null, null, "Dr."));
        patientInfo.getNames().add(new XpnName("Schmitt", "Jens", "Klaus Heinz", null, "Ritter", null));
        patientInfo.setDateOfBirth("19761230");
        patientInfo.setGender("M");

        // custom fields
        var citizenships = patientInfo.getHl7FieldIterator("PID-26");
        citizenships.add("Greenland");
        citizenships.add("New Guinea");

        var religions = patientInfo.getHl7FieldIterator("PID-17");
        religions.add("Buddhism");

        var maritalStatuses = patientInfo.getHl7FieldIterator("PID-16");
        maritalStatuses.add(null);
        maritalStatuses.add("");
        maritalStatuses.add(null);
        maritalStatuses.add("");

        var ethnicGroups = patientInfo.getHl7FieldIterator("PID-22");
        // do not add any ethnic group, the call was just to create an empty entry

        var motherIdentifiers = patientInfo.getHl7FieldIterator("PID-21");
        motherIdentifiers.add("motherId^^^&1.2.3.4.5&ISO");

        // check toString() -- the fields must be in proper order, and without PID-22
        var s = patientInfo.toString();
        assertTrue(s.contains("PID-16=[null, , null, ], PID-17=[Buddhism], PID-21=[motherId^^^&1.2.3.4.5&ISO], PID-26=[Greenland, New Guinea]"));

        // check HL7 rendering -- the fields must be in proper order, and without PID-22
        var rendered = PATIENT_INFO_TRANSFORMER.toHL7(patientInfo);
        assertEquals("PID-3|124^^^&1.2.3&ISO~123^^^&1.2.3&ISO", rendered.get(0));
        assertEquals("PID-5|Schmitt^Jens^Klaus Heinz^^Ritter~Krause^Peter^^^^Dr.~Susi", rendered.get(1));
        assertEquals("PID-7|19761230", rendered.get(2));
        assertEquals("PID-8|M", rendered.get(3));
        assertEquals("PID-11|hier", rendered.get(4));
        assertEquals("PID-16|~~~", rendered.get(5));
        assertEquals("PID-17|Buddhism", rendered.get(6));
        assertEquals("PID-21|motherId^^^&1.2.3.4.5&ISO", rendered.get(7));
        assertEquals("PID-26|Greenland~New Guinea", rendered.get(8));
    }

}
