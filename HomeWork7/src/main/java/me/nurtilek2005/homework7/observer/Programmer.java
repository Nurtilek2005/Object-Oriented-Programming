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
    public void receiveOffer(String companyName, Vacancy vacancy) {
        if (minSalary <= vacancy.getSalary()) {
            System.out.printf("Программист %s (%f) >>> Мне нужна эта работа! [%s - %f]\n",
                    name, minSalary, companyName, vacancy.getSalary());
            minSalary = vacancy.getSalary();
        } else {
            System.out.printf("Программист %s    >>> Я найду работу получше (%f)! [%s - %f]\n",
                    name, minSalary, companyName, vacancy.getSalary());
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    public ProgrammerRank getRank() {
        return this.rank;
    }
}
