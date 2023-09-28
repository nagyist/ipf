/**
 * GroupProviderCodes.java
 *
 * File generated from the voc::GroupProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration GroupProviderCodes.
 *
 */

@XmlType(name = "GroupProviderCodes")
@XmlEnum
@XmlRootElement(name = "GroupProviderCodes")
public enum GroupProviderCodes {
	@XmlEnumValue("190000000X")
	_190000000X("190000000X"),
	@XmlEnumValue("193200000X")
	_193200000X("193200000X"),
	@XmlEnumValue("193400000X")
	_193400000X("193400000X");
	
	private final String value;

    GroupProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static GroupProviderCodes fromValue(String v) {
        for (GroupProviderCodes c: GroupProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}