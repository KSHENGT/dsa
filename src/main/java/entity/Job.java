
package entity;

import adt.DoublyLinkedList;
import adt.ListInterface;
import java.time.LocalDate;
import java.util.Objects;

public class Job implements Comparable<Job> {
    private static int idCounter = 1;
    private String jobId;
    private String title;
    private String description;
    private String jobType;
    private double salaryRange;
    private String company;
    private String location;
    private LocalDate dateRelease; // Automatically stores the creation date

    public Job(String title, String description, String jobType, double salaryRange, String company, String location) {
        this.jobId = String.format("J%03d", idCounter++);
        this.title = title;
        this.description = description;
        this.jobType = jobType;
        this.salaryRange = salaryRange;
        this.company = company;
        this.location = location;
        this.dateRelease = LocalDate.now(); // Automatically set to current date
    }

    // Getter and Setter Methods
    public String getJobId() { return jobId; }
    public void setJobId(String jobId) { this.jobId = jobId; }

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
               "Date Released: " + dateRelease + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Job job = (Job) obj;
        return jobId == job.jobId && Double.compare(job.salaryRange, salaryRange) == 0 &&
               Objects.equals(title, job.title) && Objects.equals(description, job.description) &&
               Objects.equals(jobType, job.jobType) && Objects.equals(company, job.company); // &&
//               Objects.equals(location, job.location) && Objects.equals(requiredSkills, job.requiredSkills);
    }

    @Override
    public int compareTo(Job other) {
        return Double.compare(this.salaryRange, other.salaryRange);
    }
}
