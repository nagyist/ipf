/**
 * VaginalRoute.java
 *
 * File generated from the voc::VaginalRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration VaginalRoute.
 *
 */

@XmlType(name = "VaginalRoute")
@XmlEnum
@XmlRootElement(name = "VaginalRoute")
public enum VaginalRoute {
	@XmlEnumValue("DOUCHE")
	DOUCHE("DOUCHE"),
	@XmlEnumValue("VAGINS")
	VAGINS("VAGINS"),
	@XmlEnumValue("VAGINSI")
	VAGINSI("VAGINSI");
	
	private final String value;

    VaginalRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static VaginalRoute fromValue(String v) {
        for (VaginalRoute c: VaginalRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}