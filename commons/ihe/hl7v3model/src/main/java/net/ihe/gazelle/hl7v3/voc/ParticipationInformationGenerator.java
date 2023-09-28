/**
 * ParticipationInformationGenerator.java
 *
 * File generated from the voc::ParticipationInformationGenerator uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ParticipationInformationGenerator.
 *
 */

@XmlType(name = "ParticipationInformationGenerator")
@XmlEnum
@XmlRootElement(name = "ParticipationInformationGenerator")
public enum ParticipationInformationGenerator {
	@XmlEnumValue("AUT")
	AUT("AUT"),
	@XmlEnumValue("ENT")
	ENT("ENT"),
	@XmlEnumValue("INF")
	INF("INF"),
	@XmlEnumValue("TRANS")
	TRANS("TRANS"),
	@XmlEnumValue("WIT")
	WIT("WIT");
	
	private final String value;

    ParticipationInformationGenerator(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ParticipationInformationGenerator fromValue(String v) {
        for (ParticipationInformationGenerator c: ParticipationInformationGenerator.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}