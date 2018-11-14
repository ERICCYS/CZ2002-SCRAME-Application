package com.ss4group8;

import com.ss4group8.Enum.*;
import com.sun.tools.javah.Gen;

import java.util.*;
import java.util.stream.Collectors;

public class HelpInfoMgr {
    public List<Professor> printProfInDepartment (String department){
        if(ValidationMgr.checkDepartmentValidation(department)){
            List<Professor> professors = FILEMgr.loadProfessors();
            List<Professor> validProfs = professors.stream().filter(p->String.valueOf(department).equals(p.getProfDepartment())).collect(Collectors.toList());
            validProfs.forEach(System.out::println);
            return validProfs;
        }
        return null;

    }

    public static void printAllDepartment(){
        int index = 1;
        for (Department department : Department.values()) {
            System.out.println(index + ": " + department);
            index ++;
        }

    }

    public static void printAllGender(){
        for(Gender gender : Gender.values()){
            System.out.println(gender);
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


    public static List<Course> printCourseInDepartment(Department department){
        List<Course> validCourses = FILEMgr.loadCourses().stream().filter(c->department.equals(c.getCourseDepartment())).collect(Collectors.toList());
        validCourses.forEach(System.out::println);
        return validCourses;
     }


}
