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
import lombok.ToString;

import jakarta.xml.bind.annotation.*;

import java.io.Serial;

/**
 * Represents a stored query for FindDispensesQuery (PHARM-1).
 * @author Quentin Ligier
 * @since 3.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindDispensesQuery", propOrder = {})
@XmlRootElement(name = "findDispensesQuery")
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, doNotUseGetters = true)
public class FindDispensesQuery extends PharmacyStableDocumentsQuery {
    @Serial
    private static final long serialVersionUID = -8924928000145710050L;

    /**
     * Constructs the query.
     */
    public FindDispensesQuery() {
        super(QueryType.FIND_DISPENSES);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
