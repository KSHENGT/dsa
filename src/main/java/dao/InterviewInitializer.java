package dao;

import adt.DoublyLinkedList;
import adt.ListInterface;
import entity.Interview;
import entity.Applicant;
import entity.Job;


import java.util.Date;

public class InterviewInitializer {
    JobInitializer jobInitializer = new JobInitializer();
    Initializer applicantInitializer = new Initializer();  //changed
    
    ListInterface<Job> jobList = jobInitializer.initializeJobs();
    ListInterface<Applicant> applicantList = applicantInitializer.applicants;

    public ListInterface<Interview> initializeInterviews() {
        ListInterface<Interview> interviewList = new DoublyLinkedList<>();
        interviewList.add(new Interview(
                "I001",
                jobList.getEntry(1),
                applicantList.getEntry(1),
                new Date(),
                "Online",
                "Zoom Link",
                "Scheduled",
                "Initial screening"
        ));
        
        interviewList.add(new Interview(
                "I002",
                jobList.getEntry(2),
                applicantList.getEntry(2),
                new Date(),
                "In-Person",
                "Company Office",
                "Completed",
                "Technical interview"
        ));
        return interviewList;
    }
}