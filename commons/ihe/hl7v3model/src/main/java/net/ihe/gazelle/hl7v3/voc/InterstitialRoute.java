/**
 * InterstitialRoute.java
 *
 * File generated from the voc::InterstitialRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration InterstitialRoute.
 *
 */

@XmlType(name = "InterstitialRoute")
@XmlEnum
@XmlRootElement(name = "InterstitialRoute")
public enum InterstitialRoute {
	@XmlEnumValue("INTERSTITINJ")
	INTERSTITINJ("INTERSTITINJ");
	
	private final String value;

    InterstitialRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static InterstitialRoute fromValue(String v) {
        for (InterstitialRoute c: InterstitialRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}