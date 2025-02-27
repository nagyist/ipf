/*
 * Copyright 2016 the original author or authors.
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

package org.openehealth.ipf.commons.ihe.fhir.iti65;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.support.DefaultProfileValidationSupport;
import ca.uhn.fhir.context.support.IValidationSupport;
import ca.uhn.fhir.context.support.ValidationSupportContext;
import ca.uhn.fhir.rest.api.EncodingEnum;
import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import org.hl7.fhir.common.hapi.validation.support.*;
import org.hl7.fhir.common.hapi.validation.validator.FhirInstanceValidator;
import org.hl7.fhir.r4.model.Binary;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.DocumentManifest;
import org.hl7.fhir.r4.model.DocumentReference;
import org.hl7.fhir.r4.model.ListResource;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.ResourceType;
import org.hl7.fhir.r4.model.StructureDefinition;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionValidator;
import org.openehealth.ipf.commons.ihe.fhir.mhd.Mhd421;
import org.openehealth.ipf.commons.ihe.fhir.support.FhirUtils;
import org.openehealth.ipf.commons.ihe.xds.core.responses.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;

import static org.openehealth.ipf.commons.ihe.fhir.mhd.MhdProfile.*;

/**
 * Validator for ITI-65 transactions.
 *
 * THIS does not work properly yet!
 *
 * @author Christian Ohr
 * @since 3.6
 */
public class Iti65Validator extends FhirTransactionValidator.Support {

    private static final Logger log = LoggerFactory.getLogger(Iti65Validator.class);
    private static final String IHE_PROFILE_PREFIX = "http://ihe.net/fhir/StructureDefinition/";

    private final FhirContext fhirContext;
    private IValidationSupport validationSupportv320;

    public Iti65Validator(FhirContext fhirContext) {
        this.fhirContext = fhirContext;
        log.info("Initializing Validator for ITI-65 bundles");
        validationSupportv320 = loadStructureDefinitionsv320(new DefaultProfileValidationSupport(fhirContext), "Minimal");
        validationSupportv320 = loadStructureDefinitionsv320(validationSupportv320, "Comprehensive");
        log.info("Initialized Validator for ITI-65 bundles");
    }

    @Override
    public void validateRequest(Object payload, Map<String, Object> parameters) {

        var transactionBundle = (Bundle) payload;
        if (transactionBundle instanceof Mhd421) {
            validateBundleConsistency421(transactionBundle);
        } else {
            validateBundleConsistency320(transactionBundle);
        }

        var validator = fhirContext.newValidator();
        validator.setValidateAgainstStandardSchema(false);
        validator.setValidateAgainstStandardSchematron(false);
        var instanceValidator = new FhirInstanceValidator(validationSupportv320);
        instanceValidator.setNoTerminologyChecks(false);
        instanceValidator.setErrorForUnknownProfiles(true);
        instanceValidator.setBestPracticeWarningLevel(BestPracticeWarningLevel.Hint);
        validator.registerValidatorModule(instanceValidator);
        var validationResult = validator.validateWithResult(transactionBundle);
        if (!validationResult.isSuccessful()) {
            var operationOutcome = validationResult.toOperationOutcome();
            throw FhirUtils.exception(UnprocessableEntityException::new, operationOutcome, "Validation Failed");
        }
    }

    public ValidationSupportChain loadStructureDefinitionsv320(IValidationSupport baseValidationSupport, String kind) {
        var validationSupport = new PrePopulatedValidationSupport(fhirContext);
        var supportChain = new ValidationSupportChain(
                validationSupport,
                baseValidationSupport,
                new InMemoryTerminologyServerValidationSupport(baseValidationSupport.getFhirContext()),
                new CommonCodeSystemsTerminologyService(baseValidationSupport.getFhirContext()));
        findProfile(supportChain, String.format("IHE_MHD_%s_List", kind))
                .ifPresent(validationSupport::addStructureDefinition);
        findProfile(supportChain, String.format("IHE_MHD_Provide_%s_DocumentReference", kind))
                .ifPresent(validationSupport::addStructureDefinition);
        findProfile(supportChain, String.format("IHE_MHD_Query_%s_DocumentReference", kind))
                .ifPresent(validationSupport::addStructureDefinition);
        findProfile(supportChain, String.format("IHE_MHD_%s_DocumentManifest", kind))
                .ifPresent(validationSupport::addStructureDefinition);
        findProfile(supportChain, String.format("IHE_MHD_Provide_%s_DocumentBundle", kind))
                .ifPresent(validationSupport::addStructureDefinition);
        return supportChain;
    }

    private Optional<StructureDefinition> findProfile(
            ValidationSupportChain snaphotGenerationSupport,
            String name) {
        var path = "META-INF/profiles/320/" + name + ".xml";
        var url = IHE_PROFILE_PREFIX + name;
        var is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        if (is != null) {
            try (var scanner = new Scanner(is, StandardCharsets.UTF_8)) {
                var profileText = scanner.useDelimiter("\\A").next();
                var parser = EncodingEnum.detectEncodingNoDefault(profileText).newParser(fhirContext);
                var structureDefinition = parser.parseResource(StructureDefinition.class, profileText);
                return Optional.of(structureDefinition.hasSnapshot() ?
                    structureDefinition :
                    (StructureDefinition) new SnapshotGeneratingValidationSupport(fhirContext).generateSnapshot(
                                new ValidationSupportContext(snaphotGenerationSupport), structureDefinition, url, url,
                                name));
            }
        }
        return Optional.empty();
    }


    /**
     * Verifies that bundle has expected content and consistent patient references
     *
     * @param bundle transaction bundle
     */
    protected void validateBundleConsistency320(Bundle bundle) {

        var entries = FhirUtils.getBundleEntries(bundle);

        // Verify that the bundle has all required resources
        // This should be done by the StructureDefinition, but apparently HAPI has a problem with slices...

        if (entries.getOrDefault(ResourceType.DocumentManifest, Collections.emptyList()).size() != 1) {
            throw FhirUtils.unprocessableEntity(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.INVALID,
                    null, null,
                    "Request bundle must have exactly one DocumentManifest"
            );
        }
        if (entries.getOrDefault(ResourceType.DocumentReference, Collections.emptyList()).isEmpty()) {
            throw FhirUtils.unprocessableEntity(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.INVALID,
                    null, null,
                    "Request bundle must have at least one DocumentReference"
            );
        }


        var patientReferences = new HashSet<String>();
        var expectedBinaryFullUrls = new HashSet<String>();
        var expectedReferenceFullUrls = new HashSet<String>();
        entries.values().stream()
                .flatMap(Collection::stream)
                .map(Bundle.BundleEntryComponent::getResource)
                .forEach(resource -> {
                    if (resource instanceof DocumentManifest dm) {
                        for (var content : dm.getContent()) {
                            try {
                                expectedReferenceFullUrls.add(content.getReference());
                            } catch (Exception ignored) {
                            }
                        }
                        patientReferences.add(getSubjectReference(dm, DocumentManifest::getSubject));
                    } else if (resource instanceof DocumentReference dr) {
                        for (var content : dr.getContent()) {
                            var url = content.getAttachment().getUrl();
                            if (!url.startsWith("http")) {
                                expectedBinaryFullUrls.add(url);
                            }
                        }
                        patientReferences.add(getSubjectReference(dr, DocumentReference::getSubject));
                    } else if (resource instanceof ListResource listResource) {
                        patientReferences.add(getSubjectReference(listResource, ListResource::getSubject));
                    } else if (!(resource instanceof Binary)) {
                        throw FhirUtils.unprocessableEntity(
                                OperationOutcome.IssueSeverity.ERROR,
                                OperationOutcome.IssueType.INVALID,
                                null, null,
                                "Unexpected bundle component %s",
                                resource.getClass().getSimpleName()
                        );
                    }
                });

        if (patientReferences.size() != 1) {
            throw FhirUtils.unprocessableEntity(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.INVALID,
                    ErrorCode.PATIENT_ID_DOES_NOT_MATCH.getOpcode(),
                    null,
                    "Inconsistent patient references %s",
                    patientReferences
            );
        }

        entries.values().stream()
                .flatMap(Collection::stream)
                .forEach(entry -> {
                    if (ResourceType.DocumentReference == entry.getResource().getResourceType()) {
                        if (!expectedReferenceFullUrls.remove(entry.getFullUrl())) {
                            throw FhirUtils.unprocessableEntity(
                                    OperationOutcome.IssueSeverity.ERROR,
                                    OperationOutcome.IssueType.INVALID,
                                    null, null,
                                    "DocumentReference with URL %s is not referenced by any DocumentManifest",
                                    entry.getFullUrl()
                            );
                        }
                    } else if (ResourceType.Binary == entry.getResource().getResourceType()) {
                        if (!expectedBinaryFullUrls.remove(entry.getFullUrl())) {
                            throw FhirUtils.unprocessableEntity(
                                    OperationOutcome.IssueSeverity.ERROR,
                                    OperationOutcome.IssueType.INVALID,
                                    null, null,
                                    "Binary with URL %s is not referenced by any DocumentReference",
                                    entry.getFullUrl()
                            );
                        }
                    }
                });

        if (!expectedBinaryFullUrls.isEmpty()) {
            throw FhirUtils.unprocessableEntity(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.INVALID,
                    null, null,
                    "Binary with URLs %s referenced, but not present in this bundle",
                    expectedBinaryFullUrls
            );
        }

        if (!expectedReferenceFullUrls.isEmpty()) {
            throw FhirUtils.unprocessableEntity(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.INVALID,
                    null, null,
                    "DocumentReference with URLs %s referenced, but not present in this bundle",
                    expectedReferenceFullUrls
            );
        }

    }

    /**
     * Verifies that bundle has expected content and consistent patient references
     *
     * @param bundle transaction bundle
     */
    protected void validateBundleConsistency421(Bundle bundle) {

        var entries = FhirUtils.getBundleEntries(bundle);

        // Verify that the bundle has all required resources
        // This should be done by the StructureDefinition, but apparently HAPI has a problem with slices...
        // TODO check

        var submissionSets = entries.getOrDefault(ResourceType.List, Collections.emptyList()).stream()
            .map(Bundle.BundleEntryComponent::getResource)
            .map(ListResource.class::cast)
            .filter(this::isListSubmissionSet)
            .toList();
        if (submissionSets.size() != 1) {
            throw FhirUtils.unprocessableEntity(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                null, null,
                "Request bundle must have exactly one SubmissionSet list"
            );
        }
        if (entries.getOrDefault(ResourceType.DocumentReference, Collections.emptyList()).isEmpty()) {
            throw FhirUtils.unprocessableEntity(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                null, null,
                "Request bundle must have at least one DocumentReference"
            );
        }


        var patientReferences = new HashSet<String>();
        var expectedBinaryFullUrls = new HashSet<String>();
        var expectedReferenceFullUrls = new HashSet<String>();
        entries.values().stream()
            .flatMap(Collection::stream)
            .map(Bundle.BundleEntryComponent::getResource)
            .forEach(resource -> {
                if (resource instanceof ListResource listResource) {
                    if (isListSubmissionSet(listResource)) {
                        for (var entry : listResource.getEntry()) {
                            try {
                                expectedReferenceFullUrls.add(entry.getItem().getReference());
                            } catch (Exception ignored) {
                            }
                        }
                    }
                    patientReferences.add(getSubjectReference(listResource, ListResource::getSubject));
                } else if (resource instanceof DocumentReference dr) {
                    for (var content : dr.getContent()) {
                        var url = content.getAttachment().getUrl();
                        if (!url.startsWith("http")) {
                            expectedBinaryFullUrls.add(url);
                        }
                    }
                    patientReferences.add(getSubjectReference(dr, DocumentReference::getSubject));
                } else if (!(resource instanceof Binary)) {
                    throw FhirUtils.unprocessableEntity(
                        OperationOutcome.IssueSeverity.ERROR,
                        OperationOutcome.IssueType.INVALID,
                        null, null,
                        "Unexpected bundle component %s",
                        resource.getClass().getSimpleName()
                    );
                }
            });

        if (patientReferences.size() != 1) {
            throw FhirUtils.unprocessableEntity(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                ErrorCode.PATIENT_ID_DOES_NOT_MATCH.getOpcode(),
                null,
                "Inconsistent patient references %s",
                patientReferences
            );
        }

        entries.values().stream()
            .flatMap(Collection::stream)
            .forEach(entry -> {
                if (ResourceType.DocumentReference == entry.getResource().getResourceType()) {
                    if (!expectedReferenceFullUrls.remove(entry.getFullUrl())) {
                        throw FhirUtils.unprocessableEntity(
                            OperationOutcome.IssueSeverity.ERROR,
                            OperationOutcome.IssueType.INVALID,
                            null, null,
                            "DocumentReference with URL %s is not referenced by any SubmissionSet list",
                            entry.getFullUrl()
                        );
                    }
                } else if (ResourceType.Binary == entry.getResource().getResourceType()) {
                    if (!expectedBinaryFullUrls.remove(entry.getFullUrl())) {
                        throw FhirUtils.unprocessableEntity(
                            OperationOutcome.IssueSeverity.ERROR,
                            OperationOutcome.IssueType.INVALID,
                            null, null,
                            "Binary with URL %s is not referenced by any DocumentReference",
                            entry.getFullUrl()
                        );
                    }
                }
            });

        if (!expectedBinaryFullUrls.isEmpty()) {
            throw FhirUtils.unprocessableEntity(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                null, null,
                "Binary with URLs %s referenced, but not present in this bundle",
                expectedBinaryFullUrls
            );
        }

        if (!expectedReferenceFullUrls.isEmpty()) {
            throw FhirUtils.unprocessableEntity(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                null, null,
                "DocumentReference with URLs %s referenced, but not present in this bundle",
                expectedReferenceFullUrls
            );
        }

    }

    private boolean isListSubmissionSet(ListResource listResource) {
        return COMPREHENSIVE_SUBMISSIONSET_TYPE_LIST.hasProfile(listResource) ||
            MINIMAL_SUBMISSIONSET_TYPE_LIST.hasProfile(listResource) ||
            UNCONTAINED_COMPREHENSIVE_SUBMISSIONSET_TYPE_LIST.hasProfile(listResource);
    }

    private <T extends Resource> String getSubjectReference(T resource, Function<T, Reference> f) {
        var reference = f.apply(resource);
        if (reference == null) {
            throw FhirUtils.unprocessableEntity(
                    OperationOutcome.IssueSeverity.ERROR,
                    OperationOutcome.IssueType.INVALID,
                    ErrorCode.UNKNOWN_PATIENT_ID.getOpcode(),
                    null,
                    "Empty Patient reference in resource %s",
                    resource
            );
        }
        // Could be contained resources
        if (reference.getResource() != null) {
            var patient = (Patient) reference.getResource();
            return patient.getIdentifier().get(0).getValue();
        }
        return reference.getReference();
    }


}
