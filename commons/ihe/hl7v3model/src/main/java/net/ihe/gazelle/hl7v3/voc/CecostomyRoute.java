/**
 * CecostomyRoute.java
 * <p>
 * File generated from the voc::CecostomyRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration CecostomyRoute.
 *
 */

@XmlType(name = "CecostomyRoute")
@XmlEnum
@XmlRootElement(name = "CecostomyRoute")
public enum CecostomyRoute {
	@XmlEnumValue("CECINSTL")
	CECINSTL("CECINSTL");
	
	private final String value;

    CecostomyRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static CecostomyRoute fromValue(String v) {
        for (CecostomyRoute c: CecostomyRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}