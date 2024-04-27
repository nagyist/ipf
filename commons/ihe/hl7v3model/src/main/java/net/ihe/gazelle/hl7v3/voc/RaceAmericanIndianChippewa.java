/**
 * RaceAmericanIndianChippewa.java
 *
 * File generated from the voc::RaceAmericanIndianChippewa uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RaceAmericanIndianChippewa.
 *
 */

@XmlType(name = "RaceAmericanIndianChippewa")
@XmlEnum
@XmlRootElement(name = "RaceAmericanIndianChippewa")
public enum RaceAmericanIndianChippewa {
	@XmlEnumValue("1123-9")
	_11239("1123-9"),
	@XmlEnumValue("1124-7")
	_11247("1124-7"),
	@XmlEnumValue("1125-4")
	_11254("1125-4"),
	@XmlEnumValue("1126-2")
	_11262("1126-2"),
	@XmlEnumValue("1127-0")
	_11270("1127-0"),
	@XmlEnumValue("1128-8")
	_11288("1128-8"),
	@XmlEnumValue("1129-6")
	_11296("1129-6"),
	@XmlEnumValue("1130-4")
	_11304("1130-4"),
	@XmlEnumValue("1131-2")
	_11312("1131-2"),
	@XmlEnumValue("1132-0")
	_11320("1132-0"),
	@XmlEnumValue("1133-8")
	_11338("1133-8"),
	@XmlEnumValue("1134-6")
	_11346("1134-6"),
	@XmlEnumValue("1135-3")
	_11353("1135-3"),
	@XmlEnumValue("1136-1")
	_11361("1136-1"),
	@XmlEnumValue("1137-9")
	_11379("1137-9"),
	@XmlEnumValue("1138-7")
	_11387("1138-7"),
	@XmlEnumValue("1139-5")
	_11395("1139-5"),
	@XmlEnumValue("1140-3")
	_11403("1140-3"),
	@XmlEnumValue("1141-1")
	_11411("1141-1"),
	@XmlEnumValue("1142-9")
	_11429("1142-9"),
	@XmlEnumValue("1143-7")
	_11437("1143-7"),
	@XmlEnumValue("1144-5")
	_11445("1144-5"),
	@XmlEnumValue("1145-2")
	_11452("1145-2"),
	@XmlEnumValue("1146-0")
	_11460("1146-0"),
	@XmlEnumValue("1147-8")
	_11478("1147-8"),
	@XmlEnumValue("1148-6")
	_11486("1148-6");
	
	private final String value;

    RaceAmericanIndianChippewa(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RaceAmericanIndianChippewa fromValue(String v) {
        for (RaceAmericanIndianChippewa c: RaceAmericanIndianChippewa.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}