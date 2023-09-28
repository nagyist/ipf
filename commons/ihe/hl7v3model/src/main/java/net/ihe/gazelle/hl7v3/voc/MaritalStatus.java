/**
 * MaritalStatus.java
 *
 * File generated from the voc::MaritalStatus uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration MaritalStatus.
 *
 */

@XmlType(name = "MaritalStatus")
@XmlEnum
@XmlRootElement(name = "MaritalStatus")
public enum MaritalStatus {
	@XmlEnumValue("A")
	A("A"),
	@XmlEnumValue("D")
	D("D"),
	@XmlEnumValue("I")
	I("I"),
	@XmlEnumValue("L")
	L("L"),
	@XmlEnumValue("M")
	M("M"),
	@XmlEnumValue("P")
	P("P"),
	@XmlEnumValue("S")
	S("S"),
	@XmlEnumValue("T")
	T("T"),
	@XmlEnumValue("W")
	W("W");
	
	private final String value;

    MaritalStatus(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static MaritalStatus fromValue(String v) {
        for (MaritalStatus c: MaritalStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}