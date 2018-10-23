package com.ss4group8;

public class CourseRegistration {
    private String studentID;
    private String courseID;
    private String lectureGroup;
    private String tutorialGroup;
    private String labGroup;

    public CourseRegistration(String studentID, String courseID, String lectureGroup) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.lectureGroup = lectureGroup;
    }

    public CourseRegistration(String studentID, String courseID, String lectureGroup, String tutorialGroup) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.lectureGroup = lectureGroup;
        this.tutorialGroup = tutorialGroup;
    }

    public CourseRegistration(String studentID, String courseID, String lectureGroup, String tutorialGroup, String labGroup) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.lectureGroup = lectureGroup;
        this.tutorialGroup = tutorialGroup;
        this.labGroup = labGroup;
    }
}
