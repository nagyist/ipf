/**
 * NursingandCustodialCareFacilitiesProviderCodes.java
 *
 * File generated from the voc::NursingandCustodialCareFacilitiesProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration NursingandCustodialCareFacilitiesProviderCodes.
 *
 */

@XmlType(name = "NursingandCustodialCareFacilitiesProviderCodes")
@XmlEnum
@XmlRootElement(name = "NursingandCustodialCareFacilitiesProviderCodes")
public enum NursingandCustodialCareFacilitiesProviderCodes {
	@XmlEnumValue("310000000X")
	_310000000X("310000000X"),
	@XmlEnumValue("310400000X")
	_310400000X("310400000X"),
	@XmlEnumValue("3104A0625X")
	_3104A0625X("3104A0625X"),
	@XmlEnumValue("3104A0630X")
	_3104A0630X("3104A0630X"),
	@XmlEnumValue("310500000X")
	_310500000X("310500000X"),
	@XmlEnumValue("311500000X")
	_311500000X("311500000X"),
	@XmlEnumValue("311Z00000X")
	_311Z00000X("311Z00000X"),
	@XmlEnumValue("311ZA0620X")
	_311ZA0620X("311ZA0620X"),
	@XmlEnumValue("313M00000X")
	_313M00000X("313M00000X"),
	@XmlEnumValue("314000000X")
	_314000000X("314000000X"),
	@XmlEnumValue("3140N1450X")
	_3140N1450X("3140N1450X"),
	@XmlEnumValue("315D00000X")
	_315D00000X("315D00000X"),
	@XmlEnumValue("315P00000X")
	_315P00000X("315P00000X"),
	@XmlEnumValue("317400000X")
	_317400000X("317400000X");
	
	private final String value;

    NursingandCustodialCareFacilitiesProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static NursingandCustodialCareFacilitiesProviderCodes fromValue(String v) {
        for (NursingandCustodialCareFacilitiesProviderCodes c: NursingandCustodialCareFacilitiesProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}