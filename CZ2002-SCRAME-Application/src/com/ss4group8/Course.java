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

    public Course(String courseID, String courseName, Professor profInCharge, int totalSeats, ArrayList<LectureGroup> lectureGroups) {
        this.CourseID = courseID;
        this.courseName = courseName;
        this.profInCharge = profInCharge;
        this.totalSeats = this.vacancies = totalSeats;
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

    public HashMap<String, Double> getCourseWorks(){ return this.CourseWorks; }

    public void setTutorialGroups(ArrayList<TutorialGroup> tutorialGroups){
        this.tutorialGroups  = tutorialGroups;
    }

    public void setLabGroups(ArrayList<LabGroup> labGroups){
        this.labGroups = labGroups;
    }

    public void setCourseWorks(HashMap<String,Double> courseWorks){
        this.CourseWorks = courseWorks;
    }

    public void printLectureGroup() {
        for (int i = 0; i < lectureGroups.size(); i++) {
            System.out.println(lectureGroups.get(i).getGroupName() + " still has "+ lectureGroups.get(i).getCapacity()
                    + " vacancies");
        }
    }
}
