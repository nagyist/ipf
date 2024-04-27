/**
 * PerineuralRoute.java
 *
 * File generated from the voc::PerineuralRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration PerineuralRoute.
 *
 */

@XmlType(name = "PerineuralRoute")
@XmlEnum
@XmlRootElement(name = "PerineuralRoute")
public enum PerineuralRoute {
	@XmlEnumValue("PNINJ")
	PNINJ("PNINJ");
	
	private final String value;

    PerineuralRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static PerineuralRoute fromValue(String v) {
        for (PerineuralRoute c: PerineuralRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}