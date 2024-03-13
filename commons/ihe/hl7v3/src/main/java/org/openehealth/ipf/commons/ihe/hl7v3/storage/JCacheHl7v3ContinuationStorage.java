/*
 * Copyright 2020 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.openehealth.ipf.commons.ihe.hl7v3.storage;


import javax.cache.Cache;
import java.io.Serializable;

import static java.util.Objects.requireNonNull;

/**
 * @author Dmytro Rud
 * @author Christian Ohr
 */
public class JCacheHl7v3ContinuationStorage implements Hl7v3ContinuationStorage {

    private final Cache<String, Serializable> cache;

    private static final String MESSAGE_SUFFIX = ".message";
    private static final String LAST_RESULT_NUMBER_SUFFIX = ".lastIndex";
    private static final String CONTINUATION_QUANTITY_SUFFIX = ".quantity";

    JCacheHl7v3ContinuationStorage(Cache<String, Serializable> cache) {
        requireNonNull(cache);
        this.cache = cache;
    }

    @Override
    public void storeMessage(String key, String message) {
        cache.put(key + MESSAGE_SUFFIX, message);
    }

    @Override
    public String getMessage(String key) {
        return (String) cache.get(key + MESSAGE_SUFFIX);
    }

    @Override
    public void storeLastResultNumber(String key, int lastResultNumber) {
        cache.put(key + LAST_RESULT_NUMBER_SUFFIX, lastResultNumber);
    }

    @Override
    public int getLastResultNumber(String key) {
        var value = cache.get(key + LAST_RESULT_NUMBER_SUFFIX);
        return (value != null) ? (int) value : -1;
    }

    @Override
    public void storeContinuationQuantity(String key, int continuationQuantity) {
        cache.put(key + CONTINUATION_QUANTITY_SUFFIX, continuationQuantity);
    }

    @Override
    public int getContinuationQuantity(String key) {
        var value = cache.get(key + CONTINUATION_QUANTITY_SUFFIX);
        return (value != null) ? (int) value : -1;
    }

    @Override
    public boolean remove(String key) {
        var exists = cache.get(key + MESSAGE_SUFFIX) != null;
        cache.remove(key + LAST_RESULT_NUMBER_SUFFIX);
        cache.remove(key + CONTINUATION_QUANTITY_SUFFIX);
        cache.remove(key + MESSAGE_SUFFIX);
        return exists;
    }

}

