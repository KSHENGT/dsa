/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;
import boundary.*;
import utility.Screen;

/**
 *
 * @author Hong Yip
 */
public class MainController {

    MainUI mainUI = new MainUI();
    ApplicantManagement app = new ApplicantManagement();
    
    public static void main(String[] args) {
        MainController Main = new MainController();
        Main.runMainController();
    }
    
    public void runMainController() {
        int choice;
        do {
            mainUI.displayHeader("Internship Application System");
            choice = mainUI.getChoice();

            switch (choice) {
                case 1:
                    Screen.clearScreen();
                    app.appMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        } while (choice != 0);
    }
    
}
