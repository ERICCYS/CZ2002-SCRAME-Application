package com.ss4group8;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseMgr {
    private static Scanner scanner = new Scanner(System.in);
    public static Course addCourse(String courseID) {
        String courseName;
        int noOfLectureGroups;
        System.out.println("Enter course Name: ");
        courseName = scanner.nextLine();
        System.out.println("Enter the number of lecture groups:");
        noOfLectureGroups = scanner.nextInt();
        scanner.nextLine();
        ArrayList<LectureGroup> lectureGroups = new ArrayList<LectureGroup>();
        String groupName;
        // GroupName cannot have duplicate inside one course.
        int groupCapacity;
        // groupCapacity must be greater than 0;
        // The above two exceptions, we will create separate Exception classes to deal with them
        for (int i = 0; i < noOfLectureGroups; i++) {
            System.out.println("Give a name to a group, the group will be named as: " + courseID + "GROUP_NAME.");
            System.out.println("Enter a group Name: ");
            groupName = scanner.nextLine();
            // Exception handling, what is this group name already exist for this course?!
            System.out.println("Enter group capacity");
            groupCapacity = scanner.nextInt();
            scanner.nextLine();
            LectureGroup lectureGroup =  new LectureGroup(groupName, groupCapacity);
            lectureGroups.add(lectureGroup);
        }
        // Here is the simplest version, haven't consider the other attributes yet.
        Course course = new Course(courseID, courseName, lectureGroups);
        //add course into file
        FILEMgr.writeCourseIntoFile(course);
        return course;
    }

    public static void checkAvailableSlots(Course course){
        //printout the result directly
        int vacancy = 0;
        for(LectureGroup lecGroup:course.getLectureGroups()){
            vacancy += lecGroup.getCapacity();
        }
        System.out.println("This course " + course.getLectureGroups() + " still has " + vacancy + "available slots.");
    }
}