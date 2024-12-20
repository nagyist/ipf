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
package org.openehealth.ipf.commons.ihe.ws.cxf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;

/**
 * CXF interceptor which logs all errors instead of 
 * letting them break the processing flow.
 * @author Dmytro Rud
 */
abstract public class AbstractSafeInterceptor extends AbstractSoapInterceptor {
    private static final Logger log = LoggerFactory.getLogger(AbstractSafeInterceptor.class);

    /**
     * Constructs the interceptor.
     * @param phase
     *          the phase in which the interceptor is run.
     */
    protected AbstractSafeInterceptor(String phase) {
        super(phase);
    }
    
    /**
     * Performs the actual work, being called from {@link #handleMessage(SoapMessage)}.
     * 
     * @param message
     *          CXF message to process.
     */
    abstract protected void process(SoapMessage message);
    
    /**
     * Calls {@link #process(org.apache.cxf.binding.soap.SoapMessage)}
     * and "forwards" all exceptions to the error log.
     * 
     * @param message CXF message to process.
     */
    @Override
    public final void handleMessage(SoapMessage message) {
        try {
            process(message);
        } catch(Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
