/**
 * HXITPQ.java
 * <p>
 * File generated from the datatypes::HXITPQ uml Class
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
import jakarta.xml.bind.annotation.XmlElement;
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
 * Description of the class HXITPQ.
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HXIT_PQ", propOrder = {
	"validTime"
})
@XmlRootElement(name = "HXIT_PQ")
public class HXITPQ extends net.ihe.gazelle.hl7v3.datatypes.PQ implements java.io.Serializable {
	
	/**
	 * 
	 */
	@Serial
    private static final long serialVersionUID = 1L;

	
	/**
	 * 
	                        The time interval during which the given information
	                        was, is, or is expected to be valid. The interval can
	                        be open or closed, as well as infinite or undefined on
	                        either side.
	                     .
	 */
	@XmlElement(name = "validTime", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.IVLTS validTime;
	
	/**
	 * An attribute containing marshalled element node
	 */
	@XmlTransient
	private org.w3c.dom.Node _xmlNodePresentation;
	
	
	/**
	 * Return validTime.
	 * @return validTime : 
	                        The time interval during which the given information
	                        was, is, or is expected to be valid. The interval can
	                        be open or closed, as well as infinite or undefined on
	                        either side.
	 */
	public net.ihe.gazelle.hl7v3.datatypes.IVLTS getValidTime() {
	    return validTime;
	}
	
	/**
	 * Set a value to attribute validTime.
	 * @param validTime : 
	                        The time interval during which the given information
	                        was, is, or is expected to be valid. The interval can
	                        be open or closed, as well as infinite or undefined on
	                        either side.
	 */
	public void setValidTime(net.ihe.gazelle.hl7v3.datatypes.IVLTS validTime) {
	    this.validTime = validTime;
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
					_xmlNodePresentation = doc.getElementsByTagNameNS("urn:hl7-org:v3", "HXIT_PQ").item(0);
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
   public static void validateByModule(HXITPQ hXITPQ, String _location, ConstraintValidatorModule cvm, List<net.ihe.gazelle.validation.Notification> diagnostic){
   		if (hXITPQ != null){
   			net.ihe.gazelle.hl7v3.datatypes.PQ.validateByModule(hXITPQ, _location, cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.IVLTS.validateByModule(hXITPQ.getValidTime(), _location + "/validTime", cvm, diagnostic);
    	}
    }

}