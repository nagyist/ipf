/**
 * RaceAmericanIndianSioux.java
 *
 * File generated from the voc::RaceAmericanIndianSioux uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RaceAmericanIndianSioux.
 *
 */

@XmlType(name = "RaceAmericanIndianSioux")
@XmlEnum
@XmlRootElement(name = "RaceAmericanIndianSioux")
public enum RaceAmericanIndianSioux {
	@XmlEnumValue("1609-7")
	_16097("1609-7"),
	@XmlEnumValue("1610-5")
	_16105("1610-5"),
	@XmlEnumValue("1611-3")
	_16113("1611-3"),
	@XmlEnumValue("1612-1")
	_16121("1612-1"),
	@XmlEnumValue("1613-9")
	_16139("1613-9"),
	@XmlEnumValue("1614-7")
	_16147("1614-7"),
	@XmlEnumValue("1615-4")
	_16154("1615-4"),
	@XmlEnumValue("1616-2")
	_16162("1616-2"),
	@XmlEnumValue("1617-0")
	_16170("1617-0"),
	@XmlEnumValue("1618-8")
	_16188("1618-8"),
	@XmlEnumValue("1619-6")
	_16196("1619-6"),
	@XmlEnumValue("1620-4")
	_16204("1620-4"),
	@XmlEnumValue("1621-2")
	_16212("1621-2"),
	@XmlEnumValue("1622-0")
	_16220("1622-0"),
	@XmlEnumValue("1623-8")
	_16238("1623-8"),
	@XmlEnumValue("1624-6")
	_16246("1624-6"),
	@XmlEnumValue("1625-3")
	_16253("1625-3"),
	@XmlEnumValue("1626-1")
	_16261("1626-1"),
	@XmlEnumValue("1627-9")
	_16279("1627-9"),
	@XmlEnumValue("1628-7")
	_16287("1628-7"),
	@XmlEnumValue("1629-5")
	_16295("1629-5"),
	@XmlEnumValue("1630-3")
	_16303("1630-3"),
	@XmlEnumValue("1631-1")
	_16311("1631-1"),
	@XmlEnumValue("1632-9")
	_16329("1632-9"),
	@XmlEnumValue("1633-7")
	_16337("1633-7"),
	@XmlEnumValue("1634-5")
	_16345("1634-5"),
	@XmlEnumValue("1635-2")
	_16352("1635-2"),
	@XmlEnumValue("1636-0")
	_16360("1636-0"),
	@XmlEnumValue("1637-8")
	_16378("1637-8"),
	@XmlEnumValue("1638-6")
	_16386("1638-6"),
	@XmlEnumValue("1639-4")
	_16394("1639-4"),
	@XmlEnumValue("1640-2")
	_16402("1640-2"),
	@XmlEnumValue("1641-0")
	_16410("1641-0");
	
	private final String value;

    RaceAmericanIndianSioux(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RaceAmericanIndianSioux fromValue(String v) {
        for (RaceAmericanIndianSioux c: RaceAmericanIndianSioux.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}