/**
 * ActRelationshipCostTracking.java
 * <p>
 * File generated from the voc::ActRelationshipCostTracking uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ActRelationshipCostTracking.
 *
 */

@XmlType(name = "ActRelationshipCostTracking")
@XmlEnum
@XmlRootElement(name = "ActRelationshipCostTracking")
public enum ActRelationshipCostTracking {
	@XmlEnumValue("CHRG")
	CHRG("CHRG"),
	@XmlEnumValue("COST")
	COST("COST");
	
	private final String value;

    ActRelationshipCostTracking(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ActRelationshipCostTracking fromValue(String v) {
        for (ActRelationshipCostTracking c: ActRelationshipCostTracking.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}