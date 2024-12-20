/**
 * XInformationRecipientRole.java
 * <p>
 * File generated from the voc::XInformationRecipientRole uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration XInformationRecipientRole.
 *
 */

@XmlType(name = "XInformationRecipientRole")
@XmlEnum
@XmlRootElement(name = "XInformationRecipientRole")
public enum XInformationRecipientRole {
	@XmlEnumValue("ASSIGNED")
	ASSIGNED("ASSIGNED"),
	@XmlEnumValue("HLTHCHRT")
	HLTHCHRT("HLTHCHRT");
	
	private final String value;

    XInformationRecipientRole(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static XInformationRecipientRole fromValue(String v) {
        for (XInformationRecipientRole c: XInformationRecipientRole.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}