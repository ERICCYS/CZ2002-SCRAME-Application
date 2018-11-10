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

        students = FILEMgr.loadStudents();
        courses = FILEMgr.loadCourses();
        courseRegistrations = FILEMgr.loadCourseRegistration();
        marks = FILEMgr.loadStudentMarks();

        printWelcome();

        int choice;
        do {
            printOptions();
            do {
                System.out.println("Enter your choice, let me help you:");
                while (!scanner.hasNextInt()) {
                    String input = scanner.next();
                    System.out.println("Sorry. " + input + " is not an integer.");
                    System.out.println("Enter your choice, let me help you:");
                }
                choice = scanner.nextInt();
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
                    CourseMgr.enterCourseWorkComponentWeightage();
                    break;
                case 7:
                    MarkMgr.setCourseWorkMark(false);
                    break;
                case 8:
                    MarkMgr.setCourseWorkMark(true);
                    break;
                case 9:
//                    printCourseStatistics();
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

    public static void exitApplication() {

        System.out.printf("Backing up data before exiting...\n");
        FILEMgr.backUpCourse(courses);
        FILEMgr.backUpMarks(marks);
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
}
