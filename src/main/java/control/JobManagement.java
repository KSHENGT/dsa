package control;

import adt.*;
import boundary.JobUI;
import dao.JobInitializer;
import entity.Job;

/**
 * Job Management Control
 */
public class JobManagement {

    private ListInterface<Job> jobList = new DoublyLinkedList<>();
    private JobInitializer jobInitializer = new JobInitializer();
    private JobUI jobUI = new JobUI();

    public JobManagement() {
        jobList = jobInitializer.initializeJobs();  // Retrieve jobs from Initializer
    }

    public void runJobManagement() {
        int choice;
        do {
            choice = jobUI.getMenuChoice();
            switch (choice) {
                case 0:
                    System.out.println("Exiting Job Management...");
                    break;
                case 1:
                    jobUI.listAllJobs(getAllJobs());
                    break;
                case 2:
                    addNewJob();
                    break;
                case 3:
                    // updateJob();
                    break;
                case 4:
                    // deleteJob();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);
    }

    public void addNewJob() {
        Job newJob = jobUI.inputJobDetails();
        jobList.add(newJob);
        // jobInitializer.saveJobs(jobList);  // Save the updated list
    }

    //Wrong
//    public void updateJob() {
//        int jobId = jobUI.inputJobId();
//        for (int i = 1; i <= jobList.getNumberOfEntries(); i++) {
//            Job job = jobList.getEntry(i);
//            if (jobList.getJobId() == jobId) {
//                Job updatedJob = jobUI.inputJobDetails();
//                jobList.replace(i, updatedJob);
//                // jobInitializer.saveJobs(jobList);
//                return;
//            }
//        }
//        System.out.println("Job not found.");
//    }

//    public void deleteJob() {
//        int jobId = jobUI.inputJobId();
//        for (int i = 1; i <= jobList.getNumberOfEntries(); i++) {
//            if (jobList.getEntry(i).getJobId() == jobId) {
//                jobList.remove(i);
//                jobinitializer.saveJobs(jobList);
//                return;
//            }
//        }
//        System.out.println("Job not found.");
//    }

    public String getAllJobs() {
        StringBuilder outputStr = new StringBuilder();
        for (int i = 1; i <= jobList.getNumberOfEntries(); i++) {
            outputStr.append(jobList.getEntry(i)).append("\n");
        }
        return outputStr.toString();
    }

    public static void main(String[] args) {
        JobManagement jobManagement = new JobManagement();
        jobManagement.runJobManagement();
    }
}
