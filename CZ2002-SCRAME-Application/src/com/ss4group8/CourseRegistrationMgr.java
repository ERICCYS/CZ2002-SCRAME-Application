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

    public static CourseRegistration registerCourse(Student student, Course course) {
        System.out.println("Student " + student.getStudentName() + " with ID: " + student.getStudentID() +
                " wants to register " + course.getCourseID() + " " + course.getCourseName());

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

        System.out.println("Here is a list of all the lecture groups with available slots:");
        do {
            System.out.println("Please enter an integer for your choice:");
            index = 0;
            for (LectureGroup lectureGroup : course.getLectureGroups()) {
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

        for (LectureGroup lectureGroup : course.getLectureGroups()) {
            if (lectureGroup.getGroupName().equals(selectedLectureGroupName)) {
                lectureGroup.enrolledIn();
                break;
            }
        }


        if (course.getTutorialGroups().size() != 0) {
            System.out.println("Here is a list of all the tutorial groups with available slots:");
            do {
                System.out.println("Please enter an integer for your choice:");
                index = 0;
                for (TutorialGroup tutorialGroup : course.getTutorialGroups()) {
                    if (tutorialGroup.getAvailableVacancies() == 0) {
                        continue;
                    }
                    index++;
                    System.out.println(index + ": " + tutorialGroup.getGroupName());
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

            for (TutorialGroup tutorialGroup : course.getTutorialGroups()) {
                if (tutorialGroup.getGroupName().equals(selectedTutorialGroupName)) {
                    tutorialGroup.enrolledIn();
                    break;
                }
            }
        }


            if (course.getLabGroups().size() != 0) {
                System.out.println("Here is a list of all the lab groups with available slots:");
                do {
                    System.out.println("Please enter an integer for your choice:");
                    index = 0;
                    for (LabGroup labGroup : course.getLabGroups()) {
                        if (labGroup.getAvailableVacancies() == 0) {
                            continue;
                        }
                        index++;
                        System.out.println(index + ": " + labGroup.getGroupName());
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

                for (LabGroup labGroup : course.getLabGroups()) {
                    if (labGroup.getGroupName().equals(selectedLabGroupName)) {
                        labGroup.enrolledIn();
                        break;
                    }
                }
            }

            course.enrolledIn();
            CourseRegistration courseRegistration = new CourseRegistration(student, course, selectedLectureGroupName, selectedTutorialGroupName, selectedLabGroupName);
            FILEMgr.writeCourseRegistrationIntoFile(courseRegistration);

            return courseRegistration;
        }

        public static void printStudents (Course course){
//        Scanner scanner = new Scanner(System.in);
            System.out.println("Print student by: ");
            System.out.println("(1) Lecture group");
            System.out.println("(2) Tutorial group");
            System.out.println("(3) Lab group");

            int opt = scanner.nextInt();

            // READ courseRegistrationFILE
            // return ArrayList of Object(student,course,lecture,tut,lab)
            ArrayList<CourseRegistration> allStuArray = FILEMgr.loadCourseRegistration();
            ArrayList<CourseRegistration> stuArray = new ArrayList<CourseRegistration>(0);

            for (CourseRegistration courseRegistration : allStuArray) {
                if (courseRegistration.getCourse().getCourseID().equals(course.getCourseID())) {
                    stuArray.add(courseRegistration);
                }
            }

            // assume lecture,tut,lab groups are int

            if (opt == 1) { // print by LECTURE
                String newLec = "";
                Collections.sort(stuArray, LecComparator);   // Sort by Lecture group
                for (int i = 0; i < stuArray.size() - 1; i++) {  // loop through all of CourseRegistration Obj
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
                for (int i = 0; i < stuArray.size() - 1; i++) {
                    if (!newTut.equals(stuArray.get(i).getTutorialGroup())) {
                        newTut = stuArray.get(i).getTutorialGroup();
                        System.out.println("------------------------------------------------------");
                        System.out.println("Tutorial group : " + newTut);
                    }
                    System.out.print("Student Name: " + stuArray.get(i).getStudent().getStudentName());
                    System.out.println("Student ID: " + stuArray.get(i).getStudent().getStudentID());
                }
            } else if (opt == 3) { // print by LAB
                String newLab = "";
                Collections.sort(stuArray, LabComparator);
                for (int i = 0; i < stuArray.size() - 1; i++) {
                    if (!newLab.equals(stuArray.get(i).getLabGroup())) {
                        newLab = stuArray.get(i).getLabGroup();
                        System.out.println("------------------------------------------------------");
                        System.out.println("Lab group : " + newLab);
                    }
                    System.out.print("Student Name: " + stuArray.get(i).getStudent().getStudentName());
                    System.out.println("Student ID: " + stuArray.get(i).getStudent().getStudentID());
                }
            }


        }
    }
