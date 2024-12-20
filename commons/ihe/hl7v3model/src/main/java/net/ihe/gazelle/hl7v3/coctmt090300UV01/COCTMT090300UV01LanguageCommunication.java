/**
 * COCTMT090300UV01LanguageCommunication.java
 * <p>
 * File generated from the coctmt090300UV01::COCTMT090300UV01LanguageCommunication uml Class
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.coctmt090300UV01;

import java.io.Serial;
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
 * Description of the class COCTMT090300UV01LanguageCommunication.
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COCT_MT090300UV01.LanguageCommunication", propOrder = {
	"realmCode",
	"typeId",
	"templateId",
	"languageCode",
	"modeCode",
	"proficiencyLevelCode",
	"preferenceInd",
	"nullFlavor"
})
@XmlRootElement(name = "COCT_MT090300UV01.LanguageCommunication")
public class COCTMT090300UV01LanguageCommunication implements java.io.Serializable {
	
	/**
	 * 
	 */
	@Serial
    private static final long serialVersionUID = 1L;

	
	@XmlElement(name = "realmCode", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.datatypes.CS> realmCode;
	@XmlElement(name = "typeId", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.II typeId;
	@XmlElement(name = "templateId", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.datatypes.II> templateId;
	@XmlElement(name = "languageCode", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.CE languageCode;
	@XmlElement(name = "modeCode", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.CE modeCode;
	@XmlElement(name = "proficiencyLevelCode", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.CE proficiencyLevelCode;
	@XmlElement(name = "preferenceInd", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.BL preferenceInd;
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
	        realmCode = new ArrayList<>();
	    }
	    return realmCode;
	}
	
	/**
	 * Set a value to attribute realmCode.
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
	        templateId = new ArrayList<>();
	    }
	    return templateId;
	}
	
	/**
	 * Set a value to attribute templateId.
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
	 * Return languageCode.
	 * @return languageCode
	 */
	public net.ihe.gazelle.hl7v3.datatypes.CE getLanguageCode() {
	    return languageCode;
	}
	
	/**
	 * Set a value to attribute languageCode.
     */
	public void setLanguageCode(net.ihe.gazelle.hl7v3.datatypes.CE languageCode) {
	    this.languageCode = languageCode;
	}
	
	
	
	
	/**
	 * Return modeCode.
	 * @return modeCode
	 */
	public net.ihe.gazelle.hl7v3.datatypes.CE getModeCode() {
	    return modeCode;
	}
	
	/**
	 * Set a value to attribute modeCode.
     */
	public void setModeCode(net.ihe.gazelle.hl7v3.datatypes.CE modeCode) {
	    this.modeCode = modeCode;
	}
	
	
	
	
	/**
	 * Return proficiencyLevelCode.
	 * @return proficiencyLevelCode
	 */
	public net.ihe.gazelle.hl7v3.datatypes.CE getProficiencyLevelCode() {
	    return proficiencyLevelCode;
	}
	
	/**
	 * Set a value to attribute proficiencyLevelCode.
     */
	public void setProficiencyLevelCode(net.ihe.gazelle.hl7v3.datatypes.CE proficiencyLevelCode) {
	    this.proficiencyLevelCode = proficiencyLevelCode;
	}
	
	
	
	
	/**
	 * Return preferenceInd.
	 * @return preferenceInd
	 */
	public net.ihe.gazelle.hl7v3.datatypes.BL getPreferenceInd() {
	    return preferenceInd;
	}
	
	/**
	 * Set a value to attribute preferenceInd.
     */
	public void setPreferenceInd(net.ihe.gazelle.hl7v3.datatypes.BL preferenceInd) {
	    this.preferenceInd = preferenceInd;
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
				} catch (ParserConfigurationException ignored) {}
				try {
					jc = JAXBContext.newInstance("net.ihe.gazelle.hl7v3.coctmt090300UV01");
					Marshaller m = jc.createMarshaller();
					m.marshal(this, doc);
					_xmlNodePresentation = doc.getElementsByTagNameNS("urn:hl7-org:v3", "COCT_MT090300UV01.LanguageCommunication").item(0);
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
   public static void validateByModule(COCTMT090300UV01LanguageCommunication cOCTMT090300UV01LanguageCommunication, String _location, ConstraintValidatorModule cvm, List<net.ihe.gazelle.validation.Notification> diagnostic){
   		if (cOCTMT090300UV01LanguageCommunication != null){
   			cvm.validate(cOCTMT090300UV01LanguageCommunication, _location, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.CS realmCode: cOCTMT090300UV01LanguageCommunication.getRealmCode()){
					net.ihe.gazelle.hl7v3.datatypes.CS.validateByModule(realmCode, _location + "/realmCode[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(cOCTMT090300UV01LanguageCommunication.getTypeId(), _location + "/typeId", cvm, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.II templateId: cOCTMT090300UV01LanguageCommunication.getTemplateId()){
					net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(templateId, _location + "/templateId[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.datatypes.CE.validateByModule(cOCTMT090300UV01LanguageCommunication.getLanguageCode(), _location + "/languageCode", cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.CE.validateByModule(cOCTMT090300UV01LanguageCommunication.getModeCode(), _location + "/modeCode", cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.CE.validateByModule(cOCTMT090300UV01LanguageCommunication.getProficiencyLevelCode(), _location + "/proficiencyLevelCode", cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.BL.validateByModule(cOCTMT090300UV01LanguageCommunication.getPreferenceInd(), _location + "/preferenceInd", cvm, diagnostic);
    	}
    }

}