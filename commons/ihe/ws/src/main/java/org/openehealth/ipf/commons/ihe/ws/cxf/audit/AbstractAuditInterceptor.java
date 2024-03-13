/*
 * Copyright 2009 the original author or authors.
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
package org.openehealth.ipf.commons.ihe.ws.cxf.audit;

import lombok.Getter;
import lombok.Setter;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.message.Message;
import org.apache.cxf.security.transport.TLSSessionInfo;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.cxf.ws.addressing.AddressingProperties;
import org.apache.cxf.ws.addressing.AttributedURIType;
import org.apache.cxf.ws.addressing.JAXWSAConstants;
import org.openehealth.ipf.commons.audit.AuditContext;
import org.openehealth.ipf.commons.core.config.Lookup;
import org.openehealth.ipf.commons.ihe.core.atna.AuditStrategy;
import org.openehealth.ipf.commons.ihe.ws.InterceptorUtils;
import org.openehealth.ipf.commons.ihe.ws.cxf.AbstractSafeInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.ldap.LdapName;
import jakarta.servlet.http.HttpServletRequest;
import java.security.cert.X509Certificate;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * Base class for all ATNA audit-related CXF interceptors.
 *
 * @author Dmytro Rud
 */
abstract public class AbstractAuditInterceptor<T extends WsAuditDataset> extends AbstractSafeInterceptor {

    private static final transient Logger LOG = LoggerFactory.getLogger(AbstractAuditInterceptor.class);


    /**
     * Key used to store audit datasets in Web Service contexts.
     */
    public static final String DATASET_CONTEXT_KEY = AbstractAuditInterceptor.class.getName() + ".DATASET";

    /**
     * Processor for extracting SAML tokens when XUA is used
     */
    @Getter
    @Setter
    private static XuaProcessor xuaProcessor = Lookup.lookup(XuaProcessor.class).orElse(XuaProcessor.NOOP);

    /**
     * Audit strategy associated with this interceptor.
     */
    private final AuditStrategy<T> auditStrategy;

    @Getter
    private final AuditContext auditContext;

    /**
     * Constructor which sets a strategy.
     *
     * @param phase         the phase in which to use this interceptor.
     * @param auditStrategy an audit strategy instance. <p><code>null</code> values are
     *                      explicitly prohibited.
     */
    protected AbstractAuditInterceptor(String phase, AuditStrategy<T> auditStrategy, AuditContext auditContext) {
        super(phase);
        this.auditStrategy = requireNonNull(auditStrategy);
        this.auditContext = requireNonNull(auditContext);
    }


    /**
     * Returns an audit dataset instance which corresponds to the given message.
     * <p>
     * When no such instance is currently associated with the message, a new one
     * will be created by means of the corresponding {@link AuditStrategy}
     * and registered in the message's exchange.
     *
     * @param message CXF message currently handled by this interceptor.
     * @return an audit dataset instance, or <code>null</code> when this instance
     * could be neither obtained nor created from scratch.
     */
    protected T getAuditDataset(SoapMessage message) {
        T auditDataset = InterceptorUtils.findContextualProperty(message, DATASET_CONTEXT_KEY);
        if (auditDataset == null) {
            auditDataset = getAuditStrategy().createAuditDataset();
            if (auditDataset == null) {
                LOG.warn("Cannot obtain audit dataset instance, NPE is pending");
                return null;
            }
            message.getExchange().put(DATASET_CONTEXT_KEY, auditDataset);
        }
        return auditDataset;
    }


    /**
     * Returns the audit strategy associated with this interceptor.
     *
     * @return an audit strategy instance or <code>null</code> when none configured.
     */
    protected AuditStrategy<T> getAuditStrategy() {
        return auditStrategy;
    }


    /**
     * Extracts user ID from an WS-Addressing SOAP header and stores it in the given
     * audit dataset.
     *
     * @param message             CXF message.
     * @param isInbound           <code>true</code> when the CXF message is an inbound one,
     *                            <code>false</code> otherwise.
     * @param inverseWsaDirection <code>true</code> when direction is actually inversed, i.e. when the
     *                            user ID should be taken not from the "ReplyTo:" WS-Addressing header,
     *                            but from "To:" --- useful for asynchronous responses, where the endpoint
     *                            which receives the response is not the endpoint which sent the request.
     * @param auditDataset        target audit dataset.
     */
    protected static void extractUserIdFromWSAddressing(
            SoapMessage message,
            boolean isInbound,
            boolean inverseWsaDirection,
            WsAuditDataset auditDataset) {
        var wsaProperties = (AddressingProperties) message.get(isInbound ?
                JAXWSAConstants.ADDRESSING_PROPERTIES_INBOUND :
                JAXWSAConstants.ADDRESSING_PROPERTIES_OUTBOUND);

        if (wsaProperties != null) {
            AttributedURIType address = null;
            if (inverseWsaDirection) {
                address = wsaProperties.getTo();
            } else {
                var replyTo = wsaProperties.getReplyTo();
                if (replyTo != null) {
                    address = replyTo.getAddress();
                }
            }

            if (address != null) {
                auditDataset.setSourceUserId(address.getValue());
            }
        }
        if (auditDataset.getSourceUserId() == null) {
            LOG.info("Missing WS-Addressing headers");
            auditDataset.setSourceUserId("unknown");
        }
    }


    /**
     * Enriches the given audit dataset with elements from the XUA token (SAML2 assertion)
     * contained in the given CXF message.
     *
     * @param message         source CXF message.
     * @param headerDirection direction of the header containing the SAML2 assertion.
     * @param auditDataset    target ATNA audit dataset.
     */
    protected static void enrichAuditDatasetFromXuaToken(
            SoapMessage message,
            Header.Direction headerDirection,
            WsAuditDataset auditDataset) {
        xuaProcessor.enrichAuditDatasetFromXuaToken(message, headerDirection, auditDataset);
    }


    /**
     * Extracts service URI and client IP address from the servlet request.
     */
    protected static void extractAddressesFromServletRequest(
            SoapMessage message,
            WsAuditDataset auditDataset) {
        var request =
                (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
        auditDataset.setRemoteAddress(request.getRemoteAddr());
        auditDataset.setLocalAddress(request.getServerName()); // #238
        auditDataset.setDestinationUserId(request.getRequestURL().toString());
    }

    /**
     * Extract TLS information from servlet request, if available
     */
    protected static void extractClientCertificateCommonName(
            SoapMessage message,
            WsAuditDataset auditDataset) {
        var request = message.get(TLSSessionInfo.class);
        if (request != null) {
            var certificates = request.getPeerCertificates();
            if (certificates != null && certificates.length > 0) {
                try {
                    var certificate = (X509Certificate) certificates[0];
                    var principal = certificate.getSubjectDN();
                    var dn = principal.getName();
                    var ldapDN = new LdapName(dn);
                    for (var rdn : ldapDN.getRdns()) {
                        if (rdn.getType().equalsIgnoreCase("CN")) {
                            auditDataset.setSourceUserName((String) rdn.getValue());
                            break;
                        }
                    }
                } catch (Exception e) {
                    LOG.info("Could not extract CN from client certificate", e);
                }
            }
        }
    }

    /**
     * Extracts POJO from the given CXF message.
     *
     * @return POJO or <code>null</code> when none found.
     */
    protected static Object extractPojo(Message message) {
        List<?> list = message.getContent(List.class);
        return ((list == null) || list.isEmpty()) ? null : list.get(0);
    }
}
