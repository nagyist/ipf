/**
 * ParticipationTargetSubject.java
 *
 * File generated from the voc::ParticipationTargetSubject uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ParticipationTargetSubject.
 *
 */

@XmlType(name = "ParticipationTargetSubject")
@XmlEnum
@XmlRootElement(name = "ParticipationTargetSubject")
public enum ParticipationTargetSubject {
	@XmlEnumValue("SBJ")
	SBJ("SBJ"),
	@XmlEnumValue("SPC")
	SPC("SPC");
	
	private final String value;

    ParticipationTargetSubject(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ParticipationTargetSubject fromValue(String v) {
        for (ParticipationTargetSubject c: ParticipationTargetSubject.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}