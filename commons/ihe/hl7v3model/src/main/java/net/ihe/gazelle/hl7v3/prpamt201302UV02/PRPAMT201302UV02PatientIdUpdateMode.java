/**
 * PRPAMT201302UV02PatientIdUpdateMode.java
 *
 * File generated from the prpamt201302UV02::PRPAMT201302UV02PatientIdUpdateMode uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.prpamt201302UV02;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration PRPAMT201302UV02PatientIdUpdateMode.
 *
 */

@XmlType(name = "PRPAMT201302UV02PatientIdUpdateMode")
@XmlEnum
@XmlRootElement(name = "PRPAMT201302UV02PatientIdUpdateMode")
public enum PRPAMT201302UV02PatientIdUpdateMode {
	@XmlEnumValue("A")
	A("A"),
	@XmlEnumValue("N")
	N("N");
	
	private final String value;

    PRPAMT201302UV02PatientIdUpdateMode(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static PRPAMT201302UV02PatientIdUpdateMode fromValue(String v) {
        for (PRPAMT201302UV02PatientIdUpdateMode c: PRPAMT201302UV02PatientIdUpdateMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}