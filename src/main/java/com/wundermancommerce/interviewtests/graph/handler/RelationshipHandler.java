package com.wundermancommerce.interviewtests.graph.handler;

import com.wundermancommerce.interviewtests.graph.PeopleGraph;
import com.wundermancommerce.interviewtests.graph.enumeration.RelationTypeEnum;
import com.wundermancommerce.interviewtests.graph.model.Relationship;
import com.wundermancommerce.interviewtests.graph.model.User;

import java.util.function.Consumer;

public class RelationshipHandler {
    private RelationshipHandler() {
    }

    /**
     * Method responsible to add family or friendship relations to users
     * Receives a Relationship and depending on the relation type, add to family or friends set
     */
    public static Consumer<Relationship> addRelation() {
        return relationship -> {
            var firstPerson = PeopleGraph.getUserByEmail(relationship.getFirstUserEmail());
            var secondPerson = PeopleGraph.getUserByEmail(relationship.getSecondUserEmail());
            if (RelationTypeEnum.FAMILY.name().equalsIgnoreCase(relationship.getRelation())) {
                addToFamily(firstPerson, secondPerson);
            } else {
                addToFriends(firstPerson, secondPerson);
            }
        };
    }

    /**
     * Method responsible for add family relation to the users
     *
     * @param firstUser the first user which will have the second one added to it's family
     * @param secondUser the second user which will have the first one added to it's family
     */
    private static void addToFamily(User firstUser, User secondUser) {
        firstUser.addFamilyMember(secondUser);
        secondUser.addFamilyMember(firstUser);
    }

    /**
     * Method responsible for add friendship relation to the users
     * @param firstUser the first user which will have the second one added to it's friends set
     * @param secondUser the second user which will have the first one added to it's friends set
     */
    private static void addToFriends(User firstUser, User secondUser) {
        firstUser.addFriend(secondUser);
        secondUser.addFriend(firstUser);
    }
}
