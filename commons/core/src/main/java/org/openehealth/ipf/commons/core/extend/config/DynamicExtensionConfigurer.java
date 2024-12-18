/*
 * Copyright 2013 the original author or authors.
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
package org.openehealth.ipf.commons.core.extend.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import groovy.lang.GroovySystem;
import groovy.lang.MetaMethod;
import org.codehaus.groovy.reflection.CachedClass;
import org.codehaus.groovy.runtime.m12n.ExtensionModule;
import org.codehaus.groovy.runtime.metaclass.MetaClassRegistryImpl;
import org.openehealth.ipf.commons.core.config.OrderedConfigurer;
import org.openehealth.ipf.commons.core.config.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Configurer used to autowire all classes implementing the
 * {@link org.openehealth.ipf.commons.core.extend.config.DynamicExtension}
 * interface using Groovy 2.x Extension Modules
 *
 * @author Christian Ohr
 *
 * @see DynamicExtension
 * @see DynamicExtensionModule
 */
public class DynamicExtensionConfigurer<R extends Registry> extends
        OrderedConfigurer<DynamicExtension, R> {

    private static final Logger log = LoggerFactory.getLogger(DynamicExtensionConfigurer.class);

    public DynamicExtensionConfigurer() {
        setOrder(2);
    }

    @Override
    public void configure(DynamicExtension extension) {
        if (extension != null) {
            log.info("Registering new extension module {} defined in class {}",
                    extension.getModuleName(), extension.getClass());
            var module = DynamicExtensionModule.newModule(extension);
            addExtensionMethods(module);
        }
    }

    public static void addExtensionMethods(ExtensionModule module) {
        var metaClassRegistry = GroovySystem.getMetaClassRegistry();
        ((MetaClassRegistryImpl) metaClassRegistry).getModuleRegistry().addModule(module);
        var classMap = new HashMap<CachedClass, List<MetaMethod>>();
        for (var metaMethod : module.getMetaMethods()){
            if (classMap.containsKey(metaMethod.getDeclaringClass())){
                classMap.get(metaMethod.getDeclaringClass()).add(metaMethod);
            } else {
                var methodList = new ArrayList<MetaMethod>();
                methodList.add(metaMethod);
                classMap.put(metaMethod.getDeclaringClass(), methodList);
            }
            if (metaMethod.isStatic()){
                ((MetaClassRegistryImpl)metaClassRegistry).getStaticMethods().add(metaMethod);
            } else {
                ((MetaClassRegistryImpl)metaClassRegistry).getInstanceMethods().add(metaMethod);
            }
            log.debug("registered method: {}", metaMethod);
        }
        for (var cachedClassEntry : classMap.entrySet()) {
            cachedClassEntry.getKey().addNewMopMethods(cachedClassEntry.getValue());
        }
    }

    @Override
    public Collection<DynamicExtension> lookup(Registry registry) {
        return registry.beans(DynamicExtension.class).values();
    }

}
