/**
 * EthnicityHispanicSpaniard.java
 * <p>
 * File generated from the voc::EthnicityHispanicSpaniard uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration EthnicityHispanicSpaniard.
 *
 */

@XmlType(name = "EthnicityHispanicSpaniard")
@XmlEnum
@XmlRootElement(name = "EthnicityHispanicSpaniard")
public enum EthnicityHispanicSpaniard {
	@XmlEnumValue("2137-8")
	_21378("2137-8"),
	@XmlEnumValue("2138-6")
	_21386("2138-6"),
	@XmlEnumValue("2139-4")
	_21394("2139-4"),
	@XmlEnumValue("2140-2")
	_21402("2140-2"),
	@XmlEnumValue("2141-0")
	_21410("2141-0"),
	@XmlEnumValue("2142-8")
	_21428("2142-8"),
	@XmlEnumValue("2143-6")
	_21436("2143-6"),
	@XmlEnumValue("2144-4")
	_21444("2144-4"),
	@XmlEnumValue("2145-1")
	_21451("2145-1"),
	@XmlEnumValue("2146-9")
	_21469("2146-9");
	
	private final String value;

    EthnicityHispanicSpaniard(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static EthnicityHispanicSpaniard fromValue(String v) {
        for (EthnicityHispanicSpaniard c: EthnicityHispanicSpaniard.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}