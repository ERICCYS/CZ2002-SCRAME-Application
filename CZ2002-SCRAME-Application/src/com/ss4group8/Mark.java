package com.ss4group8;

import java.util.HashMap;

/**
 * Represents a student mark record associated with one student and a course.
 * Both students and courses can have multiple student mark record, but cannot be duplicate.
 * @author Ma Xiao
 * @author Fu Mengyan
 * @author Kevin Steven Kihata
 * @author Ng Chen Ee Kenneth
 * @author Ian Tan Yi
 * @version 1.0
 */

public class Mark {
    /**
     * The student of this student mark record.
     */
    private Student student;
    /**
     * The course of this student mark record.
     */
    private Course course;
    /**
     * The course work marks of this student mark record.
     */
    private HashMap<CourseworkComponent, Double> courseWorkMarks;
    /**
     * The total mark of this student mark record.
     */
    private double totalMark;

    /**
     * Creates a new student mark record with the student of this student mark record, the course of this student mark record.
     *  the course work marks of this student mark record, the total mark of this student mark record.
     * @param student The student of this student mark record.
     * @param course The course of this student mark record.
     * @param courseWorkMarks The course work marks of this student mark record.
     * @param totalMark The total mark of this student mark record.
     */
    public Mark(Student student, Course course, HashMap<CourseworkComponent, Double> courseWorkMarks, double totalMark) {
        this.student = student;
        this.course = course;
        this.courseWorkMarks = courseWorkMarks;
        this.totalMark = totalMark;
    }

    /**
     * Gets the student of this student mark record.
     * @return the student of this student mark record.
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Gets the course of this student mark record.
     * @return the course of this student mark record.
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Gets the course work marks of this student mark record.
     * @return a hashmap contains the course work marks of this student mark record.
     */
    public HashMap<CourseworkComponent, Double> getCourseWorkMarks() {
        return courseWorkMarks;
    }

    /**
     * Gets the total mark of this student mark record.
     * @return the total mark of this student mark record.
     */
    public double getTotalMark() {
        return totalMark;
    }

    /**
     * Sets the main course work marks of this student mark record.
     * @param courseWorkName The name of this main course work.
     * @param result The mark obtained in this main course work.
     */
    public void setMainCourseWorkMarks(String courseWorkName, double result) {

        for (HashMap.Entry<CourseworkComponent, Double> entry : courseWorkMarks.entrySet()) {
            CourseworkComponent courseworkComponent = entry.getKey();
            double previousResult = entry.getValue();
            if (!(courseworkComponent instanceof MainComponent)) {
                continue;
            }
            if (courseworkComponent.getComponentName().equals(courseWorkName)) {
                if (((MainComponent) courseworkComponent).getSubComponents().size() != 0) {
                    System.out.println("This main assessment is not stand alone");
                    return;
                }
                this.totalMark += (result - previousResult) * courseworkComponent.getComponentWeight() / 100d;
                entry.setValue(result);

                System.out.println("The course work component is successfully set to: " + result);
                System.out.println("The course total mark is updated to: " + this.totalMark);
                return;
            }
        }
        System.out.println("This main assessment component does not exist...");

    }


    /**
     * Sets the sub course work marks of this student mark record.
     * @param courseWorkName The name of this sub course work.
     * @param result The mark obtained in this sub course work.
     */
    public void setSubCourseWorkMarks(String courseWorkName, double result) {
        double markIncInMain = 0d;
        for (HashMap.Entry<CourseworkComponent, Double> entry : courseWorkMarks.entrySet()) {
            CourseworkComponent courseworkComponent = entry.getKey();
            double previousResult = entry.getValue();
            if (!(courseworkComponent instanceof SubComponent)) {
                continue;
            }
            if (courseworkComponent.getComponentName().equals(courseWorkName)) {
                // Set the subComponent mark, calculate the main component increment
                markIncInMain = (result - previousResult) * courseworkComponent.getComponentWeight() / 100d;
                entry.setValue(result);

                System.out.println("The sub course work component is successfully set to: " + result);
                System.out.println("The main course work component increase by: " + markIncInMain);
            }
        }
        // Find its main component and update
        for (HashMap.Entry<CourseworkComponent, Double> entry : courseWorkMarks.entrySet()) {
            CourseworkComponent courseworkComponent = entry.getKey();
            double previousResult = entry.getValue();
            if ((courseworkComponent instanceof MainComponent) && ((MainComponent) courseworkComponent).getSubComponents().size() != 0) {
                for (SubComponent subComponent : ((MainComponent) courseworkComponent).getSubComponents()) {
                    if (subComponent.getComponentName().equals(courseWorkName)) {
                        // We find the main component it is in
                        this.totalMark += markIncInMain * courseworkComponent.getComponentWeight() / 100d;
                        entry.setValue(previousResult + markIncInMain);
                        System.out.println("The course total mark is updated to: " + this.totalMark);
                        return;
                    }
                }

            }
        }

    }
}
