/**
 * RepetitionsOutOfRange.java
 * <p>
 * File generated from the voc::RepetitionsOutOfRange uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RepetitionsOutOfRange.
 *
 */

@XmlType(name = "RepetitionsOutOfRange")
@XmlEnum
@XmlRootElement(name = "RepetitionsOutOfRange")
public enum RepetitionsOutOfRange {
	@XmlEnumValue("MAXOCCURS")
	MAXOCCURS("MAXOCCURS"),
	@XmlEnumValue("MINOCCURS")
	MINOCCURS("MINOCCURS"),
	@XmlEnumValue("REP_RANGE")
	REPRANGE("REP_RANGE");
	
	private final String value;

    RepetitionsOutOfRange(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RepetitionsOutOfRange fromValue(String v) {
        for (RepetitionsOutOfRange c: RepetitionsOutOfRange.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}