package com.ss4group8;

import java.util.ArrayList;

public class TutorialGroup {
    private String grouplName;
    private int availableVacancies;

    public String getGroupName() { return this.grouplName; }

    public int getAvailableVacancies() { return this.availableVacancies; }

    public void enrolledIn () {
        this.availableVacancies -= 1;
    }

}
