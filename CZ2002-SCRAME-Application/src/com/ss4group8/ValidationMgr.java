package com.ss4group8;

import com.ss4group8.Enum.*;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.regex.*;

public class ValidationMgr {

    private static Scanner scanner = new Scanner(System.in);

    private static PrintStream originalStream = System.out;

    private static PrintStream dummyStream = new PrintStream(new OutputStream(){
        public void write(int b) {
            // NO-OP
        }
    });

    public static boolean checkDepartmentValidation(String department){
        if(HelpInfoMgr.getAllDepartment().contains(department)){
            return true;
        }
        System.out.println("The department is invalid. Please re-enter.");
        return false;
    }

    public static boolean checkGenderValidation(String gender){
        if(HelpInfoMgr.getAllGender().contains(gender)){
            return true;
        }
        System.out.println("The gender is invalid. Please re-enter.");
        return false;
    }

    public static boolean checkCourseTypeValidation(String courseType){
        if(HelpInfoMgr.getAllCourseType().contains(courseType)){
            return true;
        }
        System.out.println("The course type is invalid. Please re-enter.");
        return false;
    }

    public static boolean checkValidStudentIDInput(String studentID){
        String REGEX = "^U[0-9]{7}[A-Z]$";
        boolean valid = Pattern.compile(REGEX).matcher(studentID).matches();
        if(!valid){
            System.out.println("Wrong format of student ID.");
        }
        return valid;

    }


    public static boolean checkValidCourseIDInput(String courseID){
        String REGEX = "^[A-Z]{2}[0-9]{3,4}$";
        boolean valid = Pattern.compile(REGEX).matcher(courseID).matches();
        if(!valid){
            System.out.println("Wrong format of course ID.");
        }
        return valid;

    }

    public static boolean checkValidProfIDInput(String profID){
        String REGEX = "^P[0-9]{7}[A-Z]$";
        boolean valid =  Pattern.compile(REGEX).matcher(profID).matches();
        if(!valid){
            System.out.println("Wrong format of prof ID.");
        }
        return valid;

    }

    public static boolean checkValidPersonNameInput(String personName){
        String REGEX = "^[ a-zA-Z]+$";
        boolean valid =  Pattern.compile(REGEX).matcher(personName).matches();
        if(!valid){
            System.out.println("Wrong format of name.");
        }
        return valid;
    }

    public static boolean checkValidGroupNameInput(String groupName){
        String REGEX = "^[a-zA-Z0-9]+$";
        boolean valid =  Pattern.compile(REGEX).matcher(groupName).matches();
        if(!valid){
            System.out.println("Wrong format of group name.");
        }
        return valid;
    }

    public static Student checkStudentExists(String studentID){
        List<Student> anyStudent = FILEMgr.loadStudents().stream().filter(s->studentID.equals(s.getStudentID())).collect(Collectors.toList());
        if(anyStudent.size() == 0){
            return null;
        }
        System.out.println("Sorry. The student ID is used. This student already exists.");
        return anyStudent.get(0);

    }

    public static String checkStudentExists(){
        String studentID;
        Student currentStudent = null;
        while (true) {
            System.out.println("Enter Student ID:");
            studentID = scanner.nextLine();
            System.out.println("Enter -h to print all the student ID.");
            studentID = scanner.nextLine();
            while("-h".equals(studentID)){
                HelpInfoMgr.printAllStudents();
                studentID = scanner.nextLine();
            }

            System.setOut(dummyStream);
            currentStudent = checkStudentExists(studentID);
            if (currentStudent == null) {
                System.setOut(originalStream);
                System.out.println("Invalid Student ID. Please re-enter.");
            }else {
                break;
            }

        }
        System.setOut(originalStream);
        return studentID;
    }

    public static String checkCourseExists(){
        String courseID;
        Course currentCourse;
        while(true){
            System.out.println("Enter course ID");
            System.out.println("Enter -h to print all the course ID.");
            courseID = scanner.nextLine();
            while("-h".equals(courseID)){
                HelpInfoMgr.printAllCourses();
                courseID = scanner.nextLine();
            }

            System.setOut(dummyStream);
            currentCourse = ValidationMgr.checkCourseExists(courseID);
            if (currentCourse == null) {
                System.setOut(originalStream);
                System.out.println("Invalid Course ID. Please re-enter.");
            }else{
                break;
            }
        }
        System.setOut(originalStream);
        return courseID;
    }

    public static String checkCourseDepartmentExists(){
        String courseDepartment;
        while(true){
            System.out.println("Which department's courses are you interested? (-h to print all the departments)");
            courseDepartment = scanner.nextLine();
            while("-h".equals(courseDepartment)){
                HelpInfoMgr.printAllDepartment();
                courseDepartment = scanner.nextLine();
            }
            if(ValidationMgr.checkDepartmentValidation(courseDepartment)){
                List<String> validCourseString;
                System.setOut(dummyStream);
                validCourseString = HelpInfoMgr.printCourseInDepartment(courseDepartment);
                System.setOut(originalStream);
                if(validCourseString.size() == 0){
                    System.out.println("Invalid choice of department.");
                }else{
                    break;
                }
            }
        }
        return courseDepartment;
    }

    public static Course checkCourseExists(String courseID){
        List<Course> anyCourse = FILEMgr.loadCourses().stream().filter(c->courseID.equals(c.getCourseID())).collect(Collectors.toList());
        if(anyCourse.size() == 0){
            return null;
        }
        System.out.println("Sorry. The course ID is used. This course already exists.");
        return anyCourse.get(0);

    }

    public static Professor checkProfExists(String profID){
        List<Professor> anyProf = FILEMgr.loadProfessors().stream().filter(p->profID.equals(p.getProfID())).collect(Collectors.toList());
        if(anyProf.size() == 0){
            return null;
        }
        System.out.println("Sorry. The professor ID is used. This professor already exists.");
        return anyProf.get(0);

    }

    public static CourseRegistration checkCourseRegistrationExists(String studentID, String courseID){
        List<CourseRegistration> courseRegistrations = FILEMgr.loadCourseRegistration().stream().filter(cr->studentID.equals(cr.getStudent().getStudentID())).filter(cr->courseID.equals(cr.getCourse().getCourseID())).collect(Collectors.toList());
        if(courseRegistrations.size() == 0){
            return null;
        }
        System.out.println("Sorry. This student already registers this course.");
        return courseRegistrations.get(0);

    }



}
