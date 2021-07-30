package com.wundermancommerce.interviewtests.graph.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {
    private ValidatorUtil() {
    }

    /**
     * Method that get the Pattern Matcher to validate the Email template
     *
     * @param email the email to apply the pattern matcher
     * @return The matcher to be checked
     */
    public static Matcher getEmailPatternMatcher(String email) {
        var pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        return pattern.matcher(email);
    }
}
