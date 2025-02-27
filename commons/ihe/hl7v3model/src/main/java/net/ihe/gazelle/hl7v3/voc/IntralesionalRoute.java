/**
 * IntralesionalRoute.java
 * <p>
 * File generated from the voc::IntralesionalRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration IntralesionalRoute.
 *
 */

@XmlType(name = "IntralesionalRoute")
@XmlEnum
@XmlRootElement(name = "IntralesionalRoute")
public enum IntralesionalRoute {
	@XmlEnumValue("ILESINJ")
	ILESINJ("ILESINJ"),
	@XmlEnumValue("ILESIRR")
	ILESIRR("ILESIRR"),
	@XmlEnumValue("ILTOP")
	ILTOP("ILTOP");
	
	private final String value;

    IntralesionalRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static IntralesionalRoute fromValue(String v) {
        for (IntralesionalRoute c: IntralesionalRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}