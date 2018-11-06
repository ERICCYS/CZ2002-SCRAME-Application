package com.ss4group8;
import java.util.Comparator;

public class CourseRegistration {
    private Student student;
    private Course course;
    private String lectureGroup;
    private String tutorialGroup;
    private String labGroup;

    public CourseRegistration(Student student, Course course, String lectureGroup, String tutorialGroup, String labGroup) {
        this.student = student;
        this.course = course;
        this.lectureGroup = lectureGroup;
        this.tutorialGroup = tutorialGroup;
        this.labGroup = labGroup;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getLectureGroup() {
        return lectureGroup;
    }

    public String getTutorialGroup() {
        return tutorialGroup;
    }

    public String getLabGroup() {
        return labGroup;
    }

    public static Comparator<CourseRegistration> LecComparator = new Comparator<CourseRegistration>() {
        @Override
        public int compare(CourseRegistration o1, CourseRegistration o2) {
            String group1 = o1.getLectureGroup().toUpperCase();
            String group2 = o2.getLectureGroup().toUpperCase();

            //ascending order
            return group1.compareTo(group2);

        }
    };
    public static Comparator<CourseRegistration> TutComparator = new Comparator<CourseRegistration>() {
        @Override
        public int compare(CourseRegistration s1, CourseRegistration s2) {
            String group1 = s1.getTutorialGroup().toUpperCase();
            String group2 = s2.getTutorialGroup().toUpperCase();

            //ascending order
            return group1.compareTo(group2);

        }
    };
    public static Comparator<CourseRegistration> LabComparator = new Comparator<CourseRegistration>() {

        @Override
        public int compare(CourseRegistration o1, CourseRegistration o2) {
            String group1 = o1.getLabGroup().toUpperCase();
            String group2 = o2.getLabGroup().toUpperCase();

            //ascending order
            return group1.compareTo(group2);
        }

    };
}
