package me.nurtilek2005.homework7.observer;

import java.util.Arrays;
import java.util.Random;

public class Programmer implements Observer {
    private String name;
    private double minSalary;
    private ProgrammerRank rank;

    public Programmer(String name) {
        this(name, ProgrammerRank.JUNIOR);
    }

    public Programmer(String name, ProgrammerRank rank) {
        this.name = name;
        this.rank = rank;
        Random random = new Random();
        double randomSalary = random.nextDouble(25000, 50000);
        this.minSalary = randomSalary * (rank.ordinal() + 1);
    }

    @Override
    public void receiveOffer(Vacancy vacancy) {
        Company company = vacancy.getCompany();
        StringBuilder message = new StringBuilder();
        message.append("Программист %s ".formatted(name));
        message.append("| %s ".formatted(this.rank));
        message.append("(%f) >>> ".formatted(minSalary));
        if (minSalary <= vacancy.getSalary()) {
            minSalary = vacancy.getSalary();
            message.append("Мне нужна эта работа!").append(" ");
        } else {
            message.append("Я найду работу получше").append(" ");
        }
        message.append("[%s - ".formatted(company.getName()));
        message.append("%f]".formatted(vacancy.getSalary()));
        System.out.println(message);
    }

    public void promote() {
        StringBuilder message = new StringBuilder();
        ProgrammerRank[] ranks = ProgrammerRank.values();
        message.append("Программист %s ".formatted(name));
        message.append("| %s ".formatted(this.rank.name()));
        try {
            this.rank = ranks[this.rank.ordinal() + 1];
            message.append("повышен до %s ".formatted(this.rank.name()));
        } catch (IndexOutOfBoundsException exception) {
            message.append("уже самого высокого звания!");
        }
        Random random = new Random();
        this.minSalary += this.minSalary * (rank.ordinal() * 0.5);
        System.out.println(message);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getMinSalary() {
        return this.minSalary;
    }

    public ProgrammerRank getRank() {
        return this.rank;
    }
}
