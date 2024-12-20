/**
 * DataTypeSetOfUncertainProbabilisticIntervalOfPhysicalQuantities.java
 * <p>
 * File generated from the voc::DataTypeSetOfUncertainProbabilisticIntervalOfPhysicalQuantities uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration DataTypeSetOfUncertainProbabilisticIntervalOfPhysicalQuantities.
 *
 */

@XmlType(name = "DataTypeSetOfUncertainProbabilisticIntervalOfPhysicalQuantities")
@XmlEnum
@XmlRootElement(name = "DataTypeSetOfUncertainProbabilisticIntervalOfPhysicalQuantities")
public enum DataTypeSetOfUncertainProbabilisticIntervalOfPhysicalQuantities {
	@XmlEnumValue("NPPD<IVL<PQ>>")
	NPPDIVLPQ("NPPD<IVL<PQ>>"),
	@XmlEnumValue("SET<UVP<IVL<PQ>>>")
	SETUVPIVLPQ("SET<UVP<IVL<PQ>>>");
	
	private final String value;

    DataTypeSetOfUncertainProbabilisticIntervalOfPhysicalQuantities(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static DataTypeSetOfUncertainProbabilisticIntervalOfPhysicalQuantities fromValue(String v) {
        for (DataTypeSetOfUncertainProbabilisticIntervalOfPhysicalQuantities c: DataTypeSetOfUncertainProbabilisticIntervalOfPhysicalQuantities.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}