package com.ss4group8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Collections;

import static com.ss4group8.CourseRegistration.LabComparator;
import static com.ss4group8.CourseRegistration.LecComparator;
import static com.ss4group8.CourseRegistration.TutComparator;

public class CourseRegistrationMgr {
    private static Scanner scanner = new Scanner(System.in);

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

        String studentID;
        Student currentStudent = null;
        boolean validStudentID = false;
        System.out.println("Enter Student ID:");
        studentID = scanner.nextLine();
        for (Student student : SCRAME.students) {
            if (student.getStudentID().equals(studentID)) {
                validStudentID = true;
                currentStudent = student;
                break;
            }
        }
        if (!validStudentID) {
            System.out.println("Invalid Student ID...");
            System.out.println("Exiting the course registration");
            return;
        }
        // Exception handling
        String courseID;
        Course currentCourse = null;
        boolean validCourseID = false;
        System.out.println("Enter Course ID:");
        courseID = scanner.nextLine();
        for (Course course : SCRAME.courses) {
            if (course.getCourseID().equals(courseID)) {
                validCourseID = true;
                currentCourse = course;
                break;
            }
        }
        if (!validCourseID) {
            System.out.println("Invalid Course ID...");
            System.out.println("Exiting the course registration");
            return;
        }
        // Exception handling
        // Get the course and student. Call the function inside CourseRegistration Mgr

        System.out.println("Student " + currentStudent.getStudentName() + " with ID: " + currentStudent.getStudentID() +
                " wants to register " + currentCourse.getCourseID() + " " + currentCourse.getCourseName());


        System.out.println("Here is a list of all the lecture groups with available slots:");
        do {
            System.out.println("Please enter an integer for your choice:");
            index = 0;
            for (LectureGroup lectureGroup : currentCourse.getLectureGroups()) {
                if (lectureGroup.getAvailableVacancies() == 0) {
                    continue;
                }
                index++;
                System.out.println(index + ": " + lectureGroup.getGroupName() + " (" + lectureGroup.getAvailableVacancies() + " vacancies)");
                LecGroupAssign.put(lectureGroup.getGroupName(), index);
            }
            selectedLectureGroupNum = scanner.nextInt();
            scanner.nextLine();
            if (selectedLectureGroupNum < 1 || selectedLectureGroupNum > index) {
                System.out.println("Invalid choice. Please re-enter.");
            } else {
                break;
            }
        } while (true);

        for (HashMap.Entry<String, Integer> entry : LecGroupAssign.entrySet()) {
            String lecGroupName = entry.getKey();
            int num = entry.getValue();
            if (num == selectedLectureGroupNum) {
                selectedLectureGroupName = lecGroupName;
                break;
            }
        }

        for (LectureGroup lectureGroup : currentCourse.getLectureGroups()) {
            if (lectureGroup.getGroupName().equals(selectedLectureGroupName)) {
                lectureGroup.enrolledIn();
                break;
            }
        }


        if (currentCourse.getTutorialGroups().size() != 0) {
            System.out.println("Here is a list of all the tutorial groups with available slots:");
            do {
                System.out.println("Please enter an integer for your choice:");
                index = 0;
                for (TutorialGroup tutorialGroup : currentCourse.getTutorialGroups()) {
                    if (tutorialGroup.getAvailableVacancies() == 0) {
                        continue;
                    }
                    index++;
                    System.out.println(index + ": " + tutorialGroup.getGroupName()+ " (" + tutorialGroup.getAvailableVacancies() + " vacancies)" );
                    TutGroupAssign.put(tutorialGroup.getGroupName(), index);
                }
                selectedTutorialGroupNum = scanner.nextInt();
                scanner.nextLine();
                if (selectedTutorialGroupNum < 1 || selectedTutorialGroupNum > index) {
                    System.out.println("Invalid choice. Please re-enter.");
                } else {
                    break;
                }
            } while (true);

            for (HashMap.Entry<String, Integer> entry : TutGroupAssign.entrySet()) {
                String tutGroupName = entry.getKey();
                int num = entry.getValue();
                if (num == selectedTutorialGroupNum) {
                    selectedTutorialGroupName = tutGroupName;
                    break;
                }
            }

            for (TutorialGroup tutorialGroup : currentCourse.getTutorialGroups()) {
                if (tutorialGroup.getGroupName().equals(selectedTutorialGroupName)) {
                    tutorialGroup.enrolledIn();
                    break;
                }
            }
        }


        if (currentCourse.getLabGroups().size() != 0) {
            System.out.println("Here is a list of all the lab groups with available slots:");
            do {
                System.out.println("Please enter an integer for your choice:");
                index = 0;
                for (LabGroup labGroup : currentCourse.getLabGroups()) {
                    if (labGroup.getAvailableVacancies() == 0) {
                        continue;
                    }
                    index++;
                    System.out.println(index + ": " + labGroup.getGroupName()+ " (" + labGroup.getAvailableVacancies() + " vacancies)");
                    LabGroupAssign.put(labGroup.getGroupName(), index);
                }
                selectedLabGroupNum = scanner.nextInt();
                scanner.nextLine();
                if (selectedLabGroupNum < 1 || selectedLabGroupNum > index) {
                    System.out.println("Invalid choice. Please re-enter.");
                } else {
                    break;
                }
            } while (true);

            for (HashMap.Entry<String, Integer> entry : LabGroupAssign.entrySet()) {
                String labGroupName = entry.getKey();
                int num = entry.getValue();
                if (num == selectedLabGroupNum) {
                    selectedLabGroupName = labGroupName;
                    break;
                }
            }

            for (LabGroup labGroup : currentCourse.getLabGroups()) {
                if (labGroup.getGroupName().equals(selectedLabGroupName)) {
                    labGroup.enrolledIn();
                    break;
                }
            }
        }

        currentCourse.enrolledIn();
        CourseRegistration courseRegistration = new CourseRegistration(currentStudent, currentCourse, selectedLectureGroupName, selectedTutorialGroupName, selectedLabGroupName);
        FILEMgr.writeCourseRegistrationIntoFile(courseRegistration);

        SCRAME.courseRegistrations.add(courseRegistration);

        SCRAME.marks.add(MarkMgr.initializeMark(currentStudent, currentCourse));

        System.out.println("Course registration for student: " + currentStudent.getStudentName() + " is successful");



        }

        public static void printStudents (){
//        Scanner scanner = new Scanner(System.in);
            System.out.println("printStudent is called");
            String courseID;
            Course currentCourse = null;
            boolean validCourseID = false;

            System.out.println("Enter course ID");
            courseID = scanner.nextLine();

            for (Course course : SCRAME.courses) {
                if (course.getCourseID().equals(courseID)) {
                    validCourseID = true;
                    currentCourse = course;
                    break;
                }
            }
            if (!validCourseID) {
                System.out.println("Invalid Course ID...");
                System.out.println("Exiting the print student");
                return;
            }


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

            // assume lecture,tut,lab groups are int

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

            // Exception handling
            // Get the course and all the registration record regarding this course. Call the function inside the CourseRegistration Mgr



        }
    }
