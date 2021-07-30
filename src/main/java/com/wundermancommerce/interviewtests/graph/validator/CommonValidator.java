package com.wundermancommerce.interviewtests.graph.validator;

import com.wundermancommerce.interviewtests.graph.util.ValidatorUtil;

import java.util.Objects;
import java.util.function.Predicate;

public class CommonValidator {
    private CommonValidator() {
    }

    /**
     * Method to verify if the read line has the right number of params to map into a model
     *
     * receives the dataRecord and return true if the size is correct
     */
    public static Predicate<String[]> isTheLengthValid() {
        return dataRecord -> dataRecord.length == 3;
    }

    /**
     * Method to verify if the email is valid
     *
     * receives the email and validate the size and template
     *
     * @param email to be validated
     */
    public static boolean isEmailValid(String email) {
        if (Objects.isNull(email) || email.isBlank()) {
            return false;
        }
        var emailPatternMatcher = ValidatorUtil.getEmailPatternMatcher(email);
        return emailPatternMatcher.matches();
    }
}
