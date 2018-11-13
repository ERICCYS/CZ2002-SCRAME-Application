package com.ss4group8;


import java.util.ArrayList;
import java.util.Scanner;

public class CourseMgr {
    private static Scanner scanner = new Scanner(System.in);


    public static void addCourse() {
        String courseID;
        String courseName;
        String profID;
        boolean groupNameExists, profExists, componentExist;
        int seatsLeft;
        // Can make the sameCourseID as boolean, set to false.
        boolean sameCourseID = false;
        System.out.println("addCourse is called");
        do {
            System.out.println("Give this course a course code");
            courseID = scanner.nextLine();
            for (Course course : SCRAME.courses) {
                sameCourseID = false;
                if (course.getCourseID().equals(courseID)) {
                    System.out.println("This course ID is already used. Please enter a new one.");
                    sameCourseID = true;
                    break;
                }
            }
        } while (sameCourseID);



        System.out.println("Enter course Name: ");
        courseName = scanner.nextLine();


        int totalSeats;
        System.out.println("Enter the total vacancy of this course: ");
        totalSeats = scanner.nextInt();
        while (totalSeats <= 0) {
            System.out.println("Please enter a valid vacancy (greater than 0)");
            totalSeats = scanner.nextInt();
        }


        int noOfLectureGroups;
        do {
            System.out.println("Enter the number of lecture groups:");
            // lecture group number cannot be 0 and also cannot be larger than totalSeats
            noOfLectureGroups = scanner.nextInt();
            scanner.nextLine();
            if (noOfLectureGroups > 0 && noOfLectureGroups <= totalSeats) {
                break;
            }
            System.out.println("Invalid input.");
            System.out.println("Number of lecture group must be postive but less than total seats in this course.");
            System.out.println("Please re-enter");
        } while (true);


        ArrayList<LectureGroup> lectureGroups = new ArrayList<LectureGroup>();
        String lectureGroupName;
        // GroupName cannot have duplicate inside one course.
        int lectureGroupCapacity;
        seatsLeft = totalSeats;
        // groupCapacity must be greater than 0;
        // The above two exceptions, we will create separate Exception classes to deal with them
        for (int i = 0; i < noOfLectureGroups; i++) {
//            System.out.println("Give a name to a group, the group will be named as: " + courseID + "GROUP_NAME.");
            System.out.println("Give a name to the lecture group");
            do {
                groupNameExists = false;
                System.out.println("Enter a group Name: ");
                lectureGroupName = scanner.nextLine();
                if (lectureGroups.size() == 0) {
                    break;
                }
                for (LectureGroup lectureGroup : lectureGroups) {
                    if (lectureGroup.getGroupName().equals(lectureGroupName)) {
                        groupNameExists = true;
                        System.out.println("This lecture group already exist.");
                        break;
                    }
                }
            } while (groupNameExists);


            do {
                System.out.println("Enter this lecture group's  capacity");
                do {
                    lectureGroupCapacity = scanner.nextInt();
                    scanner.nextLine();
                    if (lectureGroupCapacity > 0) {
                        break;
                    }
                    System.out.println("Capacity must be positive. Please re-enter.");
                } while (true);
                seatsLeft -= lectureGroupCapacity;
                if ((seatsLeft > 0 && i != (noOfLectureGroups - 1)) || (seatsLeft == 0 && i == noOfLectureGroups - 1)) {
                    LectureGroup lectureGroup = new LectureGroup(lectureGroupName, lectureGroupCapacity, lectureGroupCapacity);

                    lectureGroups.add(lectureGroup);
                    break;
                } else {
                    System.out.println("Sorry, the total capacity you allocated for all the lecture groups exceeds or does not add up to the total seats for this course.");
                    System.out.println("Please re-enter the capacity for the last lecture group " + lectureGroupName + " you have entered.");
                    seatsLeft += lectureGroupCapacity;
                    continue;
                }
            } while (true);
        }

        int noOfTutorialGroups;
        int totalTutorialSeats = 0;

        do {
            System.out.println("Enter the number of tutorial groups:");
            noOfTutorialGroups = scanner.nextInt();
            scanner.nextLine();
            if (noOfTutorialGroups >= 0) {
                break;
            }
            System.out.println("Invalid input.");
            System.out.println("Number of tutorial group must be non-negative.");
            System.out.println("Please re-enter");
        } while (true);

        ArrayList<TutorialGroup> tutorialGroups = new ArrayList<TutorialGroup>();
        String tutorialGroupName;
        int tutorialGroupCapacity;
        for (int i = 0; i < noOfTutorialGroups; i++) {
            System.out.println("Give a name to the tutorial group");
            do {
                groupNameExists = false;
                System.out.println("Enter a group Name: ");
                tutorialGroupName = scanner.nextLine();
                if (tutorialGroups.size() == 0) {
                    break;
                }
                for (TutorialGroup tutorialGroup : tutorialGroups) {
                    if (tutorialGroup.getGroupName().equals(tutorialGroupName)) {
                        groupNameExists = true;
                        System.out.println("This tutorial group already exist.");
                        break;
                    }
                }
            } while (groupNameExists);

            do {
                System.out.println("Enter this tutorial group's capacity");
                tutorialGroupCapacity = scanner.nextInt();
                scanner.nextLine();
                totalTutorialSeats += tutorialGroupCapacity;
                if ((i != noOfTutorialGroups - 1) || (totalTutorialSeats >= totalSeats)) {
                    TutorialGroup tutorialGroup = new TutorialGroup(tutorialGroupName, tutorialGroupCapacity, tutorialGroupCapacity);
                    tutorialGroups.add(tutorialGroup);
                    break;
                } else {
                    System.out.println("Sorry, the total capacity you allocated for all the tutorial groups is not enough for this course.");
                    System.out.println("Please re-enter the capacity for the last tutorial group " + tutorialGroupName + " you have entered.");
                    totalTutorialSeats -= tutorialGroupCapacity;
                }
            } while (true);
        }

        int noOfLabGroups;
        int totalLabSeats = 0;
        System.out.println("Enter the number of lab groups:");
        noOfLabGroups = scanner.nextInt();
        scanner.nextLine();
        ArrayList<LabGroup> labGroups = new ArrayList<LabGroup>();
        String labGroupName;
        int labGroupCapacity;
        for (int i = 0; i < noOfLabGroups; i++) {
            System.out.println("Give a name to this lab group");
            do {
                groupNameExists = false;
                System.out.println("Enter a group Name: ");
                labGroupName = scanner.nextLine();
                if (labGroups.size() == 0) {
                    break;
                }
                for (LabGroup labGroup : labGroups) {
                    if (labGroup.getGroupName().equals(labGroupName)) {
                        groupNameExists = true;
                        System.out.println("This lab group already exist.");
                        break;
                    }
                }
            } while (groupNameExists);

            do {
                System.out.println("Enter this lab group's capacity");
                labGroupCapacity = scanner.nextInt();
                scanner.nextLine();
                totalLabSeats += labGroupCapacity;
                if((i != noOfLabGroups - 1) || (totalLabSeats >= totalSeats)){
                    LabGroup labGroup = new LabGroup(labGroupName, labGroupCapacity, labGroupCapacity);
                    labGroups.add(labGroup);
                    break;
                } else {
                    System.out.println("Sorry, the total capacity you allocated for all the lab groups is not enough for this course.");
                    System.out.println("Please re-enter the capacity for the last lab group " + labGroupName + " you have entered.");
                    totalLabSeats -= labGroupCapacity;
                }
            } while (true);
        }

        Professor profInCharge = null;
        ArrayList<Professor> professors = FILEMgr.loadProfessors();

        do {
            profExists = false;
            System.out.println("Enter the ID for the professor in charge please:");
            profID = scanner.nextLine();
            for (Professor prof : professors) {
                if (prof.getProfID().equals(profID)) {
                    profExists = true;
                    profInCharge = prof;
                    break;
                }
            }
            if (!profExists) {
                System.out.println("This professor does not exist. Please re-enter.");
            }
        } while (!profExists);

        System.out.println("Create Course Component and set component weightage now?");
        System.out.println("1. Yes");
        System.out.println("2. Not yet");
        int addCourseComponentChoice;
        addCourseComponentChoice = scanner.nextInt();
        scanner.nextLine();

        while (addCourseComponentChoice > 2 || addCourseComponentChoice < 0) {
            System.out.println("Invalid choice, please choose again.");
            System.out.println("1. Yes");
            System.out.println("2. Not yet");
            addCourseComponentChoice = scanner.nextInt();
            scanner.nextLine();
        }
        if (addCourseComponentChoice == 2) {
            Course course = new Course(courseID, courseName, profInCharge, totalSeats, totalSeats, lectureGroups, tutorialGroups, labGroups);
            //add course into file
            FILEMgr.writeCourseIntoFile(course);
            SCRAME.courses.add(course);
            System.out.println("Course " + courseID + " is added, but assessment components are not initialized.");
            return;
        }

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
                componentExist = false;
                System.out.println("Enter a component Name: ");
                mainComponentName = scanner.nextLine();
                if (mainComponents.size() == 0) {
                    break;
                }
                for (MainComponent mainComponent : mainComponents) {
                    if (mainComponent.getComponentName().equals(mainComponentName)) {
                        componentExist = true;
                        System.out.println("This main component already exist.");
                        break;
                    }
                }
            } while (componentExist);


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
                        componentExist = false;
                        System.out.println("Enter a sub-component Name: ");
                        subComponentName = scanner.nextLine();
                        if (subComponents.size() == 0) {
                            break;
                        }
                        for (SubComponent subComponent : subComponents) {
                            if (subComponent.getComponentName().equals(subComponentName)) {
                                componentExist = true;
                                System.out.println("This sub component already exist.");
                                break;
                            }
                        }
                    } while (componentExist);


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

        Course course = new Course(courseID, courseName, profInCharge, totalSeats, totalSeats, lectureGroups, tutorialGroups, labGroups, mainComponents);
        //add course into file
        FILEMgr.writeCourseIntoFile(course);
        SCRAME.courses.add(course);
        System.out.println("Course " + courseID + " is added");
    }

    public static void checkAvailableSlots() {
        //printout the result directly
        System.out.println("checkAvailableSlots is called");
        String courseID;
        Course currentCourse = null;

        boolean exist;
        do {
            exist = false;
            System.out.println("Enter course ID");
            courseID = scanner.nextLine();
            for (Course course : SCRAME.courses) {
                if (course.getCourseID().equals(courseID)) {
                    exist = true;
                    currentCourse = course;
                    break;
                }
            }
            if (exist) {
                System.out.println(currentCourse.getCourseID() + " " + currentCourse.getCourseName() + " (Available/Total): " + currentCourse.getVacancies() + "/" + currentCourse.getTotalSeats());
                System.out.println("--------------------------------------------");
                for (LectureGroup lectureGroup : currentCourse.getLectureGroups()) {
                    System.out.println("Lecture group " + lectureGroup.getGroupName() + " (Available/Total): " + lectureGroup.getAvailableVacancies() + "/" + lectureGroup.getTotalSeats());
                }
                if (currentCourse.getTutorialGroups() != null) {
                    System.out.println();
                    for (TutorialGroup tutorialGroup : currentCourse.getTutorialGroups()) {
                        System.out.println("Tutorial group " + tutorialGroup.getGroupName() + " (Available/Total):  " + tutorialGroup.getAvailableVacancies() + "/" + tutorialGroup.getTotalSeats());
                    }
                }
                if (currentCourse.getLabGroups() != null) {
                    System.out.println();
                    for (LabGroup labGroup : currentCourse.getLabGroups()) {
                        System.out.println("Lab group " + labGroup.getGroupName() + " (Available/Total): " + labGroup.getAvailableVacancies() + "/" + labGroup.getTotalSeats());
                    }
                }
                System.out.println();
                break;
            } else {
                System.out.println("This course does not exist. Please check again.");
            }
        } while (true);

    }

    public static void enterCourseWorkComponentWeightage() {
        // ASSUME when course is created, no components are added yet
        // ASSUME once components are created and set, cannot be changed.
        int numberOfMain;
        int weight;
        int noOfSub;
        int sub_weight;
        Course currentCourse = null;
        System.out.println("enterCourseWorkComponentWeightage is called");
        String courseID;
        System.out.println("Enter course ID");
        courseID = scanner.nextLine();
        for (Course course : SCRAME.courses) {
            if (course.getCourseID().equals(courseID)) {
                currentCourse = course;
                break;
            }
        }

        if (currentCourse == null) {
            System.out.println("Invalid Course ID...");
            System.out.println("Exiting the set components and weightage");
            return;
        }
        // Exception handling
        // get the course and call the function inside the CourseMgr



        ArrayList<MainComponent> mainComponents = new ArrayList<MainComponent>(0);
        //Check if mainComponent is empty
        if (currentCourse.getMainComponents().size() == 0) {
            // empty course
            System.out.println("Currently course " + currentCourse.getCourseID() + " " + currentCourse.getCourseName() + " has " + currentCourse.getMainComponents().size() + " component(s).");
            do {
                System.out.println("Enter number of MAIN component(s) to add :");
                while (!scanner.hasNextInt()) {
                    String input = scanner.next();
                    System.out.println("Sorry. " + input + " is not an integer.");
                    System.out.println("Enter your choice :");
                }
                numberOfMain = scanner.nextInt();
                if (numberOfMain < 0) {
                    System.out.println("Please enter a valid positive integer:");
                    continue;
                }
                break;
            } while (true);
            scanner.nextLine();
            do {
                int totalWeightage = 100;
                for (int i = 0; i < numberOfMain; i++) {
                    ArrayList<SubComponent> subComponents = new ArrayList<SubComponent>(0);
                    System.out.println("Total weightage left to assign : " + totalWeightage);
                    System.out.println("Enter main component " + (i+1) + " name : ");
                    String name = scanner.nextLine();
                    do {
                        System.out.println("Enter main component " + (i+1) + " weightage : ");
                        while (!scanner.hasNextInt()) {
                            String input = scanner.next();
                            System.out.println("Sorry. " + input + " is not an integer.");
                            System.out.println("Enter your choice :");
                        }
                        weight = scanner.nextInt();
                        if (weight < 0 || weight > totalWeightage) {
                            System.out.println("Please enter a weight between 0 ~ "+totalWeightage+ " :");
                            continue;
                        }
                        break;
                    } while (true);
                    scanner.nextLine();
                    totalWeightage -=weight;
                    do {
                        System.out.println("Enter number of sub component under main component " + (i + 1) + " :");
                        while (!scanner.hasNextInt()) {
                            String input = scanner.next();
                            System.out.println("Sorry. " + input + " is not an integer.");
                            System.out.println("Enter your choice :");
                        }
                        noOfSub = scanner.nextInt();
                        if (noOfSub < 0 ) {
                            System.out.println("Please enter a valid positive integer:");
                            continue;
                        }
                        break;
                    } while (true);
                    scanner.nextLine();
                    boolean flagSub = true;
                    while (flagSub) {

                        int sub_totWeight = 100;
                        for (int j = 0; j < noOfSub; j++) {
                            System.out.println("Total weightage left to assign to sub component : " + sub_totWeight);
                            System.out.println("Enter sub component " + (j + 1) + " name : ");
                            String sub_name = scanner.nextLine();
                            do {
                                System.out.println("Enter sub component " + (j + 1) + " weightage : ");
                                while (!scanner.hasNextInt()) {
                                    String input = scanner.next();
                                    System.out.println("Sorry. " + input + " is not an integer.");
                                    System.out.println("Enter your choice :");
                                }
                                sub_weight = scanner.nextInt();
                                if (sub_weight < 0 || sub_weight > sub_totWeight) {
                                    System.out.println("Please enter a weight between 0 ~ "+sub_totWeight+ " :");
                                    continue;
                                }
                                break;
                            } while (true);
                            scanner.nextLine();

                            //Create Subcomponent

                            SubComponent sub = new SubComponent(sub_name, sub_weight);
                            subComponents.add(sub);
                            sub_totWeight -= sub_weight;
                        }
                        if (sub_totWeight != 0 && noOfSub != 0) {
                            System.out.println("ERROR! sub component weightage does not tally to 100");
                            System.out.println("You have to reassign!");
                            subComponents.clear();
                            flagSub = true;
                        } else {
                            flagSub = false;
                        }  //exit if weight is fully allocated
                    }
                    //Create main component
                    MainComponent main = new MainComponent(name, weight, subComponents);
                    mainComponents.add(main);
//                    for (int each_m = 0; each_m < mainComponents.size() ; each_m++){
//                        System.out.println("    "+mainComponents.get(each_m).getComponentName() + " : " + mainComponents.get(each_m).getComponentWeight() +"%" );
//                        mainComponents.get(each_m).printComponentType();
//                        ArrayList<SubComponent> dummy_sub = mainComponents.get(each_m).getSubComponents();
//                        for (int each_s = 0; each_s <dummy_sub.size(); each_s++){
//                            System.out.println("        "+dummy_sub.get(each_s).getComponentName() + " : " + dummy_sub.get(each_s).getComponentWeight() +"%" );
//                        }
//                    }
                }

                if (totalWeightage != 0) { // weightage assign is not tallied
                    System.out.println("Weightage assigned does not tally to 100!");
                    System.out.println("You have to reassign!");
                    mainComponents.clear();
                } else {
                    break;
                }
            } while (true);


            //set maincomponent to course
            currentCourse.setMainComponents(mainComponents);

        } else {
            System.out.println("Main component is not empty!");
        }
        System.out.println(currentCourse.getCourseID()+" "+ currentCourse.getCourseName() + " components: ");
        for (MainComponent each_comp : currentCourse.getMainComponents()){
            System.out.println("    "+each_comp.getComponentName() + " : " + each_comp.getComponentWeight() +"%" );
            for (SubComponent each_sub : each_comp.getSubComponents()){
                System.out.println("        "+each_sub.getComponentName() + " : " + each_sub.getComponentWeight() +"%" );
            }
        }
        // UPDATE COURSE into course.csv

    }
}