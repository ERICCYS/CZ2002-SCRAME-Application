package com.ss4group8;

import java.util.Scanner;

public class StudentMgr {
    private static Scanner scanner = new Scanner(System.in);


    public static Student addStudent(String studentName) {
        Student student = new Student(studentName);
        FILEMgr.writeStudentsIntoFile(student);
        return student;
    }
}
