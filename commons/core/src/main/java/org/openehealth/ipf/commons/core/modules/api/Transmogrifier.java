/*
 * Copyright 2008 the original author or authors.
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
package org.openehealth.ipf.commons.core.modules.api;

/**
 * Translates one internal data structure into another one.
 *
 * @see <a href="http://en.wikipedia.org/wiki/Transmogrifier"/>
 *
 * @author Christian Ohr
 * 
 * @param <S>
 * @param <T>
 */
public interface Transmogrifier<S, T> {

    /**
     * Transmogrifies an object into another one.
     * 
     * @param object what goes in
     * @param params parameters
     * @return what comes out
     */
    T zap(S object, Object... params);

}
