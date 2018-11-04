package com.ss4group8;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class CourseRegistrationMgr {

    public CourseRegistration registerCourse() {
        return new CourseRegistration();
    }

    //Create CourseRegistration object


    public static void printStudents(Course course){
        private Scanner scanner = new Scanner(System.in);
        System.out.println("Print student by: ");
        System.out.println("(1) Lecture group");
        System.out.println("(2) Tutorial group");
        System.out.println("(3) Lab group");

        int opt = scanner.nextInt();

        // READ courseRegistrationFILE
        // return ARRAYLIST of Object(student,course,lecture,tut,lab)
        private ArrayList<CourseRegistration> stuArray;
        // assume lecture,tut,lab groups are int

        if (opt == 1){ // print by LECTURE
            String newLec = "";
            Collections.sort(stuArray,LecComparator);   // Sort by Lecture group
            for (int i = 0; i< stuArray.size()-1 ; i++) {  // loop through all of CourseRegistration Obj
                if (!newLec.equals(stuArray.get(i).getLectureGroup())) {  // if new lecture group print out group name
                    newLec = stuArray.get(i).getLectureGroup();
                    System.out.println("------------------------------------------------------");
                    System.out.println("Lecture group : " + newLec);
                }
                System.out.print("Student Name: " + stuArray.get(i).getStudent().getStudentName());
                System.out.println("Student ID: " + stuArray.get(i).getStudent().getStudentID());
            }
        }

        else if (opt == 2){ // print by TUTORIAL
            String newTut = "";
            Collections.sort(stuArray,TutComparator);
            for (int i = 0; i< stuArray.size()-1 ; i++) {
                if (!newTut.equals(stuArray.get(i).getTutorialGroup())) {
                    newTut = stuArray.get(i).getTutorialGroup();
                    System.out.println("------------------------------------------------------");
                    System.out.println("Tutorial group : " + newTut );
                }
                System.out.print("Student Name: " + stuArray.get(i).getStudent().getStudentName());
                System.out.println("Student ID: " + stuArray.get(i).getStudent().getStudentID());
            }
        }
        else if (opt == 3){ // print by LAB
            String newLab = "";
            Collections.sort(stuArray,LabComparator);
            for (int i = 0; i< stuArray.size()-1 ; i++) {
                if (!newLab.equals(stuArray.get(i).getLabGroup())) {
                    newLab =  stuArray.get(i).getLabGroup();
                    System.out.println("------------------------------------------------------");
                    System.out.println("Lab group : " +newLab);
                }
                System.out.print("Student Name: " + stuArray.get(i).getStudent().getStudentName());
                System.out.println("Student ID: " + stuArray.get(i).getStudent().getStudentID());
            }
        }


    }

}

