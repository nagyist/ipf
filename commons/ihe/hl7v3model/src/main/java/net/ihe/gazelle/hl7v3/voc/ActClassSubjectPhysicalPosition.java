/**
 * ActClassSubjectPhysicalPosition.java
 *
 * File generated from the voc::ActClassSubjectPhysicalPosition uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ActClassSubjectPhysicalPosition.
 *
 */

@XmlType(name = "ActClassSubjectPhysicalPosition")
@XmlEnum
@XmlRootElement(name = "ActClassSubjectPhysicalPosition")
public enum ActClassSubjectPhysicalPosition {
	@XmlEnumValue("LLD")
	LLD("LLD"),
	@XmlEnumValue("PRN")
	PRN("PRN"),
	@XmlEnumValue("RLD")
	RLD("RLD"),
	@XmlEnumValue("RTRD")
	RTRD("RTRD"),
	@XmlEnumValue("SFWL")
	SFWL("SFWL"),
	@XmlEnumValue("SIT")
	SIT("SIT"),
	@XmlEnumValue("STN")
	STN("STN"),
	@XmlEnumValue("SUP")
	SUP("SUP"),
	@XmlEnumValue("TRD")
	TRD("TRD"),
	@XmlEnumValue("_ImagingSubjectOrientation")
	IMAGINGSUBJECTORIENTATION("_ImagingSubjectOrientation");
	
	private final String value;

    ActClassSubjectPhysicalPosition(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ActClassSubjectPhysicalPosition fromValue(String v) {
        for (ActClassSubjectPhysicalPosition c: ActClassSubjectPhysicalPosition.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}