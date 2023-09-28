/**
 * PRPAMT201302UV02GuardianId.java
 *
 * File generated from the prpamt201302UV02::PRPAMT201302UV02GuardianId uml Class
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.prpamt201302UV02;

// End of user code
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
 * Description of the class PRPAMT201302UV02GuardianId.
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT201302UV02.Guardian.id", propOrder = {
	"updateMode"
})
@XmlRootElement(name = "PRPA_MT201302UV02.Guardian.id")
public class PRPAMT201302UV02GuardianId extends net.ihe.gazelle.hl7v3.datatypes.II implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@XmlAttribute(name = "updateMode")
	public net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02GuardianIdUpdateMode updateMode;
	
	/**
	 * An attribute containing marshalled element node
	 */
	@XmlTransient
	private org.w3c.dom.Node _xmlNodePresentation;
	
	
	/**
	 * Return updateMode.
	 * @return updateMode
	 */
	public net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02GuardianIdUpdateMode getUpdateMode() {
	    return updateMode;
	}
	
	/**
	 * Set a value to attribute updateMode.
	 * @param updateMode.
	 */
	public void setUpdateMode(net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02GuardianIdUpdateMode updateMode) {
	    this.updateMode = updateMode;
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
				} catch (ParserConfigurationException e1) {}
				try {
					jc = JAXBContext.newInstance("net.ihe.gazelle.hl7v3.prpamt201302UV02");
					Marshaller m = jc.createMarshaller();
					m.marshal(this, doc);
					_xmlNodePresentation = doc.getElementsByTagNameNS("urn:hl7-org:v3", "PRPA_MT201302UV02.Guardian.id").item(0);
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
   public static void validateByModule(PRPAMT201302UV02GuardianId pRPAMT201302UV02GuardianId, String _location, ConstraintValidatorModule cvm, List<net.ihe.gazelle.validation.Notification> diagnostic){
   		if (pRPAMT201302UV02GuardianId != null){
   			net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(pRPAMT201302UV02GuardianId, _location, cvm, diagnostic);
    	}
    }

}