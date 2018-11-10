package com.ss4group8;


import java.util.*;

public class MarkMgr {
    private static Scanner scanner = new Scanner(System.in);

    public static Student validateStudent(String studentID){
        for (Student student : SCRAME.students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    public static Course validateCourse(String courseID) {
        for (Course course : SCRAME.courses) {
            if (course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        return null;
    }

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

    
    public static void setCourseWorkMark(boolean isExam) {
        System.out.println("enterCourseWorkMark is called");
        String studentID;
        Student currentStudent;
        System.out.println("Enter Student ID:");
        studentID = scanner.nextLine();
        currentStudent = validateStudent(studentID);
        if (currentStudent == null) {
            System.out.println("Invalid Student ID...");
            System.out.println("Exiting the set course work mark");
            return ;
        }

        String courseID;
        Course currentCourse;
        System.out.println("Enter course ID");
        courseID = scanner.nextLine();
        currentCourse = validateCourse(courseID);
        if (currentCourse == null) {
            System.out.println("Invalid Course ID...");
            System.out.println("Exiting the set course work mark");
            return;
        }

        for(Mark mark:SCRAME.marks) {
            if (mark.getCourse().getCourseID().equals(courseID) && mark.getStudent().getStudentID().equals(studentID)) {
                //put the set mark function here
                if (!isExam) {
                    System.out.println("Here are the choices you can have: ");
                    ArrayList<String> availableChoices = new ArrayList<String>(0);
                    ArrayList<Double> weights = new ArrayList<Double>(0);
                    ArrayList<Boolean> isMainAss = new ArrayList<Boolean>(0);
                    for (HashMap.Entry<CourseworkComponent, Double> assessmentResult : mark.getCourseWorkMarks().entrySet()){
                        CourseworkComponent key = assessmentResult.getKey();
                        if (key instanceof MainComponent) {
                            if ((!key.getComponentName().equals("Exam")) && ((MainComponent) key).getSubComponents().size() == 0) {
                                availableChoices.add(key.getComponentName());
                                weights.add((double)key.getComponentWeight());
                                isMainAss.add(true);
                            } else {
                                for (SubComponent subComponent : ((MainComponent) key).getSubComponents()) {
                                    availableChoices.add(key.getComponentName() + "-" + subComponent.getComponentName());
                                    weights.add((double)key.getComponentWeight() * (double)subComponent.getComponentWeight() / 100d);
                                    isMainAss.add(false);
                                }
                            }
                        }
                    }

                    for (int i = 0; i < availableChoices.size(); i++) {
                        System.out.println((i + 1) + ". " + availableChoices.get(i) + " Weight in Total: " + weights.get(i) + "%");
                    }
                    System.out.println((availableChoices.size() + 1) + ". Quit");

                    int choice;
                    System.out.println("Enter your choice");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    while (choice > (availableChoices.size() + 1) || choice < 0) {
                        System.out.println("Please enter choice between " + 0 + "~" + (availableChoices.size() + 1));
                        System.out.println("Enter your choice");
                        choice = scanner.nextInt();
                        scanner.nextLine();
                    }

                    if (choice == (availableChoices.size() + 1)) {
                        return ;
                    }

                    double assessmentMark;
                    System.out.println("Enter the mark for this assessment:");
                    assessmentMark = scanner.nextDouble();
                    scanner.nextLine();
                    while (assessmentMark > 100 || assessmentMark < 0) {
                        System.out.println("Please enter mark in range 0 ~ 100.");
                        assessmentMark = scanner.nextDouble();
                        scanner.nextLine();
                    }

                    if (isMainAss.get(choice - 1)) {
                        // This is a stand alone main assessment
                        mark.setMainCourseWorkMarks(availableChoices.get(choice - 1), assessmentMark);
                    }
                    else {
                        mark.setSubCourseWorkMarks(availableChoices.get(choice - 1).split("-")[1], assessmentMark);
                    }

                }

                else {
                    // The user want to enter exam mark.
                    double examMark;
                    System.out.println("Enter exam mark:");
                    examMark = scanner.nextDouble();
                    scanner.nextLine();
                    while (examMark > 100 || examMark < 0) {
                        System.out.println("Please enter mark in range 0 ~ 100.");
                        examMark = scanner.nextDouble();
                        scanner.nextLine();
                    }
                    mark.setMainCourseWorkMarks("Exam", examMark);
                }

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

    public static void printCourseStatistics() {
        System.out.println("printCourseStatistics is called");
        String courseID;
        Course currentCourse = null;
        System.out.println("Enter Course ID:");
        courseID = scanner.nextLine();
        currentCourse = validateCourse(courseID);
        if (currentCourse == null) {
            System.out.println("Invalid Course ID...");
            System.out.println("Exiting the course registration");
            return;
        }
        System.out.println("No available now");
    }


    public static void  printStudentTranscript() {
        String studentID;
        Student currentStudent = null;
        System.out.println("Enter Student ID:");
        studentID = scanner.nextLine();
        currentStudent = validateStudent(studentID);
        if (currentStudent == null) {
            System.out.println("Invalid Student ID...");
            System.out.println("Exiting the course registration");
            return ;
        }

        ArrayList<Mark> thisStudentMark = new ArrayList<Mark>(0);
        for(Mark mark : SCRAME.marks) {
            if (mark.getStudent().getStudentID().equals(studentID)) {
                thisStudentMark.add(mark);
            }
        }

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
