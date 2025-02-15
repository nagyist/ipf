/**
 * OtherTechnologistOrTechnicianProviderHIPAA.java
 * <p>
 * File generated from the voc::OtherTechnologistOrTechnicianProviderHIPAA uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration OtherTechnologistOrTechnicianProviderHIPAA.
 *
 */

@XmlType(name = "OtherTechnologistOrTechnicianProviderHIPAA")
@XmlEnum
@XmlRootElement(name = "OtherTechnologistOrTechnicianProviderHIPAA")
public enum OtherTechnologistOrTechnicianProviderHIPAA {
	@XmlEnumValue("2472B0301N")
	_2472B0301N("2472B0301N"),
	@XmlEnumValue("2472D0500N")
	_2472D0500N("2472D0500N"),
	@XmlEnumValue("2472E0500N")
	_2472E0500N("2472E0500N"),
	@XmlEnumValue("2472R0900N")
	_2472R0900N("2472R0900N"),
	@XmlEnumValue("2472V0600N")
	_2472V0600N("2472V0600N");
	
	private final String value;

    OtherTechnologistOrTechnicianProviderHIPAA(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static OtherTechnologistOrTechnicianProviderHIPAA fromValue(String v) {
        for (OtherTechnologistOrTechnicianProviderHIPAA c: OtherTechnologistOrTechnicianProviderHIPAA.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}