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
package org.openehealth.ipf.commons.ihe.hl7v3.audit

import groovy.util.logging.Slf4j
import groovy.xml.slurpersupport.GPathResult
import org.openehealth.ipf.commons.audit.AuditContext
import org.openehealth.ipf.commons.audit.codes.EventOutcomeIndicator
import org.openehealth.ipf.commons.ihe.core.atna.AuditStrategySupport
import org.openehealth.ipf.commons.ihe.hl7v3.Hl7v3Utils

import static org.openehealth.ipf.commons.ihe.hl7v3.Hl7v3Utils.iiToCx

/**
 * @author Dmytro Rud
 */
@Slf4j
abstract class Hl7v3AuditStrategy extends AuditStrategySupport<Hl7v3AuditDataset> {

    Hl7v3AuditStrategy(boolean serverSide) {
        super(serverSide)
    }

    @Override
    Hl7v3AuditDataset createAuditDataset() {
        return new Hl7v3AuditDataset(serverSide)
    }

    /**
     * Returns ATNA response code on the basis of Acknowledgement.typeCode
     * of the HL7 v3 output message:
     * <ul>
     *   <li> when the output message cannot be parsed -- "major failure",
     *   <li> when the typeCode is missing -- "major failure",
     *   <li> when the typeCode is 'AA' or 'CA' -- "success",
     *   <li> in all other cases ('AE' and 'QE') -- "serious failure".
     * </ul>
     *
     * @param response
     *      response message as {@link GPathResult}.
     */
    @Override
    EventOutcomeIndicator getEventOutcomeIndicator(Hl7v3AuditDataset auditDataset, Object response) {
        try {
            String code = response.acknowledgement[0].typeCode.@code.text()
            if (!code) {
                // code not found -- bad XML
                return EventOutcomeIndicator.MajorFailure
            }
            return ((code == 'AA') || (code == 'CA')) ?
                    EventOutcomeIndicator.Success :
                    EventOutcomeIndicator.SeriousFailure

        } catch (Exception e) {
            log.warn('Missing or malformed response', e)
            return EventOutcomeIndicator.MajorFailure
        }
    }

    @Override
    String getEventOutcomeDescription(Hl7v3AuditDataset auditDataset, Object gpath) {
        return gpath.acknowledgement[0].acknowledgementDetail[0].@text.text()
    }

    @Override
    boolean enrichAuditDatasetFromResponse(Hl7v3AuditDataset auditDataset, Object response, AuditContext auditContext) {
        try {
            Object gpath = slurpIfNecessary(response)
            auditDataset.eventOutcomeIndicator = getEventOutcomeIndicator(auditDataset, gpath)
            auditDataset.eventOutcomeDescription = getEventOutcomeDescription(auditDataset, gpath)
            return (auditDataset.eventOutcomeIndicator == EventOutcomeIndicator.Success)
        } catch (Exception e) {
            log.warn('Missing or malformed response', e)
            return false
        }
    }

    protected static void addPatientIds(GPathResult source, Set<String> target) {
        for (node in source) {
            target << iiToCx(node)
        }
    }

    protected static GPathResult slurpIfNecessary(Object o) {
        return (o instanceof GPathResult) ? o : Hl7v3Utils.slurp((String) o)
    }
}
