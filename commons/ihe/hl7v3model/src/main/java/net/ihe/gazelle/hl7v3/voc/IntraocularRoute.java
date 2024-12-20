/**
 * IntraocularRoute.java
 * <p>
 * File generated from the voc::IntraocularRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration IntraocularRoute.
 *
 */

@XmlType(name = "IntraocularRoute")
@XmlEnum
@XmlRootElement(name = "IntraocularRoute")
public enum IntraocularRoute {
	@XmlEnumValue("IOINJ")
	IOINJ("IOINJ"),
	@XmlEnumValue("IOINSTL")
	IOINSTL("IOINSTL"),
	@XmlEnumValue("IOIRR")
	IOIRR("IOIRR"),
	@XmlEnumValue("IOSURGINS")
	IOSURGINS("IOSURGINS"),
	@XmlEnumValue("IOTOP")
	IOTOP("IOTOP");
	
	private final String value;

    IntraocularRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static IntraocularRoute fromValue(String v) {
        for (IntraocularRoute c: IntraocularRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}