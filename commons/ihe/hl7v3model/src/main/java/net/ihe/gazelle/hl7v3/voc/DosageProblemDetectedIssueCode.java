/**
 * DosageProblemDetectedIssueCode.java
 * <p>
 * File generated from the voc::DosageProblemDetectedIssueCode uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration DosageProblemDetectedIssueCode.
 *
 */

@XmlType(name = "DosageProblemDetectedIssueCode")
@XmlEnum
@XmlRootElement(name = "DosageProblemDetectedIssueCode")
public enum DosageProblemDetectedIssueCode {
	@XmlEnumValue("DOSE")
	DOSE("DOSE"),
	@XmlEnumValue("DOSECOND")
	DOSECOND("DOSECOND"),
	@XmlEnumValue("DOSEDUR")
	DOSEDUR("DOSEDUR"),
	@XmlEnumValue("DOSEDURH")
	DOSEDURH("DOSEDURH"),
	@XmlEnumValue("DOSEDURHIND")
	DOSEDURHIND("DOSEDURHIND"),
	@XmlEnumValue("DOSEDURL")
	DOSEDURL("DOSEDURL"),
	@XmlEnumValue("DOSEDURLIND")
	DOSEDURLIND("DOSEDURLIND"),
	@XmlEnumValue("DOSEH")
	DOSEH("DOSEH"),
	@XmlEnumValue("DOSEHIND")
	DOSEHIND("DOSEHIND"),
	@XmlEnumValue("DOSEHINDA")
	DOSEHINDA("DOSEHINDA"),
	@XmlEnumValue("DOSEHINDSA")
	DOSEHINDSA("DOSEHINDSA"),
	@XmlEnumValue("DOSEHINDW")
	DOSEHINDW("DOSEHINDW"),
	@XmlEnumValue("DOSEIVL")
	DOSEIVL("DOSEIVL"),
	@XmlEnumValue("DOSEIVLIND")
	DOSEIVLIND("DOSEIVLIND"),
	@XmlEnumValue("DOSEL")
	DOSEL("DOSEL"),
	@XmlEnumValue("DOSELIND")
	DOSELIND("DOSELIND"),
	@XmlEnumValue("DOSELINDA")
	DOSELINDA("DOSELINDA"),
	@XmlEnumValue("DOSELINDSA")
	DOSELINDSA("DOSELINDSA"),
	@XmlEnumValue("DOSELINDW")
	DOSELINDW("DOSELINDW"),
	@XmlEnumValue("MDOSE")
	MDOSE("MDOSE");
	
	private final String value;

    DosageProblemDetectedIssueCode(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static DosageProblemDetectedIssueCode fromValue(String v) {
        for (DosageProblemDetectedIssueCode c: DosageProblemDetectedIssueCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}