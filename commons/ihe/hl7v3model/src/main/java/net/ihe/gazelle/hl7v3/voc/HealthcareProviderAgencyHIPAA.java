/**
 * HealthcareProviderAgencyHIPAA.java
 * <p>
 * File generated from the voc::HealthcareProviderAgencyHIPAA uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration HealthcareProviderAgencyHIPAA.
 *
 */

@XmlType(name = "HealthcareProviderAgencyHIPAA")
@XmlEnum
@XmlRootElement(name = "HealthcareProviderAgencyHIPAA")
public enum HealthcareProviderAgencyHIPAA {
	@XmlEnumValue("2514C0400N")
	_2514C0400N("2514C0400N"),
	@XmlEnumValue("2514H0200N")
	_2514H0200N("2514H0200N"),
	@XmlEnumValue("2514H0201N")
	_2514H0201N("2514H0201N"),
	@XmlEnumValue("2514H0300N")
	_2514H0300N("2514H0300N"),
	@XmlEnumValue("2514N1101N")
	_2514N1101N("2514N1101N"),
	@XmlEnumValue("2514P0906N")
	_2514P0906N("2514P0906N"),
	@XmlEnumValue("2514V0001N")
	_2514V0001N("2514V0001N");
	
	private final String value;

    HealthcareProviderAgencyHIPAA(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static HealthcareProviderAgencyHIPAA fromValue(String v) {
        for (HealthcareProviderAgencyHIPAA c: HealthcareProviderAgencyHIPAA.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}