package com.ss4group8;

import java.util.ArrayList;
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


        ArrayList<String> lectureGroupNames = new ArrayList<String>(0);
        ArrayList<String> tutorialGroupNames = new ArrayList<String>(0);
        ArrayList<String> labGroupNames = new ArrayList<String>(0);

        String selectedLectureGroupName = null;
        String selectedTutorialGroupName = null;
        String selectedLabGroupName = null;

        if (course.getLectureGroups().size() != 0) {
            for (int i = 0; i < course.getLectureGroups().size(); i++) {
                lectureGroupNames.add(course.getLectureGroups().get(i).getGroupName());
                System.out.println(course.getLectureGroups().get(i).getGroupName() + " still has " +
                        course.getLectureGroups().get(i).getAvailableVacancies() + " vacancies");
            }

            System.out.println("Choose a lecture Group to enroll in: ");
            selectedLectureGroupName = scanner.nextLine();
            while (!lectureGroupNames.contains(selectedLectureGroupName)) {
                System.out.println("Invalid lecture group, enter again: ");
                selectedLectureGroupName = scanner.nextLine();
            }

            for (LectureGroup lectureGroup : course.getLectureGroups()) {
                if (lectureGroup.getGroupName().equals(selectedLectureGroupName)) {
                    lectureGroup.enrolledIn();
                    break;
                }
            }
        }

        if (course.getTutorialGroups().size() != 0) {
            for (int i = 0; i < course.getTutorialGroups().size(); i++) {
                tutorialGroupNames.add(course.getTutorialGroups().get(i).getGroupName());
                System.out.println(course.getTutorialGroups().get(i).getGroupName() + " still has " +
                        course.getTutorialGroups().get(i).getAvailableVacancies() + " vacancies");
            }

            System.out.println("Choose a tutorial Group to enroll in: ");
            selectedTutorialGroupName = scanner.nextLine();

            while (!tutorialGroupNames.contains(selectedTutorialGroupName)) {
                System.out.println("Invalid tutorial group, enter again: ");
                selectedTutorialGroupName = scanner.nextLine();
            }


            for (TutorialGroup tutorialGroup : course.getTutorialGroups()) {
                if (tutorialGroup.getGroupName().equals(selectedTutorialGroupName)) {
                    tutorialGroup.enrolledIn();
                    break;
                }
            }
        }

        if (course.getLabGroups().size() != 0) {
            for (int i = 0; i < course.getLabGroups().size(); i++) {
                labGroupNames.add(course.getLabGroups().get(i).getGroupName());
                System.out.println(course.getLabGroups().get(i).getGroupName() + " still has " +
                        course.getLabGroups().get(i).getAvailableVacancies() + " vacancies");
            }

            System.out.println("Choose a lab Group to enroll in: ");
            selectedLabGroupName = scanner.nextLine();

            while (!labGroupNames.contains(selectedLabGroupName)) {
                System.out.println("Invalid lab group, enter again: ");
                selectedLabGroupName = scanner.nextLine();
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

    public static void printStudents(Course course) {
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
