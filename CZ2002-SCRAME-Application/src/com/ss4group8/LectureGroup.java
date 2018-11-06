package com.ss4group8;

public class LectureGroup {
    private String groupName;
    private int availableVacancies;

    public LectureGroup(String groupName, int availableVacancies) {
        this.groupName = groupName;
        this.availableVacancies = availableVacancies;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getAvailableVacancies() {
        return availableVacancies;
    }

    public void enrolledIn() {
        this.availableVacancies -= 1;
    }
}
