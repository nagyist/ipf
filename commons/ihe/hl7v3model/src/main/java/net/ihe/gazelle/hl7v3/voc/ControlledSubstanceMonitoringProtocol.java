/**
 * ControlledSubstanceMonitoringProtocol.java
 * <p>
 * File generated from the voc::ControlledSubstanceMonitoringProtocol uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ControlledSubstanceMonitoringProtocol.
 *
 */

@XmlType(name = "ControlledSubstanceMonitoringProtocol")
@XmlEnum
@XmlRootElement(name = "ControlledSubstanceMonitoringProtocol")
public enum ControlledSubstanceMonitoringProtocol {
	@XmlEnumValue("CTLSUB")
	CTLSUB("CTLSUB");
	
	private final String value;

    ControlledSubstanceMonitoringProtocol(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ControlledSubstanceMonitoringProtocol fromValue(String v) {
        for (ControlledSubstanceMonitoringProtocol c: ControlledSubstanceMonitoringProtocol.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}