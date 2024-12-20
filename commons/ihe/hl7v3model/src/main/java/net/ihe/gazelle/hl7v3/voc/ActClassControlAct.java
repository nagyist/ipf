/**
 * ActClassControlAct.java
 * <p>
 * File generated from the voc::ActClassControlAct uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ActClassControlAct.
 *
 */

@XmlType(name = "ActClassControlAct")
@XmlEnum
@XmlRootElement(name = "ActClassControlAct")
public enum ActClassControlAct {
	@XmlEnumValue("ACTN")
	ACTN("ACTN"),
	@XmlEnumValue("CACT")
	CACT("CACT"),
	@XmlEnumValue("INFO")
	INFO("INFO"),
	@XmlEnumValue("STC")
	STC("STC");
	
	private final String value;

    ActClassControlAct(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ActClassControlAct fromValue(String v) {
        for (ActClassControlAct c: ActClassControlAct.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}