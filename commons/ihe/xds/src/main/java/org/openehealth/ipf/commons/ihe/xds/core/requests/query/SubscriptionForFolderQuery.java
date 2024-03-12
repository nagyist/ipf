/*
 * Copyright 2023 the original author or authors.
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
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Code;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Represents a stored query for SubscriptionFilterQuery used for ITI-52 filters
 * @author Christian Ohr
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriptionForFolderQuery", propOrder = {"patientId", "codes", "logicalUuid"})
@XmlRootElement(name = "subscriptionForFolderQuery")
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, doNotUseGetters = true)
public class SubscriptionForFolderQuery extends GetByIdQuery implements PatientIdBasedStoredQuery {
    private static final long serialVersionUID = -5765363916663583605L;

    @Getter @Setter private Identifiable patientId;
    @XmlElement(name = "code")
    @Getter @Setter private QueryList<Code> codes;
    @Getter @Setter private List<String> logicalUuid;

    /**
     * Constructs the query.
     */
    public SubscriptionForFolderQuery() {
        super(QueryType.SUBSCRIPTION_FOR_FOLDER);
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
