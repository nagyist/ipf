/**
 * AgeDetectedIssueCode.java
 *
 * File generated from the voc::AgeDetectedIssueCode uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration AgeDetectedIssueCode.
 *
 */

@XmlType(name = "AgeDetectedIssueCode")
@XmlEnum
@XmlRootElement(name = "AgeDetectedIssueCode")
public enum AgeDetectedIssueCode {
	@XmlEnumValue("AGE")
	AGE("AGE"),
	@XmlEnumValue("DOSEHINDA")
	DOSEHINDA("DOSEHINDA"),
	@XmlEnumValue("DOSELINDA")
	DOSELINDA("DOSELINDA");
	
	private final String value;

    AgeDetectedIssueCode(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static AgeDetectedIssueCode fromValue(String v) {
        for (AgeDetectedIssueCode c: AgeDetectedIssueCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}