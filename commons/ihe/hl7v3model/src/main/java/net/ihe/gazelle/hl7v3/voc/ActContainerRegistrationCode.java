/**
 * ActContainerRegistrationCode.java
 *
 * File generated from the voc::ActContainerRegistrationCode uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ActContainerRegistrationCode.
 *
 */

@XmlType(name = "ActContainerRegistrationCode")
@XmlEnum
@XmlRootElement(name = "ActContainerRegistrationCode")
public enum ActContainerRegistrationCode {
	@XmlEnumValue("ID")
	ID("ID"),
	@XmlEnumValue("IP")
	IP("IP"),
	@XmlEnumValue("L")
	L("L"),
	@XmlEnumValue("M")
	M("M"),
	@XmlEnumValue("O")
	O("O"),
	@XmlEnumValue("R")
	R("R"),
	@XmlEnumValue("X")
	X("X");
	
	private final String value;

    ActContainerRegistrationCode(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ActContainerRegistrationCode fromValue(String v) {
        for (ActContainerRegistrationCode c: ActContainerRegistrationCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}