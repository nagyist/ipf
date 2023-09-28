/**
 * CardiologySpecialistOrTechnologistHIPAA.java
 *
 * File generated from the voc::CardiologySpecialistOrTechnologistHIPAA uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration CardiologySpecialistOrTechnologistHIPAA.
 *
 */

@XmlType(name = "CardiologySpecialistOrTechnologistHIPAA")
@XmlEnum
@XmlRootElement(name = "CardiologySpecialistOrTechnologistHIPAA")
public enum CardiologySpecialistOrTechnologistHIPAA {
	@XmlEnumValue("246VC0100N")
	_246VC0100N("246VC0100N"),
	@XmlEnumValue("246VC2400N")
	_246VC2400N("246VC2400N"),
	@XmlEnumValue("246VC2901N")
	_246VC2901N("246VC2901N"),
	@XmlEnumValue("246VC2902N")
	_246VC2902N("246VC2902N"),
	@XmlEnumValue("246VC2903N")
	_246VC2903N("246VC2903N"),
	@XmlEnumValue("246VP3600N")
	_246VP3600N("246VP3600N"),
	@XmlEnumValue("246VS1301N")
	_246VS1301N("246VS1301N"),
	@XmlEnumValue("246VV0100N")
	_246VV0100N("246VV0100N");
	
	private final String value;

    CardiologySpecialistOrTechnologistHIPAA(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static CardiologySpecialistOrTechnologistHIPAA fromValue(String v) {
        for (CardiologySpecialistOrTechnologistHIPAA c: CardiologySpecialistOrTechnologistHIPAA.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}