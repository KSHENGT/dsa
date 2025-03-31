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
import entity.ApplicantManagementEntity;

public class ApplicantManagementDAO {

    private ListInterface<ApplicantManagementEntity> applicantsDatabase = new DoublyLinkedList<>();

    public ApplicantManagementDAO() {
        HardCode();

    }

    public void HardCode() {
        applicantsDatabase.add(new ApplicantManagementEntity("Alice", 30, "alice@example.com", Arrays.asList("Java", "Python"), "Kuala Lumpur", "Software Engineer", 2, new Date()));
        applicantsDatabase.add(new ApplicantManagementEntity("Bob", 20, "bob@example.com", Arrays.asList("C++", "SQL"), "Penang", "Data Analyst", 3, new Date()));
    }

    public ListInterface<ApplicantManagementEntity> getApplicantsDatabase() {
        return applicantsDatabase;
    }

}
