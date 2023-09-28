/**
 * InteriorSalish.java
 *
 * File generated from the voc::InteriorSalish uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration InteriorSalish.
 *
 */

@XmlType(name = "InteriorSalish")
@XmlEnum
@XmlRootElement(name = "InteriorSalish")
public enum InteriorSalish {
	@XmlEnumValue("x-COL")
	XCOL("x-COL"),
	@XmlEnumValue("x-CRD")
	XCRD("x-CRD"),
	@XmlEnumValue("x-FLA")
	XFLA("x-FLA"),
	@XmlEnumValue("x-OKA")
	XOKA("x-OKA");
	
	private final String value;

    InteriorSalish(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static InteriorSalish fromValue(String v) {
        for (InteriorSalish c: InteriorSalish.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}