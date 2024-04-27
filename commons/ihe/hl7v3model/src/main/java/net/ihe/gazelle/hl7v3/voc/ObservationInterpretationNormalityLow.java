/**
 * ObservationInterpretationNormalityLow.java
 *
 * File generated from the voc::ObservationInterpretationNormalityLow uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ObservationInterpretationNormalityLow.
 *
 */

@XmlType(name = "ObservationInterpretationNormalityLow")
@XmlEnum
@XmlRootElement(name = "ObservationInterpretationNormalityLow")
public enum ObservationInterpretationNormalityLow {
	@XmlEnumValue("L")
	L("L"),
	@XmlEnumValue("LL")
	LL("LL");
	
	private final String value;

    ObservationInterpretationNormalityLow(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ObservationInterpretationNormalityLow fromValue(String v) {
        for (ObservationInterpretationNormalityLow c: ObservationInterpretationNormalityLow.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}