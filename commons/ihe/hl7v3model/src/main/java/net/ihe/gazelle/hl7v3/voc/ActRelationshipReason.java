/**
 * ActRelationshipReason.java
 * <p>
 * File generated from the voc::ActRelationshipReason uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ActRelationshipReason.
 *
 */

@XmlType(name = "ActRelationshipReason")
@XmlEnum
@XmlRootElement(name = "ActRelationshipReason")
public enum ActRelationshipReason {
	@XmlEnumValue("BLOCK")
	BLOCK("BLOCK"),
	@XmlEnumValue("CURE")
	CURE("CURE"),
	@XmlEnumValue("CURE.ADJ")
	CUREADJ("CURE.ADJ"),
	@XmlEnumValue("DIAG")
	DIAG("DIAG"),
	@XmlEnumValue("MITGT")
	MITGT("MITGT"),
	@XmlEnumValue("MTGT.ADJ")
	MTGTADJ("MTGT.ADJ"),
	@XmlEnumValue("RCVY")
	RCVY("RCVY"),
	@XmlEnumValue("RSON")
	RSON("RSON"),
	@XmlEnumValue("SYMP")
	SYMP("SYMP");
	
	private final String value;

    ActRelationshipReason(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ActRelationshipReason fromValue(String v) {
        for (ActRelationshipReason c: ActRelationshipReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}