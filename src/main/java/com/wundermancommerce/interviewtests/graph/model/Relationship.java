package com.wundermancommerce.interviewtests.graph.model;

public class Relationship {
    private final String firstUserEmail;
    private final String relation;
    private final String secondUserEmail;

    public Relationship(String[] relationshipData) {
        this.firstUserEmail = relationshipData[0];
        this.relation = relationshipData[1];
        this.secondUserEmail = relationshipData[2];
    }

    public String getFirstUserEmail() {
        return firstUserEmail;
    }

    public String getRelation() {
        return relation;
    }

    public String getSecondUserEmail() {
        return secondUserEmail;
    }
}
