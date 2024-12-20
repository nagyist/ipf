/**
 * ChiropractersHIPAA.java
 * <p>
 * File generated from the voc::ChiropractersHIPAA uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ChiropractersHIPAA.
 *
 */

@XmlType(name = "ChiropractersHIPAA")
@XmlEnum
@XmlRootElement(name = "ChiropractersHIPAA")
public enum ChiropractersHIPAA {
	@XmlEnumValue("111N00000N")
	_111N00000N("111N00000N"),
	@XmlEnumValue("111NI0900N")
	_111NI0900N("111NI0900N"),
	@XmlEnumValue("111NN0400N")
	_111NN0400N("111NN0400N"),
	@XmlEnumValue("111NN1001N")
	_111NN1001N("111NN1001N"),
	@XmlEnumValue("111NR0200N")
	_111NR0200N("111NR0200N"),
	@XmlEnumValue("111NS0005N")
	_111NS0005N("111NS0005N"),
	@XmlEnumValue("111NT0100N")
	_111NT0100N("111NT0100N"),
	@XmlEnumValue("111NX0100N")
	_111NX0100N("111NX0100N"),
	@XmlEnumValue("111NX0800N")
	_111NX0800N("111NX0800N");
	
	private final String value;

    ChiropractersHIPAA(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ChiropractersHIPAA fromValue(String v) {
        for (ChiropractersHIPAA c: ChiropractersHIPAA.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}