package com.ss4group8;

public class Main {

    public static void main(String[] args) {
        // If we want to create a new course...
        CourseMgr courseMgr = new CourseMgr();
        Course course =  courseMgr.addCourse();
        System.out.println("The course u just created is: " + course.getCourseID());
        System.out.println("The course has " + course.getLectureGroups().size() + "lecture groups ");



    }
}
