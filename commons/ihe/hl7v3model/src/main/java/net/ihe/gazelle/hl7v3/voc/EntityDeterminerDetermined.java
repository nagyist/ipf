/**
 * EntityDeterminerDetermined.java
 *
 * File generated from the voc::EntityDeterminerDetermined uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration EntityDeterminerDetermined.
 *
 */

@XmlType(name = "EntityDeterminerDetermined")
@XmlEnum
@XmlRootElement(name = "EntityDeterminerDetermined")
public enum EntityDeterminerDetermined {
	@XmlEnumValue("KIND")
	KIND("KIND"),
	@XmlEnumValue("QUANTIFIED_KIND")
	QUANTIFIEDKIND("QUANTIFIED_KIND");
	
	private final String value;

    EntityDeterminerDetermined(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static EntityDeterminerDetermined fromValue(String v) {
        for (EntityDeterminerDetermined c: EntityDeterminerDetermined.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}