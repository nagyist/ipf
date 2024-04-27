/**
 * IntrasinalRoute.java
 *
 * File generated from the voc::IntrasinalRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration IntrasinalRoute.
 *
 */

@XmlType(name = "IntrasinalRoute")
@XmlEnum
@XmlRootElement(name = "IntrasinalRoute")
public enum IntrasinalRoute {
	@XmlEnumValue("ISININSTIL")
	ISININSTIL("ISININSTIL");
	
	private final String value;

    IntrasinalRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static IntrasinalRoute fromValue(String v) {
        for (IntrasinalRoute c: IntrasinalRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}