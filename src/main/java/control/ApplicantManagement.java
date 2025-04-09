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
import dao.ApplicantInitializer;
import utility.Screen;
import entity.Applicant;

/**
 *
 * @author Hong Yip
 */
public class ApplicantManagement {

    ApplicantManagementUI appMgmtUI = new ApplicantManagementUI();
    // private ApplicantInitializer applicantInitializer = new ApplicantInitializer();
    private ListInterface<Applicant> applicantList = new DoublyLinkedList<>();


    Scanner scanner = new Scanner(System.in);

    public ApplicantManagement(ListInterface<Applicant> applicantList) {
        this.applicantList = applicantList;
        // applicantList = applicantInitializer.initializeApplicants();
    }
    
    public static void main(String[] args) {
        ListInterface<Applicant> applicantList = new DoublyLinkedList<>();
        
        ApplicantInitializer applicantInitializer = new ApplicantInitializer();
        applicantList = applicantInitializer.initializeApplicants();
        
        ApplicantManagement app = new ApplicantManagement(applicantList);
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

        System.out.print("Enter age : ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

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
            applicantList.add(new Applicant(name, age, email, skills, location, jobType, experience, expectedSalary, new Date()));
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

        for (int i = 1; i <= applicantList.getNumberOfEntries(); i++) {
            Applicant applicant = applicantList.getEntry(i);

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
                    System.out.printf("%-6s | %-22s | %-3s | %-26s | %-27s | %-15s | %-24s | %-5s | %-14s | %-8s | %-30s\n",
                        "ID", "Name", "Age", "Email", "Skills", "Location", "Job Type", "Exp", "Salary", "Status", "Applied Date");
                    System.out.println("-".repeat(214));

                    // Print selected applicant with temporary values
                    System.out.printf("%-6s | %-22s | %-3d | %-26s | %-27s | %-15s | %-24s | %-5d | RM%-12.2f | %-8s | %-30s\n",
                        applicant.getApplicantID(), tempName, tempAge, tempEmail, tempSkills, tempLocation, tempJobType,
                        tempExperience, tempSalary, tempStatus, applicant.getDateApplied().toString());
                    System.out.println("-".repeat(214));

                    // Ask user which field to update
                    System.out.println("\nWhich field do you want to update?");
                    System.out.println("1. Name\n2. Age\n3. Email\n4. Skills\n5. Location\n6. Job Type\n7. Experience\n8. Salary\n9. Status");
                    System.out.println("0. Done Updating");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

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
                System.out.printf("%-6s | %-22s | %-3s | %-26s | %-27s | %-15s | %-24s | %-5s | %-14s | %-8s | %-30s\n",
                    "ID", "Name", "Age", "Email", "Skills", "Location", "Job Type", "Exp", "Salary", "Status", "Applied Date");
                System.out.println("-".repeat(214));
                System.out.printf("%-6s | %-22s | %-3d | %-26s | %-27s | %-15s | %-24s | %-5d | RM%-12.2f | %-8s | %-30s\n",
                    applicant.getApplicantID(), tempName, tempAge, tempEmail, tempSkills, tempLocation, tempJobType,
                    tempExperience, tempSalary, tempStatus, applicant.getDateApplied().toString());
                System.out.println("-".repeat(214));

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
                    applicantList.replace(i, applicant);
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
        for (int i = 1; i <= applicantList.getNumberOfEntries(); i++) {
            Applicant applicant = applicantList.getEntry(i);

            if (applicant.getApplicantID().equals(id)) {
                found = true;

                int idWidth = 6, nameWidth = 22, ageWidth = 3, emailWidth = 26;
                int skillsWidth = 27, locationWidth = 15, jobTypeWidth = 24, expWidth = 5;
                int salaryWidth = 14, statusWidth = 8, dateWidth = 30;

                String format = "| %-" + idWidth + "s | %-" + nameWidth + "s | %-" + ageWidth + "s | %-" + emailWidth + "s | %-"
                              + skillsWidth + "s | %-" + locationWidth + "s | %-" + jobTypeWidth + "s | %-" + expWidth + "s | %-"
                              + salaryWidth + "s | %-" + statusWidth + "s | %-" + dateWidth + "s |\n";

                
                System.out.printf(format, "ID", "Name", "Age", "Email", "Skills", "Location", "Job Type", "Exp", "Salary", "Status", "Applied Date");
                System.out.println("-".repeat(214));

                // Print selected applicant
                System.out.printf(format,
                    applicant.getApplicantID(),
                    applicant.getName(),
                    applicant.getAge(),
                    applicant.getEmail(),
                    applicant.getSkills(),
                    applicant.getLocation(),
                    applicant.getDesiredJobType(),
                    applicant.getExperience(),
                    "RM" + String.format("%.2f", applicant.getExpectedSalary()),
                    applicant.getStatus(),
                    applicant.getDateApplied().toString()
                );
                System.out.println("-".repeat(214));

                // Ask for confirmation
                System.out.print("Are you sure you want to remove this applicant? (Y/N): ");
                String confirm = scanner.nextLine().trim().toUpperCase();

                if (confirm.equals("Y")) {
                    applicantList.remove(i); // Corrected to remove from DAO list
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

        if (applicantList.getNumberOfEntries() == 0) {
            System.out.println("No applicants available.");
        } else {
            int idWidth = 6, nameWidth = 22, ageWidth = 3, emailWidth = 26;
            int skillsWidth = 27, locationWidth = 15, jobTypeWidth = 24, expWidth = 5;
            int salaryWidth = 14, statusWidth = 8, dateWidth = 30;

            // Print table header
            String format = "| %-" + idWidth + "s | %-" + nameWidth + "s | %-" + ageWidth + "s | %-" + emailWidth + "s | %-"
                          + skillsWidth + "s | %-" + locationWidth + "s | %-" + jobTypeWidth + "s | %-" + expWidth + "s | %-"
                          + salaryWidth + "s | %-" + statusWidth + "s | %-" + dateWidth + "s |\n";

            System.out.printf(format, "ID", "Name", "Age", "Email", "Skills", "Location", "Job Type", "Exp", "Salary", "Status", "Applied Date");
            System.out.println("-".repeat(214));

            // Print each applicant
            for (int i = 1; i <= applicantList.getNumberOfEntries(); i++) {
                Applicant applicant = applicantList.getEntry(i);
                System.out.printf(format,
                    applicant.getApplicantID(),
                    applicant.getName(),
                    applicant.getAge(),
                    applicant.getEmail(),
                    applicant.getSkills(),
                    applicant.getLocation(),
                    applicant.getDesiredJobType(),
                    applicant.getExperience(),
                    "RM" + String.format("%.2f", applicant.getExpectedSalary()),
                    applicant.getStatus(),
                    applicant.getDateApplied().toString()
                );
            }
            System.out.println("-".repeat(214));
        }

        Screen.pauseScreen();
    }




}
