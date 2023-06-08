package me.nurtilek2005.homework_3.task2;

/**
 * TODO: Спроектировать класс Freelancer самостоятельно в рамках домашнего задания
 */
public class Freelancer extends Employee {
    private Rank rank;

    public Freelancer(String name, String surname, double salary) {
        this(name, surname, salary, 0, Rank.Junior);
    }

    public Freelancer(String name, String surname, double salary, int experience) {
        this(name, surname, salary, experience, Rank.Junior);
    }

    public Freelancer(String name, String surname, double salary, int experience, Rank rank) {
        super(name, surname, salary, experience);
        this.rank = rank;
    }

    public Rank getRank() {
        return this.rank;
    }

    public void promote() {
        switch (rank) {
            case Junior -> this.rank = Rank.Middle;
            case Middle -> this.rank = Rank.Senior;
            case Senior -> this.rank = Rank.TeamLead;
        }
    }

    @Override
    public double calculateSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; %s; Среднемесячная заработная плата (фиксированная месячная оплата): %.2f (руб.); Стажа - %d",
                surname, name, rank, calculateSalary(), getExperience());
    }
}
