/*
 * Copyright 2013 the original author or authors.
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
package org.openehealth.ipf.platform.camel.hl7.validation;

import org.apache.camel.builder.RouteBuilder;
import org.openehealth.ipf.gazelle.validation.profile.pixpdq.ItiPixPdqProfile;
import org.openehealth.ipf.gazelle.validation.profile.pixpdq.PixPdqTransactions;

import static org.openehealth.ipf.platform.camel.hl7.validation.ConformanceProfileValidators.*;

/**
 * @author Boris Stanojevic
 */
public class TestRouteBuilder extends RouteBuilder {

    @Override
    public void configure() {

        from("direct:iti8")
                .process(validatingProcessor(PixPdqTransactions.ITI8));

        from("direct:iti10")
                .process(validatingProcessor(ItiPixPdqProfile.ITI_10_ADT_A31));

        from("direct:iti21")
                .process(validatingProcessor(PixPdqTransactions.ITI21));

    }
}
