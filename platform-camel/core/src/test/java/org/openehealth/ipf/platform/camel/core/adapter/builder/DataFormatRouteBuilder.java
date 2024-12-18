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
package org.openehealth.ipf.platform.camel.core.adapter.builder;

import org.apache.camel.spi.DataFormat;
import org.openehealth.ipf.platform.camel.core.adapter.DataFormatAdapter;
import org.openehealth.ipf.platform.camel.core.support.builder.RouteBuilderSupport;
import org.openehealth.ipf.platform.camel.core.support.transform.min.TestConverter;

/**
 * @author Christian Ohr
 * @author Martin Krasser
 */
public class DataFormatRouteBuilder extends RouteBuilderSupport {
	
    @Override
    public void configure() {
        
        DataFormat format = new DataFormatAdapter(new TestConverter());
        
        from("direct:external").unmarshal(format);
        from("direct:internal").marshal(format).convertBodyTo(String.class);
    }

}
