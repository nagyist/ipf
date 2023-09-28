/**
 * PharmacyServiceProviderTechnicianHIPAA.java
 *
 * File generated from the voc::PharmacyServiceProviderTechnicianHIPAA uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration PharmacyServiceProviderTechnicianHIPAA.
 *
 */

@XmlType(name = "PharmacyServiceProviderTechnicianHIPAA")
@XmlEnum
@XmlRootElement(name = "PharmacyServiceProviderTechnicianHIPAA")
public enum PharmacyServiceProviderTechnicianHIPAA {
	@XmlEnumValue("1847P3400N")
	_1847P3400N("1847P3400N");
	
	private final String value;

    PharmacyServiceProviderTechnicianHIPAA(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static PharmacyServiceProviderTechnicianHIPAA fromValue(String v) {
        for (PharmacyServiceProviderTechnicianHIPAA c: PharmacyServiceProviderTechnicianHIPAA.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}