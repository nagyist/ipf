/**
 * Transfer.java
 *
 * File generated from the voc::Transfer uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration Transfer.
 *
 */

@XmlType(name = "Transfer")
@XmlEnum
@XmlRootElement(name = "Transfer")
public enum Transfer {
	@XmlEnumValue("SALE")
	SALE("SALE"),
	@XmlEnumValue("TRANSFER")
	TRANSFER("TRANSFER");
	
	private final String value;

    Transfer(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static Transfer fromValue(String v) {
        for (Transfer c: Transfer.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}