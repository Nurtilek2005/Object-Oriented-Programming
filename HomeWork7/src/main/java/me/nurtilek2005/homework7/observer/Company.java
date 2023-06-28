package me.nurtilek2005.homework7.observer;

import java.util.Random;

public class Company {
    private String name;
    private double maxSalary;
    private Publisher jobAgency;

    public Company(String name, double maxSalary, Publisher jobAgency) {
        this.name = name;
        this.maxSalary = maxSalary;
        this.jobAgency = jobAgency;
    }

    public void needEmployee() {
        Random random = new Random();
        double salary = random.nextDouble(3000, maxSalary);
        Vacancy vacancy = new Vacancy(this, "Job", salary);
        jobAgency.sendOffer(vacancy);
    }

    public String getName() {
        return this.name;
    }

    public double getMaxSalary() {
        return this.maxSalary;
    }

    public Publisher getJobAgency() {
        return this.jobAgency;
    }
}
