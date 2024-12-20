/**
 * EntityClassOrganization.java
 * <p>
 * File generated from the voc::EntityClassOrganization uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration EntityClassOrganization.
 *
 */

@XmlType(name = "EntityClassOrganization")
@XmlEnum
@XmlRootElement(name = "EntityClassOrganization")
public enum EntityClassOrganization {
	@XmlEnumValue("NAT")
	NAT("NAT"),
	@XmlEnumValue("ORG")
	ORG("ORG"),
	@XmlEnumValue("PUB")
	PUB("PUB"),
	@XmlEnumValue("STATE")
	STATE("STATE");
	
	private final String value;

    EntityClassOrganization(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static EntityClassOrganization fromValue(String v) {
        for (EntityClassOrganization c: EntityClassOrganization.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}