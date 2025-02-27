/**
 * GrandChild.java
 * <p>
 * File generated from the voc::GrandChild uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration GrandChild.
 *
 */

@XmlType(name = "GrandChild")
@XmlEnum
@XmlRootElement(name = "GrandChild")
public enum GrandChild {
	@XmlEnumValue("GRNDCHILD")
	GRNDCHILD("GRNDCHILD"),
	@XmlEnumValue("GRNDDAU")
	GRNDDAU("GRNDDAU"),
	@XmlEnumValue("GRNDSON")
	GRNDSON("GRNDSON");
	
	private final String value;

    GrandChild(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static GrandChild fromValue(String v) {
        for (GrandChild c: GrandChild.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}