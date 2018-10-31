package com.ss4group8;

import java.util.ArrayList;
import java.util.Scanner;

public class SCRAME {
    public static Scanner scanner = new Scanner(System.in);

    public static ArrayList<Student> students = new ArrayList<Student>(0);
    public static ArrayList<Course> courses = new ArrayList<Course>(0);
    public static ArrayList<CourseRegistration> courseRegistrations = new ArrayList<CourseRegistration>(0);
    public static ArrayList<Mark> marks = new ArrayList<Mark>(0);
    public static ArrayList<Professor> professors = new ArrayList<Professor>(0);

    public static void main(String[] args) {

//        Functions to be implmented to get the data
//        students = FILEIOMgr.loadStudents();
//        courses = FILEIOMgr.loadCourses();
//        courseRegistrations = FILEIOMgr.loadCourseRegistrations();
//        marks = FILEIOMgr.loadMarks();

        printWelcome();
        printOptions();

        int choice = 0;
        do {
            System.out.println("Enter your choice, let me help you:");
            choice = scanner.nextInt();
            scanner.nextLine();
            while (choice < 0 || choice > 11) {
                System.out.println("Please enter 0 ~ 11 for your choice:");
                choice = scanner.nextInt();
                scanner.nextLine();
            }
            switch (choice) {
                case 0:
                    printOptions();
                    break;
                case 1:
                    addStudent();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    registerCourse();
                    break;
                case 4:
                    checkAvailableSlots();
                    break;
                case 5:
                    printStudents();
                    break;
                case 6:
                    enterCourseWorkComponentWeightage();
                    break;
                case 7:
                    enterCourseWorkMark();
                    break;
                case 8:
                    enterExamMark();
                    break;
                case 9:
                    printCourseStatistics();
                    break;
                case 10:
                    printStudentTranscript();
                    break;
                case 11:
                    printBye();
                    break;

            }

        } while (choice != 11);
    }
    public static void printWelcome() {
        System.out.printf("\n");
        System.out.println("#######   #######   #######       #       ##       ##   #######");
        System.out.println("#         #         #    ##      # #      # #     # #   #      ");
        System.out.println("#         #         #   ##      #   #     # #     # #   #      ");
        System.out.println("#######   #         #####       #####     #  #  #   #   #######");
        System.out.println("      #   #         #   #      #     #    #  #  #   #   #      ");
        System.out.println("      #   #         #    #     #     #    #   ##    #   #      ");
        System.out.println("#######   #######   #     #   #       #   #   ##    #   #######");
        System.out.printf("\n");
        System.out.println("****************** Hello! Welcome to SCRAME! ******************");
        System.out.printf("\n");
    }

    public static void printBye() {
        System.out.printf("\n");
        System.out.println("********* Bye! Thank you for using SCRAME! *********");
        System.out.printf("\n");
        System.out.println("                 ######    #      #   #######                   ");
        System.out.println("                 #    ##    #    #    #                         ");
        System.out.println("                 #    ##     #  #     #                         ");
        System.out.println("                 ######       ##      #######                   ");
        System.out.println("                 #    ##      ##      #                         ");
        System.out.println("                 #    ##      ##      #                         ");
        System.out.println("                 ######       ##      #######                   ");
        System.out.printf("\n");

    }

    public static void printOptions() {
        System.out.println("************ I can help you with these functions: *************");
        System.out.println(" 0. Print Options");
        System.out.println(" 1. Add a student");
        System.out.println(" 2. Add a course");
        System.out.println(" 3. Register student for a course including tutorial/lab classes");
        System.out.println(" 4. Check available slots in a class (vacancy in a class)");
        System.out.println(" 5. Print student list by lecture, tutorial or laboratory session for a course");
        System.out.println(" 6. Enter course assessment components weightage");
        System.out.println(" 7. Enter coursework mark – inclusive of its components");
        System.out.println(" 8. Enter exam mark");
        System.out.println(" 9. Print course statistics");
        System.out.println("10. Print student transcript");
        System.out.println("11. Quit SCRAME System");
        System.out.println("\n");
    }

    public static void addStudent() {
        String studentName;
        String studentID;
        System.out.println("addStudent is called");
        System.out.println("Enter student Name: ");
        studentName = scanner.nextLine();
        System.out.println("Give this student an ID");
        studentID = scanner.nextLine();
        // Exception handling

        StudentMgr.addStudent();
    }

    public static void addCourse() {
        System.out.println("addCourse is called");
        String courseName;
        String courseID;
        System.out.println("addStudent is called");
        System.out.println("Enter course Name: ");
        courseName = scanner.nextLine();
        System.out.println("Give this course an ID");
        courseID = scanner.nextLine();
        // Exception handling

    }

    public static void registerCourse() {
        System.out.println("registerCourse is called");
        String studentID;
        System.out.println("Enter Student ID:");
        studentID = scanner.nextLine();
        // Exception handling
        String courseID;
        System.out.println("Enter course ID");
        courseID = scanner.nextLine();
        // Exception handling
        // Get the course and student. Call the function inside CourseRegistration Mgr
    }

    public static void checkAvailableSlots() {
        System.out.println("checkAvailableSlots is called");
        String courseID;
        System.out.println("Enter course ID");
        courseID = scanner.nextLine();
        // Exception handling
        // Get the course and student. Call the function inside the Course Mgr
    }

    public static void printStudents() {
        System.out.println("printStudent is called");
        String courseID;
        System.out.println("Enter course ID");
        courseID = scanner.nextLine();
        // Exception handling
        // Get the course and all the registration record regarding this course. Call the function inside the CourseRegistration Mgr
    }

    public static void enterCourseWorkComponentWeightage() {
        System.out.println("enterCourseWorkComponentWeightage is called");
        System.out.println("printStudent is called");
        String courseID;
        System.out.println("Enter course ID");
        courseID = scanner.nextLine();
        // Exception handling
        // get the course and call the function inside the CourseMgr
    }

    public static void enterCourseWorkMark() {
        System.out.println("enterCourseWorkMark is called");
        String studentID;
        System.out.println("Enter Student ID:");
        studentID = scanner.nextLine();
        // Exception handling
        String courseID;
        System.out.println("Enter course ID");
        courseID = scanner.nextLine();
        // Exception handling
        // Get the course and student. Call the function inside MarkMgr
    }

    public static void enterExamMark() {
        System.out.println("enterExamMark is called");
        String studentID;
        System.out.println("Enter Student ID:");
        studentID = scanner.nextLine();
        // Exception handling
        String courseID;
        System.out.println("Enter course ID");
        courseID = scanner.nextLine();
        // Exception handling
        // Get the course and student. Call the function inside MarkMgr
    }

    public static void printCourseStatistics() {
        System.out.println("printCourseStatistics is called");
    }

    public static void printStudentTranscript() {
        System.out.println("printStudentTranscript is called");
    }
}
