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

import lombok.Getter;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLAdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetDocumentsAndAssociationsQuery;

import static org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter.*;

/**
 * Transforms between a {@link GetDocumentsAndAssociationsQuery} and {@link EbXMLAdhocQueryRequest}.
 * @author Jens Riemschneider
 */
public class GetDocumentsAndAssociationsQueryTransformer extends GetByIDQueryTransformer<GetDocumentsAndAssociationsQuery> {

    @Getter
    private static final GetDocumentsAndAssociationsQueryTransformer instance = new GetDocumentsAndAssociationsQueryTransformer();

    /**
     * Constructs the transformer.
     */
    private GetDocumentsAndAssociationsQueryTransformer() {
        super(DOC_ENTRY_UUID, DOC_ENTRY_UNIQUE_ID);
    }


    @Override
    protected void toEbXML(GetDocumentsAndAssociationsQuery query, QuerySlotHelper slots) {
        super.toEbXML(query, slots);
        slots.fromStatus(ASSOCIATION_STATUS, query.getAssociationStatuses());
        slots.fromInteger(METADATA_LEVEL, query.getMetadataLevel());
    }

    @Override
    protected void fromEbXML(GetDocumentsAndAssociationsQuery query, QuerySlotHelper slots) {
        super.fromEbXML(query, slots);
        query.setAssociationStatuses(slots.toStatus(ASSOCIATION_STATUS));
        query.setMetadataLevel(slots.toInteger(METADATA_LEVEL));
    }

}
