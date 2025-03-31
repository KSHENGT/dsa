/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author KSHENGT
 */
package entity;

public class Job {
    private int jobId;
    private String title;
    private String description;
    private String jobType;
    private double salaryRange;
    private String company;
    private String location;

    public Job(int jobId, String title, String description, String jobType, double salaryRange, String company, String location) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.jobType = jobType;
        this.salaryRange = salaryRange;
        this.company = company;
        this.location = location;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public double getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(double salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Job ID: " + jobId + "\n" +
               "Title: " + title + "\n" +
               "Description: " + description + "\n" +
               "Job Type: " + jobType + "\n" +
               String.format("Salary: %.2f\n", salaryRange) +
               "Company: " + company + "\n" +
               "Location: " + location + 
               "\n";
    }
}

