package com.ss4group8;

/**
 * This is an abstract class which can be extended by {@code MainComponent} and {@code SubComponent}.
 * @author Ma Xiao
 * @author Fu Mengyan
 * @author Kevin Steven Kihata
 * @author Ng Chen Ee Kenneth
 * @author Ian Tan Yi
 * @version 1.0
 *
 */

public abstract class CourseworkComponent {
    /**
     * The ID of this course.
     */
    private String componentName;
    /**
     * The ID of this course.
     */
    private int componentWeight;

    /**
     * The ID of this course.
     */
    public CourseworkComponent(String componentName, int componentWeight) {
        this.componentName = componentName;
        this.componentWeight = componentWeight;
    }

    /**
     * The ID of this course.
     */
    public String getComponentName() {
        return this.componentName;
    }

    /**
     * The ID of this course.
     */
    public int getComponentWeight() {
        return this.componentWeight;
    }

    /**
     * The ID of this course.
     */
    public abstract void printComponentType();
}
