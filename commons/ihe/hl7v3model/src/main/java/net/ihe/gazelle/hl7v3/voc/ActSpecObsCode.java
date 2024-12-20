/**
 * ActSpecObsCode.java
 * <p>
 * File generated from the voc::ActSpecObsCode uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ActSpecObsCode.
 *
 */

@XmlType(name = "ActSpecObsCode")
@XmlEnum
@XmlRootElement(name = "ActSpecObsCode")
public enum ActSpecObsCode {
	@XmlEnumValue("ARTBLD")
	ARTBLD("ARTBLD"),
	@XmlEnumValue("AUTO-HIGH")
	AUTOHIGH("AUTO-HIGH"),
	@XmlEnumValue("AUTO-LOW")
	AUTOLOW("AUTO-LOW"),
	@XmlEnumValue("AVAILABLE")
	AVAILABLE("AVAILABLE"),
	@XmlEnumValue("CONSUMPTION")
	CONSUMPTION("CONSUMPTION"),
	@XmlEnumValue("CURRENT")
	CURRENT("CURRENT"),
	@XmlEnumValue("DILUTION")
	DILUTION("DILUTION"),
	@XmlEnumValue("EVNFCTS")
	EVNFCTS("EVNFCTS"),
	@XmlEnumValue("FIBRIN")
	FIBRIN("FIBRIN"),
	@XmlEnumValue("HEMOLYSIS")
	HEMOLYSIS("HEMOLYSIS"),
	@XmlEnumValue("ICTERUS")
	ICTERUS("ICTERUS"),
	@XmlEnumValue("INITIAL")
	INITIAL("INITIAL"),
	@XmlEnumValue("INTFR")
	INTFR("INTFR"),
	@XmlEnumValue("LIPEMIA")
	LIPEMIA("LIPEMIA"),
	@XmlEnumValue("PRE")
	PRE("PRE"),
	@XmlEnumValue("RERUN")
	RERUN("RERUN"),
	@XmlEnumValue("VOLUME")
	VOLUME("VOLUME");
	
	private final String value;

    ActSpecObsCode(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ActSpecObsCode fromValue(String v) {
        for (ActSpecObsCode c: ActSpecObsCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}