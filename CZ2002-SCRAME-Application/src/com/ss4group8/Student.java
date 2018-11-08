package com.ss4group8;

public class Student {
    private static int idNumber = 1800000;

    private String studentID;
    private String studentName;

    public Student(String studentName) {
        this.studentName = studentName;
        this.studentID = generateStudentID();
    }

    //
    public Student(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }



    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public static void setIdNumber(int idNumber) {
        Student.idNumber = idNumber;
    }


    private String generateStudentID() {
        int rand = (int)(Math.random() * ((76 - 65) + 1)) + 65;
        String lastPlace = Character.toString ((char) rand);
        idNumber += 1;
        return "U" + String.valueOf(idNumber) + lastPlace;
    }
}
