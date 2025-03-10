/**
 * Transdermal.java
 * <p>
 * File generated from the voc::Transdermal uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration Transdermal.
 *
 */

@XmlType(name = "Transdermal")
@XmlEnum
@XmlRootElement(name = "Transdermal")
public enum Transdermal {
	@XmlEnumValue("TRNSDERMD")
	TRNSDERMD("TRNSDERMD");
	
	private final String value;

    Transdermal(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static Transdermal fromValue(String v) {
        for (Transdermal c: Transdermal.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}