/**
 * ActClass.java
 * <p>
 * File generated from the voc::ActClass uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration ActClass.
 *
 */

@XmlType(name = "ActClass")
@XmlEnum
@XmlRootElement(name = "ActClass")
public enum ActClass {
	@XmlEnumValue("ACCM")
	ACCM("ACCM"),
	@XmlEnumValue("ACCT")
	ACCT("ACCT"),
	@XmlEnumValue("ACSN")
	ACSN("ACSN"),
	@XmlEnumValue("ACT")
	ACT("ACT"),
	@XmlEnumValue("ACTN")
	ACTN("ACTN"),
	@XmlEnumValue("ADJUD")
	ADJUD("ADJUD"),
	@XmlEnumValue("AEXPOS")
	AEXPOS("AEXPOS"),
	@XmlEnumValue("ALRT")
	ALRT("ALRT"),
	@XmlEnumValue("BATTERY")
	BATTERY("BATTERY"),
	@XmlEnumValue("CACT")
	CACT("CACT"),
	@XmlEnumValue("CASE")
	CASE("CASE"),
	@XmlEnumValue("CATEGORY")
	CATEGORY("CATEGORY"),
	@XmlEnumValue("CDALVLONE")
	CDALVLONE("CDALVLONE"),
	@XmlEnumValue("CLNTRL")
	CLNTRL("CLNTRL"),
	@XmlEnumValue("CLUSTER")
	CLUSTER("CLUSTER"),
	@XmlEnumValue("CNOD")
	CNOD("CNOD"),
	@XmlEnumValue("CNTRCT")
	CNTRCT("CNTRCT"),
	@XmlEnumValue("COMPOSITION")
	COMPOSITION("COMPOSITION"),
	@XmlEnumValue("COND")
	COND("COND"),
	@XmlEnumValue("CONS")
	CONS("CONS"),
	@XmlEnumValue("CONTREG")
	CONTREG("CONTREG"),
	@XmlEnumValue("COV")
	COV("COV"),
	@XmlEnumValue("CTTEVENT")
	CTTEVENT("CTTEVENT"),
	@XmlEnumValue("DETPOL")
	DETPOL("DETPOL"),
	@XmlEnumValue("DGIMG")
	DGIMG("DGIMG"),
	@XmlEnumValue("DIET")
	DIET("DIET"),
	@XmlEnumValue("DISPACT")
	DISPACT("DISPACT"),
	@XmlEnumValue("DOC")
	DOC("DOC"),
	@XmlEnumValue("DOCBODY")
	DOCBODY("DOCBODY"),
	@XmlEnumValue("DOCCLIN")
	DOCCLIN("DOCCLIN"),
	@XmlEnumValue("DOCSECT")
	DOCSECT("DOCSECT"),
	@XmlEnumValue("EHR")
	EHR("EHR"),
	@XmlEnumValue("ENC")
	ENC("ENC"),
	@XmlEnumValue("ENTRY")
	ENTRY("ENTRY"),
	@XmlEnumValue("EXP")
	EXP("EXP"),
	@XmlEnumValue("EXPOS")
	EXPOS("EXPOS"),
	@XmlEnumValue("EXTRACT")
	EXTRACT("EXTRACT"),
	@XmlEnumValue("FCNTRCT")
	FCNTRCT("FCNTRCT"),
	@XmlEnumValue("FOLDER")
	FOLDER("FOLDER"),
	@XmlEnumValue("GEN")
	GEN("GEN"),
	@XmlEnumValue("INC")
	INC("INC"),
	@XmlEnumValue("INFO")
	INFO("INFO"),
	@XmlEnumValue("INFRM")
	INFRM("INFRM"),
	@XmlEnumValue("INVE")
	INVE("INVE"),
	@XmlEnumValue("INVSTG")
	INVSTG("INVSTG"),
	@XmlEnumValue("JURISPOL")
	JURISPOL("JURISPOL"),
	@XmlEnumValue("LIST")
	LIST("LIST"),
	@XmlEnumValue("LLD")
	LLD("LLD"),
	@XmlEnumValue("LOC")
	LOC("LOC"),
	@XmlEnumValue("MPROT")
	MPROT("MPROT"),
	@XmlEnumValue("OBS")
	OBS("OBS"),
	@XmlEnumValue("OBSCOR")
	OBSCOR("OBSCOR"),
	@XmlEnumValue("OBSSER")
	OBSSER("OBSSER"),
	@XmlEnumValue("ORGANIZER")
	ORGANIZER("ORGANIZER"),
	@XmlEnumValue("ORGPOL")
	ORGPOL("ORGPOL"),
	@XmlEnumValue("OUTB")
	OUTB("OUTB"),
	@XmlEnumValue("PCPR")
	PCPR("PCPR"),
	@XmlEnumValue("PHN")
	PHN("PHN"),
	@XmlEnumValue("POL")
	POL("POL"),
	@XmlEnumValue("POLICY")
	POLICY("POLICY"),
	@XmlEnumValue("POS")
	POS("POS"),
	@XmlEnumValue("POSACC")
	POSACC("POSACC"),
	@XmlEnumValue("POSCOORD")
	POSCOORD("POSCOORD"),
	@XmlEnumValue("PRN")
	PRN("PRN"),
	@XmlEnumValue("PROC")
	PROC("PROC"),
	@XmlEnumValue("REG")
	REG("REG"),
	@XmlEnumValue("REV")
	REV("REV"),
	@XmlEnumValue("RLD")
	RLD("RLD"),
	@XmlEnumValue("ROIBND")
	ROIBND("ROIBND"),
	@XmlEnumValue("ROIOVL")
	ROIOVL("ROIOVL"),
	@XmlEnumValue("RTRD")
	RTRD("RTRD"),
	@XmlEnumValue("SBADM")
	SBADM("SBADM"),
	@XmlEnumValue("SCOPOL")
	SCOPOL("SCOPOL"),
	@XmlEnumValue("SEQ")
	SEQ("SEQ"),
	@XmlEnumValue("SEQVAR")
	SEQVAR("SEQVAR"),
	@XmlEnumValue("SFWL")
	SFWL("SFWL"),
	@XmlEnumValue("SIT")
	SIT("SIT"),
	@XmlEnumValue("SPCOBS")
	SPCOBS("SPCOBS"),
	@XmlEnumValue("SPCTRT")
	SPCTRT("SPCTRT"),
	@XmlEnumValue("SPECCOLLECT")
	SPECCOLLECT("SPECCOLLECT"),
	@XmlEnumValue("SPLY")
	SPLY("SPLY"),
	@XmlEnumValue("STC")
	STC("STC"),
	@XmlEnumValue("STDPOL")
	STDPOL("STDPOL"),
	@XmlEnumValue("STN")
	STN("STN"),
	@XmlEnumValue("SUBST")
	SUBST("SUBST"),
	@XmlEnumValue("SUP")
	SUP("SUP"),
	@XmlEnumValue("TEXPOS")
	TEXPOS("TEXPOS"),
	@XmlEnumValue("TOPIC")
	TOPIC("TOPIC"),
	@XmlEnumValue("TRD")
	TRD("TRD"),
	@XmlEnumValue("TRFR")
	TRFR("TRFR"),
	@XmlEnumValue("TRNS")
	TRNS("TRNS"),
	@XmlEnumValue("VERIF")
	VERIF("VERIF"),
	@XmlEnumValue("XACT")
	XACT("XACT"),
	@XmlEnumValue("_ImagingSubjectOrientation")
	IMAGINGSUBJECTORIENTATION("_ImagingSubjectOrientation");
	
	private final String value;

    ActClass(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static ActClass fromValue(String v) {
        for (ActClass c: ActClass.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}