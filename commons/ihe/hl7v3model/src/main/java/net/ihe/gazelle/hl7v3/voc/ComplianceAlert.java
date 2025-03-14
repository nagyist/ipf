/**
 * ComplianceAlert.java
 * <p>
 * File generated from the voc::ComplianceAlert uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ComplianceAlert.
 *
 */

@XmlType(name = "ComplianceAlert")
@XmlEnum
@XmlRootElement(name = "ComplianceAlert")
public enum ComplianceAlert {
	@XmlEnumValue("ABUSE")
	ABUSE("ABUSE"),
	@XmlEnumValue("COMPLY")
	COMPLY("COMPLY"),
	@XmlEnumValue("DUPTHPCLS")
	DUPTHPCLS("DUPTHPCLS"),
	@XmlEnumValue("DUPTHPGEN")
	DUPTHPGEN("DUPTHPGEN"),
	@XmlEnumValue("DUPTHPY")
	DUPTHPY("DUPTHPY"),
	@XmlEnumValue("FRAUD")
	FRAUD("FRAUD"),
	@XmlEnumValue("PLYDOC")
	PLYDOC("PLYDOC"),
	@XmlEnumValue("PLYPHRM")
	PLYPHRM("PLYPHRM");
	
	private final String value;

    ComplianceAlert(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ComplianceAlert fromValue(String v) {
        for (ComplianceAlert c: ComplianceAlert.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}