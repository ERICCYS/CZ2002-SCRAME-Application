package com.ss4group8;

import com.ss4group8.Enum.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.regex.*;

public class ValidationMgr {

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
