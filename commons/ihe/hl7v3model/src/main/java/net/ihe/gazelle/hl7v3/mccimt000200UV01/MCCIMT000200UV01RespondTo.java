/**
 * MCCIMT000200UV01RespondTo.java
 * <p>
 * File generated from the mccimt000200UV01::MCCIMT000200UV01RespondTo uml Class
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.mccimt000200UV01;

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
 * Description of the class MCCIMT000200UV01RespondTo.
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MCCI_MT000200UV01.RespondTo", propOrder = {
	"realmCode",
	"typeId",
	"templateId",
	"telecom",
	"entityRsp",
	"nullFlavor",
	"typeCode"
})
@XmlRootElement(name = "MCCI_MT000200UV01.RespondTo")
public class MCCIMT000200UV01RespondTo implements java.io.Serializable {
	
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
	@XmlElement(name = "telecom", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.TEL telecom;
	@XmlElement(name = "entityRsp", required = true, namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.mccimt000200UV01.MCCIMT000200UV01EntityRsp> entityRsp;
	@XmlAttribute(name = "nullFlavor")
	public net.ihe.gazelle.hl7v3.voc.NullFlavor nullFlavor;
	@XmlAttribute(name = "typeCode", required = true)
	public net.ihe.gazelle.hl7v3.voc.CommunicationFunctionType typeCode;
	
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
	 * Return telecom.
	 * @return telecom
	 */
	public net.ihe.gazelle.hl7v3.datatypes.TEL getTelecom() {
	    return telecom;
	}
	
	/**
	 * Set a value to attribute telecom.
     */
	public void setTelecom(net.ihe.gazelle.hl7v3.datatypes.TEL telecom) {
	    this.telecom = telecom;
	}
	
	
	
	
	/**
	 * Return entityRsp.
	 * @return entityRsp
	 */
	public List<net.ihe.gazelle.hl7v3.mccimt000200UV01.MCCIMT000200UV01EntityRsp> getEntityRsp() {
		if (entityRsp == null) {
	        entityRsp = new ArrayList<>();
	    }
	    return entityRsp;
	}
	
	/**
	 * Set a value to attribute entityRsp.
     */
	public void setEntityRsp(List<net.ihe.gazelle.hl7v3.mccimt000200UV01.MCCIMT000200UV01EntityRsp> entityRsp) {
	    this.entityRsp = entityRsp;
	}
	
	
	
	/**
	 * Add a entityRsp to the entityRsp collection.
	 * @param entityRsp_elt Element to add.
	 */
	public void addEntityRsp(net.ihe.gazelle.hl7v3.mccimt000200UV01.MCCIMT000200UV01EntityRsp entityRsp_elt) {
	    this.entityRsp.add(entityRsp_elt);
	}
	
	/**
	 * Remove a entityRsp to the entityRsp collection.
	 * @param entityRsp_elt Element to remove
	 */
	public void removeEntityRsp(net.ihe.gazelle.hl7v3.mccimt000200UV01.MCCIMT000200UV01EntityRsp entityRsp_elt) {
	    this.entityRsp.remove(entityRsp_elt);
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
	
	
	
	
	/**
	 * Return typeCode.
	 * @return typeCode
	 */
	public net.ihe.gazelle.hl7v3.voc.CommunicationFunctionType getTypeCode() {
	    return typeCode;
	}
	
	/**
	 * Set a value to attribute typeCode.
     */
	public void setTypeCode(net.ihe.gazelle.hl7v3.voc.CommunicationFunctionType typeCode) {
	    this.typeCode = typeCode;
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
					jc = JAXBContext.newInstance("net.ihe.gazelle.hl7v3.mccimt000200UV01");
					Marshaller m = jc.createMarshaller();
					m.marshal(this, doc);
					_xmlNodePresentation = doc.getElementsByTagNameNS("urn:hl7-org:v3", "MCCI_MT000200UV01.RespondTo").item(0);
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
   public static void validateByModule(MCCIMT000200UV01RespondTo mCCIMT000200UV01RespondTo, String _location, ConstraintValidatorModule cvm, List<net.ihe.gazelle.validation.Notification> diagnostic){
   		if (mCCIMT000200UV01RespondTo != null){
   			cvm.validate(mCCIMT000200UV01RespondTo, _location, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.CS realmCode: mCCIMT000200UV01RespondTo.getRealmCode()){
					net.ihe.gazelle.hl7v3.datatypes.CS.validateByModule(realmCode, _location + "/realmCode[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(mCCIMT000200UV01RespondTo.getTypeId(), _location + "/typeId", cvm, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.II templateId: mCCIMT000200UV01RespondTo.getTemplateId()){
					net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(templateId, _location + "/templateId[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.datatypes.TEL.validateByModule(mCCIMT000200UV01RespondTo.getTelecom(), _location + "/telecom", cvm, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.mccimt000200UV01.MCCIMT000200UV01EntityRsp entityRsp: mCCIMT000200UV01RespondTo.getEntityRsp()){
					net.ihe.gazelle.hl7v3.mccimt000200UV01.MCCIMT000200UV01EntityRsp.validateByModule(entityRsp, _location + "/entityRsp[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
    	}
    }

}