/**
 * DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities.java
 *
 * File generated from the voc::DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities.
 *
 */

@XmlType(name = "DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities")
@XmlEnum
@XmlRootElement(name = "DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities")
public enum DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities {
	@XmlEnumValue("NPPD<IVL<PQ>>")
	NPPDIVLPQ("NPPD<IVL<PQ>>");
	
	private final String value;

    DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities fromValue(String v) {
        for (DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities c: DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}