package com.ss4group8;

import java.util.Scanner;

public class StudentMgr {
    private static Scanner scanner = new Scanner(System.in);
    public static Student addStudent() {
        String studentID;
        String studentName;
        System.out.println("Enter student name: ");
        studentName = scanner.nextLine();
        System.out.println("Give this student an ID: ");
        studentID = scanner.nextLine();
        Student student = new Student(studentID, studentName);
        return student;
    }
}
