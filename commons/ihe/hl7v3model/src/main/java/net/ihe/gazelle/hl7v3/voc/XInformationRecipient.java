/**
 * XInformationRecipient.java
 *
 * File generated from the voc::XInformationRecipient uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration XInformationRecipient.
 *
 */

@XmlType(name = "XInformationRecipient")
@XmlEnum
@XmlRootElement(name = "XInformationRecipient")
public enum XInformationRecipient {
	@XmlEnumValue("PRCP")
	PRCP("PRCP"),
	@XmlEnumValue("TRC")
	TRC("TRC");
	
	private final String value;

    XInformationRecipient(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static XInformationRecipient fromValue(String v) {
        for (XInformationRecipient c: XInformationRecipient.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}