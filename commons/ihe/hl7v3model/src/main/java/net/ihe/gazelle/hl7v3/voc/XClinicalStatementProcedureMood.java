/**
 * XClinicalStatementProcedureMood.java
 *
 * File generated from the voc::XClinicalStatementProcedureMood uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration XClinicalStatementProcedureMood.
 *
 */

@XmlType(name = "XClinicalStatementProcedureMood")
@XmlEnum
@XmlRootElement(name = "XClinicalStatementProcedureMood")
public enum XClinicalStatementProcedureMood {
	@XmlEnumValue("APT")
	APT("APT"),
	@XmlEnumValue("ARQ")
	ARQ("ARQ"),
	@XmlEnumValue("DEF")
	DEF("DEF"),
	@XmlEnumValue("EVN")
	EVN("EVN"),
	@XmlEnumValue("INT")
	INT("INT"),
	@XmlEnumValue("PRMS")
	PRMS("PRMS"),
	@XmlEnumValue("PRP")
	PRP("PRP"),
	@XmlEnumValue("RQO")
	RQO("RQO");
	
	private final String value;

    XClinicalStatementProcedureMood(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static XClinicalStatementProcedureMood fromValue(String v) {
        for (XClinicalStatementProcedureMood c: XClinicalStatementProcedureMood.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}