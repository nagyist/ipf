/**
 * BiotherapeuticNonPersonLivingSubjectRoleType.java
 * <p>
 * File generated from the voc::BiotherapeuticNonPersonLivingSubjectRoleType uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration BiotherapeuticNonPersonLivingSubjectRoleType.
 *
 */

@XmlType(name = "BiotherapeuticNonPersonLivingSubjectRoleType")
@XmlEnum
@XmlRootElement(name = "BiotherapeuticNonPersonLivingSubjectRoleType")
public enum BiotherapeuticNonPersonLivingSubjectRoleType {
	@XmlEnumValue("ANTIBIOT")
	ANTIBIOT("ANTIBIOT"),
	@XmlEnumValue("BIOTH")
	BIOTH("BIOTH"),
	@XmlEnumValue("DEBR")
	DEBR("DEBR");
	
	private final String value;

    BiotherapeuticNonPersonLivingSubjectRoleType(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static BiotherapeuticNonPersonLivingSubjectRoleType fromValue(String v) {
        for (BiotherapeuticNonPersonLivingSubjectRoleType c: BiotherapeuticNonPersonLivingSubjectRoleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}