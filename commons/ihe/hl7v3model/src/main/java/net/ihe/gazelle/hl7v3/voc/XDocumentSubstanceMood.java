/**
 * XDocumentSubstanceMood.java
 *
 * File generated from the voc::XDocumentSubstanceMood uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration XDocumentSubstanceMood.
 *
 */

@XmlType(name = "XDocumentSubstanceMood")
@XmlEnum
@XmlRootElement(name = "XDocumentSubstanceMood")
public enum XDocumentSubstanceMood {
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

    XDocumentSubstanceMood(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static XDocumentSubstanceMood fromValue(String v) {
        for (XDocumentSubstanceMood c: XDocumentSubstanceMood.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}