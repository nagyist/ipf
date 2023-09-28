/**
 * ActClassEntry.java
 *
 * File generated from the voc::ActClassEntry uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ActClassEntry.
 *
 */

@XmlType(name = "ActClassEntry")
@XmlEnum
@XmlRootElement(name = "ActClassEntry")
public enum ActClassEntry {
	@XmlEnumValue("BATTERY")
	BATTERY("BATTERY"),
	@XmlEnumValue("CLUSTER")
	CLUSTER("CLUSTER"),
	@XmlEnumValue("ENTRY")
	ENTRY("ENTRY");
	
	private final String value;

    ActClassEntry(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ActClassEntry fromValue(String v) {
        for (ActClassEntry c: ActClassEntry.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}