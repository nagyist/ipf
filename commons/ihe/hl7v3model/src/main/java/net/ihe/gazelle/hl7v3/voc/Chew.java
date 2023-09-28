/**
 * Chew.java
 *
 * File generated from the voc::Chew uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration Chew.
 *
 */

@XmlType(name = "Chew")
@XmlEnum
@XmlRootElement(name = "Chew")
public enum Chew {
	@XmlEnumValue("CHEW")
	CHEW("CHEW");
	
	private final String value;

    Chew(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static Chew fromValue(String v) {
        for (Chew c: Chew.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}