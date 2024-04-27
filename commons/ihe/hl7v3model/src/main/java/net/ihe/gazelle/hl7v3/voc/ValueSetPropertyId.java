/**
 * ValueSetPropertyId.java
 *
 * File generated from the voc::ValueSetPropertyId uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ValueSetPropertyId.
 *
 */

@XmlType(name = "ValueSetPropertyId")
@XmlEnum
@XmlRootElement(name = "ValueSetPropertyId")
public enum ValueSetPropertyId {
	@XmlEnumValue("appliesTo")
	APPLIESTO("appliesTo"),
	@XmlEnumValue("howApplies")
	HOWAPPLIES("howApplies"),
	@XmlEnumValue("openIssue")
	OPENISSUE("openIssue");
	
	private final String value;

    ValueSetPropertyId(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ValueSetPropertyId fromValue(String v) {
        for (ValueSetPropertyId c: ValueSetPropertyId.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}