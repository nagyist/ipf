/**
 * ActRelationshipFulfills.java
 * <p>
 * File generated from the voc::ActRelationshipFulfills uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ActRelationshipFulfills.
 *
 */

@XmlType(name = "ActRelationshipFulfills")
@XmlEnum
@XmlRootElement(name = "ActRelationshipFulfills")
public enum ActRelationshipFulfills {
	@XmlEnumValue("FLFS")
	FLFS("FLFS"),
	@XmlEnumValue("OCCR")
	OCCR("OCCR"),
	@XmlEnumValue("OREF")
	OREF("OREF"),
	@XmlEnumValue("SCH")
	SCH("SCH");
	
	private final String value;

    ActRelationshipFulfills(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ActRelationshipFulfills fromValue(String v) {
        for (ActRelationshipFulfills c: ActRelationshipFulfills.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}