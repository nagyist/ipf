/**
 * EntityNamePartType.java
 * <p>
 * File generated from the voc::EntityNamePartType uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration EntityNamePartType.
 *
 */

@XmlType(name = "EntityNamePartType")
@XmlEnum
@XmlRootElement(name = "EntityNamePartType")
public enum EntityNamePartType {
	@XmlEnumValue("DEL")
	DEL("DEL"),
	@XmlEnumValue("FAM")
	FAM("FAM"),
	@XmlEnumValue("GIV")
	GIV("GIV"),
	@XmlEnumValue("PFX")
	PFX("PFX"),
	@XmlEnumValue("SFX")
	SFX("SFX");
	
	private final String value;

    EntityNamePartType(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static EntityNamePartType fromValue(String v) {
        for (EntityNamePartType c: EntityNamePartType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}