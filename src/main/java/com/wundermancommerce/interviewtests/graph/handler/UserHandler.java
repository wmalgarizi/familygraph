package com.wundermancommerce.interviewtests.graph.handler;

import com.wundermancommerce.interviewtests.graph.model.User;

import java.util.HashSet;
import java.util.Set;

public class UserHandler {
    private UserHandler() {
    }

    /**
     * Method to get extended family size, not counting the friends
     * @param user user to get family size
     * @return the size of the family
     */
    public static int getExtendedFamilySize(User user) {
        var emailSet = new HashSet<String>();
        return getExtendedFamily(user, emailSet).size();
    }

    /**
     * Method to get the number of relationships
     * @param user user to get relationship number
     * @return the number of the relationships
     */
    public static Integer getRelationshipNumber(User user) {
        return user.getFamily().size() + user.getFriends().size();
    }

    /**
     * Method which effectively calculates the extended family size
     * @param user user to get family size
     * @param emailSet the set of emails
     * @return the set containing the family users related emails
     */
    private static Set<String> getExtendedFamily(User user, Set<String> emailSet) {
        emailSet.add(user.getEmail());

        user.getFamily().forEach(p -> {
            if (!emailSet.contains(p.getEmail()))
                getExtendedFamily(p, emailSet);
        });

        return emailSet;
    }
}
