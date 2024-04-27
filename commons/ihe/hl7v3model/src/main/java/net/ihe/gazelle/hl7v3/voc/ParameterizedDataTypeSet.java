/**
 * ParameterizedDataTypeSet.java
 *
 * File generated from the voc::ParameterizedDataTypeSet uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ParameterizedDataTypeSet.
 *
 */

@XmlType(name = "ParameterizedDataTypeSet")
@XmlEnum
@XmlRootElement(name = "ParameterizedDataTypeSet")
public enum ParameterizedDataTypeSet {
	@XmlEnumValue("EIVL<T>")
	EIVLT("EIVL<T>"),
	@XmlEnumValue("IVL<T>")
	IVLT("IVL<T>"),
	@XmlEnumValue("PIVL<T>")
	PIVLT("PIVL<T>"),
	@XmlEnumValue("SET<T>")
	SETT("SET<T>");
	
	private final String value;

    ParameterizedDataTypeSet(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ParameterizedDataTypeSet fromValue(String v) {
        for (ParameterizedDataTypeSet c: ParameterizedDataTypeSet.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}