package com.ss4group8;

import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    private String CourseID;
    private String courseName;
    private Professor profInCharge;
    private int vacancies;
    private int totalSeats;
    private ArrayList<LectureGroup> lectureGroups;
    private ArrayList<TutorialGroup> tutorialGroups;
    private ArrayList<LabGroup> labGroups;
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

    public Professor getProfInCharge() { return this.profInCharge; }

    public int getVacancies() { return this.vacancies; }

    public int getTotalSeats() { return this.totalSeats; }

    public ArrayList<LectureGroup> getLectureGroups() {
        return lectureGroups;
    }

    public ArrayList<TutorialGroup> getTutorialGroups() { return this.tutorialGroups; }

    public ArrayList<LabGroup> getLabGroups() { return this.labGroups; }

    public void printLectureGroup() {
        for (int i = 0; i < lectureGroups.size(); i++) {
            System.out.println(lectureGroups.get(i).getGroupName() + " still has "+ lectureGroups.get(i).getCapacity()
                    + " vacancies");
        }
    }
}
