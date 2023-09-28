/**
 * EntityClassLivingSubject.java
 *
 * File generated from the voc::EntityClassLivingSubject uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration EntityClassLivingSubject.
 *
 */

@XmlType(name = "EntityClassLivingSubject")
@XmlEnum
@XmlRootElement(name = "EntityClassLivingSubject")
public enum EntityClassLivingSubject {
	@XmlEnumValue("ANM")
	ANM("ANM"),
	@XmlEnumValue("LIV")
	LIV("LIV"),
	@XmlEnumValue("MIC")
	MIC("MIC"),
	@XmlEnumValue("NLIV")
	NLIV("NLIV"),
	@XmlEnumValue("PLNT")
	PLNT("PLNT"),
	@XmlEnumValue("PSN")
	PSN("PSN");
	
	private final String value;

    EntityClassLivingSubject(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static EntityClassLivingSubject fromValue(String v) {
        for (EntityClassLivingSubject c: EntityClassLivingSubject.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}