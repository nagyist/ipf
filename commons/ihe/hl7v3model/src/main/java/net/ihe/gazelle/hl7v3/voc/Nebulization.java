/**
 * Nebulization.java
 * <p>
 * File generated from the voc::Nebulization uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration Nebulization.
 *
 */

@XmlType(name = "Nebulization")
@XmlEnum
@XmlRootElement(name = "Nebulization")
public enum Nebulization {
	@XmlEnumValue("ETNEB")
	ETNEB("ETNEB");
	
	private final String value;

    Nebulization(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static Nebulization fromValue(String v) {
        for (Nebulization c: Nebulization.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}