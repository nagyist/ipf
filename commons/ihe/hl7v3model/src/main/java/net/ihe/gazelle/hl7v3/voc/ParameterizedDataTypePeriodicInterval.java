/**
 * ParameterizedDataTypePeriodicInterval.java
 *
 * File generated from the voc::ParameterizedDataTypePeriodicInterval uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ParameterizedDataTypePeriodicInterval.
 *
 */

@XmlType(name = "ParameterizedDataTypePeriodicInterval")
@XmlEnum
@XmlRootElement(name = "ParameterizedDataTypePeriodicInterval")
public enum ParameterizedDataTypePeriodicInterval {
	@XmlEnumValue("PIVL<T>")
	PIVLT("PIVL<T>");
	
	private final String value;

    ParameterizedDataTypePeriodicInterval(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ParameterizedDataTypePeriodicInterval fromValue(String v) {
        for (ParameterizedDataTypePeriodicInterval c: ParameterizedDataTypePeriodicInterval.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}