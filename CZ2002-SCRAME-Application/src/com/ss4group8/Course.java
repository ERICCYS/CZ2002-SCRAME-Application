package com.ss4group8;

import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    private String CourseID;
    private String courseName;
    private ArrayList<LectureGroup> lectureGroups;
    private HashMap<String, Double> CourseWorks;

    public Course(String courseID, String courseName, ArrayList<LectureGroup> lectureGroups) {
        this.CourseID = courseID;
        this.courseName = courseName;
        this.lectureGroups = lectureGroups;
    }

    public String getCourseID() {
        return CourseID;
    }

    public String getCourseName() {return courseName; }

    public ArrayList<LectureGroup> getLectureGroups() {
        return lectureGroups;
    }

    public void printLectureGroup() {
        for (int i = 0; i < lectureGroups.size(); i++) {
            System.out.println(lectureGroups.get(i).getGroupName() + " still has "+ lectureGroups.get(i).getCapacity()
                    + " vacancies");
        }
    }
}
