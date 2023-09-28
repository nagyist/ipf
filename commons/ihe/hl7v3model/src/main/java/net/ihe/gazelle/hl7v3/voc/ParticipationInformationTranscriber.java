/**
 * ParticipationInformationTranscriber.java
 *
 * File generated from the voc::ParticipationInformationTranscriber uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ParticipationInformationTranscriber.
 *
 */

@XmlType(name = "ParticipationInformationTranscriber")
@XmlEnum
@XmlRootElement(name = "ParticipationInformationTranscriber")
public enum ParticipationInformationTranscriber {
	@XmlEnumValue("ENT")
	ENT("ENT"),
	@XmlEnumValue("TRANS")
	TRANS("TRANS");
	
	private final String value;

    ParticipationInformationTranscriber(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ParticipationInformationTranscriber fromValue(String v) {
        for (ParticipationInformationTranscriber c: ParticipationInformationTranscriber.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}