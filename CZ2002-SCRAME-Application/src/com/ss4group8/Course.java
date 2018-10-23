package com.ss4group8;

import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    private String CourseID;
    private ArrayList<LectureGroup> lectureGroups;
    private HashMap<String, Double> CourseWorks;

    public Course(String courseID, ArrayList<LectureGroup> lectureGroups) {
        CourseID = courseID;
        this.lectureGroups = lectureGroups;
    }

    public String getCourseID() {
        return CourseID;
    }

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
