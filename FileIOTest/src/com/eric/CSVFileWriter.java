package com.eric;

import java.io.FileWriter;
import java.util.ArrayList;

public class CSVFileWriter {
    private static final String COMMA_DELIMETER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    private static final String FILE_HEADER = "Student Name,Student ID";

    public static void writeCSVFile(String fileName, ArrayList<Student> students) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER.toString());

            fileWriter.append(NEW_LINE_SEPARATOR);

            for(Student student : students) {
                fileWriter.append(student.getStudentName());
                fileWriter.append(COMMA_DELIMETER);
                fileWriter.append(student.getStudentID());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("CSV file created successfully");
        }
        catch (Exception e) {
            System.out.println("Error in CSVFileWriter!");
            e.printStackTrace();
        }
        finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            }
            catch (Exception e) {
                System.out.println("Error while flushing/closing fileWriter!");
                e.printStackTrace();
            }
        }
    }
}
