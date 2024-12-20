/*
 * Copyright 2008 the original author or authors.
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
package org.openehealth.ipf.platform.camel.core.adapter.builder;

import org.apache.camel.Predicate;
import org.openehealth.ipf.platform.camel.core.support.builder.RouteBuilderSupport;


/**
 * @author Martin Krasser
 */
public class PredicateRouteBuilder extends RouteBuilderSupport {

    @Override
    public void configure() {
        from("direct:predicate-test-1")
        .filter(predicate1())
        .to("mock:mock");
        
        from("direct:predicate-test-2")
        .filter(predicate2())
        .to("mock:mock");
        
    }

    private Predicate predicate1() {
        return helper.predicate("testPredicate");
    }

    private Predicate predicate2() {
        return helper.predicate("testPredicate").input(header("foo"));
    }

}
