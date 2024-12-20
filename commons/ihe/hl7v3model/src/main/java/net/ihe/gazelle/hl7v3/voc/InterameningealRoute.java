/**
 * InterameningealRoute.java
 * <p>
 * File generated from the voc::InterameningealRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration InterameningealRoute.
 *
 */

@XmlType(name = "InterameningealRoute")
@XmlEnum
@XmlRootElement(name = "InterameningealRoute")
public enum InterameningealRoute {
	@XmlEnumValue("INTERMENINJ")
	INTERMENINJ("INTERMENINJ");
	
	private final String value;

    InterameningealRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static InterameningealRoute fromValue(String v) {
        for (InterameningealRoute c: InterameningealRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}