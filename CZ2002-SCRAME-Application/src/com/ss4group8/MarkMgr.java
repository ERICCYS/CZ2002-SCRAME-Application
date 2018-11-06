package com.ss4group8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MarkMgr {
    private Scanner scanner = new Scanner(System.in);

    public static Mark initializeMark(Student student, Course course) {
        HashMap<CourseworkComponent, Double> courseWorkMarks = new HashMap<CourseworkComponent, Double>();
        double totalMark = 0d;
        ArrayList<MainComponent> mainComponents = course.getMainComponents();

        for (MainComponent mainComponent : mainComponents) {
            courseWorkMarks.put(mainComponent, 0d);
            if (mainComponent.getSubComponents().size() > 0) {
                for (SubComponent subComponent : mainComponent.getSubComponents()) {
                    courseWorkMarks.put(subComponent, 0d);
                }
            }
        }
        Mark mark = new Mark(student, course, courseWorkMarks, totalMark);
        FILEMgr.updateStudentMarks(mark);
        return mark;
    }
}
