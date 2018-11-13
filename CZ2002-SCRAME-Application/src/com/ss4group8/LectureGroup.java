package com.ss4group8;

public class LectureGroup {
    private String groupName;
    private int availableVacancies;
    private int totalSeats;

    public LectureGroup(String groupName, int availableVacancies) {
        this.groupName = groupName;
        this.availableVacancies = availableVacancies;
    }

    public LectureGroup(String groupName, int availableVacancies, int totalSeats) {

        this.groupName = groupName;
        this.availableVacancies = availableVacancies;
        this.totalSeats = totalSeats;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getAvailableVacancies() {
        return availableVacancies;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void enrolledIn() {
        this.availableVacancies -= 1;
    }
}
