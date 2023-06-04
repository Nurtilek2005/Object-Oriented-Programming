package me.nurtilek2005.homework_3.task2;

/**
 * TODO: Спроектировать класс Freelancer самостоятельно в рамках домашнего задания
 */
public class Freelancer extends Employee {
    private Rank rank;
    public enum Rank {
        Junior,
        Middle,
        Senior,
        TeamLead
    }

    public Freelancer(String name, String surname, double salary) {
        this(name, surname, salary, Rank.Junior);
    }

    public Freelancer(String name, String surname, double salary, Rank rank) {
        super(name, surname, salary);
        this.rank = rank;
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
        return 0;
    }

    public Rank getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        return String.format("%s %s; %s; Среднемесячная заработная плата (фиксированная месячная оплата): %.2f (руб.)",
                surname, name, rank, calculateSalary());
    }
}
