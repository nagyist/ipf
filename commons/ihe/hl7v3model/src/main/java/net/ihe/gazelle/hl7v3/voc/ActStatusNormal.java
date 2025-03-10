/**
 * ActStatusNormal.java
 * <p>
 * File generated from the voc::ActStatusNormal uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ActStatusNormal.
 *
 */

@XmlType(name = "ActStatusNormal")
@XmlEnum
@XmlRootElement(name = "ActStatusNormal")
public enum ActStatusNormal {
	@XmlEnumValue("aborted")
	ABORTED("aborted"),
	@XmlEnumValue("active")
	ACTIVE("active"),
	@XmlEnumValue("cancelled")
	CANCELLED("cancelled"),
	@XmlEnumValue("completed")
	COMPLETED("completed"),
	@XmlEnumValue("held")
	HELD("held"),
	@XmlEnumValue("new")
	NEW("new"),
	@XmlEnumValue("normal")
	NORMAL("normal"),
	@XmlEnumValue("suspended")
	SUSPENDED("suspended");
	
	private final String value;

    ActStatusNormal(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ActStatusNormal fromValue(String v) {
        for (ActStatusNormal c: ActStatusNormal.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}