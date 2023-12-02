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
package org.openehealth.ipf.commons.ihe.xds.core.validate;

import static java.util.Objects.requireNonNull;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage.*;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidatorAssertions.metaDataAssert;

import java.util.regex.Pattern;

/**
 * Validates time values.
 * @author Jens Riemschneider
 */
public class TimeValidator implements ValueValidator {
    private static final String YEAR = "[0-9]{4}";
    private static final String MONTH = "(0[1-9]|1[012])";
    private static final String DAY = "(0[1-9]|[12][0-9]|3[01])";
    private static final String HOUR = "([01][0-9]|2[0123])";
    private static final String MIN_SEC = "[0-5][0-9]";
    private static final String REG_EX =
        YEAR + "(" + MONTH + "(" + DAY + "(" + HOUR + "(" + MIN_SEC + "(" + MIN_SEC + ")?)?)?)?)?";

    private static final Pattern TIME_PATTERN = Pattern.compile(REG_EX);

    private final int minLen;

    /**
     * Initializes a validator which will check that the timestamp has the right format
     * and the given minimal length (to check the precision).
     *
     * @param minLen minimal length of the timestamp; "-1" means no check.
     */
    public TimeValidator(int minLen) {
        this.minLen = minLen;
    }

    /**
     * Initializes a validator which will check that the timestamp has the right format
     * without minimal length constraint.
     */
    public TimeValidator() {
        this(-1);
    }

    @Override
    public void validate(String time) throws XDSMetaDataException {
        requireNonNull(time, "time cannot be null");
        metaDataAssert(TIME_PATTERN.matcher(time).matches(), INVALID_TIME, time);
        metaDataAssert((minLen < 0) || (time.length() >= minLen), TIME_PRECISION_TOO_LOW, time);
    }
}
