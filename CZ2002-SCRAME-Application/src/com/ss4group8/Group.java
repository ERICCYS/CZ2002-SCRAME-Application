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
 */

public class Group {
    /**
     * The name of this group.
     */
    private String groupName;

    /**
     * The availableVacancies of this group.
     */
    private int availableVacancies;


    /**
     * The total seates of this group
     */
    private int totalSeats;


    /**
     * Creates a group with the group name, the current available vacancy of this course, and the total seats for this group.
     * @param groupName this group's name.
     * @param availableVacancies this group's current available vacancy.
     * @param totalSeats this group's total seats
     */
    public Group(String groupName, int availableVacancies, int totalSeats) {
        this.groupName = groupName;
        this.availableVacancies = availableVacancies;
        this.totalSeats = totalSeats;
    }

    /**
     * Gets the name of this group
     * @return
     */
    public String getGroupName() { return this.groupName; }

    /**
     * Gets the current available vacancies for this course.
     * @return
     */
    public int getAvailableVacancies() { return this.availableVacancies; }

    /**
     * Gets the total seats for this course.
     * @return
     */
    public int getTotalSeats() {
        return totalSeats;
    }

    /**
     * Updates the available of this course after someone has registered this course.
     */
    public void enrolledIn () {
        this.availableVacancies -= 1;
    }
}
