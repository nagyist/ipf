/**
 * ActInsurancePolicyCodeAutomobileByBOT.java
 * <p>
 * File generated from the voc::ActInsurancePolicyCodeAutomobileByBOT uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ActInsurancePolicyCodeAutomobileByBOT.
 *
 */

@XmlType(name = "ActInsurancePolicyCodeAutomobileByBOT")
@XmlEnum
@XmlRootElement(name = "ActInsurancePolicyCodeAutomobileByBOT")
public enum ActInsurancePolicyCodeAutomobileByBOT {
	@XmlEnumValue("AUTOPOL")
	AUTOPOL("AUTOPOL"),
	@XmlEnumValue("COL")
	COL("COL"),
	@XmlEnumValue("UNINSMOT")
	UNINSMOT("UNINSMOT");
	
	private final String value;

    ActInsurancePolicyCodeAutomobileByBOT(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ActInsurancePolicyCodeAutomobileByBOT fromValue(String v) {
        for (ActInsurancePolicyCodeAutomobileByBOT c: ActInsurancePolicyCodeAutomobileByBOT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}