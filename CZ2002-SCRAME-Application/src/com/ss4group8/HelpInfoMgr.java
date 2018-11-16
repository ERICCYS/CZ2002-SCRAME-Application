package com.ss4group8;

import com.ss4group8.Enum.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 Manages all the help information display in the system.
 @author Ma Xiao
 @author Fu Mengyan
 @author Kevin Steven Kihata
 @author Ng Chen Ee Kenneth
 @author Ian Tan Yi
 @version 1.0
 @since   2018-11-13
 */

public class HelpInfoMgr {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Displays all the professors in the inputted department.
     * @param department The inputted department.
     * @return A list of all the names of professors in the inputted department or else null.
     */
    public static List<String> printProfInDepartment (String department){
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

    /**
     * Displays a list of IDs of all the students.
     */
    public static void printAllStudents(){
        SCRAME.students.stream().map(s->s.getStudentID()).forEach(System.out::println);
    }

    /**
     * Displays a list of IDs of all the courses.
     */
    public static void printAllCourses(){
        SCRAME.courses.stream().map(c->c.getCourseID()).forEach(System.out::println);

    }

    /**
     * Displays a list of all the departments.
     */
    public static void printAllDepartment(){
        int index = 1;
        for (Department department : Department.values()) {
            System.out.println(index + ": " + department);
            index ++;
        }

    }

    /**
     * Displays a list of all the genders.
     */
    public static void printAllGender(){
        int index = 1;
        for(Gender gender : Gender.values()){
            System.out.println(index + ": " + gender);
            index ++;
        }

    }

    /**
     * Displays a list of all the course types.
     */
    public static void printAllCourseType(){
        int index = 1;
        for(CourseType courseType : CourseType.values()){
            System.out.println(index + ": " + courseType);
            index ++;
        }
    }

    /**
     * Gets all the departments as an array list.
     * @return an array list of all the departments.
     */
    public static ArrayList<String> getAllDepartment(){
        Set<Department> departmentEnumSet = EnumSet.allOf(Department.class);
        ArrayList<String> departmentStringList = new ArrayList<String>(0);
        Iterator iter = departmentEnumSet.iterator();
        while (iter.hasNext()) {
            departmentStringList.add(iter.next().toString());
        }
        return departmentStringList;

    }

    /**
     * Gets all the genders as an array list.
     * @return an array list of all the genders.
     */
    public static ArrayList<String> getAllGender(){
        Set<Gender> genderEnumSet = EnumSet.allOf(Gender.class);
        ArrayList<String> genderStringList = new ArrayList<String>(0);
        Iterator iter = genderEnumSet.iterator();
        while (iter.hasNext()) {
            genderStringList.add(iter.next().toString());
        }
        return genderStringList;
    }

    /**
     * Gets all the course types as an array list.
     * @return an array list of all the course types.
     */
    public static ArrayList<String> getAllCourseType(){
        Set<CourseType> courseTypeEnumSet = EnumSet.allOf(CourseType.class);
        ArrayList<String> courseTypeStringSet = new ArrayList<String>(0);
        Iterator iter = courseTypeEnumSet.iterator();
        while (iter.hasNext()) {
            courseTypeStringSet.add(iter.next().toString());
        }
        return courseTypeStringSet;
    }


    /**
     * Displays a list of all the courses in the inputted department.
     * @param department The inputted department.
     * @return a list of all the department values.
     */
    public static List<String> printCourseInDepartment(String department){
        List<Course> validCourses = SCRAME.courses.stream().filter(c->department.equals(c.getCourseDepartment())).collect(Collectors.toList());
        List<String> validCourseString = validCourses.stream().map(c->c.getCourseID()).collect(Collectors.toList());
        validCourseString.forEach(System.out::println);
        if(validCourseString.size() == 0){
            System.out.println("None.");
        }
        return validCourseString;
     }

    /**
     * Checks whether the inputted department is valid.
     * @param groupType The type of this group.
     * @param groups An array list of a certain type of groups in a course.
     * @return the name of the group chosen by the user.
     */
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
