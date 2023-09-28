/**
 * SolidDrugForm.java
 *
 * File generated from the voc::SolidDrugForm uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration SolidDrugForm.
 *
 */

@XmlType(name = "SolidDrugForm")
@XmlEnum
@XmlRootElement(name = "SolidDrugForm")
public enum SolidDrugForm {
	@XmlEnumValue("BAR")
	BAR("BAR"),
	@XmlEnumValue("BARSOAP")
	BARSOAP("BARSOAP"),
	@XmlEnumValue("BEAD")
	BEAD("BEAD"),
	@XmlEnumValue("BUCTAB")
	BUCTAB("BUCTAB"),
	@XmlEnumValue("CAKE")
	CAKE("CAKE"),
	@XmlEnumValue("CAP")
	CAP("CAP"),
	@XmlEnumValue("CAPLET")
	CAPLET("CAPLET"),
	@XmlEnumValue("CEMENT")
	CEMENT("CEMENT"),
	@XmlEnumValue("CHEWBAR")
	CHEWBAR("CHEWBAR"),
	@XmlEnumValue("CHEWTAB")
	CHEWTAB("CHEWTAB"),
	@XmlEnumValue("CPTAB")
	CPTAB("CPTAB"),
	@XmlEnumValue("CRYS")
	CRYS("CRYS"),
	@XmlEnumValue("DISINTAB")
	DISINTAB("DISINTAB"),
	@XmlEnumValue("DISK")
	DISK("DISK"),
	@XmlEnumValue("DRTAB")
	DRTAB("DRTAB"),
	@XmlEnumValue("ECTAB")
	ECTAB("ECTAB"),
	@XmlEnumValue("ENTCAP")
	ENTCAP("ENTCAP"),
	@XmlEnumValue("ERCAP")
	ERCAP("ERCAP"),
	@XmlEnumValue("ERCAP12")
	ERCAP12("ERCAP12"),
	@XmlEnumValue("ERCAP24")
	ERCAP24("ERCAP24"),
	@XmlEnumValue("ERECCAP")
	ERECCAP("ERECCAP"),
	@XmlEnumValue("ERECTAB")
	ERECTAB("ERECTAB"),
	@XmlEnumValue("ERENTCAP")
	ERENTCAP("ERENTCAP"),
	@XmlEnumValue("ERTAB")
	ERTAB("ERTAB"),
	@XmlEnumValue("ERTAB12")
	ERTAB12("ERTAB12"),
	@XmlEnumValue("ERTAB24")
	ERTAB24("ERTAB24"),
	@XmlEnumValue("FLAKE")
	FLAKE("FLAKE"),
	@XmlEnumValue("GRAN")
	GRAN("GRAN"),
	@XmlEnumValue("GUM")
	GUM("GUM"),
	@XmlEnumValue("MEDBAR")
	MEDBAR("MEDBAR"),
	@XmlEnumValue("MEDPAD")
	MEDPAD("MEDPAD"),
	@XmlEnumValue("MEDSWAB")
	MEDSWAB("MEDSWAB"),
	@XmlEnumValue("ORCAP")
	ORCAP("ORCAP"),
	@XmlEnumValue("ORTAB")
	ORTAB("ORTAB"),
	@XmlEnumValue("ORTROCHE")
	ORTROCHE("ORTROCHE"),
	@XmlEnumValue("PAD")
	PAD("PAD"),
	@XmlEnumValue("PATCH")
	PATCH("PATCH"),
	@XmlEnumValue("PELLET")
	PELLET("PELLET"),
	@XmlEnumValue("PILL")
	PILL("PILL"),
	@XmlEnumValue("POWD")
	POWD("POWD"),
	@XmlEnumValue("RECPWD")
	RECPWD("RECPWD"),
	@XmlEnumValue("RECSUPP")
	RECSUPP("RECSUPP"),
	@XmlEnumValue("SLTAB")
	SLTAB("SLTAB"),
	@XmlEnumValue("SRBUCTAB")
	SRBUCTAB("SRBUCTAB"),
	@XmlEnumValue("SUPP")
	SUPP("SUPP"),
	@XmlEnumValue("SWAB")
	SWAB("SWAB"),
	@XmlEnumValue("TAB")
	TAB("TAB"),
	@XmlEnumValue("TOPPWD")
	TOPPWD("TOPPWD"),
	@XmlEnumValue("TPATCH")
	TPATCH("TPATCH"),
	@XmlEnumValue("TPATH16")
	TPATH16("TPATH16"),
	@XmlEnumValue("TPATH24")
	TPATH24("TPATH24"),
	@XmlEnumValue("TPATH2WK")
	TPATH2WK("TPATH2WK"),
	@XmlEnumValue("TPATH72")
	TPATH72("TPATH72"),
	@XmlEnumValue("TPATHWK")
	TPATHWK("TPATHWK"),
	@XmlEnumValue("URETHSUPP")
	URETHSUPP("URETHSUPP"),
	@XmlEnumValue("VAGPWD")
	VAGPWD("VAGPWD"),
	@XmlEnumValue("VAGSUPP")
	VAGSUPP("VAGSUPP"),
	@XmlEnumValue("VAGTAB")
	VAGTAB("VAGTAB"),
	@XmlEnumValue("WAFER")
	WAFER("WAFER");
	
	private final String value;

    SolidDrugForm(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static SolidDrugForm fromValue(String v) {
        for (SolidDrugForm c: SolidDrugForm.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}