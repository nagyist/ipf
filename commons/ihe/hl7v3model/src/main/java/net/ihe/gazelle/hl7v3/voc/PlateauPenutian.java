/**
 * PlateauPenutian.java
 * <p>
 * File generated from the voc::PlateauPenutian uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration PlateauPenutian.
 *
 */

@XmlType(name = "PlateauPenutian")
@XmlEnum
@XmlRootElement(name = "PlateauPenutian")
public enum PlateauPenutian {
	@XmlEnumValue("x-KLA")
	XKLA("x-KLA"),
	@XmlEnumValue("x-NEZ")
	XNEZ("x-NEZ"),
	@XmlEnumValue("x-UMA")
	XUMA("x-UMA"),
	@XmlEnumValue("x-WAA")
	XWAA("x-WAA"),
	@XmlEnumValue("x-WAR")
	XWAR("x-WAR"),
	@XmlEnumValue("x-YAK")
	XYAK("x-YAK");
	
	private final String value;

    PlateauPenutian(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static PlateauPenutian fromValue(String v) {
        for (PlateauPenutian c: PlateauPenutian.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}