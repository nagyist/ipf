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

package org.openehealth.ipf.commons.audit.queue;

import lombok.Setter;
import org.openehealth.ipf.commons.audit.AuditContext;
import org.openehealth.ipf.commons.audit.model.AuditMessage;

import java.util.stream.Stream;

/**
 * <p>
 * Abstract base class for message queues that serialize the AuditRecord into a wire format
 * by using the configured {@link org.openehealth.ipf.commons.audit.marshal.SerializationStrategy SerializationStrategy}
 * and send it to an ATNA repository using the configured {@link org.openehealth.ipf.commons.audit.protocol.AuditTransmissionProtocol},
 * </p>
 * <p>
 * There may be other use cases such as forwarding AuditMessages as object into a Camel Route or in-memory storage.
 * In this case, implement your own {@link AuditMessageQueue}.
 * </p>
 *
 * @author Christian Ohr
 * @since 3.5
 */
public abstract class AbstractAuditMessageQueue implements AuditMessageQueue {


    @Setter
    private boolean pretty = false;

    @Override
    public void audit(AuditContext auditContext, AuditMessage... auditMessages) {
        if (auditMessages != null) {
            Stream.of(auditMessages)
                .map(msg -> auditContext.getSerializationStrategy().marshal(msg, pretty))
                .forEach(msg -> handle(auditContext, msg));
        }
    }

    protected abstract void handle(AuditContext auditContext, String auditRecord);


}
