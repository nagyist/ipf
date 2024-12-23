/*
 * Copyright 2016 the original author or authors.
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

package org.openehealth.ipf.commons.ihe.fhir;

import ca.uhn.fhir.model.primitive.InstantDt;
import ca.uhn.fhir.rest.api.server.IBundleProvider;
import jakarta.servlet.http.HttpServletResponse;
import org.hl7.fhir.instance.model.api.IBaseResource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.openehealth.ipf.commons.ihe.fhir.Constants.FHIR_REQUEST_PARAMETERS;

/**
 * Base class of a {@link IBundleProvider} delegating to a {@link RequestConsumer} instance
 */
public abstract class AbstractBundleProvider implements IBundleProvider {

    private final RequestConsumer consumer;
    private final Object payload;
    private final Map<String, Object> headers;
    private final boolean sort;
    protected final HttpServletResponse httpServletResponse;

    public AbstractBundleProvider(RequestConsumer consumer, Object payload, Map<String, Object> headers, HttpServletResponse httpServletResponse) {
        this(consumer, false, payload, headers, httpServletResponse);
    }

    public AbstractBundleProvider(RequestConsumer consumer, boolean sort, Object payload, Map<String, Object> headers, HttpServletResponse httpServletResponse) {
        this.consumer = consumer;
        this.payload = payload;
        this.headers = headers;
        this.sort = sort;
        this.httpServletResponse = httpServletResponse;
    }

    @Override
    public InstantDt getPublished() {
        return InstantDt.withCurrentTime();
    }

    @Override
    public Integer preferredPageSize() {
        return null;
    }

    protected List<IBaseResource> obtainResources(Object payload, Map<String, Object> inHeaders) {
        HashMap<String, Object> outHeaders = new HashMap<>();
        List<IBaseResource> resources = consumer.handleBundleRequest(payload, inHeaders, outHeaders);
        FhirProvider.processOutHeaders(outHeaders, httpServletResponse);
        return resources;
    }

    protected RequestConsumer getConsumer() {
        return consumer;
    }

    /**
     * @return a copy of the original query parameters
     */
    protected Map<String, Object> getHeaders() {
        return new HashMap<>(headers);
    }

    protected Object getPayload() {
        return payload;
    }

    @Override
    public String getUuid() {
        return null;
    }

    @SuppressWarnings("unchecked")
    public <T extends IBaseResource> void sortIfApplicable(List<T> resources) {
        if (sort && headers.containsKey(FHIR_REQUEST_PARAMETERS)) {
            var searchParameters =  headers.get(FHIR_REQUEST_PARAMETERS);
            if (searchParameters instanceof FhirSearchAndSortParameters fhirSearchAndSortParameters) {
                fhirSearchAndSortParameters.sort(resources);
            }
        }
    }

}
