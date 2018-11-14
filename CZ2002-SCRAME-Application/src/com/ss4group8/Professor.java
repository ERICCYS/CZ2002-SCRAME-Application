package com.ss4group8;

public class Professor {
    private String profID;
    private String profName;
    private String profDepartment;

    public Professor(String profID, String profName) {
        this.profID = profID;
        this.profName = profName;
    }

    public String getProfID() {
        return profID;
    }

    public String getProfName() {
        return profName;
    }

    public String getProfDepartment(){
        return profDepartment;
    }


    public void setProfDepartment(String profDepartment) {
        this.profDepartment = profDepartment;
    }

}
