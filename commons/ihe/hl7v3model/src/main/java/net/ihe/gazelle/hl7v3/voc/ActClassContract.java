/**
 * ActClassContract.java
 *
 * File generated from the voc::ActClassContract uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ActClassContract.
 *
 */

@XmlType(name = "ActClassContract")
@XmlEnum
@XmlRootElement(name = "ActClassContract")
public enum ActClassContract {
	@XmlEnumValue("CNTRCT")
	CNTRCT("CNTRCT"),
	@XmlEnumValue("COV")
	COV("COV"),
	@XmlEnumValue("FCNTRCT")
	FCNTRCT("FCNTRCT");
	
	private final String value;

    ActClassContract(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ActClassContract fromValue(String v) {
        for (ActClassContract c: ActClassContract.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}