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

package org.openehealth.ipf.boot.atna;

import lombok.NonNull;
import org.openehealth.ipf.commons.audit.AuditContext;
import org.openehealth.ipf.commons.audit.codes.EventOutcomeIndicator;
import org.openehealth.ipf.commons.audit.event.ApplicationActivityBuilder;
import org.openehealth.ipf.commons.audit.utils.AuditUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import static java.util.Objects.requireNonNull;

public class ApplicationStartEventListener implements ApplicationListener<ContextRefreshedEvent> {

    private final AuditContext auditContext;

    @Autowired
    private ApplicationContext applicationContext;

    public ApplicationStartEventListener(AuditContext auditContext) {
        this.auditContext = requireNonNull(auditContext);
    }

    @Override
    public void onApplicationEvent(@NonNull ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext() == applicationContext) {
            auditContext.audit(
                    new ApplicationActivityBuilder.ApplicationStart(EventOutcomeIndicator.Success)
                            .setAuditSource(auditContext)
                            .setApplicationParticipant(
                                    applicationContext.getApplicationName(),
                                    null,
                                    null,
                                    AuditUtils.getLocalHostName())
                            .addApplicationStarterParticipant(System.getProperty("user.name"))
                            .getMessages()
            );
        }

    }
}
