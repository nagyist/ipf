/*
 * Copyright 2020 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *           http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.openehealth.ipf.tutorials.xds;

import jakarta.activation.DataSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteArrayDataSource implements DataSource {

    private final byte[] data;
    private final String contentType;

    ByteArrayDataSource(byte[] data, String contentType) {
        this.data = data;
        this.contentType = contentType;
    }

    @Override
    public InputStream getInputStream() {
        return new ByteArrayInputStream(data);
    }

    @Override
    public OutputStream getOutputStream() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public String getName() {
        return "ByteArrayDataSource";
    }
}
