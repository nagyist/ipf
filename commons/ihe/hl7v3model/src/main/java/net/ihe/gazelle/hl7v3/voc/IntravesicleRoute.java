/**
 * IntravesicleRoute.java
 * <p>
 * File generated from the voc::IntravesicleRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration IntravesicleRoute.
 *
 */

@XmlType(name = "IntravesicleRoute")
@XmlEnum
@XmlRootElement(name = "IntravesicleRoute")
public enum IntravesicleRoute {
	@XmlEnumValue("IVESINJ")
	IVESINJ("IVESINJ");
	
	private final String value;

    IntravesicleRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static IntravesicleRoute fromValue(String v) {
        for (IntravesicleRoute c: IntravesicleRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}