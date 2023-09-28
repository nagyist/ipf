/**
 * CompliancePackageEntityType.java
 *
 * File generated from the voc::CompliancePackageEntityType uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration CompliancePackageEntityType.
 *
 */

@XmlType(name = "CompliancePackageEntityType")
@XmlEnum
@XmlRootElement(name = "CompliancePackageEntityType")
public enum CompliancePackageEntityType {
	@XmlEnumValue("BLSTRPK")
	BLSTRPK("BLSTRPK"),
	@XmlEnumValue("CARD")
	CARD("CARD"),
	@XmlEnumValue("COMPPKG")
	COMPPKG("COMPPKG"),
	@XmlEnumValue("DIALPK")
	DIALPK("DIALPK"),
	@XmlEnumValue("DISK")
	DISK("DISK"),
	@XmlEnumValue("DOSET")
	DOSET("DOSET"),
	@XmlEnumValue("STRIP")
	STRIP("STRIP");
	
	private final String value;

    CompliancePackageEntityType(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static CompliancePackageEntityType fromValue(String v) {
        for (CompliancePackageEntityType c: CompliancePackageEntityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}