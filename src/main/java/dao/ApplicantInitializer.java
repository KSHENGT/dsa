/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.*;

/**
 *
 * @author Hong Yip
 */
import adt.DoublyLinkedList;
import adt.ListInterface;
import entity.Applicant;
import entity.ApplicantSkill;

public class ApplicantInitializer {
    
    public ListInterface<Applicant> initializeApplicants() {
        ListInterface<Applicant> applicantList = new DoublyLinkedList<>();
        
        
        // Applicant 1
        Applicant a1 = new Applicant("Alice", 30, "alice@example.com", "Java, Python", "Kuala Lumpur", "Software Engineer", 2, 2000, new Date());
        a1.addSkill(new ApplicantSkill("Java", "Advanced"));
        a1.addSkill(new ApplicantSkill("Python", "Intermediate"));

        // Applicant 2
        Applicant a2 = new Applicant("Bob", 20, "bob@example.com", "C++, SQL", "Penang", "Data Analyst", 3, 2000, new Date());
        a2.addSkill(new ApplicantSkill("C++", "Intermediate"));
        a2.addSkill(new ApplicantSkill("SQL", "Advanced"));

        applicantList.add(a1);
        applicantList.add(a2);
        
        return applicantList;
    }
    
    public static void main(String[] args) {
        ApplicantInitializer applicantInitializer = new ApplicantInitializer();
        ListInterface<Applicant> applicantList = applicantInitializer.initializeApplicants();
        System.out.println("\nApplicants:\n" + applicantList);
    }
}

