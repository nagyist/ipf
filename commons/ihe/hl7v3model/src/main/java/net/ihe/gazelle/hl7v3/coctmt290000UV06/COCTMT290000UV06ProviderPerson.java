/**
 * COCTMT290000UV06ProviderPerson.java
 *
 * File generated from the coctmt290000UV06::COCTMT290000UV06ProviderPerson uml Class
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.coctmt290000UV06;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
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
 * Description of the class COCTMT290000UV06ProviderPerson.
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COCT_MT290000UV06.ProviderPerson", propOrder = {
	"realmCode",
	"typeId",
	"templateId",
	"name",
	"telecom",
	"administrativeGenderCode",
	"birthTime",
	"addr",
	"classCode",
	"determinerCode",
	"nullFlavor"
})
@XmlRootElement(name = "COCT_MT290000UV06.ProviderPerson")
public class COCTMT290000UV06ProviderPerson implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@XmlElement(name = "realmCode", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.datatypes.CS> realmCode;
	@XmlElement(name = "typeId", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.II typeId;
	@XmlElement(name = "templateId", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.datatypes.II> templateId;
	@XmlElement(name = "name", required = true, namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.PN name;
	@XmlElement(name = "telecom", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.TEL telecom;
	@XmlElement(name = "administrativeGenderCode", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.CE administrativeGenderCode;
	@XmlElement(name = "birthTime", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.TS birthTime;
	@XmlElement(name = "addr", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.AD addr;
	@XmlAttribute(name = "classCode", required = true)
	public net.ihe.gazelle.hl7v3.voc.EntityClass classCode;
	@XmlAttribute(name = "determinerCode", required = true)
	public net.ihe.gazelle.hl7v3.voc.EntityDeterminer determinerCode;
	@XmlAttribute(name = "nullFlavor")
	public net.ihe.gazelle.hl7v3.voc.NullFlavor nullFlavor;
	
	/**
	 * An attribute containing marshalled element node
	 */
	@XmlTransient
	private org.w3c.dom.Node _xmlNodePresentation;
	
	
	/**
	 * Return realmCode.
	 * @return realmCode
	 */
	public List<net.ihe.gazelle.hl7v3.datatypes.CS> getRealmCode() {
		if (realmCode == null) {
	        realmCode = new ArrayList<net.ihe.gazelle.hl7v3.datatypes.CS>();
	    }
	    return realmCode;
	}
	
	/**
	 * Set a value to attribute realmCode.
	 * @param realmCode.
	 */
	public void setRealmCode(List<net.ihe.gazelle.hl7v3.datatypes.CS> realmCode) {
	    this.realmCode = realmCode;
	}
	
	
	
	/**
	 * Add a realmCode to the realmCode collection.
	 * @param realmCode_elt Element to add.
	 */
	public void addRealmCode(net.ihe.gazelle.hl7v3.datatypes.CS realmCode_elt) {
	    this.realmCode.add(realmCode_elt);
	}
	
	/**
	 * Remove a realmCode to the realmCode collection.
	 * @param realmCode_elt Element to remove
	 */
	public void removeRealmCode(net.ihe.gazelle.hl7v3.datatypes.CS realmCode_elt) {
	    this.realmCode.remove(realmCode_elt);
	}
	
	/**
	 * Return typeId.
	 * @return typeId
	 */
	public net.ihe.gazelle.hl7v3.datatypes.II getTypeId() {
	    return typeId;
	}
	
	/**
	 * Set a value to attribute typeId.
	 * @param typeId.
	 */
	public void setTypeId(net.ihe.gazelle.hl7v3.datatypes.II typeId) {
	    this.typeId = typeId;
	}
	
	
	
	
	/**
	 * Return templateId.
	 * @return templateId
	 */
	public List<net.ihe.gazelle.hl7v3.datatypes.II> getTemplateId() {
		if (templateId == null) {
	        templateId = new ArrayList<net.ihe.gazelle.hl7v3.datatypes.II>();
	    }
	    return templateId;
	}
	
	/**
	 * Set a value to attribute templateId.
	 * @param templateId.
	 */
	public void setTemplateId(List<net.ihe.gazelle.hl7v3.datatypes.II> templateId) {
	    this.templateId = templateId;
	}
	
	
	
	/**
	 * Add a templateId to the templateId collection.
	 * @param templateId_elt Element to add.
	 */
	public void addTemplateId(net.ihe.gazelle.hl7v3.datatypes.II templateId_elt) {
	    this.templateId.add(templateId_elt);
	}
	
	/**
	 * Remove a templateId to the templateId collection.
	 * @param templateId_elt Element to remove
	 */
	public void removeTemplateId(net.ihe.gazelle.hl7v3.datatypes.II templateId_elt) {
	    this.templateId.remove(templateId_elt);
	}
	
	/**
	 * Return name.
	 * @return name
	 */
	public net.ihe.gazelle.hl7v3.datatypes.PN getName() {
	    return name;
	}
	
	/**
	 * Set a value to attribute name.
	 * @param name.
	 */
	public void setName(net.ihe.gazelle.hl7v3.datatypes.PN name) {
	    this.name = name;
	}
	
	
	
	
	/**
	 * Return telecom.
	 * @return telecom
	 */
	public net.ihe.gazelle.hl7v3.datatypes.TEL getTelecom() {
	    return telecom;
	}
	
	/**
	 * Set a value to attribute telecom.
	 * @param telecom.
	 */
	public void setTelecom(net.ihe.gazelle.hl7v3.datatypes.TEL telecom) {
	    this.telecom = telecom;
	}
	
	
	
	
	/**
	 * Return administrativeGenderCode.
	 * @return administrativeGenderCode
	 */
	public net.ihe.gazelle.hl7v3.datatypes.CE getAdministrativeGenderCode() {
	    return administrativeGenderCode;
	}
	
	/**
	 * Set a value to attribute administrativeGenderCode.
	 * @param administrativeGenderCode.
	 */
	public void setAdministrativeGenderCode(net.ihe.gazelle.hl7v3.datatypes.CE administrativeGenderCode) {
	    this.administrativeGenderCode = administrativeGenderCode;
	}
	
	
	
	
	/**
	 * Return birthTime.
	 * @return birthTime
	 */
	public net.ihe.gazelle.hl7v3.datatypes.TS getBirthTime() {
	    return birthTime;
	}
	
	/**
	 * Set a value to attribute birthTime.
	 * @param birthTime.
	 */
	public void setBirthTime(net.ihe.gazelle.hl7v3.datatypes.TS birthTime) {
	    this.birthTime = birthTime;
	}
	
	
	
	
	/**
	 * Return addr.
	 * @return addr
	 */
	public net.ihe.gazelle.hl7v3.datatypes.AD getAddr() {
	    return addr;
	}
	
	/**
	 * Set a value to attribute addr.
	 * @param addr.
	 */
	public void setAddr(net.ihe.gazelle.hl7v3.datatypes.AD addr) {
	    this.addr = addr;
	}
	
	
	
	
	/**
	 * Return classCode.
	 * @return classCode
	 */
	public net.ihe.gazelle.hl7v3.voc.EntityClass getClassCode() {
	    return classCode;
	}
	
	/**
	 * Set a value to attribute classCode.
	 * @param classCode.
	 */
	public void setClassCode(net.ihe.gazelle.hl7v3.voc.EntityClass classCode) {
	    this.classCode = classCode;
	}
	
	
	
	
	/**
	 * Return determinerCode.
	 * @return determinerCode
	 */
	public net.ihe.gazelle.hl7v3.voc.EntityDeterminer getDeterminerCode() {
	    return determinerCode;
	}
	
	/**
	 * Set a value to attribute determinerCode.
	 * @param determinerCode.
	 */
	public void setDeterminerCode(net.ihe.gazelle.hl7v3.voc.EntityDeterminer determinerCode) {
	    this.determinerCode = determinerCode;
	}
	
	
	
	
	/**
	 * Return nullFlavor.
	 * @return nullFlavor
	 */
	public net.ihe.gazelle.hl7v3.voc.NullFlavor getNullFlavor() {
	    return nullFlavor;
	}
	
	/**
	 * Set a value to attribute nullFlavor.
	 * @param nullFlavor.
	 */
	public void setNullFlavor(net.ihe.gazelle.hl7v3.voc.NullFlavor nullFlavor) {
	    this.nullFlavor = nullFlavor;
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
					jc = JAXBContext.newInstance("net.ihe.gazelle.hl7v3.coctmt290000UV06");
					Marshaller m = jc.createMarshaller();
					m.marshal(this, doc);
					_xmlNodePresentation = doc.getElementsByTagNameNS("urn:hl7-org:v3", "COCT_MT290000UV06.ProviderPerson").item(0);
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
   public static void validateByModule(COCTMT290000UV06ProviderPerson cOCTMT290000UV06ProviderPerson, String _location, ConstraintValidatorModule cvm, List<net.ihe.gazelle.validation.Notification> diagnostic){
   		if (cOCTMT290000UV06ProviderPerson != null){
   			cvm.validate(cOCTMT290000UV06ProviderPerson, _location, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.CS realmCode: cOCTMT290000UV06ProviderPerson.getRealmCode()){
					net.ihe.gazelle.hl7v3.datatypes.CS.validateByModule(realmCode, _location + "/realmCode[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(cOCTMT290000UV06ProviderPerson.getTypeId(), _location + "/typeId", cvm, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.II templateId: cOCTMT290000UV06ProviderPerson.getTemplateId()){
					net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(templateId, _location + "/templateId[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.datatypes.PN.validateByModule(cOCTMT290000UV06ProviderPerson.getName(), _location + "/name", cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.TEL.validateByModule(cOCTMT290000UV06ProviderPerson.getTelecom(), _location + "/telecom", cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.CE.validateByModule(cOCTMT290000UV06ProviderPerson.getAdministrativeGenderCode(), _location + "/administrativeGenderCode", cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.TS.validateByModule(cOCTMT290000UV06ProviderPerson.getBirthTime(), _location + "/birthTime", cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.AD.validateByModule(cOCTMT290000UV06ProviderPerson.getAddr(), _location + "/addr", cvm, diagnostic);
    	}
    }

}