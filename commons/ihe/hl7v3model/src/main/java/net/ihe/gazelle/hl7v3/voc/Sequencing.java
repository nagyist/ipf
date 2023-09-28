/**
 * Sequencing.java
 *
 * File generated from the voc::Sequencing uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration Sequencing.
 *
 */

@XmlType(name = "Sequencing")
@XmlEnum
@XmlRootElement(name = "Sequencing")
public enum Sequencing {
	@XmlEnumValue("A")
	A("A"),
	@XmlEnumValue("D")
	D("D"),
	@XmlEnumValue("N")
	N("N");
	
	private final String value;

    Sequencing(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static Sequencing fromValue(String v) {
        for (Sequencing c: Sequencing.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}