/**
 * IntracervicalRoute.java
 *
 * File generated from the voc::IntracervicalRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration IntracervicalRoute.
 *
 */

@XmlType(name = "IntracervicalRoute")
@XmlEnum
@XmlRootElement(name = "IntracervicalRoute")
public enum IntracervicalRoute {
	@XmlEnumValue("IUINJC")
	IUINJC("IUINJC");
	
	private final String value;

    IntracervicalRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static IntracervicalRoute fromValue(String v) {
        for (IntracervicalRoute c: IntracervicalRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}