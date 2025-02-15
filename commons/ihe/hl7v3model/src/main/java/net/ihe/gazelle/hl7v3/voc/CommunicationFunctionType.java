/**
 * CommunicationFunctionType.java
 * <p>
 * File generated from the voc::CommunicationFunctionType uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration CommunicationFunctionType.
 *
 */

@XmlType(name = "CommunicationFunctionType")
@XmlEnum
@XmlRootElement(name = "CommunicationFunctionType")
public enum CommunicationFunctionType {
	@XmlEnumValue("RCV")
	RCV("RCV"),
	@XmlEnumValue("RSP")
	RSP("RSP"),
	@XmlEnumValue("SND")
	SND("SND");
	
	private final String value;

    CommunicationFunctionType(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static CommunicationFunctionType fromValue(String v) {
        for (CommunicationFunctionType c: CommunicationFunctionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}