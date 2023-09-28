/**
 * RadiologyProviderCodes.java
 *
 * File generated from the voc::RadiologyProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RadiologyProviderCodes.
 *
 */

@XmlType(name = "RadiologyProviderCodes")
@XmlEnum
@XmlRootElement(name = "RadiologyProviderCodes")
public enum RadiologyProviderCodes {
	@XmlEnumValue("208500000X")
	_208500000X("208500000X"),
	@XmlEnumValue("2085B0100X")
	_2085B0100X("2085B0100X"),
	@XmlEnumValue("2085N0700X")
	_2085N0700X("2085N0700X"),
	@XmlEnumValue("2085N0904X")
	_2085N0904X("2085N0904X"),
	@XmlEnumValue("2085P0229X")
	_2085P0229X("2085P0229X"),
	@XmlEnumValue("2085R0001X")
	_2085R0001X("2085R0001X"),
	@XmlEnumValue("2085R0202X")
	_2085R0202X("2085R0202X"),
	@XmlEnumValue("2085R0203X")
	_2085R0203X("2085R0203X"),
	@XmlEnumValue("2085R0204X")
	_2085R0204X("2085R0204X"),
	@XmlEnumValue("2085R0205X")
	_2085R0205X("2085R0205X"),
	@XmlEnumValue("2085U0001X")
	_2085U0001X("2085U0001X");
	
	private final String value;

    RadiologyProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RadiologyProviderCodes fromValue(String v) {
        for (RadiologyProviderCodes c: RadiologyProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}