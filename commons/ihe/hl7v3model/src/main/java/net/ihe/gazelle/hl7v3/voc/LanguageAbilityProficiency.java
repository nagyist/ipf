/**
 * LanguageAbilityProficiency.java
 *
 * File generated from the voc::LanguageAbilityProficiency uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration LanguageAbilityProficiency.
 *
 */

@XmlType(name = "LanguageAbilityProficiency")
@XmlEnum
@XmlRootElement(name = "LanguageAbilityProficiency")
public enum LanguageAbilityProficiency {
	@XmlEnumValue("E")
	E("E"),
	@XmlEnumValue("F")
	F("F"),
	@XmlEnumValue("G")
	G("G"),
	@XmlEnumValue("P")
	P("P");
	
	private final String value;

    LanguageAbilityProficiency(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static LanguageAbilityProficiency fromValue(String v) {
        for (LanguageAbilityProficiency c: LanguageAbilityProficiency.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}