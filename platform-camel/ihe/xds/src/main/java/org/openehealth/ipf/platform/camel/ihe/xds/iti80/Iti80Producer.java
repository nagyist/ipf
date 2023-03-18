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

import org.openehealth.ipf.commons.ihe.ws.JaxWsClientFactory;
import org.openehealth.ipf.commons.ihe.ws.WsTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.xds.core.audit.XdsSubmitAuditDataset;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.ebxml30.ProvideAndRegisterDocumentSetRequestType;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rs.RegistryResponseType;
import org.openehealth.ipf.commons.ihe.xds.iti80.Iti80PortType;
import org.openehealth.ipf.platform.camel.ihe.ws.AbstractWsEndpoint;
import org.openehealth.ipf.platform.camel.ihe.xds.XdsSubmissionProducer;

/**
 * @author Dmytro Rud
 */
public class Iti80Producer extends XdsSubmissionProducer<ProvideAndRegisterDocumentSetRequestType, RegistryResponseType> {

    public Iti80Producer(AbstractWsEndpoint<XdsSubmitAuditDataset, WsTransactionConfiguration<XdsSubmitAuditDataset>> endpoint,
                         JaxWsClientFactory<XdsSubmitAuditDataset> clientFactory) {
        super(endpoint, clientFactory, ProvideAndRegisterDocumentSetRequestType.class, RegistryResponseType.class);
    }

    @Override
    protected RegistryResponseType callService(Object client, ProvideAndRegisterDocumentSetRequestType request) {
        injectTargetHomeCommunityId(client, request.getSubmitObjectsRequest());
        return ((Iti80PortType) client).documentCrossGatewayDocumentProvide(request);
    }

}
