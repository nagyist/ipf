/**
 * SkilledNursingFacilityProviderCodes.java
 *
 * File generated from the voc::SkilledNursingFacilityProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration SkilledNursingFacilityProviderCodes.
 *
 */

@XmlType(name = "SkilledNursingFacilityProviderCodes")
@XmlEnum
@XmlRootElement(name = "SkilledNursingFacilityProviderCodes")
public enum SkilledNursingFacilityProviderCodes {
	@XmlEnumValue("314000000X")
	_314000000X("314000000X"),
	@XmlEnumValue("3140N1450X")
	_3140N1450X("3140N1450X");
	
	private final String value;

    SkilledNursingFacilityProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static SkilledNursingFacilityProviderCodes fromValue(String v) {
        for (SkilledNursingFacilityProviderCodes c: SkilledNursingFacilityProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}