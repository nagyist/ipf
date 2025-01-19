/*
 * Copyright 2011 the original author or authors.
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

import org.w3c.dom.Node;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/**
 * Various XML utilities.
 *
 * @author Dmytro Rud
 */
abstract public class XmlUtils {

    private static final Pattern ROOT_ELEMENT_PATTERN = Pattern.compile(
            "(?:<\\?xml.+?\\?>)?" +                              // optional prolog
            "(?:\\s*<!--.*?-->)*" +                              // optional comments
            "\\s*<(?:[\\w.-]+?:)?([\\w.-]+)(?:\\s|(?:/?>))",   // open tag of the root element
            Pattern.DOTALL
    );

    private XmlUtils() {
        throw new IllegalStateException("Cannot instantiate helper class");
    }

    /**
     * Creates an XML Source from the given XML String.
     *
     * @param s XML String.
     * @return XML Source.
     */
    public static Source source(String s) {
        return new StreamSource(new StringReader(s));
    }

    /**
     * Returns local name of the root element of the XML document represented
     * by the given string, or <code>null</code>, when the given string does
     * not contain valid XML.
     *
     * @param s XML string.
     * @return root element local name, or <code>null</code> when it could not be determined.
     */
    public static String rootElementName(String s) {
        if (s == null) {
            return null;
        }
        var matcher = ROOT_ELEMENT_PATTERN.matcher(s);
        return (matcher.find() && (matcher.start() == 0)) ? matcher.group(1) : null;
    }

    /**
     * Creates a String representation of a JAXB object.
     *
     * @param jaxbContext JAXB context corresponding to the object's type
     * @param object      The JAXB object to be processed
     * @param prettyPrint Whether the XML shall nbe pretty printed or not
     * @return String representation of the given  JAXB object
     */
    public static String renderJaxb(JAXBContext jaxbContext, Object object, Boolean prettyPrint) {
        try {
            var marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, prettyPrint);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, StandardCharsets.UTF_8.name());
            var writer = new StringWriter();
            marshaller.marshal(object, writer);
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Simple method to serialize a DOM-bound XML object to a byte array (string)
     *
     * @param inputNode DOM Node to serialize
     * @return Byte array of XML in ASCII form
     * @throws Exception exception
     */
    public static byte[] serialize(Node inputNode) throws Exception {
        // Initialize sources and targets
        var serializerOutput = new ByteArrayOutputStream();
        Source sourceObject = new DOMSource(inputNode);
        Result targetObject = new StreamResult(serializerOutput);

        var serializerFactory = TransformerFactory.newInstance();
        var serializer = serializerFactory.newTransformer();
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        serializer.transform(sourceObject, targetObject);
        return serializerOutput.toByteArray();
    }
}
