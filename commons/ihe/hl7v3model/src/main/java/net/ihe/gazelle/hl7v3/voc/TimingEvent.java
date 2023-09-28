/**
 * TimingEvent.java
 *
 * File generated from the voc::TimingEvent uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration TimingEvent.
 *
 */

@XmlType(name = "TimingEvent")
@XmlEnum
@XmlRootElement(name = "TimingEvent")
public enum TimingEvent {
	@XmlEnumValue("AC")
	AC("AC"),
	@XmlEnumValue("ACD")
	ACD("ACD"),
	@XmlEnumValue("ACM")
	ACM("ACM"),
	@XmlEnumValue("ACV")
	ACV("ACV"),
	@XmlEnumValue("HS")
	HS("HS"),
	@XmlEnumValue("IC")
	IC("IC"),
	@XmlEnumValue("ICD")
	ICD("ICD"),
	@XmlEnumValue("ICM")
	ICM("ICM"),
	@XmlEnumValue("ICV")
	ICV("ICV"),
	@XmlEnumValue("PC")
	PC("PC"),
	@XmlEnumValue("PCD")
	PCD("PCD"),
	@XmlEnumValue("PCM")
	PCM("PCM"),
	@XmlEnumValue("PCV")
	PCV("PCV");
	
	private final String value;

    TimingEvent(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static TimingEvent fromValue(String v) {
        for (TimingEvent c: TimingEvent.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}