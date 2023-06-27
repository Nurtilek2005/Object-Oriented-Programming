package me.nurtilek2005.homework7.observer;

public class Vacancy {
    private final String name;
    private final Company company;
    private final double salary;

    public Vacancy(Company company, String name) {
        this(company, name, 1000);
    }

    public Vacancy(Company company, String name, double salary) {
        this.name = name;
        this.company = company;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public Company getCompany() {
        return this.company;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return "Вакансия: '%s', Зарплата: %f".formatted(name, salary);
    }
}
