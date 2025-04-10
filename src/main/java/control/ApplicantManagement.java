/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import java.util.*;
import adt.ListInterface;
import java.util.Scanner;
import boundary.ApplicantManagementUI;
import dao.Initializer;
import utility.Screen;
import entity.Applicant;

/**
 *
 * @author Hong Yip
 */
public class ApplicantManagement {

    ApplicantManagementUI appMgmtUI = new ApplicantManagementUI();
    private ListInterface<Applicant> applicant = new DoublyLinkedList<>();
    Scanner scanner = new Scanner(System.in);

    public ApplicantManagement() {
        applicant = Initializer.applicants;
    }
    
    public static void main(String[] args) {
        ApplicantManagement app = new ApplicantManagement();
        app.RunApplicantController();
    }

    public void RunApplicantController() {
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
                case 6:
                    Screen.clearScreen();
                    return;
            }
        } while (choice != 0);
    }

    public void createApplicantProfile() {
        Screen.clearScreen();
        appMgmtUI.displayHeader("Create Application");
        System.out.print("Enter name : ");
        String name = scanner.nextLine();
        
        System.out.print("Enter gender : ");
        String gender = scanner.nextLine();

        System.out.print("Enter age : ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter email (e.g., johndoe@example.com): ");
        String email = scanner.nextLine();

        System.out.print("Enter skills (comma-separated, e.g., Java, Python, SQL): ");
        String skills = scanner.nextLine();

        System.out.print("Enter your location (e.g., Kuala Lumpur): ");
        String location = scanner.nextLine();

        System.out.print("Enter desired job type (e.g., Software Engineer): ");
        String jobType = scanner.nextLine();

        System.out.print("Enter years of experience : ");
        int experience = scanner.nextInt();
        
        System.out.print("Enter expected salary (e.g., 5000): RM ");
        double expectedSalary = scanner.nextDouble();
        
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
            applicant.add(new Applicant(name, gender, age, email, skills, location, jobType, experience, expectedSalary, new Date()));
            System.out.println("Applicant Created Successfully!");
        } else {
            System.out.println("Applicant Not Added.");
        }
        Screen.pauseScreen();
    }

    public void updateApplicantProfile() {
        Screen.clearScreen();
        appMgmtUI.displayHeader("Update Applicant Profile");
        System.out.print("\nEnter ID to update: ");
        String id = scanner.nextLine().trim();
        Screen.clearScreen();
        boolean found = false;

        for (int i = 1; i <= applicant.getNumberOfEntries(); i++) {
            Applicant applicant = this.applicant.getEntry(i);

            if (applicant.getApplicantID().equals(id)) { // Find applicant by ID
                found = true;

                // Create a copy of the current applicant details
                String tempName = applicant.getName();
                int tempAge = applicant.getAge();
                String tempEmail = applicant.getEmail();
                String tempSkills = applicant.getSkills();
                String tempLocation = applicant.getLocation();
                String tempJobType = applicant.getDesiredJobType();
                int tempExperience = applicant.getExperience();
                double tempSalary = applicant.getExpectedSalary();
                String tempStatus = applicant.getStatus();

                boolean keepUpdating = true;
                while (keepUpdating) {
                    Screen.clearScreen();
                    
                    // Display the current details
                    appMgmtUI.displayHeader("Current Applicant Details");
                    appMgmtUI.displayApplicantTableHeader();
                    // Print selected applicant with temporary values
                    System.out.printf("| %-6s | %-22s | %-3d | %-26s | %-27s | %-15s | %-24s | %-5d | RM%-12.2f | %-8s | %-30s |\n",
                        applicant.getApplicantID(), tempName, tempAge, tempEmail, tempSkills, tempLocation, tempJobType,
                        tempExperience, tempSalary, tempStatus, applicant.getDateApplied().toString());
                    appMgmtUI.printSeparator();

                    // Ask user which field to update
                    System.out.println("\nWhich field do you want to update?");
                    System.out.println("1. Name\n2. Age\n3. Email\n4. Skills\n5. Location\n6. Job Type\n7. Experience\n8. Salary\n9. Status");
                    System.out.println("0. Done Updating");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); 

                    if (choice == 0) {
                        keepUpdating = false;
                        break;
                    }

                    // Get new value from user
                    System.out.print("Enter new value: ");
                    String newValue = scanner.nextLine().trim();

                    // Store the change temporarily
                    switch (choice) {
                        case 1 -> tempName = newValue;
                        case 2 -> tempAge = Integer.parseInt(newValue);
                        case 3 -> tempEmail = newValue;
                        case 4 -> tempSkills = newValue;
                        case 5 -> tempLocation = newValue;
                        case 6 -> tempJobType = newValue;
                        case 7 -> tempExperience = Integer.parseInt(newValue);
                        case 8 -> tempSalary = Double.parseDouble(newValue);
                        case 9 -> tempStatus = newValue;
                        default -> System.out.println("Invalid choice!");
                    }
                }

                // Show final updated details for confirmation
                Screen.clearScreen();
                appMgmtUI.displayHeader("Final Updated Applicant Profile");
                appMgmtUI.displayApplicantTableHeader();
                System.out.printf("| %-6s | %-22s | %-3d | %-26s | %-27s | %-15s | %-24s | %-5d | RM%-12.2f | %-8s | %-30s |\n",
                    applicant.getApplicantID(), tempName, tempAge, tempEmail, tempSkills, tempLocation, tempJobType,
                    tempExperience, tempSalary, tempStatus, applicant.getDateApplied().toString());
                appMgmtUI.printSeparator();

                // Confirm update
                System.out.print("Confirm update? (Y/N): ");
                String confirm = scanner.nextLine().trim().toUpperCase();
                if (confirm.equals("Y")) {
                    // Apply changes only if confirmed
                    applicant.setName(tempName);
                    applicant.setAge(tempAge);
                    applicant.setEmail(tempEmail);
                    applicant.setSkills(tempSkills);
                    applicant.setLocation(tempLocation);
                    applicant.setDesiredJobType(tempJobType);
                    applicant.setExperience(tempExperience);
                    applicant.setExpectedSalary(tempSalary);
                    applicant.setStatus(tempStatus);
                    this.applicant.replace(i, applicant);
                    System.out.println("Applicant profile updated successfully!");
                    Screen.pauseScreen();
                } else {
                    System.out.println("Update cancelled.");
                    Screen.pauseScreen();
                }
                return;
            }
        }

        if (!found) {
            System.out.println("Applicant not found!");
        }
        Screen.pauseScreen();
    }

    
    private void removeApplicantProfile() {
        Screen.clearScreen();
        appMgmtUI.displayHeader("Remove Applicant Profile");
        System.out.print("Enter ID to remove: ");
        String id = scanner.nextLine();
        Screen.clearScreen();
        boolean found = false;

        appMgmtUI.displayHeader("Remove Applicant Profile");
        appMgmtUI.displayApplicantTableHeader();
        for (int i = 1; i <= applicant.getNumberOfEntries(); i++) {
            Applicant applicant = this.applicant.getEntry(i);

            if (applicant.getApplicantID().equals(id)) {
                found = true;
                appMgmtUI.displayApplicantTable(applicant);
                appMgmtUI.printSeparator();

                // Ask for confirmation
                System.out.print("Are you sure you want to remove this applicant? (Y/N): ");
                String confirm = scanner.nextLine().trim().toUpperCase();

                if (confirm.equals("Y")) {
                    this.applicant.remove(i); // Corrected to remove from DAO list
                    System.out.println("Applicant removed successfully!\n");
                } else {
                    System.out.println("Removal cancelled.");
                }
                
            }
            
        }

        if (!found) {
            System.out.println("\nApplicant not found!");
        }
        Screen.pauseScreen();
    }



    public void filterApplicants() {
        Screen.clearScreen();
        System.out.println("Filtering applicants based on criteria...");
        Screen.pauseScreen();
    }
    
    public void viewAllApplicants() {
        Screen.clearScreen();

        // Print centered header
        appMgmtUI.displayHeader("Applicant");

        if (applicant.getNumberOfEntries() == 0) {
            System.out.println("No applicants available.");
        } else {
            appMgmtUI.displayApplicantTableHeader();

            // Print each applicant
            for (int i = 1; i <= applicant.getNumberOfEntries(); i++) {
                Applicant applicant = this.applicant.getEntry(i);
                appMgmtUI.displayApplicantTable(applicant);
            }
            appMgmtUI.printSeparator();
        }

        Screen.pauseScreen();
    }

}
