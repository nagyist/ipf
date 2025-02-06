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
package org.openehealth.ipf.commons.ihe.xds.core.transform.ebxml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssigningAuthority;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Hl7v2Based;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for transformation between HL7 v2 and {@link Identifiable}.
 * @author Jens Riemschneider
 */
public class IdentifiableTransformerTest {
    private Identifiable identifiable;
    
    @BeforeEach
    public void setUp() {
        var assigningAuthority = new AssigningAuthority();
        assigningAuthority.setUniversalId("uni");
        assigningAuthority.setUniversalIdType("uniType");
        
        identifiable = new Identifiable();
        identifiable.setId("21&3");
        identifiable.setAssigningAuthority(assigningAuthority);
    }
    
    @Test
    public void testToEbXML21SourcePatient() {
        var result = Hl7v2Based.render(identifiable);
        assertNotNull(result);
        
        assertEquals("21\\T\\3^^^&uni&uniType", result);
    }

    @Test
    public void testToEbXML21SourcePatientNull() {
        assertNull(Hl7v2Based.render(null));
    }

    @Test
    public void testToEbXML21SourcePatientEmpty() {
        var result = Hl7v2Based.render(new Identifiable());
        assertNull(result);
    }

    @Test
    public void testFromEbXML21SourcePatient() {
        var ebXML = Hl7v2Based.render(identifiable);
        var result = Identifiable.parse(ebXML);
        assertNotNull(result);
        
        assertEquals("21&3", result.getId());

        var assigningAuthority = result.getAssigningAuthority();
        assertEquals("uni", assigningAuthority.getUniversalId());
        assertEquals("uniType", assigningAuthority.getUniversalIdType());
    }
    
    @Test
    public void testFromEbXML21SourcePatientNull() {
        assertNull(Identifiable.parse(null));
    }
    
    @Test
    public void testFromEbXML21SourcePatientEmpty() {
        var result = Identifiable.parse("");
        assertNull(result);
    }
}
