package org.openehealth.ipf.commons.core;

import org.ietf.jgss.GSSException;
import org.ietf.jgss.Oid;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 */
public class URNTest {

    @Test
    public void testCorrectOID() throws URISyntaxException {
        var nss = "1.2.3.4";
        var text = "urn:OID:" + nss;
        assertTrue(URN.isURN(text));
        var urn = URN.create(text);
        assertEquals("OID", urn.getNamespaceId());
        assertTrue(urn.isNamespace(URN.OID));
        assertEquals(nss, urn.getNamespaceSpecificString());
        assertEquals(text, urn.toString());
    }

    @Test
    public void testCorrectUUID() {
        var uuid = UUID.randomUUID();
        var urn = new URN(uuid);
        assertEquals("uuid", urn.getNamespaceId());
        assertTrue(urn.isNamespace(URN.UUID));
        assertEquals(uuid.toString(), urn.getNamespaceSpecificString());
    }

    @Test
    public void testInvalidURN() {
        assertFalse(URN.isURN("blorg:oid:1234"));
        assertFalse(URN.isURN("urn:oid"));
        assertFalse(URN.isURN("1234"));
        assertFalse(URN.isURN("http://hl7.org/fhir"));
    }

    @Test
    public void testPartConstructor() throws URISyntaxException {
        var urn = new URN("isbn", "2384576256");
        assertEquals("urn:isbn:2384576256", urn.toString());
    }

    @Test
    public void testUri() throws URISyntaxException {
        var text = "urn:isbn:2384576256";
        var uri = new URI(text);
        var urn = new URN(uri);
        assertEquals(text, urn.toString());
        assertEquals(uri, urn.toURI());
    }

    @Test
    public void testEquals() throws URISyntaxException {
        assertEquals(URN.create("urn:oid:1.2.3.4"), URN.create("urn:OID:1.2.3.4"));
    }

    @Test
    public void testHashCode() throws URISyntaxException {
        var set = new HashSet<URN>();
        set.add(URN.create("urn:oid:1.2.3.4"));
        assertTrue(set.contains(URN.create("urn:OID:1.2.3.4")));
    }

    @Test
    public void testFromOid() throws GSSException, URISyntaxException {
        var oid = "2.999.2.3.2.43.54";
        assertEquals(new URN(new Oid(oid)), URN.create("urn:oid:" + oid));
    }
}
