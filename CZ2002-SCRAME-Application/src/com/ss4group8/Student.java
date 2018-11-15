package com.ss4group8;

public class Student {
    private static int idNumber = 1800000;

    private String studentID;
    private String studentName;
    private String studentSchool;
    private String gender;
    private double GPA = 0;
    private int studentYear;

    public Student(String studentName) {
        this.studentName = studentName;
        this.studentID = generateStudentID();
    }


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

    public String getStudentSchool(){
        return studentSchool;
    }

    public String getGender(){
        return gender;
    }


    public double getGPA(){
        return GPA;
    }

    public int getStudentYear(){
        return studentYear;
    }

    public static void setIdNumber(int idNumber) {
        Student.idNumber = idNumber;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setStudentSchool(String studentSchool){
        this.studentSchool = studentSchool;
    }

    public void setGender(String gender){
        this.gender = gender;
    }


    public void setGPA(double GPA){
        this.GPA = GPA;
    }

    public void  setStudentYear(int studentYear){
        this.studentYear = studentYear;
    }


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
        return generateStudentID;
    }
}
