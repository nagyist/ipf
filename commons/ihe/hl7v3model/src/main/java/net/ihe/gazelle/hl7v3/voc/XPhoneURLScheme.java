/**
 * XPhoneURLScheme.java
 * <p>
 * File generated from the voc::XPhoneURLScheme uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration XPhoneURLScheme.
 *
 */

@XmlType(name = "XPhoneURLScheme")
@XmlEnum
@XmlRootElement(name = "XPhoneURLScheme")
public enum XPhoneURLScheme {
	@XmlEnumValue("fax")
	FAX("fax"),
	@XmlEnumValue("tel")
	TEL("tel");
	
	private final String value;

    XPhoneURLScheme(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static XPhoneURLScheme fromValue(String v) {
        for (XPhoneURLScheme c: XPhoneURLScheme.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}