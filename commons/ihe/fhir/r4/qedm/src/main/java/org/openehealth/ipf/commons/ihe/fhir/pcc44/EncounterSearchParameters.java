/*
 * Copyright 2018 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.openehealth.ipf.commons.ihe.fhir.pcc44;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.Include;
import ca.uhn.fhir.rest.api.SortSpec;
import ca.uhn.fhir.rest.param.DateRangeParam;
import ca.uhn.fhir.rest.param.ReferenceParam;
import ca.uhn.fhir.rest.param.TokenParam;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hl7.fhir.r4.model.Encounter;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

import static java.util.Comparator.*;

/**
 * @author Christian Ohr
 * @since 3.6
 */

@ToString
public class EncounterSearchParameters extends Pcc44CommonSearchParameters<Encounter> {

    @Getter @Setter
    private DateRangeParam date;

    @Builder
    EncounterSearchParameters(DateRangeParam date,
                              ReferenceParam patientReference,
                              TokenParam _id,
                              SortSpec sortSpec,
                              Set<Include> includeSpec,
                              Set<Include> revIncludeSpec,
                              FhirContext fhirContext) {
        super(patientReference, _id, sortSpec, includeSpec, revIncludeSpec, fhirContext);
        this.date = date;
    }

    @Override
    protected Optional<Comparator<Encounter>> comparatorFor(String paramName) {
        return Encounter.SP_DATE.equals(paramName) ?
            Optional.of(CP_PERIOD) :
            Optional.empty();
    }

    private static final Comparator<Encounter> CP_PERIOD = comparing(
        encounter -> !encounter.hasPeriod() ? null : encounter.getPeriod().getStart(),
        nullsLast(naturalOrder()));
}
