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

    public static void enterCourseWorkMark() {
        double examMark;
        Mark mark = null;
        System.out.println("Enter the exam mark:");
        examMark = scanner.nextInt();
        mark.setMainCourseWorkMarks("Exam", examMark);
    }

    public static void setCourseWorkMark() {
        System.out.println("enterCourseWorkMark is called");
        String studentID;
        double courseWorkMark;
        boolean validStudentID = false;
        System.out.println("Enter Student ID:");
        studentID = scanner.nextLine();
        for (Student student : SCRAME.students) {
            if (student.getStudentID().equals(studentID)) {
                validStudentID = true;
                break;
            }
        }
        if (!validStudentID) {
            System.out.println("Invalid Student ID...");
            System.out.println("Exiting the mark management");
            return;
        }
        String courseID;
        boolean validCourseID = false;
        System.out.println("Enter course ID");
        courseID = scanner.nextLine();
        for (Course course : SCRAME.courses) {
            if (course.getCourseID().equals(courseID)) {
                validCourseID = true;
                break;
            }
        }
        if (!validCourseID) {
            System.out.println("Invalid Course ID...");
            System.out.println("Exiting the mark management");
            return;
        }

        for(Mark mark:SCRAME.marks) {
            if (mark.getCourse().getCourseID().equals(courseID) && mark.getStudent().getStudentID().equals(studentID)) {
                //put the set mark function here
                return;
            }
        }

        System.out.println("This student haven't registered " + courseID);
        // Exception handling
        // Get the course and student. Call the function inside MarkMgr

        // Print the choice.
        // As the user to enter the name
        // take in the the courseWorkName and mark, and whether it is a main component.
    }

    public static void  printStudentTranscript(ArrayList<Mark> thisStudentMark) {
        if (thisStudentMark.size() == 0) {
            System.out.println("------ No transcript ready for this student yet ------");
        }
        System.out.println("--------------- Official Transcript ----------------");
        System.out.print("Student Name: " + thisStudentMark.get(0).getStudent().getStudentName());
        System.out.println("\tStudent ID: " + thisStudentMark.get(0).getStudent().getStudentID());

        System.out.println();
        System.out.println();
        System.out.println();


        for (Mark mark : thisStudentMark) {
            System.out.print("Course ID: " + mark.getCourse().getCourseID());
            System.out.println("\tCourse Name: " + mark.getCourse().getCourseName());

            for (HashMap.Entry<CourseworkComponent, Double> entry : mark.getCourseWorkMarks().entrySet()) {
                CourseworkComponent assessment = entry.getKey();
                Double result = entry.getValue();
                if(assessment instanceof MainComponent) {
                    System.out.println("Main Assessment: " + assessment.getComponentName() + " ----- (" + assessment.getComponentWeight() + "%)");
                    int mainAssessmentWeight = assessment.getComponentWeight();
                    ArrayList<SubComponent> subAssessments = ((MainComponent) assessment).getSubComponents();
                    for (SubComponent subAssessment : subAssessments) {
                        System.out.print("Sub Assessment: " + subAssessment.getComponentName() + " -- (" + subAssessment.getComponentWeight() + "% * " + mainAssessmentWeight + "%) --- ");
                        String subAssessmentName = subAssessment.getComponentName();
                        for (HashMap.Entry<CourseworkComponent, Double> subEntry : mark.getCourseWorkMarks().entrySet()) {
                            CourseworkComponent subKey = subEntry.getKey();
                            Double subValue = subEntry.getValue();
                            if (subKey instanceof SubComponent && subKey.getComponentName().equals(subAssessmentName)) {
                                System.out.println("Mark: " + String.valueOf(subValue));
                                break;
                            }
                        }
                    }
                    System.out.println("Main Assessment Total: " + result);
                    System.out.println();
                }
            }

            System.out.println("Course Total: " + mark.getTotalMark());
            System.out.println();
            System.out.println();
        }
    }
}
