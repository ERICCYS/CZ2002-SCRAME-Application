package com.ss4group8;

import java.util.ArrayList;

public class MainComponent extends CourseworkComponent {
    private ArrayList<SubComponent> subComponents;

    public MainComponent(String componentName, int componentWeight, ArrayList<SubComponent> subComponents) {
        super(componentName, componentWeight);
        this.subComponents = subComponents;
    }

    public ArrayList<SubComponent> getSubComponents() {
        return this.subComponents;
    }

    public void printComponentType() {
        System.out.println("This is a main-component.");
        System.out.println("There are " + this.subComponents.size() + " sub-components inside");
    }

}
