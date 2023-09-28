/**
 * FontStyle.java
 *
 * File generated from the voc::FontStyle uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration FontStyle.
 *
 */

@XmlType(name = "FontStyle")
@XmlEnum
@XmlRootElement(name = "FontStyle")
public enum FontStyle {
	@XmlEnumValue("bold")
	BOLD("bold"),
	@XmlEnumValue("emphasis")
	EMPHASIS("emphasis"),
	@XmlEnumValue("italics")
	ITALICS("italics"),
	@XmlEnumValue("underline")
	UNDERLINE("underline");
	
	private final String value;

    FontStyle(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static FontStyle fromValue(String v) {
        for (FontStyle c: FontStyle.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}