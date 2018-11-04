package com.ss4group8;

import java.util.Scanner;

public class CourseRegistrationMgr {
    private Scanner scanner = new Scanner(System.in);
    public static CourseRegistration registerCourse(Student student, Course course) {
        System.out.println("Student " + student.getStudentName() + " with ID: " + student.getStudentID() +
         " wants to register " + course.getCourseID() + " " + course.getCourseName());


        return new CourseRegistration();
    }

}
