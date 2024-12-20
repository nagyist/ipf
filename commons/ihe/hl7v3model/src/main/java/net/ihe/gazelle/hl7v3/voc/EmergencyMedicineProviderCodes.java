/**
 * EmergencyMedicineProviderCodes.java
 * <p>
 * File generated from the voc::EmergencyMedicineProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration EmergencyMedicineProviderCodes.
 *
 */

@XmlType(name = "EmergencyMedicineProviderCodes")
@XmlEnum
@XmlRootElement(name = "EmergencyMedicineProviderCodes")
public enum EmergencyMedicineProviderCodes {
	@XmlEnumValue("207P00000X")
	_207P00000X("207P00000X"),
	@XmlEnumValue("207PE0004X")
	_207PE0004X("207PE0004X"),
	@XmlEnumValue("207PE0005X")
	_207PE0005X("207PE0005X"),
	@XmlEnumValue("207PP0204X")
	_207PP0204X("207PP0204X"),
	@XmlEnumValue("207PS0010X")
	_207PS0010X("207PS0010X"),
	@XmlEnumValue("207PT0002X")
	_207PT0002X("207PT0002X");
	
	private final String value;

    EmergencyMedicineProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static EmergencyMedicineProviderCodes fromValue(String v) {
        for (EmergencyMedicineProviderCodes c: EmergencyMedicineProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}