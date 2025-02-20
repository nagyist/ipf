/**
 * CVDiagTherPracticeSetting.java
 * <p>
 * File generated from the voc::CVDiagTherPracticeSetting uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration CVDiagTherPracticeSetting.
 *
 */

@XmlType(name = "CVDiagTherPracticeSetting")
@XmlEnum
@XmlRootElement(name = "CVDiagTherPracticeSetting")
public enum CVDiagTherPracticeSetting {
	@XmlEnumValue("CATH")
	CATH("CATH"),
	@XmlEnumValue("CVDX")
	CVDX("CVDX"),
	@XmlEnumValue("ECHO")
	ECHO("ECHO");
	
	private final String value;

    CVDiagTherPracticeSetting(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static CVDiagTherPracticeSetting fromValue(String v) {
        for (CVDiagTherPracticeSetting c: CVDiagTherPracticeSetting.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}