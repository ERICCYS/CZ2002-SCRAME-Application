package com.ss4group8;

import java.util.ArrayList;

/**
 * {@code Course} class represents a course held by school.
 * A course has a {@code courseID} and {@code courseName}.
 * A course contains at least one {@code LectureGroup}, may contains multiple {@code TutorialGroup} and {@code LabGroup}.
 * A course can have many {@code MainComponent}, and a {@code MainComponent} can have many {@code SubComponent}.
 * @author Ma Xiao
 * @author Fu Mengyan
 * @author Kevin Steven Kihata
 * @author Ng Chen Ee Kenneth
 * @author Ian Tan Yi
 * @version 1.0
 *
 */


public class Course {
    private String courseID;
    private String courseName;
    private int AU;
    private Professor profInCharge;
    private int vacancies;
    private int totalSeats;

    private ArrayList<LectureGroup> lectureGroups;
    private ArrayList<TutorialGroup> tutorialGroups = new ArrayList<TutorialGroup>(0);
    private ArrayList<LabGroup> labGroups = new ArrayList<LabGroup>(0);
    private ArrayList<MainComponent> mainComponents = new ArrayList<MainComponent>(0);


    public Course(String courseID, String courseName, int AU, Professor profInCharge, int vacancies, int totalSeats, ArrayList<LectureGroup> lectureGroups, ArrayList<TutorialGroup> tutorialGroups, ArrayList<LabGroup> labGroups, ArrayList<MainComponent> mainComponents) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.AU = AU;
        this.profInCharge = profInCharge;
        this.vacancies = vacancies;
        this.totalSeats = totalSeats;
        this.lectureGroups = lectureGroups;
        this.tutorialGroups = tutorialGroups;
        this.labGroups = labGroups;
        this.mainComponents = mainComponents;
    }

    public Course(String courseID, String courseName, int AU, Professor profInCharge, int vacancies, int totalSeats, ArrayList<LectureGroup> lectureGroups, ArrayList<TutorialGroup> tutorialGroups, ArrayList<LabGroup> labGroups) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.AU = AU;
        this.profInCharge = profInCharge;
        this.vacancies = vacancies;
        this.totalSeats = totalSeats;
        this.lectureGroups = lectureGroups;
        this.tutorialGroups = tutorialGroups;
        this.labGroups = labGroups;
    }


    public Course(String courseID, String courseName, int AU, Professor profInCharge, int vacancies, int totalSeats, ArrayList<LectureGroup> lectureGroups) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.AU = AU;
        this.profInCharge = profInCharge;
        this.vacancies = vacancies;
        this.totalSeats = totalSeats;
        this.lectureGroups = lectureGroups;
    }

//    public Course(String courseID, String courseName, Professor profInCharge, int vacancies, int totalSeats, ArrayList<LectureGroup> lectureGroups, ArrayList<TutorialGroup> tutorialGroups, ArrayList<LabGroup> labGroups, ArrayList<MainComponent> mainComponents) {
//        this.courseID = courseID;
//        this.courseName = courseName;
//        this.profInCharge = profInCharge;
//        this.vacancies = vacancies;
//        this.totalSeats = totalSeats;
//        this.lectureGroups = lectureGroups;
//        this.tutorialGroups = tutorialGroups;
//        this.labGroups = labGroups;
//        this.mainComponents = mainComponents;
//    }
//
//    public Course(String courseID, String courseName, Professor profInCharge, int vacancies, int totalSeats, ArrayList<LectureGroup> lectureGroups) {
//        this.courseID = courseID;
//        this.courseName = courseName;
//        this.profInCharge = profInCharge;
//        this.vacancies = vacancies;
//        this.totalSeats = totalSeats;
//        this.lectureGroups = lectureGroups;
//    }
//
//    public Course(String courseID, String courseName, Professor profInCharge, int vacancies, int totalSeats, ArrayList<LectureGroup> lectureGroups, ArrayList<TutorialGroup> tutorialGroups, ArrayList<LabGroup> labGroups) {
//        this.courseID = courseID;
//        this.courseName = courseName;
//        this.profInCharge = profInCharge;
//        this.vacancies = vacancies;
//        this.totalSeats = totalSeats;
//        this.lectureGroups = lectureGroups;
//        this.tutorialGroups = tutorialGroups;
//        this.labGroups = labGroups;
//    }


    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getAU() { return AU; }

    public Professor getProfInCharge() {
        return this.profInCharge;
    }

    public int getVacancies() { return this.vacancies; }

    public int getTotalSeats() {
        return this.totalSeats;
    }

    public ArrayList<LectureGroup> getLectureGroups() {
        return lectureGroups;
    }

    public ArrayList<TutorialGroup> getTutorialGroups() {
        return this.tutorialGroups;
    }

    public ArrayList<LabGroup> getLabGroups() {
        return this.labGroups;
    }

    public ArrayList<MainComponent> getMainComponents() {
        return this.mainComponents;
    }

    public void setVacancies(int vacancies) {
        this.vacancies = vacancies;
    }

    public void enrolledIn() { this.vacancies = vacancies - 1; }

    public void setTutorialGroups(ArrayList<TutorialGroup> tutorialGroups) {
        this.tutorialGroups = tutorialGroups;
    }

    public void setLabGroups(ArrayList<LabGroup> labGroups) {
        this.labGroups = labGroups;
    }

    public void setMainComponents(ArrayList<MainComponent> mainComponents) {
        this.mainComponents = mainComponents;
    }

//    public void printLectureGroup() {
//        for (int i = 0; i < lectureGroups.size(); i++) {
//            System.out.println(lectureGroups.get(i).getGroupName() + " still has " + lectureGroups.get(i).getAvailableVacancies()
//                    + " vacancies");
//        }
//    }
}
