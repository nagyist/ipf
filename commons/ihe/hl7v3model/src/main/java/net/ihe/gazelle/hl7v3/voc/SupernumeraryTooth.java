/**
 * SupernumeraryTooth.java
 *
 * File generated from the voc::SupernumeraryTooth uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration SupernumeraryTooth.
 *
 */

@XmlType(name = "SupernumeraryTooth")
@XmlEnum
@XmlRootElement(name = "SupernumeraryTooth")
public enum SupernumeraryTooth {
	@XmlEnumValue("TID10s")
	TID10S("TID10s"),
	@XmlEnumValue("TID11s")
	TID11S("TID11s"),
	@XmlEnumValue("TID12s")
	TID12S("TID12s"),
	@XmlEnumValue("TID13s")
	TID13S("TID13s"),
	@XmlEnumValue("TID14s")
	TID14S("TID14s"),
	@XmlEnumValue("TID15s")
	TID15S("TID15s"),
	@XmlEnumValue("TID16s")
	TID16S("TID16s"),
	@XmlEnumValue("TID17s")
	TID17S("TID17s"),
	@XmlEnumValue("TID18s")
	TID18S("TID18s"),
	@XmlEnumValue("TID19s")
	TID19S("TID19s"),
	@XmlEnumValue("TID1s")
	TID1S("TID1s"),
	@XmlEnumValue("TID20s")
	TID20S("TID20s"),
	@XmlEnumValue("TID21s")
	TID21S("TID21s"),
	@XmlEnumValue("TID22s")
	TID22S("TID22s"),
	@XmlEnumValue("TID23s")
	TID23S("TID23s"),
	@XmlEnumValue("TID24s")
	TID24S("TID24s"),
	@XmlEnumValue("TID25s")
	TID25S("TID25s"),
	@XmlEnumValue("TID26s")
	TID26S("TID26s"),
	@XmlEnumValue("TID27s")
	TID27S("TID27s"),
	@XmlEnumValue("TID28s")
	TID28S("TID28s"),
	@XmlEnumValue("TID29s")
	TID29S("TID29s"),
	@XmlEnumValue("TID2s")
	TID2S("TID2s"),
	@XmlEnumValue("TID30s")
	TID30S("TID30s"),
	@XmlEnumValue("TID31s")
	TID31S("TID31s"),
	@XmlEnumValue("TID32s")
	TID32S("TID32s"),
	@XmlEnumValue("TID3s")
	TID3S("TID3s"),
	@XmlEnumValue("TID4s")
	TID4S("TID4s"),
	@XmlEnumValue("TID5s")
	TID5S("TID5s"),
	@XmlEnumValue("TID6s")
	TID6S("TID6s"),
	@XmlEnumValue("TID7s")
	TID7S("TID7s"),
	@XmlEnumValue("TID8s")
	TID8S("TID8s"),
	@XmlEnumValue("TID9s")
	TID9S("TID9s"),
	@XmlEnumValue("TIDAs")
	TIDAS("TIDAs"),
	@XmlEnumValue("TIDBs")
	TIDBS("TIDBs"),
	@XmlEnumValue("TIDCs")
	TIDCS("TIDCs"),
	@XmlEnumValue("TIDDs")
	TIDDS("TIDDs"),
	@XmlEnumValue("TIDEs")
	TIDES("TIDEs"),
	@XmlEnumValue("TIDFs")
	TIDFS("TIDFs"),
	@XmlEnumValue("TIDGs")
	TIDGS("TIDGs"),
	@XmlEnumValue("TIDHs")
	TIDHS("TIDHs"),
	@XmlEnumValue("TIDIs")
	TIDIS("TIDIs"),
	@XmlEnumValue("TIDJs")
	TIDJS("TIDJs"),
	@XmlEnumValue("TIDKs")
	TIDKS("TIDKs"),
	@XmlEnumValue("TIDLs")
	TIDLS("TIDLs"),
	@XmlEnumValue("TIDMs")
	TIDMS("TIDMs"),
	@XmlEnumValue("TIDNs")
	TIDNS("TIDNs"),
	@XmlEnumValue("TIDOs")
	TIDOS("TIDOs"),
	@XmlEnumValue("TIDPs")
	TIDPS("TIDPs"),
	@XmlEnumValue("TIDQs")
	TIDQS("TIDQs"),
	@XmlEnumValue("TIDRs")
	TIDRS("TIDRs"),
	@XmlEnumValue("TIDSs")
	TIDSS("TIDSs"),
	@XmlEnumValue("TIDTs")
	TIDTS("TIDTs");
	
	private final String value;

    SupernumeraryTooth(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static SupernumeraryTooth fromValue(String v) {
        for (SupernumeraryTooth c: SupernumeraryTooth.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}