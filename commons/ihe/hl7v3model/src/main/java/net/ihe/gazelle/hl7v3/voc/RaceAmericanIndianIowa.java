/**
 * RaceAmericanIndianIowa.java
 * <p>
 * File generated from the voc::RaceAmericanIndianIowa uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RaceAmericanIndianIowa.
 *
 */

@XmlType(name = "RaceAmericanIndianIowa")
@XmlEnum
@XmlRootElement(name = "RaceAmericanIndianIowa")
public enum RaceAmericanIndianIowa {
	@XmlEnumValue("1281-5")
	_12815("1281-5"),
	@XmlEnumValue("1282-3")
	_12823("1282-3"),
	@XmlEnumValue("1283-1")
	_12831("1283-1");
	
	private final String value;

    RaceAmericanIndianIowa(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RaceAmericanIndianIowa fromValue(String v) {
        for (RaceAmericanIndianIowa c: RaceAmericanIndianIowa.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}