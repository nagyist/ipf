/**
 * XActRelationshipEntryRelationship.java
 * <p>
 * File generated from the voc::XActRelationshipEntryRelationship uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration XActRelationshipEntryRelationship.
 *
 */

@XmlType(name = "XActRelationshipEntryRelationship")
@XmlEnum
@XmlRootElement(name = "XActRelationshipEntryRelationship")
public enum XActRelationshipEntryRelationship {
	@XmlEnumValue("CAUS")
	CAUS("CAUS"),
	@XmlEnumValue("COMP")
	COMP("COMP"),
	@XmlEnumValue("GEVL")
	GEVL("GEVL"),
	@XmlEnumValue("MFST")
	MFST("MFST"),
	@XmlEnumValue("REFR")
	REFR("REFR"),
	@XmlEnumValue("RSON")
	RSON("RSON"),
	@XmlEnumValue("SAS")
	SAS("SAS"),
	@XmlEnumValue("SPRT")
	SPRT("SPRT"),
	@XmlEnumValue("SUBJ")
	SUBJ("SUBJ"),
	@XmlEnumValue("XCRPT")
	XCRPT("XCRPT");
	
	private final String value;

    XActRelationshipEntryRelationship(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static XActRelationshipEntryRelationship fromValue(String v) {
        for (XActRelationshipEntryRelationship c: XActRelationshipEntryRelationship.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}