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
package org.openehealth.ipf.commons.ihe.xds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openehealth.ipf.commons.ihe.core.InteractionId;
import org.openehealth.ipf.commons.ihe.ws.WsTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.xds.core.audit.XdsAuditDataset;

import java.util.Arrays;
import java.util.List;

/**
 * @author Christian Ohr
 * @since 3.2
 */
public class CONTINUA_HRN implements XdsIntegrationProfile {

    private static final CONTINUA_HRN Instance = new CONTINUA_HRN();

    @AllArgsConstructor
    public enum Interactions implements XdsInteractionId {
        ITI_41(XDS.Interactions.ITI_41.getWsTransactionConfiguration());

        @Getter private final WsTransactionConfiguration<? extends XdsAuditDataset> wsTransactionConfiguration;

        @Override
        public XdsIntegrationProfile getInteractionProfile() {
            return Instance;
        }
    }

    @Override
    public HomeCommunityIdOptionality getHomeCommunityIdOptionality() {
        return HomeCommunityIdOptionality.NEVER;
    }

    @Override
    public List<InteractionId> getInteractionIds() {
        return Arrays.asList(Interactions.values());
    }
}
