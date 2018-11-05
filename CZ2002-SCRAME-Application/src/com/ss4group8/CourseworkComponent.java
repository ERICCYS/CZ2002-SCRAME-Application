package com.ss4group8;

public abstract class CourseworkComponent {
    private String componentName;
    private String componentWeight;

    public CourseworkComponent(String componentName, String componentWeight) {
        this.componentName = componentName;
        this.componentWeight = componentWeight;
    }

    public String getComponentName() {
        return componentName;
    }

    public String getComponentWeight() {
        return componentWeight;
    }

    public abstract void printComponentType();
}
