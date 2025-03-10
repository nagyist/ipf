/**
 * SupplyAppropriateManagementCode.java
 * <p>
 * File generated from the voc::SupplyAppropriateManagementCode uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration SupplyAppropriateManagementCode.
 *
 */

@XmlType(name = "SupplyAppropriateManagementCode")
@XmlEnum
@XmlRootElement(name = "SupplyAppropriateManagementCode")
public enum SupplyAppropriateManagementCode {
	@XmlEnumValue("14")
	_14("14"),
	@XmlEnumValue("15")
	_15("15"),
	@XmlEnumValue("16")
	_16("16"),
	@XmlEnumValue("17")
	_17("17"),
	@XmlEnumValue("18")
	_18("18");
	
	private final String value;

    SupplyAppropriateManagementCode(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static SupplyAppropriateManagementCode fromValue(String v) {
        for (SupplyAppropriateManagementCode c: SupplyAppropriateManagementCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}