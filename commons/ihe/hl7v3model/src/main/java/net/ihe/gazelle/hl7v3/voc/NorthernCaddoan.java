/**
 * NorthernCaddoan.java
 * <p>
 * File generated from the voc::NorthernCaddoan uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration NorthernCaddoan.
 *
 */

@XmlType(name = "NorthernCaddoan")
@XmlEnum
@XmlRootElement(name = "NorthernCaddoan")
public enum NorthernCaddoan {
	@XmlEnumValue("x-ARI")
	XARI("x-ARI"),
	@XmlEnumValue("x-PAW")
	XPAW("x-PAW"),
	@XmlEnumValue("x-WIC")
	XWIC("x-WIC");
	
	private final String value;

    NorthernCaddoan(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static NorthernCaddoan fromValue(String v) {
        for (NorthernCaddoan c: NorthernCaddoan.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}