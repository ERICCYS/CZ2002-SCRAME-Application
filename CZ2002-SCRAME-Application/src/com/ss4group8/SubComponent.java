package com.ss4group8;

/**
 * Represents a sub-component of a main component.
 * A main component can have many or no sub-components.
 * This class extends {@code CourseWorkComponent}.
 * @author Ma Xiao
 * @author Fu Mengyan
 * @author Kevin Steven Kihata
 * @author Ng Chen Ee Kenneth
 * @author Ian Tan Yi
 * @version 1.0
 *
 */
public class SubComponent extends CourseworkComponent {
    /**
     * Creates a sub-component with this sub-component's name and this sub-component's weightage.
     * This function makes use of the interface {@code CourseWorkComponent}.
     * @param componentName This sub-component's name.
     * @param componentWeight This sub-component's weightage.
     */
    public SubComponent(String componentName, int componentWeight) {
        super(componentName, componentWeight);
    }

    /**
     * Displays the type of this component, which is a sub-component.
     */
    public void printComponentType() {
        System.out.println("This is a sub-component.");
    }
}
