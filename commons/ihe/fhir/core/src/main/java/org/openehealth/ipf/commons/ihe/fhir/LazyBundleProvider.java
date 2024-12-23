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

import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.openehealth.ipf.commons.ihe.fhir.Constants.FHIR_FROM_INDEX;
import static org.openehealth.ipf.commons.ihe.fhir.Constants.FHIR_REQUEST_SIZE_ONLY;
import static org.openehealth.ipf.commons.ihe.fhir.Constants.FHIR_TO_INDEX;

/**
 * Bundle provider that requests information from the {@link RequestConsumer} on request:
 * <ul>
 * <li>If only the size of the result set is requested, the request will contain an additional empty message header named
 * {@link Constants#FHIR_REQUEST_SIZE_ONLY}, and the response is expected to populate this
 * header with the result size as integer value. The size is cached for further attempts to request the size</li>
 * <li>
 * If a subset of the result is requested, the request will contain in addition the lower and upper index in the message
 * headers {@link Constants#FHIR_FROM_INDEX} and {@link Constants#FHIR_TO_INDEX}, respectively. The response is
 * expected to contain this result subset.
 * </li>
 * </ul>
 * <p>
 * Note: instances of this class is neither thread-safe nor can they be reused across requests
 * </p>
 */
public class LazyBundleProvider extends AbstractBundleProvider {

    private static final Logger log = LoggerFactory.getLogger(LazyBundleProvider.class);

    private final boolean cacheResults;
    private int size = -1;
    private final transient List<IBaseResource> cachedResults = new ArrayList<>();
    private final transient ResultRanges resultRanges = new ResultRanges();

    /**
     * Initializes a lazy bundle provider
     *
     * @param consumer     FHIR consumer that uses ths provider
     * @param cacheResults cache results. So far, only the result set size is cached
     * @param payload      incoming payload
     * @param headers      incoming headers
     * @param httpServletResponse HTTP servlet response
     */
    public LazyBundleProvider(RequestConsumer consumer, boolean cacheResults, Object payload, Map<String, Object> headers, HttpServletResponse httpServletResponse) {
        this(consumer, cacheResults, false, payload, headers, httpServletResponse);
    }

    /**
     * Initializes a lazy bundle provider
     *
     * @param consumer     FHIR consumer that uses ths provider
     * @param cacheResults cache results. So far, only the result set size is cached
     * @param sort         sort results
     * @param payload      incoming payload
     * @param headers      incoming headers
     * @param httpServletResponse HTTP servlet response
     */
    public LazyBundleProvider(RequestConsumer consumer, boolean cacheResults, boolean sort, Object payload, Map<String, Object> headers, HttpServletResponse httpServletResponse) {
        super(consumer, sort, payload, headers, httpServletResponse);
        this.cacheResults = cacheResults;
    }

    @Override
    public @NonNull List<IBaseResource> getResources(int fromIndex, int toIndex) {
        if (!cacheResults) {
            var result = getPartialResult(fromIndex, toIndex);
            sortIfApplicable(result);
            return result;
        }
        log.debug("Cached results contain the following ranges: {}. Requesting resources from index {} to {}", resultRanges, fromIndex, toIndex);
        var wanted = Range.closedOpen(fromIndex, toIndex);
        var needed = resultRanges.required(wanted);
        log.debug("Requiring the following ranges {}", needed);
        for (var requiredRange : needed.asDescendingSetOfRanges()) {
            log.debug("Now requesting the following range {}", requiredRange);
            var results = getPartialResult(requiredRange.lowerEndpoint(), requiredRange.upperEndpoint());
            log.debug("Got back a list of size {}", results.size());
            if (!results.isEmpty()) {
                cacheAll(requiredRange.lowerEndpoint(), results);
                // Take care, potentially less elements than requested have been retrieved
                resultRanges.add(Range.closedOpen(requiredRange.lowerEndpoint(), requiredRange.lowerEndpoint() + results.size()));
            }
        }
        log.debug("Cached results now contain the following ranges: {}", resultRanges);

        // Everything went OK, return whatever we got
        return cachedResults.subList(fromIndex, Math.min(cachedResults.size(), Math.min(cachedResults.size(), toIndex)));
    }

    private List<IBaseResource> getPartialResult(int fromIndex, int toIndex) {
        var headers = getHeaders();
        headers.put(FHIR_FROM_INDEX, fromIndex);
        headers.put(FHIR_TO_INDEX, toIndex);
        return obtainResources(getPayload(), headers);
    }

    @Override
    public Integer size() {
        if (!cacheResults || size < 0) {
            var headers = getHeaders();
            headers.put(FHIR_REQUEST_SIZE_ONLY, null);
            size = getConsumer().handleSizeRequest(getPayload(), headers);
        }
        return size;
    }

    private void cacheAll(int fromIndex, List<IBaseResource> resources) {
        if (cachedResults.size() <= fromIndex) {
            for (var i = cachedResults.size(); i < fromIndex; i++) {
                log.debug("Adding null for index {}", i);
                cachedResults.add(null);
            }
            cachedResults.addAll(resources);
        } else {
            for (var i = 0; i < resources.size(); i++) {
                cachedResults.set(fromIndex + i, resources.get(i));
            }
        }
        sortIfApplicable(cachedResults);
    }

    private static class ResultRanges {

        private final RangeSet<Integer> rangeSet = TreeRangeSet.create();

        /**
         * @param wantedRange the range of elements the caller wants to retrieve
         * @return the ranges that actually need to be retrieved
         */
        public RangeSet<Integer> required(Range<Integer> wantedRange) {
            var intersection = rangeSet.subRangeSet(wantedRange);
            return TreeRangeSet.create(intersection.complement().subRangeSet(wantedRange));
        }

        public void add(Range<Integer> wantedRange) {
            rangeSet.add(wantedRange.canonical(DiscreteDomain.integers()));
        }

        @Override
        public String toString() {
            return rangeSet.toString();
        }
    }




}
