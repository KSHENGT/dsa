/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;

public class Interview implements Serializable {

    private String interviewID;
    private Job job;
    private Applicant applicant;
    private Date interviewDate;
    private String interviewType; // e.g., "Online", "In-Person", "Phone"
    private String interviewLocation; // e.g., "Zoom Link", "Company Office", "Phone Number"
    private String interviewStatus; // e.g., "Scheduled", "Completed", "Cancelled"
    private String interviewFeedback; // Feedback or notes after the interview

    public Interview(String interviewID,Job job, Applicant applicant, Date interviewDate, String interviewType, String interviewLocation, String interviewStatus, String interviewFeedback) {
        this.interviewID = interviewID;
        this.job = job;
        this.applicant = applicant;
        this.interviewDate = interviewDate;
        this.interviewType = interviewType;
        this.interviewLocation = interviewLocation;
        this.interviewStatus = interviewStatus;
        this.interviewFeedback = interviewFeedback;
    }

    public String getInterviewID(){
        return interviewID;
    }
    
    public void setInterviewID(String interviewID) {
        this.interviewID = interviewID;
    }
    
    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType;
    }

    public String getInterviewLocation() {
        return interviewLocation;
    }

    public void setInterviewLocation(String interviewLocation) {
        this.interviewLocation = interviewLocation;
    }

    public String getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(String interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public String getInterviewFeedback() {
        return interviewFeedback;
    }

    public void setInterviewFeedback(String interviewFeedback) {
        this.interviewFeedback = interviewFeedback;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "interviewID=" + interviewID +
                "job=" + job +
                ", applicant=" + applicant +
                ", interviewDate=" + interviewDate +
                ", interviewType='" + interviewType + '\'' +
                ", interviewLocation='" + interviewLocation + '\'' +
                ", interviewStatus='" + interviewStatus + '\'' +
                ", interviewFeedback='" + interviewFeedback + '\'' +
                '}';
    }
}
