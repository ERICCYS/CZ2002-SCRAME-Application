package com.ss4group8;

import java.util.Scanner;

public class StudentMgr {
    private static Scanner scanner = new Scanner(System.in);


    public static void addStudent() {
        String studentName;
        String studentID;
        int choice;
        int studentExists;
        Student currentStudent = null;
//        String studentID;
//        // Can make the sameStudentID as boolean, set to false.
//        int sameStudentID = 0;
        System.out.println("addStudent is called");
        System.out.println("Choose the way you want to add a student:");
        System.out.println("1. Manually input the student ID.");
        System.out.println("2. Let the system self-generate the student ID.");
        do{
            System.out.println("Please input your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();
            if(choice < 1 || choice > 2){
                System.out.println("Invalid input. Please re-enter.");
            }else{
                break;
            }
        }while(true);
        System.out.println("Enter student Name: ");
        studentName = scanner.nextLine();
        if (choice == 1) {
            currentStudent = new Student(studentName);
        }else{
            do{
                studentExists = 0;
            System.out.println("Enter student ID: ");
            studentID = scanner.nextLine();
            for(Student student:SCRAME.students){
                if(studentID.equals(student.getStudentID())){
                    System.out.println("Sorry. The student ID is used. This student already exists.");
                    studentExists = 1;
                    break;
                }
            }
            if(studentExists == 0){
                break;
            }
            }while(true);
            currentStudent = new Student(studentName);
            currentStudent.setStudentID(studentID);
        }

        FILEMgr.writeStudentsIntoFile(currentStudent);

        SCRAME.students.add(currentStudent);
        System.out.println("Student named: " + studentName + " is added, with ID: " + currentStudent.getStudentID());

        System.out.println("Student list: ");
        System.out.println("Student ID | Student Name");
        for (Student student: SCRAME.students) {
            System.out.println(" " + student.getStudentID() + " | " + student.getStudentName());
        }

    }
}
