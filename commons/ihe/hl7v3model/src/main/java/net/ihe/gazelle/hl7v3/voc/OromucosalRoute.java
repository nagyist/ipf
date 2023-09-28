/**
 * OromucosalRoute.java
 *
 * File generated from the voc::OromucosalRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration OromucosalRoute.
 *
 */

@XmlType(name = "OromucosalRoute")
@XmlEnum
@XmlRootElement(name = "OromucosalRoute")
public enum OromucosalRoute {
	@XmlEnumValue("GARGLE")
	GARGLE("GARGLE"),
	@XmlEnumValue("ORMUC")
	ORMUC("ORMUC"),
	@XmlEnumValue("SUCK")
	SUCK("SUCK"),
	@XmlEnumValue("SWISHSPIT")
	SWISHSPIT("SWISHSPIT"),
	@XmlEnumValue("SWISHSWAL")
	SWISHSWAL("SWISHSWAL");
	
	private final String value;

    OromucosalRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static OromucosalRoute fromValue(String v) {
        for (OromucosalRoute c: OromucosalRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}