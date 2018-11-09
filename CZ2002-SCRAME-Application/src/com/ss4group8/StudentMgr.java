package com.ss4group8;

import java.util.Scanner;

public class StudentMgr {
    private static Scanner scanner = new Scanner(System.in);


    public static void addStudent() {
        String studentName;
//        String studentID;
//        // Can make the sameStudentID as boolean, set to false.
//        int sameStudentID = 0;
        System.out.println("addStudent is called");
        System.out.println("Enter student Name: ");
        studentName = scanner.nextLine();

        Student currentStudent = new Student(studentName);
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
