package com.ss4group8;

import com.ss4group8.Enum.*;
import java.util.*;
import java.util.stream.Collectors;

public class HelpInfoMgr {
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> printProfInDepartment (String department, boolean printOut){
        if(ValidationMgr.checkDepartmentValidation(department)){
            List<String> validProfString = SCRAME.professors.stream().filter(p->String.valueOf(department).equals(p.getProfDepartment())).map(p->p.getProfID()).collect(Collectors.toList());
            if (printOut) {
                validProfString.forEach(System.out::println);
            }
            return validProfString;
        }
        System.out.println("None.");
        return null;

    }

    public static void printAllStudents(){
        SCRAME.students.stream().map(s->s.getStudentID()).forEach(System.out::println);
    }

    public static void printAllCourses(){
        SCRAME.courses.stream().map(c->c.getCourseID()).forEach(System.out::println);

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
        List<Course> validCourses = SCRAME.courses.stream().filter(c->department.equals(c.getCourseDepartment())).collect(Collectors.toList());
        List<String> validCourseString = validCourses.stream().map(c->c.getCourseID()).collect(Collectors.toList());
        validCourseString.forEach(System.out::println);
        if(validCourseString.size() == 0){
            System.out.println("None.");
        }
        return validCourseString;
     }

     public static String printGroupWithVacancyInfo(String groupType, ArrayList<Group> groups) {
         int index;
         HashMap<String, Integer> groupAssign = new HashMap<String, Integer>(0);
         int selectedGroupNum;
         String selectedGroupName = null;

         if (groups.size() != 0) {
             System.out.println("Here is a list of all the "+ groupType +" groups with available slots:");
             do {
                 index = 0;
                 for (Group group : groups) {
                     if (group.getAvailableVacancies() == 0) {
                         continue;
                     }
                     index++;
                     System.out.println(index + ": " + group.getGroupName() + " (" + group.getAvailableVacancies() + " vacancies)");
                     groupAssign.put(group.getGroupName(), index);
                 }
                 System.out.println("Please enter an integer for your choice:");
                 selectedGroupNum = scanner.nextInt();
                 scanner.nextLine();
                 if (selectedGroupNum < 1 || selectedGroupNum > index) {
                     System.out.println("Invalid choice. Please re-enter.");
                 } else {
                     break;
                 }
             } while (true);

             for (HashMap.Entry<String, Integer> entry : groupAssign.entrySet()) {
                 String groupName = entry.getKey();
                 int num = entry.getValue();
                 if (num == selectedGroupNum) {
                     selectedGroupName = groupName;
                     break;
                 }
             }

             for (Group group : groups) {
                 if (group.getGroupName().equals(selectedGroupName)) {
                     group.enrolledIn();
                     break;
                 }
             }
         }
         return selectedGroupName;
     }

}
