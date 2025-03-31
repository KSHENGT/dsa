package dao;

import adt.DoublyLinkedList;
import adt.ListInterface;
import entity.Job;

public class Initializer {

    public ListInterface<Job> initializeJobs() {
        ListInterface<Job> jobslist = new DoublyLinkedList<>();
        jobslist.add(new Job(101, "Software Engineer", "Develop applications.", "Full-Time", 5000.00, "Tech Corp", "Kuala Lumpur"));
        jobslist.add(new Job(102, "Data Analyst", "Analyze data trends.", "Contract", 4500.00, "Data Insights", "Penang"));
        jobslist.add(new Job(103, "Marketing Manager", "Lead marketing campaigns.", "Full-Time", 6000.00, "MarketPro", "Johor Bahru"));
        jobslist.add(new Job(104, "Graphic Designer", "Create visual content.", "Part-Time", 3000.00, "Creative Studio", "Selangor"));
        jobslist.add(new Job(105, "Network Engineer", "Manage IT infrastructure.", "Full-Time", 5500.00, "NetSecure", "Cyberjaya"));
        return jobslist;
    }

    public static void main(String[] args) {
        Initializer initializer = new Initializer();
        ListInterface<Job> jobslist = initializer.initializeJobs();
        System.out.println("\nJobs:\n" + jobslist);
    }
}
