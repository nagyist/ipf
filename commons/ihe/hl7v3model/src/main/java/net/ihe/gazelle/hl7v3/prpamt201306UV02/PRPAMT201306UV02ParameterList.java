/**
 * PRPAMT201306UV02ParameterList.java
 *
 * File generated from the prpamt201306UV02::PRPAMT201306UV02ParameterList uml Class
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.prpamt201306UV02;

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
 * Description of the class PRPAMT201306UV02ParameterList.
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT201306UV02.ParameterList", propOrder = {
	"realmCode",
	"typeId",
	"templateId",
	"id",
	"livingSubjectAdministrativeGender",
	"livingSubjectBirthPlaceAddress",
	"livingSubjectBirthPlaceName",
	"livingSubjectBirthTime",
	"livingSubjectDeceasedTime",
	"livingSubjectId",
	"livingSubjectName",
	"mothersMaidenName",
	"otherIDsScopingOrganization",
	"patientAddress",
	"patientStatusCode",
	"patientTelecom",
	"principalCareProviderId",
	"principalCareProvisionId",
	"nullFlavor"
})
@XmlRootElement(name = "PRPA_MT201306UV02.ParameterList")
public class PRPAMT201306UV02ParameterList implements java.io.Serializable {
	
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
	public net.ihe.gazelle.hl7v3.datatypes.II id;
	@XmlElement(name = "livingSubjectAdministrativeGender", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectAdministrativeGender> livingSubjectAdministrativeGender;
	@XmlElement(name = "livingSubjectBirthPlaceAddress", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthPlaceAddress> livingSubjectBirthPlaceAddress;
	@XmlElement(name = "livingSubjectBirthPlaceName", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthPlaceName> livingSubjectBirthPlaceName;
	@XmlElement(name = "livingSubjectBirthTime", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthTime> livingSubjectBirthTime;
	@XmlElement(name = "livingSubjectDeceasedTime", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectDeceasedTime> livingSubjectDeceasedTime;
	@XmlElement(name = "livingSubjectId", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectId> livingSubjectId;
	@XmlElement(name = "livingSubjectName", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectName> livingSubjectName;
	@XmlElement(name = "mothersMaidenName", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02MothersMaidenName> mothersMaidenName;
	@XmlElement(name = "otherIDsScopingOrganization", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02OtherIDsScopingOrganization> otherIDsScopingOrganization;
	@XmlElement(name = "patientAddress", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientAddress> patientAddress;
	@XmlElement(name = "patientStatusCode", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientStatusCode> patientStatusCode;
	@XmlElement(name = "patientTelecom", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientTelecom> patientTelecom;
	@XmlElement(name = "principalCareProviderId", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PrincipalCareProviderId> principalCareProviderId;
	@XmlElement(name = "principalCareProvisionId", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PrincipalCareProvisionId> principalCareProvisionId;
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
	 * Return livingSubjectAdministrativeGender.
	 * @return livingSubjectAdministrativeGender
	 */
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectAdministrativeGender> getLivingSubjectAdministrativeGender() {
		if (livingSubjectAdministrativeGender == null) {
	        livingSubjectAdministrativeGender = new ArrayList<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectAdministrativeGender>();
	    }
	    return livingSubjectAdministrativeGender;
	}
	
	/**
	 * Set a value to attribute livingSubjectAdministrativeGender.
	 * @param livingSubjectAdministrativeGender.
	 */
	public void setLivingSubjectAdministrativeGender(List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectAdministrativeGender> livingSubjectAdministrativeGender) {
	    this.livingSubjectAdministrativeGender = livingSubjectAdministrativeGender;
	}
	
	
	
	/**
	 * Add a livingSubjectAdministrativeGender to the livingSubjectAdministrativeGender collection.
	 * @param livingSubjectAdministrativeGender_elt Element to add.
	 */
	public void addLivingSubjectAdministrativeGender(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectAdministrativeGender livingSubjectAdministrativeGender_elt) {
	    this.getLivingSubjectAdministrativeGender().add(livingSubjectAdministrativeGender_elt);
	}
	
	/**
	 * Remove a livingSubjectAdministrativeGender to the livingSubjectAdministrativeGender collection.
	 * @param livingSubjectAdministrativeGender_elt Element to remove
	 */
	public void removeLivingSubjectAdministrativeGender(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectAdministrativeGender livingSubjectAdministrativeGender_elt) {
	    this.getLivingSubjectAdministrativeGender().remove(livingSubjectAdministrativeGender_elt);
	}
	
	/**
	 * Return livingSubjectBirthPlaceAddress.
	 * @return livingSubjectBirthPlaceAddress
	 */
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthPlaceAddress> getLivingSubjectBirthPlaceAddress() {
		if (livingSubjectBirthPlaceAddress == null) {
	        livingSubjectBirthPlaceAddress = new ArrayList<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthPlaceAddress>();
	    }
	    return livingSubjectBirthPlaceAddress;
	}
	
	/**
	 * Set a value to attribute livingSubjectBirthPlaceAddress.
	 * @param livingSubjectBirthPlaceAddress.
	 */
	public void setLivingSubjectBirthPlaceAddress(List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthPlaceAddress> livingSubjectBirthPlaceAddress) {
	    this.livingSubjectBirthPlaceAddress = livingSubjectBirthPlaceAddress;
	}
	
	
	
	/**
	 * Add a livingSubjectBirthPlaceAddress to the livingSubjectBirthPlaceAddress collection.
	 * @param livingSubjectBirthPlaceAddress_elt Element to add.
	 */
	public void addLivingSubjectBirthPlaceAddress(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthPlaceAddress livingSubjectBirthPlaceAddress_elt) {
	    this.getLivingSubjectBirthPlaceAddress().add(livingSubjectBirthPlaceAddress_elt);
	}
	
	/**
	 * Remove a livingSubjectBirthPlaceAddress to the livingSubjectBirthPlaceAddress collection.
	 * @param livingSubjectBirthPlaceAddress_elt Element to remove
	 */
	public void removeLivingSubjectBirthPlaceAddress(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthPlaceAddress livingSubjectBirthPlaceAddress_elt) {
	    this.getLivingSubjectBirthPlaceAddress().remove(livingSubjectBirthPlaceAddress_elt);
	}
	
	/**
	 * Return livingSubjectBirthPlaceName.
	 * @return livingSubjectBirthPlaceName
	 */
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthPlaceName> getLivingSubjectBirthPlaceName() {
		if (livingSubjectBirthPlaceName == null) {
	        livingSubjectBirthPlaceName = new ArrayList<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthPlaceName>();
	    }
	    return livingSubjectBirthPlaceName;
	}
	
	/**
	 * Set a value to attribute livingSubjectBirthPlaceName.
	 * @param livingSubjectBirthPlaceName.
	 */
	public void setLivingSubjectBirthPlaceName(List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthPlaceName> livingSubjectBirthPlaceName) {
	    this.livingSubjectBirthPlaceName = livingSubjectBirthPlaceName;
	}
	
	
	
	/**
	 * Add a livingSubjectBirthPlaceName to the livingSubjectBirthPlaceName collection.
	 * @param livingSubjectBirthPlaceName_elt Element to add.
	 */
	public void addLivingSubjectBirthPlaceName(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthPlaceName livingSubjectBirthPlaceName_elt) {
	    this.getLivingSubjectBirthPlaceName().add(livingSubjectBirthPlaceName_elt);
	}
	
	/**
	 * Remove a livingSubjectBirthPlaceName to the livingSubjectBirthPlaceName collection.
	 * @param livingSubjectBirthPlaceName_elt Element to remove
	 */
	public void removeLivingSubjectBirthPlaceName(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthPlaceName livingSubjectBirthPlaceName_elt) {
	    this.getLivingSubjectBirthPlaceName().remove(livingSubjectBirthPlaceName_elt);
	}
	
	/**
	 * Return livingSubjectBirthTime.
	 * @return livingSubjectBirthTime
	 */
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthTime> getLivingSubjectBirthTime() {
		if (livingSubjectBirthTime == null) {
	        livingSubjectBirthTime = new ArrayList<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthTime>();
	    }
	    return livingSubjectBirthTime;
	}
	
	/**
	 * Set a value to attribute livingSubjectBirthTime.
	 * @param livingSubjectBirthTime.
	 */
	public void setLivingSubjectBirthTime(List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthTime> livingSubjectBirthTime) {
	    this.livingSubjectBirthTime = livingSubjectBirthTime;
	}
	
	
	
	/**
	 * Add a livingSubjectBirthTime to the livingSubjectBirthTime collection.
	 * @param livingSubjectBirthTime_elt Element to add.
	 */
	public void addLivingSubjectBirthTime(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthTime livingSubjectBirthTime_elt) {
	    this.getLivingSubjectBirthTime().add(livingSubjectBirthTime_elt);
	}
	
	/**
	 * Remove a livingSubjectBirthTime to the livingSubjectBirthTime collection.
	 * @param livingSubjectBirthTime_elt Element to remove
	 */
	public void removeLivingSubjectBirthTime(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthTime livingSubjectBirthTime_elt) {
	    this.getLivingSubjectBirthTime().remove(livingSubjectBirthTime_elt);
	}
	
	/**
	 * Return livingSubjectDeceasedTime.
	 * @return livingSubjectDeceasedTime
	 */
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectDeceasedTime> getLivingSubjectDeceasedTime() {
		if (livingSubjectDeceasedTime == null) {
	        livingSubjectDeceasedTime = new ArrayList<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectDeceasedTime>();
	    }
	    return livingSubjectDeceasedTime;
	}
	
	/**
	 * Set a value to attribute livingSubjectDeceasedTime.
	 * @param livingSubjectDeceasedTime.
	 */
	public void setLivingSubjectDeceasedTime(List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectDeceasedTime> livingSubjectDeceasedTime) {
	    this.livingSubjectDeceasedTime = livingSubjectDeceasedTime;
	}
	
	
	
	/**
	 * Add a livingSubjectDeceasedTime to the livingSubjectDeceasedTime collection.
	 * @param livingSubjectDeceasedTime_elt Element to add.
	 */
	public void addLivingSubjectDeceasedTime(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectDeceasedTime livingSubjectDeceasedTime_elt) {
	    this.getLivingSubjectDeceasedTime().add(livingSubjectDeceasedTime_elt);
	}
	
	/**
	 * Remove a livingSubjectDeceasedTime to the livingSubjectDeceasedTime collection.
	 * @param livingSubjectDeceasedTime_elt Element to remove
	 */
	public void removeLivingSubjectDeceasedTime(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectDeceasedTime livingSubjectDeceasedTime_elt) {
	    this.getLivingSubjectDeceasedTime().remove(livingSubjectDeceasedTime_elt);
	}
	
	/**
	 * Return livingSubjectId.
	 * @return livingSubjectId
	 */
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectId> getLivingSubjectId() {
		if (livingSubjectId == null) {
	        livingSubjectId = new ArrayList<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectId>();
	    }
	    return livingSubjectId;
	}
	
	/**
	 * Set a value to attribute livingSubjectId.
	 * @param livingSubjectId.
	 */
	public void setLivingSubjectId(List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectId> livingSubjectId) {
	    this.livingSubjectId = livingSubjectId;
	}
	
	
	
	/**
	 * Add a livingSubjectId to the livingSubjectId collection.
	 * @param livingSubjectId_elt Element to add.
	 */
	public void addLivingSubjectId(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectId livingSubjectId_elt) {
	    this.getLivingSubjectId().add(livingSubjectId_elt);
	}
	
	/**
	 * Remove a livingSubjectId to the livingSubjectId collection.
	 * @param livingSubjectId_elt Element to remove
	 */
	public void removeLivingSubjectId(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectId livingSubjectId_elt) {
	    this.getLivingSubjectId().remove(livingSubjectId_elt);
	}
	
	/**
	 * Return livingSubjectName.
	 * @return livingSubjectName
	 */
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectName> getLivingSubjectName() {
		if (livingSubjectName == null) {
	        livingSubjectName = new ArrayList<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectName>();
	    }
	    return livingSubjectName;
	}
	
	/**
	 * Set a value to attribute livingSubjectName.
	 * @param livingSubjectName.
	 */
	public void setLivingSubjectName(List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectName> livingSubjectName) {
	    this.livingSubjectName = livingSubjectName;
	}
	
	
	
	/**
	 * Add a livingSubjectName to the livingSubjectName collection.
	 * @param livingSubjectName_elt Element to add.
	 */
	public void addLivingSubjectName(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectName livingSubjectName_elt) {
	    this.getLivingSubjectName().add(livingSubjectName_elt);
	}
	
	/**
	 * Remove a livingSubjectName to the livingSubjectName collection.
	 * @param livingSubjectName_elt Element to remove
	 */
	public void removeLivingSubjectName(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectName livingSubjectName_elt) {
	    this.getLivingSubjectName().remove(livingSubjectName_elt);
	}
	
	/**
	 * Return mothersMaidenName.
	 * @return mothersMaidenName
	 */
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02MothersMaidenName> getMothersMaidenName() {
		if (mothersMaidenName == null) {
	        mothersMaidenName = new ArrayList<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02MothersMaidenName>();
	    }
	    return mothersMaidenName;
	}
	
	/**
	 * Set a value to attribute mothersMaidenName.
	 * @param mothersMaidenName.
	 */
	public void setMothersMaidenName(List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02MothersMaidenName> mothersMaidenName) {
	    this.mothersMaidenName = mothersMaidenName;
	}
	
	
	
	/**
	 * Add a mothersMaidenName to the mothersMaidenName collection.
	 * @param mothersMaidenName_elt Element to add.
	 */
	public void addMothersMaidenName(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02MothersMaidenName mothersMaidenName_elt) {
	    this.getMothersMaidenName().add(mothersMaidenName_elt);
	}
	
	/**
	 * Remove a mothersMaidenName to the mothersMaidenName collection.
	 * @param mothersMaidenName_elt Element to remove
	 */
	public void removeMothersMaidenName(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02MothersMaidenName mothersMaidenName_elt) {
	    this.getMothersMaidenName().remove(mothersMaidenName_elt);
	}
	
	/**
	 * Return otherIDsScopingOrganization.
	 * @return otherIDsScopingOrganization
	 */
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02OtherIDsScopingOrganization> getOtherIDsScopingOrganization() {
		if (otherIDsScopingOrganization == null) {
	        otherIDsScopingOrganization = new ArrayList<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02OtherIDsScopingOrganization>();
	    }
	    return otherIDsScopingOrganization;
	}
	
	/**
	 * Set a value to attribute otherIDsScopingOrganization.
	 * @param otherIDsScopingOrganization.
	 */
	public void setOtherIDsScopingOrganization(List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02OtherIDsScopingOrganization> otherIDsScopingOrganization) {
	    this.otherIDsScopingOrganization = otherIDsScopingOrganization;
	}
	
	
	
	/**
	 * Add a otherIDsScopingOrganization to the otherIDsScopingOrganization collection.
	 * @param otherIDsScopingOrganization_elt Element to add.
	 */
	public void addOtherIDsScopingOrganization(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02OtherIDsScopingOrganization otherIDsScopingOrganization_elt) {
	    this.getOtherIDsScopingOrganization().add(otherIDsScopingOrganization_elt);
	}
	
	/**
	 * Remove a otherIDsScopingOrganization to the otherIDsScopingOrganization collection.
	 * @param otherIDsScopingOrganization_elt Element to remove
	 */
	public void removeOtherIDsScopingOrganization(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02OtherIDsScopingOrganization otherIDsScopingOrganization_elt) {
	    this.getOtherIDsScopingOrganization().remove(otherIDsScopingOrganization_elt);
	}
	
	/**
	 * Return patientAddress.
	 * @return patientAddress
	 */
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientAddress> getPatientAddress() {
		if (patientAddress == null) {
	        patientAddress = new ArrayList<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientAddress>();
	    }
	    return patientAddress;
	}
	
	/**
	 * Set a value to attribute patientAddress.
	 * @param patientAddress.
	 */
	public void setPatientAddress(List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientAddress> patientAddress) {
	    this.patientAddress = patientAddress;
	}
	
	
	
	/**
	 * Add a patientAddress to the patientAddress collection.
	 * @param patientAddress_elt Element to add.
	 */
	public void addPatientAddress(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientAddress patientAddress_elt) {
	    this.getPatientAddress().add(patientAddress_elt);
	}
	
	/**
	 * Remove a patientAddress to the patientAddress collection.
	 * @param patientAddress_elt Element to remove
	 */
	public void removePatientAddress(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientAddress patientAddress_elt) {
	    this.getPatientAddress().remove(patientAddress_elt);
	}
	
	/**
	 * Return patientStatusCode.
	 * @return patientStatusCode
	 */
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientStatusCode> getPatientStatusCode() {
		if (patientStatusCode == null) {
	        patientStatusCode = new ArrayList<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientStatusCode>();
	    }
	    return patientStatusCode;
	}
	
	/**
	 * Set a value to attribute patientStatusCode.
	 * @param patientStatusCode.
	 */
	public void setPatientStatusCode(List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientStatusCode> patientStatusCode) {
	    this.patientStatusCode = patientStatusCode;
	}
	
	
	
	/**
	 * Add a patientStatusCode to the patientStatusCode collection.
	 * @param patientStatusCode_elt Element to add.
	 */
	public void addPatientStatusCode(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientStatusCode patientStatusCode_elt) {
	    this.getPatientStatusCode().add(patientStatusCode_elt);
	}
	
	/**
	 * Remove a patientStatusCode to the patientStatusCode collection.
	 * @param patientStatusCode_elt Element to remove
	 */
	public void removePatientStatusCode(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientStatusCode patientStatusCode_elt) {
	    this.getPatientStatusCode().remove(patientStatusCode_elt);
	}
	
	/**
	 * Return patientTelecom.
	 * @return patientTelecom
	 */
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientTelecom> getPatientTelecom() {
		if (patientTelecom == null) {
	        patientTelecom = new ArrayList<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientTelecom>();
	    }
	    return patientTelecom;
	}
	
	/**
	 * Set a value to attribute patientTelecom.
	 * @param patientTelecom.
	 */
	public void setPatientTelecom(List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientTelecom> patientTelecom) {
	    this.patientTelecom = patientTelecom;
	}
	
	
	
	/**
	 * Add a patientTelecom to the patientTelecom collection.
	 * @param patientTelecom_elt Element to add.
	 */
	public void addPatientTelecom(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientTelecom patientTelecom_elt) {
	    this.getPatientTelecom().add(patientTelecom_elt);
	}
	
	/**
	 * Remove a patientTelecom to the patientTelecom collection.
	 * @param patientTelecom_elt Element to remove
	 */
	public void removePatientTelecom(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientTelecom patientTelecom_elt) {
	    this.getPatientTelecom().remove(patientTelecom_elt);
	}
	
	/**
	 * Return principalCareProviderId.
	 * @return principalCareProviderId
	 */
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PrincipalCareProviderId> getPrincipalCareProviderId() {
		if (principalCareProviderId == null) {
	        principalCareProviderId = new ArrayList<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PrincipalCareProviderId>();
	    }
	    return principalCareProviderId;
	}
	
	/**
	 * Set a value to attribute principalCareProviderId.
	 * @param principalCareProviderId.
	 */
	public void setPrincipalCareProviderId(List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PrincipalCareProviderId> principalCareProviderId) {
	    this.principalCareProviderId = principalCareProviderId;
	}
	
	
	
	/**
	 * Add a principalCareProviderId to the principalCareProviderId collection.
	 * @param principalCareProviderId_elt Element to add.
	 */
	public void addPrincipalCareProviderId(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PrincipalCareProviderId principalCareProviderId_elt) {
	    this.getPrincipalCareProviderId().add(principalCareProviderId_elt);
	}
	
	/**
	 * Remove a principalCareProviderId to the principalCareProviderId collection.
	 * @param principalCareProviderId_elt Element to remove
	 */
	public void removePrincipalCareProviderId(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PrincipalCareProviderId principalCareProviderId_elt) {
	    this.getPrincipalCareProviderId().remove(principalCareProviderId_elt);
	}
	
	/**
	 * Return principalCareProvisionId.
	 * @return principalCareProvisionId
	 */
	public List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PrincipalCareProvisionId> getPrincipalCareProvisionId() {
		if (principalCareProvisionId == null) {
	        principalCareProvisionId = new ArrayList<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PrincipalCareProvisionId>();
	    }
	    return principalCareProvisionId;
	}
	
	/**
	 * Set a value to attribute principalCareProvisionId.
	 * @param principalCareProvisionId.
	 */
	public void setPrincipalCareProvisionId(List<net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PrincipalCareProvisionId> principalCareProvisionId) {
	    this.principalCareProvisionId = principalCareProvisionId;
	}
	
	
	
	/**
	 * Add a principalCareProvisionId to the principalCareProvisionId collection.
	 * @param principalCareProvisionId_elt Element to add.
	 */
	public void addPrincipalCareProvisionId(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PrincipalCareProvisionId principalCareProvisionId_elt) {
	    this.getPrincipalCareProvisionId().add(principalCareProvisionId_elt);
	}
	
	/**
	 * Remove a principalCareProvisionId to the principalCareProvisionId collection.
	 * @param principalCareProvisionId_elt Element to remove
	 */
	public void removePrincipalCareProvisionId(net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PrincipalCareProvisionId principalCareProvisionId_elt) {
	    this.getPrincipalCareProvisionId().remove(principalCareProvisionId_elt);
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
					jc = JAXBContext.newInstance("net.ihe.gazelle.hl7v3.prpamt201306UV02");
					Marshaller m = jc.createMarshaller();
					m.marshal(this, doc);
					_xmlNodePresentation = doc.getElementsByTagNameNS("urn:hl7-org:v3", "PRPA_MT201306UV02.ParameterList").item(0);
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
   public static void validateByModule(PRPAMT201306UV02ParameterList pRPAMT201306UV02ParameterList, String _location, ConstraintValidatorModule cvm, List<net.ihe.gazelle.validation.Notification> diagnostic){
   		if (pRPAMT201306UV02ParameterList != null){
   			cvm.validate(pRPAMT201306UV02ParameterList, _location, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.CS realmCode: pRPAMT201306UV02ParameterList.getRealmCode()){
					net.ihe.gazelle.hl7v3.datatypes.CS.validateByModule(realmCode, _location + "/realmCode[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(pRPAMT201306UV02ParameterList.getTypeId(), _location + "/typeId", cvm, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.II templateId: pRPAMT201306UV02ParameterList.getTemplateId()){
					net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(templateId, _location + "/templateId[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(pRPAMT201306UV02ParameterList.getId(), _location + "/id", cvm, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectAdministrativeGender livingSubjectAdministrativeGender: pRPAMT201306UV02ParameterList.getLivingSubjectAdministrativeGender()){
					net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectAdministrativeGender.validateByModule(livingSubjectAdministrativeGender, _location + "/livingSubjectAdministrativeGender[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthPlaceAddress livingSubjectBirthPlaceAddress: pRPAMT201306UV02ParameterList.getLivingSubjectBirthPlaceAddress()){
					net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthPlaceAddress.validateByModule(livingSubjectBirthPlaceAddress, _location + "/livingSubjectBirthPlaceAddress[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthPlaceName livingSubjectBirthPlaceName: pRPAMT201306UV02ParameterList.getLivingSubjectBirthPlaceName()){
					net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthPlaceName.validateByModule(livingSubjectBirthPlaceName, _location + "/livingSubjectBirthPlaceName[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthTime livingSubjectBirthTime: pRPAMT201306UV02ParameterList.getLivingSubjectBirthTime()){
					net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthTime.validateByModule(livingSubjectBirthTime, _location + "/livingSubjectBirthTime[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectDeceasedTime livingSubjectDeceasedTime: pRPAMT201306UV02ParameterList.getLivingSubjectDeceasedTime()){
					net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectDeceasedTime.validateByModule(livingSubjectDeceasedTime, _location + "/livingSubjectDeceasedTime[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectId livingSubjectId: pRPAMT201306UV02ParameterList.getLivingSubjectId()){
					net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectId.validateByModule(livingSubjectId, _location + "/livingSubjectId[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectName livingSubjectName: pRPAMT201306UV02ParameterList.getLivingSubjectName()){
					net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectName.validateByModule(livingSubjectName, _location + "/livingSubjectName[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02MothersMaidenName mothersMaidenName: pRPAMT201306UV02ParameterList.getMothersMaidenName()){
					net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02MothersMaidenName.validateByModule(mothersMaidenName, _location + "/mothersMaidenName[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02OtherIDsScopingOrganization otherIDsScopingOrganization: pRPAMT201306UV02ParameterList.getOtherIDsScopingOrganization()){
					net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02OtherIDsScopingOrganization.validateByModule(otherIDsScopingOrganization, _location + "/otherIDsScopingOrganization[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientAddress patientAddress: pRPAMT201306UV02ParameterList.getPatientAddress()){
					net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientAddress.validateByModule(patientAddress, _location + "/patientAddress[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientStatusCode patientStatusCode: pRPAMT201306UV02ParameterList.getPatientStatusCode()){
					net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientStatusCode.validateByModule(patientStatusCode, _location + "/patientStatusCode[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientTelecom patientTelecom: pRPAMT201306UV02ParameterList.getPatientTelecom()){
					net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientTelecom.validateByModule(patientTelecom, _location + "/patientTelecom[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PrincipalCareProviderId principalCareProviderId: pRPAMT201306UV02ParameterList.getPrincipalCareProviderId()){
					net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PrincipalCareProviderId.validateByModule(principalCareProviderId, _location + "/principalCareProviderId[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PrincipalCareProvisionId principalCareProvisionId: pRPAMT201306UV02ParameterList.getPrincipalCareProvisionId()){
					net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PrincipalCareProvisionId.validateByModule(principalCareProvisionId, _location + "/principalCareProvisionId[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
    	}
    }

}