package com.ss4group8;

import java.util.HashMap;

public class Mark {
    private String studentID;
    private String courseID;
    private double examMark;
    private HashMap<String,                          Double> courseWorkMarks;
    private double totalMark;

    public Mark(String studentID, String courseID, double examMark, HashMap<String, Double> courseWorkMarks, double totalMark) {
        // Initially set all the course work marks to 0 and the exam mark to 0, total mark to 0
        this.studentID = studentID;
        this.courseID = courseID;
        this.examMark = examMark;
        this.courseWorkMarks = courseWorkMarks;
        this.totalMark = totalMark;
    }
}
