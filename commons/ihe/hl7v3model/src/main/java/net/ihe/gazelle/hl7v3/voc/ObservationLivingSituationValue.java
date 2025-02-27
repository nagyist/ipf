/**
 * ObservationLivingSituationValue.java
 * <p>
 * File generated from the voc::ObservationLivingSituationValue uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ObservationLivingSituationValue.
 *
 */

@XmlType(name = "ObservationLivingSituationValue")
@XmlEnum
@XmlRootElement(name = "ObservationLivingSituationValue")
public enum ObservationLivingSituationValue {
	@XmlEnumValue("ALONE")
	ALONE("ALONE"),
	@XmlEnumValue("DEPCHD")
	DEPCHD("DEPCHD"),
	@XmlEnumValue("DEPSPS")
	DEPSPS("DEPSPS"),
	@XmlEnumValue("DEPYGCHD")
	DEPYGCHD("DEPYGCHD"),
	@XmlEnumValue("FAM")
	FAM("FAM"),
	@XmlEnumValue("LIVSIT")
	LIVSIT("LIVSIT"),
	@XmlEnumValue("RELAT")
	RELAT("RELAT"),
	@XmlEnumValue("SPS")
	SPS("SPS"),
	@XmlEnumValue("UNREL")
	UNREL("UNREL");
	
	private final String value;

    ObservationLivingSituationValue(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ObservationLivingSituationValue fromValue(String v) {
        for (ObservationLivingSituationValue c: ObservationLivingSituationValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}