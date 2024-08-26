/*
 * Copyright 2009 the original author or authors.
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
package org.openehealth.ipf.platform.camel.ihe.xds.iti43

import jakarta.activation.DataHandler
import org.apache.camel.builder.RouteBuilder
import org.apache.cxf.interceptor.Fault
import org.apache.cxf.message.Message
import org.apache.cxf.phase.AbstractPhaseInterceptor
import org.apache.cxf.phase.Phase
import org.openehealth.ipf.commons.ihe.ws.utils.LargeDataSource
import org.openehealth.ipf.commons.ihe.xds.core.requests.RetrieveDocumentSet
import org.openehealth.ipf.commons.ihe.xds.core.responses.RetrievedDocument
import org.openehealth.ipf.commons.ihe.xds.core.responses.RetrievedDocumentSet

import static org.openehealth.ipf.commons.ihe.xds.core.responses.Status.FAILURE
import static org.openehealth.ipf.commons.ihe.xds.core.responses.Status.SUCCESS
import static org.openehealth.ipf.platform.camel.ihe.xds.XdsCamelValidators.iti43RequestValidator
import static org.openehealth.ipf.platform.camel.ihe.xds.XdsCamelValidators.iti43ResponseValidator

/**
 * @author Jens Riemschneider
 */
class Iti43TestRouteBuilder extends RouteBuilder {
    @Override
    void configure() throws Exception {
        from('xds-iti43:xds-iti43-service1')
            .process(iti43RequestValidator())
            .process { checkValue(it, 'service 1') } 
            .process(iti43ResponseValidator())
    
        from('xds-iti43:xds-iti43-service2')
            .process { checkValue(it, 'service 2') }

        from('xds-iti43:xds-iti43-service3?inInterceptors=#customUrlParametersCheckServerInterceptor')
            .process { checkValue(it, 'service 3') }
    }

    void checkValue(exchange, expected) {
        RetrieveDocumentSet request = exchange.in.getBody(RetrieveDocumentSet.class)
        RetrievedDocumentSet response = new RetrievedDocumentSet(SUCCESS)
        if (expected != request.documents[0].documentUniqueId) {
            response.setStatus(FAILURE)
        }
        else {
            def doc1 = new RetrievedDocument()
            doc1.dataHandler = new DataHandler(new LargeDataSource())
            doc1.requestData = request.documents[0]
            doc1.mimeType = 'application/octet-cream'
            response.documents.add(doc1)

            def doc2 = new RetrievedDocument()
            doc2.dataHandler = new DataHandler(new LargeDataSource())
            doc2.requestData = request.documents[1]
            doc2.mimeType = 'application/octet-cream'
            response.documents.add(doc2)
        }

        exchange.message.body = response
    }

    private static class CustomParamsInterceptor extends AbstractPhaseInterceptor<Message> {

        CustomParamsInterceptor() {
            super(Phase.RECEIVE)
        }

        @Override
        void handleMessage(Message message) throws Fault {
            assert message.get(Message.QUERY_STRING)
        }
    }
}
