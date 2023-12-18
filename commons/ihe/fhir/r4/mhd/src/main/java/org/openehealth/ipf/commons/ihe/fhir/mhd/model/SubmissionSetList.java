/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openehealth.ipf.commons.ihe.fhir.mhd.model;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.util.ElementUtil;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Reference;

import java.util.ArrayList;
import java.util.List;

public class SubmissionSetList<T extends SubmissionSetList<T>> extends MhdList<T> {

    public SubmissionSetList() {
        super();
        setCode(new CodeableConcept().addCoding(SUBMISSIONSET_LIST_CODING));
    }

    @Child(name = "sourceId")
    @Extension(url = "https://profiles.ihe.net/ITI/MHD/StructureDefinition/ihe-sourceId", definedLocally = false)
    @Description(shortDefinition = "Publisher organization identity of the SubmissionSet")
    private Identifier sourceId;

    @Child(name = "intendedRecipient", max = Child.MAX_UNLIMITED)
    @Extension(url = "https://profiles.ihe.net/ITI/MHD/StructureDefinition/ihe-intendedRecipient", definedLocally = false)
    @Description(shortDefinition = "Intended recipient of the SubmissionSet")
    private List<Reference> intendedRecipient;

    @Override
    public boolean isEmpty() {
        return super.isEmpty() && ElementUtil.isEmpty(sourceId, intendedRecipient);
    }

    public Identifier getSourceId() {
        if (sourceId == null) {
            sourceId = new Identifier();
        }
        return sourceId;
    }

    @SuppressWarnings("unchecked")
    public T setSourceId(Identifier sourceId) {
        this.sourceId = sourceId;
        return (T)this;
    }

    public boolean hasSourceId() {
        return this.sourceId != null && !this.sourceId.isEmpty();
    }

    public List<Reference> getCitizenship() {
        if (intendedRecipient == null) {
            intendedRecipient = new ArrayList<>();
        }
        return intendedRecipient;
    }

    public Reference getIntendedRecipientFirstRep() {
        return this.getCitizenship().get(0);
    }

    @SuppressWarnings("unchecked")
    public T setIntendedRecipient(List<Reference> intendedRecipient) {
        this.intendedRecipient = intendedRecipient;
        return (T)this;
    }

    public Reference addIntendedRecipient() {
        var r = new Reference();
        if (this.intendedRecipient == null)
            this.intendedRecipient = new ArrayList<>();
        this.intendedRecipient.add(r);
        return r;
    }

    @SuppressWarnings("unchecked")
    public T addIntendedRecipient(Reference r) {
        if (r == null)
            return (T)this;
        if (this.intendedRecipient == null)
            this.intendedRecipient = new ArrayList<>();
        this.intendedRecipient.add(r);
        return (T)this;
    }

    @SuppressWarnings("unchecked")
    public T setSource(Source value) {
        super.setSource(value);
        return (T)this;
    }

    @SuppressWarnings("unchecked")
    public T linkDocumentReference(String fullUrl) {
        addEntry().setItem(new Reference(fullUrl));
        return (T)this;
    }

    public boolean hasIntendedRecipient() {
        if (this.intendedRecipient == null)
            return false;
        for (var item : this.intendedRecipient)
            if (!item.isEmpty())
                return true;
        return false;
    }

    private static final Coding SUBMISSIONSET_LIST_CODING = new Coding(
        "https://profiles.ihe.net/ITI/MHD/CodeSystem/MHDlistTypes",
        "submissionset",
        "submissionset"
    );
}