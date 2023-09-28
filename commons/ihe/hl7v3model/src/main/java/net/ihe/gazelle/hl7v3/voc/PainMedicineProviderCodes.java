/**
 * PainMedicineProviderCodes.java
 *
 * File generated from the voc::PainMedicineProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration PainMedicineProviderCodes.
 *
 */

@XmlType(name = "PainMedicineProviderCodes")
@XmlEnum
@XmlRootElement(name = "PainMedicineProviderCodes")
public enum PainMedicineProviderCodes {
	@XmlEnumValue("208V00000X")
	_208V00000X("208V00000X"),
	@XmlEnumValue("208VP0000X")
	_208VP0000X("208VP0000X"),
	@XmlEnumValue("208VP0014X")
	_208VP0014X("208VP0014X");
	
	private final String value;

    PainMedicineProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static PainMedicineProviderCodes fromValue(String v) {
        for (PainMedicineProviderCodes c: PainMedicineProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}