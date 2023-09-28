/**
 * TopicalPowder.java
 *
 * File generated from the voc::TopicalPowder uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration TopicalPowder.
 *
 */

@XmlType(name = "TopicalPowder")
@XmlEnum
@XmlRootElement(name = "TopicalPowder")
public enum TopicalPowder {
	@XmlEnumValue("RECPWD")
	RECPWD("RECPWD"),
	@XmlEnumValue("TOPPWD")
	TOPPWD("TOPPWD"),
	@XmlEnumValue("VAGPWD")
	VAGPWD("VAGPWD");
	
	private final String value;

    TopicalPowder(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static TopicalPowder fromValue(String v) {
        for (TopicalPowder c: TopicalPowder.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}