/*
 * Copyright 2023 the original author or authors.
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
package org.openehealth.ipf.platform.camel.ihe.xds.iti80;

import org.apache.camel.Endpoint;
import org.openehealth.ipf.commons.ihe.ws.JaxWsClientFactory;
import org.openehealth.ipf.commons.ihe.ws.WsTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.xds.core.audit.XdsSubmitAuditDataset;
import org.openehealth.ipf.platform.camel.ihe.ws.AbstractWsEndpoint;
import org.openehealth.ipf.platform.camel.ihe.ws.AbstractWsProducer;
import org.openehealth.ipf.platform.camel.ihe.xds.XdsComponent;
import org.openehealth.ipf.platform.camel.ihe.xds.XdsEndpoint;

import java.util.Map;

import static org.openehealth.ipf.commons.ihe.xds.XCDR.Interactions.ITI_80;

/**
 * The Camel component for the ITI-80 transaction.
 */
public class Iti80Component extends XdsComponent<XdsSubmitAuditDataset> {

    public Iti80Component() {
        super(ITI_80);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) {
        return new XdsEndpoint<>(uri, remaining, this, parameters, Iti80Service.class) {
            @Override
            public AbstractWsProducer<XdsSubmitAuditDataset, WsTransactionConfiguration<XdsSubmitAuditDataset>, ?, ?> getProducer(
                    AbstractWsEndpoint<XdsSubmitAuditDataset, WsTransactionConfiguration<XdsSubmitAuditDataset>> endpoint,
                    JaxWsClientFactory<XdsSubmitAuditDataset> clientFactory) {
                return new Iti80Producer(endpoint, clientFactory);
            }
        };
    }

}
