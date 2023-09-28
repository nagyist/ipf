/**
 * Cree.java
 *
 * File generated from the voc::Cree uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration Cree.
 *
 */

@XmlType(name = "Cree")
@XmlEnum
@XmlRootElement(name = "Cree")
public enum Cree {
	@XmlEnumValue("x-CRP")
	XCRP("x-CRP");
	
	private final String value;

    Cree(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static Cree fromValue(String v) {
        for (Cree c: Cree.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}