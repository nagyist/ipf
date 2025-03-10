/**
 * ProbabilityDistributionType.java
 * <p>
 * File generated from the voc::ProbabilityDistributionType uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ProbabilityDistributionType.
 *
 */

@XmlType(name = "ProbabilityDistributionType")
@XmlEnum
@XmlRootElement(name = "ProbabilityDistributionType")
public enum ProbabilityDistributionType {
	@XmlEnumValue("B")
	B("B"),
	@XmlEnumValue("E")
	E("E"),
	@XmlEnumValue("F")
	F("F"),
	@XmlEnumValue("G")
	G("G"),
	@XmlEnumValue("LN")
	LN("LN"),
	@XmlEnumValue("N")
	N("N"),
	@XmlEnumValue("T")
	T("T"),
	@XmlEnumValue("U")
	U("U"),
	@XmlEnumValue("X2")
	X2("X2");
	
	private final String value;

    ProbabilityDistributionType(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ProbabilityDistributionType fromValue(String v) {
        for (ProbabilityDistributionType c: ProbabilityDistributionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}