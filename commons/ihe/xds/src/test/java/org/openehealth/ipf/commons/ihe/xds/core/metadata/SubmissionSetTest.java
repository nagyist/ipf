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
package org.openehealth.ipf.commons.ihe.xds.core.metadata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.transform.ebxml.SubmissionSetTransformerTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for {@link SubmissionSet}.
 * Note that most of the accessors of {@code SubmissionSet} are tested via
 * the tests of its transformer {@link SubmissionSetTransformerTestBase}.
 */
public class SubmissionSetTest {
    private Author author1;
    private Author author2;
    private SubmissionSet submissionSet;

    @BeforeEach
    public void setUp() {
        author1 = new Author();
        author2 = new Author();
        submissionSet = new SubmissionSet();
    }

    @Test
    public void testGetAuthorOnAuthorListContainingMultipleAuthors() {
        submissionSet.getAuthors().add(author1);
        submissionSet.getAuthors().add(author2);
        assertEquals(2, submissionSet.getAuthors().size());
        assertEquals(author1, submissionSet.getAuthors().get(0));
        assertEquals(author2, submissionSet.getAuthors().get(1));
    }
}