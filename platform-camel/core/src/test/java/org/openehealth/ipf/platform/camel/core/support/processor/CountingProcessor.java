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
package org.openehealth.ipf.platform.camel.core.support.processor;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @author Martin Krasser
 */
public class CountingProcessor implements Processor {

    private final AtomicInteger counter = new AtomicInteger(0);
    
    public int getExchangeCount() {
        return counter.get();
    }
    
    public void reset() {
        counter.set(0);
    }
    
    @Override
    public void process(Exchange exchange) {
        counter.incrementAndGet();
    }
    
}
