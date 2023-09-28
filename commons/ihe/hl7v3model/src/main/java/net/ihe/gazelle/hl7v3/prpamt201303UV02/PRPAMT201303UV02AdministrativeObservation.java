/**
 * PRPAMT201303UV02AdministrativeObservation.java
 *
 * File generated from the prpamt201303UV02::PRPAMT201303UV02AdministrativeObservation uml Class
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.prpamt201303UV02;

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
 * Description of the class PRPAMT201303UV02AdministrativeObservation.
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT201303UV02.AdministrativeObservation", propOrder = {
	"realmCode",
	"typeId",
	"templateId",
	"id",
	"code",
	"statusCode",
	"effectiveTime",
	"value",
	"classCode",
	"moodCode",
	"nullFlavor"
})
@XmlRootElement(name = "PRPA_MT201303UV02.AdministrativeObservation")
public class PRPAMT201303UV02AdministrativeObservation implements java.io.Serializable {
	
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
	@XmlElement(name = "id", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.datatypes.II> id;
	@XmlElement(name = "code", required = true, namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.CD code;
	@XmlElement(name = "statusCode", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.CS statusCode;
	@XmlElement(name = "effectiveTime", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.datatypes.SXCMTS> effectiveTime;
	@XmlElement(name = "value", required = true, namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.ANY value;
	@XmlAttribute(name = "classCode", required = true)
	public net.ihe.gazelle.hl7v3.voc.ActClassObservation classCode;
	@XmlAttribute(name = "moodCode")
	public net.ihe.gazelle.hl7v3.voc.ActMood moodCode;
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
	 * Return id.
	 * @return id
	 */
	public List<net.ihe.gazelle.hl7v3.datatypes.II> getId() {
		if (id == null) {
	        id = new ArrayList<net.ihe.gazelle.hl7v3.datatypes.II>();
	    }
	    return id;
	}
	
	/**
	 * Set a value to attribute id.
	 * @param id.
	 */
	public void setId(List<net.ihe.gazelle.hl7v3.datatypes.II> id) {
	    this.id = id;
	}
	
	
	
	/**
	 * Add a id to the id collection.
	 * @param id_elt Element to add.
	 */
	public void addId(net.ihe.gazelle.hl7v3.datatypes.II id_elt) {
	    this.id.add(id_elt);
	}
	
	/**
	 * Remove a id to the id collection.
	 * @param id_elt Element to remove
	 */
	public void removeId(net.ihe.gazelle.hl7v3.datatypes.II id_elt) {
	    this.id.remove(id_elt);
	}
	
	/**
	 * Return code.
	 * @return code
	 */
	public net.ihe.gazelle.hl7v3.datatypes.CD getCode() {
	    return code;
	}
	
	/**
	 * Set a value to attribute code.
	 * @param code.
	 */
	public void setCode(net.ihe.gazelle.hl7v3.datatypes.CD code) {
	    this.code = code;
	}
	
	
	
	
	/**
	 * Return statusCode.
	 * @return statusCode
	 */
	public net.ihe.gazelle.hl7v3.datatypes.CS getStatusCode() {
	    return statusCode;
	}
	
	/**
	 * Set a value to attribute statusCode.
	 * @param statusCode.
	 */
	public void setStatusCode(net.ihe.gazelle.hl7v3.datatypes.CS statusCode) {
	    this.statusCode = statusCode;
	}
	
	
	
	
	/**
	 * Return effectiveTime.
	 * @return effectiveTime
	 */
	public List<net.ihe.gazelle.hl7v3.datatypes.SXCMTS> getEffectiveTime() {
		if (effectiveTime == null) {
	        effectiveTime = new ArrayList<net.ihe.gazelle.hl7v3.datatypes.SXCMTS>();
	    }
	    return effectiveTime;
	}
	
	/**
	 * Set a value to attribute effectiveTime.
	 * @param effectiveTime.
	 */
	public void setEffectiveTime(List<net.ihe.gazelle.hl7v3.datatypes.SXCMTS> effectiveTime) {
	    this.effectiveTime = effectiveTime;
	}
	
	
	
	/**
	 * Add a effectiveTime to the effectiveTime collection.
	 * @param effectiveTime_elt Element to add.
	 */
	public void addEffectiveTime(net.ihe.gazelle.hl7v3.datatypes.SXCMTS effectiveTime_elt) {
	    this.effectiveTime.add(effectiveTime_elt);
	}
	
	/**
	 * Remove a effectiveTime to the effectiveTime collection.
	 * @param effectiveTime_elt Element to remove
	 */
	public void removeEffectiveTime(net.ihe.gazelle.hl7v3.datatypes.SXCMTS effectiveTime_elt) {
	    this.effectiveTime.remove(effectiveTime_elt);
	}
	
	/**
	 * Return value.
	 * @return value
	 */
	public net.ihe.gazelle.hl7v3.datatypes.ANY getValue() {
	    return value;
	}
	
	/**
	 * Set a value to attribute value.
	 * @param value.
	 */
	public void setValue(net.ihe.gazelle.hl7v3.datatypes.ANY value) {
	    this.value = value;
	}
	
	
	
	
	/**
	 * Return classCode.
	 * @return classCode
	 */
	public net.ihe.gazelle.hl7v3.voc.ActClassObservation getClassCode() {
	    return classCode;
	}
	
	/**
	 * Set a value to attribute classCode.
	 * @param classCode.
	 */
	public void setClassCode(net.ihe.gazelle.hl7v3.voc.ActClassObservation classCode) {
	    this.classCode = classCode;
	}
	
	
	
	
	/**
	 * Return moodCode.
	 * @return moodCode
	 */
	public net.ihe.gazelle.hl7v3.voc.ActMood getMoodCode() {
	    return moodCode;
	}
	
	/**
	 * Set a value to attribute moodCode.
	 * @param moodCode.
	 */
	public void setMoodCode(net.ihe.gazelle.hl7v3.voc.ActMood moodCode) {
	    this.moodCode = moodCode;
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
					jc = JAXBContext.newInstance("net.ihe.gazelle.hl7v3.prpamt201303UV02");
					Marshaller m = jc.createMarshaller();
					m.marshal(this, doc);
					_xmlNodePresentation = doc.getElementsByTagNameNS("urn:hl7-org:v3", "PRPA_MT201303UV02.AdministrativeObservation").item(0);
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
   public static void validateByModule(PRPAMT201303UV02AdministrativeObservation pRPAMT201303UV02AdministrativeObservation, String _location, ConstraintValidatorModule cvm, List<net.ihe.gazelle.validation.Notification> diagnostic){
   		if (pRPAMT201303UV02AdministrativeObservation != null){
   			cvm.validate(pRPAMT201303UV02AdministrativeObservation, _location, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.CS realmCode: pRPAMT201303UV02AdministrativeObservation.getRealmCode()){
					net.ihe.gazelle.hl7v3.datatypes.CS.validateByModule(realmCode, _location + "/realmCode[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(pRPAMT201303UV02AdministrativeObservation.getTypeId(), _location + "/typeId", cvm, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.II templateId: pRPAMT201303UV02AdministrativeObservation.getTemplateId()){
					net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(templateId, _location + "/templateId[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.II id: pRPAMT201303UV02AdministrativeObservation.getId()){
					net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(id, _location + "/id[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.datatypes.CD.validateByModule(pRPAMT201303UV02AdministrativeObservation.getCode(), _location + "/code", cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.CS.validateByModule(pRPAMT201303UV02AdministrativeObservation.getStatusCode(), _location + "/statusCode", cvm, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.SXCMTS effectiveTime: pRPAMT201303UV02AdministrativeObservation.getEffectiveTime()){
					net.ihe.gazelle.hl7v3.datatypes.SXCMTS.validateByModule(effectiveTime, _location + "/effectiveTime[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.datatypes.ANY.validateByModule(pRPAMT201303UV02AdministrativeObservation.getValue(), _location + "/value", cvm, diagnostic);
    	}
    }

}