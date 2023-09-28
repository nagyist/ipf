/**
 * ManagedParticipationStatusNormal.java
 *
 * File generated from the voc::ManagedParticipationStatusNormal uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ManagedParticipationStatusNormal.
 *
 */

@XmlType(name = "ManagedParticipationStatusNormal")
@XmlEnum
@XmlRootElement(name = "ManagedParticipationStatusNormal")
public enum ManagedParticipationStatusNormal {
	@XmlEnumValue("active")
	ACTIVE("active"),
	@XmlEnumValue("cancelled")
	CANCELLED("cancelled"),
	@XmlEnumValue("completed")
	COMPLETED("completed"),
	@XmlEnumValue("normal")
	NORMAL("normal"),
	@XmlEnumValue("pending")
	PENDING("pending");
	
	private final String value;

    ManagedParticipationStatusNormal(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ManagedParticipationStatusNormal fromValue(String v) {
        for (ManagedParticipationStatusNormal c: ManagedParticipationStatusNormal.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}