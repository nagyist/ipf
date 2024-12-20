/*
 * Copyright 2018 the original author or authors.
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
package org.openehealth.ipf.commons.ihe.hl7v3.audit;

import lombok.Getter;
import lombok.Setter;
import org.openehealth.ipf.commons.ihe.ws.cxf.audit.WsAuditDataset;

import java.io.Serial;


/**
 * Generic audit dataset for IHE PIX/PDQ v3 transactions.
 *
 * @author Dmytro Rud
 */
public class Hl7v3AuditDataset extends WsAuditDataset {

    @Serial
    private static final long serialVersionUID = -7303748425104562452L;

    /** HL7v3 message ID. */
    @Getter @Setter private String messageId;

    /** HL7v3 query ID. */
    @Getter @Setter private String queryId;

    /** Home ID of the target community. */
    @Getter @Setter private String homeCommunityId;

    /** Request message type (name of the root element). */
    @Getter @Setter private String requestType;

    /** Patient ID list. */
    @Getter @Setter private String[] patientIds;

    /** Old patient ID. */
    @Getter @Setter private String oldPatientId;

    public Hl7v3AuditDataset(boolean serverSide) {
        super(serverSide);
    }

    public String getPatientId() {
        return ((patientIds != null) && (patientIds.length > 0)) ? patientIds[0] : null;
    }

}
