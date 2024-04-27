/**
 * NonRigidContainerEntityType.java
 *
 * File generated from the voc::NonRigidContainerEntityType uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration NonRigidContainerEntityType.
 *
 */

@XmlType(name = "NonRigidContainerEntityType")
@XmlEnum
@XmlRootElement(name = "NonRigidContainerEntityType")
public enum NonRigidContainerEntityType {
	@XmlEnumValue("BAG")
	BAG("BAG"),
	@XmlEnumValue("PACKT")
	PACKT("PACKT"),
	@XmlEnumValue("PCH")
	PCH("PCH"),
	@XmlEnumValue("SACH")
	SACH("SACH");
	
	private final String value;

    NonRigidContainerEntityType(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static NonRigidContainerEntityType fromValue(String v) {
        for (NonRigidContainerEntityType c: NonRigidContainerEntityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}