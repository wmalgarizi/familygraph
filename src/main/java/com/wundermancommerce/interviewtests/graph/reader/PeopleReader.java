package com.wundermancommerce.interviewtests.graph.reader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.wundermancommerce.interviewtests.graph.PeopleGraph;
import com.wundermancommerce.interviewtests.graph.model.User;
import com.wundermancommerce.interviewtests.graph.validator.UserValidator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PeopleReader {
    public static final String PEOPLE_FILE_PATH = "src/test/resources/people.csv";

    private PeopleReader() {
    }

    /**
     * Method that reads the people csv file and map each line to user models
     */
    public static void readPeople() throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(PEOPLE_FILE_PATH))) {
            Map<String, User> userMap = reader.readAll()
                    .stream()
                    .filter(UserValidator.validateUserTemplate())
                    .map(User::new)
                    .collect(Collectors.toMap(User::getEmail, Function.identity()));
            PeopleGraph.setUserMap(userMap);
        }
    }
}
