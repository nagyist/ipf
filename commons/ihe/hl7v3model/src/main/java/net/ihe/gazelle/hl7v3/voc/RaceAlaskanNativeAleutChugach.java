/**
 * RaceAlaskanNativeAleutChugach.java
 *
 * File generated from the voc::RaceAlaskanNativeAleutChugach uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RaceAlaskanNativeAleutChugach.
 *
 */

@XmlType(name = "RaceAlaskanNativeAleutChugach")
@XmlEnum
@XmlRootElement(name = "RaceAlaskanNativeAleutChugach")
public enum RaceAlaskanNativeAleutChugach {
	@XmlEnumValue("1984-4")
	_19844("1984-4"),
	@XmlEnumValue("1985-1")
	_19851("1985-1"),
	@XmlEnumValue("1986-9")
	_19869("1986-9"),
	@XmlEnumValue("1987-7")
	_19877("1987-7"),
	@XmlEnumValue("1988-5")
	_19885("1988-5");
	
	private final String value;

    RaceAlaskanNativeAleutChugach(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RaceAlaskanNativeAleutChugach fromValue(String v) {
        for (RaceAlaskanNativeAleutChugach c: RaceAlaskanNativeAleutChugach.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}