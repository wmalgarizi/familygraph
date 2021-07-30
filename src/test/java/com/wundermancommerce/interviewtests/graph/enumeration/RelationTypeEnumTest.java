package com.wundermancommerce.interviewtests.graph.enumeration;

import org.junit.Test;

import static org.junit.Assert.*;

public class RelationTypeEnumTest {
    @Test
    public void isValidRelation_whenReceiveFamilyUpperRelation_thenShouldReturnTrue() {
        //Given
        var type = "FAMILY";

        //When

        //Then
        assertTrue(RelationTypeEnum.isValidRelation(type));
    }

    @Test
    public void isValidRelation_whenReceiveFamilyLowerRelation_thenShouldReturnTrue() {
        //Given
        var type = "family";

        //When

        //Then
        assertTrue(RelationTypeEnum.isValidRelation(type));
    }
    @Test
    public void isValidRelation_whenReceiveFriendsUpperRelation_thenShouldReturnTrue() {
        //Given
        var type = "FRIENDS";

        //When

        //Then
        assertTrue(RelationTypeEnum.isValidRelation(type));
    }

    @Test
    public void isValidRelation_whenReceiveFriendsLowerRelation_thenShouldReturnTrue() {
        //Given
        var type = "friends";

        //When

        //Then
        assertTrue(RelationTypeEnum.isValidRelation(type));
    }

    @Test
    public void isValidRelation_whenReceiveInvalidRelation_thenShouldReturnFalse() {
        //Given
        var type = "lol";

        //When

        //Then
        assertFalse(RelationTypeEnum.isValidRelation(type));
    }

}