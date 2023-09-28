/**
 * VerificationOutcomeValue.java
 *
 * File generated from the voc::VerificationOutcomeValue uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration VerificationOutcomeValue.
 *
 */

@XmlType(name = "VerificationOutcomeValue")
@XmlEnum
@XmlRootElement(name = "VerificationOutcomeValue")
public enum VerificationOutcomeValue {
	@XmlEnumValue("ACT")
	ACT("ACT"),
	@XmlEnumValue("ACTPEND")
	ACTPEND("ACTPEND"),
	@XmlEnumValue("ELG")
	ELG("ELG"),
	@XmlEnumValue("INACT")
	INACT("INACT"),
	@XmlEnumValue("INPNDINV")
	INPNDINV("INPNDINV"),
	@XmlEnumValue("INPNDUPD")
	INPNDUPD("INPNDUPD"),
	@XmlEnumValue("NELG")
	NELG("NELG");
	
	private final String value;

    VerificationOutcomeValue(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static VerificationOutcomeValue fromValue(String v) {
        for (VerificationOutcomeValue c: VerificationOutcomeValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}