/**
 * RaceAmericanIndianIroquois.java
 * <p>
 * File generated from the voc::RaceAmericanIndianIroquois uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RaceAmericanIndianIroquois.
 *
 */

@XmlType(name = "RaceAmericanIndianIroquois")
@XmlEnum
@XmlRootElement(name = "RaceAmericanIndianIroquois")
public enum RaceAmericanIndianIroquois {
	@XmlEnumValue("1285-6")
	_12856("1285-6"),
	@XmlEnumValue("1286-4")
	_12864("1286-4"),
	@XmlEnumValue("1287-2")
	_12872("1287-2"),
	@XmlEnumValue("1288-0")
	_12880("1288-0"),
	@XmlEnumValue("1289-8")
	_12898("1289-8"),
	@XmlEnumValue("1290-6")
	_12906("1290-6"),
	@XmlEnumValue("1291-4")
	_12914("1291-4"),
	@XmlEnumValue("1292-2")
	_12922("1292-2"),
	@XmlEnumValue("1293-0")
	_12930("1293-0"),
	@XmlEnumValue("1294-8")
	_12948("1294-8"),
	@XmlEnumValue("1295-5")
	_12955("1295-5");
	
	private final String value;

    RaceAmericanIndianIroquois(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RaceAmericanIndianIroquois fromValue(String v) {
        for (RaceAmericanIndianIroquois c: RaceAmericanIndianIroquois.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}