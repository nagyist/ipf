/**
 * QueryResponse.java
 *
 * File generated from the voc::QueryResponse uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration QueryResponse.
 *
 */

@XmlType(name = "QueryResponse")
@XmlEnum
@XmlRootElement(name = "QueryResponse")
public enum QueryResponse {
	@XmlEnumValue("AE")
	AE("AE"),
	@XmlEnumValue("NF")
	NF("NF"),
	@XmlEnumValue("OK")
	OK("OK"),
	@XmlEnumValue("QE")
	QE("QE");
	
	private final String value;

    QueryResponse(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static QueryResponse fromValue(String v) {
        for (QueryResponse c: QueryResponse.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}