package me.nurtilek2005.homework7.observer;

public class Vacancy {
    private final String name;
    private final double salary;

    public Vacancy(String name) {
        this(name, 1000);
    }

    public Vacancy(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
