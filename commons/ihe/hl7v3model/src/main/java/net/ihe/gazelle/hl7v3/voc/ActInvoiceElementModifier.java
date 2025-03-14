/**
 * ActInvoiceElementModifier.java
 * <p>
 * File generated from the voc::ActInvoiceElementModifier uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ActInvoiceElementModifier.
 *
 */

@XmlType(name = "ActInvoiceElementModifier")
@XmlEnum
@XmlRootElement(name = "ActInvoiceElementModifier")
public enum ActInvoiceElementModifier {
	@XmlEnumValue("EFORM")
	EFORM("EFORM"),
	@XmlEnumValue("FAX")
	FAX("FAX"),
	@XmlEnumValue("LINV")
	LINV("LINV"),
	@XmlEnumValue("PAPER")
	PAPER("PAPER");
	
	private final String value;

    ActInvoiceElementModifier(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ActInvoiceElementModifier fromValue(String v) {
        for (ActInvoiceElementModifier c: ActInvoiceElementModifier.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}