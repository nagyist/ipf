/**
 * VideoMediaType.java
 *
 * File generated from the voc::VideoMediaType uml Enumeration
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.voc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Description of the enumeration VideoMediaType.
 *
 */

@XmlType(name = "VideoMediaType")
@XmlEnum
@XmlRootElement(name = "VideoMediaType")
public enum VideoMediaType {
	@XmlEnumValue("video/mpeg")
	VIDEOMPEG("video/mpeg"),
	@XmlEnumValue("video/x-avi")
	VIDEOXAVI("video/x-avi");
	
	private final String value;

    VideoMediaType(String v) {
        value = v;
    }
    
     public String value() {
        return value;
    }

    public static VideoMediaType fromValue(String v) {
        for (VideoMediaType c: VideoMediaType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}