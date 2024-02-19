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

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.v25.datatype.*;
import ca.uhn.hl7v2.parser.DefaultEscaping;
import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.parser.Escaping;
import lombok.SneakyThrows;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.*;

/**
 * A renderer of HL7 v2 elements which considers XDS-specific
 * requirements regarding required and prohibited fields
 * as prescribed in the ITI TF Volume 3 Chapter 4.
 *
 * @author Dmytro Rud
 */
public abstract class XdsHl7v2Renderer {

    static final String XDS_VALIDATION_CP_1292_PROPERTY = "XDS_VALIDATION_CP_1292";

    /**
     * Encoding characters for HL7 v2 messages.
     */
    public static final EncodingCharacters ENCODING_CHARACTERS =
            new EncodingCharacters('|', '^', '~', '\\', '&', '#');
    public static final Escaping ESCAPING = new DefaultEscaping();

    /**
     * Map from HL7 class name to indices of fields allowed for rendering.
     * An optional modifier is the class name of the root XDS model object.
     * So the type of the key is a tuple [HL7 class name, XDS class name].
     * <p>
     * Querying algorithm when rendering an HL7 element C which is
     * contained (directly or indirectly) in an XDS model object T:
     * <ol>
     *      <li> Try to retrieve indices for [C class name, null].
     *      <li> When step 1 fails, try to retrieve indices for [C class name, T class name].
     *      <li> When step 2 fails, assume that all fields of C are allowed.
     * </ol>
     * <p>
     * Note that the indices are one-based, as in the HL7 and IHE documentation.
     */
    private static final Map<String, Collection<Integer>> INCLUSIONS = new HashMap<>();

    private static void addInclusion(
            Class<? extends Composite> hl7Class,
            Class<? extends Hl7v2Based> xdsClass,
            int... fieldNumbers)
    {
        var collection = new HashSet<Integer>(fieldNumbers.length);
        for (var number : fieldNumbers) {
            collection.add(number - 1);
        }
        var key = new StringBuilder(hl7Class.getSimpleName());
        if (xdsClass != null) {
            key.append('\n').append(xdsClass.getSimpleName());
        }
        INCLUSIONS.put(key.toString(), collection);
    }

    static {
        addInclusion(CE.class,  null,                        1, 3);
        addInclusion(CX.class,  Identifiable.class,          1, 4);
        if (isCP1292ValidationEnabled()) {
            addInclusion(CX.class, ReferenceId.class, 1, 4, 5, 6);
        } else {
            addInclusion(CX.class, ReferenceId.class, 1, 4, 5);
        }
        addInclusion(HD.class,  AssigningAuthority.class,    2, 3);
        addInclusion(HD.class,  CXiAssigningAuthority.class, 1, 2, 3);
        addInclusion(HD.class,  Identifiable.class,          2, 3);
        addInclusion(HD.class,  ReferenceId.class,           1, 2, 3);
        addInclusion(XON.class, null,                        1, 6, 10);
        addInclusion(XTN.class, null,                        2, 3, 4, 5, 6, 7, 8, 12);
    }

    private static boolean isCP1292ValidationEnabled() {
        String cp1292Value = System.getProperty(XDS_VALIDATION_CP_1292_PROPERTY, "false");
        return BooleanUtils.toBoolean(cp1292Value);
    }

    private XdsHl7v2Renderer() {
        throw new IllegalStateException("cannot instantiate helper class");
    }

    @SneakyThrows
    public static boolean isEmpty(Hl7v2Based hl7v2based) {
        return isEmpty(hl7v2based.getHapiObject(), "\n" + hl7v2based.getClass().getSimpleName());
    }

    private static boolean isEmpty(Composite composite, String keyModifier) throws HL7Exception {
        var fields = composite.getComponents();

        var key = composite.getClass().getSimpleName();
        var inclusions = INCLUSIONS.get(key);
        if (inclusions == null) {
            inclusions = INCLUSIONS.get(key + keyModifier);
        }

        for (var i = 0; i < fields.length; ++i) {
            if ((inclusions == null) || inclusions.contains(i)) {
                if (fields[i] instanceof Composite) {
                    if (!isEmpty((Composite) fields[i], keyModifier)) {
                        return false;
                    }
                } else if (fields[i] instanceof Primitive) {
                    if (!fields[i].isEmpty()) {
                        return false;
                    }
                } else {
                    // actually, this line should be unreachable
                    throw new IllegalStateException("Don't know how to handle " + fields[i]);
                }
            }
        }

        return true;
    }

    /**
     * Encodes the given HL7-based XDS model object using specific
     * rules regarding required and prohibited HL7 fields.
     * @param hl7v2based
     *      source HL7-based XDS object model to be rendered.
     * @return
     *      String representation of the given HL7 v2 composite field.
     */
    public static String encode(Hl7v2Based hl7v2based) {
        return encodeComposite(
                hl7v2based.getHapiObject(),
                "\n" + hl7v2based.getClass().getSimpleName(),
                ENCODING_CHARACTERS.getComponentSeparator());
    }


    private static String encodeComposite(Composite composite, String keyModifier, char delimiter) {
        var sb = new StringBuilder();
        var fields = composite.getComponents();

        var key = composite.getClass().getSimpleName();
        var inclusions = INCLUSIONS.get(key);
        if (inclusions == null) {
            inclusions = INCLUSIONS.get(key + keyModifier);
        }

        for (var i = 0; i < fields.length; ++i) {
            if ((inclusions == null) || inclusions.contains(i)) {
                if (fields[i] instanceof Composite) {
                    sb.append(encodeComposite((Composite) fields[i], keyModifier, ENCODING_CHARACTERS.getSubcomponentSeparator()));
                } else if (fields[i] instanceof Primitive) {
                    sb.append(encodePrimitive((Primitive) fields[i]));
                } else {
                    // actually, this line should be unreachable
                    throw new IllegalStateException("Don't know how to handle " + fields[i]);
                }
            }
            sb.append(delimiter);
        }

        return StringUtils.stripEnd(sb.toString(), String.valueOf(delimiter));
    }


    private static String encodePrimitive(Primitive p) {
        var value = p.getValue();
        return (value == null) ? "" : ESCAPING.escape(value, ENCODING_CHARACTERS);
    }

}
