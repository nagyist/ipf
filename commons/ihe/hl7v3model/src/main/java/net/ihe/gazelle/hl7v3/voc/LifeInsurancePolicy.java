/**
 * LifeInsurancePolicy.java
 *
 * File generated from the voc::LifeInsurancePolicy uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration LifeInsurancePolicy.
 *
 */

@XmlType(name = "LifeInsurancePolicy")
@XmlEnum
@XmlRootElement(name = "LifeInsurancePolicy")
public enum LifeInsurancePolicy {
	@XmlEnumValue("ANNU")
	ANNU("ANNU"),
	@XmlEnumValue("LIFE")
	LIFE("LIFE"),
	@XmlEnumValue("TLIFE")
	TLIFE("TLIFE"),
	@XmlEnumValue("ULIFE")
	ULIFE("ULIFE");
	
	private final String value;

    LifeInsurancePolicy(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static LifeInsurancePolicy fromValue(String v) {
        for (LifeInsurancePolicy c: LifeInsurancePolicy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}