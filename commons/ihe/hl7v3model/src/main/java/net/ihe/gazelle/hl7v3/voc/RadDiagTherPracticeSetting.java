/**
 * RadDiagTherPracticeSetting.java
 * <p>
 * File generated from the voc::RadDiagTherPracticeSetting uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RadDiagTherPracticeSetting.
 *
 */

@XmlType(name = "RadDiagTherPracticeSetting")
@XmlEnum
@XmlRootElement(name = "RadDiagTherPracticeSetting")
public enum RadDiagTherPracticeSetting {
	@XmlEnumValue("261QX0203N")
	_261QX0203N("261QX0203N"),
	@XmlEnumValue("RADDX")
	RADDX("RADDX"),
	@XmlEnumValue("RADO")
	RADO("RADO"),
	@XmlEnumValue("RNEU")
	RNEU("RNEU");
	
	private final String value;

    RadDiagTherPracticeSetting(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RadDiagTherPracticeSetting fromValue(String v) {
        for (RadDiagTherPracticeSetting c: RadDiagTherPracticeSetting.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}