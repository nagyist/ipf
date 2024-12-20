/**
 * EyeAndVisionServiceProviderTechnicianAndOrTechnologistHIPAA.java
 * <p>
 * File generated from the voc::EyeAndVisionServiceProviderTechnicianAndOrTechnologistHIPAA uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration EyeAndVisionServiceProviderTechnicianAndOrTechnologistHIPAA.
 *
 */

@XmlType(name = "EyeAndVisionServiceProviderTechnicianAndOrTechnologistHIPAA")
@XmlEnum
@XmlRootElement(name = "EyeAndVisionServiceProviderTechnicianAndOrTechnologistHIPAA")
public enum EyeAndVisionServiceProviderTechnicianAndOrTechnologistHIPAA {
	@XmlEnumValue("156FC0800N")
	_156FC0800N("156FC0800N"),
	@XmlEnumValue("156FC0801N")
	_156FC0801N("156FC0801N"),
	@XmlEnumValue("156FX1100N")
	_156FX1100N("156FX1100N"),
	@XmlEnumValue("156FX1101N")
	_156FX1101N("156FX1101N"),
	@XmlEnumValue("156FX1201N")
	_156FX1201N("156FX1201N"),
	@XmlEnumValue("156FX1202N")
	_156FX1202N("156FX1202N"),
	@XmlEnumValue("156FX1700N")
	_156FX1700N("156FX1700N"),
	@XmlEnumValue("156FX1800N")
	_156FX1800N("156FX1800N"),
	@XmlEnumValue("156FX1900N")
	_156FX1900N("156FX1900N");
	
	private final String value;

    EyeAndVisionServiceProviderTechnicianAndOrTechnologistHIPAA(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static EyeAndVisionServiceProviderTechnicianAndOrTechnologistHIPAA fromValue(String v) {
        for (EyeAndVisionServiceProviderTechnicianAndOrTechnologistHIPAA c: EyeAndVisionServiceProviderTechnicianAndOrTechnologistHIPAA.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}