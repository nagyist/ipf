/**
 * GeneralAcuteCareHospitalWomen.java
 *
 * File generated from the voc::GeneralAcuteCareHospitalWomen uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration GeneralAcuteCareHospitalWomen.
 *
 */

@XmlType(name = "GeneralAcuteCareHospitalWomen")
@XmlEnum
@XmlRootElement(name = "GeneralAcuteCareHospitalWomen")
public enum GeneralAcuteCareHospitalWomen {
	@XmlEnumValue("282NW0100N")
	_282NW0100N("282NW0100N"),
	@XmlEnumValue("2865C1500N")
	_2865C1500N("2865C1500N"),
	@XmlEnumValue("2865M2000N")
	_2865M2000N("2865M2000N"),
	@XmlEnumValue("2865X1600N")
	_2865X1600N("2865X1600N");
	
	private final String value;

    GeneralAcuteCareHospitalWomen(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static GeneralAcuteCareHospitalWomen fromValue(String v) {
        for (GeneralAcuteCareHospitalWomen c: GeneralAcuteCareHospitalWomen.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}