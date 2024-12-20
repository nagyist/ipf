/**
 * GTSAbbreviation.java
 * <p>
 * File generated from the voc::GTSAbbreviation uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration GTSAbbreviation.
 *
 */

@XmlType(name = "GTSAbbreviation")
@XmlEnum
@XmlRootElement(name = "GTSAbbreviation")
public enum GTSAbbreviation {
	@XmlEnumValue("AM")
	AM("AM"),
	@XmlEnumValue("BID")
	BID("BID"),
	@XmlEnumValue("JB")
	JB("JB"),
	@XmlEnumValue("JE")
	JE("JE"),
	@XmlEnumValue("JH")
	JH("JH"),
	@XmlEnumValue("JHCHREAS")
	JHCHREAS("JHCHREAS"),
	@XmlEnumValue("JHCHRGFR")
	JHCHRGFR("JHCHRGFR"),
	@XmlEnumValue("JHCHRNEW")
	JHCHRNEW("JHCHRNEW"),
	@XmlEnumValue("JHCHRPEN")
	JHCHRPEN("JHCHRPEN"),
	@XmlEnumValue("JHCHRXME")
	JHCHRXME("JHCHRXME"),
	@XmlEnumValue("JHCHRXMS")
	JHCHRXMS("JHCHRXMS"),
	@XmlEnumValue("JHNUS")
	JHNUS("JHNUS"),
	@XmlEnumValue("JHNUSCLM")
	JHNUSCLM("JHNUSCLM"),
	@XmlEnumValue("JHNUSIND")
	JHNUSIND("JHNUSIND"),
	@XmlEnumValue("JHNUSIND1")
	JHNUSIND1("JHNUSIND1"),
	@XmlEnumValue("JHNUSIND5")
	JHNUSIND5("JHNUSIND5"),
	@XmlEnumValue("JHNUSLBR")
	JHNUSLBR("JHNUSLBR"),
	@XmlEnumValue("JHNUSMEM")
	JHNUSMEM("JHNUSMEM"),
	@XmlEnumValue("JHNUSMEM5")
	JHNUSMEM5("JHNUSMEM5"),
	@XmlEnumValue("JHNUSMEM6")
	JHNUSMEM6("JHNUSMEM6"),
	@XmlEnumValue("JHNUSMLK")
	JHNUSMLK("JHNUSMLK"),
	@XmlEnumValue("JHNUSPRE")
	JHNUSPRE("JHNUSPRE"),
	@XmlEnumValue("JHNUSTKS")
	JHNUSTKS("JHNUSTKS"),
	@XmlEnumValue("JHNUSTKS5")
	JHNUSTKS5("JHNUSTKS5"),
	@XmlEnumValue("JHNUSVET")
	JHNUSVET("JHNUSVET"),
	@XmlEnumValue("PM")
	PM("PM"),
	@XmlEnumValue("QID")
	QID("QID"),
	@XmlEnumValue("TID")
	TID("TID");
	
	private final String value;

    GTSAbbreviation(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static GTSAbbreviation fromValue(String v) {
        for (GTSAbbreviation c: GTSAbbreviation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}