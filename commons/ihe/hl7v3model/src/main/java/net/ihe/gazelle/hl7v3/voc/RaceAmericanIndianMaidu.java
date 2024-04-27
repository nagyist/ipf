/**
 * RaceAmericanIndianMaidu.java
 *
 * File generated from the voc::RaceAmericanIndianMaidu uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RaceAmericanIndianMaidu.
 *
 */

@XmlType(name = "RaceAmericanIndianMaidu")
@XmlEnum
@XmlRootElement(name = "RaceAmericanIndianMaidu")
public enum RaceAmericanIndianMaidu {
	@XmlEnumValue("1344-1")
	_13441("1344-1"),
	@XmlEnumValue("1345-8")
	_13458("1345-8"),
	@XmlEnumValue("1346-6")
	_13466("1346-6");
	
	private final String value;

    RaceAmericanIndianMaidu(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RaceAmericanIndianMaidu fromValue(String v) {
        for (RaceAmericanIndianMaidu c: RaceAmericanIndianMaidu.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}