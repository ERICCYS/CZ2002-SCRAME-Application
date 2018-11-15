package com.ss4group8;

/**
 * {@code Group} represents study groups (LectureGroup, TutorialGroup and LabGroup) for a course.
 * A course has a {@code courseID} and {@code courseName}.
 * A course contains at least one {@code LectureGroup}, may contains multiple {@code TutorialGroup} and {@code LabGroup}.
 * A course can have many {@code MainComponent}, and a {@code MainComponent} can have many {@code SubComponent}.
 * @author Ma Xiao
 * @author Fu Mengyan
 * @author Kevin Steven Kihata
 * @author Ng Chen Ee Kenneth
 * @author Ian Tan Yi
 * @version 1.0
 *
 */

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
