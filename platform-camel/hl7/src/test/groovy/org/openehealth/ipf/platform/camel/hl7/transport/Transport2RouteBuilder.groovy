/*
 * Copyright 2017 the original author or authors.
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
package org.openehealth.ipf.platform.camel.hl7.transport

import org.apache.camel.builder.RouteBuilder
import org.openehealth.ipf.platform.camel.hl7.HL7v2

/**
 * @author Martin Krasser
 */
class Transport2RouteBuilder extends RouteBuilder {
    
    void configure() {

        from('netty:tcp://127.0.0.1:8889?sync=true&decoders=#hl7decoder&encoders=#hl7encoder')
            .unmarshal().hl7()
            .delay(50) // simulate some processing effort
            .transform(HL7v2.ack())

    }
    
}