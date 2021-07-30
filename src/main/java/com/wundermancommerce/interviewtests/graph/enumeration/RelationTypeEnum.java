package com.wundermancommerce.interviewtests.graph.enumeration;

import java.util.Arrays;

public enum RelationTypeEnum {
    FAMILY,
    FRIENDS;

    /**
     * Method to verify if the relation type is valid
     * @param relation the type to be validated
     * @return true if is valid and false if is not
     */
    public static boolean isValidRelation(String relation) {
        return Arrays.stream(RelationTypeEnum.values())
                .anyMatch(relationType -> relationType.name().equalsIgnoreCase(relation));
    }
}
