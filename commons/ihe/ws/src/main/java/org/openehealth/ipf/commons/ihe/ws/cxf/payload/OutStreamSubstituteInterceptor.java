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
package org.openehealth.ipf.commons.ihe.ws.cxf.payload;

import com.ctc.wstx.io.UTF8Writer;
import com.ctc.wstx.sw.BaseStreamWriter;
import com.ctc.wstx.sw.BufferingXmlWriter;
import org.apache.cxf.interceptor.StaxOutInterceptor;
import org.apache.cxf.io.CacheAndWriteOutputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import javax.xml.stream.XMLStreamWriter;
import java.io.OutputStream;
import java.lang.reflect.Field;

/**
 * CXF interceptor that substitutes message output stream 
 * with a special wrapper that collects SOAP payload.
 *   
 * @author Dmytro Rud
 */
public class OutStreamSubstituteInterceptor extends AbstractPhaseInterceptor<Message> {

    private static final Field MWRITER_FIELD;
    private static final Field MOUT_WRITER_FIELD;
    private static final Field MOUT_STREAM_FIELD;
    static {
        try {
            MWRITER_FIELD = BaseStreamWriter.class.getDeclaredField("mWriter");
            MWRITER_FIELD.setAccessible(true);
            MOUT_WRITER_FIELD = BufferingXmlWriter.class.getDeclaredField("mOut");
            MOUT_WRITER_FIELD.setAccessible(true);
            MOUT_STREAM_FIELD = UTF8Writer.class.getDeclaredField("mOut");
            MOUT_STREAM_FIELD.setAccessible(true);
        } catch (NoSuchFieldException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public OutStreamSubstituteInterceptor() {
        super(Phase.PRE_STREAM);
        addAfter(StaxOutInterceptor.class.getName());
    }

    private static void checkClass(Object x, Class<?> expectedClass) {
        var realClass = x.getClass();
        if (!expectedClass.isAssignableFrom(realClass)) {
            throw new IllegalStateException("Expected " + expectedClass.getName() + ", got " + realClass.getName());
        }
    }

    @Override
    public void handleMessage(Message message) {
        try {
            Object x = message.getContent(XMLStreamWriter.class);
            checkClass(x, BaseStreamWriter.class);
            x = MWRITER_FIELD.get(x);
            checkClass(x, BufferingXmlWriter.class);
            x = MOUT_WRITER_FIELD.get(x);
            checkClass(x, UTF8Writer.class);
            var writer = (UTF8Writer) x;
            x = MOUT_STREAM_FIELD.get(writer);
            checkClass(x, OutputStream.class);
            var os = (OutputStream) x;
            var wrapper = new WrappedOutputStream(os, (String) message.get(Message.ENCODING));
            message.setContent(OutputStream.class, wrapper);
            MOUT_STREAM_FIELD.set(writer, wrapper);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }


    /**
     * Retrieves the instance of stream wrapper installed by this interceptor.
     * @param message
     *      CXF message which contains output stream as one of content types.
     * @return
     *      an instance of {@link WrappedOutputStream}.
     * @throws IllegalStateException
     *      when the stream wrapper instance could not be retrieved.
     */
    public static WrappedOutputStream getStreamWrapper(Message message) {
        var outputStream =  message.getContent(OutputStream.class);
        if (outputStream instanceof CacheAndWriteOutputStream cacheAndWriteOutputStream) {
            // Extract what we need from the wrapper added by CXF. CXF sometimes adds the wrapper for diagnostics.
            outputStream = cacheAndWriteOutputStream.getFlowThroughStream();
        }
        if (outputStream instanceof WrappedOutputStream wrappedOutputStream) {
            return wrappedOutputStream;
        } else {
            throw new IllegalStateException("Message output stream is not of expected type");
        }
    }

}
