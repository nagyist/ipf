/**
 * SerranoGabrielino.java
 *
 * File generated from the voc::SerranoGabrielino uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration SerranoGabrielino.
 *
 */

@XmlType(name = "SerranoGabrielino")
@XmlEnum
@XmlRootElement(name = "SerranoGabrielino")
public enum SerranoGabrielino {
	@XmlEnumValue("x-SER")
	XSER("x-SER");
	
	private final String value;

    SerranoGabrielino(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static SerranoGabrielino fromValue(String v) {
        for (SerranoGabrielino c: SerranoGabrielino.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}