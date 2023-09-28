/**
 * Palaihnihan.java
 *
 * File generated from the voc::Palaihnihan uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration Palaihnihan.
 *
 */

@XmlType(name = "Palaihnihan")
@XmlEnum
@XmlRootElement(name = "Palaihnihan")
public enum Palaihnihan {
	@XmlEnumValue("x-ACH")
	XACH("x-ACH"),
	@XmlEnumValue("x-ATW")
	XATW("x-ATW");
	
	private final String value;

    Palaihnihan(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static Palaihnihan fromValue(String v) {
        for (Palaihnihan c: Palaihnihan.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}