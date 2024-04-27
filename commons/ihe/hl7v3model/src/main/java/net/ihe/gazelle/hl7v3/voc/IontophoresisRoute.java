/**
 * IontophoresisRoute.java
 *
 * File generated from the voc::IontophoresisRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration IontophoresisRoute.
 *
 */

@XmlType(name = "IontophoresisRoute")
@XmlEnum
@XmlRootElement(name = "IontophoresisRoute")
public enum IontophoresisRoute {
	@XmlEnumValue("IONTO")
	IONTO("IONTO");
	
	private final String value;

    IontophoresisRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static IontophoresisRoute fromValue(String v) {
        for (IontophoresisRoute c: IontophoresisRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}