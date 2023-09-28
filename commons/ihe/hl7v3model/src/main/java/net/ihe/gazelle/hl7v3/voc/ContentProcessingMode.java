/**
 * ContentProcessingMode.java
 *
 * File generated from the voc::ContentProcessingMode uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ContentProcessingMode.
 *
 */

@XmlType(name = "ContentProcessingMode")
@XmlEnum
@XmlRootElement(name = "ContentProcessingMode")
public enum ContentProcessingMode {
	@XmlEnumValue("SEQL")
	SEQL("SEQL"),
	@XmlEnumValue("UNOR")
	UNOR("UNOR");
	
	private final String value;

    ContentProcessingMode(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ContentProcessingMode fromValue(String v) {
        for (ContentProcessingMode c: ContentProcessingMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}