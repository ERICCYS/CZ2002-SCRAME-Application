package com.ss4group8;


import java.util.Scanner;

public class StudentMgr {
    private static Scanner scanner = new Scanner(System.in);


    public static void addStudent() {
        String studentName, studentSchool;
        String studentID = null;
        int choice, studentYear;
        boolean studentExists;
        String GPA = "not available";
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
            if(scanner.hasNextInt()){
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice < 1 || choice > 2) {
                    System.out.println("Invalid input. Please re-enter.");
                } else {
                    break;
                }
            }else{
                System.out.println("Your input " + scanner.nextLine() + " is not an integer.");
            }
        } while (true);
        if (choice == 1) {
            while(true){
                System.out.println("The student ID should follow:");
                System.out.println("Length is exactly 9");
                System.out.println("Start with U (Undergraduate)");
                System.out.println("End with a uppercase letter between A and L");
                System.out.println("Seven digits in the middle");
                System.out.println();
                System.out.println("Give this student an ID: ");
                studentID = scanner.nextLine();
                if(ValidationMgr.checkValidStudentIDInput(studentID)){
                    if(ValidationMgr.checkStudentExists(studentID) == null){
                        break;
                    }
                }
            }
        }

        while(true){
        System.out.println("Enter student Name: ");
        studentName = scanner.nextLine();
        if(ValidationMgr.checkValidPersonNameInput(studentName)){
            break;
        }
        }

        currentStudent = new Student(studentName);
        if (choice == 1) {
            currentStudent.setStudentID(studentID);
        }


        //student department
        while(true){
            System.out.println("Enter student's school (uppercase): ");
            System.out.println("Enter -h to print all the schools.");
            studentSchool = scanner.nextLine();
            while("-h".equals(studentSchool)){
                HelpInfoMgr.printAllDepartment();
                studentSchool = scanner.nextLine();
            }

            if(ValidationMgr.checkDepartmentValidation(studentSchool)){
                currentStudent.setStudentSchool(studentSchool);
                break;
            }
        }



        //gender
        String studentGender;
        while(true){
            System.out.println("Enter student gender (uppercase): ");
            System.out.println("Enter -h to print all the genders.");
            studentGender = scanner.nextLine();
            while("-h".equals(studentGender)){
                HelpInfoMgr.printAllGender();
                studentGender = scanner.nextLine();
            }

            if(ValidationMgr.checkGenderValidation(studentGender)){
                currentStudent.setGender(studentGender);
                break;
            }
        }



        //student year
        do{
            System.out.println("Enter student's school year (1-4) : ");
            if(scanner.hasNextInt()){
                studentYear = scanner.nextInt();
                scanner.nextLine();
                if(studentYear < 1 || studentYear > 4){
                    System.out.println("Your input is out of bound.");
                    System.out.println("Please re-enter an integer between 1 and 4");
                }else{
                    currentStudent.setStudentYear(studentYear);
                    break;
                }
            }else{
                System.out.println("Your input " + scanner.nextLine() + " is not an integer");
                System.out.println("Please re-enter.");
            }
        }while(true);


        FILEMgr.writeStudentsIntoFile(currentStudent);

        SCRAME.students.add(currentStudent);
        System.out.println("Student named: " + studentName + " is added, with ID: " + currentStudent.getStudentID());

        System.out.println("Student list: ");
        System.out.println("Student ID | Student Name | Student School | Gender | Year | GPA");
        for (Student student : SCRAME.students) {
            if(Double.compare(student.getGPA(),0.0) != 0){
                GPA = String.valueOf(student.getGPA());
            }
            System.out.println(" " + student.getStudentID() + " | " + student.getStudentName() + " | " + student.getStudentSchool() + " | " + student.getGender() + " | " + student.getStudentYear() + " | " + GPA);
        }

    }
}
