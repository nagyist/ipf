/**
 * VerificationMethod.java
 * <p>
 * File generated from the voc::VerificationMethod uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration VerificationMethod.
 *
 */

@XmlType(name = "VerificationMethod")
@XmlEnum
@XmlRootElement(name = "VerificationMethod")
public enum VerificationMethod {
	@XmlEnumValue("VDOC")
	VDOC("VDOC"),
	@XmlEnumValue("VREG")
	VREG("VREG"),
	@XmlEnumValue("VTOKEN")
	VTOKEN("VTOKEN"),
	@XmlEnumValue("VVOICE")
	VVOICE("VVOICE");
	
	private final String value;

    VerificationMethod(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static VerificationMethod fromValue(String v) {
        for (VerificationMethod c: VerificationMethod.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}