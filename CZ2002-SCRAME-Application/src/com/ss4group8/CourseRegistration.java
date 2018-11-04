package com.ss4group8;

import java.util.Comparator;

public class CourseRegistration {
    private com.ss4group8.Student student;
    private com.ss4group8.Course course;
    private String lectureGroup;
    private String tutorialGroup;
    private String labGroup;

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
    }
    public static Comparator<CourseRegistration> tutComparator = new Comparator<CourseRegistration>() {
        @Override
        public int compare(CourseRegistration s1, CourseRegistration s2) {
            String group1 = s1.getTutorialGroup().toUpperCase();
            String group2 = s2.getTutorialGroup().toUpperCase();

            //ascending order
            return group1.compareTo(group2);

        }
    }
    public static Comparator<CourseRegistration> LabComparator = new Comparator<CourseRegistration>() {

        @Override
        public int compare(CourseRegistration o1, CourseRegistration o2) {
            String group1 = o1.getLabGroup().toUpperCase();
            String group2 = o2.getLabGroup().toUpperCase();

            //ascending order
            return group1.compareTo(group2);
        }

    }
}
