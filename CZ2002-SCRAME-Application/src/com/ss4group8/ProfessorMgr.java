package com.ss4group8;

import java.util.Scanner;

public class ProfessorMgr {
    private Scanner scanner = new Scanner(System.in);

    public Professor addProfessor() {
        System.out.println("Enter the professor's name: ");
        String profName = scanner.nextLine();
        System.out.println("Give this professor an ID: ");
        String profID = scanner.nextLine();
        Professor professor = new Professor(profID, profName);
        return professor;
    }

}
