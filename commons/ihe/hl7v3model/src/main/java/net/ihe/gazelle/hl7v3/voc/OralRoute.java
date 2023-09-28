/**
 * OralRoute.java
 *
 * File generated from the voc::OralRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration OralRoute.
 *
 */

@XmlType(name = "OralRoute")
@XmlEnum
@XmlRootElement(name = "OralRoute")
public enum OralRoute {
	@XmlEnumValue("CHEW")
	CHEW("CHEW"),
	@XmlEnumValue("DISSOLVE")
	DISSOLVE("DISSOLVE"),
	@XmlEnumValue("ORALTA")
	ORALTA("ORALTA"),
	@XmlEnumValue("ORIFINHL")
	ORIFINHL("ORIFINHL"),
	@XmlEnumValue("ORINHL")
	ORINHL("ORINHL"),
	@XmlEnumValue("ORRINSE")
	ORRINSE("ORRINSE"),
	@XmlEnumValue("PO")
	PO("PO"),
	@XmlEnumValue("REBREATH")
	REBREATH("REBREATH");
	
	private final String value;

    OralRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static OralRoute fromValue(String v) {
        for (OralRoute c: OralRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}