/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;
import boundary.*;
import utility.Screen;
import dao.*;
import adt.*;
import entity.*;

/**
 *
 * @author Hong Yip
 */
public class MainController {

    MainUI mainUI = new MainUI();
    ListInterface<Applicant> applicantList = new ApplicantInitializer().initializeApplicants();
    
    ApplicantManagement app = new ApplicantManagement(applicantList);
    ApplicationManagement application = new ApplicationManagement(applicantList);
    
    
    public static void main(String[] args) {
//        ApplicantInitializer applicantInitializer = new ApplicantInitializer();
//        ListInterface<Applicant> applicantList = applicantInitializer.initializeApplicants();
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
                    Screen.clearScreen();
                    application.runApplicationManagement();
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        } while (choice != 0);
    }
    
}
