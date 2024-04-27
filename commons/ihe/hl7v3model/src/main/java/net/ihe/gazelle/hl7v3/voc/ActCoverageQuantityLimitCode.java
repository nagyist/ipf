/**
 * ActCoverageQuantityLimitCode.java
 *
 * File generated from the voc::ActCoverageQuantityLimitCode uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ActCoverageQuantityLimitCode.
 *
 */

@XmlType(name = "ActCoverageQuantityLimitCode")
@XmlEnum
@XmlRootElement(name = "ActCoverageQuantityLimitCode")
public enum ActCoverageQuantityLimitCode {
	@XmlEnumValue("COVPRD")
	COVPRD("COVPRD"),
	@XmlEnumValue("LFEMX")
	LFEMX("LFEMX"),
	@XmlEnumValue("NETAMT")
	NETAMT("NETAMT"),
	@XmlEnumValue("PRDMX")
	PRDMX("PRDMX"),
	@XmlEnumValue("UNITPRICE")
	UNITPRICE("UNITPRICE"),
	@XmlEnumValue("UNITQTY")
	UNITQTY("UNITQTY");
	
	private final String value;

    ActCoverageQuantityLimitCode(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ActCoverageQuantityLimitCode fromValue(String v) {
        for (ActCoverageQuantityLimitCode c: ActCoverageQuantityLimitCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}