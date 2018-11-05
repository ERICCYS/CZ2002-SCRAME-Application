package com.ss4group8;

import java.util.HashMap;

public class Mark {
    private Student student;
    private Course course;
    private double examMark;
    private HashMap<CourseworkComponent,Double> courseWorkMarks;
    private double totalMark;

    public Mark(Student student, Course course, double examMark, HashMap<CourseworkComponent, Double> courseWorkMarks, double totalMark) {
        this.student = student;
        this.course = course;
        this.examMark = examMark;
        this.courseWorkMarks = courseWorkMarks;
        this.totalMark = totalMark;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public double getExamMark() {
        return examMark;
    }

    public HashMap<CourseworkComponent, Double> getCourseWorkMarks() {
        return courseWorkMarks;
    }

    public double getTotalMark() {
        return totalMark;
    }
}
