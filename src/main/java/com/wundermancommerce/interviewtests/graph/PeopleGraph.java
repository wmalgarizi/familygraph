package com.wundermancommerce.interviewtests.graph;

import com.wundermancommerce.interviewtests.graph.facade.ReaderFacade;
import com.wundermancommerce.interviewtests.graph.model.User;

import java.util.Map;

public class PeopleGraph {
    private static Map<String, User> userMap;

    private PeopleGraph() {
    }

    static {
        ReaderFacade.readFiles();
    }

    public static int getUserMapSize() {
        return userMap.size();
    }

    public static boolean isMapEmpty() {
        return userMap.isEmpty();
    }

    public static User getUserByEmail(String email) {
        return userMap.get(email);
    }

    public static void setUserMap(Map<String, User> userMap) {
        PeopleGraph.userMap = userMap;
    }
}
