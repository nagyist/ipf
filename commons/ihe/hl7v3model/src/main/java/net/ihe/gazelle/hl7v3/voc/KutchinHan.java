/**
 * KutchinHan.java
 *
 * File generated from the voc::KutchinHan uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration KutchinHan.
 *
 */

@XmlType(name = "KutchinHan")
@XmlEnum
@XmlRootElement(name = "KutchinHan")
public enum KutchinHan {
	@XmlEnumValue("x-HAA")
	XHAA("x-HAA"),
	@XmlEnumValue("x-KUC")
	XKUC("x-KUC");
	
	private final String value;

    KutchinHan(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static KutchinHan fromValue(String v) {
        for (KutchinHan c: KutchinHan.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}