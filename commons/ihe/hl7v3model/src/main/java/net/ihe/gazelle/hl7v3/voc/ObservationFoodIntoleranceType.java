/**
 * ObservationFoodIntoleranceType.java
 * <p>
 * File generated from the voc::ObservationFoodIntoleranceType uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ObservationFoodIntoleranceType.
 *
 */

@XmlType(name = "ObservationFoodIntoleranceType")
@XmlEnum
@XmlRootElement(name = "ObservationFoodIntoleranceType")
public enum ObservationFoodIntoleranceType {
	@XmlEnumValue("FALG")
	FALG("FALG"),
	@XmlEnumValue("FINT")
	FINT("FINT"),
	@XmlEnumValue("FNAINT")
	FNAINT("FNAINT");
	
	private final String value;

    ObservationFoodIntoleranceType(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ObservationFoodIntoleranceType fromValue(String v) {
        for (ObservationFoodIntoleranceType c: ObservationFoodIntoleranceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}