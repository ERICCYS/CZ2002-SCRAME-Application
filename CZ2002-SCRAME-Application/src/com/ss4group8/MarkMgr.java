package com.ss4group8;

import java.util.*;

public class MarkMgr {
    private static Scanner scanner = new Scanner(System.in);

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

    public static void setExamMark(Mark mark) {
        double examMark;
        System.out.println("Enter the exam mark:");
        examMark = scanner.nextInt();
        mark.setMainCourseWorkMarks("Final", examMark);
    }

    public static void set


}
