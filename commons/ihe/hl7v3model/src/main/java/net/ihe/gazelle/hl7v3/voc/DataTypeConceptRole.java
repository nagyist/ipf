/**
 * DataTypeConceptRole.java
 *
 * File generated from the voc::DataTypeConceptRole uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration DataTypeConceptRole.
 *
 */

@XmlType(name = "DataTypeConceptRole")
@XmlEnum
@XmlRootElement(name = "DataTypeConceptRole")
public enum DataTypeConceptRole {
	@XmlEnumValue("CR")
	CR("CR");
	
	private final String value;

    DataTypeConceptRole(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static DataTypeConceptRole fromValue(String v) {
        for (DataTypeConceptRole c: DataTypeConceptRole.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}