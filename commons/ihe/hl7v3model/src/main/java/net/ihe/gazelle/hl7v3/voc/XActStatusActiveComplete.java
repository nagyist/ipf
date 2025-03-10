/**
 * XActStatusActiveComplete.java
 * <p>
 * File generated from the voc::XActStatusActiveComplete uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration XActStatusActiveComplete.
 *
 */

@XmlType(name = "XActStatusActiveComplete")
@XmlEnum
@XmlRootElement(name = "XActStatusActiveComplete")
public enum XActStatusActiveComplete {
	@XmlEnumValue("active")
	ACTIVE("active"),
	@XmlEnumValue("completed")
	COMPLETED("completed");
	
	private final String value;

    XActStatusActiveComplete(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static XActStatusActiveComplete fromValue(String v) {
        for (XActStatusActiveComplete c: XActStatusActiveComplete.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}