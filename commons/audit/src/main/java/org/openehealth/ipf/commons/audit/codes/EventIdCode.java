/*
 * Copyright 2017 the original author or authors.
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

package org.openehealth.ipf.commons.audit.codes;

import lombok.Getter;
import org.openehealth.ipf.commons.audit.types.EnumeratedCodedValue;
import org.openehealth.ipf.commons.audit.types.EnumeratedValueSet;
import org.openehealth.ipf.commons.audit.types.EventId;

/**
 * Audit Event ID Code as specified in
 * http://dicom.nema.org/medical/dicom/current/output/html/part16.html#sect_CID_400
 * 1.2.840.10008.6.1.903
 *
 * @author Christian Ohr
 * @since 3.5
 */
public enum EventIdCode implements EventId, EnumeratedCodedValue<EventId> {

    ApplicationActivity("110100", "Application Activity"),
    AuditLogUsed("110101", "Audit Log Used"),
    BeginTransferringDICOMInstances("110102", "Begin Transferring DICOM Instances"),
    DICOMInstancesAccessed("110103", "DICOM Instances Accessed"),
    DICOMInstancesTransferred("110104", "DICOM Instances Transferred"),
    DICOMStudyDeleted("110105", "DICOM Study Deleted"),
    Export("110106", "Export"),
    Import("110107", "Import"),
    NetworkEntry("110108", "Network Entry"),
    OrderRecord("110109", "Order Record"),
    PatientRecord("110110", "Patient Record"),
    ProcedureRecord("110111", "Procedure Record"),
    Query("110112", "Query"),
    SecurityAlert("110113", "Security Alert"),
    UserAuthentication("110114", "User Authentication");

    @Getter
    private final EventId value;

    EventIdCode(String code, String displayName) {
        this.value = EventId.of(code, CODE_SYSTEM_NAME_DCM, displayName);
    }

    public static EventIdCode enumForCode(String code) {
        return EnumeratedValueSet.enumForCode(EventIdCode.class, code);
    }
}


