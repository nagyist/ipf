/**
 * TargetAwareness.java
 *
 * File generated from the voc::TargetAwareness uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration TargetAwareness.
 *
 */

@XmlType(name = "TargetAwareness")
@XmlEnum
@XmlRootElement(name = "TargetAwareness")
public enum TargetAwareness {
	@XmlEnumValue("D")
	D("D"),
	@XmlEnumValue("F")
	F("F"),
	@XmlEnumValue("I")
	I("I"),
	@XmlEnumValue("M")
	M("M"),
	@XmlEnumValue("P")
	P("P"),
	@XmlEnumValue("U")
	U("U");
	
	private final String value;

    TargetAwareness(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static TargetAwareness fromValue(String v) {
        for (TargetAwareness c: TargetAwareness.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}