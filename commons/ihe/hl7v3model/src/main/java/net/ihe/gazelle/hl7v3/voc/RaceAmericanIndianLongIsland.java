/**
 * RaceAmericanIndianLongIsland.java
 *
 * File generated from the voc::RaceAmericanIndianLongIsland uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RaceAmericanIndianLongIsland.
 *
 */

@XmlType(name = "RaceAmericanIndianLongIsland")
@XmlEnum
@XmlRootElement(name = "RaceAmericanIndianLongIsland")
public enum RaceAmericanIndianLongIsland {
	@XmlEnumValue("1325-0")
	_13250("1325-0"),
	@XmlEnumValue("1326-8")
	_13268("1326-8"),
	@XmlEnumValue("1327-6")
	_13276("1327-6"),
	@XmlEnumValue("1328-4")
	_13284("1328-4"),
	@XmlEnumValue("1329-2")
	_13292("1329-2");
	
	private final String value;

    RaceAmericanIndianLongIsland(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RaceAmericanIndianLongIsland fromValue(String v) {
        for (RaceAmericanIndianLongIsland c: RaceAmericanIndianLongIsland.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}