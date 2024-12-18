/*
 * Copyright 2011 the original author or authors.
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
package org.openehealth.ipf.modules.cda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.emf.common.util.Diagnostic;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil.ValidationHandler;

/**
 * Validation Handler
 *
 * @author Stefan Ivanov
 *
 */
public class DefaultValidationHandler implements ValidationHandler {
    private static final Logger log = LoggerFactory.getLogger(DefaultValidationHandler.class.getName());
    
    @Override
    public void handleError(Diagnostic diagnostic) {
        log.error("Validation error: {}", diagnostic);
    }
    
    @Override
    public void handleWarning(Diagnostic diagnostic) {
        log.warn("Validation warning: {}", diagnostic);
    }
    
    @Override
    public void handleInfo(Diagnostic diagnostic) {
        log.debug("Validation info: {}", diagnostic);
    }
    
}
