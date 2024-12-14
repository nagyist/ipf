/*
 * Copyright 2018 the original author or authors.
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
package org.openehealth.ipf.commons.spring.map.config;

import org.openehealth.ipf.commons.core.config.Configurer;
import org.openehealth.ipf.commons.core.config.OrderedConfigurer;
import org.openehealth.ipf.commons.core.config.Registry;
import org.openehealth.ipf.commons.spring.map.MappingResourceHolder;
import org.openehealth.ipf.commons.spring.map.SpringBidiMappingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * {@link Configurer} used to add all {@link CustomMappings} 
 * bean occurrences from the spring application context
 * to the provided {@link SpringBidiMappingService}.
 * 
 * @author Boris Stanojevic
 */
public class CustomMappingsConfigurer<R extends Registry> extends OrderedConfigurer<MappingResourceHolder, R> {

    private SpringBidiMappingService mappingService;
    
    private static final Logger log = LoggerFactory.getLogger(CustomMappingsConfigurer.class);
    
    /**
     * lookup for the specific {@link CustomMappings} objects inside
     * the given beanFactory
     * 
     * @see OrderedConfigurer
     */
    @Override
    public Collection<MappingResourceHolder> lookup(Registry registry) {
        return registry.beans(MappingResourceHolder.class).values();
    }

    /**
     * configuration logic  
     */
    @Override
    public void configure(MappingResourceHolder configuration) {
        if (configuration.getMappingResources() != null) {
            mappingService.setMappingResources(configuration.getMappingResources());
            log.debug("Mapping scripts added {}", configuration);
        }
    }
    
    public SpringBidiMappingService getMappingService() {
        return mappingService;
    }

    public void setMappingService(SpringBidiMappingService mappingService) {
        this.mappingService = mappingService;
    }

}
