package com.ss4group8;

import java.util.ArrayList;
import java.util.Scanner;

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


        return new CourseRegistration(student, course, selectedLectureGroupName, selectedTutorialGroupName, selectedLabGroupName);
    }

}
