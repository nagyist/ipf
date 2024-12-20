/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openehealth.ipf.platform.camel.ihe.mllp.iti9

import org.junit.jupiter.api.Test
import org.openehealth.ipf.platform.camel.ihe.mllp.core.AbstractMllpTest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.test.context.ContextConfiguration

import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

import static org.junit.jupiter.api.Assertions.assertTrue

/**
 * Unit tests for the PIX Query transaction a.k.a. ITI-9, where requests are sent
 * @author Christian Ohr
 */
@ContextConfiguration('/iti9/iti-9.xml')
class TestIti9QueryStream extends AbstractMllpTest {

    private static final Logger log = LoggerFactory.getLogger(TestIti9QueryStream)
    
    static String getMessageString(String msh9, String msh12, boolean needQpd = true) {
        def s = 'MSH|^~\\&|MESA_PIX_CLIENT|MESA_DEPARTMENT|MESA_XREF|XYZ_HOSPITAL|'+
                "200603121200||${msh9}|10501110|P|${msh12}||||||||\n"
        if(needQpd) {
            s += 'QPD|QRY_1001^Query for Corresponding Identifiers^IHEDEMO|QRY10501110|' +
                    'ABC10501^^^HIMSS2005&1.3.6.1.4.1.21367.2005.1.1&ISO^PI|||||\n'
        }
        s += 'RCP|I||||||'
        return s
    }


    @Test
    void testQueryStream() throws Exception {
        final String message = getMessageString('QBP^Q23', '2.5')

        Socket socket = new Socket("localhost", 18091)
        BufferedOutputStream outputStream = new BufferedOutputStream(new DataOutputStream(socket.getOutputStream()))
        final BufferedInputStream inputStream = new BufferedInputStream(new DataInputStream(socket.getInputStream()))

        int messageCount = 100
        CountDownLatch latch = new CountDownLatch(messageCount)

        Runnable runnable = new Runnable() {
            @Override
            void run() {
                int response
                StringBuilder s = new StringBuilder()
                try {
                    while ((response = inputStream.read()) >= 0) {
                        if (response == 28) {
                            response = inputStream.read() // read second end byte
                            if (response == 13) {
                                log.debug(s.toString().replaceAll('\r', '\n'))
                                s = new StringBuilder()
                                latch.countDown()
                            }
                        } else {
                            s.append((char) response)
                        }
                    }
                } catch (IOException ignored) {
                }
            }
        }

        Thread t = new Thread(runnable)
        t.start()

        for (int i = 0; i < messageCount; i++) {
            String msg = message.replace("10501110", String.valueOf(i))
            outputStream.write(11)
            outputStream.flush()
            // Some systems send start byte in a separate frame
            // Thread.sleep(10);
            outputStream.write(msg.getBytes())
            outputStream.flush()
            // Some systems send end bytes in a separate frame
            // Thread.sleep(10);
            outputStream.write(28)
            outputStream.write(13)
            outputStream.flush()
            // Thread.sleep(10);
        }

        boolean success = latch.await(20, TimeUnit.SECONDS)

        outputStream.close()
        inputStream.close()
        socket.close()

        assertTrue(success)
    }
}
