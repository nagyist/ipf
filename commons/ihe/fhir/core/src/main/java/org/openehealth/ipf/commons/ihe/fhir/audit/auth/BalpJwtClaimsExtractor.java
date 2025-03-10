package org.openehealth.ipf.commons.ihe.fhir.audit.auth;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.Getter;
import org.openehealth.ipf.commons.audit.BalpJwtExtractorProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class BalpJwtClaimsExtractor {

    private static final Logger log = LoggerFactory.getLogger(BalpJwtClaimsExtractor.class);

    public Optional<String> extractId(JWT jwt, BalpJwtExtractorProperties balpJwtExtractorProperties) {
        return Optional.ofNullable(extractStringClaimFromJWT(jwt, balpJwtExtractorProperties.getIdPath()));
    }

    public Optional<String> extractClientId(JWT jwt, BalpJwtExtractorProperties balpJwtExtractorProperties) {
        return Optional.ofNullable(extractStringClaimFromJWT(jwt, balpJwtExtractorProperties.getClientIdPath()));
    }

    public Optional<String> extractSubject(JWT jwt, BalpJwtExtractorProperties balpJwtExtractorProperties) {
        return Optional.ofNullable(extractStringClaimFromJWT(jwt, balpJwtExtractorProperties.getSubjectPath()));
    }

    public Optional<String> extractIssuer(JWT jwt, BalpJwtExtractorProperties balpJwtExtractorProperties) {
        return Optional.ofNullable(extractStringClaimFromJWT(jwt, balpJwtExtractorProperties.getIssuerPath()));
    }

    public Optional<String> extractSubjectName(JWT jwt, BalpJwtExtractorProperties balpJwtExtractorProperties) {
        return Optional.ofNullable(extractStringClaimFromJWT(jwt, balpJwtExtractorProperties.getSubjectNamePath()));
    }

    public Optional<String> extractSubjectOrganization(JWT jwt, BalpJwtExtractorProperties balpJwtExtractorProperties) {
        return Optional.ofNullable(extractStringClaimFromJWT(jwt, balpJwtExtractorProperties.getSubjectOrganizationPath()));
    }

    public Optional<String> extractSubjectOrganizationId(JWT jwt, BalpJwtExtractorProperties balpJwtExtractorProperties) {
        return Optional.ofNullable(extractStringClaimFromJWT(jwt, balpJwtExtractorProperties.getSubjectOrganizationIdPath()));
    }

    public Optional<Set<String>> extractSubjectRole(JWT jwt, BalpJwtExtractorProperties balpJwtExtractorProperties) {
        return Optional.ofNullable(extractListClaimFromJWT(jwt, balpJwtExtractorProperties.getSubjectRolePath()));
    }

    public Optional<Set<String>> extractPurposeOfUse(JWT jwt, BalpJwtExtractorProperties balpJwtExtractorProperties) {
        return Optional.ofNullable(extractListClaimFromJWT(jwt, balpJwtExtractorProperties.getPurposeOfUsePath()));
    }

    public Optional<String> extractHomeCommunityId(JWT jwt, BalpJwtExtractorProperties balpJwtExtractorProperties) {
        return Optional.ofNullable(extractStringClaimFromJWT(jwt, balpJwtExtractorProperties.getHomeCommunityIdPath()));
    }

    public Optional<String> extractNationalProviderIdentifier(JWT jwt, BalpJwtExtractorProperties balpJwtExtractorProperties) {
        return Optional.ofNullable(extractStringClaimFromJWT(jwt, balpJwtExtractorProperties.getNationalProviderIdPath()));
    }

    public Optional<String> extractPersonId(JWT jwt, BalpJwtExtractorProperties balpJwtExtractorProperties) {
        return Optional.ofNullable(extractStringClaimFromJWT(jwt, balpJwtExtractorProperties.getPersonIdPath()));
    }

    public Optional<String> extractBppcPatientId(JWT jwt, BalpJwtExtractorProperties balpJwtExtractorProperties) {
        return Optional.ofNullable(extractStringClaimFromJWT(jwt, balpJwtExtractorProperties.getPatientIdPath()));
    }

    public Optional<String> extractBppcDocId(JWT jwt, BalpJwtExtractorProperties balpJwtExtractorProperties) {
        return Optional.ofNullable(extractStringClaimFromJWT(jwt, balpJwtExtractorProperties.getDocIdPath()));
    }

    public Optional<String> extractBppcAcp(JWT jwt, BalpJwtExtractorProperties balpJwtExtractorProperties) {
        return Optional.ofNullable(extractStringClaimFromJWT(jwt, balpJwtExtractorProperties.getAcpPath()));
    }

    private String extractStringClaimFromJWT(JWT jwt, String[] expressions){
        var finalClaimForExpression = getFinalClaimSet(jwt, expressions);
        if (finalClaimForExpression.isPresent()) {
            var claimsSet = finalClaimForExpression.get().jwtClaimsSet();
            var expression = finalClaimForExpression.get().expression();
            try {
                return claimsSet.getStringClaim(expression);
            } catch (ParseException pe) {
                log.warn("Not string claims present for expression key '{}'", expression, pe);
            }
        }
        return null;
    }

    private Set<String> extractListClaimFromJWT(JWT jwt, String[] expressions){
        var finalClaimForExpression = getFinalClaimSet(jwt, expressions);
        if (finalClaimForExpression.isPresent()) {
            var claimsSet = finalClaimForExpression.get().jwtClaimsSet();
            var expression = finalClaimForExpression.get().expression();
            try {
                var values = claimsSet.getListClaim(expression);
                if (values != null && !values.isEmpty()) {
                    return values.stream().map(Objects::toString).collect(Collectors.toSet());
                }
            } catch (ParseException pe) {
                log.warn("Not list claims present for expression key '{}'", expression, pe);
            }
        }
        return null;
    }

    private Optional<ClaimSetPair> getFinalClaimSet(JWT jwt, String[] expressions) {
        if (expressions == null) {
            return Optional.empty();
        }
        for (var expression: expressions) {
            try {
                if (expression.contains(":")) {
                    var extracted = jwt.getJWTClaimsSet();
                    var structure = List.of(expression.split("\\:"));
                    Iterator<String> structureIterator = structure.listIterator();
                    String subExpression = null;
                    while (structureIterator.hasNext()) {
                        subExpression = structureIterator.next();
                        if (structureIterator.hasNext()) {
                            if (!containsClaim(extracted, subExpression)) {
                                break;
                            }
                            extracted = JWTClaimsSet.parse(extracted.getJSONObjectClaim(subExpression));
                        }
                    }
                    if (extracted != null && isNotBlank(subExpression) &&
                        extracted.getClaims().containsKey(subExpression)) {
                        return Optional.of(new ClaimSetPair(subExpression, extracted));
                    }
                } else {
                    if (jwt.getJWTClaimsSet().getClaims().containsKey(expression)) {
                        return Optional.of(new ClaimSetPair(expression, jwt.getJWTClaimsSet()));
                    }
                }
            } catch (ParseException pe) {
                log.debug("Not claimset present for expression key: {}", pe.getMessage());
            }
        }
        return Optional.empty();
    }

    private boolean containsClaim(JWTClaimsSet claimsSet, String name) {
        return claimsSet.getClaim(name) != null;
    }

    private record ClaimSetPair(@Getter String expression, @Getter JWTClaimsSet jwtClaimsSet) {
    }

}
