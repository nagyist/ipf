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
package org.openehealth.ipf.commons.xml;

import org.openehealth.ipf.commons.core.modules.api.ValidationException;
import org.openehealth.ipf.commons.core.modules.api.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Validation of XML documents based on a XML Schema. Before using this class
 * consider using a validating Parser class.
 * 
 * @author Christian Ohr
 */
public class XsdValidator extends AbstractCachingXmlProcessor<Schema> implements Validator<Source, String> {
    private static final Logger log = LoggerFactory.getLogger(XsdValidator.class);

    private static final ConcurrentMap<String, Loader<Schema>> XSD_CACHE = new ConcurrentHashMap<>();
    private static final LSResourceResolverImpl RESOURCE_RESOLVER = new LSResourceResolverImpl();

    private String schemaLanguage = XMLConstants.W3C_XML_SCHEMA_NS_URI;

    public XsdValidator() {
        super(null);
    }

    public XsdValidator(ClassLoader classloader) {
        super(classloader);
    }

    @Override
    protected ConcurrentMap<String, Loader<Schema>> getCache() {
        return XSD_CACHE;
    }

    @Override
    public void validate(Source message, String schema) {
        var exceptions = doValidate(message, schema);
        if (! exceptions.isEmpty()) {
            throw new ValidationException(exceptions);
        }
    }

    /**
     * @param message
     *            the message to be validated
     * @param schemaResource
     *            the XML schema to validate against
     * @return a list of validation exceptions
     */
    protected List<ValidationException> doValidate(Source message, String schemaResource) {
        try {
            log.debug("Validating XML message");
            var schema = resource(schemaResource);
            var validator = schema.newValidator();
            var errorHandler = new CollectingErrorHandler();
            validator.setErrorHandler(errorHandler);
            validator.validate(message);
            var exceptions = errorHandler.getExceptions();
            if (! exceptions.isEmpty()) {
                log.debug("Message validation found {} problems", exceptions.size());
            } else {
                log.debug("Message validation successful");
            }
            return exceptions;
        } catch (Exception e) {
            return Collections.singletonList(new ValidationException(
                    "Unexpected validation failure because " + e.getMessage(), e));
        }
    }

    @Override
    protected Schema createResource(Object... params) {
        // SchemaFactory is neither thread-safe nor reentrant
        var factory = SchemaFactory.newInstance(getSchemaLanguage());

        // Register resource resolver to resolve external XML schemas
        factory.setResourceResolver(RESOURCE_RESOLVER);
        try {
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            return factory.newSchema(resourceContent(params));
        } catch (SAXException e) {
            throw new IllegalArgumentException("Could not initialize XSD schema", e);
        }
    }

    public String getSchemaLanguage() {
        return schemaLanguage;
    }

    public void setSchemaLanguage(String schemaLanguage) {
        this.schemaLanguage = schemaLanguage;
    }

    /**
     * Error handler that collects {@link SAXParseException}s and provides them
     * wrapped in an {@link ValidationException} array.
     * 
     * @author Christian Ohr
     */
    private static class CollectingErrorHandler implements ErrorHandler {

        private final List<ValidationException> exceptions = new ArrayList<>();

        @Override
        public void error(SAXParseException exception) {
            add(exception);
        }

        @Override
        public void fatalError(SAXParseException exception) {
            add(exception);
        }

        @Override
        public void warning(SAXParseException exception) {
            // TODO log some message
        }

        private void add(SAXParseException exception) {
            exceptions.add(new ValidationException(exception));
        }

        public List<ValidationException> getExceptions() {
            return exceptions;
        }
    }
}
