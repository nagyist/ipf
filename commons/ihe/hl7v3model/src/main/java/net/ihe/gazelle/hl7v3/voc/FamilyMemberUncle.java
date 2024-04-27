/**
 * FamilyMemberUncle.java
 *
 * File generated from the voc::FamilyMemberUncle uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration FamilyMemberUncle.
 *
 */

@XmlType(name = "FamilyMemberUncle")
@XmlEnum
@XmlRootElement(name = "FamilyMemberUncle")
public enum FamilyMemberUncle {
	@XmlEnumValue("MUNCLE")
	MUNCLE("MUNCLE"),
	@XmlEnumValue("PUNCLE")
	PUNCLE("PUNCLE"),
	@XmlEnumValue("UNCLE")
	UNCLE("UNCLE");
	
	private final String value;

    FamilyMemberUncle(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static FamilyMemberUncle fromValue(String v) {
        for (FamilyMemberUncle c: FamilyMemberUncle.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}