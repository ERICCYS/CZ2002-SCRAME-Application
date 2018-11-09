package com.ss4group8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
        for (Map.Entry<CourseworkComponent, Double> entry : courseWorkMarks.entrySet()) {
            CourseworkComponent courseworkComponent = entry.getKey();
//            Double previousResult = entry.getValue();

            if (courseworkComponent.getComponentName().equals(courseWorkName)) {
                entry.setValue(result);
                System.out.println("The course work component is successfully set to " + result);
                return;
            }
        }
        System.out.println("This assessment component does not exist...");

    }
}
