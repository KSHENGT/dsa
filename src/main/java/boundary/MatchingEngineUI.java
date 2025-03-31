/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import entity.Job;
import java.util.Scanner;
/**
 *
 * @author jians
 */
public class MatchingEngineUI {
    Scanner scanner = new Scanner(System.in);
    
    public int getMatchingMenuChoice() {
        System.out.println("\nMatching Engine");
        System.out.println("1. Top 5 matched job");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }
    
}
