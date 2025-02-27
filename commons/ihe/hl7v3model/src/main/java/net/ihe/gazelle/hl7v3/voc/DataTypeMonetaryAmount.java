/**
 * DataTypeMonetaryAmount.java
 * <p>
 * File generated from the voc::DataTypeMonetaryAmount uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration DataTypeMonetaryAmount.
 *
 */

@XmlType(name = "DataTypeMonetaryAmount")
@XmlEnum
@XmlRootElement(name = "DataTypeMonetaryAmount")
public enum DataTypeMonetaryAmount {
	@XmlEnumValue("MO")
	MO("MO");
	
	private final String value;

    DataTypeMonetaryAmount(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static DataTypeMonetaryAmount fromValue(String v) {
        for (DataTypeMonetaryAmount c: DataTypeMonetaryAmount.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}