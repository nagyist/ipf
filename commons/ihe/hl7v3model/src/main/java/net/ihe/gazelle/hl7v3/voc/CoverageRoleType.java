/**
 * CoverageRoleType.java
 * <p>
 * File generated from the voc::CoverageRoleType uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration CoverageRoleType.
 *
 */

@XmlType(name = "CoverageRoleType")
@XmlEnum
@XmlRootElement(name = "CoverageRoleType")
public enum CoverageRoleType {
	@XmlEnumValue("FAMDEP")
	FAMDEP("FAMDEP"),
	@XmlEnumValue("FSTUD")
	FSTUD("FSTUD"),
	@XmlEnumValue("HANDIC")
	HANDIC("HANDIC"),
	@XmlEnumValue("INJ")
	INJ("INJ"),
	@XmlEnumValue("PSTUD")
	PSTUD("PSTUD"),
	@XmlEnumValue("SELF")
	SELF("SELF"),
	@XmlEnumValue("SPON")
	SPON("SPON"),
	@XmlEnumValue("STUD")
	STUD("STUD");
	
	private final String value;

    CoverageRoleType(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static CoverageRoleType fromValue(String v) {
        for (CoverageRoleType c: CoverageRoleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}