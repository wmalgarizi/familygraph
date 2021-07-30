package com.wundermancommerce.interviewtests.graph.reader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.wundermancommerce.interviewtests.graph.handler.RelationshipHandler;
import com.wundermancommerce.interviewtests.graph.model.Relationship;
import com.wundermancommerce.interviewtests.graph.validator.CommonValidator;

import java.io.FileReader;
import java.io.IOException;

public class RelationshipReader {
    private static final String RELATIONSHIP_FILE_PATH = "src/test/resources/relationships.csv";

    private RelationshipReader() {
    }

    /**
     * Method that reads the relationships csv file, map each line to Relationship
     * models and add users relations
     */
    public static void readRelationships() throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(RELATIONSHIP_FILE_PATH))) {
            reader.readAll().stream()
                    .filter(CommonValidator.isTheLengthValid())
                    .map(Relationship::new)
                    .forEach(RelationshipHandler.addRelation());
        }
    }
}
