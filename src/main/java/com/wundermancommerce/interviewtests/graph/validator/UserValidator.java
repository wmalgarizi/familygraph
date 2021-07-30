package com.wundermancommerce.interviewtests.graph.validator;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Objects;
import java.util.function.Predicate;

public class UserValidator {
    private UserValidator() {
    }

    /**
     * Method to verify if the user line can be mapped to user model
     *
     * receives the userData, verify the length and the attributes
     *
     * @return true if is valid
     */
    public static Predicate<String[]> validateUserTemplate() {
        return userData -> CommonValidator.isTheLengthValid()
                .and(areTheAttributesValid())
                .test(userData);
    }

    /**
     * Method to verify if the userData attributes are valid
     *
     * receives the userData, verify the attributes templates
     *
     * @return true if is valid
     */
    private static Predicate<String[]> areTheAttributesValid() {
        return userData -> isValidName(userData[0])
                && CommonValidator.isEmailValid(userData[1])
                && isAgeValid(userData[2]);
    }

    /**
     * Method to verify if the name is valid
     *
     * receives the userData, verify if the name contains only letters
     *
     * @return true if is valid
     */
    private static boolean isValidName(String name) {
        return Objects.nonNull(name) && !name.isBlank()
                && name.matches("[a-zA-Z]+");
    }

    /**
     * Method to verify if the age is valid
     *
     * receives the userData, verify the if the age contains only numbers
     *
     * @return true if is valid
     */
    private static boolean isAgeValid(String age) {
        return Objects.nonNull(age) && !age.isBlank()
                && NumberUtils.isCreatable(age);
    }
}
