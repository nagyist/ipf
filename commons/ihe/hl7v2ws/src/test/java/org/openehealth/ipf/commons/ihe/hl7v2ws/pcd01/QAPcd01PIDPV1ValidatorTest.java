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
package org.openehealth.ipf.commons.ihe.hl7v2ws.pcd01;

import ca.uhn.hl7v2.HL7Exception;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Kingsley Nwaigbo
 * 
 */
public class QAPcd01PIDPV1ValidatorTest extends AbstractPCD01ValidatorTest {

    // ################ PID Segment tests ###############################

    @Test
    public void testMissingPID3() {
        assertThrows(HL7Exception.class, () -> validate(maxMsgReplace("111222333444^^^Imaginary Hospital&1.3.4.565&ISO^PI",
                "")));
    }

    @Test
    public void testSpaceAsPID3() {
        assertThrows(HL7Exception.class, () -> validate(maxMsgReplace("111222333444^^^Imaginary Hospital&1.3.4.565&ISO^PI",
                " ")));
    }

    @Test
    public void testMissingPID3_1() {
        assertThrows(HL7Exception.class, () -> validate(maxMsgReplace("111222333444^^^Imaginary Hospital&1.3.4.565&ISO^PI",
                "^^^Imaginary Hospital&1.3.4.565&ISO^PI")));
    }

    @Test
    public void testMissingPID34_1_2_3() {
        assertThrows(HL7Exception.class, () -> validate(maxMsgReplace("111222333444^^^Imaginary Hospital&1.3.4.565&ISO^PI",
                "111222333444")));
    }

    @Test
    public void testMissingPID34_1_2() {
        assertThrows(HL7Exception.class, () -> validate(maxMsgReplace("111222333444^^^Imaginary Hospital&1.3.4.565&ISO^PI",
                "111222333444^^^ISO")));
    }

    @Test
    public void testMissingPID5() {
        assertThrows(HL7Exception.class, () -> validate(maxMsgReplace("Doe^John^Joseph", "")));
    }

    @Test
    public void testMissingPID5_1() throws HL7Exception {
        validate(maxMsgReplace("Doe^John^Joseph", "^John^Joseph"));
    }

    @Test
    public void testMissingPID5_2_3() throws HL7Exception {
        validate(maxMsgReplace("Doe^John^Joseph", "Doe^^"));
    }

    @Test
    public void testMissingPV12() {
        assertThrows(HL7Exception.class, () -> validate(maxMsgReplace("|I|", "||")));
    }

}