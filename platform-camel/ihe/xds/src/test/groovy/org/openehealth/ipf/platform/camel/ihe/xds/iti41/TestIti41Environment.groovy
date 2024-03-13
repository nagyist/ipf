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
package org.openehealth.ipf.platform.camel.ihe.xds.iti41

import org.apache.cxf.transport.servlet.CXFServlet
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openehealth.ipf.commons.ihe.xds.core.SampleData
import org.openehealth.ipf.commons.ihe.xds.core.metadata.LocalizedString
import org.openehealth.ipf.commons.ihe.xds.core.responses.Response
import org.openehealth.ipf.platform.camel.ihe.xds.XdsStandardTestContainer

import static org.openehealth.ipf.commons.ihe.xds.core.responses.Status.SUCCESS

/**
 * Tests the ITI-41 transaction with a webservice and SSL configuration provided via system properties
 *
 * @author Christian Ohr
 */
class TestIti41Environment extends XdsStandardTestContainer {
    
    def static CONTEXT_DESCRIPTOR = 'iti-41-environment.xml'
    
    def SERVICE1 = "xds-iti41://localhost:${port}/xds-iti41-service1?secure=true"
    def SERVICE2 = "xds-iti41://localhost:${port}/xds-iti41-service2?secure=true"
    
    def request
    def docEntry

    static Properties sysProperties
    
    @BeforeAll
    static void classSetUp() {
        startServer(new CXFServlet(), CONTEXT_DESCRIPTOR, true)
        setSystemProperties()
    }

    @AfterAll
    static void classShutdown() {
        resetSystemProperties()
    }

    private static void setSystemProperties() {
        sysProperties = System.properties
        System.setProperty("javax.net.ssl.keyStore", "client.jks")
        System.setProperty("javax.net.ssl.trustStore", "client.jks")
        System.setProperty("javax.net.ssl.keyStorePassword", "changeit")
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit")
        System.setProperty("javax.net.debug", "all")
    }

    private static void resetSystemProperties() {
        if (sysProperties != null) {
            System.setProperty("javax.net.ssl.keyStore", sysProperties.get("javax.net.ssl.keyStore").toString())
            System.setProperty("javax.net.ssl.trustStore", sysProperties.get("javax.net.ssl.trustStore").toString())
            System.setProperty("javax.net.ssl.keyStorePassword", sysProperties.get("javax.net.ssl.keyStorePassword").toString())
            System.setProperty("javax.net.debug", sysProperties.get("javax.net.debug").toString())
        }
    }
    
    @BeforeEach
    void setUp() {
        request = SampleData.createProvideAndRegisterDocumentSet()
        docEntry = request.documents[0].documentEntry
    }
    
    @Test
    void testIti41() {
        assert SUCCESS == sendIt(SERVICE1, 'service 1', 'urn:oid:1.2.1').status
        assert SUCCESS == sendIt(SERVICE2, 'service 2', 'urn:oid:1.2.2').status
        assert auditSender.messages.size() == 4
    }
    
    def sendIt(endpoint, value, String targetHomeCommunityId) {
        docEntry.comments = new LocalizedString(value)
        request.targetHomeCommunityId = targetHomeCommunityId
        send(endpoint, request, Response.class)
    }
}
