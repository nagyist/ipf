/**
 * XDeterminerInstanceKind.java
 * <p>
 * File generated from the voc::XDeterminerInstanceKind uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration XDeterminerInstanceKind.
 *
 */

@XmlType(name = "XDeterminerInstanceKind")
@XmlEnum
@XmlRootElement(name = "XDeterminerInstanceKind")
public enum XDeterminerInstanceKind {
	@XmlEnumValue("INSTANCE")
	INSTANCE("INSTANCE"),
	@XmlEnumValue("KIND")
	KIND("KIND"),
	@XmlEnumValue("QUANTIFIED_KIND")
	QUANTIFIEDKIND("QUANTIFIED_KIND");
	
	private final String value;

    XDeterminerInstanceKind(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static XDeterminerInstanceKind fromValue(String v) {
        for (XDeterminerInstanceKind c: XDeterminerInstanceKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}