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
package org.openehealth.ipf.commons.ihe.xds.core.requests.query;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.*;

import jakarta.xml.bind.annotation.*;

import java.io.Serial;
import java.util.List;

/**
 * Represents a stored query for FindSubmissionSets.
 * @author Jens Riemschneider
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindSubmissionSetsQuery", propOrder = {
        "status", "sourceIds", "authorPerson", "submissionTime", "contentTypeCodes", "patientId", "targetCommunityIds"})
@XmlRootElement(name = "findSubmissionSetsQuery")
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, doNotUseGetters = true)
public class FindSubmissionSetsQuery extends StoredQuery implements PatientIdBasedStoredQuery, TargetCommunityIdListBasedStoredQuery {
    @Serial
    private static final long serialVersionUID = 1712346604151312305L;

    @Getter @Setter private List<AvailabilityStatus> status;
    @XmlElement(name = "sourceId")
    @Getter @Setter private List<String> sourceIds;
    @XmlElement(name = "contentTypeCode")
    @Getter @Setter private List<Code> contentTypeCodes;
    @Getter @Setter private String authorPerson;
    @Getter @Setter private Identifiable patientId;
    @Getter @Setter private List<String> targetCommunityIds;

    @Getter private final TimeRange submissionTime = new TimeRange();

    /**
     * Constructs the query.
     */
    public FindSubmissionSetsQuery() {
        super(QueryType.FIND_SUBMISSION_SETS);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * Allows to use a {@link Person} instead of a {@link String}
     * for specifying the query parameter "$XDSSubmissionSetAuthorPerson".
     *
     * @param authorPerson a {@link Person} object.
     */
    public void setTypedAuthorPerson(Person authorPerson) {
        this.authorPerson = Hl7v2Based.render(authorPerson);
    }

    /**
     * Tries to return the query parameter "$XDSSubmissionSetAuthorPerson"
     * as a {@link Person} instead of a {@link String}.
     * This may fail if SQL LIKE wildcards ("%", "_", etc.) are used.
     *
     * @return a {@link Person} object.
     */
    public Person getTypedAuthorPerson() {
        return Hl7v2Based.parse(this.authorPerson, Person.class);
    }

}
