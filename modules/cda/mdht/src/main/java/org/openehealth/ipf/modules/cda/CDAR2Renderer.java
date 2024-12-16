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
package org.openehealth.ipf.modules.cda;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Map;

import javax.xml.transform.Result;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.openehealth.ipf.commons.core.modules.api.RenderException;
import org.openehealth.ipf.commons.core.modules.api.Renderer;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.CDAPackage;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.internal.resource.CDAResourceFactoryImpl;

/**
 * @author Christian Ohr
 */
public class CDAR2Renderer implements Renderer<ClinicalDocument> {

    @Override
    public String render(ClinicalDocument doc, Object... options) {
        var bos = new ByteArrayOutputStream();
        try {
            render(doc, bos, options);
            return bos.toString();
        } catch (IOException e) {
            throw new RenderException(e);
        }

    }

    /**
     * Renders the clinical document as XML. Options can be specified for
     * dynamic configuration of the rendering process.
     * 
     * @param doc the clinical document
     * @param os the stream to write the XML to
     * @param options may contains a map with options for rendering.
     */
    @Override
    public OutputStream render(ClinicalDocument doc,
            OutputStream os, Object... options) throws IOException {
        XMLResource resources = new CDAResourceFactoryImpl()
                .createResource(URI.createURI(CDAPackage.eNS_URI));
        // set to true if want the XML declaration printed, set to FALSE if you
        // don't. TODO merge this with dynamic options.
        resources.getDefaultSaveOptions().put(XMLResource.OPTION_DECLARE_XML,
                Boolean.TRUE);
        
        if (options != null && options.length > 0 && options[0] instanceof Map map) {
            resources.getDefaultSaveOptions().putAll(map);
        }
        
        // Create document root
        var root = CDAFactory.eINSTANCE.createDocumentRoot();
        root.getXMLNSPrefixMap().put("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        root.getXMLNSPrefixMap().put("", "urn:hl7-org:v3");
        root.getXSISchemaLocation().put("urn:hl7-org:v3", "CDA.xsd");
        root.setClinicalDocument(doc);
        resources.getContents().add(root);
        // Write to stream
        resources.save(os, resources.getDefaultSaveOptions());
        return os;
    }

    @Override
    public Result render(ClinicalDocument doc, Result result,
            Object... options) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Writer render(ClinicalDocument doc, Writer writer,
            Object... options) throws IOException {
        var s = render(doc, options);
        writer.write(s);
        return writer;
    }

}
