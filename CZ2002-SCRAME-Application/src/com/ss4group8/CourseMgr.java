package com.ss4group8;


import java.util.ArrayList;
import java.util.Scanner;

public class CourseMgr {
    private static Scanner scanner = new Scanner(System.in);

    public static Course addCourse(String courseID) {
        String courseName;
        String profID;
        int groupNameExists, profExists, componentExist;

        int profInChargeIndex = 0;
        ArrayList<Professor> professors = FILEMgr.loadProfessors();
        System.out.println("Enter course Name: ");
        courseName = scanner.nextLine();


        int totalSeats = 0;
        System.out.println("Enter the total vacancy of this course: ");
        totalSeats = scanner.nextInt();
        while (totalSeats <= 0) {
            System.out.println("Please enter a valid vacancy (greater than 0)");
            totalSeats = scanner.nextInt();
        }


        int noOfLectureGroups;
        System.out.println("Enter the number of lecture groups:");
        // lecture group number cannot be 0
        noOfLectureGroups = scanner.nextInt();
        scanner.nextLine();


        ArrayList<LectureGroup> lectureGroups = new ArrayList<LectureGroup>();
        String lectureGroupName;
        // GroupName cannot have duplicate inside one course.
        int lectureGroupCapacity;
        // groupCapacity must be greater than 0;
        // The above two exceptions, we will create separate Exception classes to deal with them
        for (int i = 0; i < noOfLectureGroups; i++) {
//            System.out.println("Give a name to a group, the group will be named as: " + courseID + "GROUP_NAME.");
            System.out.println("Give a name to the lecture group");
            do {
                groupNameExists = 0;
                System.out.println("Enter a group Name: ");
                lectureGroupName = scanner.nextLine();
                if (lectureGroups.size() == 0) {
                    break;
                }
                for (LectureGroup lectureGroup : lectureGroups) {
                    if (lectureGroup.getGroupName().equals(lectureGroupName)) {
                        groupNameExists = 1;
                        System.out.println("This lecture group already exist.");
                        break;
                    }
                }
            } while (groupNameExists == 1);
            System.out.println("Enter this lecture group's  capacity");
            lectureGroupCapacity = scanner.nextInt();
//            totalSeats += lectureGroupCapacity;
            scanner.nextLine();
            LectureGroup lectureGroup = new LectureGroup(lectureGroupName, lectureGroupCapacity);
            lectureGroups.add(lectureGroup);
        }

        int noOfTutorialGroups;
        System.out.println("Enter the number of tutorial groups:");
        noOfTutorialGroups = scanner.nextInt();
        scanner.nextLine();
        ArrayList<TutorialGroup> tutorialGroups = new ArrayList<TutorialGroup>();
        String tutorialGroupName;
        // GroupName cannot have duplicate inside one course.
        int tutorialGroupCapacity;
        // groupCapacity must be greater than 0;
        // The above two exceptions, we will create separate Exception classes to deal with them
        for (int i = 0; i < noOfTutorialGroups; i++) {
//            System.out.println("Give a name to a group, the group will be named as: " + courseID + "GROUP_NAME.");
            System.out.println("Give a name to the tutorial group");
            do {
                groupNameExists = 0;
                System.out.println("Enter a group Name: ");
                tutorialGroupName = scanner.nextLine();
                if (tutorialGroups.size() == 0) {
                    break;
                }
                for (TutorialGroup tutorialGroup : tutorialGroups) {
                    if (tutorialGroup.getGroupName().equals(tutorialGroupName)) {
                        groupNameExists = 1;
                        System.out.println("This tutorial group already exist.");
                        break;
                    }
                }
            } while (groupNameExists == 1);
            System.out.println("Enter this tutorial group's capacity");
            tutorialGroupCapacity = scanner.nextInt();
//            totalSeats += tutorialGroupCapacity;
            scanner.nextLine();
            TutorialGroup tutorialGroup = new TutorialGroup(tutorialGroupName, tutorialGroupCapacity);
            tutorialGroups.add(tutorialGroup);
        }

        int noOfLabGroups;
        System.out.println("Enter the number of lab groups:");
        noOfLabGroups = scanner.nextInt();
        scanner.nextLine();
        ArrayList<LabGroup> labGroups = new ArrayList<LabGroup>();
        String labGroupName;
        // GroupName cannot have duplicate inside one course.
        int labGroupCapacity;
        // groupCapacity must be greater than 0;
        // The above two exceptions, we will create separate Exception classes to deal with them
        for (int i = 0; i < noOfLabGroups; i++) {
//            System.out.println("Give a name to a group, the group will be named as: " + courseID + "GROUP_NAME.");
            System.out.println("Give a name to this lab group");
            do {
                groupNameExists = 0;
                System.out.println("Enter a group Name: ");
                labGroupName = scanner.nextLine();
                if (labGroups.size() == 0) {
                    break;
                }
                for (LabGroup labGroup : labGroups) {
                    if (labGroup.getGroupName().equals(labGroupName)) {
                        groupNameExists = 1;
                        System.out.println("This lab group already exist.");
                        break;
                    }
                }
            } while (groupNameExists == 1);
            System.out.println("Enter this lab group's capacity");
            labGroupCapacity = scanner.nextInt();
            scanner.nextLine();
//            totalSeats += labGroupCapacity;
            LabGroup labGroup = new LabGroup(labGroupName, labGroupCapacity);
            labGroups.add(labGroup);
        }


        do {
            profExists = 0;
            System.out.println("Enter the ID for the professor in charge please:");
            profID = scanner.nextLine();
            for (Professor prof : professors) {
                if (prof.getProfID().equals(profID)) {
                    profExists = 1;
                    // profInChargeIndex++;
                    // When the profID doesn't equals to this, profInChargeIndex++;
                    break;
                } else {
                    profInChargeIndex++;
                }
            }
            if (profExists == 0) {
                System.out.println("This professor does not exist. Please re-enter.");
            }
        } while (profExists == 0);


        int noOfCourseworkComponents;
        System.out.println("Enter the number of main assessment component of this course (e.g. Exam, Coursework etc.): ");
        noOfCourseworkComponents = scanner.nextInt();
        scanner.nextLine();
        ArrayList<MainComponent> mainComponents = new ArrayList<MainComponent>();

        String mainComponentName;
        int mainComponentWeight;
        int weightRemaining = 100;

        for (int i = 0; i < noOfCourseworkComponents; i++) {
            System.out.println("Give this component a name");
            do {
                componentExist = 0;
                System.out.println("Enter a component Name: ");
                mainComponentName = scanner.nextLine();
                if (mainComponents.size() == 0) {
                    break;
                }
                for (MainComponent mainComponent : mainComponents) {
                    if (mainComponent.getComponentName().equals(mainComponentName)) {
                        componentExist = 1;
                        System.out.println("This main component already exist.");
                        break;
                    }
                }
            } while (componentExist == 1);


            if (i != noOfCourseworkComponents - 1) {
                System.out.print(weightRemaining + "% unallocated. ");
                System.out.println("Enter the weight allocation to this component:");
                mainComponentWeight = scanner.nextInt();
                scanner.nextLine();

                while (mainComponentWeight >= weightRemaining) {
                    if (mainComponentWeight > weightRemaining)
                        System.out.println("Weight entered is invalid, please enter again: ");
                    else
                        System.out.println("You need to consider the weight allocation of another " + (noOfCourseworkComponents - 1 - i) + "main assessments");

                    mainComponentWeight = scanner.nextInt();
                    scanner.nextLine();
                }
                weightRemaining -= mainComponentWeight;
                System.out.println("Allocation succeed. " + weightRemaining + "% unallocated");
            } else {
                System.out.print(weightRemaining + "% unallocated. ");
                System.out.println(weightRemaining + "% of the course will be allocated to this assessment.");
                mainComponentWeight = weightRemaining;
                weightRemaining = 0;
            }

            int noOfSubComponent;

            System.out.println("Enter the number of sub assessment components (if no sub component, enter 0): ");
            noOfSubComponent = scanner.nextInt();
            scanner.nextLine();
            ArrayList<SubComponent> subComponents = new ArrayList<SubComponent>();

            if (noOfSubComponent > 0) {
                String subComponentName;
                int subComponentWeight;
                int subWeightRemaining = 100;

                for (int j = 0; j < noOfSubComponent; j++) {
                    System.out.println("Give this sub-component a name");
                    do {
                        componentExist = 0;
                        System.out.println("Enter a sub-component Name: ");
                        subComponentName = scanner.nextLine();
                        if (subComponents.size() == 0) {
                            break;
                        }
                        for (SubComponent subComponent : subComponents) {
                            if (subComponent.getComponentName().equals(subComponentName)) {
                                componentExist = 1;
                                System.out.println("This sub component already exist.");
                                break;
                            }
                        }
                    } while (componentExist == 1);


                    if (j != noOfSubComponent - 1) {
                        System.out.print(subWeightRemaining + "% unallocated. ");
                        System.out.println("Enter the weight allocation to this component:");
                        subComponentWeight = scanner.nextInt();
                        scanner.nextLine();

                        while (subComponentWeight >= subWeightRemaining) {
                            if (subComponentWeight > subWeightRemaining)
                                System.out.println("Weight entered for this sub component is invalid, please enter again: ");
                            else
                                System.out.println("You need to consider the weight allocation of another " + (noOfSubComponent - 1 - j) + "sub assessments");

                            subComponentWeight = scanner.nextInt();
                            scanner.nextLine();
                        }


                        subComponents.add(new SubComponent(subComponentName, subComponentWeight));
                        subWeightRemaining -= subComponentWeight;
                        System.out.println("Allocation succeed. " + subWeightRemaining + "% unallocated for sub-components in " + mainComponentName);
                    } else {
                        System.out.print(subWeightRemaining + "% unallocated. ");
                        System.out.println(subWeightRemaining + "% weight of main assessment " + mainComponentName + " will be allocated to this sub-assessment");
                        subComponentWeight = subWeightRemaining;
                        subComponents.add(new SubComponent(subComponentName, subComponentWeight));
                        subWeightRemaining = 0;
                    }
                }

            }

            mainComponents.add(new MainComponent(mainComponentName, mainComponentWeight, subComponents));
        }

        Course course = new Course(courseID, courseName, professors.get(profInChargeIndex), totalSeats, totalSeats, lectureGroups, tutorialGroups, labGroups, mainComponents);
        //add course into file
        FILEMgr.writeCourseIntoFile(course);
        return course;
    }

    public static void checkAvailableSlots(Course course) {
        //printout the result directly
        System.out.println("This course " + course.getCourseID() + " " + course.getCourseName() + " still has " + course.getVacancies() + " available slots.");
        System.out.println("------------------------------------------------------------------------------");
        for (LectureGroup lectureGroup : course.getLectureGroups()) {
            System.out.println("Lecture group " + lectureGroup.getGroupName() + " still has " + lectureGroup.getAvailableVacancies() + " available slots");
        }
        if (course.getTutorialGroups() != null) {
            System.out.println("------------------------------------------------------------------------------");
            for (TutorialGroup tutorialGroup : course.getTutorialGroups()) {
                System.out.println("Tutorial group " + tutorialGroup.getGroupName() + " still has " + tutorialGroup.getAvailableVacancies() + " available slots");
            }
        }
        if (course.getLabGroups() != null) {
            System.out.println("------------------------------------------------------------------------------");
            for (LabGroup labGroup : course.getLabGroups()) {
                System.out.println("Tutorial group " + labGroup.getGroupName() + " still has " + labGroup.getAvailableVacancies() + " available slots");
            }
        }
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