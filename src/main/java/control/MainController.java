/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;
import boundary.*;
import utility.Screen;
import dao.Initializer;

/**
 *
 * @author Hong Yip
 */
public class MainController {

    MainUI mainUI = new MainUI();
    ApplicantManagement app = new ApplicantManagement();
    //ApplicationManagement application = new ApplicationManagement();
    
    public static void main(String[] args) {
        Initializer initializer = new Initializer();
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
                    app.RunApplicantController();
                    break;
                case 2:
                    break;
                case 3:
                    Screen.clearScreen();
                    //application.Menu();
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        } while (choice != 0);
    }
    
}
