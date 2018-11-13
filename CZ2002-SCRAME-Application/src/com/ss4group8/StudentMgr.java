package com.ss4group8;


import java.util.Scanner;

public class StudentMgr {
    private static Scanner scanner = new Scanner(System.in);


    public static void addStudent() {
        String studentName;
        String studentID = null;
        int choice;
        boolean studentExists;
        Student currentStudent = null;
//        String studentID;
//        // Can make the sameStudentID as boolean, set to false.
//        int sameStudentID = 0;
        System.out.println("addStudent is called");
        System.out.println("Choose the way you want to add a student:");
        System.out.println("1. Manually input the student ID.");
        System.out.println("2. Let the system self-generate the student ID.");
        do {
            System.out.println("Please input your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice < 1 || choice > 2) {
                System.out.println("Invalid input. Please re-enter.");
            } else {
                break;
            }
        } while (true);
        if (choice == 1) {
            do {
                studentExists = false;
                boolean validIDFormat;

                do {
                    validIDFormat = true;
                    System.out.println("Enter student ID: ");
                    studentID = scanner.nextLine();

                    if (studentID.length() != 9) {
//                        System.out.println("Length less than 9");
                        validIDFormat = false;
                    } else if (studentID.charAt(0) != 'U' && studentID.charAt(0) != 'G') {
//                        System.out.println("Prefix issue");
                        validIDFormat = false;
                    } else if (studentID.charAt(8) < 'A' || studentID.charAt(8) > 'L') {
//                        System.out.println("Ending issue");
                        validIDFormat = false;
                    } else {
                        try {
//                            System.out.println(studentID.substring(1, 8));
                            Integer.parseInt(studentID.substring(1, 8));
                        } catch (NumberFormatException e) {
//                            System.out.println("Number issue");
                            validIDFormat = false;
                        }
                    }
                    if (!validIDFormat) {
                        System.out.println("The student ID should follow:");
                        System.out.println("Length is exactly 9");
                        System.out.println("Start with U (Undergraduate) or G (Graduate)");
                        System.out.println("End with a uppercase letter between A and L");
                        System.out.println("Seven digits in the middle");
                        System.out.println();
                    }
                } while (!validIDFormat);


                for (Student student : SCRAME.students) {
                    if (studentID.equals(student.getStudentID())) {
                        System.out.println("Sorry. The student ID is used. This student already exists.");
                        studentExists = true;
                        break;
                    }
                }

            } while (studentExists);
        }
        System.out.println("Enter student Name: ");
        studentName = scanner.nextLine();
        currentStudent = new Student(studentName);
        if (choice == 1) {
            currentStudent.setStudentID(studentID);
        }

        FILEMgr.writeStudentsIntoFile(currentStudent);

        SCRAME.students.add(currentStudent);
        System.out.println("Student named: " + studentName + " is added, with ID: " + currentStudent.getStudentID());

        System.out.println("Student list: ");
        System.out.println("Student ID | Student Name");
        for (Student student : SCRAME.students) {
            System.out.println(" " + student.getStudentID() + " | " + student.getStudentName());
        }

    }
}
