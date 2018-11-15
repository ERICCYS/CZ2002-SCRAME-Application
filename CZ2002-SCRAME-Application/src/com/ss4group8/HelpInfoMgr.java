package com.ss4group8;

import com.ss4group8.Enum.*;
import java.util.*;
import java.util.stream.Collectors;

public class HelpInfoMgr {
    public static List<String> printProfInDepartment (String department){
        if(ValidationMgr.checkDepartmentValidation(department)){
            List<Professor> professors = FILEMgr.loadProfessors();
            List<String> validProfString = professors.stream().filter(p->String.valueOf(department).equals(p.getProfDepartment())).map(p->p.getProfID()).collect(Collectors.toList());
            validProfString.forEach(System.out::println);
            return validProfString;
        }
        System.out.println("None.");
        return null;

    }

    public static void printAllStudents(){
        List<Student> students = FILEMgr.loadStudents();
        students.stream().map(s->s.getStudentID()).forEach(System.out::println);

    }

    public static void printAllCourses(){
        List<Course> courses = FILEMgr.loadCourses();
        courses.stream().map(c->c.getCourseID()).forEach(System.out::println);

    }

    public static void printAllDepartment(){
        int index = 1;
        for (Department department : Department.values()) {
            System.out.println(index + ": " + department);
            index ++;
        }

    }

    public static void printAllGender(){
        int index = 1;
        for(Gender gender : Gender.values()){
            System.out.println(index + ": " + gender);
            index ++;
        }

    }

    public static void printAllCourseType(){
        int index = 1;
        for(CourseType courseType : CourseType.values()){
            System.out.println(index + ": " + courseType);
            index ++;
        }
    }

    public static ArrayList<String> getAllDepartment(){
        Set<Department> departmentEnumSet = EnumSet.allOf(Department.class);
        ArrayList<String> departmentStringList = new ArrayList<String>(0);
        Iterator iter = departmentEnumSet.iterator();
        while (iter.hasNext()) {
            departmentStringList.add(iter.next().toString());
        }
        return departmentStringList;

    }

    public static ArrayList<String> getAllGender(){
        Set<Gender> genderEnumSet = EnumSet.allOf(Gender.class);
        ArrayList<String> genderStringList = new ArrayList<String>(0);
        Iterator iter = genderEnumSet.iterator();
        while (iter.hasNext()) {
            genderStringList.add(iter.next().toString());
        }
        return genderStringList;
    }

    public static ArrayList<String> getAllCourseType(){
        Set<CourseType> courseTypeEnumSet = EnumSet.allOf(CourseType.class);
        ArrayList<String> courseTypeStringSet = new ArrayList<String>(0);
        Iterator iter = courseTypeEnumSet.iterator();
        while (iter.hasNext()) {
            courseTypeStringSet.add(iter.next().toString());
        }
        return courseTypeStringSet;
    }


    public static List<String> printCourseInDepartment(String department){
        List<Course> validCourses = FILEMgr.loadCourses().stream().filter(c->department.equals(c.getCourseDepartment())).collect(Collectors.toList());
        List<String> validCourseString = validCourses.stream().map(c->c.getCourseID()).collect(Collectors.toList());
        validCourseString.forEach(System.out::println);
        if(validCourseString.size() == 0){
            System.out.println("None.");
        }
        return validCourseString;
     }


}
