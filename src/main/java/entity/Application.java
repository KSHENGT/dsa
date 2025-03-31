package entity;

import java.io.Serializable;
import java.util.Date;

public class Application implements Serializable {
    
    private String applicationID;
    private Date applicationDate;
    private String status;
    private Job job;
    private Applicant applicant;
    
    public Application(String applicationID, String status, Job job, Applicant applicant) {
        this.applicationID = applicationID;
//        this.applicationDate = new Date();
        this.status = status;
        this.job = job;
        this.applicant = applicant;
    }

    // Getters
    public String getApplicationID() {
        return applicationID;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public Job getJob() {
        return job;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    // Setters
    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    @Override
    public String toString() {
        return "Application{" +
                "applicationID='" + applicationID + '\'' +
                ", applicationDate=" + applicationDate +
                ", status='" + status + '\'' +
                ", job=" + job +
                ", applicant=" + applicant +
                '}' + '\n';
    }
}
