/**
 * AdxpDeliveryMode.java
 *
 * File generated from the datatypes::AdxpDeliveryMode uml Class
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.datatypes;

// End of user code
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
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
 * Description of the class AdxpDeliveryMode.
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "adxp.deliveryMode")
@XmlRootElement(name = "adxp.deliveryMode")
public class AdxpDeliveryMode extends net.ihe.gazelle.hl7v3.datatypes.ADXP implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	/**
	 * An attribute containing marshalled element node
	 */
	@XmlTransient
	private org.w3c.dom.Node _xmlNodePresentation;
	
	
	
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
				} catch (ParserConfigurationException e1) {}
				try {
					jc = JAXBContext.newInstance("net.ihe.gazelle.hl7v3.datatypes");
					Marshaller m = jc.createMarshaller();
					m.marshal(this, doc);
					_xmlNodePresentation = doc.getElementsByTagNameNS("urn:hl7-org:v3", "adxp.deliveryMode").item(0);
				} catch (JAXBException e) {
					try{
						db = dbf.newDocumentBuilder();
						_xmlNodePresentation = db.newDocument();
					}
					catch(Exception ee){}
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
   public static void validateByModule(AdxpDeliveryMode adxpDeliveryMode, String _location, ConstraintValidatorModule cvm, List<net.ihe.gazelle.validation.Notification> diagnostic){
   		if (adxpDeliveryMode != null){
   			net.ihe.gazelle.hl7v3.datatypes.ADXP.validateByModule(adxpDeliveryMode, _location, cvm, diagnostic);
    	}
    }

}