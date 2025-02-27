/**
 * WeightAlert.java
 * <p>
 * File generated from the voc::WeightAlert uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration WeightAlert.
 *
 */

@XmlType(name = "WeightAlert")
@XmlEnum
@XmlRootElement(name = "WeightAlert")
public enum WeightAlert {
	@XmlEnumValue("DOSEHINDW")
	DOSEHINDW("DOSEHINDW"),
	@XmlEnumValue("DOSELINDW")
	DOSELINDW("DOSELINDW");
	
	private final String value;

    WeightAlert(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static WeightAlert fromValue(String v) {
        for (WeightAlert c: WeightAlert.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}