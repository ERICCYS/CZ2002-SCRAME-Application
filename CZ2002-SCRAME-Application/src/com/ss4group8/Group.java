package com.ss4group8;

public class Group {
    private String groupName;
    private int availableVacancies;
    private int totalSeats;

    public Group(String groupName, int availableVacancies, int totalSeats) {
        this.groupName = groupName;
        this.availableVacancies = availableVacancies;
        this.totalSeats = totalSeats;
    }


    public String getGroupName() { return this.groupName; }

    public int getAvailableVacancies() { return this.availableVacancies; }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void enrolledIn () {
        this.availableVacancies -= 1;
    }
}
