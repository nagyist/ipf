/**
 * PlasticSurgeryProviderCodes.java
 *
 * File generated from the voc::PlasticSurgeryProviderCodes uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration PlasticSurgeryProviderCodes.
 *
 */

@XmlType(name = "PlasticSurgeryProviderCodes")
@XmlEnum
@XmlRootElement(name = "PlasticSurgeryProviderCodes")
public enum PlasticSurgeryProviderCodes {
	@XmlEnumValue("208200000X")
	_208200000X("208200000X"),
	@XmlEnumValue("2082S0099X")
	_2082S0099X("2082S0099X"),
	@XmlEnumValue("2082S0105X")
	_2082S0105X("2082S0105X");
	
	private final String value;

    PlasticSurgeryProviderCodes(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static PlasticSurgeryProviderCodes fromValue(String v) {
        for (PlasticSurgeryProviderCodes c: PlasticSurgeryProviderCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}