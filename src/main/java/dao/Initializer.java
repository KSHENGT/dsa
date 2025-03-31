package dao;

import adt.DoublyLinkedList;
import adt.ListInterface;
import entity.Job;

public class Initializer {

    // Static list to store job postings (accessible by DAO)
    private static ListInterface<Job> jobsList = new DoublyLinkedList<>();

    // Static block to initialize hardcoded job postings
    static {
        Job job1 = new Job(101, "Software Engineer", "Develop applications.", "Full-Time", 5000.00, "Tech Corp", "Kuala Lumpur", 3);
        job1.addRequiredSkill("Java");
        job1.addRequiredSkill("Spring Boot");
        job1.addRequiredSkill("SQL");

        Job job2 = new Job(102, "Data Analyst", "Analyze data trends.", "Contract", 4500.00, "Data Insights", "Penang", 2);
        job2.addRequiredSkill("Python");
        job2.addRequiredSkill("SQL");
        job2.addRequiredSkill("Power BI");

        Job job3 = new Job(103, "Marketing Manager", "Lead marketing campaigns.", "Full-Time", 6000.00, "MarketPro", "Johor Bahru", 5);
        job3.addRequiredSkill("SEO");
        job3.addRequiredSkill("Google Ads");
        job3.addRequiredSkill("Social Media");

        Job job4 = new Job(104, "Graphic Designer", "Create visual content.", "Part-Time", 3000.00, "Creative Studio", "Selangor", 2);
        job4.addRequiredSkill("Photoshop");
        job4.addRequiredSkill("Illustrator");
        job4.addRequiredSkill("Figma");

        Job job5 = new Job(105, "Network Engineer", "Manage IT infrastructure.", "Full-Time", 5500.00, "NetSecure", "Cyberjaya", 4);
        job5.addRequiredSkill("Networking");
        job5.addRequiredSkill("Cybersecurity");
        job5.addRequiredSkill("Linux");

        // Add jobs to the list
        jobsList.add(job1);
        jobsList.add(job2);
        jobsList.add(job3);
        jobsList.add(job4);
        jobsList.add(job5);
    }

    // Getter method for retrieving jobs
    public ListInterface<Job> retrieveJobs() {
        return jobsList;
    }

    // Method to save updated jobs list
    public void saveJobs(ListInterface<Job> updatedJobs) {
        jobsList = updatedJobs;  // Update the static list
    }
    
//    public static void main(String[] args) {
//    Initializer initializer = new Initializer();
//    ListInterface<Job> jobslist = initializer.initializeJobs();
//    System.out.println("\nJobs:\n" + jobslist);
//    }

}
