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
package org.openehealth.ipf.commons.ihe.xds.core.requests.query;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.*;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.QuerySlotHelper;

import jakarta.xml.bind.annotation.*;

import java.io.Serial;
import java.util.List;

/**
 * Abstract stored query for PHARM-1 stable documents queries.
 * @author Quentin Ligier
 * @since 3.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PharmacyStableDocumentsQuery", propOrder = {
        "authorPersons", "creationTime", "serviceStartTime", "serviceStopTime",
        "confidentialityCodes", "eventCodes", "uuids", "healthcareFacilityTypeCodes",
        "practiceSettingCodes", "uniqueIds"})
@XmlRootElement(name = "abstractPharm1StableDocumentsQuery")
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, doNotUseGetters = true)
public abstract class PharmacyStableDocumentsQuery extends PharmacyDocumentsQuery {
    @Serial
    private static final long serialVersionUID = 7497052735222205532L;

    @XmlElement(name = "uuid")
    @Getter @Setter private List<String> uuids;
    @XmlElement(name = "uniqueId")
    @Getter @Setter private List<String> uniqueIds;
    @XmlElement(name = "practiceSettingCode")
    @Getter @Setter private List<Code> practiceSettingCodes;
    @Getter private final TimeRange creationTime = new TimeRange();
    @Getter private final TimeRange serviceStartTime = new TimeRange();
    @Getter private final TimeRange serviceStopTime = new TimeRange();
    @XmlElement(name = "healthcareFacilityTypeCode")
    @Getter @Setter private List<Code> healthcareFacilityTypeCodes;
    @XmlElement(name = "eventCode")
    @Getter @Setter private List<Code> eventCodes;
    @XmlElement(name = "confidentialityCode")
    @Getter @Setter private List<Code> confidentialityCodes;
    @XmlElement(name = "authorPerson")
    @Getter @Setter private List<String> authorPersons;

    /**
     * For JAXB serialization only.
     */
    public PharmacyStableDocumentsQuery() {
    }

    /**
     * Constructs the query.
     * @param queryType
     *          the type of the query.
     */
    protected PharmacyStableDocumentsQuery(final QueryType queryType) {
        super(queryType);
    }

    /**
     * Allows to use a collection of {@link Person} instead of a collection of {@link String}
     * for specifying the query parameter "$XDSDocumentEntryAuthorPerson".
     *
     * @param authorPersons a collection of {@link Person} objects.
     */
    public void setTypedAuthorPersons(List<Person> authorPersons) {
        this.authorPersons = QuerySlotHelper.render(authorPersons);
    }

    /**
     * Tries to return the query parameter "$XDSDocumentEntryAuthorPerson"
     * as a collection of {@link Person} instead of a collection of {@link String}.
     * This may fail if SQL LIKE wildcards ("%", "_", etc.) are used in one or more elements.
     *
     * @return a collection of {@link Person} objects.
     */
    public List<Person> getTypedAuthorPersons() {
        return QuerySlotHelper.parse(this.authorPersons, Person.class);
    }
}
