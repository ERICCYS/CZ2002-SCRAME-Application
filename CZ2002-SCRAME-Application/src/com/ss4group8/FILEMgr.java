package com.ss4group8;

import java.io.*;
import java.util.*;

public class FILEMgr {
    //loadCourseRegistrations
    //loadMarks
    private static final String COMMA_DELIMITER=",";
    private static final String NEW_LINE_SEPARATOR="\n";
    private static final String LINE_DELIMITER="|";
    private static final String EQUAL_SIGN="=";

    private static final String studentFileName = "data/studentFile.csv";
    private static final String courseFileName = "data/courseFile.csv";

    private static final int studentIdIndex = 0;
    private static final int studentNameIndex = 1;

    private static final int courseIdIndex = 0;
    private static final int courseNameIndex = 1;
    private static final int profInChargeIndex = 2;
    private static final int vacanciesIndex = 3;
    private static final int totalSeatsIndex = 4;
    private static final int lectureGroupsIndex = 5;
    private static final int tutorialGroupIndex = 6;
    private static final int labGroupIndex = 7;
    private static final int courseWorkIndex = 8;

    //initialize the header into csv file for better understanding
    public static void initializeStudentFile(){
        String student_HEADER="studentID,studentName";

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
                System.out.println("Error occurs when flushing or closing studentFile.");
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
        String course_HEADER="courseID,courseName,profInCharge,vacancies,totalSeats,lectureGroups,TutorialGroups,LabGroups,CourseWork";

        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(courseFileName);
            fileWriter.append(course_HEADER);
            fileWriter.append("\n");
        }catch(Exception e){
            System.out.println("Error in CSV fileWriter!");
            e.printStackTrace();
        }finally{
            try{
                fileWriter.flush();
                fileWriter.close();
            }catch(IOException e){
                System.out.println("Error occurs when flushing or closing courseFile.");
                e.printStackTrace();
            }
        }
    }

    public static void writeCourseIntoFile(Course course){
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(courseFileName);
            fileWriter.append(course.getCourseID());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(course.getCourseName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(course.getProfInCharge().getProfID());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(course.getVacancies()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(course.getTotalSeats()));
            fileWriter.append(COMMA_DELIMITER);
            ArrayList<LectureGroup> lectureGroups = course.getLectureGroups();
            if(lectureGroups.size() != 0){
                int index = 0;
                for(LectureGroup lectureGroup:lectureGroups){
                    fileWriter.append(lectureGroup.getGroupName());
                    index++;
                    if(index != lectureGroups.size()){
                    fileWriter.append(LINE_DELIMITER);}
                }
            }
            else{
                fileWriter.append("NULL");
            }
            fileWriter.append(COMMA_DELIMITER);
            ArrayList<TutorialGroup> tutorialGroups = course.getTutorialGroups();
            if(tutorialGroups.size() != 0){
                int index = 0;
                for(TutorialGroup tutorialGroup:tutorialGroups){
                    fileWriter.append(tutorialGroup.getGroupName());
                    index ++;
                    if (index != tutorialGroups.size()){
                    fileWriter.append(LINE_DELIMITER);}
                }
            }
            else{
                fileWriter.append("NULL");
            }
            fileWriter.append(COMMA_DELIMITER);
            ArrayList<LabGroup> labGroups = course.getLabGroups();
            if(labGroups.size() != 0){
                int index = 0;
                for(LabGroup labGroup:labGroups){
                    fileWriter.append(labGroup.getGroupName());
                    index ++;
                    if(index != labGroups.size()){
                    fileWriter.append(LINE_DELIMITER);}
                }
            }
            else{
                fileWriter.append("NULL");
            }
            fileWriter.append(COMMA_DELIMITER);
            HashMap<String, Double> courseworks = course.getCourseWorks();
            if(!courseworks.isEmpty()){
                int index = 0;
                for (HashMap.Entry<String,Double> entry:courseworks.entrySet())
                {
                    String key = entry.getKey();
                    Double value = entry.getValue();
                    fileWriter.append(key);
                    fileWriter.append(EQUAL_SIGN);
                    fileWriter.append(String.valueOf(value));
                    index ++;
                    if(index != courseworks.size()){
                    fileWriter.append(LINE_DELIMITER);}
                }
            }else{
                fileWriter.append("NULL");
            }
            fileWriter.append(NEW_LINE_SEPARATOR);
        }catch(Exception e){
            System.out.println("Error in adding a student to the file.");
            e.printStackTrace();
        }finally{
            try{
                fileWriter.flush();
                fileWriter.close();
            }catch(IOException e){
                System.out.println("Error occurs occurs when flushing or closing the file.");
                e.printStackTrace();
            }
        }

    }

    public static ArrayList<Course> loadCourses(){
        ArrayList<Course> courses = new ArrayList<Course>(0);
        BufferedReader fileReader = null;
        try{
            String line;
            fileReader = new BufferedReader(new FileReader(courseFileName));
            fileReader.readLine();//read the header to skip it
            while((line = fileReader.readLine())!=null){
                String[] tokens = line.split(COMMA_DELIMITER);
                if(tokens.length>0){
//                    Student student = new Student(tokens[studentIdIndex], tokens[studentNameIndex]);
//                    students.add(student);
                    String courseID = tokens[courseIdIndex];
                    String courseName = tokens[courseNameIndex];
                    String profInCharge = tokens[profInChargeIndex];
                    ArrayList<Professor> professors = loadProfessors();
                    for(Professor professor:professors){
                        if(professor.getProfID().equals(profInCharge)){
                            Professor professorInCharge = professor;
                            break;
                        }
                    }
                    int vacancies = Integer.parseInt(tokens[vacanciesIndex]);
                    int totalSeats = Integer.parseInt(tokens[totalSeatsIndex]);
                    //getLectureGroups
                    //new course
                    //getTutorialGroups and set
                    //getLabGroups and set
                    //getCoursework and set
                }
            }
        }catch(Exception e){
            System.out.println("Error happens when loading students.");
            e.printStackTrace();
        }finally{
            try{
                fileReader.close();
            }catch(IOException e){
                System.out.println("Error happens when closing the fileReader.");
                e.printStackTrace();
            }
        }
        return courses;
    }

    public static ArrayList<Professor> loadProfessors(){
        //have not implemented yet
        ArrayList<Professor> professors = new ArrayList<Professor>(0);
        return professors;
    }

}
