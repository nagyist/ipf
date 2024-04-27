/**
 * NursingServiceRelatedProvidersProviderCodes.java
 *
 * File generated from the voc::NursingServiceRelatedProvidersProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration NursingServiceRelatedProvidersProviderCodes.
 *
 */

@XmlType(name = "NursingServiceRelatedProvidersProviderCodes")
@XmlEnum
@XmlRootElement(name = "NursingServiceRelatedProvidersProviderCodes")
public enum NursingServiceRelatedProvidersProviderCodes {
	@XmlEnumValue("370000000X")
	_370000000X("370000000X"),
	@XmlEnumValue("372500000X")
	_372500000X("372500000X"),
	@XmlEnumValue("372600000X")
	_372600000X("372600000X"),
	@XmlEnumValue("373H00000X")
	_373H00000X("373H00000X"),
	@XmlEnumValue("374700000X")
	_374700000X("374700000X"),
	@XmlEnumValue("3747A0650X")
	_3747A0650X("3747A0650X"),
	@XmlEnumValue("3747P1801X")
	_3747P1801X("3747P1801X"),
	@XmlEnumValue("374T00000X")
	_374T00000X("374T00000X"),
	@XmlEnumValue("374U00000X")
	_374U00000X("374U00000X"),
	@XmlEnumValue("376G00000X")
	_376G00000X("376G00000X"),
	@XmlEnumValue("376J00000X")
	_376J00000X("376J00000X"),
	@XmlEnumValue("376K00000X")
	_376K00000X("376K00000X");
	
	private final String value;

    NursingServiceRelatedProvidersProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static NursingServiceRelatedProvidersProviderCodes fromValue(String v) {
        for (NursingServiceRelatedProvidersProviderCodes c: NursingServiceRelatedProvidersProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}