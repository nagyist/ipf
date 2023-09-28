/**
 * RaceWhite.java
 *
 * File generated from the voc::RaceWhite uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RaceWhite.
 *
 */

@XmlType(name = "RaceWhite")
@XmlEnum
@XmlRootElement(name = "RaceWhite")
public enum RaceWhite {
	@XmlEnumValue("2106-3")
	_21063("2106-3"),
	@XmlEnumValue("2108-9")
	_21089("2108-9"),
	@XmlEnumValue("2109-7")
	_21097("2109-7"),
	@XmlEnumValue("2110-5")
	_21105("2110-5"),
	@XmlEnumValue("2111-3")
	_21113("2111-3"),
	@XmlEnumValue("2112-1")
	_21121("2112-1"),
	@XmlEnumValue("2113-9")
	_21139("2113-9"),
	@XmlEnumValue("2114-7")
	_21147("2114-7"),
	@XmlEnumValue("2115-4")
	_21154("2115-4"),
	@XmlEnumValue("2116-2")
	_21162("2116-2"),
	@XmlEnumValue("2118-8")
	_21188("2118-8"),
	@XmlEnumValue("2119-6")
	_21196("2119-6"),
	@XmlEnumValue("2120-4")
	_21204("2120-4"),
	@XmlEnumValue("2121-2")
	_21212("2121-2"),
	@XmlEnumValue("2122-0")
	_21220("2122-0"),
	@XmlEnumValue("2123-8")
	_21238("2123-8"),
	@XmlEnumValue("2124-6")
	_21246("2124-6"),
	@XmlEnumValue("2125-3")
	_21253("2125-3"),
	@XmlEnumValue("2126-1")
	_21261("2126-1"),
	@XmlEnumValue("2127-9")
	_21279("2127-9"),
	@XmlEnumValue("2129-5")
	_21295("2129-5");
	
	private final String value;

    RaceWhite(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RaceWhite fromValue(String v) {
        for (RaceWhite c: RaceWhite.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}