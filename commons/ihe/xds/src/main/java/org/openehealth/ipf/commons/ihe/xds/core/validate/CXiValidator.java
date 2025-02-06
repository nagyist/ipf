/*
 * Copyright 2013 the original author or authors.
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
package org.openehealth.ipf.commons.ihe.xds.core.validate;

import org.apache.commons.lang3.BooleanUtils;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Hl7v2Based;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.ReferenceId;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.HL7ValidationUtils.isEmptyField;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.HL7ValidationUtils.isNotEmptyField;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage.CXI_INCOMPLETE_ASSIGNING_AUTHORITY;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage.CXI_NEEDS_ID_TYPE_CODE;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage.CXI_TOO_MANY_COMPONENTS;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage.CX_NEEDS_ID;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidatorAssertions.metaDataAssert;

/**
 * Validates a CXi value (special CX used for Reference IDs).
 * @author Dmytro Rud
 */
public class CXiValidator implements ValueValidator {

    private static final String XDS_VALIDATION_CP_1292_PROPERTY = "XDS_VALIDATION_CP_1292";
    private static final HDValidator HD_VALIDATOR = new HDValidator();

    @Override
    public void validate(String hl7CX) throws XDSMetaDataException {
        var referenceId = ReferenceId.parse(hl7CX);
        metaDataAssert(referenceId != null, CX_NEEDS_ID);

        var cx = referenceId.getHapiObject();

        // prohibited fields
        metaDataAssert(isEmpty(cx.getCx2_CheckDigit().getValue()), CXI_TOO_MANY_COMPONENTS);
        metaDataAssert(isEmpty(cx.getCx3_CheckDigitScheme().getValue()), CXI_TOO_MANY_COMPONENTS);
        if (isCP1292ValidationEnabled() && isNotEmptyField(cx.getCx6_AssigningFacility())) {
            HD_VALIDATOR.validate(cx.getCx6_AssigningFacility(), hl7CX);
        } else {
            metaDataAssert(isEmptyField(cx.getCx6_AssigningFacility()), CXI_TOO_MANY_COMPONENTS);
        }
        metaDataAssert(isEmpty(cx.getCx7_EffectiveDate().getValue()), CXI_TOO_MANY_COMPONENTS);
        metaDataAssert(isEmpty(cx.getCx8_ExpirationDate().getValue()), CXI_TOO_MANY_COMPONENTS);
        metaDataAssert(isEmptyField(cx.getCx9_AssigningJurisdiction()), CXI_TOO_MANY_COMPONENTS);
        metaDataAssert(isEmptyField(cx.getCx10_AssigningAgencyOrDepartment()), CXI_TOO_MANY_COMPONENTS);

        // required and optional fields
        metaDataAssert(isNotEmpty(cx.getCx1_IDNumber().getValue()), CX_NEEDS_ID, hl7CX);
        metaDataAssert(isNotEmpty(cx.getCx5_IdentifierTypeCode().getValue()), CXI_NEEDS_ID_TYPE_CODE, hl7CX);

        var assigningAuthority = cx.getCx4_AssigningAuthority();
        if (! isEmptyField(assigningAuthority)) {
            var cx41filled = isNotEmpty(assigningAuthority.getHd1_NamespaceID().getValue());
            var cx42filled = isNotEmpty(assigningAuthority.getHd2_UniversalID().getValue());
            var cx43filled = isNotEmpty(assigningAuthority.getHd3_UniversalIDType().getValue());
            metaDataAssert(cx41filled || (cx42filled && cx43filled), CXI_INCOMPLETE_ASSIGNING_AUTHORITY);
        }
    }

    private static boolean isCP1292ValidationEnabled() {
        var cp1292Value = System.getProperty(XDS_VALIDATION_CP_1292_PROPERTY, "false");
        return BooleanUtils.toBoolean(cp1292Value);
    }

}
