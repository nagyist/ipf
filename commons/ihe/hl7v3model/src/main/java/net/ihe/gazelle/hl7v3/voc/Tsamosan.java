/**
 * Tsamosan.java
 * <p>
 * File generated from the voc::Tsamosan uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration Tsamosan.
 *
 */

@XmlType(name = "Tsamosan")
@XmlEnum
@XmlRootElement(name = "Tsamosan")
public enum Tsamosan {
	@XmlEnumValue("x-CEA")
	XCEA("x-CEA"),
	@XmlEnumValue("x-CJH")
	XCJH("x-CJH"),
	@XmlEnumValue("x-COW")
	XCOW("x-COW"),
	@XmlEnumValue("x-QUN")
	XQUN("x-QUN");
	
	private final String value;

    Tsamosan(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static Tsamosan fromValue(String v) {
        for (Tsamosan c: Tsamosan.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}