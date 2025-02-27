/**
 * OrthopaedicSurgeryProviderCodes.java
 * <p>
 * File generated from the voc::OrthopaedicSurgeryProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration OrthopaedicSurgeryProviderCodes.
 *
 */

@XmlType(name = "OrthopaedicSurgeryProviderCodes")
@XmlEnum
@XmlRootElement(name = "OrthopaedicSurgeryProviderCodes")
public enum OrthopaedicSurgeryProviderCodes {
	@XmlEnumValue("207X00000X")
	_207X00000X("207X00000X"),
	@XmlEnumValue("207XS0106X")
	_207XS0106X("207XS0106X"),
	@XmlEnumValue("207XS0114X")
	_207XS0114X("207XS0114X"),
	@XmlEnumValue("207XS0117X")
	_207XS0117X("207XS0117X"),
	@XmlEnumValue("207XX0004X")
	_207XX0004X("207XX0004X"),
	@XmlEnumValue("207XX0005X")
	_207XX0005X("207XX0005X"),
	@XmlEnumValue("207XX0801X")
	_207XX0801X("207XX0801X");
	
	private final String value;

    OrthopaedicSurgeryProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static OrthopaedicSurgeryProviderCodes fromValue(String v) {
        for (OrthopaedicSurgeryProviderCodes c: OrthopaedicSurgeryProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}