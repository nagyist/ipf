/**
 * TechnicianTechnologistProviderCodes.java
 * <p>
 * File generated from the voc::TechnicianTechnologistProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration TechnicianTechnologistProviderCodes.
 *
 */

@XmlType(name = "TechnicianTechnologistProviderCodes")
@XmlEnum
@XmlRootElement(name = "TechnicianTechnologistProviderCodes")
public enum TechnicianTechnologistProviderCodes {
	@XmlEnumValue("156F00000X")
	_156F00000X("156F00000X"),
	@XmlEnumValue("156FC0800X")
	_156FC0800X("156FC0800X"),
	@XmlEnumValue("156FC0801X")
	_156FC0801X("156FC0801X"),
	@XmlEnumValue("156FX1100X")
	_156FX1100X("156FX1100X"),
	@XmlEnumValue("156FX1101X")
	_156FX1101X("156FX1101X"),
	@XmlEnumValue("156FX1201X")
	_156FX1201X("156FX1201X"),
	@XmlEnumValue("156FX1202X")
	_156FX1202X("156FX1202X"),
	@XmlEnumValue("156FX1700X")
	_156FX1700X("156FX1700X"),
	@XmlEnumValue("156FX1800X")
	_156FX1800X("156FX1800X"),
	@XmlEnumValue("156FX1900X")
	_156FX1900X("156FX1900X");
	
	private final String value;

    TechnicianTechnologistProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static TechnicianTechnologistProviderCodes fromValue(String v) {
        for (TechnicianTechnologistProviderCodes c: TechnicianTechnologistProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}