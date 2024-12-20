/**
 * Grandparent.java
 * <p>
 * File generated from the voc::Grandparent uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration Grandparent.
 *
 */

@XmlType(name = "Grandparent")
@XmlEnum
@XmlRootElement(name = "Grandparent")
public enum Grandparent {
	@XmlEnumValue("GRFTH")
	GRFTH("GRFTH"),
	@XmlEnumValue("GRMTH")
	GRMTH("GRMTH"),
	@XmlEnumValue("GRPRN")
	GRPRN("GRPRN"),
	@XmlEnumValue("MGRFTH")
	MGRFTH("MGRFTH"),
	@XmlEnumValue("MGRMTH")
	MGRMTH("MGRMTH"),
	@XmlEnumValue("MGRPRN")
	MGRPRN("MGRPRN"),
	@XmlEnumValue("PGRFTH")
	PGRFTH("PGRFTH"),
	@XmlEnumValue("PGRMTH")
	PGRMTH("PGRMTH"),
	@XmlEnumValue("PGRPRN")
	PGRPRN("PGRPRN");
	
	private final String value;

    Grandparent(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static Grandparent fromValue(String v) {
        for (Grandparent c: Grandparent.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}