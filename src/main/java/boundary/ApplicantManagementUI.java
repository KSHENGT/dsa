/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import entity.Applicant;
import java.util.Scanner;

/**
 *
 * @author Hong Yip
 */
public class ApplicantManagementUI {

    Scanner scanner = new Scanner(System.in);

    public static void displayHeader(String title) {
        int width = 216;
        String border = "-".repeat(width);
        String padding = " ".repeat((width - title.length() - 2) / 2);

        System.out.println(border);
        System.out.println("|" + padding + title + padding + "|");
        System.out.println(border);
    }

    public int getChoice() {
        int choice = 0;
        System.out.println("\n1. Create Applicant Profile");
        System.out.println("2. Update Applicant Profile");
        System.out.println("3. Remove Applicant Profile");
        System.out.println("4. Filter Applicants (by criteria)");
        System.out.println("5. View All Applicants");
        System.out.println("6. Back to Main Function");
        System.out.println("0. Exit\n\n");

        while (true) {
            try {
                System.out.print("Please select an option > ");
                choice = Integer.parseInt(scanner.nextLine());
                if ((choice >= 1 && choice <= 6) || choice == 0) {
                    break;
                } else {
                    System.out.println("\nInvalid option! Please enter a number between 1 and 5.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");
            }
        }
        return choice;
    }
    
    public static void printSeparator() {
        System.out.println("-".repeat(216));
    }

    public static void displayApplicantTableHeader() {
        int idWidth = 6, nameWidth = 22, genderWidth = 6, ageWidth = 3, emailWidth = 24;
        int skillsWidth = 27, locationWidth = 13, jobTypeWidth = 24, expWidth = 5;
        int salaryWidth = 12, statusWidth = 8, dateWidth = 28;

        String format = "| %-" + idWidth + "s | %-" + nameWidth + "s | %-" + genderWidth + "s | %-" + ageWidth + "s | %-"
                        + emailWidth + "s | %-" + skillsWidth + "s | %-" + locationWidth + "s | %-" + jobTypeWidth + "s | %-"
                        + expWidth + "s | %-" + salaryWidth + "s | %-" + statusWidth + "s | %-" + dateWidth + "s |\n";

        System.out.printf(format, "ID", "Name", "Gender", "Age", "Email", "Skills", "Location", "Job Type", "Exp", "Salary", "Status", "Applied Date");
        printSeparator();
    }

    
    
    public static void displayApplicantTable(Applicant applicant) {
        int idWidth = 6, nameWidth = 22, genderWidth = 6, ageWidth = 3, emailWidth = 24;
        int skillsWidth = 27, locationWidth = 13, jobTypeWidth = 24, expWidth = 5;
        int salaryWidth = 12, statusWidth = 8, dateWidth = 28;

        String format = "| %-" + idWidth + "s | %-" + nameWidth + "s | %-" + genderWidth + "s | %-" + ageWidth + "s | %-"
                        + emailWidth + "s | %-" + skillsWidth + "s | %-" + locationWidth + "s | %-" + jobTypeWidth + "s | %-"
                        + expWidth + "s | %-" + salaryWidth + "s | %-" + statusWidth + "s | %-" + dateWidth + "s |\n";

        System.out.printf(format,
            applicant.getApplicantID(),
            applicant.getName(),
            applicant.getGender(),
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

}
