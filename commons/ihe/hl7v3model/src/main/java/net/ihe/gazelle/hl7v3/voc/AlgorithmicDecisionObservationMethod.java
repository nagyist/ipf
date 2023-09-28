/**
 * AlgorithmicDecisionObservationMethod.java
 *
 * File generated from the voc::AlgorithmicDecisionObservationMethod uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration AlgorithmicDecisionObservationMethod.
 *
 */

@XmlType(name = "AlgorithmicDecisionObservationMethod")
@XmlEnum
@XmlRootElement(name = "AlgorithmicDecisionObservationMethod")
public enum AlgorithmicDecisionObservationMethod {
	@XmlEnumValue("ALGM")
	ALGM("ALGM"),
	@XmlEnumValue("BYCL")
	BYCL("BYCL");
	
	private final String value;

    AlgorithmicDecisionObservationMethod(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static AlgorithmicDecisionObservationMethod fromValue(String v) {
        for (AlgorithmicDecisionObservationMethod c: AlgorithmicDecisionObservationMethod.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}