/**
 * PreventiveMedicineProviderCodes.java
 * <p>
 * File generated from the voc::PreventiveMedicineProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration PreventiveMedicineProviderCodes.
 *
 */

@XmlType(name = "PreventiveMedicineProviderCodes")
@XmlEnum
@XmlRootElement(name = "PreventiveMedicineProviderCodes")
public enum PreventiveMedicineProviderCodes {
	@XmlEnumValue("208300000X")
	_208300000X("208300000X"),
	@XmlEnumValue("2083A0100X")
	_2083A0100X("2083A0100X"),
	@XmlEnumValue("2083P0011X")
	_2083P0011X("2083P0011X"),
	@XmlEnumValue("2083P0500X")
	_2083P0500X("2083P0500X"),
	@XmlEnumValue("2083P0901X")
	_2083P0901X("2083P0901X"),
	@XmlEnumValue("2083S0010X")
	_2083S0010X("2083S0010X"),
	@XmlEnumValue("2083T0002X")
	_2083T0002X("2083T0002X"),
	@XmlEnumValue("2083X0100X")
	_2083X0100X("2083X0100X");
	
	private final String value;

    PreventiveMedicineProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static PreventiveMedicineProviderCodes fromValue(String v) {
        for (PreventiveMedicineProviderCodes c: PreventiveMedicineProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}