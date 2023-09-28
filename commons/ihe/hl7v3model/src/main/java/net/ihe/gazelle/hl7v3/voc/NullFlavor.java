/**
 * NullFlavor.java
 *
 * File generated from the voc::NullFlavor uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration NullFlavor.
 *
 */

@XmlType(name = "NullFlavor")
@XmlEnum
@XmlRootElement(name = "NullFlavor")
public enum NullFlavor {
	@XmlEnumValue("ASKU")
	ASKU("ASKU"),
	@XmlEnumValue("MSK")
	MSK("MSK"),
	@XmlEnumValue("NA")
	NA("NA"),
	@XmlEnumValue("NASK")
	NASK("NASK"),
	@XmlEnumValue("NAV")
	NAV("NAV"),
	@XmlEnumValue("NI")
	NI("NI"),
	@XmlEnumValue("NINF")
	NINF("NINF"),
	@XmlEnumValue("OTH")
	OTH("OTH"),
	@XmlEnumValue("PINF")
	PINF("PINF"),
	@XmlEnumValue("QS")
	QS("QS"),
	@XmlEnumValue("TRC")
	TRC("TRC"),
	@XmlEnumValue("UNC")
	UNC("UNC"),
	@XmlEnumValue("UNK")
	UNK("UNK");
	
	private final String value;

    NullFlavor(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static NullFlavor fromValue(String v) {
        for (NullFlavor c: NullFlavor.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}