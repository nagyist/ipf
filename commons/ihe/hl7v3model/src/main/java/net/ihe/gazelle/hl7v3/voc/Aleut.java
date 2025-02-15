/**
 * Aleut.java
 * <p>
 * File generated from the voc::Aleut uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration Aleut.
 *
 */

@XmlType(name = "Aleut")
@XmlEnum
@XmlRootElement(name = "Aleut")
public enum Aleut {
	@XmlEnumValue("x-ALW")
	XALW("x-ALW");
	
	private final String value;

    Aleut(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static Aleut fromValue(String v) {
        for (Aleut c: Aleut.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}