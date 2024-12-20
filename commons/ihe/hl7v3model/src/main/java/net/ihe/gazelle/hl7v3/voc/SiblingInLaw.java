/**
 * SiblingInLaw.java
 * <p>
 * File generated from the voc::SiblingInLaw uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration SiblingInLaw.
 *
 */

@XmlType(name = "SiblingInLaw")
@XmlEnum
@XmlRootElement(name = "SiblingInLaw")
public enum SiblingInLaw {
	@XmlEnumValue("BROINLAW")
	BROINLAW("BROINLAW"),
	@XmlEnumValue("SIBINLAW")
	SIBINLAW("SIBINLAW"),
	@XmlEnumValue("SISINLAW")
	SISINLAW("SISINLAW");
	
	private final String value;

    SiblingInLaw(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static SiblingInLaw fromValue(String v) {
        for (SiblingInLaw c: SiblingInLaw.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}