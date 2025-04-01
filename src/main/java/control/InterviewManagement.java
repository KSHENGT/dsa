package control;

import adt.DoublyLinkedList;
import adt.ListInterface;
import boundary.InterviewUI; // Changed to InterviewUI
import dao.InterviewInitializer; // Changed to InterviewInitializer
import entity.Applicant;
import entity.Interview;
import entity.Job;
import utility.Screen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InterviewManagement {

    private InterviewUI interviewUI = new InterviewUI(); // Changed to InterviewUI
    private InterviewInitializer interviewDao = new InterviewInitializer(); // Changed to InterviewInitializer
    private ListInterface<Interview> interview = new DoublyLinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InterviewManagement interviewManagement = new InterviewManagement();
        interviewManagement.interviewMenu();
    }

    public void interviewMenu() {
        int choice;
        do {
            choice = interviewUI.getMenuChoice();
            switch (choice) {
                case 1:
                    scheduleInterview();
                    break;
                case 2:
                    filterSuccessfulApplicants();
                    break;
                case 3:
                    generateInterviewScheduleReport();
                    break;
                case 4:
                    Screen.clearScreen();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice!= 0);
    }

    public void scheduleInterview() {
        Screen.clearScreen();
        interviewUI.displayScheduleInterviewMessage("Schedule Interview");

        String jobId = interviewUI.getJobIdInput();
        String applicantId = interviewUI.getApplicantIdInput();
        String dateString = interviewUI.getDateInput();
        String interviewType = interviewUI.getInterviewTypeInput();
        String interviewLocation = interviewUI.getInterviewLocationInput();

        Job job = getJobById(jobId);
        Applicant applicant = getApplicantById(applicantId);

        if (job == null || applicant == null) {
            interviewUI.displayScheduleInterviewMessage("Job or Applicant not found.");
            Screen.pauseScreen();
            return;
        }

        try {
            Date interviewDate = parseDate(dateString);
            String interviewID = generateUniqueID(); // Generate unique ID
            Interview interview = new Interview(interviewID, job, applicant, interviewDate, interviewType, interviewLocation, "Scheduled", "");
            interviewDao.interviewDatabase.add(interview); // Changed to interviewDao
            interviewUI.displayScheduleInterviewMessage("Interview scheduled successfully.");
        } catch (IllegalArgumentException e) {
            interviewUI.displayScheduleInterviewMessage("Invalid date format. Please use HH:mm.");
        }
        Screen.pauseScreen();
    }

    public void filterSuccessfulApplicants() {
        Screen.clearScreen();
        interviewUI.displayScheduleInterviewMessage("Filter Successful Applicants");

        String criteria = interviewUI.getFilterCriteriaInput();

        List<Applicant> rankedApplicants = filterAndRankSuccessfulApplicants(criteria);

        if (rankedApplicants.isEmpty()) {
            interviewUI.displayFilteredApplicants("No successful applicants found.");
        } else {
            StringBuilder applicantList = new StringBuilder();
            for (Applicant applicant : rankedApplicants) {
                applicantList.append(applicant.toString()).append("\n"); // Assuming Applicant has a proper toString()
            }
            interviewUI.displayFilteredApplicants(applicantList.toString());
        }

        Screen.pauseScreen();
    }

    public void generateInterviewScheduleReport() {
        Screen.clearScreen();
        interviewUI.displayScheduleInterviewMessage("Generate Interview Schedule Report");

        // Assuming you have a way to generate the report
        String report = generateReport();

        interviewUI.displayInterviewReport(report);
        Screen.pauseScreen();
    }

    // Helper methods (replace with your actual implementation)
    private Job getJobById(String jobId) {
        // Implement logic to retrieve Job object by ID
        // For demonstration purposes, return null
        return null;
    }

    private Applicant getApplicantById(String applicantId) {
        // Implement logic to retrieve Applicant object by ID
        // For demonstration purposes, return null
        return null;
    }

    private String generateReport() {
        // Implement logic to generate the interview schedule report
        // For demonstration purposes, return an empty string
        return "Interview Schedule Report";
    }

    private Date parseDate(String dateString) {
        // Implement logic to parse the date string
        // For demonstration purposes, throw an exception
        return new Date();
    }

    private String generateUniqueID() {
        return java.util.UUID.randomUUID().toString();
    }

    public List<Applicant> filterAndRankSuccessfulApplicants(String filterCriteria) {
        ListInterface<Interview> allInterviews = interviewDao.getAllInterviews(); // Changed to interviewDao
        List<Applicant> successfulApplicants = new ArrayList<>();

        for (int i = 1; i <= allInterviews.getNumberOfEntries(); i++) {
        Interview interview = allInterviews.getEntry(i);
        if (isSuccessfulApplicant(interview, filterCriteria)) {
            successfulApplicants.add(interview.getApplicant());
        }
    }

        Collections.sort(successfulApplicants, new Comparator<Applicant>() {
            @Override
            public int compare(Applicant a1, Applicant a2) {
                return calculateApplicantScore(a2) - calculateApplicantScore(a1); // Descending order
            }
        });

        return successfulApplicants;
    }

    private boolean isSuccessfulApplicant(Interview interview, String filterCriteria) {
        // Implement logic to determine if the applicant is successful
        // based on interview status, feedback, skills, etc.
        // Also use the filter criteria to filter the results.
        return interview.getInterviewStatus().equals("Completed"); // Example
    }

    private int calculateApplicantScore(Applicant applicant) {
        // Implement logic to calculate the applicant's score
        // based on skills, experience, etc.
        return 10; // Example
    }
}