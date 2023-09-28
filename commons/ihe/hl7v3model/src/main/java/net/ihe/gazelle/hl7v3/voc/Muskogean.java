/**
 * Muskogean.java
 *
 * File generated from the voc::Muskogean uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration Muskogean.
 *
 */

@XmlType(name = "Muskogean")
@XmlEnum
@XmlRootElement(name = "Muskogean")
public enum Muskogean {
	@XmlEnumValue("x-AKZ")
	XAKZ("x-AKZ"),
	@XmlEnumValue("x-CCT")
	XCCT("x-CCT"),
	@XmlEnumValue("x-CIC")
	XCIC("x-CIC"),
	@XmlEnumValue("x-CKU")
	XCKU("x-CKU"),
	@XmlEnumValue("x-CRK")
	XCRK("x-CRK"),
	@XmlEnumValue("x-MIK")
	XMIK("x-MIK");
	
	private final String value;

    Muskogean(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static Muskogean fromValue(String v) {
        for (Muskogean c: Muskogean.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}