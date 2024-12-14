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
package org.openehealth.ipf.commons.ihe.xds.core.requests.query;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.xml.bind.annotation.*;

import java.io.Serial;
import java.util.List;

/**
 * Represents a stored query for GetFolders.
 * @author Jens Riemschneider
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFoldersQuery", propOrder = {"logicalUuid", "metadataLevel"})
@XmlRootElement(name = "getFoldersQuery")
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, doNotUseGetters = true)
public class GetFoldersQuery extends GetByIdQuery {
    @Serial
    private static final long serialVersionUID = 854601731250203237L;

    @Getter @Setter private List<String> logicalUuid;
    @Getter @Setter private Integer metadataLevel;

    /**
     * Constructs the query.
     */
    public GetFoldersQuery() {
        super(QueryType.GET_FOLDERS);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
