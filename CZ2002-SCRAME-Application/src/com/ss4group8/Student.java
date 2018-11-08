package com.ss4group8;

public class Student {
    private String studentID;
    private String studentName;

    public Student(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public Student(String studentName) {
        this.studentName = studentName;
        this.studentID = generateStudentID();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }


    private static int idNumber = 1800000;

    private String generateStudentID() {
        int rand = (int)(Math.random() * ((76 - 65) + 1)) + 65;
        String lastPlace = Character.toString ((char) rand);
        idNumber += 1;
        return "U" + String.valueOf(idNumber) + lastPlace;
    }
}
