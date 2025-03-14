/**
 * UreteralRoute.java
 * <p>
 * File generated from the voc::UreteralRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration UreteralRoute.
 *
 */

@XmlType(name = "UreteralRoute")
@XmlEnum
@XmlRootElement(name = "UreteralRoute")
public enum UreteralRoute {
	@XmlEnumValue("URETINJ")
	URETINJ("URETINJ");
	
	private final String value;

    UreteralRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static UreteralRoute fromValue(String v) {
        for (UreteralRoute c: UreteralRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}