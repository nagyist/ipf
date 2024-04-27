/**
 * FamilyMemberCousin.java
 *
 * File generated from the voc::FamilyMemberCousin uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration FamilyMemberCousin.
 *
 */

@XmlType(name = "FamilyMemberCousin")
@XmlEnum
@XmlRootElement(name = "FamilyMemberCousin")
public enum FamilyMemberCousin {
	@XmlEnumValue("COUSN")
	COUSN("COUSN"),
	@XmlEnumValue("MCOUSN")
	MCOUSN("MCOUSN"),
	@XmlEnumValue("PCOUSN")
	PCOUSN("PCOUSN");
	
	private final String value;

    FamilyMemberCousin(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static FamilyMemberCousin fromValue(String v) {
        for (FamilyMemberCousin c: FamilyMemberCousin.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}