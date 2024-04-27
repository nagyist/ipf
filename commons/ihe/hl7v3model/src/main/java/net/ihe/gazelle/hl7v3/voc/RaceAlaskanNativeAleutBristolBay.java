/**
 * RaceAlaskanNativeAleutBristolBay.java
 *
 * File generated from the voc::RaceAlaskanNativeAleutBristolBay uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RaceAlaskanNativeAleutBristolBay.
 *
 */

@XmlType(name = "RaceAlaskanNativeAleutBristolBay")
@XmlEnum
@XmlRootElement(name = "RaceAlaskanNativeAleutBristolBay")
public enum RaceAlaskanNativeAleutBristolBay {
	@XmlEnumValue("1972-9")
	_19729("1972-9"),
	@XmlEnumValue("1973-7")
	_19737("1973-7"),
	@XmlEnumValue("1974-5")
	_19745("1974-5"),
	@XmlEnumValue("1975-2")
	_19752("1975-2"),
	@XmlEnumValue("1976-0")
	_19760("1976-0"),
	@XmlEnumValue("1977-8")
	_19778("1977-8"),
	@XmlEnumValue("1978-6")
	_19786("1978-6"),
	@XmlEnumValue("1979-4")
	_19794("1979-4"),
	@XmlEnumValue("1980-2")
	_19802("1980-2"),
	@XmlEnumValue("1981-0")
	_19810("1981-0"),
	@XmlEnumValue("1982-8")
	_19828("1982-8");
	
	private final String value;

    RaceAlaskanNativeAleutBristolBay(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RaceAlaskanNativeAleutBristolBay fromValue(String v) {
        for (RaceAlaskanNativeAleutBristolBay c: RaceAlaskanNativeAleutBristolBay.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}