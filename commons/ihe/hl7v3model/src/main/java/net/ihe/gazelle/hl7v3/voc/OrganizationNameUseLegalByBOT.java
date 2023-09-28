/**
 * OrganizationNameUseLegalByBOT.java
 *
 * File generated from the voc::OrganizationNameUseLegalByBOT uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration OrganizationNameUseLegalByBOT.
 *
 */

@XmlType(name = "OrganizationNameUseLegalByBOT")
@XmlEnum
@XmlRootElement(name = "OrganizationNameUseLegalByBOT")
public enum OrganizationNameUseLegalByBOT {
	@XmlEnumValue("L")
	L("L"),
	@XmlEnumValue("OR")
	OR("OR");
	
	private final String value;

    OrganizationNameUseLegalByBOT(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static OrganizationNameUseLegalByBOT fromValue(String v) {
        for (OrganizationNameUseLegalByBOT c: OrganizationNameUseLegalByBOT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}