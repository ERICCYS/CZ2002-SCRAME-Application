package com.ss4group8;

public class LectureGroup extends Group{
//    private String groupName;
//    private int availableVacancies;
//    private int totalSeats;
//
//    public LectureGroup(String groupName, int availableVacancies, int totalSeats) {
//
//        this.groupName = groupName;
//        this.availableVacancies = availableVacancies;
//        this.totalSeats = totalSeats;
//    }
//
//    public String getGroupName() {
//        return groupName;
//    }
//
//    public int getAvailableVacancies() {
//        return availableVacancies;
//    }
//
//    public int getTotalSeats() {
//        return totalSeats;
//    }
//
//    public void enrolledIn() {
//        this.availableVacancies -= 1;
//    }


    public LectureGroup(String groupName, int availableVacancies, int totalSeats) {
        super(groupName, availableVacancies, totalSeats);
    }
}
