/*
 * Copyright 2018 the original author or authors.
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
package org.openehealth.ipf.platform.camel.ihe.xacml20;

import org.openehealth.ipf.commons.ihe.ws.*;
import org.openehealth.ipf.commons.ihe.ws.cxf.audit.WsAuditDataset;
import org.openehealth.ipf.platform.camel.ihe.ws.AbstractWebService;
import org.openehealth.ipf.platform.camel.ihe.ws.AbstractWsComponent;
import org.openehealth.ipf.platform.camel.ihe.ws.AbstractWsEndpoint;

import java.util.Map;

/**
 * @since 3.5.1
 * @author Dmytro Rud
 */
abstract public class Xacml20Endpoint<T extends WsAuditDataset> extends AbstractWsEndpoint<T, WsTransactionConfiguration<T>> {

    public Xacml20Endpoint(
            String endpointUri,
            String address,
            AbstractWsComponent<T, WsTransactionConfiguration<T>, ? extends WsInteractionId<WsTransactionConfiguration<T>>> component,
            Map<String, Object> parameters,
            Class<? extends AbstractWebService> serviceClass)
    {
        super(endpointUri, address, component, parameters, serviceClass);
    }

    @Override
    public JaxWsClientFactory<T> getJaxWsClientFactory() {
        return new JaxWsRequestClientFactory<>(
                getComponent().getWsTransactionConfiguration(),
                getServiceUrl(),
                isAudit() ? getClientAuditStrategy() : null,
                getAuditContext(),
                getCustomCxfInterceptors(),
                getFeatures(),
                getProperties(),
                getCorrelator(),
                getSecurityInformation(),
                getHttpClientPolicy());
    }

    @Override
    public JaxWsServiceFactory<T> getJaxWsServiceFactory() {
        return new JaxWsRequestServiceFactory<>(
                getComponent().getWsTransactionConfiguration(),
                getServiceAddress(),
                isAudit() ? getComponent().getServerAuditStrategy() : null,
                getAuditContext(),
                getCustomCxfInterceptors(),
                getRejectionHandlingStrategy());
    }

}
