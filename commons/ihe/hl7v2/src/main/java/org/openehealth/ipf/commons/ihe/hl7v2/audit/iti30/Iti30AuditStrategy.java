/*
 * Copyright 2015 the original author or authors.
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
package org.openehealth.ipf.commons.ihe.hl7v2.audit.iti30;

import ca.uhn.hl7v2.model.Message;
import org.openehealth.ipf.commons.audit.AuditContext;
import org.openehealth.ipf.commons.audit.AuditException;
import org.openehealth.ipf.commons.audit.codes.EventActionCode;
import org.openehealth.ipf.commons.audit.model.AuditMessage;
import org.openehealth.ipf.commons.ihe.core.atna.AuditStrategySupport;
import org.openehealth.ipf.commons.ihe.core.atna.event.DefaultPatientRecordEventBuilder;
import org.openehealth.ipf.commons.ihe.hl7v2.audit.FeedAuditDataset;
import org.openehealth.ipf.commons.ihe.hl7v2.audit.codes.MllpEventTypeCode;

import java.util.Map;

public class Iti30AuditStrategy extends AuditStrategySupport<FeedAuditDataset> {

    public Iti30AuditStrategy(boolean serverSide) {
        super(serverSide);
    }

    @Override
    public FeedAuditDataset enrichAuditDatasetFromRequest(FeedAuditDataset auditDataset, Object msg, Map<String, Object> parameters) {
        Iti30AuditStrategyUtils.enrichAuditDatasetFromRequest(auditDataset, (Message) msg);
        return auditDataset;
    }

    @Override
    public AuditMessage[] makeAuditMessage(AuditContext auditContext, FeedAuditDataset auditDataset) {
        return switch (auditDataset.getMessageType()) {
            case "A28" -> new AuditMessage[]{
                patientRecordAuditMessage(auditContext, auditDataset, EventActionCode.Create, true)
            };
            case "A31", "A47", "A24", "A37" -> new AuditMessage[]{
                patientRecordAuditMessage(auditContext, auditDataset, EventActionCode.Update, true)
            };
            case "A40" -> new AuditMessage[]{
                patientRecordAuditMessage(auditContext, auditDataset, EventActionCode.Delete, false),
                patientRecordAuditMessage(auditContext, auditDataset, EventActionCode.Update, true)
            };
            default ->
                throw new AuditException("Cannot create audit message for event " + auditDataset.getMessageType());
        };
    }

    protected AuditMessage patientRecordAuditMessage(AuditContext auditContext,
                                                     final FeedAuditDataset auditDataset,
                                                     EventActionCode eventActionCode,
                                                     boolean newPatientId) {
        return new DefaultPatientRecordEventBuilder(auditContext, auditDataset, eventActionCode, MllpEventTypeCode.PatientIdentityManagement)

                // Type=MSH-10 (the literal string), Value=the value of MSH-10 (from the message content, base64 encoded)
                .addPatients(
                        "MSH-10", auditDataset.getMessageControlId(),
                        newPatientId ? auditDataset.getPatientId() : auditDataset.getOldPatientId())
                .getMessage();
    }

    @Override
    public FeedAuditDataset createAuditDataset() {
        return new FeedAuditDataset(isServerSide());
    }
}
