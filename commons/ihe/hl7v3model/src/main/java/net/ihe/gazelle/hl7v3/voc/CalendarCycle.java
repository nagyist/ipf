/**
 * CalendarCycle.java
 *
 * File generated from the voc::CalendarCycle uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration CalendarCycle.
 *
 */

@XmlType(name = "CalendarCycle")
@XmlEnum
@XmlRootElement(name = "CalendarCycle")
public enum CalendarCycle {
	@XmlEnumValue("CD")
	CD("CD"),
	@XmlEnumValue("CH")
	CH("CH"),
	@XmlEnumValue("CM")
	CM("CM"),
	@XmlEnumValue("CN")
	CN("CN"),
	@XmlEnumValue("CS")
	CS("CS"),
	@XmlEnumValue("CW")
	CW("CW"),
	@XmlEnumValue("CY")
	CY("CY"),
	@XmlEnumValue("D")
	D("D"),
	@XmlEnumValue("DM")
	DM("DM"),
	@XmlEnumValue("DW")
	DW("DW"),
	@XmlEnumValue("DY")
	DY("DY"),
	@XmlEnumValue("H")
	H("H"),
	@XmlEnumValue("HD")
	HD("HD"),
	@XmlEnumValue("J")
	J("J"),
	@XmlEnumValue("M")
	M("M"),
	@XmlEnumValue("MY")
	MY("MY"),
	@XmlEnumValue("N")
	N("N"),
	@XmlEnumValue("NH")
	NH("NH"),
	@XmlEnumValue("S")
	S("S"),
	@XmlEnumValue("SN")
	SN("SN"),
	@XmlEnumValue("W")
	W("W"),
	@XmlEnumValue("WY")
	WY("WY"),
	@XmlEnumValue("Y")
	Y("Y");
	
	private final String value;

    CalendarCycle(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static CalendarCycle fromValue(String v) {
        for (CalendarCycle c: CalendarCycle.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}