/**
 * ResearchSubjectRoleBasis.java
 *
 * File generated from the voc::ResearchSubjectRoleBasis uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ResearchSubjectRoleBasis.
 *
 */

@XmlType(name = "ResearchSubjectRoleBasis")
@XmlEnum
@XmlRootElement(name = "ResearchSubjectRoleBasis")
public enum ResearchSubjectRoleBasis {
	@XmlEnumValue("ERL")
	ERL("ERL"),
	@XmlEnumValue("SCN")
	SCN("SCN");
	
	private final String value;

    ResearchSubjectRoleBasis(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ResearchSubjectRoleBasis fromValue(String v) {
        for (ResearchSubjectRoleBasis c: ResearchSubjectRoleBasis.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}