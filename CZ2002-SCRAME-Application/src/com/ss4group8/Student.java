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

    public void setStudentID(String studentID) { this.studentID = studentID; }


    private String generateStudentID() {
        String generateStudentID;
        int studentIDUsed;
        do{
            int rand = (int)(Math.random() * ((76 - 65) + 1)) + 65;
            String lastPlace = Character.toString ((char) rand);
            idNumber += 1;
            generateStudentID = "U" + String.valueOf(idNumber) + lastPlace;
            studentIDUsed = 0;
            for(Student student:SCRAME.students){
                if(generateStudentID.equals(student.getStudentID())){
                    studentIDUsed = 1;
                    break;
                }
            }
            if(studentIDUsed == 0){
                break;
            }
        }while(true);
        System.out.println("In student class, current student id is " + generateStudentID);
        return generateStudentID;
    }
}
