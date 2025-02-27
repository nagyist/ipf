/**
 * DataTypeSetOfPhysicalQuantities.java
 * <p>
 * File generated from the voc::DataTypeSetOfPhysicalQuantities uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration DataTypeSetOfPhysicalQuantities.
 *
 */

@XmlType(name = "DataTypeSetOfPhysicalQuantities")
@XmlEnum
@XmlRootElement(name = "DataTypeSetOfPhysicalQuantities")
public enum DataTypeSetOfPhysicalQuantities {
	@XmlEnumValue("SET<PQ>")
	SETPQ("SET<PQ>");
	
	private final String value;

    DataTypeSetOfPhysicalQuantities(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static DataTypeSetOfPhysicalQuantities fromValue(String v) {
        for (DataTypeSetOfPhysicalQuantities c: DataTypeSetOfPhysicalQuantities.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}