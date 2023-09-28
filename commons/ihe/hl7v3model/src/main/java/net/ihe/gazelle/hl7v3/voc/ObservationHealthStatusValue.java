/**
 * ObservationHealthStatusValue.java
 *
 * File generated from the voc::ObservationHealthStatusValue uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ObservationHealthStatusValue.
 *
 */

@XmlType(name = "ObservationHealthStatusValue")
@XmlEnum
@XmlRootElement(name = "ObservationHealthStatusValue")
public enum ObservationHealthStatusValue {
	@XmlEnumValue("DISABLE")
	DISABLE("DISABLE"),
	@XmlEnumValue("DRUG")
	DRUG("DRUG"),
	@XmlEnumValue("HLSTAT")
	HLSTAT("HLSTAT"),
	@XmlEnumValue("IVDRG")
	IVDRG("IVDRG"),
	@XmlEnumValue("PGNT")
	PGNT("PGNT");
	
	private final String value;

    ObservationHealthStatusValue(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ObservationHealthStatusValue fromValue(String v) {
        for (ObservationHealthStatusValue c: ObservationHealthStatusValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}