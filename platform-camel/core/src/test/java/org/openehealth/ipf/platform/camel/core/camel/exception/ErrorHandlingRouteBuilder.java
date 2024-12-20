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
package org.openehealth.ipf.platform.camel.core.camel.exception;


import org.apache.camel.builder.RouteBuilder;
import org.openehealth.ipf.platform.camel.core.support.processor.FailureProcessor;


/**
 * @author Martin Krasser
 */
public class ErrorHandlingRouteBuilder extends RouteBuilder {

    private final FailureProcessor failure = new FailureProcessor("blah");
    
        
    @Override
    public void configure() {

        // global error handler
        errorHandler(noErrorHandler());
        
        from("direct:input-1")
        .to("mock:inter")   // inherits global error handler (step in pipeline)
        .process(failure)   // inherits global error handler (step in pipeline)
        .to("mock:output"); // inherits global error handler (step in pipeline)
        
        from("direct:input-2")
        // defines local error handler (placed before every node in this route)
        .errorHandler(defaultErrorHandler().maximumRedeliveries(2)).to("mock:error")
        .onException(Exception.class).handled(false).end()
        .to("mock:inter")   // no redeliveries here
        .to("direct:temp"); // the error handler of this node redelivers
        
        from("direct:temp")
        .to("mock:check")    // inherits global error handler (step in pipeline)
        .process(failure)    // inherits global error handler (step in pipeline)
        .to("mock:output");  // inherits global error handler (step in pipeline)
    }
    
}
