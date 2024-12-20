/**
 * RoleClassOntologicalEquivalentEntityByBOT.java
 * <p>
 * File generated from the voc::RoleClassOntologicalEquivalentEntityByBOT uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration RoleClassOntologicalEquivalentEntityByBOT.
 *
 */

@XmlType(name = "RoleClassOntologicalEquivalentEntityByBOT")
@XmlEnum
@XmlRootElement(name = "RoleClassOntologicalEquivalentEntityByBOT")
public enum RoleClassOntologicalEquivalentEntityByBOT {
	@XmlEnumValue("EQUIV")
	EQUIV("EQUIV"),
	@XmlEnumValue("SAME")
	SAME("SAME"),
	@XmlEnumValue("SUBY")
	SUBY("SUBY");
	
	private final String value;

    RoleClassOntologicalEquivalentEntityByBOT(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static RoleClassOntologicalEquivalentEntityByBOT fromValue(String v) {
        for (RoleClassOntologicalEquivalentEntityByBOT c: RoleClassOntologicalEquivalentEntityByBOT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}