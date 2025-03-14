/**
 * ChiropracticProvidersProviderCodes.java
 * <p>
 * File generated from the voc::ChiropracticProvidersProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ChiropracticProvidersProviderCodes.
 *
 */

@XmlType(name = "ChiropracticProvidersProviderCodes")
@XmlEnum
@XmlRootElement(name = "ChiropracticProvidersProviderCodes")
public enum ChiropracticProvidersProviderCodes {
	@XmlEnumValue("110000000X")
	_110000000X("110000000X"),
	@XmlEnumValue("111N00000X")
	_111N00000X("111N00000X"),
	@XmlEnumValue("111NI0900X")
	_111NI0900X("111NI0900X"),
	@XmlEnumValue("111NN0400X")
	_111NN0400X("111NN0400X"),
	@XmlEnumValue("111NN1001X")
	_111NN1001X("111NN1001X"),
	@XmlEnumValue("111NR0200X")
	_111NR0200X("111NR0200X"),
	@XmlEnumValue("111NS0005X")
	_111NS0005X("111NS0005X"),
	@XmlEnumValue("111NT0100X")
	_111NT0100X("111NT0100X"),
	@XmlEnumValue("111NX0100X")
	_111NX0100X("111NX0100X"),
	@XmlEnumValue("111NX0800X")
	_111NX0800X("111NX0800X");
	
	private final String value;

    ChiropracticProvidersProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ChiropracticProvidersProviderCodes fromValue(String v) {
        for (ChiropracticProvidersProviderCodes c: ChiropracticProvidersProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}