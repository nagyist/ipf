/**
 * MilitaryHospital.java
 * <p>
 * File generated from the voc::MilitaryHospital uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration MilitaryHospital.
 *
 */

@XmlType(name = "MilitaryHospital")
@XmlEnum
@XmlRootElement(name = "MilitaryHospital")
public enum MilitaryHospital {
	@XmlEnumValue("MHSP")
	MHSP("MHSP");
	
	private final String value;

    MilitaryHospital(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static MilitaryHospital fromValue(String v) {
        for (MilitaryHospital c: MilitaryHospital.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}