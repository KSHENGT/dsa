/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

/**
 *
 * @author shenl
 */
import java.util.Scanner;

public class InterviewUI {
    Scanner scanner = new Scanner(System.in);
    
    public static void displayHeader(String title) {
    int width = 214;
    String border = "-".repeat(width);
    String padding = " ".repeat((width - title.length() - 2) / 2);

    System.out.println(border);
    System.out.println("|" + padding + title + padding + "|");
    System.out.println(border);
    }
    
    public int getMenuChoice() {
        int choice = 0;
        System.out.println("\nInterview Management");
        System.out.println("1. Schedule Interviews");
        System.out.println("2. Filter Successful Applicants");
        System.out.println("3. Generate Interview Schedule Report");
        System.out.println("4. Back to Main Function");
        System.out.println("0. Exit\n\n");

        while (true) {
            try {
                System.out.print("Please select an option > ");
                choice = Integer.parseInt(scanner.nextLine());
                if ((choice >= 1 && choice <= 4) || choice == 0) {
                    break;
                } else {
                    System.out.println("\nInvalid option! Please enter a number between 1 and 3.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");
            }
        }
        return choice;
      
    }
    
    public void displayScheduleInterviewMessage(String message) {
        System.out.println("\n" + message);
    }
    
    public void displayFilteredApplicants(String applicantList) {
        System.out.println("\nFiltered Applicants:\n" + applicantList);
    }
    
    public void displayInterviewReport(String report) {
        System.out.println("\nInterview Schedule Report:\n" + report);
    }
    
    public String getJobIdInput() {
        System.out.print("Enter Job ID: ");
        return scanner.nextLine();
    }

    public String getApplicantIdInput() {
        System.out.print("Enter Applicant ID: ");
        return scanner.nextLine();
    }
    
    public String getInterviewTypeInput() {
        String[] interviewTypes = {"Online", "In-Person", "Phone"};
        int choice;

        do {
            System.out.println("Select Interview Type:");
            for (int i = 0; i < interviewTypes.length; i++) {
                System.out.println((i + 1) + ". " + interviewTypes[i]);
            }
            System.out.print("Enter your choice (1-" + interviewTypes.length + "): ");

            if (scanner.hasNextInt()) { // Check for integer input
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (choice >= 1 && choice <= interviewTypes.length) {
                    return interviewTypes[choice - 1];
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and " + interviewTypes.length + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
                choice = 0; // Force loop to continue
            }
        } while (true);
    }
    
    public String getInterviewLocationInput() {
        System.out.print("Enter Interview Location: ");
        return scanner.nextLine();
    }

    public String getDateInput() {
        System.out.print("Enter Interview Date (YYYY-MM-DD HH:mm): ");
        return scanner.nextLine();
    }

    public String getFilterCriteriaInput() {
        System.out.print("Enter filter criteria (e.g., job title, date range): ");
        return scanner.nextLine();
    }
}
