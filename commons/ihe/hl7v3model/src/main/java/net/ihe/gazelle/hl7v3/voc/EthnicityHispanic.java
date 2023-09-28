/**
 * EthnicityHispanic.java
 *
 * File generated from the voc::EthnicityHispanic uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration EthnicityHispanic.
 *
 */

@XmlType(name = "EthnicityHispanic")
@XmlEnum
@XmlRootElement(name = "EthnicityHispanic")
public enum EthnicityHispanic {
	@XmlEnumValue("2135-2")
	_21352("2135-2"),
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
	_21469("2146-9"),
	@XmlEnumValue("2148-5")
	_21485("2148-5"),
	@XmlEnumValue("2149-3")
	_21493("2149-3"),
	@XmlEnumValue("2150-1")
	_21501("2150-1"),
	@XmlEnumValue("2151-9")
	_21519("2151-9"),
	@XmlEnumValue("2152-7")
	_21527("2152-7"),
	@XmlEnumValue("2153-5")
	_21535("2153-5"),
	@XmlEnumValue("2155-0")
	_21550("2155-0"),
	@XmlEnumValue("2156-8")
	_21568("2156-8"),
	@XmlEnumValue("2157-6")
	_21576("2157-6"),
	@XmlEnumValue("2158-4")
	_21584("2158-4"),
	@XmlEnumValue("2159-2")
	_21592("2159-2"),
	@XmlEnumValue("2160-0")
	_21600("2160-0"),
	@XmlEnumValue("2161-8")
	_21618("2161-8"),
	@XmlEnumValue("2162-6")
	_21626("2162-6"),
	@XmlEnumValue("2163-4")
	_21634("2163-4"),
	@XmlEnumValue("2165-9")
	_21659("2165-9"),
	@XmlEnumValue("2166-7")
	_21667("2166-7"),
	@XmlEnumValue("2167-5")
	_21675("2167-5"),
	@XmlEnumValue("2168-3")
	_21683("2168-3"),
	@XmlEnumValue("2169-1")
	_21691("2169-1"),
	@XmlEnumValue("2170-9")
	_21709("2170-9"),
	@XmlEnumValue("2171-7")
	_21717("2171-7"),
	@XmlEnumValue("2172-5")
	_21725("2172-5"),
	@XmlEnumValue("2173-3")
	_21733("2173-3"),
	@XmlEnumValue("2174-1")
	_21741("2174-1"),
	@XmlEnumValue("2175-8")
	_21758("2175-8"),
	@XmlEnumValue("2176-6")
	_21766("2176-6"),
	@XmlEnumValue("2178-2")
	_21782("2178-2"),
	@XmlEnumValue("2180-8")
	_21808("2180-8"),
	@XmlEnumValue("2182-4")
	_21824("2182-4"),
	@XmlEnumValue("2184-0")
	_21840("2184-0");
	
	private final String value;

    EthnicityHispanic(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static EthnicityHispanic fromValue(String v) {
        for (EthnicityHispanic c: EthnicityHispanic.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}