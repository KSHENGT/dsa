/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author TAN KAI SHENG
 */

import adt.DoublyLinkedList;
import adt.ListInterface;
import entity.Job;

public class JobInitializer {
    // Static list to store job postings (accessible by DAO)
    

    // Static block to initialize hardcoded job postings
    public ListInterface<Job> initializeJobs() {
        ListInterface<Job> jobList = new DoublyLinkedList<>();
        jobList.add(new Job("Software Engineer", "Develop applications.", "Full-Time", 5000.00, "Tech Corp", "Kuala Lumpur"));
        jobList.add(new Job("Data Analyst", "Analyze data trends.", "Contract", 4500.00, "Data Insights", "Penang"));
        return jobList;
    }
    

        
        
    
    public static void main(String[] args) {
    JobInitializer jobinitializer = new JobInitializer();
    ListInterface<Job> jobslist = jobinitializer.initializeJobs();
    System.out.println("\nJobs:\n" + jobslist);
    }


}
