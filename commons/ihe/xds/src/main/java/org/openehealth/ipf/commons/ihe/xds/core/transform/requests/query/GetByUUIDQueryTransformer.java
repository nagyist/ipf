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
package org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query;

import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLAdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetByUuidQuery;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter;

import static java.util.Objects.requireNonNull;

/**
 * Base class of transformers for {@link GetByUuidQuery}.
 * @param <T>
 *          type of the query.
 * @author Jens Riemschneider
 */
public abstract class GetByUUIDQueryTransformer<T extends GetByUuidQuery> extends AbstractStoredQueryTransformer<T> {
    private final QueryParameter uuidParam;

    /**
     * Constructs the transformer.
     * @param uuidParam
     *          the parameter name of the UUID parameter.
     */
    protected GetByUUIDQueryTransformer(QueryParameter uuidParam) {
        this.uuidParam = requireNonNull(uuidParam, "uuidParam cannot be null");
    }

    /**
     * Transforms the query into its ebXML representation.
     * <p>
     * Does not perform any transformation if one of the parameters is <code>null</code>.
     * @param query
     *          the query. Can be <code>null</code>.
     * @param ebXML
     *          the ebXML representation. Can be <code>null</code>.
     */
    @Override
    public void toEbXML(T query, EbXMLAdhocQueryRequest ebXML) {
        if (query == null || ebXML == null) {
            return;
        }

        super.toEbXML(query, ebXML);

        var slots = new QuerySlotHelper(ebXML);
        slots.fromStringList(uuidParam, query.getUuids());

        toEbXML(query, slots);
    }

    /**
     * Transforms the ebXML representation of a query into a query object.
     * <p>
     * Does not perform any transformation if one of the parameters is <code>null</code>.
     * @param query
     *          the query. Can be <code>null</code>.
     * @param ebXML
     *          the ebXML representation. Can be <code>null</code>.
     */
   @Override
public void fromEbXML(T query, EbXMLAdhocQueryRequest ebXML) {
        if (query == null || ebXML == null) {
            return;
        }

        super.fromEbXML(query, ebXML);

        var slots = new QuerySlotHelper(ebXML);
        query.setUuids(slots.toStringList(uuidParam));

        fromEbXML(query, slots);
    }

    /**
     * Called by {@link #toEbXML(GetByUuidQuery, EbXMLAdhocQueryRequest)} to
     * transform slots.
     * @param query
     *          the query to transform.
     * @param slots
     *          the slots to be filled.
     */
    protected void toEbXML(T query, QuerySlotHelper slots) {}

    /**
     * Called by {@link #fromEbXML(GetByUuidQuery, EbXMLAdhocQueryRequest)} to
     * transform slots.
     * @param query
     *          the target query.
     * @param slots
     *          the slots to transform.
     */
    protected void fromEbXML(T query, QuerySlotHelper slots) {}
}
