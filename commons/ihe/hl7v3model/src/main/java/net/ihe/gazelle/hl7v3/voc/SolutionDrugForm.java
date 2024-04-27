/**
 * SolutionDrugForm.java
 *
 * File generated from the voc::SolutionDrugForm uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration SolutionDrugForm.
 *
 */

@XmlType(name = "SolutionDrugForm")
@XmlEnum
@XmlRootElement(name = "SolutionDrugForm")
public enum SolutionDrugForm {
	@XmlEnumValue("DOUCHE")
	DOUCHE("DOUCHE"),
	@XmlEnumValue("DROP")
	DROP("DROP"),
	@XmlEnumValue("ELIXIR")
	ELIXIR("ELIXIR"),
	@XmlEnumValue("ENEMA")
	ENEMA("ENEMA"),
	@XmlEnumValue("IPSOL")
	IPSOL("IPSOL"),
	@XmlEnumValue("IRSOL")
	IRSOL("IRSOL"),
	@XmlEnumValue("IVSOL")
	IVSOL("IVSOL"),
	@XmlEnumValue("LIN")
	LIN("LIN"),
	@XmlEnumValue("MUCTOPSOL")
	MUCTOPSOL("MUCTOPSOL"),
	@XmlEnumValue("NDROP")
	NDROP("NDROP"),
	@XmlEnumValue("OPDROP")
	OPDROP("OPDROP"),
	@XmlEnumValue("OPIRSOL")
	OPIRSOL("OPIRSOL"),
	@XmlEnumValue("ORALSOL")
	ORALSOL("ORALSOL"),
	@XmlEnumValue("ORDROP")
	ORDROP("ORDROP"),
	@XmlEnumValue("OTDROP")
	OTDROP("OTDROP"),
	@XmlEnumValue("RECSOL")
	RECSOL("RECSOL"),
	@XmlEnumValue("RINSE")
	RINSE("RINSE"),
	@XmlEnumValue("SOL")
	SOL("SOL"),
	@XmlEnumValue("SYRUP")
	SYRUP("SYRUP"),
	@XmlEnumValue("TINC")
	TINC("TINC"),
	@XmlEnumValue("TOPSOL")
	TOPSOL("TOPSOL");
	
	private final String value;

    SolutionDrugForm(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static SolutionDrugForm fromValue(String v) {
        for (SolutionDrugForm c: SolutionDrugForm.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}