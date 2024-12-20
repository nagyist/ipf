/**
 * DataTypeSetOfUncertainValueProbabilistic.java
 * <p>
 * File generated from the voc::DataTypeSetOfUncertainValueProbabilistic uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration DataTypeSetOfUncertainValueProbabilistic.
 *
 */

@XmlType(name = "DataTypeSetOfUncertainValueProbabilistic")
@XmlEnum
@XmlRootElement(name = "DataTypeSetOfUncertainValueProbabilistic")
public enum DataTypeSetOfUncertainValueProbabilistic {
	@XmlEnumValue("NPPD<ANY>")
	NPPDANY("NPPD<ANY>"),
	@XmlEnumValue("SET<UVP<ANY>>")
	SETUVPANY("SET<UVP<ANY>>");
	
	private final String value;

    DataTypeSetOfUncertainValueProbabilistic(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static DataTypeSetOfUncertainValueProbabilistic fromValue(String v) {
        for (DataTypeSetOfUncertainValueProbabilistic c: DataTypeSetOfUncertainValueProbabilistic.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}