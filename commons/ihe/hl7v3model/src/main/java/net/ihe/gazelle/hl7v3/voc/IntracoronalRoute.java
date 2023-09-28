/**
 * IntracoronalRoute.java
 *
 * File generated from the voc::IntracoronalRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration IntracoronalRoute.
 *
 */

@XmlType(name = "IntracoronalRoute")
@XmlEnum
@XmlRootElement(name = "IntracoronalRoute")
public enum IntracoronalRoute {
	@XmlEnumValue("ICORONTA")
	ICORONTA("ICORONTA");
	
	private final String value;

    IntracoronalRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static IntracoronalRoute fromValue(String v) {
        for (IntracoronalRoute c: IntracoronalRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}