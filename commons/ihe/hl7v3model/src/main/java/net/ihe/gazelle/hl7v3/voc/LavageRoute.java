/**
 * LavageRoute.java
 * <p>
 * File generated from the voc::LavageRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration LavageRoute.
 *
 */

@XmlType(name = "LavageRoute")
@XmlEnum
@XmlRootElement(name = "LavageRoute")
public enum LavageRoute {
	@XmlEnumValue("IGASTLAV")
	IGASTLAV("IGASTLAV");
	
	private final String value;

    LavageRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static LavageRoute fromValue(String v) {
        for (LavageRoute c: LavageRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}