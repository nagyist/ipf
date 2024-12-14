/*
 * Copyright 2018 the original author or authors.
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

package org.openehealth.ipf.platform.camel.ihe.fhir.iti68;

import ca.uhn.fhir.rest.gclient.ICriterion;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.openehealth.ipf.platform.camel.ihe.ws.StandardTestContainer;

/**
 *
 */
abstract class AbstractTestIti68 extends StandardTestContainer {

    public static void startServer(String contextDescriptor) {
        var servlet = new CamelHttpTransportServlet();
        startServer(servlet, contextDescriptor, false, DEMO_APP_PORT, "CamelServlet");
    }

    protected byte[] sendViaProducer(ICriterion<?>... requestData) {
        return producerTemplate.requestBody("direct:input", requestData, byte[].class);
    }

}
