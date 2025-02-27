/**
 * SubmucosalRoute.java
 * <p>
 * File generated from the voc::SubmucosalRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration SubmucosalRoute.
 *
 */

@XmlType(name = "SubmucosalRoute")
@XmlEnum
@XmlRootElement(name = "SubmucosalRoute")
public enum SubmucosalRoute {
	@XmlEnumValue("SMUCMAB")
	SMUCMAB("SMUCMAB"),
	@XmlEnumValue("SUBMUCINJ")
	SUBMUCINJ("SUBMUCINJ");
	
	private final String value;

    SubmucosalRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static SubmucosalRoute fromValue(String v) {
        for (SubmucosalRoute c: SubmucosalRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}