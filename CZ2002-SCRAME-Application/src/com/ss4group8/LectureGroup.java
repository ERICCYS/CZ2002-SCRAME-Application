package com.ss4group8;

public class LectureGroup {
    private String groupName;
    private int capacity;

    public LectureGroup(String groupName, int capacity) {
        this.groupName = groupName;
        this.capacity = capacity;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getCapacity() {
        return capacity;
    }
}
