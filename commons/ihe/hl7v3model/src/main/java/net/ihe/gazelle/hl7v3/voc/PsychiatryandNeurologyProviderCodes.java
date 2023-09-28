/**
 * PsychiatryandNeurologyProviderCodes.java
 *
 * File generated from the voc::PsychiatryandNeurologyProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration PsychiatryandNeurologyProviderCodes.
 *
 */

@XmlType(name = "PsychiatryandNeurologyProviderCodes")
@XmlEnum
@XmlRootElement(name = "PsychiatryandNeurologyProviderCodes")
public enum PsychiatryandNeurologyProviderCodes {
	@XmlEnumValue("208400000X")
	_208400000X("208400000X"),
	@XmlEnumValue("2084A0401X")
	_2084A0401X("2084A0401X"),
	@XmlEnumValue("2084F0202X")
	_2084F0202X("2084F0202X"),
	@XmlEnumValue("2084N0400X")
	_2084N0400X("2084N0400X"),
	@XmlEnumValue("2084N0402X")
	_2084N0402X("2084N0402X"),
	@XmlEnumValue("2084N0600X")
	_2084N0600X("2084N0600X"),
	@XmlEnumValue("2084P0005X")
	_2084P0005X("2084P0005X"),
	@XmlEnumValue("2084P0800X")
	_2084P0800X("2084P0800X"),
	@XmlEnumValue("2084P0802X")
	_2084P0802X("2084P0802X"),
	@XmlEnumValue("2084P0804X")
	_2084P0804X("2084P0804X"),
	@XmlEnumValue("2084P0805X")
	_2084P0805X("2084P0805X"),
	@XmlEnumValue("2084P2900X")
	_2084P2900X("2084P2900X"),
	@XmlEnumValue("2084S0010X")
	_2084S0010X("2084S0010X"),
	@XmlEnumValue("2084V0102X")
	_2084V0102X("2084V0102X");
	
	private final String value;

    PsychiatryandNeurologyProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static PsychiatryandNeurologyProviderCodes fromValue(String v) {
        for (PsychiatryandNeurologyProviderCodes c: PsychiatryandNeurologyProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}