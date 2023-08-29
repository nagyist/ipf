/*
 * Copyright 2019 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.openehealth.ipf.commons.ihe.fhir;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.server.RequestDetails;

import javax.security.cert.X509Certificate;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;

/**
 * Base class for all Resource Providers defined in IPF
 *
 * @author Christian Ohr
 */
public abstract class FhirProvider implements Serializable {

    /**
     * @return FhirContext
     */
    protected abstract FhirContext getFhirContext();

    /**
     * Returns the first consumer that is able to handle the provided payload
     *
     * @param requestDetails FHIR request
     * @return consumer or {@link Optional#empty()}
     */
    protected abstract Optional<RequestConsumer> getRequestConsumer(RequestDetails requestDetails);

    /**
     * Ensures that the provided consumer is considered by this provider
     *
     * @param consumer request consumer
     */
    public abstract void setConsumer(RequestConsumer consumer);

    /**
     * Ensures that the provided consumer is not considered by this provider
     *
     * @param consumer request consumer
     */
    public abstract void unsetConsumer(RequestConsumer consumer);


    /**
     * @return true if this provider must be registered at the {@link FhirRegistry}
     * @see FhirRegistry#register(Object)
     */
    public boolean requiresRegistration() {
        return true;
    }

    /**
     * @return true if this provider must be unregistered at the {@link FhirRegistry}
     * @see FhirRegistry#unregister(Object)
     */
    public boolean requiresDeregistration() {
        return true;
    }

    /**
     * Utility method the adds HTTP servlet request parameters and query parameters to a map of Camel headers
     *
     * @param parameters         query parameters
     * @param httpServletRequest servlet request
     * @param requestDetails     request details
     * @return enriched map of parameters
     */
    protected Map<String, Object> enrichParameters(FhirSearchParameters parameters, HttpServletRequest httpServletRequest,
                                                   RequestDetails requestDetails) {
        // Populate some headers.
        var enriched = new HashMap<String, Object>();
        enriched.put(Constants.HTTP_URI, httpServletRequest.getRequestURI());
        enriched.put(Constants.HTTP_URL, httpServletRequest.getRequestURL().toString());
        enriched.put(Constants.HTTP_METHOD, httpServletRequest.getMethod());
        enriched.put(Constants.HTTP_QUERY, httpServletRequest.getQueryString());
        enriched.put(Constants.HTTP_CHARACTER_ENCODING, httpServletRequest.getCharacterEncoding());
        enriched.put(Constants.HTTP_CONTENT_TYPE, httpServletRequest.getContentType());
        enriched.put(Constants.HTTP_PROTOCOL_VERSION, httpServletRequest.getProtocol());
        enriched.put(Constants.HTTP_SCHEME, httpServletRequest.getScheme());
        enriched.put(Constants.HTTP_CLIENT_IP_ADDRESS, httpServletRequest.getRemoteAddr());
        enriched.put(Constants.HTTP_LOCALES, Collections.list(httpServletRequest.getLocales()));
        enriched.put(Constants.HTTP_USER, httpServletRequest.getUserPrincipal());

        var headers = extractHttpHeaders(httpServletRequest);
        enriched.put(Constants.HTTP_INCOMING_HEADERS, headers);

        var cipherSuite = (String) httpServletRequest.getAttribute("javax.servlet.request.cipher_suite");
        if (cipherSuite != null) {
            enriched.put(Constants.HTTP_X509_CERTIFICATES, httpServletRequest.getAttribute(X509Certificate.class.getName()));
        }

        if (parameters != null) {
            enriched.put(Constants.FHIR_REQUEST_PARAMETERS, parameters);
        }
        if (requestDetails != null) {
            enriched.put(Constants.FHIR_REQUEST_DETAILS, requestDetails);
        }
        return enriched;
    }


    /**
     * @param httpServletRequest HTTP servlet request.
     * @return A map mapping header names to list of header values.
     */
    private static Map<String, List<String>> extractHttpHeaders(HttpServletRequest httpServletRequest) {
        var result = new HashMap<String, List<String>>();
        var headerNames = httpServletRequest.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                var name = headerNames.nextElement();
                var headers = httpServletRequest.getHeaders(name);
                if (headers != null) {
                    var list = new ArrayList<String>();
                    while (headers.hasMoreElements()) {
                        list.add(headers.nextElement());
                    }
                    if (!list.isEmpty()) {
                        result.put(name, list);
                    }
                }
            }
        }
        return result;
    }
}
