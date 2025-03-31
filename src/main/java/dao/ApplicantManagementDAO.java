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

public class ApplicantManagementDAO {

    public static ListInterface<Applicant> applicantsDatabase = new DoublyLinkedList<>();

    public ApplicantManagementDAO() {
        HardCode();

    }
    
    public ListInterface<Applicant> initializeApplicants() {
        applicantsDatabase.add(new Applicant("Alice", 30, "alice@example.com", "Java, Python", "Kuala Lumpur", "Software Engineer", 2, 2000, new Date()));
        applicantsDatabase.add(new Applicant("Bob", 20, "bob@example.com", "C++, SQL", "Penang", "Data Analyst", 3, 2000, new Date()));
        return applicantsDatabase;
    }

    public void HardCode() {
        applicantsDatabase.add(new Applicant("Alice", 30, "alice@example.com", "Java, Python", "Kuala Lumpur", "Software Engineer", 2, 2000, new Date()));
        applicantsDatabase.add(new Applicant("Bob", 20, "bob@example.com", "C++, SQL", "Penang", "Data Analyst", 3, 2000, new Date()));
    }
    

}
