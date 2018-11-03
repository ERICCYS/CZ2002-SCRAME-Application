package com.ss4group8;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class FILEMgr {
    //loadCourseRegistrations
    //loadMarks
    private static final String COMMA_DELIMITER=",";
    private static final String NEW_LINE_SEPARATOR="\n";

    private static final String studentFileName = "data/studentFile.csv";
    private static final String courseFileName = "data/courseFile.csv";

    private static final int studentIdIndex = 0;
    private static final int studentNameIndex = 1;

    //initialize the header into csv file for better understanding
    public static void initializeStudentFile(){
        String student_HEADER="studentID,studentName";

        String studentFileName = "data/studentFile.csv";
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(studentFileName);
            fileWriter.append(student_HEADER);
            fileWriter.append("\n");
        }catch(Exception e){
            System.out.println("Error in CSV fileWriter!");
            e.printStackTrace();
        }finally{
            try{
                fileWriter.flush();
                fileWriter.close();
            }catch(IOException e){
                System.out.println("Error in flushing or closing studentFile.");
                e.printStackTrace();
            }
        }
    }


    //when a new student is add, add him to the csv file
    public static void writeStudentsIntoFile(Student student){
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(studentFileName);
            fileWriter.append(student.getStudentID());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(student.getStudentName());
            fileWriter.append(NEW_LINE_SEPARATOR);
        }catch(Exception e){
            System.out.println("Error in adding a student to the file.");
            e.printStackTrace();
        }finally{
            try{
                fileWriter.flush();
                fileWriter.close();
            }catch(IOException e){
                System.out.println("Error in flushing or closing the file.");
                e.printStackTrace();
            }
        }
    }


    //load all the existing students from the csv file
    public static ArrayList<Student> loadStudents(){
        BufferedReader fileReader = null;
        ArrayList<Student> students = new ArrayList<Student>(0);
        try{
            String line;
            fileReader = new BufferedReader(new FileReader(studentFileName));
            fileReader.readLine();//read the header to skip it
            while((line = fileReader.readLine())!=null){
                String[] tokens = line.split(COMMA_DELIMITER);
                if(tokens.length>0){
                    Student student = new Student(tokens[studentIdIndex], tokens[studentNameIndex]);
                    students.add(student);
                }
            }
        }catch(Exception e){
            System.out.println("Error occurs when loading students.");
            e.printStackTrace();
        }finally{
            try{
                fileReader.close();
            }catch(IOException e){
                System.out.println("Error occurs when closing the fileReader.");
                e.printStackTrace();
            }
        }
        return students;
    }


    public static void initializeCourseFile(){

    }
    public static void writeCourseIntoFile(Course course){
    }

    public static ArrayList<Course> loadCourses(){
        ArrayList<Course> courses = new ArrayList<Course>(0);
        return courses;
    }

}
