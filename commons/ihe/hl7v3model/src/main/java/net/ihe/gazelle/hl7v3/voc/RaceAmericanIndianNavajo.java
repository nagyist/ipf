/**
 * RaceAmericanIndianNavajo.java
 * <p>
 * File generated from the voc::RaceAmericanIndianNavajo uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RaceAmericanIndianNavajo.
 *
 */

@XmlType(name = "RaceAmericanIndianNavajo")
@XmlEnum
@XmlRootElement(name = "RaceAmericanIndianNavajo")
public enum RaceAmericanIndianNavajo {
	@XmlEnumValue("1382-1")
	_13821("1382-1"),
	@XmlEnumValue("1383-9")
	_13839("1383-9"),
	@XmlEnumValue("1384-7")
	_13847("1384-7"),
	@XmlEnumValue("1385-4")
	_13854("1385-4");
	
	private final String value;

    RaceAmericanIndianNavajo(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RaceAmericanIndianNavajo fromValue(String v) {
        for (RaceAmericanIndianNavajo c: RaceAmericanIndianNavajo.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}