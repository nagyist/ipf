/*
 * Copyright 2020 the original author or authors.
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

import org.openehealth.ipf.commons.ihe.xds.core.requests.query.PharmacyStableDocumentsQuery;

import static org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter.*;

/**
 * Base transformations for all stable-documents PHARM-1 queries.
 * @author Quentin Ligier
 * @since 3.7
 */
abstract class PharmacyStableDocumentsQueryTransformer<T extends PharmacyStableDocumentsQuery> extends PharmacyDocumentsQueryTransformer<T> {


    @Override
    protected void toEbXML(T query, QuerySlotHelper slots) {
        super.toEbXML(query, slots);
        slots.fromStringList(DOC_ENTRY_AUTHOR_PERSON, query.getAuthorPersons());
        slots.fromStringList(DOC_ENTRY_UUID, query.getUuids());
        slots.fromStringList(DOC_ENTRY_UNIQUE_ID, query.getUniqueIds());
        slots.fromTimestamp(DOC_ENTRY_CREATION_TIME_FROM, query.getCreationTime().getFrom());
        slots.fromTimestamp(DOC_ENTRY_CREATION_TIME_TO, query.getCreationTime().getTo());
        slots.fromCode(DOC_ENTRY_HEALTHCARE_FACILITY_TYPE_CODE, query.getHealthcareFacilityTypeCodes());
        slots.fromCode(DOC_ENTRY_PRACTICE_SETTING_CODE, query.getPracticeSettingCodes());
        slots.fromCode(DOC_ENTRY_EVENT_CODE, query.getEventCodes());
        slots.fromCode(DOC_ENTRY_CONFIDENTIALITY_CODE, query.getConfidentialityCodes());
        slots.fromTimestamp(DOC_ENTRY_SERVICE_START_TIME_FROM, query.getServiceStartTime().getFrom());
        slots.fromTimestamp(DOC_ENTRY_SERVICE_START_TIME_TO, query.getServiceStartTime().getTo());
        slots.fromTimestamp(DOC_ENTRY_SERVICE_STOP_TIME_FROM, query.getServiceStopTime().getFrom());
        slots.fromTimestamp(DOC_ENTRY_SERVICE_STOP_TIME_TO, query.getServiceStopTime().getTo());
    }

    @Override
    protected void fromEbXML(T query, QuerySlotHelper slots) {
        super.fromEbXML(query, slots);
        query.setAuthorPersons(slots.toStringList(DOC_ENTRY_AUTHOR_PERSON));
        query.setConfidentialityCodes(slots.toCodeList(DOC_ENTRY_CONFIDENTIALITY_CODE));
        query.getCreationTime().setFrom(slots.toTimestamp(DOC_ENTRY_CREATION_TIME_FROM));
        query.getCreationTime().setTo(slots.toTimestamp(DOC_ENTRY_CREATION_TIME_TO));
        query.setEventCodes(slots.toCodeList(DOC_ENTRY_EVENT_CODE));
        query.setHealthcareFacilityTypeCodes(slots.toCodeList(DOC_ENTRY_HEALTHCARE_FACILITY_TYPE_CODE));
        query.setPracticeSettingCodes(slots.toCodeList(DOC_ENTRY_PRACTICE_SETTING_CODE));
        query.setUniqueIds(slots.toStringList(DOC_ENTRY_UNIQUE_ID));
        query.setUuids(slots.toStringList(DOC_ENTRY_UUID));
        query.getServiceStartTime().setFrom(slots.toTimestamp(DOC_ENTRY_SERVICE_START_TIME_FROM));
        query.getServiceStartTime().setTo(slots.toTimestamp(DOC_ENTRY_SERVICE_START_TIME_TO));
        query.getServiceStopTime().setFrom(slots.toTimestamp(DOC_ENTRY_SERVICE_STOP_TIME_FROM));
        query.getServiceStopTime().setTo(slots.toTimestamp(DOC_ENTRY_SERVICE_STOP_TIME_TO));
    }
}
