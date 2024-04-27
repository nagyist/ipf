/**
 * GenericUpdateReasonCode.java
 *
 * File generated from the voc::GenericUpdateReasonCode uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration GenericUpdateReasonCode.
 *
 */

@XmlType(name = "GenericUpdateReasonCode")
@XmlEnum
@XmlRootElement(name = "GenericUpdateReasonCode")
public enum GenericUpdateReasonCode {
	@XmlEnumValue("CHGDATA")
	CHGDATA("CHGDATA"),
	@XmlEnumValue("FIXDATA")
	FIXDATA("FIXDATA"),
	@XmlEnumValue("NEWDATA")
	NEWDATA("NEWDATA");
	
	private final String value;

    GenericUpdateReasonCode(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static GenericUpdateReasonCode fromValue(String v) {
        for (GenericUpdateReasonCode c: GenericUpdateReasonCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}