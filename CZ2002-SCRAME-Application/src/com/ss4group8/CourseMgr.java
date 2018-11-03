package com.ss4group8;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseMgr {
    private static Scanner scanner = new Scanner(System.in);
    public static Course addCourse(String courseID) {
        String courseName;
        int noOfLectureGroups;
        int totalSeats = 0;
        String profID;
        int groupNameExists,profExists;
        int profInChargeIndex = 0;
        ArrayList<Professor> professors = FILEMgr.loadProfessors();
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
            do {groupNameExists = 0;
                System.out.println("Enter a group Name: ");
                groupName = scanner.nextLine();
                if(lectureGroups.size() == 0){
                    break;
                }
                for(LectureGroup lectureGroup:lectureGroups){
                    if(lectureGroup.getGroupName().equals(groupName)){
                        groupNameExists=1;
                        break;
                    }
                }
            }while(groupNameExists==1);
            System.out.println("Enter group capacity");
            groupCapacity = scanner.nextInt();
            totalSeats += groupCapacity;
            scanner.nextLine();
            LectureGroup lectureGroup =  new LectureGroup(groupName, groupCapacity);
            lectureGroups.add(lectureGroup);
        }
        do{profExists = 0;
        System.out.println("Enter the ID for the professor in charge please:");
        profID = scanner.nextLine();
        for(Professor prof:professors){
            if(prof.getProfID() == profID){
                profExists = 1;
                profInChargeIndex ++;
                break;
            }
        }
        if(profExists==0){ System.out.println("This professor does not exist. Please re-enter.");}
        }while(profExists==0);
        Course course = new Course(courseID, courseName, professors.get(profInChargeIndex), totalSeats, lectureGroups);
        //add course into file
        FILEMgr.writeCourseIntoFile(course);
        return course;
    }

    public static void checkAvailableSlots(Course course){
        //printout the result directly
        System.out.println("This course " + course.getLectureGroups() + " still has " + course.getVacancies() + "available slots.");
    }
}