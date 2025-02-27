/**
 * SouthernNumic.java
 * <p>
 * File generated from the voc::SouthernNumic uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration SouthernNumic.
 *
 */

@XmlType(name = "SouthernNumic")
@XmlEnum
@XmlRootElement(name = "SouthernNumic")
public enum SouthernNumic {
	@XmlEnumValue("x-KAW")
	XKAW("x-KAW"),
	@XmlEnumValue("x-UTE")
	XUTE("x-UTE");
	
	private final String value;

    SouthernNumic(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static SouthernNumic fromValue(String v) {
        for (SouthernNumic c: SouthernNumic.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}