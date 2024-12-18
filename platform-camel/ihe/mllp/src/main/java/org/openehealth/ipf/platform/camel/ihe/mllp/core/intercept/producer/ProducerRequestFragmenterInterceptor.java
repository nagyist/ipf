/*
 * Copyright 2010 the original author or authors.
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
package org.openehealth.ipf.platform.camel.ihe.mllp.core.intercept.producer;

import ca.uhn.hl7v2.util.Terser;
import org.apache.camel.Exchange;
import org.openehealth.ipf.modules.hl7.message.MessageUtils;
import org.openehealth.ipf.platform.camel.ihe.core.InterceptorSupport;
import org.openehealth.ipf.platform.camel.ihe.mllp.core.MllpTransactionEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.openehealth.ipf.platform.camel.ihe.mllp.core.FragmentationUtils.appendSplitSegment;
import static org.openehealth.ipf.platform.camel.ihe.mllp.core.FragmentationUtils.splitString;
import static org.openehealth.ipf.platform.camel.ihe.mllp.core.FragmentationUtils.uniqueId;

/**
 * A producer-side interceptor which implements non-interactive request 
 * fragmentation as described in paragraph 2.10.2.2 of the HL7 v.2.5 specification.
 * @author Dmytro Rud
 */
public class ProducerRequestFragmenterInterceptor extends InterceptorSupport {
    private static final Logger log = LoggerFactory.getLogger(ProducerRequestFragmenterInterceptor.class);
    

    @Override
    public void process(Exchange exchange) throws Exception {
        var threshold = getEndpoint(MllpTransactionEndpoint.class).getUnsolicitedFragmentationThreshold();
        if (threshold < 3) {
            getWrappedProcessor().process(exchange);
            return;
        }

        var request = exchange.getIn().getBody(String.class);
        var fieldSeparator = request.charAt(3);
        var segments = splitString(request, '\r');

        // short message --> send unmodified and return
        if (segments.size() <= threshold) {
            getWrappedProcessor().process(exchange);
            return;
        }

        // parse MSH segment
        var mshFields = splitString(segments.get(0), request.charAt(3));
        
        // when MSH-14 is already present -- send the message unmodified and return
        if ((mshFields.size() >= 14) && isNotEmpty(mshFields.get(13))) {
            log.warn("MSH-14 is not empty, cannot perform automatic message fragmentation");
            getWrappedProcessor().process(exchange);
            return;
        }
        
        // when DSC is present and already filled -- send the message unmodified 
        // and return; otherwise -- delete the DSC segment, if present 
        if (segments.get(segments.size() - 1).startsWith("DSC")) {
            var dscFields = splitString(segments.get(segments.size() - 1), request.charAt(3));
            if ((dscFields.size() >= 2) && isNotEmpty(dscFields.get(1))) {
                log.warn("DSC-1 is not empty, cannot perform automatic message fragmentation");
                getWrappedProcessor().process(exchange);
                return;
            }
            segments.remove(segments.size() - 1);
        }

        while (mshFields.size() < 14) {
            mshFields.add("");
        }
        
        // main loop
        var currentSegmentIndex = 1;
        var continuationPointer = "";
        while (currentSegmentIndex < segments.size()) {
            var currentSegmentsCount = 1;
            var sb = new StringBuilder();
            
            // add MSH (position 1)
            appendSplitSegment(sb, mshFields, fieldSeparator);

            // add data segments (positions 2..MAX-1)
            do {
                sb.append(segments.get(currentSegmentIndex)).append('\r');
            } while ((++currentSegmentIndex  < segments.size()) 
                  && (++currentSegmentsCount < threshold - 1));

            // one position free, one segment left -> bring them together
            if (currentSegmentIndex == segments.size() - 1) {
                sb.append(segments.get(currentSegmentIndex++)).append('\r');
            }
            
            // one or more segments left -> add DSC (position MAX)
            if(currentSegmentIndex < segments.size()) {
                continuationPointer = uniqueId();
                sb.append("DSC")
                  .append(fieldSeparator)
                  .append(continuationPointer)
                  .append(fieldSeparator)
                  .append("F\r");

                log.debug("Send next fragment, continuation pointer = {}", continuationPointer);
            }
            
            // send the generated fragment to the receiver
            exchange.getIn().setBody(sb.toString());
            getWrappedProcessor().process(exchange);

            // catch and analyse the response, if this was not the last fragment
            if(currentSegmentIndex < segments.size()) {
                var responseString = exchange.getMessage().getBody(String.class);
                var responseTerser = new Terser(getEndpoint(MllpTransactionEndpoint.class).getHl7v2TransactionConfiguration().getParser().parse(responseString));

                var messageType = responseTerser.get("MSH-9-1");
                var acknowledgementCode = responseTerser.get("MSA-1");
                var controlId = mshFields.get(9);
                
                if (! "ACK".equals(messageType)) {
                    throw new RuntimeException("Server responded with " + messageType + " instead of ACK to the fragment with control ID " + mshFields.get(9));
                }
                if ("AA".equals(acknowledgementCode) || "CA".equals(acknowledgementCode)) {
                    if (! controlId.equals(responseTerser.get("MSA-2"))) {
                        throw new RuntimeException("Expected " + controlId + " in MSA-2, but got " + responseTerser.get("MSA-2"));
                    }
                } else {
                    // NAKs will go to the route
                    log.debug("Got NAK response for fragment with control ID {}", controlId); 
                    break;
                }
    
                // update fields for next fragment
                mshFields.set(6, MessageUtils.hl7Now());
                mshFields.set(9, uniqueId());
                mshFields.set(13, continuationPointer);
            }
        }
    }

}
