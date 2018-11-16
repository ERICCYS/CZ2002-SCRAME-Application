package com.ss4group8;

/**
 * Represents TutorialGroup for a course.
 * A course can have many lecture groups.
 * This class is a subclass of {@code Group}.
 * @author Ma Xiao
 * @author Fu Mengyan
 * @author Kevin Steven Kihata
 * @author Ng Chen Ee Kenneth
 * @author Ian Tan Yi
 * @version 1.0
 * @since   2018-11-07
 */

public class TutorialGroup extends Group{

    /**
     * Creates a tutorial group given group name, available vacancies and total seats.
     * @param groupName This tutorial group's name.
     * @param availableVacancies This tutorial group's current available vacancy.
     * @param totalSeats This tutorial group's total seats.
     */
    public TutorialGroup(String groupName, int availableVacancies, int totalSeats) {
        super(groupName, availableVacancies, totalSeats);
    }
}
