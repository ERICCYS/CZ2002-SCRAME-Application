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
            // Find a way to handle the input mismatch exceptions.
            if(scanner.hasNextInt()){
            choice = scanner.nextInt();
            }else{
                do{
                System.out.println("Sorry. Your input should be an integer.");
                System.out.println("Enter your choice, let me help you:");
                }while(!scanner.hasNextInt());
            }
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
                    MarkMgr.enterCourseWorkMark();
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



    public static void enterExamMark() {
        System.out.println("enterExamMark is called");
        String studentID;
        Student currentStudent = null;
        boolean validStudentID = false;
        System.out.println("Enter Student ID:");
        studentID = scanner.nextLine();
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                validStudentID = true;
                break;
            }
        }
        if (!validStudentID) {
            System.out.println("Invalid Student ID...");
            System.out.println("Exiting the mark management");
            return;
        }
        String courseID;
        boolean validCourseID = false;
        System.out.println("Enter course ID");
        courseID = scanner.nextLine();
        for (Course course : courses) {
            if (course.getCourseID().equals(courseID)) {
                validCourseID = true;
                break;
            }
        }
        if (!validCourseID) {
            System.out.println("Invalid Course ID...");
            System.out.println("Exiting the mark management");
            return;
        }

        for(Mark mark:marks) {
            if (mark.getCourse().getCourseID().equals(courseID) && mark.getStudent().getStudentID().equals(studentID)) {
                MarkMgr.setExamMark(mark);
                return;
            }
        }

        System.out.println("This student haven't registered " + courseID);
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
