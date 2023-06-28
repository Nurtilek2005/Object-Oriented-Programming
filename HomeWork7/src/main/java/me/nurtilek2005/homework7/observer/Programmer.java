package me.nurtilek2005.homework7.observer;

import java.util.Random;

public class Programmer implements Observer {
    private String name;
    private double minSalary;
    private ProgrammerRank rank;

    public Programmer(String name) {
        this(name, ProgrammerRank.JUNIOR);
    }

    public Programmer(String name, ProgrammerRank rank) {
        Random random = new Random();
        switch (rank) {
            case JUNIOR -> minSalary = random.nextDouble(20000, 50000);
            case MIDDLE -> minSalary = random.nextDouble(70000, 100000);
            case SENIOR -> minSalary = random.nextDouble(12000, 200000);
            case TEAM_LEAD -> minSalary = random.nextDouble(200000, 300000);
        }
        this.name = name;
    }

    @Override
    public void receiveOffer(Vacancy vacancy) {
        Company company = vacancy.getCompany();
        StringBuilder message = new StringBuilder();
        message.append("Программист %s ".formatted(name));
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
