/**
 * GLISTTS.java
 * <p>
 * File generated from the datatypes::GLISTTS uml Class
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
 * Description of the class GLISTTS.
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GLIST_TS", propOrder = {
	"head",
	"increment",
	"denominator",
	"period"
})
@XmlRootElement(name = "GLIST_TS")
public class GLISTTS extends net.ihe.gazelle.hl7v3.datatypes.ANY implements java.io.Serializable {
	
	/**
	 * 
	 */
	@Serial
    private static final long serialVersionUID = 1L;

	
	/**
	 * 
	                     This is the start-value of the generated list. 
	                  .
	 */
	@XmlElement(name = "head", required = true, namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.TS head;
	/**
	 * 
	                     The difference between one value and its previous
	                     different value. For example, to generate the sequence
	                     (1; 4; 7; 10; 13; ...) the increment is 3; likewise to
	                     generate the sequence (1; 1; 4; 4; 7; 7; 10; 10; 13;
	                     13; ...) the increment is also 3.
	                  .
	 */
	@XmlElement(name = "increment", required = true, namespace = "urn:hl7-org:v3")
	public net.ihe.gazelle.hl7v3.datatypes.PQ increment;
	/**
	 * 
	                     The integer by which the index for the sequence is
	                     divided, effectively the number of times the sequence
	                     generates the same sequence item value before
	                     incrementing to the next sequence item value. For
	                     example, to generate the sequence (1; 1; 1; 2; 2; 2; 3; 3;
	                     3; ...)  the denominator is 3.
	                  .
	 */
	@XmlAttribute(name = "denominator")
	@jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter(net.ihe.gazelle.adapters.IntegerAdapter.class)
	public Integer denominator;
	/**
	 * 
	                     If non-NULL, specifies that the sequence alternates,
	                     i.e., after this many increments, the sequence item
	                     values roll over to start from the initial sequence
	                     item value. For example, the sequence (1; 2; 3; 1; 2;
	                     3; 1; 2; 3; ...) has period 3; also the sequence
	                     (1; 1; 2; 2; 3; 3; 1; 1; 2; 2; 3; 3; ...) has period
	                     3 too.
	                  .
	 */
	@XmlAttribute(name = "period")
	@jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter(net.ihe.gazelle.adapters.IntegerAdapter.class)
	public Integer period;
	
	/**
	 * An attribute containing marshalled element node
	 */
	@XmlTransient
	private org.w3c.dom.Node _xmlNodePresentation;
	
	
	/**
	 * Return head.
	 * @return head : 
	                     This is the start-value of the generated list. 
	 */
	public net.ihe.gazelle.hl7v3.datatypes.TS getHead() {
	    return head;
	}
	
	/**
	 * Set a value to attribute head.
	 * @param head : 
	                     This is the start-value of the generated list. 
	 */
	public void setHead(net.ihe.gazelle.hl7v3.datatypes.TS head) {
	    this.head = head;
	}
	
	
	
	
	/**
	 * Return increment.
	 * @return increment : 
	                     The difference between one value and its previous
	                     different value. For example, to generate the sequence
	                     (1; 4; 7; 10; 13; ...) the increment is 3; likewise to
	                     generate the sequence (1; 1; 4; 4; 7; 7; 10; 10; 13;
	                     13; ...) the increment is also 3.
	 */
	public net.ihe.gazelle.hl7v3.datatypes.PQ getIncrement() {
	    return increment;
	}
	
	/**
	 * Set a value to attribute increment.
	 * @param increment : 
	                     The difference between one value and its previous
	                     different value. For example, to generate the sequence
	                     (1; 4; 7; 10; 13; ...) the increment is 3; likewise to
	                     generate the sequence (1; 1; 4; 4; 7; 7; 10; 10; 13;
	                     13; ...) the increment is also 3.
	 */
	public void setIncrement(net.ihe.gazelle.hl7v3.datatypes.PQ increment) {
	    this.increment = increment;
	}
	
	
	
	
	/**
	 * Return denominator.
	 * @return denominator : 
	                     The integer by which the index for the sequence is
	                     divided, effectively the number of times the sequence
	                     generates the same sequence item value before
	                     incrementing to the next sequence item value. For
	                     example, to generate the sequence (1; 1; 1; 2; 2; 2; 3; 3;
	                     3; ...)  the denominator is 3.
	 */
	public Integer getDenominator() {
	    return denominator;
	}
	
	/**
	 * Set a value to attribute denominator.
	 * @param denominator : 
	                     The integer by which the index for the sequence is
	                     divided, effectively the number of times the sequence
	                     generates the same sequence item value before
	                     incrementing to the next sequence item value. For
	                     example, to generate the sequence (1; 1; 1; 2; 2; 2; 3; 3;
	                     3; ...)  the denominator is 3.
	 */
	public void setDenominator(Integer denominator) {
	    this.denominator = denominator;
	}
	
	
	
	
	/**
	 * Return period.
	 * @return period : 
	                     If non-NULL, specifies that the sequence alternates,
	                     i.e., after this many increments, the sequence item
	                     values roll over to start from the initial sequence
	                     item value. For example, the sequence (1; 2; 3; 1; 2;
	                     3; 1; 2; 3; ...) has period 3; also the sequence
	                     (1; 1; 2; 2; 3; 3; 1; 1; 2; 2; 3; 3; ...) has period
	                     3 too.
	 */
	public Integer getPeriod() {
	    return period;
	}
	
	/**
	 * Set a value to attribute period.
	 * @param period : 
	                     If non-NULL, specifies that the sequence alternates,
	                     i.e., after this many increments, the sequence item
	                     values roll over to start from the initial sequence
	                     item value. For example, the sequence (1; 2; 3; 1; 2;
	                     3; 1; 2; 3; ...) has period 3; also the sequence
	                     (1; 1; 2; 2; 3; 3; 1; 1; 2; 2; 3; 3; ...) has period
	                     3 too.
	 */
	public void setPeriod(Integer period) {
	    this.period = period;
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
					_xmlNodePresentation = doc.getElementsByTagNameNS("urn:hl7-org:v3", "GLIST_TS").item(0);
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
   public static void validateByModule(GLISTTS gLISTTS, String _location, ConstraintValidatorModule cvm, List<net.ihe.gazelle.validation.Notification> diagnostic){
   		if (gLISTTS != null){
   			net.ihe.gazelle.hl7v3.datatypes.ANY.validateByModule(gLISTTS, _location, cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.TS.validateByModule(gLISTTS.getHead(), _location + "/head", cvm, diagnostic);
			net.ihe.gazelle.hl7v3.datatypes.PQ.validateByModule(gLISTTS.getIncrement(), _location + "/increment", cvm, diagnostic);
    	}
    }

}