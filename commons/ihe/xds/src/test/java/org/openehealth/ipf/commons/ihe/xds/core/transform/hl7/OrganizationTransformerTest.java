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
package org.openehealth.ipf.commons.ihe.xds.core.transform.hl7;

import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssigningAuthority;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Hl7v2Based;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Tests for transformation between HL7 v2 and {@link Organization}.
 * @author Jens Riemschneider
 */
public class OrganizationTransformerTest {
    @Test
    public void testToHL7() {
        var assigningAuthority = new AssigningAuthority();
        assigningAuthority.setUniversalId("1.2&.3.4");
        assigningAuthority.setUniversalIdType("he&llo_WU&RZ");

        var organization = new Organization();
        organization.setOrganizationName("Untere&Klinik");
        organization.setIdNumber("a|number");
        organization.setAssigningAuthority(assigningAuthority);
        
        assertEquals("Untere\\T\\Klinik^^^^^&1.2\\T\\.3.4&he\\T\\llo_WU\\T\\RZ^^^^a\\F\\number",
                Hl7v2Based.render(organization));
    }

    @Test
    public void testToHL7Empty() {
        assertNull(Hl7v2Based.render(new Organization()));
    }


    @Test
    public void testFromHL7() {
        var organization = Organization.parse(
                "Untere\\T\\Klinik^^^^^he\\T\\llo&1.2\\T\\.3.4&WU\\T\\RZ^^^^a\\F\\number");

        assertEquals("Untere&Klinik", organization.getOrganizationName());
        assertEquals("a|number", organization.getIdNumber());
        assertEquals("1.2&.3.4", organization.getAssigningAuthority().getUniversalId());
        assertEquals("WU&RZ", organization.getAssigningAuthority().getUniversalIdType());
    }

    @Test
    public void testFromHL7WithNullParam() {
        assertNull(Organization.parse(null));
    }    

    @Test
    public void testFromHL7WithEmptyParam() {
        assertNull(Organization.parse(""));
    }    
}
