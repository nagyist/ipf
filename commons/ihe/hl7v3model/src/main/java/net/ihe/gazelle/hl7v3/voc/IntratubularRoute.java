/**
 * IntratubularRoute.java
 *
 * File generated from the voc::IntratubularRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration IntratubularRoute.
 *
 */

@XmlType(name = "IntratubularRoute")
@XmlEnum
@XmlRootElement(name = "IntratubularRoute")
public enum IntratubularRoute {
	@XmlEnumValue("ITUBINJ")
	ITUBINJ("ITUBINJ");
	
	private final String value;

    IntratubularRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static IntratubularRoute fromValue(String v) {
        for (IntratubularRoute c: IntratubularRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}