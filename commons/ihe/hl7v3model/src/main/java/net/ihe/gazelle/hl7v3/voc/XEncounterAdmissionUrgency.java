/**
 * XEncounterAdmissionUrgency.java
 *
 * File generated from the voc::XEncounterAdmissionUrgency uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration XEncounterAdmissionUrgency.
 *
 */

@XmlType(name = "XEncounterAdmissionUrgency")
@XmlEnum
@XmlRootElement(name = "XEncounterAdmissionUrgency")
public enum XEncounterAdmissionUrgency {
	@XmlEnumValue("EL")
	EL("EL"),
	@XmlEnumValue("EM")
	EM("EM"),
	@XmlEnumValue("R")
	R("R"),
	@XmlEnumValue("UR")
	UR("UR");
	
	private final String value;

    XEncounterAdmissionUrgency(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static XEncounterAdmissionUrgency fromValue(String v) {
        for (XEncounterAdmissionUrgency c: XEncounterAdmissionUrgency.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}