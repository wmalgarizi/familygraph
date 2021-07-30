package com.wundermancommerce.interviewtests.graph.model;

import java.util.HashSet;
import java.util.Set;

public class User {
    private final String name;
    private final String email;
    private final Short age;
    private final Set<User> family = new HashSet<>();
    private final Set<User> friends = new HashSet<>();

    public User(String[] userData) {
        this.name = userData[0];
        this.email = userData[1];
        this.age = Short.parseShort(userData[2]);
    }

    public String getEmail() {
        return email;
    }

    public Set<User> getFamily() {
        return family;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void addFamilyMember(User user) {
        family.add(user);
    }

    public void addFriend(User user) {
        friends.add(user);
    }
}
