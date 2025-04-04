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

public class ApplicantInitializer {
    
    public ListInterface<Applicant> initializeApplicants() {
        ListInterface<Applicant> applicantList = new DoublyLinkedList<>();
        applicantList.add(new Applicant("Alice", 30, "alice@example.com", "Java, Python", "Kuala Lumpur", "Software Engineer", 2, 2000, new Date()));
        applicantList.add(new Applicant("Bob", 20, "bob@example.com", "C++, SQL", "Penang", "Data Analyst", 3, 2000, new Date()));
        return applicantList;
    }
    
    public static void main(String[] args) {
        ApplicantInitializer applicantInitializer = new ApplicantInitializer();
        ListInterface<Applicant> applicantList = applicantInitializer.initializeApplicants();
        System.out.println("\nApplicants:\n" + applicantList);
    }
}

