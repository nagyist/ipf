/**
 * ManagedParticipationStatus.java
 * <p>
 * File generated from the voc::ManagedParticipationStatus uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ManagedParticipationStatus.
 *
 */

@XmlType(name = "ManagedParticipationStatus")
@XmlEnum
@XmlRootElement(name = "ManagedParticipationStatus")
public enum ManagedParticipationStatus {
	@XmlEnumValue("active")
	ACTIVE("active"),
	@XmlEnumValue("cancelled")
	CANCELLED("cancelled"),
	@XmlEnumValue("completed")
	COMPLETED("completed"),
	@XmlEnumValue("normal")
	NORMAL("normal"),
	@XmlEnumValue("nullified")
	NULLIFIED("nullified"),
	@XmlEnumValue("pending")
	PENDING("pending");
	
	private final String value;

    ManagedParticipationStatus(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ManagedParticipationStatus fromValue(String v) {
        for (ManagedParticipationStatus c: ManagedParticipationStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}