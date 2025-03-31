/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.*;
import entity.Application;
import entity.Job;
import entity.Applicant;
/**
 *
 * @author jians
 */
public class ApplicationInitializer {
    Initializer jobInitializer = new Initializer();
    ApplicantManagementDAO applicantInitializer = new ApplicantManagementDAO();
    
    ListInterface<Job> jobList = jobInitializer.retrieveJobs();
    ListInterface<Applicant> applicantList = applicantInitializer.initializeApplicants();
    
    public ListInterface<Application> initializeApplications() {
        ListInterface<Application> applicationList = new DoublyLinkedList<>();
        
        applicationList.add(new Application("AP001", "pending", jobList.getEntry(1), applicantList.getEntry(1)));
        applicationList.add(new Application("AP002", "pending", jobList.getEntry(2), applicantList.getEntry(2)));
        applicationList.add(new Application("AP003", "pending", jobList.getEntry(3), applicantList.getEntry(3)));
        applicationList.add(new Application("AP004", "accepted", jobList.getEntry(4), applicantList.getEntry(4)));
        applicationList.add(new Application("AP005", "rejected", jobList.getEntry(5), applicantList.getEntry(5)));
        
        return applicationList;
    }
    
    public static void main(String[] args) {
        ApplicationInitializer applicationInitializer = new ApplicationInitializer();
        ListInterface<Application> applicationList = applicationInitializer.initializeApplications();
        System.out.println("\nApplication:\n" + applicationList);
    }
}
