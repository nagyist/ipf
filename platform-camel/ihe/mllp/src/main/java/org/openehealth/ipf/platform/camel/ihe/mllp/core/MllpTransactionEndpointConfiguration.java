/*
 * Copyright 2014 the original author or authors.
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

package org.openehealth.ipf.platform.camel.ihe.mllp.core;

import lombok.Getter;
import org.openehealth.ipf.commons.ihe.hl7v2.audit.MllpAuditDataset;
import org.openehealth.ipf.commons.ihe.hl7v2.storage.InteractiveContinuationStorage;
import org.openehealth.ipf.commons.ihe.hl7v2.storage.UnsolicitedFragmentationStorage;

import java.util.Map;

/**
 * Camel endpoint configuration for MLLP-based eHealth transactions (like IHE PIX, PDQ, XAD-PID, etc.).
 * @author Dmytro Rud
 */
public class MllpTransactionEndpointConfiguration extends MllpEndpointConfiguration {

    @Getter private final boolean supportUnsolicitedFragmentation;
    @Getter private final int unsolicitedFragmentationThreshold;
    @Getter private final UnsolicitedFragmentationStorage unsolicitedFragmentationStorage;

    @Getter private final boolean supportInteractiveContinuation;
    @Getter private final int interactiveContinuationDefaultThreshold;
    @Getter private final InteractiveContinuationStorage interactiveContinuationStorage;
    @Getter private final boolean autoCancel;
    @Getter private final boolean copyOriginalMessage;

    protected MllpTransactionEndpointConfiguration(MllpComponent<MllpTransactionEndpointConfiguration, ? extends MllpAuditDataset> component, String uri, Map<String, Object> parameters) {
        super(component, uri, parameters);

        copyOriginalMessage = component.getAndRemoveParameter(
                parameters, "copyOriginalMessage", boolean.class, true);
        supportUnsolicitedFragmentation = component.getAndRemoveParameter(
                parameters, "supportUnsolicitedFragmentation", boolean.class, false);
        unsolicitedFragmentationThreshold = component.getAndRemoveParameter(
                parameters, "unsolicitedFragmentationThreshold", int.class, -1);            // >= 3 segments

        unsolicitedFragmentationStorage = component.resolveAndRemoveReferenceParameter(
                parameters,
                "unsolicitedFragmentationStorage",
                UnsolicitedFragmentationStorage.class);

        supportInteractiveContinuation = component.getAndRemoveParameter(
                parameters, "supportInteractiveContinuation", boolean.class, false);
        interactiveContinuationDefaultThreshold = component.getAndRemoveParameter(
                parameters, "interactiveContinuationDefaultThreshold", int.class, -1);      // >= 1 data record

        interactiveContinuationStorage = component.resolveAndRemoveReferenceParameter(
                        parameters,
                        "interactiveContinuationStorage",
                        InteractiveContinuationStorage.class);

        autoCancel = component.getAndRemoveParameter(parameters, "autoCancel", boolean.class, false);
    }

}
