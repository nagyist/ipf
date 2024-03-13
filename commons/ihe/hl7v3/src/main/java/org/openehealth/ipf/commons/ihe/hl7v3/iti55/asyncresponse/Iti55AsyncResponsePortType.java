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
package org.openehealth.ipf.commons.ihe.hl7v3.iti55.asyncresponse;

import jakarta.jws.Oneway;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.xml.ws.Action;

/**
 * SEI for the ITI-55 XCPD Initiating Gateway actor: receiver of WSA asynchronous responses.
 * @author Dmytro Rud
 */
@WebService(targetNamespace = "urn:ihe:iti:xcpd:2009", name = "InitiatingGateway_PortType", portName = "InitiatingGateway_Port")
@SOAPBinding(style = Style.DOCUMENT, parameterStyle = ParameterStyle.BARE)
public interface Iti55AsyncResponsePortType {

    @Oneway
    @Action(input = "urn:hl7-org:v3:PRPA_IN201306UV02:CrossGatewayPatientDiscovery")
    @WebMethod(operationName = "InitiatingGateway_Async_PRPA_IN201306UV02")
    void receiveAsyncResponse(
            @WebParam(partName = "Body", targetNamespace = "urn:ihe:iti:xcpd:2009")
            String response
    );
}
