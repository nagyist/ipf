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
package org.openehealth.ipf.platform.camel.core.adapter;

import static org.openehealth.ipf.platform.camel.core.util.Exchanges.prepareResult;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import javax.xml.transform.Source;

import org.apache.camel.Exchange;
import org.openehealth.ipf.commons.core.modules.api.Parser;

/**
 * Adapts a {@link Parser}. 
 * 
 * @author Martin Krasser
 */
public class ParserAdapter extends ProcessorAdapter {

    private final Parser parser;

    /**
     * Creates a new {@link ParserAdapter} and sets the delegate
     * {@link Parser}.
     * 
     * @param parser
     *            a parser.
     */
    public ParserAdapter(Parser parser) {
        this.parser = parser;
    }
    
    /**
     * Processes input data and populates the output message. This method
     * delegates message processing to more specialized <code>doProcess</code>
     * implementations.
     * 
     * @param exchange
     *            message exchange where to write processing results.
     * @param inputData
     *            input data.
     * @param inputParams
     *            input parameters.
     * @throws Exception
     *             if a processing error occurs.
     * 
     * @see #doProcess(InputStream, Object...)
     * @see #doProcess(Reader, Object...)
     * @see #doProcess(Source, Object...)
     * @see #doProcess(String, Object...)
     */
    @Override
    protected void doProcess(Exchange exchange, Object inputData, 
            Object... inputParams) throws Exception {
        
        if (inputData instanceof InputStream inputStream) {
            prepareResult(exchange).setBody(doProcess(inputStream, inputParams));
        } else if (inputData instanceof Reader reader) {
            prepareResult(exchange).setBody(doProcess(reader, inputParams));
        } else if (inputData instanceof Source source) {
            prepareResult(exchange).setBody(doProcess(source, inputParams));
        } else if (inputData instanceof String s) {
            prepareResult(exchange).setBody(doProcess(s, inputParams));
        } else {
            throw new IllegalArgumentException(
                    "input data class not supported: " + inputData.getClass());
        }
        
    }
    
    /**
     * Parses <code>inputData</code> using <code>inputParams</code> and
     * returns the parsing result. Parsing is delegated to the {@link Parser}
     * set at construction time.
     * 
     * @param inputData
     *            input data
     * @param inputParams
     *            input parameters
     * @throws IOException
     *             if a system-level problem occurs
     * @return parsing result
     */
    protected Object doProcess(InputStream inputData, Object... inputParams) throws IOException {
        return parser.parse(inputData, inputParams);
    }
    
    /**
     * Parses <code>inputData</code> using <code>inputParams</code> and
     * returns the parsing result. Parsing is delegated to the {@link Parser}
     * set at construction time.
     * 
     * @param inputData
     *            input data
     * @param inputParams
     *            input parameters
     * @throws IOException
     *             if a system-level problem occurs
     * @return parsing result
     */
    protected Object doProcess(Reader inputData, Object... inputParams) throws IOException {
        return parser.parse(inputData, inputParams);
    }
    
    /**
     * Parses <code>inputData</code> using <code>inputParams</code> and
     * returns the parsing result. Parsing is delegated to the {@link Parser}
     * set at construction time.
     * 
     * @param inputData
     *            input data
     * @param inputParams
     *            input parameters
     * @throws IOException
     *             if a system-level problem occurs
     * @return parsing result
     */
    protected Object doProcess(Source inputData, Object... inputParams) throws IOException {
        return parser.parse(inputData, inputParams);
    }
    
    /**
     * Parses <code>inputData</code> using <code>inputParams</code> and
     * returns the parsing result. Parsing is delegated to the {@link Parser}
     * set at construction time.
     * 
     * @param inputData
     *            input data
     * @param inputParams
     *            input parameters
     * @return parsing result
     */
    protected Object doProcess(String inputData, Object... inputParams) {
        return parser.parse(inputData, inputParams);
    }
    
}
