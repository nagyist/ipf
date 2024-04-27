/**
 * VeterinarianHIPAA.java
 *
 * File generated from the voc::VeterinarianHIPAA uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration VeterinarianHIPAA.
 *
 */

@XmlType(name = "VeterinarianHIPAA")
@XmlEnum
@XmlRootElement(name = "VeterinarianHIPAA")
public enum VeterinarianHIPAA {
	@XmlEnumValue("174MM1900N")
	_174MM1900N("174MM1900N");
	
	private final String value;

    VeterinarianHIPAA(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static VeterinarianHIPAA fromValue(String v) {
        for (VeterinarianHIPAA c: VeterinarianHIPAA.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}