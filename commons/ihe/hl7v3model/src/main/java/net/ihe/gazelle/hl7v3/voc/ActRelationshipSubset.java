/**
 * ActRelationshipSubset.java
 *
 * File generated from the voc::ActRelationshipSubset uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ActRelationshipSubset.
 *
 */

@XmlType(name = "ActRelationshipSubset")
@XmlEnum
@XmlRootElement(name = "ActRelationshipSubset")
public enum ActRelationshipSubset {
	@XmlEnumValue("FIRST")
	FIRST("FIRST"),
	@XmlEnumValue("FUTSUM")
	FUTSUM("FUTSUM"),
	@XmlEnumValue("FUTURE")
	FUTURE("FUTURE"),
	@XmlEnumValue("LAST")
	LAST("LAST"),
	@XmlEnumValue("MAX")
	MAX("MAX"),
	@XmlEnumValue("MIN")
	MIN("MIN"),
	@XmlEnumValue("NEXT")
	NEXT("NEXT"),
	@XmlEnumValue("PAST")
	PAST("PAST"),
	@XmlEnumValue("PREVSUM")
	PREVSUM("PREVSUM"),
	@XmlEnumValue("RECENT")
	RECENT("RECENT"),
	@XmlEnumValue("SUM")
	SUM("SUM");
	
	private final String value;

    ActRelationshipSubset(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ActRelationshipSubset fromValue(String v) {
        for (ActRelationshipSubset c: ActRelationshipSubset.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}