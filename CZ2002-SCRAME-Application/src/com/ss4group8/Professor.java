package com.ss4group8;

public class Professor {
    private String profID;
    private String profName;

    public Professor(String profID, String profName) {
        this.profID = profID;
        this.profName = profName;
    }

    public String getProfID() {
        return profID;
    }

    public String getProfName() {
        return profName;
    }
}
