/**
 * XActClassCareProvisionEncounter.java
 *
 * File generated from the voc::XActClassCareProvisionEncounter uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration XActClassCareProvisionEncounter.
 *
 */

@XmlType(name = "XActClassCareProvisionEncounter")
@XmlEnum
@XmlRootElement(name = "XActClassCareProvisionEncounter")
public enum XActClassCareProvisionEncounter {
	@XmlEnumValue("ENC")
	ENC("ENC"),
	@XmlEnumValue("PCPR")
	PCPR("PCPR");
	
	private final String value;

    XActClassCareProvisionEncounter(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static XActClassCareProvisionEncounter fromValue(String v) {
        for (XActClassCareProvisionEncounter c: XActClassCareProvisionEncounter.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}