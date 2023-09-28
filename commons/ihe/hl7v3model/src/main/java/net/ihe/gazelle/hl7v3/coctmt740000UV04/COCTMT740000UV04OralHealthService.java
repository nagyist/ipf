/**
 * COCTMT740000UV04OralHealthService.java
 *
 * File generated from the coctmt740000UV04::COCTMT740000UV04OralHealthService uml Class
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.coctmt740000UV04;

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
 * Description of the class COCTMT740000UV04OralHealthService.
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COCT_MT740000UV04.OralHealthService", propOrder = {
	"realmCode",
	"typeId",
	"templateId",
	"id",
	"code",
	"effectiveTime",
	"reasonCode",
	"targetSiteCode",
	"responsibleParty",
	"performer",
	"location",
	"pertinentInformation1",
	"pertinentInformation2",
	"referencedBy",
	"classCode",
	"moodCode",
	"nullFlavor"
})
@XmlRootElement(name = "COCT_MT740000UV04.OralHealthService")
public class COCTMT740000UV04OralHealthService implements java.io.Serializable {
	
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
	@XmlElement(name = "id", required = true, namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.II id;
	@XmlElement(name = "code", required = true, namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.CS code;
	@XmlElement(name = "effectiveTime", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.IVLTS effectiveTime;
	@XmlElement(name = "reasonCode", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.datatypes.CS> reasonCode;
	@XmlElement(name = "targetSiteCode", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.datatypes.CE> targetSiteCode;
	@XmlElement(name = "responsibleParty", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04ResponsibleParty responsibleParty;
	@XmlElement(name = "performer", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04Performer performer;
	@XmlElement(name = "location", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04Location> location;
	@XmlElement(name = "pertinentInformation1", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04PertinentInformation1> pertinentInformation1;
	@XmlElement(name = "pertinentInformation2", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04PertinentInformation2> pertinentInformation2;
	@XmlElement(name = "referencedBy", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04Reference referencedBy;
	@XmlAttribute(name = "classCode", required = true)
	public net.ihe.gazelle.hl7v3.voc.ActClassProcedure classCode;
	@XmlAttribute(name = "moodCode", required = true)
	public net.ihe.gazelle.hl7v3.voc.XActMoodIntentEvent moodCode;
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
	public net.ihe.gazelle.hl7v3.datatypes.II getId() {
	    return id;
	}
	
	/**
	 * Set a value to attribute id.
	 * @param id.
	 */
	public void setId(net.ihe.gazelle.hl7v3.datatypes.II id) {
	    this.id = id;
	}
	
	
	
	
	/**
	 * Return code.
	 * @return code
	 */
	public net.ihe.gazelle.hl7v3.datatypes.CS getCode() {
	    return code;
	}
	
	/**
	 * Set a value to attribute code.
	 * @param code.
	 */
	public void setCode(net.ihe.gazelle.hl7v3.datatypes.CS code) {
	    this.code = code;
	}
	
	
	
	
	/**
	 * Return effectiveTime.
	 * @return effectiveTime
	 */
	public net.ihe.gazelle.hl7v3.datatypes.IVLTS getEffectiveTime() {
	    return effectiveTime;
	}
	
	/**
	 * Set a value to attribute effectiveTime.
	 * @param effectiveTime.
	 */
	public void setEffectiveTime(net.ihe.gazelle.hl7v3.datatypes.IVLTS effectiveTime) {
	    this.effectiveTime = effectiveTime;
	}
	
	
	
	
	/**
	 * Return reasonCode.
	 * @return reasonCode
	 */
	public List<net.ihe.gazelle.hl7v3.datatypes.CS> getReasonCode() {
		if (reasonCode == null) {
	        reasonCode = new ArrayList<net.ihe.gazelle.hl7v3.datatypes.CS>();
	    }
	    return reasonCode;
	}
	
	/**
	 * Set a value to attribute reasonCode.
	 * @param reasonCode.
	 */
	public void setReasonCode(List<net.ihe.gazelle.hl7v3.datatypes.CS> reasonCode) {
	    this.reasonCode = reasonCode;
	}
	
	
	
	/**
	 * Add a reasonCode to the reasonCode collection.
	 * @param reasonCode_elt Element to add.
	 */
	public void addReasonCode(net.ihe.gazelle.hl7v3.datatypes.CS reasonCode_elt) {
	    this.reasonCode.add(reasonCode_elt);
	}
	
	/**
	 * Remove a reasonCode to the reasonCode collection.
	 * @param reasonCode_elt Element to remove
	 */
	public void removeReasonCode(net.ihe.gazelle.hl7v3.datatypes.CS reasonCode_elt) {
	    this.reasonCode.remove(reasonCode_elt);
	}
	
	/**
	 * Return targetSiteCode.
	 * @return targetSiteCode
	 */
	public List<net.ihe.gazelle.hl7v3.datatypes.CE> getTargetSiteCode() {
		if (targetSiteCode == null) {
	        targetSiteCode = new ArrayList<net.ihe.gazelle.hl7v3.datatypes.CE>();
	    }
	    return targetSiteCode;
	}
	
	/**
	 * Set a value to attribute targetSiteCode.
	 * @param targetSiteCode.
	 */
	public void setTargetSiteCode(List<net.ihe.gazelle.hl7v3.datatypes.CE> targetSiteCode) {
	    this.targetSiteCode = targetSiteCode;
	}
	
	
	
	/**
	 * Add a targetSiteCode to the targetSiteCode collection.
	 * @param targetSiteCode_elt Element to add.
	 */
	public void addTargetSiteCode(net.ihe.gazelle.hl7v3.datatypes.CE targetSiteCode_elt) {
	    this.targetSiteCode.add(targetSiteCode_elt);
	}
	
	/**
	 * Remove a targetSiteCode to the targetSiteCode collection.
	 * @param targetSiteCode_elt Element to remove
	 */
	public void removeTargetSiteCode(net.ihe.gazelle.hl7v3.datatypes.CE targetSiteCode_elt) {
	    this.targetSiteCode.remove(targetSiteCode_elt);
	}
	
	/**
	 * Return responsibleParty.
	 * @return responsibleParty
	 */
	public net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04ResponsibleParty getResponsibleParty() {
	    return responsibleParty;
	}
	
	/**
	 * Set a value to attribute responsibleParty.
	 * @param responsibleParty.
	 */
	public void setResponsibleParty(net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04ResponsibleParty responsibleParty) {
	    this.responsibleParty = responsibleParty;
	}
	
	
	
	
	/**
	 * Return performer.
	 * @return performer
	 */
	public net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04Performer getPerformer() {
	    return performer;
	}
	
	/**
	 * Set a value to attribute performer.
	 * @param performer.
	 */
	public void setPerformer(net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04Performer performer) {
	    this.performer = performer;
	}
	
	
	
	
	/**
	 * Return location.
	 * @return location
	 */
	public List<net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04Location> getLocation() {
		if (location == null) {
	        location = new ArrayList<net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04Location>();
	    }
	    return location;
	}
	
	/**
	 * Set a value to attribute location.
	 * @param location.
	 */
	public void setLocation(List<net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04Location> location) {
	    this.location = location;
	}
	
	
	
	/**
	 * Add a location to the location collection.
	 * @param location_elt Element to add.
	 */
	public void addLocation(net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04Location location_elt) {
	    this.location.add(location_elt);
	}
	
	/**
	 * Remove a location to the location collection.
	 * @param location_elt Element to remove
	 */
	public void removeLocation(net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04Location location_elt) {
	    this.location.remove(location_elt);
	}
	
	/**
	 * Return pertinentInformation1.
	 * @return pertinentInformation1
	 */
	public List<net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04PertinentInformation1> getPertinentInformation1() {
		if (pertinentInformation1 == null) {
	        pertinentInformation1 = new ArrayList<net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04PertinentInformation1>();
	    }
	    return pertinentInformation1;
	}
	
	/**
	 * Set a value to attribute pertinentInformation1.
	 * @param pertinentInformation1.
	 */
	public void setPertinentInformation1(List<net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04PertinentInformation1> pertinentInformation1) {
	    this.pertinentInformation1 = pertinentInformation1;
	}
	
	
	
	/**
	 * Add a pertinentInformation1 to the pertinentInformation1 collection.
	 * @param pertinentInformation1_elt Element to add.
	 */
	public void addPertinentInformation1(net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04PertinentInformation1 pertinentInformation1_elt) {
	    this.pertinentInformation1.add(pertinentInformation1_elt);
	}
	
	/**
	 * Remove a pertinentInformation1 to the pertinentInformation1 collection.
	 * @param pertinentInformation1_elt Element to remove
	 */
	public void removePertinentInformation1(net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04PertinentInformation1 pertinentInformation1_elt) {
	    this.pertinentInformation1.remove(pertinentInformation1_elt);
	}
	
	/**
	 * Return pertinentInformation2.
	 * @return pertinentInformation2
	 */
	public List<net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04PertinentInformation2> getPertinentInformation2() {
		if (pertinentInformation2 == null) {
	        pertinentInformation2 = new ArrayList<net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04PertinentInformation2>();
	    }
	    return pertinentInformation2;
	}
	
	/**
	 * Set a value to attribute pertinentInformation2.
	 * @param pertinentInformation2.
	 */
	public void setPertinentInformation2(List<net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04PertinentInformation2> pertinentInformation2) {
	    this.pertinentInformation2 = pertinentInformation2;
	}
	
	
	
	/**
	 * Add a pertinentInformation2 to the pertinentInformation2 collection.
	 * @param pertinentInformation2_elt Element to add.
	 */
	public void addPertinentInformation2(net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04PertinentInformation2 pertinentInformation2_elt) {
	    this.pertinentInformation2.add(pertinentInformation2_elt);
	}
	
	/**
	 * Remove a pertinentInformation2 to the pertinentInformation2 collection.
	 * @param pertinentInformation2_elt Element to remove
	 */
	public void removePertinentInformation2(net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04PertinentInformation2 pertinentInformation2_elt) {
	    this.pertinentInformation2.remove(pertinentInformation2_elt);
	}
	
	/**
	 * Return referencedBy.
	 * @return referencedBy
	 */
	public net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04Reference getReferencedBy() {
	    return referencedBy;
	}
	
	/**
	 * Set a value to attribute referencedBy.
	 * @param referencedBy.
	 */
	public void setReferencedBy(net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04Reference referencedBy) {
	    this.referencedBy = referencedBy;
	}
	
	
	
	
	/**
	 * Return classCode.
	 * @return classCode
	 */
	public net.ihe.gazelle.hl7v3.voc.ActClassProcedure getClassCode() {
	    return classCode;
	}
	
	/**
	 * Set a value to attribute classCode.
	 * @param classCode.
	 */
	public void setClassCode(net.ihe.gazelle.hl7v3.voc.ActClassProcedure classCode) {
	    this.classCode = classCode;
	}
	
	
	
	
	/**
	 * Return moodCode.
	 * @return moodCode
	 */
	public net.ihe.gazelle.hl7v3.voc.XActMoodIntentEvent getMoodCode() {
	    return moodCode;
	}
	
	/**
	 * Set a value to attribute moodCode.
	 * @param moodCode.
	 */
	public void setMoodCode(net.ihe.gazelle.hl7v3.voc.XActMoodIntentEvent moodCode) {
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
					jc = JAXBContext.newInstance("net.ihe.gazelle.hl7v3.coctmt740000UV04");
					Marshaller m = jc.createMarshaller();
					m.marshal(this, doc);
					_xmlNodePresentation = doc.getElementsByTagNameNS("urn:hl7-org:v3", "COCT_MT740000UV04.OralHealthService").item(0);
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
   public static void validateByModule(COCTMT740000UV04OralHealthService cOCTMT740000UV04OralHealthService, String _location, ConstraintValidatorModule cvm, List<net.ihe.gazelle.validation.Notification> diagnostic){
   		if (cOCTMT740000UV04OralHealthService != null){
   			cvm.validate(cOCTMT740000UV04OralHealthService, _location, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.CS realmCode: cOCTMT740000UV04OralHealthService.getRealmCode()){
					net.ihe.gazelle.hl7v3.datatypes.CS.validateByModule(realmCode, _location + "/realmCode[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(cOCTMT740000UV04OralHealthService.getTypeId(), _location + "/typeId", cvm, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.II templateId: cOCTMT740000UV04OralHealthService.getTemplateId()){
					net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(templateId, _location + "/templateId[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(cOCTMT740000UV04OralHealthService.getId(), _location + "/id", cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.CS.validateByModule(cOCTMT740000UV04OralHealthService.getCode(), _location + "/code", cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.IVLTS.validateByModule(cOCTMT740000UV04OralHealthService.getEffectiveTime(), _location + "/effectiveTime", cvm, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.CS reasonCode: cOCTMT740000UV04OralHealthService.getReasonCode()){
					net.ihe.gazelle.hl7v3.datatypes.CS.validateByModule(reasonCode, _location + "/reasonCode[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.CE targetSiteCode: cOCTMT740000UV04OralHealthService.getTargetSiteCode()){
					net.ihe.gazelle.hl7v3.datatypes.CE.validateByModule(targetSiteCode, _location + "/targetSiteCode[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04ResponsibleParty.validateByModule(cOCTMT740000UV04OralHealthService.getResponsibleParty(), _location + "/responsibleParty", cvm, diagnostic);
			net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04Performer.validateByModule(cOCTMT740000UV04OralHealthService.getPerformer(), _location + "/performer", cvm, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04Location location: cOCTMT740000UV04OralHealthService.getLocation()){
					net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04Location.validateByModule(location, _location + "/location[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04PertinentInformation1 pertinentInformation1: cOCTMT740000UV04OralHealthService.getPertinentInformation1()){
					net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04PertinentInformation1.validateByModule(pertinentInformation1, _location + "/pertinentInformation1[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04PertinentInformation2 pertinentInformation2: cOCTMT740000UV04OralHealthService.getPertinentInformation2()){
					net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04PertinentInformation2.validateByModule(pertinentInformation2, _location + "/pertinentInformation2[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.coctmt740000UV04.COCTMT740000UV04Reference.validateByModule(cOCTMT740000UV04OralHealthService.getReferencedBy(), _location + "/referencedBy", cvm, diagnostic);
    	}
    }

}