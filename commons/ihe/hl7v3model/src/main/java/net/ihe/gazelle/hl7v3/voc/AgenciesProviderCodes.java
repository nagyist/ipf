/**
 * AgenciesProviderCodes.java
 * <p>
 * File generated from the voc::AgenciesProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration AgenciesProviderCodes.
 *
 */

@XmlType(name = "AgenciesProviderCodes")
@XmlEnum
@XmlRootElement(name = "AgenciesProviderCodes")
public enum AgenciesProviderCodes {
	@XmlEnumValue("250000000X")
	_250000000X("250000000X"),
	@XmlEnumValue("251B00000X")
	_251B00000X("251B00000X"),
	@XmlEnumValue("251C00000X")
	_251C00000X("251C00000X"),
	@XmlEnumValue("251E00000X")
	_251E00000X("251E00000X"),
	@XmlEnumValue("251F00000X")
	_251F00000X("251F00000X"),
	@XmlEnumValue("251G00000X")
	_251G00000X("251G00000X"),
	@XmlEnumValue("251J00000X")
	_251J00000X("251J00000X"),
	@XmlEnumValue("251K00000X")
	_251K00000X("251K00000X"),
	@XmlEnumValue("251V00000X")
	_251V00000X("251V00000X");
	
	private final String value;

    AgenciesProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static AgenciesProviderCodes fromValue(String v) {
        for (AgenciesProviderCodes c: AgenciesProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}