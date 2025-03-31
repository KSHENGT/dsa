/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import java.util.Scanner;

/**
 *
 * @author Hong Yip
 */
public class ApplicantManagementUI {

    Scanner scanner = new Scanner(System.in);

    public static void displayHeader(String title) {
        int width = Math.max(60, title.length() + 6); 
        int padding = (width - title.length() - 2) / 2;

        String border = "-".repeat(width);
        String centeredTitle = String.format("|%" + (padding + title.length()) + "s%-" + padding + "s|", title, "");

        System.out.println(border);
        System.out.println(centeredTitle);
        System.out.println(border);
    }

    public int getChoice() {
        int choice = 0;
        System.out.println("1. Create Applicant Profile");
        System.out.println("2. Update Applicant Profile");
        System.out.println("3. Remove Applicant Profile");
        System.out.println("4. Filter Applicants (by criteria)");
        System.out.println("5. View All Applicants");
        System.out.println("6. Exit");
        System.out.println("---------------------------------------------------------------");

        while (true) {
            try {
                System.out.print("Please select an option (1-6)> ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 6) {
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

}
