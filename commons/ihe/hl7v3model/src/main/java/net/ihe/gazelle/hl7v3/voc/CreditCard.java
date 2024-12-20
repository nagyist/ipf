/**
 * CreditCard.java
 * <p>
 * File generated from the voc::CreditCard uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration CreditCard.
 *
 */

@XmlType(name = "CreditCard")
@XmlEnum
@XmlRootElement(name = "CreditCard")
public enum CreditCard {
	@XmlEnumValue("AE")
	AE("AE"),
	@XmlEnumValue("DN")
	DN("DN"),
	@XmlEnumValue("DV")
	DV("DV"),
	@XmlEnumValue("MC")
	MC("MC"),
	@XmlEnumValue("V")
	V("V");
	
	private final String value;

    CreditCard(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static CreditCard fromValue(String v) {
        for (CreditCard c: CreditCard.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}