/**
 * PasteDrugForm.java
 *
 * File generated from the voc::PasteDrugForm uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration PasteDrugForm.
 *
 */

@XmlType(name = "PasteDrugForm")
@XmlEnum
@XmlRootElement(name = "PasteDrugForm")
public enum PasteDrugForm {
	@XmlEnumValue("PASTE")
	PASTE("PASTE"),
	@XmlEnumValue("PUD")
	PUD("PUD"),
	@XmlEnumValue("TPASTE")
	TPASTE("TPASTE");
	
	private final String value;

    PasteDrugForm(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static PasteDrugForm fromValue(String v) {
        for (PasteDrugForm c: PasteDrugForm.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}