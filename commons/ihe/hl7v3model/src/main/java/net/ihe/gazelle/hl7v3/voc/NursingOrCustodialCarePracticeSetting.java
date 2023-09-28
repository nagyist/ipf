/**
 * NursingOrCustodialCarePracticeSetting.java
 *
 * File generated from the voc::NursingOrCustodialCarePracticeSetting uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration NursingOrCustodialCarePracticeSetting.
 *
 */

@XmlType(name = "NursingOrCustodialCarePracticeSetting")
@XmlEnum
@XmlRootElement(name = "NursingOrCustodialCarePracticeSetting")
public enum NursingOrCustodialCarePracticeSetting {
	@XmlEnumValue("314000000N")
	_314000000N("314000000N"),
	@XmlEnumValue("NCCF")
	NCCF("NCCF"),
	@XmlEnumValue("SNF")
	SNF("SNF");
	
	private final String value;

    NursingOrCustodialCarePracticeSetting(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static NursingOrCustodialCarePracticeSetting fromValue(String v) {
        for (NursingOrCustodialCarePracticeSetting c: NursingOrCustodialCarePracticeSetting.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}