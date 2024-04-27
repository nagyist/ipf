/**
 * ConceptStatus.java
 *
 * File generated from the voc::ConceptStatus uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ConceptStatus.
 *
 */

@XmlType(name = "ConceptStatus")
@XmlEnum
@XmlRootElement(name = "ConceptStatus")
public enum ConceptStatus {
	@XmlEnumValue("A")
	A("A"),
	@XmlEnumValue("D")
	D("D"),
	@XmlEnumValue("P")
	P("P"),
	@XmlEnumValue("R")
	R("R");
	
	private final String value;

    ConceptStatus(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ConceptStatus fromValue(String v) {
        for (ConceptStatus c: ConceptStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}