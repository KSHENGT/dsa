package boundary;

import entity.Job;
import java.util.Scanner;

/**
 * Job UI for user interaction
 */
public class JobUI {
    private Scanner scanner;

    public JobUI() {
        scanner = new Scanner(System.in);
    }

    public int getMenuChoice() {
        System.out.println("\n========== JOB MANAGEMENT MENU ==========");
        System.out.println("1. List all jobs");
        System.out.println("2. Add a new job");
        System.out.println("3. Update a job");
        System.out.println("4. Delete a job");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");

        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Please enter a valid option: ");
            scanner.next();
        }

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return choice;
    }

    public void listAllJobs(String jobDetails) {
        System.out.println("\n========== LIST OF JOBS ==========");
        System.out.println(jobDetails.isEmpty() ? "No jobs available." : jobDetails);
    }

    public Job inputJobDetails() {
        System.out.println("\n========== ADD / UPDATE JOB ==========");

        int jobId = getValidInt("Enter Job ID: ");
        System.out.print("Enter Job Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Job Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter Job Type (Full-Time/Part-Time): ");
        String jobType = scanner.nextLine();

        double salaryRange = getValidDouble("Enter Salary Range: ");
        System.out.print("Enter Company Name: ");
        String company = scanner.nextLine();

        System.out.print("Enter Job Location: ");
        String location = scanner.nextLine();

        int experience = getValidInt("Enter Required Experience (years): ");

        return new Job(title, description, jobType, salaryRange, company, location);
    }

    public int inputJobId() {
        return getValidInt("\nEnter Job ID: ");
    }

    /**
     * Helper method to ensure valid integer input
     */
    private int getValidInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Please enter a number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return value;
    }

    /**
     * Helper method to ensure valid double input
     */
    private double getValidDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input! Please enter a valid number: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        return value;
    }
}
