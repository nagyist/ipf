/**
 * ObservationDetectedIssueCode.java
 *
 * File generated from the voc::ObservationDetectedIssueCode uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ObservationDetectedIssueCode.
 *
 */

@XmlType(name = "ObservationDetectedIssueCode")
@XmlEnum
@XmlRootElement(name = "ObservationDetectedIssueCode")
public enum ObservationDetectedIssueCode {
	@XmlEnumValue("AGE")
	AGE("AGE"),
	@XmlEnumValue("ALGY")
	ALGY("ALGY"),
	@XmlEnumValue("COND")
	COND("COND"),
	@XmlEnumValue("CREACT")
	CREACT("CREACT"),
	@XmlEnumValue("DOSEHINDA")
	DOSEHINDA("DOSEHINDA"),
	@XmlEnumValue("DOSEHINDSA")
	DOSEHINDSA("DOSEHINDSA"),
	@XmlEnumValue("DOSEHINDW")
	DOSEHINDW("DOSEHINDW"),
	@XmlEnumValue("DOSELINDA")
	DOSELINDA("DOSELINDA"),
	@XmlEnumValue("DOSELINDSA")
	DOSELINDSA("DOSELINDSA"),
	@XmlEnumValue("DOSELINDW")
	DOSELINDW("DOSELINDW"),
	@XmlEnumValue("GEN")
	GEN("GEN"),
	@XmlEnumValue("GEND")
	GEND("GEND"),
	@XmlEnumValue("INT")
	INT("INT"),
	@XmlEnumValue("LAB")
	LAB("LAB"),
	@XmlEnumValue("LACT")
	LACT("LACT"),
	@XmlEnumValue("OBSA")
	OBSA("OBSA"),
	@XmlEnumValue("PREG")
	PREG("PREG"),
	@XmlEnumValue("RALG")
	RALG("RALG"),
	@XmlEnumValue("RAR")
	RAR("RAR"),
	@XmlEnumValue("REACT")
	REACT("REACT"),
	@XmlEnumValue("RINT")
	RINT("RINT"),
	@XmlEnumValue("RREACT")
	RREACT("RREACT");
	
	private final String value;

    ObservationDetectedIssueCode(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ObservationDetectedIssueCode fromValue(String v) {
        for (ObservationDetectedIssueCode c: ObservationDetectedIssueCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}