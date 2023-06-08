package me.nurtilek2005.homework_3.task2;

public class Worker extends Employee {
    public Worker(String name, String surname, double salary) {
        this(name, surname, salary, 0);
    }

    public Worker(String name, String surname, double salary, int experience) {
        super(name, surname, salary, experience);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; Среднемесячная заработная плата (фиксированная месячная оплата): %.2f (руб.); Стажа - %d",
                surname, name, calculateSalary(), getExperience());
    }
}
