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
package org.openehealth.ipf.commons.audit.protocol;


import org.openehealth.ipf.commons.audit.AuditMetadataProvider;

import java.nio.charset.StandardCharsets;

/**
 * Base client implementation of RFC 5424 syslog for sending audit messages to an Audit Record Repository
 * that implements RFC 5424 SYSLOG.
 *
 * @author Christian Ohr
 * @since 3.5
 */
public class RFC5424Protocol {

    /**
     * Default syslog priority for this transport, according to
     * <a href="http://dicom.nema.org/medical/dicom/current/output/html/part15.html#sect_A.6">here</a>
     */
    private static final int TRANSPORT_PRI = 10 * 8 + 5;

    /**
     * Default syslog MSGID for this transport, according to
     * <a href="http://dicom.nema.org/medical/dicom/current/output/html/part15.html#sect_A.6">here</a>
     */
    private static final String TRANSPORT_MSGID = "IHE+RFC-3881";


    public RFC5424Protocol() {
    }


    /**
     * Serialize the syslog message payload body for sending by this transport. Must only be
     * called if this object was initialized with {@link #RFC5424Protocol()}
     *
     * @param auditMetadataProvider audit meta data
     * @param auditMessage          message to prepare
     * @return serialized message
     */
    protected byte[] getTransportPayload(AuditMetadataProvider auditMetadataProvider, String auditMessage) {
        var msg = String.format("<%s>1 %s %s %s %s %s - \uFEFF<?xml version=\"1.0\" encoding=\"UTF-8\"?>%s",
                TRANSPORT_PRI,
                auditMetadataProvider.getTimestamp(),
                auditMetadataProvider.getHostname(),
                auditMetadataProvider.getSendingApplication().replace(' ', '_'),
                auditMetadataProvider.getProcessID(),
                TRANSPORT_MSGID,
                auditMessage);
        return msg.trim().getBytes(StandardCharsets.UTF_8);
    }

}
