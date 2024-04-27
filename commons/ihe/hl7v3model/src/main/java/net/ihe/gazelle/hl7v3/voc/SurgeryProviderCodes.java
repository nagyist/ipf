/**
 * SurgeryProviderCodes.java
 *
 * File generated from the voc::SurgeryProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration SurgeryProviderCodes.
 *
 */

@XmlType(name = "SurgeryProviderCodes")
@XmlEnum
@XmlRootElement(name = "SurgeryProviderCodes")
public enum SurgeryProviderCodes {
	@XmlEnumValue("204F00000X")
	_204F00000X("204F00000X"),
	@XmlEnumValue("208600000X")
	_208600000X("208600000X"),
	@XmlEnumValue("2086S0102X")
	_2086S0102X("2086S0102X"),
	@XmlEnumValue("2086S0105X")
	_2086S0105X("2086S0105X"),
	@XmlEnumValue("2086S0120X")
	_2086S0120X("2086S0120X"),
	@XmlEnumValue("2086S0122X")
	_2086S0122X("2086S0122X"),
	@XmlEnumValue("2086S0127X")
	_2086S0127X("2086S0127X"),
	@XmlEnumValue("2086S0129X")
	_2086S0129X("2086S0129X"),
	@XmlEnumValue("2086X0206X")
	_2086X0206X("2086X0206X"),
	@XmlEnumValue("208G00000X")
	_208G00000X("208G00000X");
	
	private final String value;

    SurgeryProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static SurgeryProviderCodes fromValue(String v) {
        for (SurgeryProviderCodes c: SurgeryProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}