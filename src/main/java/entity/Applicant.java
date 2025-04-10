/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.util.*;

/**
 *
 * @author Hong Yip
 */
public class Applicant {

    private static int idCounter = 1;  
    String applicantID;
    String name;
    String gender;
    int age;
    String email;
    String skills;
    String location;
    String desiredJobType;
    int experience;
    double expectedSalary;
    String status;
    Date dateApplied;

    public Applicant(String name, String gender, int age, String email, String skills, String location, String desiredJobType, int experience, double expectedSalary, Date dateApplied) {
        this.applicantID = String.format("A%03d", idCounter++);
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.skills = skills;
        this.location = location;
        this.desiredJobType = desiredJobType;
        this.experience = experience;
        this.expectedSalary = expectedSalary;
        this.status = "pending";
        this.dateApplied = dateApplied;
    }

    public String getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(String applicantID) {
        this.applicantID = applicantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesiredJobType() {
        return desiredJobType;
    }

    public void setDesiredJobType(String desiredJobType) {
        this.desiredJobType = desiredJobType;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
    
    public double getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(double expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(Date dateApplied) {
        this.dateApplied = dateApplied;
    }

    @Override
    public String toString() {
        return "Applicant{" + "applicantID=" + applicantID + ", name=" + name + ", gender=" + gender + ", age=" + age + ", email=" + email + ", skills=" + skills + ", location=" + location + ", desiredJobType=" + desiredJobType + ", experience=" + experience + ", expectedSalary=" + expectedSalary + ", status=" + status + ", dateApplied=" + dateApplied + '}';
    }
   

}
