/**
 * ED.java
 * <p>
 * File generated from the datatypes::ED uml Class
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.datatypes;

// End of user code
import java.io.Serial;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.ihe.gazelle.gen.common.ConstraintValidatorModule;

import org.w3c.dom.Document;
import org.w3c.dom.Node;


/**
 * Description of the class ED.
 *
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ED", propOrder = {
	"compression",
	"integrityCheck",
	"integrityCheckAlgorithm",
	"language",
	"mediaType"
})
@XmlRootElement(name = "ED")
public class ED extends net.ihe.gazelle.hl7v3.datatypes.BIN implements java.io.Serializable {
	
	/**
	 * 
	 */
	@Serial
    private static final long serialVersionUID = 1L;

	
	/**
	 * 
	                     Indicates whether the raw byte data is compressed,
	                     and what compression algorithm was used.
	                  .
	 */
	@XmlAttribute(name = "compression")
	public net.ihe.gazelle.hl7v3.voc.CompressionAlgorithm compression;
	/**
	 * 
	                     The integrity check is a short binary value representing
	                     a cryptographically strong checksum that is calculated
	                     over the binary data. The purpose of this property, when
	                     communicated with a reference is for anyone to validate
	                     later whether the reference still resolved to the same
	                     data that the reference resolved to when the encapsulated
	                     data value with reference was created.
	                  .
	 */
	@XmlAttribute(name = "integrityCheck")
	public String integrityCheck;
	/**
	 * 
	                     Specifies the algorithm used to compute the
	                     integrityCheck value.
	                  .
	 */
	@XmlAttribute(name = "integrityCheckAlgorithm")
	public net.ihe.gazelle.hl7v3.voc.IntegrityCheckAlgorithm integrityCheckAlgorithm;
	/**
	 * 
	                     For character based information the language property
	                     specifies the human language of the text.
	                  .
	 */
	@XmlAttribute(name = "language")
	public String language;
	/**
	 * 
	                     Identifies the type of the encapsulated data and
	                     identifies a method to interpret or render the data.
	                  .
	 */
	@XmlAttribute(name = "mediaType")
	public String mediaType;
	
	/**
	 * An attribute containing marshalled element node
	 */
	@XmlTransient
	private org.w3c.dom.Node _xmlNodePresentation;
	
	
	/**
	 * Return reference.
	 * @return reference
	 */
	public net.ihe.gazelle.hl7v3.datatypes.TEL getReference() {

        return null;
	}
	
	
	
	/**
	 * Return thumbnail.
	 * @return thumbnail
	 */
	public net.ihe.gazelle.hl7v3.datatypes.Thumbnail getThumbnail() {

        return null;
	}
	
	
	
	/**
	 * Return compression.
	 * @return compression : 
	                     Indicates whether the raw byte data is compressed,
	                     and what compression algorithm was used.
	 */
	public net.ihe.gazelle.hl7v3.voc.CompressionAlgorithm getCompression() {
	    return compression;
	}
	
	/**
	 * Set a value to attribute compression.
	 * @param compression : 
	                     Indicates whether the raw byte data is compressed,
	                     and what compression algorithm was used.
	 */
	public void setCompression(net.ihe.gazelle.hl7v3.voc.CompressionAlgorithm compression) {
	    this.compression = compression;
	}
	
	
	
	
	/**
	 * Return integrityCheck.
	 * @return integrityCheck : 
	                     The integrity check is a short binary value representing
	                     a cryptographically strong checksum that is calculated
	                     over the binary data. The purpose of this property, when
	                     communicated with a reference is for anyone to validate
	                     later whether the reference still resolved to the same
	                     data that the reference resolved to when the encapsulated
	                     data value with reference was created.
	                  
	 */
	public String getIntegrityCheck() {
	    return integrityCheck;
	}
	
	/**
	 * Set a value to attribute integrityCheck.
	 * @param integrityCheck : 
	                     The integrity check is a short binary value representing
	                     a cryptographically strong checksum that is calculated
	                     over the binary data. The purpose of this property, when
	                     communicated with a reference is for anyone to validate
	                     later whether the reference still resolved to the same
	                     data that the reference resolved to when the encapsulated
	                     data value with reference was created.
	                  
		 */
	public void setIntegrityCheck(String integrityCheck) {
	    this.integrityCheck = integrityCheck;
	}
	
	
	
	
	/**
	 * Return integrityCheckAlgorithm.
	 * @return integrityCheckAlgorithm : 
	                     Specifies the algorithm used to compute the
	                     integrityCheck value.
	 */
	public net.ihe.gazelle.hl7v3.voc.IntegrityCheckAlgorithm getIntegrityCheckAlgorithm() {
	    return integrityCheckAlgorithm;
	}
	
	/**
	 * Set a value to attribute integrityCheckAlgorithm.
	 * @param integrityCheckAlgorithm : 
	                     Specifies the algorithm used to compute the
	                     integrityCheck value.
	 */
	public void setIntegrityCheckAlgorithm(net.ihe.gazelle.hl7v3.voc.IntegrityCheckAlgorithm integrityCheckAlgorithm) {
	    this.integrityCheckAlgorithm = integrityCheckAlgorithm;
	}
	
	
	
	
	/**
	 * Return language.
	 * @return language : 
	                     For character based information the language property
	                     specifies the human language of the text.
	 */
	public String getLanguage() {
	    return language;
	}
	
	/**
	 * Set a value to attribute language.
	 * @param language : 
	                     For character based information the language property
	                     specifies the human language of the text.
	 */
	public void setLanguage(String language) {
	    this.language = language;
	}

	
	/**
	 * Return mediaType.
	 * @return mediaType : 
	                     Identifies the type of the encapsulated data and
	                     identifies a method to interpret or render the data.
	 */
	public String getMediaType() {
	    return mediaType;
	}
	
	/**
	 * Set a value to attribute mediaType.
	 * @param mediaType : 
	                     Identifies the type of the encapsulated data and
	                     identifies a method to interpret or render the data.
	 */
	public void setMediaType(String mediaType) {
	    this.mediaType = mediaType;
	}

	
	
	public Node get_xmlNodePresentation() {
		if (_xmlNodePresentation == null){
				JAXBContext jc;
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				dbf.setNamespaceAware(true);
				DocumentBuilder db = null;
				Document doc = null;
				try {
					db = dbf.newDocumentBuilder();
					doc = db.newDocument();
				} catch (ParserConfigurationException ignored) {}
				try {
					jc = JAXBContext.newInstance("net.ihe.gazelle.hl7v3.datatypes");
					Marshaller m = jc.createMarshaller();
					m.marshal(this, doc);
					_xmlNodePresentation = doc.getElementsByTagNameNS("urn:hl7-org:v3", "ED").item(0);
				} catch (JAXBException e) {
					try{
						db = dbf.newDocumentBuilder();
						_xmlNodePresentation = db.newDocument();
					}
					catch(Exception ignored){}
				}
			}
			return _xmlNodePresentation;
	}
	
	public void set_xmlNodePresentation(Node _xmlNodePresentation) {
		this._xmlNodePresentation = _xmlNodePresentation;
	}
	
	
	

	
	/**
     * validate by a module of validation
     * 
     */
   public static void validateByModule(ED eD, String _location, ConstraintValidatorModule cvm, List<net.ihe.gazelle.validation.Notification> diagnostic){
   		if (eD != null){
   			net.ihe.gazelle.hl7v3.datatypes.BIN.validateByModule(eD, _location, cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.TEL.validateByModule(eD.getReference(), _location + "/reference", cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.Thumbnail.validateByModule(eD.getThumbnail(), _location + "/thumbnail", cvm, diagnostic);
    	}
    }

}