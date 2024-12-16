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

import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.gclient.IClientExecutable;
import ca.uhn.fhir.rest.gclient.ICriterion;
import ca.uhn.fhir.rest.gclient.IQuery;
import org.hl7.fhir.instance.model.api.IBaseBundle;
import org.hl7.fhir.instance.model.api.IBaseResource;

import java.util.Map;

/**
 * @author Christian Ohr
 * @since 3.2
 */
public class QueryClientRequestFactory<T extends IBaseBundle> implements ClientRequestFactory<IQuery<T>> {

    private final Class<? extends IBaseResource> type;
    private final Class<T> bundleType;

    public QueryClientRequestFactory(Class<? extends IBaseResource> type, Class<T> bundleType) {
        this.type = type;
        this.bundleType = bundleType;
    }

    @Override
    public IClientExecutable<IQuery<T>, T> getClientExecutable(IGenericClient client, Object requestData, Map<String, Object> parameters) {
        IQuery<IBaseBundle> query;
        if (requestData instanceof ICriterion criterion) {
            query = client.search()
                    .forResource(type)
                    .where(criterion);
        } else if (requestData instanceof ICriterion[] criteria) {
            query = client.search()
                    .forResource(type);
            if (criteria.length > 0) {
                query = query.where(criteria[0]);
                if (criteria.length > 1) {
                    for (var i = 1; i < criteria.length; i++) {
                        query = query.and(criteria[i]);
                    }
                }
            }
        } else {
            query = client.search().byUrl(requestData.toString());
        }
        if (parameters.containsKey(Constants.FHIR_COUNT)) {
            query.count(Integer.parseInt(parameters.get(Constants.FHIR_COUNT).toString()));
        }
        return query.returnBundle(bundleType);
    }
}
