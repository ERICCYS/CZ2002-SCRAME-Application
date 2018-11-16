package com.ss4group8;

/**
 * Represents a professor at school
 */

public class Professor {
    /**
     * this professor's ID
     */

    private String profID;

    /**
     * this professor's Name
     */
    private String profName;

    /**
     * this professor's department
     */
    private String profDepartment;

    /**
     * Creates professor with professor ID and professor name.
     * @param profID the ID of the professor
     * @param profName the name of the professor
     */
    public Professor(String profID, String profName) {
        this.profID = profID;
        this.profName = profName;
    }

    /**
     * Gets this professor's ID
     * @return the ID of this professor
     */

    public String getProfID() {
        return profID;
    }

    /**
     * Gets this professor's name
     * @return the name of this professor
     */
    public String getProfName() {
        return profName;
    }

    /**
     * Gets this professor's department
     * @return the department of this professor
     */
    public String getProfDepartment(){
        return profDepartment;
    }

    /**
     * Sets the department of the professor
     * @param profDepartment this professor's department
     */
    public void setProfDepartment(String profDepartment) {
        this.profDepartment = profDepartment;
    }

}
