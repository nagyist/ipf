/**
 * IntraepidermalRoute.java
 *
 * File generated from the voc::IntraepidermalRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration IntraepidermalRoute.
 *
 */

@XmlType(name = "IntraepidermalRoute")
@XmlEnum
@XmlRootElement(name = "IntraepidermalRoute")
public enum IntraepidermalRoute {
	@XmlEnumValue("IEPIDINJ")
	IEPIDINJ("IEPIDINJ");
	
	private final String value;

    IntraepidermalRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static IntraepidermalRoute fromValue(String v) {
        for (IntraepidermalRoute c: IntraepidermalRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}