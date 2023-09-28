/**
 * IntrapericardialRoute.java
 *
 * File generated from the voc::IntrapericardialRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration IntrapericardialRoute.
 *
 */

@XmlType(name = "IntrapericardialRoute")
@XmlEnum
@XmlRootElement(name = "IntrapericardialRoute")
public enum IntrapericardialRoute {
	@XmlEnumValue("IPCARDINJ")
	IPCARDINJ("IPCARDINJ");
	
	private final String value;

    IntrapericardialRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static IntrapericardialRoute fromValue(String v) {
        for (IntrapericardialRoute c: IntrapericardialRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}