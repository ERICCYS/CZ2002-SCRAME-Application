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
}
