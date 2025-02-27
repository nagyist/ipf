/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openehealth.ipf.platform.camel.ihe.hpd.chciq;

import lombok.extern.slf4j.Slf4j;
import org.openehealth.ipf.commons.ihe.hpd.chciq.ChCiqPortType;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.BatchRequest;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.BatchResponse;
import org.openehealth.ipf.commons.ihe.ws.cxf.audit.WsAuditDataset;
import org.openehealth.ipf.platform.camel.ihe.hpd.HpdQueryEndpoint;
import org.openehealth.ipf.platform.camel.ihe.hpd.HpdQueryService;

@Slf4j
public class ChCiqService extends HpdQueryService implements ChCiqPortType {

    public ChCiqService(HpdQueryEndpoint<WsAuditDataset> endpoint) {
        super(endpoint);
    }

    @Override
    public BatchResponse communityQueryRequest(BatchRequest request) {
        return doProcess(request);
    }

}
