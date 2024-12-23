/**
 * PrimaryDentition.java
 * <p>
 * File generated from the voc::PrimaryDentition uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration PrimaryDentition.
 *
 */

@XmlType(name = "PrimaryDentition")
@XmlEnum
@XmlRootElement(name = "PrimaryDentition")
public enum PrimaryDentition {
	@XmlEnumValue("TIDA")
	TIDA("TIDA"),
	@XmlEnumValue("TIDB")
	TIDB("TIDB"),
	@XmlEnumValue("TIDC")
	TIDC("TIDC"),
	@XmlEnumValue("TIDD")
	TIDD("TIDD"),
	@XmlEnumValue("TIDE")
	TIDE("TIDE"),
	@XmlEnumValue("TIDF")
	TIDF("TIDF"),
	@XmlEnumValue("TIDG")
	TIDG("TIDG"),
	@XmlEnumValue("TIDH")
	TIDH("TIDH"),
	@XmlEnumValue("TIDI")
	TIDI("TIDI"),
	@XmlEnumValue("TIDJ")
	TIDJ("TIDJ"),
	@XmlEnumValue("TIDK")
	TIDK("TIDK"),
	@XmlEnumValue("TIDL")
	TIDL("TIDL"),
	@XmlEnumValue("TIDM")
	TIDM("TIDM"),
	@XmlEnumValue("TIDN")
	TIDN("TIDN"),
	@XmlEnumValue("TIDO")
	TIDO("TIDO"),
	@XmlEnumValue("TIDP")
	TIDP("TIDP"),
	@XmlEnumValue("TIDQ")
	TIDQ("TIDQ"),
	@XmlEnumValue("TIDR")
	TIDR("TIDR"),
	@XmlEnumValue("TIDS")
	TIDS("TIDS"),
	@XmlEnumValue("TIDT")
	TIDT("TIDT");
	
	private final String value;

    PrimaryDentition(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static PrimaryDentition fromValue(String v) {
        for (PrimaryDentition c: PrimaryDentition.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}