/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;
import adt.DoublyLinkedList;
import adt.ListInterface;
import entity.Applicant;
import entity.Application;
import java.util.Date;
/**
 *
 * @author Hong Yip
 */
public class Initializer {
    public static ListInterface<Applicant> applicants = new DoublyLinkedList<>();
    public static ListInterface<Application> applications = new DoublyLinkedList<>();
    
    public Initializer() {
        initializer();
    }
    
    
    public void initializer() {
        //Applicant 
        Applicant a1 = new Applicant("Alice", "Female", 30, "alice@example.com", "Java, Python", "Kuala Lumpur", "Software Engineer", 2, 2000, new Date());
        Applicant a2 = new Applicant("Bob", "Male", 20, "bob@example.com", "C++, SQL", "Penang", "Data Analyst", 3, 2000, new Date());
        applicants.add(a1);
        applicants.add(a2);
        
        //APplication
        //Application ape1 = new Application(....);
        //applications.add(ape1);
        
        
    }
}
