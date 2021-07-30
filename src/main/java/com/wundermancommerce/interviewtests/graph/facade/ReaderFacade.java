package com.wundermancommerce.interviewtests.graph.facade;

import com.opencsv.exceptions.CsvException;
import com.wundermancommerce.interviewtests.graph.reader.PeopleReader;
import com.wundermancommerce.interviewtests.graph.reader.RelationshipReader;

import java.io.IOException;

public class ReaderFacade {
    private ReaderFacade() {
    }

    /**
     * Method to read and map the csv files
     */
    public static void readFiles() {
        try {
            PeopleReader.readPeople();
            RelationshipReader.readRelationships();
        } catch (IOException | CsvException error) {
            error.printStackTrace();
        }
    }
}
