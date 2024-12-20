/**
 * RoleClassManufacturedProduct.java
 * <p>
 * File generated from the voc::RoleClassManufacturedProduct uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RoleClassManufacturedProduct.
 *
 */

@XmlType(name = "RoleClassManufacturedProduct")
@XmlEnum
@XmlRootElement(name = "RoleClassManufacturedProduct")
public enum RoleClassManufacturedProduct {
	@XmlEnumValue("MANU")
	MANU("MANU"),
	@XmlEnumValue("THER")
	THER("THER");
	
	private final String value;

    RoleClassManufacturedProduct(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RoleClassManufacturedProduct fromValue(String v) {
        for (RoleClassManufacturedProduct c: RoleClassManufacturedProduct.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}