/**
 * DataTypeSequenceOfSequencesOfDataValues.java
 * <p>
 * File generated from the voc::DataTypeSequenceOfSequencesOfDataValues uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration DataTypeSequenceOfSequencesOfDataValues.
 *
 */

@XmlType(name = "DataTypeSequenceOfSequencesOfDataValues")
@XmlEnum
@XmlRootElement(name = "DataTypeSequenceOfSequencesOfDataValues")
public enum DataTypeSequenceOfSequencesOfDataValues {
	@XmlEnumValue("AD")
	AD("AD"),
	@XmlEnumValue("LIST<ADXP>")
	LISTADXP("LIST<ADXP>"),
	@XmlEnumValue("LIST<BIN>")
	LISTBIN("LIST<BIN>"),
	@XmlEnumValue("LIST<ED>")
	LISTED("LIST<ED>"),
	@XmlEnumValue("LIST<LIST<ANY>>")
	LISTLISTANY("LIST<LIST<ANY>>"),
	@XmlEnumValue("LIST<LIST<BL>>")
	LISTLISTBL("LIST<LIST<BL>>"),
	@XmlEnumValue("LIST<PNXP>")
	LISTPNXP("LIST<PNXP>"),
	@XmlEnumValue("LIST<ST>")
	LISTST("LIST<ST>"),
	@XmlEnumValue("PN")
	PN("PN");
	
	private final String value;

    DataTypeSequenceOfSequencesOfDataValues(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static DataTypeSequenceOfSequencesOfDataValues fromValue(String v) {
        for (DataTypeSequenceOfSequencesOfDataValues c: DataTypeSequenceOfSequencesOfDataValues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}