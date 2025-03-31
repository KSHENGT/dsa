/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 *
 * @author Hong Yip
 */
public class Screen {
    public static void clearScreen() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(10);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);

        } catch (AWTException e) {
            System.out.println("Error clearing screen: " + e.getMessage());
        }
    }
    
    public static void pauseScreen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
        clearScreen();
    }
}