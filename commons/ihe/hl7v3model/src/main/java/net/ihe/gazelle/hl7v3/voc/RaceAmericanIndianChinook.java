/**
 * RaceAmericanIndianChinook.java
 *
 * File generated from the voc::RaceAmericanIndianChinook uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RaceAmericanIndianChinook.
 *
 */

@XmlType(name = "RaceAmericanIndianChinook")
@XmlEnum
@XmlRootElement(name = "RaceAmericanIndianChinook")
public enum RaceAmericanIndianChinook {
	@XmlEnumValue("1114-8")
	_11148("1114-8"),
	@XmlEnumValue("1115-5")
	_11155("1115-5"),
	@XmlEnumValue("1116-3")
	_11163("1116-3"),
	@XmlEnumValue("1117-1")
	_11171("1117-1"),
	@XmlEnumValue("1118-9")
	_11189("1118-9"),
	@XmlEnumValue("1119-7")
	_11197("1119-7"),
	@XmlEnumValue("1120-5")
	_11205("1120-5"),
	@XmlEnumValue("1121-3")
	_11213("1121-3");
	
	private final String value;

    RaceAmericanIndianChinook(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RaceAmericanIndianChinook fromValue(String v) {
        for (RaceAmericanIndianChinook c: RaceAmericanIndianChinook.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}