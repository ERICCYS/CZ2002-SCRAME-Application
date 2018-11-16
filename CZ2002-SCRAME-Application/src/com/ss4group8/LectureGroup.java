package com.ss4group8;

/**
 * Represents lecture group for a course.
 * A course can have many lecture groups.
 * This class is a subclass of {@code Group}.
 * @author Ma Xiao
 * @author Fu Mengyan
 * @author Kevin Steven Kihata
 * @author Ng Chen Ee Kenneth
 * @author Ian Tan Yi
 * @version 1.0
 */
public class LectureGroup extends Group{

    /**
     * Creates a lecture group with the group name, the current available vacancy of this course, and the total seats for this group.
     * This function makes use of its super class.
     * @param groupName This lecture group's name.
     * @param availableVacancies This lecture group's current available vacancy.
     * @param totalSeats This lecture group's total seats.
     */
    public LectureGroup(String groupName, int availableVacancies, int totalSeats) {
        super(groupName, availableVacancies, totalSeats);
    }
}
