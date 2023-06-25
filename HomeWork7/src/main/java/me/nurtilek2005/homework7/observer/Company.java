package me.nurtilek2005.homework7.observer;

import java.util.Random;

public class Company {
    private String companyName;
    private double maxSalary;
    private Publisher jobAgency;

    public Company(String companyName, double maxSalary, Publisher jobAgency) {
        this.companyName = companyName;
        this.maxSalary = maxSalary;
        this.jobAgency = jobAgency;
    }

    public void needEmployee() {
        Random random = new Random();
        double salary = random.nextDouble(3000, maxSalary);
        Vacancy vacancy = new Vacancy("Job", salary);
        jobAgency.sendOffer(companyName, vacancy);
    }
}
