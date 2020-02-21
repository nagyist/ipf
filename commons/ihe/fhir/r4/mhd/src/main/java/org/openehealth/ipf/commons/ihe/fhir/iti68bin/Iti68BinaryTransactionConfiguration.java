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

package org.openehealth.ipf.commons.ihe.fhir.iti68bin;

import org.openehealth.ipf.commons.ihe.core.TransactionConfiguration;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirAuditDataset;
import org.openehealth.ipf.commons.ihe.fhir.iti68.Iti68AuditDataset;
import org.openehealth.ipf.commons.ihe.fhir.iti68.Iti68ServerAuditStrategy;

/**
 * @author Christian Ohr
 * @since 3.6
 */
public class Iti68BinaryTransactionConfiguration extends TransactionConfiguration<FhirAuditDataset> {

    public Iti68BinaryTransactionConfiguration() {

        super("mhd-iti68-bin",
                "Retrieve Document",
                false,
                null,
                new Iti68BinaryServerAuditStrategy());
    }
}
