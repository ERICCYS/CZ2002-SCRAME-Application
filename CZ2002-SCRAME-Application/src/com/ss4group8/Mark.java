package com.ss4group8;

import java.util.HashMap;

public class Mark {
    private Student student;
    private Course course;
    private HashMap<CourseworkComponent, Double> courseWorkMarks;
    private double totalMark;

    public Mark(Student student, Course course, HashMap<CourseworkComponent, Double> courseWorkMarks, double totalMark) {
        this.student = student;
        this.course = course;
        this.courseWorkMarks = courseWorkMarks;
        this.totalMark = totalMark;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public HashMap<CourseworkComponent, Double> getCourseWorkMarks() {
        return courseWorkMarks;
    }

    public double getTotalMark() {
        return totalMark;
    }

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
