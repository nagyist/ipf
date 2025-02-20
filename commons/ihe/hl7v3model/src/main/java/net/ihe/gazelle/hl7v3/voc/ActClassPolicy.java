/**
 * ActClassPolicy.java
 * <p>
 * File generated from the voc::ActClassPolicy uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ActClassPolicy.
 *
 */

@XmlType(name = "ActClassPolicy")
@XmlEnum
@XmlRootElement(name = "ActClassPolicy")
public enum ActClassPolicy {
	@XmlEnumValue("JURISPOL")
	JURISPOL("JURISPOL"),
	@XmlEnumValue("ORGPOL")
	ORGPOL("ORGPOL"),
	@XmlEnumValue("POLICY")
	POLICY("POLICY"),
	@XmlEnumValue("SCOPOL")
	SCOPOL("SCOPOL"),
	@XmlEnumValue("STDPOL")
	STDPOL("STDPOL");
	
	private final String value;

    ActClassPolicy(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ActClassPolicy fromValue(String v) {
        for (ActClassPolicy c: ActClassPolicy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}