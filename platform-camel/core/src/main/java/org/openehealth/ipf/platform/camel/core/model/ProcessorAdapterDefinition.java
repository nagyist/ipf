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
package org.openehealth.ipf.platform.camel.core.model;

import groovy.lang.Closure;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.SimpleType;
import org.apache.camel.Expression;
import org.openehealth.ipf.platform.camel.core.adapter.StaticParams;
import org.openehealth.ipf.platform.camel.core.closures.DelegatingExpression;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 * @author Martin Krasser
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class ProcessorAdapterDefinition extends DelegateDefinition {

    @XmlTransient
    private Expression inputExpression;
    @XmlTransient
    private Expression paramsExpression;

    /**
     * Defines the input to the adapter via the given expression
     *
     * @param inputExpression the expression logic
     */
    public ProcessorAdapterDefinition input(Expression inputExpression) {
        this.inputExpression = inputExpression;
        return this;
    }

    /**
     * Defines the input to the adapter via the closure expression
     *
     * @param inputExpression a closure implementing the expression logic
     */
    public ProcessorAdapterDefinition input(@ClosureParams(value = SimpleType.class, options = {"org.apache.camel.Expression"})
                                                    Closure inputExpression) {
        this.inputExpression = new DelegatingExpression(inputExpression);
        return this;
    }

    /**
     * Defines the parameters for the adapter via the given expression
     *
     * @param paramsExpression the expression logic
     */
    public ProcessorAdapterDefinition params(Expression paramsExpression) {
        this.paramsExpression = paramsExpression;
        return this;
    }

    /**
     * Defines the parameters for the adapter via the closure expression
     *
     * @param paramsExpression a closure implementing the expression logic
     */
    public ProcessorAdapterDefinition params(@ClosureParams(value = SimpleType.class, options = {"org.apache.camel.Expression"})
                                                     Closure paramsExpression) {
        this.paramsExpression = new DelegatingExpression(paramsExpression);
        return this;
    }

    /**
     * Defines the static parameters for the adapter
     *
     * @param params the parameters
     */
    public ProcessorAdapterDefinition staticParams(Object... params) {
        paramsExpression = new StaticParams(params);
        return this;
    }

    public ParamsDefinition params() {
        return new ParamsDefinition(this);
    }


    public Expression getInputExpression() {
        return inputExpression;
    }

    public Expression getParamsExpression() {
        return paramsExpression;
    }
}
