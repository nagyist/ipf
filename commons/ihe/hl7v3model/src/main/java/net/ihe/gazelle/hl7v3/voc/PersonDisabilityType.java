/**
 * PersonDisabilityType.java
 *
 * File generated from the voc::PersonDisabilityType uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration PersonDisabilityType.
 *
 */

@XmlType(name = "PersonDisabilityType")
@XmlEnum
@XmlRootElement(name = "PersonDisabilityType")
public enum PersonDisabilityType {
	@XmlEnumValue("1")
	_1("1"),
	@XmlEnumValue("2")
	_2("2"),
	@XmlEnumValue("3")
	_3("3"),
	@XmlEnumValue("4")
	_4("4"),
	@XmlEnumValue("5")
	_5("5"),
	@XmlEnumValue("CB")
	CB("CB"),
	@XmlEnumValue("CR")
	CR("CR"),
	@XmlEnumValue("G")
	G("G"),
	@XmlEnumValue("WC")
	WC("WC"),
	@XmlEnumValue("WK")
	WK("WK");
	
	private final String value;

    PersonDisabilityType(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static PersonDisabilityType fromValue(String v) {
        for (PersonDisabilityType c: PersonDisabilityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}