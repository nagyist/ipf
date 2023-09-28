/**
 * Pomoan.java
 *
 * File generated from the voc::Pomoan uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration Pomoan.
 *
 */

@XmlType(name = "Pomoan")
@XmlEnum
@XmlRootElement(name = "Pomoan")
public enum Pomoan {
	@XmlEnumValue("x-KJU")
	XKJU("x-KJU"),
	@XmlEnumValue("x-PEF")
	XPEF("x-PEF"),
	@XmlEnumValue("x-PEO")
	XPEO("x-PEO"),
	@XmlEnumValue("x-PEQ")
	XPEQ("x-PEQ"),
	@XmlEnumValue("x-POO")
	XPOO("x-POO");
	
	private final String value;

    Pomoan(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static Pomoan fromValue(String v) {
        for (Pomoan c: Pomoan.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}