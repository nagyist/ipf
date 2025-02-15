/**
 * RacePacificIslandMelanesian.java
 * <p>
 * File generated from the voc::RacePacificIslandMelanesian uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RacePacificIslandMelanesian.
 *
 */

@XmlType(name = "RacePacificIslandMelanesian")
@XmlEnum
@XmlRootElement(name = "RacePacificIslandMelanesian")
public enum RacePacificIslandMelanesian {
	@XmlEnumValue("2100-6")
	_21006("2100-6"),
	@XmlEnumValue("2101-4")
	_21014("2101-4"),
	@XmlEnumValue("2102-2")
	_21022("2102-2"),
	@XmlEnumValue("2103-0")
	_21030("2103-0"),
	@XmlEnumValue("2104-8")
	_21048("2104-8");
	
	private final String value;

    RacePacificIslandMelanesian(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RacePacificIslandMelanesian fromValue(String v) {
        for (RacePacificIslandMelanesian c: RacePacificIslandMelanesian.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}