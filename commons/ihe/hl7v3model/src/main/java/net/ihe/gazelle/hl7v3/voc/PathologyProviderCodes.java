/**
 * PathologyProviderCodes.java
 * <p>
 * File generated from the voc::PathologyProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration PathologyProviderCodes.
 *
 */

@XmlType(name = "PathologyProviderCodes")
@XmlEnum
@XmlRootElement(name = "PathologyProviderCodes")
public enum PathologyProviderCodes {
	@XmlEnumValue("207Z00000X")
	_207Z00000X("207Z00000X"),
	@XmlEnumValue("207ZB0001X")
	_207ZB0001X("207ZB0001X"),
	@XmlEnumValue("207ZC0500X")
	_207ZC0500X("207ZC0500X"),
	@XmlEnumValue("207ZD0900X")
	_207ZD0900X("207ZD0900X"),
	@XmlEnumValue("207ZF0201X")
	_207ZF0201X("207ZF0201X"),
	@XmlEnumValue("207ZH0000X")
	_207ZH0000X("207ZH0000X"),
	@XmlEnumValue("207ZI0100X")
	_207ZI0100X("207ZI0100X"),
	@XmlEnumValue("207ZM0300X")
	_207ZM0300X("207ZM0300X"),
	@XmlEnumValue("207ZN0500X")
	_207ZN0500X("207ZN0500X"),
	@XmlEnumValue("207ZP0007X")
	_207ZP0007X("207ZP0007X"),
	@XmlEnumValue("207ZP0101X")
	_207ZP0101X("207ZP0101X"),
	@XmlEnumValue("207ZP0102X")
	_207ZP0102X("207ZP0102X"),
	@XmlEnumValue("207ZP0104X")
	_207ZP0104X("207ZP0104X"),
	@XmlEnumValue("207ZP0105X")
	_207ZP0105X("207ZP0105X"),
	@XmlEnumValue("207ZP0213X")
	_207ZP0213X("207ZP0213X");
	
	private final String value;

    PathologyProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static PathologyProviderCodes fromValue(String v) {
        for (PathologyProviderCodes c: PathologyProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}