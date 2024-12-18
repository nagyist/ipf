/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openehealth.ipf.commons.ihe.xds.core.metadata;

import static java.util.Objects.requireNonNull;

import java.io.Serial;
import java.io.Serializable;

import ca.uhn.hl7v2.Location;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.MessageVisitor;
import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.v25.datatype.HD;
import ca.uhn.hl7v2.model.v25.message.ACK;
import ca.uhn.hl7v2.parser.PipeParser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import jakarta.xml.bind.annotation.XmlTransient;

/**
 * An XDS model object backed up by an HL7 v2 element.
 * @param <C>
 *     HAPI composite type which corresponds to the HL7 v2 element.
 *
 * @author Dmytro Rud
 */
@XmlTransient
abstract public class Hl7v2Based<C extends Composite> implements Serializable {
    @Serial
    private static final long serialVersionUID = 5463666004063275303L;

    protected static final Message MESSAGE;
    static {
        MESSAGE = new ACK();
        MESSAGE.getParser().getParserConfiguration().setValidating(false);
    }


    private final C hapiObject;


    /**
     * Default constructor, for serialization purposes only.
     */
    protected Hl7v2Based() {
        throw new IllegalStateException("this default constructor is defined only to satisfy JAXB requirements");
    }


    /**
     * Constructor.
     * @param hapiObject
     *      HAPI composite object.
     */
    protected Hl7v2Based(C hapiObject) {
        this.hapiObject = requireNonNull(hapiObject, "HAPI object");
    }


    /**
     * Parses the given HL7 v2 element into an XDS simplified model object.
     * @param hl7String
     *      HL7 v2 element as a String.
     * @param xdsModelClass
     *      class of the XDS model object to be generates.
     * @param <C>
     *      class of HAPI composite object which should hold the HL7 element.
     * @param <T>
     *      class of XDS model object.
     * @return
     *      generated XDS model object or <code>null</code> when the given
     *      HL7 v2 element is <code>null</code> or empty.
     */
    @SneakyThrows
    public static <C extends Composite, T extends Hl7v2Based<C>> T parse(
            String hl7String,
            Class<T> xdsModelClass)
    {
        if (StringUtils.isEmpty(hl7String)) {
            return null;
        }
        var xdsModelObject = xdsModelClass.getConstructor().newInstance();
        MESSAGE.getParser().parse(xdsModelObject.getHapiObject(), hl7String, XdsHl7v2Renderer.ENCODING_CHARACTERS);
        return xdsModelObject.isEmpty() ? null : xdsModelObject;
    }


    /**
     * Renders this XDS model object using the XDS-specific
     * {@link XdsHl7v2Renderer HL7 v2 renderer},
     * i.e. with applying IHE TF rules regarding unwanted components.
     * @return
     *      HL7 v2 representation of this XDS model object, may be an empty String.
     */
    protected String render() {
        return XdsHl7v2Renderer.encode(this);
    }


    /**
     * Renders the given XDS model object as an HL7 v2 element according to the
     * XDS specification, i.e. with applying IHE TF rules regarding unwanted components.
     *
     * @param xdsModelObject
     *      XDS model object.
     * @return
     *      HL7 v2 representation of the given object, or <code>null</code>
     *      when the given object is <code>null</code> or empty.
     */
    public static String render(Hl7v2Based xdsModelObject) {
        return (xdsModelObject != null) ? StringUtils.trimToNull(xdsModelObject.render()) : null;
    }


    /**
     * Renders the given XDS model object as an HL7 v2 element
     * without applying IHE TF rules regarding unwanted components.
     *
     * @param xdsModelObject
     *      XDS model object.
     * @return
     *      HL7 v2 representation of the given object, or an empty string
     *      when the given object is <code>null</code> or empty.
     */
    public static String rawRender(Hl7v2Based xdsModelObject) {
        return (xdsModelObject != null)
                ? PipeParser.encode(xdsModelObject.getHapiObject(), XdsHl7v2Renderer.ENCODING_CHARACTERS)
                : "";
    }


    /**
     * @return
     *      <code>true</code> if this XDS model object does not contain any usable data.
     */
    @JsonIgnore
    public boolean isEmpty() {
        return XdsHl7v2Renderer.isEmpty(this);
    }


    /**
     * @return
     *      HAPI composite holding the HL7 v2 element
     *      which corresponds to this XDS model object.
     */
    @JsonIgnore
    public C getHapiObject() {
        return hapiObject;
    }


    @SneakyThrows
    protected static void setValue(Primitive p, String value) {
        if (value == null) {
            p.clear();
        } else {
            p.setValue(value);
        }
    }

    protected static void setValue(Primitive p, Integer value) {
        setValue(p, (value == null) ? null : value.toString());
    }

    protected static Integer getIntegerValue(Primitive p) {
        var value = p.getValue();
        return (StringUtils.isEmpty(value) || "\"\"".equals(value)) ? null : Integer.parseInt(value);
    }

    protected static Long getLongValue(Primitive p) {
        var value = p.getValue();
        return (StringUtils.isEmpty(value) || "\"\"".equals(value)) ? null : Long.parseLong(value);
    }

    /**
     * Helper method used for copying data elements of an assigning authority.
     * @param assigningAuthority
     *      source assigning authority.
     * @param target
     *      target HL7 v2 HD element.
     */
    protected static void setAssigningAuthority(AssigningAuthority assigningAuthority, HD target) {
        if (assigningAuthority != null) {
            var source = assigningAuthority.getHapiObject().getInternal();
            setValue(target.getHd1_NamespaceID(), source.getHd1_NamespaceID().getValue());
            setValue(target.getHd2_UniversalID(), source.getHd2_UniversalID().getValue());
            setValue(target.getHd3_UniversalIDType(), source.getHd3_UniversalIDType().getValue());
        } else {
            target.clear();
        }
    }


    /**
     * Fake enclosing element for an HL7 v2 sub-component, necessary for correct rendering and parsing.
     */
    public static class Holder<T extends Type> extends AbstractType implements Composite {
        @Serial
        private static final long serialVersionUID = -9084300955263787034L;

        private final Type[] data = new Type[1];

        public Holder(T t) {
            super(t.getMessage());
            data[0] = t;
        }

        @SuppressWarnings("unchecked")
        public T getInternal() {
            return (T) data[0];
        }

        @Override
        public Type[] getComponents() {
            return this.data;
        }

        @Override
        public Type getComponent(int number) throws DataTypeException {
            try {
                return data[number];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DataTypeException("please do not use this class");
            }
        }

        @Override
        public boolean accept(MessageVisitor visitor, Location currentLocation) {
            return false;
        }
    }

}
