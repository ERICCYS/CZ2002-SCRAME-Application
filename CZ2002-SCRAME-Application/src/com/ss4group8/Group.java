package com.ss4group8;

/**
 * Represents study groups (LectureGroup, TutorialGroup and LabGroup) for a course.
 * A course must have at least one lecture group.
 * A course can have many or no tutorial groups and lab groups.
 * Student enrolled in this course must also be enrolled in one of the groups of each type.
 *
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
     *
     * @param groupName          This group's name.
     * @param availableVacancies This group's current available vacancy.
     * @param totalSeats         This group's total seats.
     */
    public Group(String groupName, int availableVacancies, int totalSeats) {
        this.groupName = groupName;
        this.availableVacancies = availableVacancies;
        this.totalSeats = totalSeats;
    }

    /**
     * Gets the name of this group.
     *
     * @return this group's name.
     */
    public String getGroupName() {
        return this.groupName;
    }

    /**
     * Gets the current available vacancies for this group.
     *
     * @return this group's current available vacancy.
     */
    public int getAvailableVacancies() {
        return this.availableVacancies;
    }

    /**
     * Gets the total seats for this group.
     *
     * @return this group's total seats.
     */
    public int getTotalSeats() {
        return totalSeats;
    }

    /**
     * Updates the available vacancies of this group after someone has registered this group.
     */
    public void enrolledIn() {
        this.availableVacancies -= 1;
    }
}
