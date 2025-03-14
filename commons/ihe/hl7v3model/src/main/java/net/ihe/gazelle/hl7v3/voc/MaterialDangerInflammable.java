/**
 * MaterialDangerInflammable.java
 * <p>
 * File generated from the voc::MaterialDangerInflammable uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration MaterialDangerInflammable.
 *
 */

@XmlType(name = "MaterialDangerInflammable")
@XmlEnum
@XmlRootElement(name = "MaterialDangerInflammable")
public enum MaterialDangerInflammable {
	@XmlEnumValue("EXP")
	EXP("EXP"),
	@XmlEnumValue("IFL")
	IFL("IFL");
	
	private final String value;

    MaterialDangerInflammable(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static MaterialDangerInflammable fromValue(String v) {
        for (MaterialDangerInflammable c: MaterialDangerInflammable.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}