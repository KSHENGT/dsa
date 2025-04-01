package dao;

import adt.DoublyLinkedList;
import adt.ListInterface;
import entity.Interview;
import entity.Applicant;
import entity.Job;

import java.util.Date;

public class InterviewInitializer {

    public static ListInterface<Interview> interviewDatabase = new DoublyLinkedList<>();

    public InterviewInitializer() {
        HardCode();
    }

    public ListInterface<Interview> initializeInterviews() {
        HardCode();
        return interviewDatabase;
    }

    public void HardCode() {
        // Hardcoded Interview data
        interviewDatabase.add(new Interview(
                "I001",
                new Job(101, "Software Engineer", "Develop applications.", "Full-Time", 5000.00, "Tech Corp", "Kuala Lumpur", 3),
                new Applicant("Alice", 30, "alice@example.com", "Java, Python", "Kuala Lumpur", "Software Engineer", 2, 2000, new Date()), // Applicant object (replace with actual Applicant if needed)
                new Date(),
                "Online",
                "Zoom Link",
                "Scheduled",
                "Initial screening"
        ));

        interviewDatabase.add(new Interview(
                "I002",
                new Job(102, "Data Analyst", "Analyze data trends.", "Contract", 4500.00, "Data Insights", "Penang", 2),
                new Applicant("Bob", 20, "bob@example.com", "C++, SQL", "Penang", "Data Analyst", 3, 2000, new Date()),
                new Date(),
                "In-Person",
                "Company Office",
                "Completed",
                "Technical interview"
        ));

        // Add more hardcoded interviews as needed
    }

    public ListInterface<Interview> getAllInterviews() {
        return interviewDatabase;
    }

    public Interview getInterviewById(String interviewId) {
        for (int i = 1; i <= interviewDatabase.getNumberOfEntries(); i++) {
            Interview interview = interviewDatabase.getEntry(i);
            if (interview.getInterviewID().equals(interviewId)) {
                return interview;
            }
        }
        return null; // Interview not found
    }

    public void addInterview(Interview interview) {
        interviewDatabase.add(interview);
    }

    public void updateInterview(Interview interview) {
        for (int i = 1; i <= interviewDatabase.getNumberOfEntries(); i++) {
            if (interviewDatabase.getEntry(i).getInterviewID().equals(interview.getInterviewID())) {
                interviewDatabase.replace(i, interview);
                return;
            }
        }
    }

    public void deleteInterview(String interviewId) {
        for (int i = 1; i <= interviewDatabase.getNumberOfEntries(); i++) {
            if (interviewDatabase.getEntry(i).getInterviewID().equals(interviewId)) {
                interviewDatabase.remove(i);
                return;
            }
        }
    }
}