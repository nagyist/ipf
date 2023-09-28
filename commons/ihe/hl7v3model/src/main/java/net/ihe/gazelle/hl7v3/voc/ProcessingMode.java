/**
 * ProcessingMode.java
 *
 * File generated from the voc::ProcessingMode uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ProcessingMode.
 *
 */

@XmlType(name = "ProcessingMode")
@XmlEnum
@XmlRootElement(name = "ProcessingMode")
public enum ProcessingMode {
	@XmlEnumValue("A")
	A("A"),
	@XmlEnumValue("I")
	I("I"),
	@XmlEnumValue("R")
	R("R"),
	@XmlEnumValue("T")
	T("T");
	
	private final String value;

    ProcessingMode(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ProcessingMode fromValue(String v) {
        for (ProcessingMode c: ProcessingMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}