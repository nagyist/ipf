/**
 * IntravenousRoute.java
 *
 * File generated from the voc::IntravenousRoute uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration IntravenousRoute.
 *
 */

@XmlType(name = "IntravenousRoute")
@XmlEnum
@XmlRootElement(name = "IntravenousRoute")
public enum IntravenousRoute {
	@XmlEnumValue("IVFLUSH")
	IVFLUSH("IVFLUSH"),
	@XmlEnumValue("IVINJ")
	IVINJ("IVINJ"),
	@XmlEnumValue("IVINJBOL")
	IVINJBOL("IVINJBOL"),
	@XmlEnumValue("IVPUSH")
	IVPUSH("IVPUSH"),
	@XmlEnumValue("IVRPUSH")
	IVRPUSH("IVRPUSH"),
	@XmlEnumValue("IVSPUSH")
	IVSPUSH("IVSPUSH");
	
	private final String value;

    IntravenousRoute(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static IntravenousRoute fromValue(String v) {
        for (IntravenousRoute c: IntravenousRoute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}