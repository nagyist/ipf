/**
 * EntityHandling.java
 *
 * File generated from the voc::EntityHandling uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration EntityHandling.
 *
 */

@XmlType(name = "EntityHandling")
@XmlEnum
@XmlRootElement(name = "EntityHandling")
public enum EntityHandling {
	@XmlEnumValue("AMB")
	AMB("AMB"),
	@XmlEnumValue("C37")
	C37("C37"),
	@XmlEnumValue("CAMB")
	CAMB("CAMB"),
	@XmlEnumValue("CATM")
	CATM("CATM"),
	@XmlEnumValue("CFRZ")
	CFRZ("CFRZ"),
	@XmlEnumValue("CREF")
	CREF("CREF"),
	@XmlEnumValue("DFRZ")
	DFRZ("DFRZ"),
	@XmlEnumValue("DRY")
	DRY("DRY"),
	@XmlEnumValue("FRZ")
	FRZ("FRZ"),
	@XmlEnumValue("MTLF")
	MTLF("MTLF"),
	@XmlEnumValue("NTR")
	NTR("NTR"),
	@XmlEnumValue("PRTL")
	PRTL("PRTL"),
	@XmlEnumValue("PSA")
	PSA("PSA"),
	@XmlEnumValue("PSO")
	PSO("PSO"),
	@XmlEnumValue("REF")
	REF("REF"),
	@XmlEnumValue("SBU")
	SBU("SBU"),
	@XmlEnumValue("UFRZ")
	UFRZ("UFRZ"),
	@XmlEnumValue("UPR")
	UPR("UPR");
	
	private final String value;

    EntityHandling(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static EntityHandling fromValue(String v) {
        for (EntityHandling c: EntityHandling.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}