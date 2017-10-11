
package org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for ErrorResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ErrorResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="detail" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;any/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="requestID" type="{urn:oasis:names:tc:DSML:2:0:core}RequestID" /&gt;
 *       &lt;attribute name="type"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="notAttempted"/&gt;
 *             &lt;enumeration value="couldNotConnect"/&gt;
 *             &lt;enumeration value="connectionClosed"/&gt;
 *             &lt;enumeration value="malformedRequest"/&gt;
 *             &lt;enumeration value="gatewayInternalError"/&gt;
 *             &lt;enumeration value="authenticationFailed"/&gt;
 *             &lt;enumeration value="unresolvableURI"/&gt;
 *             &lt;enumeration value="other"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ErrorResponse", propOrder = {
    "message",
    "detail"
})
public class ErrorResponse {

    protected String message;
    protected ErrorResponse.Detail detail;
    @XmlAttribute(name = "requestID")
    protected String requestID;
    @XmlAttribute(name = "type")
    protected ErrorResponse.ErrorType type;

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the detail property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorResponse.Detail }
     *     
     */
    public ErrorResponse.Detail getDetail() {
        return detail;
    }

    /**
     * Sets the value of the detail property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorResponse.Detail }
     *     
     */
    public void setDetail(ErrorResponse.Detail value) {
        this.detail = value;
    }

    /**
     * Gets the value of the requestID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestID() {
        return requestID;
    }

    /**
     * Sets the value of the requestID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestID(String value) {
        this.requestID = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorResponse.ErrorType }
     *     
     */
    public ErrorResponse.ErrorType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorResponse.ErrorType }
     *     
     */
    public void setType(ErrorResponse.ErrorType value) {
        this.type = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;any/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class Detail {

        @XmlAnyElement(lax = true)
        protected Object any;

        /**
         * Gets the value of the any property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getAny() {
            return any;
        }

        /**
         * Sets the value of the any property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setAny(Object value) {
            this.any = value;
        }

    }


    /**
     * <p>Java class for null.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <pre>
     * &lt;simpleType>
     *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *     &lt;enumeration value="notAttempted"/>
     *     &lt;enumeration value="couldNotConnect"/>
     *     &lt;enumeration value="connectionClosed"/>
     *     &lt;enumeration value="malformedRequest"/>
     *     &lt;enumeration value="gatewayInternalError"/>
     *     &lt;enumeration value="authenticationFailed"/>
     *     &lt;enumeration value="unresolvableURI"/>
     *     &lt;enumeration value="other"/>
     *   &lt;/restriction>
     * &lt;/simpleType>
     * </pre>
     * 
     */
    @XmlType(name = "")
    @XmlEnum
    public enum ErrorType {

        @XmlEnumValue("notAttempted")
        NOT_ATTEMPTED("notAttempted"),
        @XmlEnumValue("couldNotConnect")
        COULD_NOT_CONNECT("couldNotConnect"),
        @XmlEnumValue("connectionClosed")
        CONNECTION_CLOSED("connectionClosed"),
        @XmlEnumValue("malformedRequest")
        MALFORMED_REQUEST("malformedRequest"),
        @XmlEnumValue("gatewayInternalError")
        GATEWAY_INTERNAL_ERROR("gatewayInternalError"),
        @XmlEnumValue("authenticationFailed")
        AUTHENTICATION_FAILED("authenticationFailed"),
        @XmlEnumValue("unresolvableURI")
        UNRESOLVABLE_URI("unresolvableURI"),
        @XmlEnumValue("other")
        OTHER("other");
        private final String value;

        ErrorType(String v) {
            value = v;
        }

        public String value() {
            return value;
        }

        public static ErrorResponse.ErrorType fromValue(String v) {
            for (ErrorResponse.ErrorType c: ErrorResponse.ErrorType.values()) {
                if (c.value.equals(v)) {
                    return c;
                }
            }
            throw new IllegalArgumentException(v);
        }

    }

}
