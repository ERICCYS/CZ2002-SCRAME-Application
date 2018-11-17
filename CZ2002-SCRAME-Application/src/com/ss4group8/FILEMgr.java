package com.ss4group8;


import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Manages file IO of this system.
 *
 * @author Ma Xiao
 * @author Fu Mengyan
 * @author Kevin Steven Kihata
 * @author Ng Chen Ee Kenneth
 * @author Ian Tan Yi
 * @version 1.0
 */

public class FILEMgr {

    /**
     * The string of {@code COMMA_DELIMITER}.
     */
    private static final String COMMA_DELIMITER = ",";

    /**
     * The string of {@code NEW_LINE_SEPARATOR}.
     */
    private static final String NEW_LINE_SEPARATOR = "\n";

    /**
     * The string of {@code LINE_DELIMITER}.
     */
    private static final String LINE_DELIMITER = "|";

    /**
     * The string of {@code EQUAL_SIGN}.
     */
    private static final String EQUAL_SIGN = "=";

    /**
     * The string of {@code HYPHEN}.
     */
    private static final String HYPHEN = "-";

    /**
     * The string of {@code SLASH}.
     */
    private static final String SLASH = "/";

    /**
     * The file name of studentFile.csv.
     */
    private static final String studentFileName = "data/studentFile.csv";

    /**
     * The file name of courseFile.csv.
     */
    private static final String courseFileName = "data/courseFile.csv";

    /**
     * The file name of professorFile.csv.
     */
    private static final String professorFileName = "data/professorFile.csv";

    /**
     * The file name of courseRegistrationFile.csv.
     */
    private static final String courseRegistrationFileName = "data/courseRegistrationFile.csv";

    /**
     * The file name of markFile.csv.
     */
    private static final String markFileName = "data/markFile.csv";

    /**
     * The header of studentFile.csv.
     */
    private static final String student_HEADER = "studentID,studentName,studentSchool,studentGender,studentGPA,studentYear";

    /**
     * The header of courseFile.csv.
     */
    private static final String course_HEADER = "courseID,courseName,profInCharge,vacancies,totalSeats,lectureGroups,TutorialGroups,LabGroups,MainComponents,AU,courseDepartment,courseType,lecHr,tutHr,labHr";

    /**
     * The header of professorFile.csv.
     */
    private static final String professor_HEADER = "professorID,professorName,profDepartment";

    /**
     * The header of courseRegistrationFile.csv.
     */
    private static final String courseRegistration_HEADER = "studentID,courseID,lectureGroup,tutorialGroup,labGroup";

    /**
     * The header of markFile.csv.
     */
    private static final String mark_HEADER = "studentID,courseID,courseWorkMarks,totalMark";

    /**
     * The index of the student ID in studentFile.csv.
     */
    private static final int studentIdIndex = 0;

    /**
     * The index of the student name in studentFile.csv.
     */
    private static final int studentNameIndex = 1;

    /**
     * The index of the student school in studentFile.csv.
     */
    private static final int studentSchoolIndex = 2;

    /**
     * The index of the student gender in studentFile.csv.
     */
    private static final int studentGenderIndex = 3;

    /**
     * The index of the student GPA in studentFile.csv.
     */
    private static final int studentGPAIndex = 4;

    /**
     * The index of the student year in studentFile.csv.
     */
    private static final int studentYearIndex = 5;

    /**
     * The index of the course ID in courseFile.csv.
     */
    private static final int courseIdIndex = 0;

    /**
     * The index of the course name in courseFile.csv.
     */
    private static final int courseNameIndex = 1;

    /**
     * The index of the professor in charge of this course in courseFile.csv.
     */
    private static final int profInChargeIndex = 2;
    /**
     * The index of course vacancies in courseFile.csv.
     */
    private static final int vacanciesIndex = 3;

    /**
     * The index of course total seats in courseFile.csv.
     */
    private static final int totalSeatsIndex = 4;

    /**
     * The index of course lecture groups in courseFile.csv.
     */
    private static final int lectureGroupsIndex = 5;

    /**
     * The index of course tutorial groups in courseFile.csv.
     */
    private static final int tutorialGroupIndex = 6;

    /**
     * The index of course lab group in courseFile.csv.
     */
    private static final int labGroupIndex = 7;

    /**
     * The index of course main components in courseFile.csv.
     */
    private static final int mainComponentsIndex = 8;

    /**
     * The index of course AU in courseFile.csv.
     */
    private static final int AUIndex = 9;

    /**
     * The index of course department in courseFile.csv.
     */
    private static final int courseDepartmentIndex = 10;

    /**
     * The index of course type in courseFile.csv.
     */
    private static final int courseTypeIndex = 11;

    /**
     * The index of course weekly lecture hour in courseFile.csv.
     */
    private static final int lecHrIndex = 12;

    /**
     * The index of course weekly tutorial hour in courseFile.csv.
     */
    private static final int tutHrIndex = 13;

    /**
     * The index of course weekly lab hour in courseFile.csv.
     */
    private static final int labHrIndex = 14;

    /**
     * The index of professor ID in professorFile.csv.
     */
    private static final int professorIdIndex = 0;

    /**
     * The index of professor name in professorFile.csv.
     */
    private static final int professorNameIndex = 1;

    /**
     * The index of professor department in professorFile.csv.
     */
    private static final int professorDepartmentIndex = 2;

    /**
     * The index of studentID in courseRegistrationFile.csv.
     */
    private static final int studentIdInRegistrationIndex = 0;

    /**
     * The index of courseID in courseRegistrationFile.csv.
     */
    private static final int courseIdInRegistrationIndex = 1;

    /**
     * The index of lectureGroup in courseRegistrationFile.csv.
     */
    private static final int lectureGroupInRegistrationIndex = 2;

    /**
     * The index of tutorialGroup in courseRegistrationFile.csv.
     */
    private static final int tutorialGroupInRegistrationIndex = 3;

    /**
     * The index of labGroup in courseRegistrationFile.csv.
     */
    private static final int labGroupInRegistrationIndex = 4;


    /**
     * The index of studentID in markFile.csv.
     */
    private static final int studentIdIndexInMarks = 0;

    /**
     * The index of courseID in markFile.csv.
     */
    private static final int courseIdIndexInMarks = 1;

    /**
     * The index of courseWorkMark in markFile.csv..
     */
    private static final int courseWorkMarksIndex = 2;

    /**
     * The index of totalMark in markFile.csv.
     */
    private static final int totalMarkIndex = 3;

    /**
     * Write a new student information into the file.
     *
     * @param student a student to be added into the file
     */
    public static void writeStudentsIntoFile(Student student) {
        File file;
        FileWriter fileWriter = null;
        try {
            file = new File(studentFileName);
            //initialize file header if have not done so
            fileWriter = new FileWriter(studentFileName, true);
            if (file.length() == 0) {
                fileWriter.append(student_HEADER);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.append(student.getStudentID());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(student.getStudentName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(student.getStudentSchool());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(student.getGender());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(student.getGPA()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(student.getStudentYear()));
            fileWriter.append(NEW_LINE_SEPARATOR);
        } catch (Exception e) {
            System.out.println("Error in adding a student to the file.");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error in flushing or closing the file.");
                e.printStackTrace();
            }
        }
    }


    /**
     * Load all the students' information from file into the system.
     *
     * @return an array list of all the students.
     */
    public static ArrayList<Student> loadStudents() {
        BufferedReader fileReader = null;
        ArrayList<Student> students = new ArrayList<Student>(0);
        try {
            String line;
            fileReader = new BufferedReader(new FileReader(studentFileName));
            fileReader.readLine();//read the header to skip it
            int recentStudentID = 0;
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    recentStudentID = Math.max(recentStudentID, Integer.parseInt(tokens[studentIdIndex].substring(1, 8)));
                    Student student = new Student(tokens[studentIdIndex], tokens[studentNameIndex]);
                    student.setStudentSchool(tokens[studentSchoolIndex]);
                    student.setGender(tokens[studentGenderIndex]);
                    student.setGPA(Double.parseDouble(tokens[studentGPAIndex]));
                    student.setStudentYear(Integer.parseInt(tokens[studentYearIndex]));
                    students.add(student);
                }
            }
            // Set the recent student ID, let the newly added student have the ID onwards.
            // If there is no student in DB, set recentStudentID to 1800000 (2018 into Uni)

            Student.setIdNumber(recentStudentID > 0 ? recentStudentID : 1800000);
        } catch (Exception e) {
            System.out.println("Error occurs when loading students.");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error occurs when closing the fileReader.");
                e.printStackTrace();
            }
        }
        return students;
    }

    /**
     * Write a new course information into the file.
     *
     * @param course a course to be added into file
     */
    public static void writeCourseIntoFile(Course course) {
        File file;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(courseFileName, true);
            //initialize file header if have not done so
            file = new File(courseFileName);
            if (file.length() == 0) {
                fileWriter.append(course_HEADER);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            fileWriter.append(course.getCourseID());
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(course.getCourseName());
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(course.getProfInCharge().getProfID());
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(String.valueOf(course.getVacancies()));
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(String.valueOf(course.getTotalSeats()));
            fileWriter.append(COMMA_DELIMITER);

            ArrayList<LectureGroup> lectureGroups = course.getLectureGroups();
            if (lectureGroups.size() != 0) {
                int index = 0;
                for (LectureGroup lectureGroup : lectureGroups) {
                    fileWriter.append(lectureGroup.getGroupName());
                    fileWriter.append(EQUAL_SIGN);
                    fileWriter.append(String.valueOf(lectureGroup.getAvailableVacancies()));
                    fileWriter.append(EQUAL_SIGN);
                    fileWriter.append(String.valueOf(lectureGroup.getTotalSeats()));
                    index++;
                    if (index != lectureGroups.size()) {
                        fileWriter.append(LINE_DELIMITER);
                    }
                }
            } else {
                fileWriter.append("NULL");
            }
            fileWriter.append(COMMA_DELIMITER);

            ArrayList<TutorialGroup> tutorialGroups = course.getTutorialGroups();
            if (tutorialGroups.size() != 0) {
                int index = 0;
                for (TutorialGroup tutorialGroup : tutorialGroups) {
                    fileWriter.append(tutorialGroup.getGroupName());
                    fileWriter.append(EQUAL_SIGN);
                    fileWriter.append(String.valueOf(tutorialGroup.getAvailableVacancies()));
                    fileWriter.append(EQUAL_SIGN);
                    fileWriter.append(String.valueOf(tutorialGroup.getTotalSeats()));
                    index++;
                    if (index != tutorialGroups.size()) {
                        fileWriter.append(LINE_DELIMITER);
                    }
                }
            } else {
                fileWriter.append("NULL");
            }
            fileWriter.append(COMMA_DELIMITER);

            ArrayList<LabGroup> labGroups = course.getLabGroups();
            if (labGroups.size() != 0) {
                int index = 0;
                for (LabGroup labGroup : labGroups) {
                    fileWriter.append(labGroup.getGroupName());
                    fileWriter.append(EQUAL_SIGN);
                    fileWriter.append(String.valueOf(labGroup.getAvailableVacancies()));
                    fileWriter.append(EQUAL_SIGN);
                    fileWriter.append(String.valueOf(labGroup.getTotalSeats()));
                    index++;
                    if (index != labGroups.size()) {
                        fileWriter.append(LINE_DELIMITER);
                    }
                }
            } else {
                fileWriter.append("NULL");
            }
            fileWriter.append(COMMA_DELIMITER);

            ArrayList<MainComponent> mainComponents = course.getMainComponents();
            if (mainComponents.size() != 0) {
                int index = 0;
                for (MainComponent mainComponent : mainComponents) {
                    fileWriter.append(mainComponent.getComponentName());
                    fileWriter.append(EQUAL_SIGN);
                    fileWriter.append(String.valueOf(mainComponent.getComponentWeight()));
                    fileWriter.append(EQUAL_SIGN);
                    ArrayList<SubComponent> subComponents = mainComponent.getSubComponents();
                    int inner_index = 0;
                    for (SubComponent subComponent : subComponents) {
                        fileWriter.append(subComponent.getComponentName());
                        fileWriter.append(HYPHEN);
                        fileWriter.append(String.valueOf(subComponent.getComponentWeight()));
                        inner_index++;
                        if (inner_index != subComponents.size()) {
                            fileWriter.append(SLASH);
                        }
                    }
                    index++;
                    if (index != mainComponents.size()) {
                        fileWriter.append(LINE_DELIMITER);
                    }
                }
            } else {
                fileWriter.append("NULL");
            }
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(course.getAU()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(course.getCourseDepartment());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(course.getCourseType());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(course.getLecWeeklyHour()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(course.getTutWeeklyHour()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(course.getLabWeeklyHour()));
            fileWriter.append(NEW_LINE_SEPARATOR);
        } catch (Exception e) {
            System.out.println("Error in adding a course to the file.");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error occurs occurs when flushing or closing the file.");
                e.printStackTrace();
            }
        }

    }

    /**
     * Load all the courses' information from file into the system.
     *
     * @return an array list of all the courses.
     */
    public static ArrayList<Course> loadCourses() {
        ArrayList<Course> courses = new ArrayList<Course>(0);
        BufferedReader fileReader = null;
        try {
            String line;
            int thisProfessor = 0;
            Professor currentProfessor = null;
            ArrayList<Professor> professors = loadProfessors();
            fileReader = new BufferedReader(new FileReader(courseFileName));
            fileReader.readLine();//read the header to skip it
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    String courseID = tokens[courseIdIndex];
                    String courseName = tokens[courseNameIndex];
                    String profInCharge = tokens[profInChargeIndex];
                    for (Professor professor : professors) {
                        if (professor.getProfID().equals(profInCharge)) {
                            currentProfessor = professor;
                            break;
                        }
                    }
                    int vacancies = Integer.parseInt(tokens[vacanciesIndex]);
                    int totalSeats = Integer.parseInt(tokens[totalSeatsIndex]);
                    int AU = Integer.parseInt(tokens[AUIndex]);
                    String courseDepartment = tokens[courseDepartmentIndex];
                    String courseType = tokens[courseTypeIndex];
                    int lecWeeklyHr = Integer.parseInt(tokens[lecHrIndex]);
                    int tutWeeklyHr = Integer.parseInt(tokens[tutHrIndex]);
                    int labWeeklyHr = Integer.parseInt(tokens[labHrIndex]);

                    String lectureGroupsString = tokens[lectureGroupsIndex];
                    ArrayList<LectureGroup> lectureGroups = new ArrayList<LectureGroup>(0);
                    String[] eachLectureGroupsString = lectureGroupsString.split(Pattern.quote(LINE_DELIMITER));

                    for (int i = 0; i < eachLectureGroupsString.length; i++) {
                        String[] thisLectureGroup = eachLectureGroupsString[i].split(EQUAL_SIGN);
                        lectureGroups.add(new LectureGroup(thisLectureGroup[0], Integer.parseInt(thisLectureGroup[1]), Integer.parseInt(thisLectureGroup[2])));
                    }

                    Course course = new Course(courseID, courseName, currentProfessor, vacancies, totalSeats, lectureGroups, AU, courseDepartment, courseType, lecWeeklyHr);

                    String tutorialGroupsString = tokens[tutorialGroupIndex];
                    ArrayList<TutorialGroup> tutorialGroups = new ArrayList<TutorialGroup>(0);

                    if (!tutorialGroupsString.equals("NULL")) {
                        String[] eachTutorialGroupsString = tutorialGroupsString.split(Pattern.quote(LINE_DELIMITER));
                        for (int i = 0; i < eachTutorialGroupsString.length; i++) {
                            String[] thisTutorialGroup = eachTutorialGroupsString[i].split(EQUAL_SIGN);
                            tutorialGroups.add(new TutorialGroup(thisTutorialGroup[0], Integer.parseInt(thisTutorialGroup[1]), Integer.parseInt(thisTutorialGroup[2])));
                        }
                    }
                    course.setTutorialGroups(tutorialGroups);
                    course.setTutWeeklyHour(tutWeeklyHr);

                    String labGroupsString = tokens[labGroupIndex];
                    ArrayList<LabGroup> labGroups = new ArrayList<LabGroup>(0);
                    if (!labGroupsString.equals("NULL")) {
                        String[] eachLabGroupString = labGroupsString.split(Pattern.quote(LINE_DELIMITER));
                        for (int i = 0; i < eachLabGroupString.length; i++) {
                            String[] thisLabGroup = eachLabGroupString[i].split(EQUAL_SIGN);
                            labGroups.add(new LabGroup(thisLabGroup[0], Integer.parseInt(thisLabGroup[1]), Integer.parseInt(thisLabGroup[2])));
                        }
                    }
                    course.setLabGroups(labGroups);
                    course.setLabWeeklyHour(labWeeklyHr);

                    String mainComponentsString = tokens[mainComponentsIndex];
                    ArrayList<MainComponent> mainComponents = new ArrayList<MainComponent>(0);
                    if (!mainComponentsString.equals("NULL")) {
                        String[] eachMainComponentsString = mainComponentsString.split(Pattern.quote(LINE_DELIMITER));
                        for (int i = 0; i < eachMainComponentsString.length; i++) {
                            String[] thisMainComponent = eachMainComponentsString[i].split(EQUAL_SIGN);
                            ArrayList<SubComponent> subComponents = new ArrayList<SubComponent>(0);
                            if (thisMainComponent.length > 2) {
                                String[] subComponentsString = thisMainComponent[2].split(SLASH);
                                for (int j = 0; j < subComponentsString.length; j++) {
                                    String[] thisSubComponent = subComponentsString[j].split(HYPHEN);
                                    subComponents.add(new SubComponent(thisSubComponent[0], Integer.parseInt(thisSubComponent[1])));
                                }
                            }

                            mainComponents.add(new MainComponent(thisMainComponent[0], Integer.parseInt(thisMainComponent[1]), subComponents));
                        }
                    }
                    course.setMainComponents(mainComponents);
                    course.setVacancies(vacancies);
                    courses.add(course);
                }
            }
        } catch (Exception e) {
            System.out.println("Error happens when loading courses.");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error happens when closing the fileReader.");
                e.printStackTrace();
            }
        }
        return courses;
    }

    /**
     * Backs up all the changes of courses made into the file.
     *
     * @param courses courses to be backed up
     */
    public static void backUpCourse(ArrayList<Course> courses) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(courseFileName);


            fileWriter.append(course_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Course course : courses) {
                fileWriter.append(course.getCourseID());
                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(course.getCourseName());
                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(course.getProfInCharge().getProfID());
                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(String.valueOf(course.getVacancies()));
                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(String.valueOf(course.getTotalSeats()));
                fileWriter.append(COMMA_DELIMITER);

                ArrayList<LectureGroup> lectureGroups = course.getLectureGroups();

                if (lectureGroups.size() != 0) {
                    int index = 0;
                    for (LectureGroup lectureGroup : lectureGroups) {
                        fileWriter.append(lectureGroup.getGroupName());
                        fileWriter.append(EQUAL_SIGN);
                        fileWriter.append(String.valueOf(lectureGroup.getAvailableVacancies()));
                        fileWriter.append(EQUAL_SIGN);
                        fileWriter.append(String.valueOf(lectureGroup.getTotalSeats()));
                        index++;
                        if (index != lectureGroups.size()) {
                            fileWriter.append(LINE_DELIMITER);
                        }
                    }
                } else {
                    fileWriter.append("NULL");
                }

                fileWriter.append(COMMA_DELIMITER);

                ArrayList<TutorialGroup> tutorialGroups = course.getTutorialGroups();
                if (tutorialGroups.size() != 0) {
                    int index = 0;
                    for (TutorialGroup tutorialGroup : tutorialGroups) {
                        fileWriter.append(tutorialGroup.getGroupName());
                        fileWriter.append(EQUAL_SIGN);
                        fileWriter.append(String.valueOf(tutorialGroup.getAvailableVacancies()));
                        fileWriter.append(EQUAL_SIGN);
                        fileWriter.append(String.valueOf(tutorialGroup.getTotalSeats()));
                        index++;
                        if (index != tutorialGroups.size()) {
                            fileWriter.append(LINE_DELIMITER);
                        }
                    }
                } else {
                    fileWriter.append("NULL");
                }
                fileWriter.append(COMMA_DELIMITER);

                ArrayList<LabGroup> labGroups = course.getLabGroups();
                if (labGroups.size() != 0) {
                    int index = 0;
                    for (LabGroup labGroup : labGroups) {
                        fileWriter.append(labGroup.getGroupName());
                        fileWriter.append(EQUAL_SIGN);
                        fileWriter.append(String.valueOf(labGroup.getAvailableVacancies()));
                        fileWriter.append(EQUAL_SIGN);
                        fileWriter.append(String.valueOf(labGroup.getTotalSeats()));
                        index++;
                        if (index != labGroups.size()) {
                            fileWriter.append(LINE_DELIMITER);
                        }
                    }
                } else {
                    fileWriter.append("NULL");
                }

                fileWriter.append(COMMA_DELIMITER);

                ArrayList<MainComponent> mainComponents = course.getMainComponents();
                if (mainComponents.size() != 0) {
                    int index = 0;
                    for (MainComponent mainComponent : mainComponents) {
                        fileWriter.append(mainComponent.getComponentName());
                        fileWriter.append(EQUAL_SIGN);
                        fileWriter.append(String.valueOf(mainComponent.getComponentWeight()));
                        fileWriter.append(EQUAL_SIGN);
                        ArrayList<SubComponent> subComponents = mainComponent.getSubComponents();
                        int inner_index = 0;
                        for (SubComponent subComponent : subComponents) {
                            fileWriter.append(subComponent.getComponentName());
                            fileWriter.append(HYPHEN);
                            fileWriter.append(String.valueOf(subComponent.getComponentWeight()));
                            inner_index++;
                            if (inner_index != subComponents.size()) {
                                fileWriter.append(SLASH);
                            }
                        }
                        index++;
                        if (index != mainComponents.size()) {
                            fileWriter.append(LINE_DELIMITER);
                        }
                    }
                } else {
                    fileWriter.append("NULL");
                }
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(course.getAU()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(course.getCourseDepartment());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(course.getCourseType());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(course.getLecWeeklyHour()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(course.getTutWeeklyHour()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(course.getLabWeeklyHour()));
                fileWriter.append(NEW_LINE_SEPARATOR);

            }

        } catch (Exception e) {
            System.out.println("Error in backing up courses.");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error occurs when flushing or closing the file.");
                e.printStackTrace();
            }
        }
    }

    /**
     * Writes a new professor information into the file.
     *
     * @param professor professor to be added into file
     */
    public static void writeProfIntoFile(Professor professor) {
        File file;
        FileWriter fileWriter = null;
        try {
            file = new File(professorFileName);
            //initialize file header if have not done so
            fileWriter = new FileWriter(professorFileName, true);
            if (file.length() == 0) {
                fileWriter.append(professor_HEADER);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.append(professor.getProfID());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(professor.getProfName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(professor.getProfDepartment());
            fileWriter.append(NEW_LINE_SEPARATOR);
        } catch (Exception e) {
            System.out.println("Error in adding a professor to the file.");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error occurs when flushing or closing the file.");
                e.printStackTrace();
            }
        }
    }

    /**
     * Load all the professors' information from file into the system.
     *
     * @return an array list of all the professors.
     */
    public static ArrayList<Professor> loadProfessors() {
        BufferedReader fileReader = null;
        ArrayList<Professor> professors = new ArrayList<Professor>(0);
        try {
            String line;
            fileReader = new BufferedReader(new FileReader(professorFileName));
            //read the header to skip it
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    Professor professor = new Professor(tokens[professorIdIndex], tokens[professorNameIndex]);
                    professor.setProfDepartment(tokens[professorDepartmentIndex]);
                    professors.add(professor);
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurs when loading professors.");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error occurs when closing the fileReader.");
                e.printStackTrace();
            }
        }
        return professors;
    }

    /**
     * Writes a new course registration record into the file.
     *
     * @param courseRegistration courseRegistration to be added into file
     */
    public static void writeCourseRegistrationIntoFile(CourseRegistration courseRegistration) {
        File file;
        FileWriter fileWriter = null;
        try {
            file = new File(courseRegistrationFileName);
            //initialize file header if have not done so
            fileWriter = new FileWriter(courseRegistrationFileName, true);
            if (file.length() == 0) {
                fileWriter.append(courseRegistration_HEADER);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.append(courseRegistration.getStudent().getStudentID());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(courseRegistration.getCourse().getCourseID());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(courseRegistration.getLectureGroup());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(courseRegistration.getTutorialGroup());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(courseRegistration.getLabGroup());
            fileWriter.append(NEW_LINE_SEPARATOR);
        } catch (Exception e) {
            System.out.println("Error in adding a course registration to the file.");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error occurs when flushing or closing the file.");
                e.printStackTrace();
            }
        }
    }

    /**
     * Load all the course registration records from file into the system.
     *
     * @return an array list of all the course registration records.
     */
    public static ArrayList<CourseRegistration> loadCourseRegistration() {
        BufferedReader fileReader = null;
        ArrayList<CourseRegistration> courseRegistrations = new ArrayList<CourseRegistration>(0);
        try {
            String line;
            Student currentStudent = null;
            Course currentCourse = null;
            ArrayList<Student> students = loadStudents();

            fileReader = new BufferedReader(new FileReader(courseRegistrationFileName));
            fileReader.readLine();//read the header to skip it

            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    String studentID = tokens[studentIdInRegistrationIndex];

                    for (Student student : students) {
                        if (student.getStudentID().equals(studentID)) {
                            currentStudent = student;
                            break;
                        }
                    }
                    String courseID = tokens[courseIdInRegistrationIndex];
                    ArrayList<Course> courses = loadCourses();
                    for (Course course : courses) {
                        if (course.getCourseID().equals(courseID)) {
                            currentCourse = course;
                            break;
                        }
                    }
                    courseRegistrations.add(new CourseRegistration(currentStudent, currentCourse, tokens[lectureGroupInRegistrationIndex], tokens[tutorialGroupInRegistrationIndex], tokens[labGroupInRegistrationIndex]));
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurs when loading course registrations.");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error occurs when closing the fileReader.");
                e.printStackTrace();
            }
        }
        return courseRegistrations;
    }


    /**
     * Writes a new student mark record into the file.
     *
     * @param mark mark to be updated into the file
     */
    public static void updateStudentMarks(Mark mark) {
        File file;
        FileWriter fileWriter = null;
        try {
            file = new File(markFileName);
            //initialize file header if have not done so
            fileWriter = new FileWriter(markFileName, true);
            if (file.length() == 0) {
                fileWriter.append(mark_HEADER);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.append(mark.getStudent().getStudentID());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(mark.getCourse().getCourseID());
            fileWriter.append(COMMA_DELIMITER);
            HashMap<CourseworkComponent, Double> courseworkMarks = mark.getCourseWorkMarks();
            if (!courseworkMarks.isEmpty()) {
                int index = 0;
                for (HashMap.Entry<CourseworkComponent, Double> entry : courseworkMarks.entrySet()) {
                    CourseworkComponent key = entry.getKey();
                    Double value = entry.getValue();
                    if (key instanceof MainComponent) {
                        fileWriter.append(key.getComponentName());
                        fileWriter.append(EQUAL_SIGN);
                        fileWriter.append(String.valueOf(key.getComponentWeight()));
                        fileWriter.append(EQUAL_SIGN);
                        fileWriter.append(String.valueOf(value));
                        fileWriter.append(EQUAL_SIGN);
                        ArrayList<SubComponent> subComponents = ((MainComponent) key).getSubComponents();
                        int subComponent_index = 0;
                        for (SubComponent subComponent : subComponents) {
                            fileWriter.append(subComponent.getComponentName());
                            fileWriter.append(SLASH);
                            fileWriter.append(String.valueOf(subComponent.getComponentWeight()));
                            fileWriter.append(SLASH);
                            fileWriter.append(String.valueOf(0.0));
                            subComponent_index++;
                            if (subComponent_index != subComponents.size()) {
                                fileWriter.append(EQUAL_SIGN);
                            }
                        }
                    }
                    index++;
                    if (index != courseworkMarks.size() && (key instanceof MainComponent)) {
                        fileWriter.append(LINE_DELIMITER);
                    }
                }
            } else {
                fileWriter.append("NULL");
            }
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(mark.getTotalMark()));
            fileWriter.append(NEW_LINE_SEPARATOR);
        } catch (Exception e) {
            System.out.println("Error in adding a mark to the file.");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error occurs in flushing or closing the file.");
                e.printStackTrace();
            }
        }
    }

    /**
     * Load all the student mark records from file into the system.
     *
     * @return an array list of all the student mark records.
     */
    public static ArrayList<Mark> loadStudentMarks() {
        BufferedReader fileReader = null;
        ArrayList<Mark> marks = new ArrayList<Mark>(0);
        try {
            String line;

            ArrayList<Student> students = loadStudents();
            ArrayList<Course> courses = loadCourses();

            fileReader = new BufferedReader(new FileReader(markFileName));
            //read the header to skip it
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                Student currentStudent = null;
                Course currentCourse = null;

                HashMap<CourseworkComponent, Double> courseWorkMarks = new HashMap<CourseworkComponent, Double>(0);
                String[] thisCourseWorkMark;

                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    String studentID = tokens[studentIdIndexInMarks];

                    for (Student student : students) {
                        if (student.getStudentID().equals(studentID)) {
                            currentStudent = student;
                            break;
                        }
                    }

                    String courseID = tokens[courseIdIndexInMarks];

                    for (Course course : courses) {
                        if (course.getCourseID().equals(courseID)) {
                            currentCourse = course;
                            break;
                        }
                    }

                    String courseWorkMarksString = tokens[courseWorkMarksIndex];
//                    System.out.println("From File, This course work components is: " + courseWorkMarksString);

                    String[] eachCourseWorkMark = courseWorkMarksString.split(Pattern.quote(LINE_DELIMITER));
                    // Get all the main components
//                    System.out.println("From the file: " + eachCourseWorkMark.length + " main components.");

                    for (int i = 0; i < eachCourseWorkMark.length; i++) {
                        thisCourseWorkMark = eachCourseWorkMark[i].split(EQUAL_SIGN);

                        ArrayList<SubComponent> subComponents = new ArrayList<SubComponent>(0);
                        HashMap<SubComponent, Double> subComponentMarks = new HashMap<SubComponent, Double>();
                        for (int j = 3; j < thisCourseWorkMark.length; j++) {
                            if (thisCourseWorkMark[3].equals("")) {
                                break;
                            }
                            String[] thisSubComponent = thisCourseWorkMark[j].split(SLASH);
                            subComponents.add(new SubComponent(thisSubComponent[0], Integer.parseInt(thisSubComponent[1])));
                            subComponentMarks.put(new SubComponent(thisSubComponent[0], Integer.parseInt(thisSubComponent[1])), Double.parseDouble(thisSubComponent[2]));
                        }

                        courseWorkMarks.put(new MainComponent(thisCourseWorkMark[0], Integer.parseInt(thisCourseWorkMark[1]), subComponents), Double.parseDouble(thisCourseWorkMark[2]));
                        // Put sub component
                        for (HashMap.Entry<SubComponent, Double> entry : subComponentMarks.entrySet()) {
                            SubComponent subComponent = entry.getKey();
                            Double subComponentResult = entry.getValue();
                            courseWorkMarks.put(subComponent, subComponentResult);
                        }
                    }
                    Double totalMark = Double.parseDouble(tokens[totalMarkIndex]);
                    Mark mark = new Mark(currentStudent, currentCourse, courseWorkMarks, totalMark);
//                    System.out.println();
//                    System.out.println("Loaded mark...");
//                    System.out.println("Student ID: " + mark.getStudent().getStudentID() + " Student name: " + mark.getStudent().getStudentName());
//                    System.out.println("Course ID: " + mark.getCourse().getCourseID() + " Course name: " + mark.getCourse().getCourseName());
//                    for (HashMap.Entry<CourseworkComponent, Double> entry : mark.getCourseWorkMarks().entrySet()) {
//                        System.out.println("Course Components: " + entry.getKey().getComponentName());
//                        System.out.println("Course Component weightage " + entry.getKey().getComponentWeight());
//                    }
//                    System.out.println();
                    marks.add(mark);
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurs when loading student marks.");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error occurs when closing the fileReader.");
                e.printStackTrace();
            }
        }
        return marks;
    }

    /**
     * Backs up all the changes of student mark records made into the file.
     *
     * @param marks marks to be backed up into file
     */
    public static void backUpMarks(ArrayList<Mark> marks) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(markFileName);

            fileWriter.append(mark_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Mark mark : marks) {
                fileWriter.append(mark.getStudent().getStudentID());
                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(mark.getCourse().getCourseID());
                fileWriter.append(COMMA_DELIMITER);

                if (!mark.getCourseWorkMarks().isEmpty()) {
                    int index = 0;
                    for (HashMap.Entry<CourseworkComponent, Double> entry : mark.getCourseWorkMarks().entrySet()) {
                        CourseworkComponent key = entry.getKey();
                        Double value = entry.getValue();
                        if (key instanceof MainComponent) {
                            fileWriter.append(key.getComponentName());
                            fileWriter.append(EQUAL_SIGN);
                            fileWriter.append(String.valueOf(key.getComponentWeight()));
                            fileWriter.append(EQUAL_SIGN);
                            fileWriter.append(String.valueOf(value));
                            fileWriter.append(EQUAL_SIGN);
                            ArrayList<SubComponent> subComponents = ((MainComponent) key).getSubComponents();
                            int subComponent_index = 0;
                            for (SubComponent subComponent : subComponents) {
                                fileWriter.append(subComponent.getComponentName());
                                fileWriter.append(SLASH);
                                fileWriter.append(String.valueOf(subComponent.getComponentWeight()));
                                fileWriter.append(SLASH);
                                String subComponentName = subComponent.getComponentName();
                                double subComponentMark = 0d;
                                for (HashMap.Entry<CourseworkComponent, Double> subEntry : mark.getCourseWorkMarks().entrySet()) {
                                    CourseworkComponent subKey = subEntry.getKey();
                                    Double subValue = subEntry.getValue();
                                    if (subKey instanceof SubComponent && subKey.getComponentName().equals(subComponentName)) {
                                        subComponentMark = subValue;
                                        break;
                                    }
                                }
                                fileWriter.append(String.valueOf(subComponentMark));
                                subComponent_index++;
                                if (subComponent_index != subComponents.size()) {
                                    fileWriter.append(EQUAL_SIGN);
                                }
                            }
                        }
                        index++;
                        if (index != mark.getCourseWorkMarks().size() && (key instanceof MainComponent)) {
                            fileWriter.append(LINE_DELIMITER);
                        }
                    }
                } else {
                    fileWriter.append("NULL");
                }
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(mark.getTotalMark()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception e) {
            System.out.println("Error in adding a mark to the file.");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error occurs in flushing or closing the file.");
                e.printStackTrace();
            }
        }
    }
}
