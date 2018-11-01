package com.eric;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader {
    private static final String COMMA_DELIMITER = ",";

    // Student Attributes index
    private static final int STUDENT_ID = 0;
    private static final int STUDENT_NAME = 1;

    public static ArrayList<Student> readCSVFile (String fileName) {
        BufferedReader fileReader = null;
        ArrayList<Student> students= new ArrayList<Student>();
        try {

            String line = "";

            fileReader = new BufferedReader(new FileReader(fileName));

//            This line is to read the first line of csv file
//            fileReader.readLine();
//            We can discuss whether we need a head for csv file...

            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    String studentName = tokens[STUDENT_NAME];
                    String studentID = tokens[STUDENT_ID];
                    Student student = new Student(studentName, studentID);
                    students.add(student);
                }
            }
//            Print the new student list

//            for (Object student : students) {
//                System.out.println(student.toString());
//            }

        }
        catch (Exception e) {
            System.out.println("Error in CSV file Reader!");
            e.printStackTrace();
        }
        finally {
            try {
                fileReader.close();
            }
            catch (IOException e) {
                System.out.println("Error while closing fileReader!");
                e.printStackTrace();;
            }
        }

        return students;
    }
}
