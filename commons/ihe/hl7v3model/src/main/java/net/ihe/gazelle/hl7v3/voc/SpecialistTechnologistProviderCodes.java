/**
 * SpecialistTechnologistProviderCodes.java
 *
 * File generated from the voc::SpecialistTechnologistProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration SpecialistTechnologistProviderCodes.
 *
 */

@XmlType(name = "SpecialistTechnologistProviderCodes")
@XmlEnum
@XmlRootElement(name = "SpecialistTechnologistProviderCodes")
public enum SpecialistTechnologistProviderCodes {
	@XmlEnumValue("225500000X")
	_225500000X("225500000X"),
	@XmlEnumValue("2255A2300X")
	_2255A2300X("2255A2300X"),
	@XmlEnumValue("2255R0406X")
	_2255R0406X("2255R0406X");
	
	private final String value;

    SpecialistTechnologistProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static SpecialistTechnologistProviderCodes fromValue(String v) {
        for (SpecialistTechnologistProviderCodes c: SpecialistTechnologistProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}