package com.ss4group8;

import java.util.Scanner;

public class CourseRegistrationMgr {
    private Scanner scanner = new Scanner(System.in);
    public CourseRegistration registerCourse() {
        String studentID;
        String courseID;

        System.out.println("Enter the Student ID: ");
        studentID = scanner.nextLine();
        System.out.println("Enter the Course ID: ");
        courseID = scanner.nextLine();

        // Need to access DB...
        // Check if this studentID, courseID is valid...
        // Check how many groups this course has...

        // Ask the student to register the groups...

        return new CourseRegistration("aaa", "bbbb", "ccccc");
    }

}
