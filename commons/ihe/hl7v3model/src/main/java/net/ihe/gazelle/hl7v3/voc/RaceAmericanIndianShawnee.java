/**
 * RaceAmericanIndianShawnee.java
 *
 * File generated from the voc::RaceAmericanIndianShawnee uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RaceAmericanIndianShawnee.
 *
 */

@XmlType(name = "RaceAmericanIndianShawnee")
@XmlEnum
@XmlRootElement(name = "RaceAmericanIndianShawnee")
public enum RaceAmericanIndianShawnee {
	@XmlEnumValue("1578-4")
	_15784("1578-4"),
	@XmlEnumValue("1579-2")
	_15792("1579-2"),
	@XmlEnumValue("1580-0")
	_15800("1580-0");
	
	private final String value;

    RaceAmericanIndianShawnee(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RaceAmericanIndianShawnee fromValue(String v) {
        for (RaceAmericanIndianShawnee c: RaceAmericanIndianShawnee.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}