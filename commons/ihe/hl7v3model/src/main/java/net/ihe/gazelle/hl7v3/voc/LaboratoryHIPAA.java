/**
 * LaboratoryHIPAA.java
 * <p>
 * File generated from the voc::LaboratoryHIPAA uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration LaboratoryHIPAA.
 *
 */

@XmlType(name = "LaboratoryHIPAA")
@XmlEnum
@XmlRootElement(name = "LaboratoryHIPAA")
public enum LaboratoryHIPAA {
	@XmlEnumValue("291U00000N")
	_291U00000N("291U00000N"),
	@XmlEnumValue("292200000N")
	_292200000N("292200000N"),
	@XmlEnumValue("293D00000N")
	_293D00000N("293D00000N");
	
	private final String value;

    LaboratoryHIPAA(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static LaboratoryHIPAA fromValue(String v) {
        for (LaboratoryHIPAA c: LaboratoryHIPAA.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}