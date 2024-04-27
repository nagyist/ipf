/**
 * ERPracticeSetting.java
 *
 * File generated from the voc::ERPracticeSetting uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ERPracticeSetting.
 *
 */

@XmlType(name = "ERPracticeSetting")
@XmlEnum
@XmlRootElement(name = "ERPracticeSetting")
public enum ERPracticeSetting {
	@XmlEnumValue("ER")
	ER("ER"),
	@XmlEnumValue("ETU")
	ETU("ETU");
	
	private final String value;

    ERPracticeSetting(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ERPracticeSetting fromValue(String v) {
        for (ERPracticeSetting c: ERPracticeSetting.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}