/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import java.util.Scanner;

/**
 *
 * @author jians
 */
public class ApplicationManagementUI {
    Scanner scanner = new Scanner(System.in);
    
    public int getMenuChoice() {
        System.out.println("\nApplication");
        System.out.println(" 1. List Applications");
        System.out.println(" 2. Match");
        System.out.println("-1. Back");
        System.out.println(" 0. Quit");
        System.out.println("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }
    
    public void listAllApplications(String outputStr) {
        System.out.println("\nApplication List:\n" + outputStr);
    }
}
