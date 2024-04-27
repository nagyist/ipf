/**
 * VeterinarianProviderCodes.java
 *
 * File generated from the voc::VeterinarianProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration VeterinarianProviderCodes.
 *
 */

@XmlType(name = "VeterinarianProviderCodes")
@XmlEnum
@XmlRootElement(name = "VeterinarianProviderCodes")
public enum VeterinarianProviderCodes {
	@XmlEnumValue("174M00000X")
	_174M00000X("174M00000X"),
	@XmlEnumValue("174MM1900X")
	_174MM1900X("174MM1900X");
	
	private final String value;

    VeterinarianProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static VeterinarianProviderCodes fromValue(String v) {
        for (VeterinarianProviderCodes c: VeterinarianProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}