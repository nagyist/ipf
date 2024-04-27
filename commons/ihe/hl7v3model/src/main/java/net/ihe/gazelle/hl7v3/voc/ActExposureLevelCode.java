/**
 * ActExposureLevelCode.java
 *
 * File generated from the voc::ActExposureLevelCode uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ActExposureLevelCode.
 *
 */

@XmlType(name = "ActExposureLevelCode")
@XmlEnum
@XmlRootElement(name = "ActExposureLevelCode")
public enum ActExposureLevelCode {
	@XmlEnumValue("HIGH")
	HIGH("HIGH"),
	@XmlEnumValue("LOW")
	LOW("LOW"),
	@XmlEnumValue("MEDIUM")
	MEDIUM("MEDIUM");
	
	private final String value;

    ActExposureLevelCode(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ActExposureLevelCode fromValue(String v) {
        for (ActExposureLevelCode c: ActExposureLevelCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}