/**
 * ActInformationAccessCode.java
 *
 * File generated from the voc::ActInformationAccessCode uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ActInformationAccessCode.
 *
 */

@XmlType(name = "ActInformationAccessCode")
@XmlEnum
@XmlRootElement(name = "ActInformationAccessCode")
public enum ActInformationAccessCode {
	@XmlEnumValue("ACADR")
	ACADR("ACADR"),
	@XmlEnumValue("ACALLG")
	ACALLG("ACALLG"),
	@XmlEnumValue("ACDEMO")
	ACDEMO("ACDEMO"),
	@XmlEnumValue("ACIMMUN")
	ACIMMUN("ACIMMUN"),
	@XmlEnumValue("ACLAB")
	ACLAB("ACLAB"),
	@XmlEnumValue("ACMED")
	ACMED("ACMED"),
	@XmlEnumValue("ACMEDC")
	ACMEDC("ACMEDC"),
	@XmlEnumValue("ACOBS")
	ACOBS("ACOBS"),
	@XmlEnumValue("ACPOLPRG")
	ACPOLPRG("ACPOLPRG"),
	@XmlEnumValue("ACPROV")
	ACPROV("ACPROV"),
	@XmlEnumValue("ACPSERV")
	ACPSERV("ACPSERV");
	
	private final String value;

    ActInformationAccessCode(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ActInformationAccessCode fromValue(String v) {
        for (ActInformationAccessCode c: ActInformationAccessCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}