/**
 * TopicalAbsorptionRoute.java
 *
 * File generated from the voc::TopicalAbsorptionRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration TopicalAbsorptionRoute.
 *
 */

@XmlType(name = "TopicalAbsorptionRoute")
@XmlEnum
@XmlRootElement(name = "TopicalAbsorptionRoute")
public enum TopicalAbsorptionRoute {
	@XmlEnumValue("TTYMPTABSORP")
	TTYMPTABSORP("TTYMPTABSORP");
	
	private final String value;

    TopicalAbsorptionRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static TopicalAbsorptionRoute fromValue(String v) {
        for (TopicalAbsorptionRoute c: TopicalAbsorptionRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}