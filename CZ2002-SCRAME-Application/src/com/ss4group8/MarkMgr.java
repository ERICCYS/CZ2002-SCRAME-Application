package com.ss4group8;

import java.util.HashMap;
import java.util.Scanner;

public class MarkMgr {
    private Scanner scanner = new Scanner(System.in);
    public Mark initializeMark(String studentID, String courseID) {
        HashMap<String, Double> courseWorkMark = new HashMap<String, Double>();
        // We need to get the courseWorks for this course from DB. Put all 0 in the second entry.
        Mark mark = new Mark(studentID, courseID, 0d, courseWorkMark, 0d);
        return mark;

    }
}
