package com.wundermancommerce.interviewtests.graph;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.wundermancommerce.interviewtests.graph.handler.UserHandler;
import com.wundermancommerce.interviewtests.graph.reader.PeopleReader;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PeopleGraphTest {
    @Test
    public void givenTheValidCSVFile_whenMapToPeople_thenShouldPopulateCorrectly() throws IOException, CsvException {
        //Given
        var reader = new CSVReader(new FileReader(PeopleReader.PEOPLE_FILE_PATH));
        int size = reader.readAll().size();

        //When

        //Then
        assertFalse(PeopleGraph.isMapEmpty());
        assertEquals(size, PeopleGraph.getUserMapSize());
    }

    @Test
    public void givenTheUserEmailAndNumberOfRelations_whenTryToGetRelationships_thenShouldReturnTheCorrectNumber() {
        //Given
        var userRelationships = new HashMap<String, Integer>();
        userRelationships.put("bob@bob.com", 4);
        userRelationships.put("jenny@toys.com", 3);
        userRelationships.put("nigel@marketing.com", 2);
        userRelationships.put("alan@lonely.org", 0);

        //When

        //Then
        userRelationships.forEach((email, num) -> {
            var user = PeopleGraph.getUserByEmail(email);
            assertEquals(num, UserHandler.getRelationshipNumber(user));
        });
    }

    @Test
    public void givenJennyAndBobsEmails_whenSearchForTheExtendedFamily_thenShouldReturnTheRightNumber() {
        //Given
        var size = 4;
        var jennysEmail = "jenny@toys.com";
        var bobsEmail = "bob@bob.com";

        //When

        //Then
        verifyFamilySize(size, jennysEmail);
        verifyFamilySize(size, bobsEmail);
    }

    private void verifyFamilySize(int familySize, String email) {
        var user = PeopleGraph.getUserByEmail(email);
        assertEquals(familySize, UserHandler.getExtendedFamilySize(user));
    }
}
