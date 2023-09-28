/**
 * PodiatricMedicineandSurgeryProvidersProviderCodes.java
 *
 * File generated from the voc::PodiatricMedicineandSurgeryProvidersProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration PodiatricMedicineandSurgeryProvidersProviderCodes.
 *
 */

@XmlType(name = "PodiatricMedicineandSurgeryProvidersProviderCodes")
@XmlEnum
@XmlRootElement(name = "PodiatricMedicineandSurgeryProvidersProviderCodes")
public enum PodiatricMedicineandSurgeryProvidersProviderCodes {
	@XmlEnumValue("210000000X")
	_210000000X("210000000X"),
	@XmlEnumValue("211D00000X")
	_211D00000X("211D00000X"),
	@XmlEnumValue("213E00000X")
	_213E00000X("213E00000X"),
	@XmlEnumValue("213EG0000X")
	_213EG0000X("213EG0000X"),
	@XmlEnumValue("213EP0504X")
	_213EP0504X("213EP0504X"),
	@XmlEnumValue("213EP1101X")
	_213EP1101X("213EP1101X"),
	@XmlEnumValue("213ER0200X")
	_213ER0200X("213ER0200X"),
	@XmlEnumValue("213ES0000X")
	_213ES0000X("213ES0000X"),
	@XmlEnumValue("213ES0103X")
	_213ES0103X("213ES0103X"),
	@XmlEnumValue("213ES0131X")
	_213ES0131X("213ES0131X");
	
	private final String value;

    PodiatricMedicineandSurgeryProvidersProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static PodiatricMedicineandSurgeryProvidersProviderCodes fromValue(String v) {
        for (PodiatricMedicineandSurgeryProvidersProviderCodes c: PodiatricMedicineandSurgeryProvidersProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}