package entity;

import adt.DoublyLinkedList;
import adt.ListInterface;
import java.time.LocalDate;
import java.util.Objects;

public class Job implements Comparable<Job> {
    private int jobId;
    private String title;
    private String description;
    private String jobType;
    private double salaryRange;
    private String company;
    private String location;
    private ListInterface<String> requiredSkills;
    private int requiredExperience;
    private LocalDate dateRelease; // Automatically stores the creation date

    public Job(int jobId, String title, String description, String jobType, double salaryRange, String company, String location, int requiredExperience) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.jobType = jobType;
        this.salaryRange = salaryRange;
        this.company = company;
        this.location = location;
        this.requiredSkills = new DoublyLinkedList<>();
        this.requiredExperience = requiredExperience;
        this.dateRelease = LocalDate.now(); // Automatically set to current date
    }

    // Getter and Setter Methods
    public int getJobId() { return jobId; }
    public void setJobId(int jobId) { this.jobId = jobId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getJobType() { return jobType; }
    public void setJobType(String jobType) { this.jobType = jobType; }

    public double getSalaryRange() { return salaryRange; }
    public void setSalaryRange(double salaryRange) { this.salaryRange = salaryRange; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public ListInterface<String> getRequiredSkills() { return requiredSkills; }
    
    public void addRequiredSkill(String skill) { 
        requiredSkills.add(skill); 
    }

    public int getRequiredExperience() { return requiredExperience; }
    public void setRequiredExperience(int requiredExperience) { this.requiredExperience = requiredExperience; }

    public LocalDate getDateRelease() { return dateRelease; }

    @Override
    public String toString() {
        return "Job ID: " + jobId + "\n" +
               "Title: " + title + "\n" +
               "Description: " + description + "\n" +
               "Job Type: " + jobType + "\n" +
               String.format("Salary: %.2f\n", salaryRange) +
               "Company: " + company + "\n" +
               "Location: " + location + "\n" +
               "Required Experience: " + requiredExperience + " years\n" +
               "Date Released: " + dateRelease + "\n" +
               "Required Skills: " + requiredSkills;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Job job = (Job) obj;
        return jobId == job.jobId && Double.compare(job.salaryRange, salaryRange) == 0 &&
               Objects.equals(title, job.title) && Objects.equals(description, job.description) &&
               Objects.equals(jobType, job.jobType) && Objects.equals(company, job.company) &&
               Objects.equals(location, job.location) && Objects.equals(requiredSkills, job.requiredSkills);
    }

    @Override
    public int compareTo(Job other) {
        return Double.compare(this.salaryRange, other.salaryRange);
    }
}
