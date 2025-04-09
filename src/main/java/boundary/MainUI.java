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
public class MainUI {
    Scanner scanner = new Scanner(System.in);

    public static void displayHeader(String title) {
        int width = 214;
        String border = "-".repeat(width);
        String padding = " ".repeat((width - title.length() - 2) / 2);

        System.out.println(border);
        System.out.println("|" + padding + title + padding + "|");
        System.out.println(border);
    }

    public int getChoice() {
        int choice;
        System.out.println("\n1. Student Operations");
        System.out.println("2. Job Operations");
        System.out.println("3. Application/Matching Operation");
        System.out.println("4. Interview Operation");
        System.out.println("5. Reports");
        System.out.println("0. Exit\n\n");

        while (true) {
            try {
                System.out.print("Please select an option > ");
                choice = Integer.parseInt(scanner.nextLine());
                if ((choice >= 1 && choice < 6) || choice == 0) {
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
