package com.eric;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Student> students = new ArrayList<Student>(0);

    public static void main(String[] args) {
        // write your code here
        String fileName = "data/Students.csv";

        System.out.println("Read CSV file:");
        students = CSVFileReader.readCSVFile(fileName);

        for (Object student : students) {
            System.out.println(student.toString());
        }

        String anotherFileName = "data/Students_Copy.csv";
        CSVFileWriter.writeCSVFile(anotherFileName, students);
//
//        students = CSVFileReader.readCSVFile(anotherFileName);
//
//        for (Object student : students) {
//            System.out.println(student.toString());
//        }
    }

}