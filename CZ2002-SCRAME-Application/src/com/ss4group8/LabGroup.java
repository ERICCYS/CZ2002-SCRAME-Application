package com.ss4group8;

import java.util.ArrayList;

public class LabGroup {
    private String groupName;
    private int availableVacancies;
    private int totalSeats;

    public LabGroup(String groupName, int availableVacancies) {
        this.groupName = groupName;
        this.availableVacancies = availableVacancies;
    }

    public LabGroup(String groupName, int availableVacancies, int totalSeats) {
        this.groupName = groupName;
        this.availableVacancies = availableVacancies;
        this.totalSeats = totalSeats;
    }



    public String getGroupName() {
        return this.groupName;
    }

    public int getAvailableVacancies() {
        return this.availableVacancies;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void enrolledIn() {
        this.availableVacancies -= 1;
    }
}
