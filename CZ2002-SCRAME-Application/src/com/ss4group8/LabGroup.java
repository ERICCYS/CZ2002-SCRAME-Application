package com.ss4group8;

/**
 * {@code LabGroup} represents LabGroup for a course.
 * A course can have many lab groups.
 * This class is a subclass of {@code Group}.
 * @author Ma Xiao
 * @author Fu Mengyan
 * @author Kevin Steven Kihata
 * @author Ng Chen Ee Kenneth
 * @author Ian Tan Yi
 * @version 1.0
 * @since   2018-11-07
 */
public class LabGroup extends Group{


    /**
     * Creates a tutorial group with the group name, the current available vacancy of this course, and the total seats for this group.
     * This function makes use of its super class.
     * @param groupName This tutorial group's name.
     * @param availableVacancies This tutorial group's current available vacancy.
     * @param totalSeats This tutorial group's total seats.
     */

    public LabGroup(String groupName, int availableVacancies, int totalSeats) {
        super(groupName, availableVacancies, totalSeats);
    }
}
