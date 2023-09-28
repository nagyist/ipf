/**
 * HomeAddressUse.java
 *
 * File generated from the voc::HomeAddressUse uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration HomeAddressUse.
 *
 */

@XmlType(name = "HomeAddressUse")
@XmlEnum
@XmlRootElement(name = "HomeAddressUse")
public enum HomeAddressUse {
	@XmlEnumValue("H")
	H("H"),
	@XmlEnumValue("HP")
	HP("HP"),
	@XmlEnumValue("HV")
	HV("HV");
	
	private final String value;

    HomeAddressUse(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static HomeAddressUse fromValue(String v) {
        for (HomeAddressUse c: HomeAddressUse.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}