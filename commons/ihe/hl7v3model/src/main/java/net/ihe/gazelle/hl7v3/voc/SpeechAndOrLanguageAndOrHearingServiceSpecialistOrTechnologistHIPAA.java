/**
 * SpeechAndOrLanguageAndOrHearingServiceSpecialistOrTechnologistHIPAA.java
 * <p>
 * File generated from the voc::SpeechAndOrLanguageAndOrHearingServiceSpecialistOrTechnologistHIPAA uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration SpeechAndOrLanguageAndOrHearingServiceSpecialistOrTechnologistHIPAA.
 *
 */

@XmlType(name = "SpeechAndOrLanguageAndOrHearingServiceSpecialistOrTechnologistHIPAA")
@XmlEnum
@XmlRootElement(name = "SpeechAndOrLanguageAndOrHearingServiceSpecialistOrTechnologistHIPAA")
public enum SpeechAndOrLanguageAndOrHearingServiceSpecialistOrTechnologistHIPAA {
	@XmlEnumValue("2355A2700N")
	_2355A2700N("2355A2700N"),
	@XmlEnumValue("2355S0801N")
	_2355S0801N("2355S0801N");
	
	private final String value;

    SpeechAndOrLanguageAndOrHearingServiceSpecialistOrTechnologistHIPAA(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static SpeechAndOrLanguageAndOrHearingServiceSpecialistOrTechnologistHIPAA fromValue(String v) {
        for (SpeechAndOrLanguageAndOrHearingServiceSpecialistOrTechnologistHIPAA c: SpeechAndOrLanguageAndOrHearingServiceSpecialistOrTechnologistHIPAA.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}