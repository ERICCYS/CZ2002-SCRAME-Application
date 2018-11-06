package com.ss4group8;

public abstract class CourseworkComponent {
    private String componentName;
    private int componentWeight;

    public CourseworkComponent(String componentName, int componentWeight) {
        this.componentName = componentName;
        this.componentWeight = componentWeight;
    }

    public String getComponentName() {
        return componentName;
    }

    public int getComponentWeight() {
        return componentWeight;
    }

    public abstract void printComponentType();
}
