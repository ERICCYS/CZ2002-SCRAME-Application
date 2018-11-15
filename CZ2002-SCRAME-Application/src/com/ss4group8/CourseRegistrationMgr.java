package com.ss4group8;

import java.lang.reflect.Array;
import java.util.*;
import java.io.PrintStream;
import java.io.OutputStream;

import static com.ss4group8.CourseRegistration.LabComparator;
import static com.ss4group8.CourseRegistration.LecComparator;
import static com.ss4group8.CourseRegistration.TutComparator;

public class CourseRegistrationMgr {
    private static Scanner scanner = new Scanner(System.in);
    private static PrintStream originalStream = System.out;

    private static PrintStream dummyStream = new PrintStream(new OutputStream(){
        public void write(int b) {
            // NO-OP
        }
    });

    public static Course validateCourse(String courseID) {
        for (Course course : SCRAME.courses) {
            if (course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        return null;
    }

    public static void registerCourse() {
        System.out.println("registerCourse is called");
        HashMap<String, Integer> LecGroupAssign = new HashMap<String, Integer>(0);
        HashMap<String, Integer> TutGroupAssign = new HashMap<String, Integer>(0);
        HashMap<String, Integer> LabGroupAssign = new HashMap<String, Integer>(0);
        int index;

        int selectedLectureGroupNum;
        int selectedTutorialGroupNum;
        int selectedLabGroupNum;
        String selectedLectureGroupName = null;
        String selectedTutorialGroupName = null;
        String selectedLabGroupName = null;

        Student currentStudent = ValidationMgr.checkStudentExists();
        String studentID = currentStudent.getStudentID();
        boolean validStudentID = false;


        String courseDepartment = ValidationMgr.checkCourseDepartmentExists();

        Course currentCourse = ValidationMgr.checkCourseExists();
        String courseID = currentCourse.getCourseID();

        // Exception handling
        // Get the course and student. Call the function inside CourseRegistration Mgr

        if(ValidationMgr.checkCourseRegistrationExists(studentID, courseID) != null){
            return;
        }

        if (currentCourse.getMainComponents().size() == 0) {
            System.out.println("Professor " + currentCourse.getProfInCharge().getProfName() + " is preparing the assessment. Please try to register other courses.");
            return;
        }

        System.out.println("Student " + currentStudent.getStudentName() + " with ID: " + currentStudent.getStudentID() +
                " wants to register " + currentCourse.getCourseID() + " " + currentCourse.getCourseName());

        ArrayList<Group> lecGroups = new ArrayList<Group>(0);
        for(LectureGroup lectureGroup : currentCourse.getLectureGroups()){
            lecGroups.add((Group)lectureGroup);
        }

        HelpInfoMgr.printGroupWithVacancyInfo(currentCourse,"lecture", lecGroups);

        ArrayList<Group> tutGroups = new ArrayList<Group>(0);
        for(TutorialGroup tutorialGroup : currentCourse.getTutorialGroups()){
            tutGroups.add((Group)tutorialGroup);
        }

        HelpInfoMgr.printGroupWithVacancyInfo(currentCourse, "tutorial", tutGroups);

        ArrayList<Group> labGroups = new ArrayList<Group>(0);
        for(LabGroup labGroup : currentCourse.getLabGroups()){
            labGroups.add((Group)labGroup);
        }

        HelpInfoMgr.printGroupWithVacancyInfo(currentCourse, "lab", labGroups);

        currentCourse.enrolledIn();
        CourseRegistration courseRegistration = new CourseRegistration(currentStudent, currentCourse, selectedLectureGroupName, selectedTutorialGroupName, selectedLabGroupName);
        FILEMgr.writeCourseRegistrationIntoFile(courseRegistration);

        SCRAME.courseRegistrations.add(courseRegistration);

        SCRAME.marks.add(MarkMgr.initializeMark(currentStudent, currentCourse));

        System.out.println("Course registration successful!");
        System.out.print("Student: " + currentStudent.getStudentName());
        System.out.print("\tLecture Group: " + selectedLectureGroupName);
        if (currentCourse.getTutorialGroups().size() != 0) {
            System.out.print("\tTutorial Group: " + selectedTutorialGroupName);
        }
        if (currentCourse.getLabGroups().size() != 0) {
            System.out.print("\tLab Group: " + selectedLabGroupName);
        }
        System.out.println();
    }

    public static void printStudents() {
//        Scanner scanner = new Scanner(System.in);
        System.out.println("printStudent is called");
        Course currentCourse =ValidationMgr.checkCourseExists();
        
        System.out.println("Print student by: ");
        System.out.println("(1) Lecture group");
        System.out.println("(2) Tutorial group");
        System.out.println("(3) Lab group");
        // READ courseRegistrationFILE
        // return ArrayList of Object(student,course,lecture,tut,lab)
        ArrayList<CourseRegistration> allStuArray = FILEMgr.loadCourseRegistration();

//            for(CourseRegistration courseRegistration : allStuArray) {
//                System.out.println(courseRegistration.getCourse().getCourseID() + " " + courseRegistration.getStudent().getStudentID());
//            }

        ArrayList<CourseRegistration> stuArray = new ArrayList<CourseRegistration>(0);
        for (CourseRegistration courseRegistration : allStuArray) {
            if (courseRegistration.getCourse().getCourseID().equals(currentCourse.getCourseID())) {
                stuArray.add(courseRegistration);
            }
        }

//            System.out.println("About course " + course.getCourseID());
//            for(CourseRegistration courseRegistration : stuArray) {
//                System.out.println(courseRegistration.getCourse().getCourseID() + " " + courseRegistration.getStudent().getStudentID());
//            }


        int opt = scanner.nextInt();
        scanner.nextLine();

        if (opt == 1) { // print by LECTURE
            String newLec = "";
            Collections.sort(stuArray, LecComparator);   // Sort by Lecture group
//                System.out.println(stuArray.size());
            for (int i = 0; i < stuArray.size(); i++) {  // loop through all of CourseRegistration Obj
                if (!newLec.equals(stuArray.get(i).getLectureGroup())) {  // if new lecture group print out group name
                    newLec = stuArray.get(i).getLectureGroup();
                    System.out.println("------------------------------------------------------");
                    System.out.println("Lecture group : " + newLec);
                }
                System.out.print("Student Name: " + stuArray.get(i).getStudent().getStudentName());
                System.out.println(" Student ID: " + stuArray.get(i).getStudent().getStudentID());
            }
        } else if (opt == 2) { // print by TUTORIAL
            String newTut = "";
            Collections.sort(stuArray, TutComparator);
            for (int i = 0; i < stuArray.size(); i++) {
                if (!newTut.equals(stuArray.get(i).getTutorialGroup())) {
                    newTut = stuArray.get(i).getTutorialGroup();
                    System.out.println("------------------------------------------------------");
                    System.out.println("Tutorial group : " + newTut);
                }
                System.out.print("Student Name: " + stuArray.get(i).getStudent().getStudentName());
                System.out.println(" Student ID: " + stuArray.get(i).getStudent().getStudentID());
            }
        } else if (opt == 3) { // print by LAB
            String newLab = "";
            Collections.sort(stuArray, LabComparator);
            for (int i = 0; i < stuArray.size(); i++) {
                if (!newLab.equals(stuArray.get(i).getLabGroup())) {
                    newLab = stuArray.get(i).getLabGroup();
                    System.out.println("------------------------------------------------------");
                    System.out.println("Lab group : " + newLab);
                }
                System.out.print("Student Name: " + stuArray.get(i).getStudent().getStudentName());
                System.out.println(" Student ID: " + stuArray.get(i).getStudent().getStudentID());
            }
        }
        System.out.println("------------------------------------------------------");
        // Exception handling
        // Get the course and all the registration record regarding this course. Call the function inside the CourseRegistration Mgr

    }





}
