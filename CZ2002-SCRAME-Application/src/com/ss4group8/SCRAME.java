package com.ss4group8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The main class of the system.
 * @author Ma Xiao
 * @author Fu Mengyan
 * @author Kevin Steven Kihata
 * @author Ng Chen Ee Kenneth
 * @author Ian Tan Yi
 * @version 1.0
 */

public class SCRAME {
    public static Scanner scanner = new Scanner(System.in);
    /**
     * An array list of all the students in this school.
     */
    public static ArrayList<Student> students = new ArrayList<Student>(0);
    /**
     * An array list of all the courses in this school.
     */
    public static ArrayList<Course> courses = new ArrayList<Course>(0);
    /**
     * An array list of all the course registration records in this school.
     */
    public static ArrayList<CourseRegistration> courseRegistrations = new ArrayList<CourseRegistration>(0);
    /**
     * An array list of all the student mark records in this school.
     */
    public static ArrayList<Mark> marks = new ArrayList<Mark>(0);
    /**
     * An array list of all the professors in this school.
     */
    public static ArrayList<Professor> professors = new ArrayList<Professor>(0);

    /**
     * The main function of the system.
     * Command line interface.
     * @param args The command line parameters.
     */
    public static void main(String[] args) {

        students = FILEMgr.loadStudents();
        courses = FILEMgr.loadCourses();
        courseRegistrations = FILEMgr.loadCourseRegistration();
        marks = FILEMgr.loadStudentMarks();
        professors = FILEMgr.loadProfessors();

        printWelcome();

        int choice;
        do {
            printOptions();
            do {
                System.out.println("Enter your choice, let me help you:");
                while (!scanner.hasNextInt()) {
                    System.out.println("Sorry. " + scanner.nextLine() + " is not an integer.");
                    System.out.println("Enter your choice, let me help you:");
                }
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice < 0 || choice > 11) {
                    System.out.println("Please enter 0 ~ 11 for your choice:");
                    continue;
                }
                break;
            } while (true);

            switch (choice) {
                case 0:
                    printOptions();
                    break;
                case 1:
                    StudentMgr.addStudent();
                    break;
                case 2:
                    CourseMgr.addCourse();
                    break;
                case 3:
                    CourseRegistrationMgr.registerCourse();
                    break;
                case 4:
                    CourseMgr.checkAvailableSlots();
                    break;
                case 5:
                    CourseRegistrationMgr.printStudents();
                    break;
                case 6:
                    CourseMgr.enterCourseWorkComponentWeightage(null);
                    break;
                case 7:
                    MarkMgr.setCourseWorkMark(false);
                    break;
                case 8:
                    MarkMgr.setCourseWorkMark(true);
                    break;
                case 9:
                    MarkMgr.printCourseStatistics();
                    break;
                case 10:
                    MarkMgr.printStudentTranscript();
                    break;
                case 11:
                    exitApplication();
                    break;

            }

        } while (choice != 11);
    }

    /**
     * Displays the welcome message.
     */
    public static void printWelcome() {
        System.out.println();
        System.out.println("#######   #######   #######       #       ##       ##   #######");
        System.out.println("#         #         #    ##      # #      # #     # #   #      ");
        System.out.println("#         #         #   ##      #   #     # #     # #   #      ");
        System.out.println("#######   #         #####       #####     #  #  #   #   #######");
        System.out.println("      #   #         #   #      #     #    #  #  #   #   #      ");
        System.out.println("      #   #         #    #     #     #    #   ##    #   #      ");
        System.out.println("#######   #######   #     #   #       #   #   ##    #   #######");
        System.out.println();
        System.out.println("****************** Hello! Welcome to SCRAME! ******************");
        System.out.println();
    }

    /**
     * Displays the exiting message.
     */
    public static void exitApplication() {

        System.out.println("Backing up data before exiting...");
        FILEMgr.backUpCourse(courses);
        FILEMgr.backUpMarks(marks);
        System.out.println("********* Bye! Thank you for using SCRAME! *********");
        System.out.println();
        System.out.println("                 ######    #      #   #######                   ");
        System.out.println("                 #    ##    #    #    #                         ");
        System.out.println("                 #    ##     #  #     #                         ");
        System.out.println("                 ######       ##      #######                   ");
        System.out.println("                 #    ##      ##      #                         ");
        System.out.println("                 #    ##      ##      #                         ");
        System.out.println("                 ######       ##      #######                   ");
        System.out.println();

    }

    /**
     * Displays all the options of the system.
     */
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
        System.out.println();
    }
}