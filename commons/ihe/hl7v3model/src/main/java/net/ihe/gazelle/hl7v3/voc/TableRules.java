/**
 * TableRules.java
 *
 * File generated from the voc::TableRules uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration TableRules.
 *
 */

@XmlType(name = "TableRules")
@XmlEnum
@XmlRootElement(name = "TableRules")
public enum TableRules {
	@XmlEnumValue("all")
	ALL("all"),
	@XmlEnumValue("cols")
	COLS("cols"),
	@XmlEnumValue("groups")
	GROUPS("groups"),
	@XmlEnumValue("none")
	NONE("none"),
	@XmlEnumValue("rows")
	ROWS("rows");
	
	private final String value;

    TableRules(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static TableRules fromValue(String v) {
        for (TableRules c: TableRules.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}