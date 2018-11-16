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
     * The name of this coursework.
     */
    private String componentName;
    /**
     * The weight of this course component.
     */
    private int componentWeight;

    /**
     * Creates a course work components with component name and component weight
     * @param componentName the name of this coursework component
     * @param componentWeight the weight of this coursework component
     */
    public CourseworkComponent(String componentName, int componentWeight) {
        this.componentName = componentName;
        this.componentWeight = componentWeight;
    }

    /**
     * Gets the component name
     * @return the name of this component
     */
    public String getComponentName() {
        return this.componentName;
    }

    /**
     * Gets the weight of this component
     * @return the weight of this component
     */
    public int getComponentWeight() {
        return this.componentWeight;
    }

    /**
     * Prints the component type
     */
    public abstract void printComponentType();
}
