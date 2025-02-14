/**
 * RadiologicTechnologistProviderCodes.java
 * <p>
 * File generated from the voc::RadiologicTechnologistProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RadiologicTechnologistProviderCodes.
 *
 */

@XmlType(name = "RadiologicTechnologistProviderCodes")
@XmlEnum
@XmlRootElement(name = "RadiologicTechnologistProviderCodes")
public enum RadiologicTechnologistProviderCodes {
	@XmlEnumValue("247100000X")
	_247100000X("247100000X"),
	@XmlEnumValue("2471B0102X")
	_2471B0102X("2471B0102X"),
	@XmlEnumValue("2471C1101X")
	_2471C1101X("2471C1101X"),
	@XmlEnumValue("2471C1106X")
	_2471C1106X("2471C1106X"),
	@XmlEnumValue("2471C3401X")
	_2471C3401X("2471C3401X"),
	@XmlEnumValue("2471C3402X")
	_2471C3402X("2471C3402X"),
	@XmlEnumValue("2471M1202X")
	_2471M1202X("2471M1202X"),
	@XmlEnumValue("2471M2300X")
	_2471M2300X("2471M2300X"),
	@XmlEnumValue("2471N0900X")
	_2471N0900X("2471N0900X"),
	@XmlEnumValue("2471Q0001X")
	_2471Q0001X("2471Q0001X"),
	@XmlEnumValue("2471R0002X")
	_2471R0002X("2471R0002X"),
	@XmlEnumValue("2471S1302X")
	_2471S1302X("2471S1302X"),
	@XmlEnumValue("2471V0105X")
	_2471V0105X("2471V0105X"),
	@XmlEnumValue("2471V0106X")
	_2471V0106X("2471V0106X");
	
	private final String value;

    RadiologicTechnologistProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RadiologicTechnologistProviderCodes fromValue(String v) {
        for (RadiologicTechnologistProviderCodes c: RadiologicTechnologistProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}