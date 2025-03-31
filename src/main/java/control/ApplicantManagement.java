/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.*;

import adt.DoublyLinkedList;
import adt.ListInterface;
import java.util.Scanner;
import boundary.ApplicantManagementUI;
import dao.ApplicantManagementDAO;
import utility.Screen;
import entity.ApplicantManagementEntity;

/**
 *
 * @author Hong Yip
 */
public class ApplicantManagement {

    ApplicantManagementUI appMgmtUI = new ApplicantManagementUI();
    ApplicantManagementDAO applicantDAO = new ApplicantManagementDAO();
    //ListInterface<ApplicantManagementEntity> applicantsDatabase = new LinkedList<>();
    ListInterface<ApplicantManagementEntity> applicantsDatabase = applicantDAO.getApplicantsDatabase();

    Scanner scanner = new Scanner(System.in);

//    public ApplicantManagement() {
//        loadHardcodedApplicants();
//    }
//
//    private void loadHardcodedApplicants() {
//        for (int i = 1; i <= applicantDAO.getApplicantsDatabase().getNumberOfEntries(); i++) {
//            applicantsDatabase.add(applicantDAO.getApplicantsDatabase().getEntry(i));
//        }
//    }
    public ApplicantManagement() {
        
    }
    public static void main(String[] args) {
        ApplicantManagement app = new ApplicantManagement();
        app.appMenu();
    }

    public void appMenu() {
        int choice;
        do {
            appMgmtUI.displayHeader("Applicant Management (Job Seeker)");
            choice = appMgmtUI.getChoice();

            switch (choice) {
                case 1:
                    createApplicantProfile();
                    break;
                case 2:
                    updateApplicantProfile();
                    break;
                case 3:
                    removeApplicantProfile();
                    break;
                case 4:
                    filterApplicants();
                    break;
                case 5:
                    viewAllApplicants();
                    break;
            }
        } while (choice != 6);
    }

    public void createApplicantProfile() {
        Screen.clearScreen();
        appMgmtUI.displayHeader("Create Application");
        System.out.print("Enter name : ");
        String name = scanner.nextLine();

        System.out.print("Enter age : ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter email (e.g., johndoe@example.com): ");
        String email = scanner.nextLine();

        System.out.print("Enter skills (comma-separated, e.g., Java, Python, SQL): ");
        List<String> skills = Arrays.asList(scanner.nextLine().split(","));

        System.out.print("Enter your location (e.g., Kuala Lumpur): ");
        String location = scanner.nextLine();

        System.out.print("Enter desired job type (e.g., Software Engineer): ");
        String jobType = scanner.nextLine();

        System.out.print("Enter years of experience : ");
        int experience = scanner.nextInt();
        
        scanner.nextLine();

        String confirmation;
        while (true) {
            System.out.print("\nConfirm adding this applicant? (Y/N): ");
            confirmation = scanner.nextLine().trim().toUpperCase();

            if (confirmation.equals("Y") || confirmation.equals("N")) {
                break; // Exit loop if input is valid
            } else {
                System.out.println("Invalid input! Please enter 'Y' or 'N'.");
            }
        }

        if (confirmation.equals("Y")) {
            applicantsDatabase.add(new ApplicantManagementEntity(name, age, email, skills, location, jobType, experience, new Date()));
            System.out.println("Applicant Created Successfully!");
        } else {
            System.out.println("Applicant Not Added.");
        }
        Screen.pauseScreen();
    }

    public void updateApplicantProfile() {
        Screen.clearScreen();
        System.out.println("Updating applicant profile...");
        Screen.pauseScreen();
    }

    public void removeApplicantProfile() {
        Screen.clearScreen();
        System.out.println("Removing applicant profile...");
        Screen.pauseScreen();
    }

    public void filterApplicants() {
        Screen.clearScreen();
        System.out.println("Filtering applicants based on criteria...");
        Screen.pauseScreen();
    }

    public void viewAllApplicants() {
        Screen.clearScreen();
        for (int i = 1; i <= applicantsDatabase.getNumberOfEntries(); i++) {
            System.out.println(applicantsDatabase.getEntry(i));
        }
        Screen.pauseScreen();
    }

}
