/**
 * CalendarCycleTwoLetter.java
 * <p>
 * File generated from the voc::CalendarCycleTwoLetter uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration CalendarCycleTwoLetter.
 *
 */

@XmlType(name = "CalendarCycleTwoLetter")
@XmlEnum
@XmlRootElement(name = "CalendarCycleTwoLetter")
public enum CalendarCycleTwoLetter {
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
	@XmlEnumValue("DM")
	DM("DM"),
	@XmlEnumValue("DW")
	DW("DW"),
	@XmlEnumValue("DY")
	DY("DY"),
	@XmlEnumValue("HD")
	HD("HD"),
	@XmlEnumValue("MY")
	MY("MY"),
	@XmlEnumValue("NH")
	NH("NH"),
	@XmlEnumValue("SN")
	SN("SN"),
	@XmlEnumValue("WY")
	WY("WY");
	
	private final String value;

    CalendarCycleTwoLetter(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static CalendarCycleTwoLetter fromValue(String v) {
        for (CalendarCycleTwoLetter c: CalendarCycleTwoLetter.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}