/**
 * XActRelationshipDocument.java
 * <p>
 * File generated from the voc::XActRelationshipDocument uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration XActRelationshipDocument.
 *
 */

@XmlType(name = "XActRelationshipDocument")
@XmlEnum
@XmlRootElement(name = "XActRelationshipDocument")
public enum XActRelationshipDocument {
	@XmlEnumValue("APND")
	APND("APND"),
	@XmlEnumValue("RPLC")
	RPLC("RPLC"),
	@XmlEnumValue("XFRM")
	XFRM("XFRM");
	
	private final String value;

    XActRelationshipDocument(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static XActRelationshipDocument fromValue(String v) {
        for (XActRelationshipDocument c: XActRelationshipDocument.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}