package me.nurtilek2005.homework7.observer;

import java.util.Random;

public class Master implements Observer {
    private String name;
    private double minSalary;

    public Master(String name) {
        this.name = name;
        Random random = new Random();
        minSalary = random.nextDouble(60000, 80000);
    }

    @Override
    public void receiveOffer(String companyName, Vacancy vacancy) {
        if (minSalary <= vacancy.getSalary()) {
            System.out.printf("Рабочий %s (%f) >>> Мне нужна эта работа! [%s - %f]\n",
                    name, minSalary, companyName, vacancy.getSalary());
            minSalary = vacancy.getSalary();
        } else {
            System.out.printf("Рабочий %s >>> Я найду работу получше (%f)! [%s - %f]\n",
                    name, minSalary, companyName, vacancy.getSalary());
        }
    }

    @Override
    public String getName() {
        return this.name;
    }
}
