/**
 * Kalapuyan.java
 * <p>
 * File generated from the voc::Kalapuyan uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration Kalapuyan.
 *
 */

@XmlType(name = "Kalapuyan")
@XmlEnum
@XmlRootElement(name = "Kalapuyan")
public enum Kalapuyan {
	@XmlEnumValue("x-KAL")
	XKAL("x-KAL");
	
	private final String value;

    Kalapuyan(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static Kalapuyan fromValue(String v) {
        for (Kalapuyan c: Kalapuyan.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}