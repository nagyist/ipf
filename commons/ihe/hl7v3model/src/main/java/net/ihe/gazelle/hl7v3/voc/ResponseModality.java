/**
 * ResponseModality.java
 *
 * File generated from the voc::ResponseModality uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ResponseModality.
 *
 */

@XmlType(name = "ResponseModality")
@XmlEnum
@XmlRootElement(name = "ResponseModality")
public enum ResponseModality {
	@XmlEnumValue("B")
	B("B"),
	@XmlEnumValue("R")
	R("R"),
	@XmlEnumValue("T")
	T("T");
	
	private final String value;

    ResponseModality(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ResponseModality fromValue(String v) {
        for (ResponseModality c: ResponseModality.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}