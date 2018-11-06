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
            do {
                groupNameExists = 0;
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
            } while(groupNameExists==1);
            System.out.println("Enter group capacity");
            groupCapacity = scanner.nextInt();
            totalSeats += groupCapacity;
            scanner.nextLine();
            LectureGroup lectureGroup =  new LectureGroup(groupName, groupCapacity);
            lectureGroups.add(lectureGroup);
        }
        do{
            profExists = 0;
            System.out.println("Enter the ID for the professor in charge please:");
            profID = scanner.nextLine();
            for(Professor prof:professors) {
                if(prof.getProfID().equals(profID)) {
                    profExists = 1;
                    // profInChargeIndex++;
                    // When the profID doesn't equals to this, profInChargeIndex++;
                    break;
                }
                else {
                    profInChargeIndex++;
                }
            }
            if(profExists == 0) {
                System.out.println("This professor does not exist. Please re-enter.");
            }
        } while(profExists==0);
        Course course = new Course(courseID, courseName, professors.get(profInChargeIndex), totalSeats, lectureGroups);
        //add course into file
        FILEMgr.writeCourseIntoFile(course);
        return course;
    }

    public static void checkAvailableSlots(Course course){
        //printout the result directly
        System.out.println("This course " + course.getLectureGroups() + " still has " + course.getVacancies() + "available slots.");
    }

    public static void setWeightage(Course course){
        // ASSUME when course is created, no components are added yet
        // ASSUME once components are created and set, cannot be changed.
        int totalWeightage = 100;
        ArrayList<SubComponent> subComponents = null;
        ArrayList<MainComponent> mainComponents = null;
        //Check if mainComponent is empty
        if ( course.getMainComponents().size() == 0){ // empty course
            System.out.println("Currently course "+course.getCourseID() + " "+ course.getCourseName()+ " has "+course.getMainComponents().size() + "component(s).");
            System.out.print("Enter number of MAIN component(s) to add : ");
            int numberOfMain = scanner.nextInt();
            System.out.println();
            boolean flagMain = true; // true means first entry
            do {
                for (int i = 0; i < numberOfMain; i++) {
                    System.out.println("Total weightage left to assign : " + totalWeightage);
                    System.out.print("Enter main component " + i + " name : ");
                    String name = scanner.next();
                    System.out.println();
                    System.out.print("Enter main component " + i + " weightage : ");
                    int weight = scanner.nextInt();
                    System.out.println();
                    System.out.print("Enter number of sub component under main component " + i + " :");
                    int noOfSub = scanner.nextInt();
                    System.out.println();
                    boolean flagSub = true;
                    do {

                        int sub_totWeight = 100;
                        for (int j = 0; j < noOfSub; j++) {
                            System.out.println("Total weightage left to assign to sub component : " + sub_totWeight);
                            System.out.print("Enter sub component " + j + " name : ");
                            String sub_name = scanner.next();
                            System.out.println();
                            System.out.print("Enter sub component " + j + " weightage : ");
                            int sub_weight = scanner.nextInt();
                            System.out.println();

                            //Create Subcomponent

                            SubComponent sub = new SubComponent(sub_name, sub_weight);
                            subComponents.add(sub);
                            sub_totWeight -= sub_weight;
                        }
                        if (sub_totWeight != 0) {

                            System.out.println("ERROR! sub component weightage does not tally to 100");
                            System.out.println("You have to reassign!");
                            subComponents.clear();
                        }
                        else {flagSub = false;}  //exit if weight is fully allocated
                    } while (flagSub == true);
                    //Create main component
                    MainComponent main = new MainComponent(name,weight,subComponents);
                    mainComponents.add(main);
                    totalWeightage -= weight;
                }
                if (totalWeightage != 0) { // weightage assign is not tallied
                    System.out.println("Weightage assigned does not tally to 100!");
                    System.out.println("You have to reassign!");
                    mainComponents.clear();
                }
                else{flagMain = false;}
            }while (flagMain == true);

            //set maincomponent to course
            course.setMainComponents(mainComponents);

        }
        else{
            System.out.println("Main component is not empty!");
        }
    }


}