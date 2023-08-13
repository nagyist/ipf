/*
 * Copyright 2015 the original author or authors.
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
package org.openehealth.ipf.platform.camel.ihe.core;

import org.apache.camel.DelegateProcessor;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Producer;

import static java.util.Objects.requireNonNull;

/**
 * Adapter for interceptors which allows them
 * to be exposed as Camel {@link Producer}s.
 *
 * @author Dmytro Rud
 */
public class Interceptor2ProducerAdapter implements Producer, DelegateProcessor {
    private final Processor interceptor;
    private final Producer originalProducer;

    public Interceptor2ProducerAdapter(Processor interceptor, Producer originalProducer) {
        this.interceptor = requireNonNull(interceptor);
        this.originalProducer = requireNonNull(originalProducer);
    }

    @Override
    public Processor getProcessor() {
        return interceptor;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        interceptor.process(exchange);
    }

    @Override
    public Endpoint getEndpoint() {
        return originalProducer.getEndpoint();
    }

    @Override
    public void start() {
        originalProducer.start();
    }

    @Override
    public void stop() {
        originalProducer.stop();
    }

    @Override
    public boolean isSingleton() {
        return originalProducer.isSingleton();
    }
}
