/**
 * SubarachnoidRoute.java
 * <p>
 * File generated from the voc::SubarachnoidRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration SubarachnoidRoute.
 *
 */

@XmlType(name = "SubarachnoidRoute")
@XmlEnum
@XmlRootElement(name = "SubarachnoidRoute")
public enum SubarachnoidRoute {
	@XmlEnumValue("SUBARACHINJ")
	SUBARACHINJ("SUBARACHINJ");
	
	private final String value;

    SubarachnoidRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static SubarachnoidRoute fromValue(String v) {
        for (SubarachnoidRoute c: SubarachnoidRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}