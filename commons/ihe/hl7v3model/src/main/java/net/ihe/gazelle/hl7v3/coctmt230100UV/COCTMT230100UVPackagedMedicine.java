/**
 * COCTMT230100UVPackagedMedicine.java
 * <p>
 * File generated from the coctmt230100UV::COCTMT230100UVPackagedMedicine uml Class
 * Generated by IHE - europe, gazelle team
 */
package net.ihe.gazelle.hl7v3.coctmt230100UV;

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
 * Description of the class COCTMT230100UVPackagedMedicine.
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COCT_MT230100UV.PackagedMedicine", propOrder = {
	"realmCode",
	"typeId",
	"templateId",
	"id",
	"code",
	"name",
	"formCode",
	"lotNumberText",
	"capacityQuantity",
	"capTypeCode",
	"asManufacturedProduct",
	"asSuperContent",
	"subContent",
	"classCode",
	"determinerCode",
	"nullFlavor"
})
@XmlRootElement(name = "COCT_MT230100UV.PackagedMedicine")
public class COCTMT230100UVPackagedMedicine implements java.io.Serializable {
	
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
	@XmlElement(name = "id", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.II id;
	@XmlElement(name = "code", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.CE code;
	@XmlElement(name = "name", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.datatypes.TN> name;
	@XmlElement(name = "formCode", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.CE formCode;
	@XmlElement(name = "lotNumberText", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.ST lotNumberText;
	@XmlElement(name = "capacityQuantity", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.PQ capacityQuantity;
	@XmlElement(name = "capTypeCode", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.CE capTypeCode;
	@XmlElement(name = "asManufacturedProduct", namespace = "urn:hl7-org:v3")
	public List<net.ihe.gazelle.hl7v3.coctmt230100UV.COCTMT230100UVManufacturedProduct> asManufacturedProduct;
	@XmlElement(name = "asSuperContent", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.coctmt230100UV.COCTMT230100UVSuperContent asSuperContent;
	@XmlElement(name = "subContent", namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.coctmt230100UV.COCTMT230100UVSubContent subContent;
	@XmlAttribute(name = "classCode", required = true)
	public net.ihe.gazelle.hl7v3.voc.EntityClassContainer classCode;
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
	 * Return id.
	 * @return id
	 */
	public net.ihe.gazelle.hl7v3.datatypes.II getId() {
	    return id;
	}
	
	/**
	 * Set a value to attribute id.
     */
	public void setId(net.ihe.gazelle.hl7v3.datatypes.II id) {
	    this.id = id;
	}
	
	
	
	
	/**
	 * Return code.
	 * @return code
	 */
	public net.ihe.gazelle.hl7v3.datatypes.CE getCode() {
	    return code;
	}
	
	/**
	 * Set a value to attribute code.
     */
	public void setCode(net.ihe.gazelle.hl7v3.datatypes.CE code) {
	    this.code = code;
	}
	
	
	
	
	/**
	 * Return name.
	 * @return name
	 */
	public List<net.ihe.gazelle.hl7v3.datatypes.TN> getName() {
		if (name == null) {
	        name = new ArrayList<>();
	    }
	    return name;
	}
	
	/**
	 * Set a value to attribute name.
     */
	public void setName(List<net.ihe.gazelle.hl7v3.datatypes.TN> name) {
	    this.name = name;
	}
	
	
	
	/**
	 * Add a name to the name collection.
	 * @param name_elt Element to add.
	 */
	public void addName(net.ihe.gazelle.hl7v3.datatypes.TN name_elt) {
	    this.name.add(name_elt);
	}
	
	/**
	 * Remove a name to the name collection.
	 * @param name_elt Element to remove
	 */
	public void removeName(net.ihe.gazelle.hl7v3.datatypes.TN name_elt) {
	    this.name.remove(name_elt);
	}
	
	/**
	 * Return formCode.
	 * @return formCode
	 */
	public net.ihe.gazelle.hl7v3.datatypes.CE getFormCode() {
	    return formCode;
	}
	
	/**
	 * Set a value to attribute formCode.
     */
	public void setFormCode(net.ihe.gazelle.hl7v3.datatypes.CE formCode) {
	    this.formCode = formCode;
	}
	
	
	
	
	/**
	 * Return lotNumberText.
	 * @return lotNumberText
	 */
	public net.ihe.gazelle.hl7v3.datatypes.ST getLotNumberText() {
	    return lotNumberText;
	}
	
	/**
	 * Set a value to attribute lotNumberText.
     */
	public void setLotNumberText(net.ihe.gazelle.hl7v3.datatypes.ST lotNumberText) {
	    this.lotNumberText = lotNumberText;
	}
	
	
	
	
	/**
	 * Return capacityQuantity.
	 * @return capacityQuantity
	 */
	public net.ihe.gazelle.hl7v3.datatypes.PQ getCapacityQuantity() {
	    return capacityQuantity;
	}
	
	/**
	 * Set a value to attribute capacityQuantity.
     */
	public void setCapacityQuantity(net.ihe.gazelle.hl7v3.datatypes.PQ capacityQuantity) {
	    this.capacityQuantity = capacityQuantity;
	}
	
	
	
	
	/**
	 * Return capTypeCode.
	 * @return capTypeCode
	 */
	public net.ihe.gazelle.hl7v3.datatypes.CE getCapTypeCode() {
	    return capTypeCode;
	}
	
	/**
	 * Set a value to attribute capTypeCode.
     */
	public void setCapTypeCode(net.ihe.gazelle.hl7v3.datatypes.CE capTypeCode) {
	    this.capTypeCode = capTypeCode;
	}
	
	
	
	
	/**
	 * Return asManufacturedProduct.
	 * @return asManufacturedProduct
	 */
	public List<net.ihe.gazelle.hl7v3.coctmt230100UV.COCTMT230100UVManufacturedProduct> getAsManufacturedProduct() {
		if (asManufacturedProduct == null) {
	        asManufacturedProduct = new ArrayList<>();
	    }
	    return asManufacturedProduct;
	}
	
	/**
	 * Set a value to attribute asManufacturedProduct.
     */
	public void setAsManufacturedProduct(List<net.ihe.gazelle.hl7v3.coctmt230100UV.COCTMT230100UVManufacturedProduct> asManufacturedProduct) {
	    this.asManufacturedProduct = asManufacturedProduct;
	}
	
	
	
	/**
	 * Add a asManufacturedProduct to the asManufacturedProduct collection.
	 * @param asManufacturedProduct_elt Element to add.
	 */
	public void addAsManufacturedProduct(net.ihe.gazelle.hl7v3.coctmt230100UV.COCTMT230100UVManufacturedProduct asManufacturedProduct_elt) {
	    this.asManufacturedProduct.add(asManufacturedProduct_elt);
	}
	
	/**
	 * Remove a asManufacturedProduct to the asManufacturedProduct collection.
	 * @param asManufacturedProduct_elt Element to remove
	 */
	public void removeAsManufacturedProduct(net.ihe.gazelle.hl7v3.coctmt230100UV.COCTMT230100UVManufacturedProduct asManufacturedProduct_elt) {
	    this.asManufacturedProduct.remove(asManufacturedProduct_elt);
	}
	
	/**
	 * Return asSuperContent.
	 * @return asSuperContent
	 */
	public net.ihe.gazelle.hl7v3.coctmt230100UV.COCTMT230100UVSuperContent getAsSuperContent() {
	    return asSuperContent;
	}
	
	/**
	 * Set a value to attribute asSuperContent.
     */
	public void setAsSuperContent(net.ihe.gazelle.hl7v3.coctmt230100UV.COCTMT230100UVSuperContent asSuperContent) {
	    this.asSuperContent = asSuperContent;
	}
	
	
	
	
	/**
	 * Return subContent.
	 * @return subContent
	 */
	public net.ihe.gazelle.hl7v3.coctmt230100UV.COCTMT230100UVSubContent getSubContent() {
	    return subContent;
	}
	
	/**
	 * Set a value to attribute subContent.
     */
	public void setSubContent(net.ihe.gazelle.hl7v3.coctmt230100UV.COCTMT230100UVSubContent subContent) {
	    this.subContent = subContent;
	}
	
	
	
	
	/**
	 * Return classCode.
	 * @return classCode
	 */
	public net.ihe.gazelle.hl7v3.voc.EntityClassContainer getClassCode() {
	    return classCode;
	}
	
	/**
	 * Set a value to attribute classCode.
     */
	public void setClassCode(net.ihe.gazelle.hl7v3.voc.EntityClassContainer classCode) {
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
					jc = JAXBContext.newInstance("net.ihe.gazelle.hl7v3.coctmt230100UV");
					Marshaller m = jc.createMarshaller();
					m.marshal(this, doc);
					_xmlNodePresentation = doc.getElementsByTagNameNS("urn:hl7-org:v3", "COCT_MT230100UV.PackagedMedicine").item(0);
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
   public static void validateByModule(COCTMT230100UVPackagedMedicine cOCTMT230100UVPackagedMedicine, String _location, ConstraintValidatorModule cvm, List<net.ihe.gazelle.validation.Notification> diagnostic){
   		if (cOCTMT230100UVPackagedMedicine != null){
   			cvm.validate(cOCTMT230100UVPackagedMedicine, _location, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.CS realmCode: cOCTMT230100UVPackagedMedicine.getRealmCode()){
					net.ihe.gazelle.hl7v3.datatypes.CS.validateByModule(realmCode, _location + "/realmCode[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(cOCTMT230100UVPackagedMedicine.getTypeId(), _location + "/typeId", cvm, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.II templateId: cOCTMT230100UVPackagedMedicine.getTemplateId()){
					net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(templateId, _location + "/templateId[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.datatypes.II.validateByModule(cOCTMT230100UVPackagedMedicine.getId(), _location + "/id", cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.CE.validateByModule(cOCTMT230100UVPackagedMedicine.getCode(), _location + "/code", cvm, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.datatypes.TN name: cOCTMT230100UVPackagedMedicine.getName()){
					net.ihe.gazelle.hl7v3.datatypes.TN.validateByModule(name, _location + "/name[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.datatypes.CE.validateByModule(cOCTMT230100UVPackagedMedicine.getFormCode(), _location + "/formCode", cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.ST.validateByModule(cOCTMT230100UVPackagedMedicine.getLotNumberText(), _location + "/lotNumberText", cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.PQ.validateByModule(cOCTMT230100UVPackagedMedicine.getCapacityQuantity(), _location + "/capacityQuantity", cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.CE.validateByModule(cOCTMT230100UVPackagedMedicine.getCapTypeCode(), _location + "/capTypeCode", cvm, diagnostic);
			{
				int i = 0;
				for (net.ihe.gazelle.hl7v3.coctmt230100UV.COCTMT230100UVManufacturedProduct asManufacturedProduct: cOCTMT230100UVPackagedMedicine.getAsManufacturedProduct()){
					net.ihe.gazelle.hl7v3.coctmt230100UV.COCTMT230100UVManufacturedProduct.validateByModule(asManufacturedProduct, _location + "/asManufacturedProduct[" + i + "]", cvm, diagnostic);
					i++;
				}
			}
			
			net.ihe.gazelle.hl7v3.coctmt230100UV.COCTMT230100UVSuperContent.validateByModule(cOCTMT230100UVPackagedMedicine.getAsSuperContent(), _location + "/asSuperContent", cvm, diagnostic);
			net.ihe.gazelle.hl7v3.coctmt230100UV.COCTMT230100UVSubContent.validateByModule(cOCTMT230100UVPackagedMedicine.getSubContent(), _location + "/subContent", cvm, diagnostic);
    	}
    }

}