/**
 * MDFAttributeType.java
 *
 * File generated from the voc::MDFAttributeType uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration MDFAttributeType.
 *
 */

@XmlType(name = "MDFAttributeType")
@XmlEnum
@XmlRootElement(name = "MDFAttributeType")
public enum MDFAttributeType {
	@XmlEnumValue("ADDR")
	ADDR("ADDR"),
	@XmlEnumValue("CD")
	CD("CD"),
	@XmlEnumValue("COM")
	COM("COM"),
	@XmlEnumValue("DESC")
	DESC("DESC"),
	@XmlEnumValue("DTTM")
	DTTM("DTTM"),
	@XmlEnumValue("EXPR")
	EXPR("EXPR"),
	@XmlEnumValue("FRC")
	FRC("FRC"),
	@XmlEnumValue("ID")
	ID("ID"),
	@XmlEnumValue("IND")
	IND("IND"),
	@XmlEnumValue("NBR")
	NBR("NBR"),
	@XmlEnumValue("NM")
	NM("NM"),
	@XmlEnumValue("PHON")
	PHON("PHON"),
	@XmlEnumValue("QTY")
	QTY("QTY"),
	@XmlEnumValue("TIME")
	TIME("TIME"),
	@XmlEnumValue("TMR")
	TMR("TMR"),
	@XmlEnumValue("TXT")
	TXT("TXT"),
	@XmlEnumValue("VALUE")
	VALUE("VALUE");
	
	private final String value;

    MDFAttributeType(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static MDFAttributeType fromValue(String v) {
        for (MDFAttributeType c: MDFAttributeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}