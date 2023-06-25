package me.nurtilek2005.homework7.observer;

import java.util.Random;

public class Student implements Observer {
    private String name;
    private double minSalary;

    public Student(String name) {
        this.name = name;
        Random random = new Random();
        minSalary = random.nextDouble(2000, 4000);
    }

    @Override
    public void receiveOffer(String companyName, Vacancy vacancy) {
        if (minSalary <= vacancy.getSalary()) {
            System.out.printf("Студент %s (%f) >>> Мне нужна эта работа! [%s - %f]\n",
                    name, minSalary, companyName, vacancy.getSalary());
            minSalary = vacancy.getSalary();
        } else {
            System.out.printf("Студент %s >>> Я найду работу получше (%f)! [%s - %f]\n",
                    name, minSalary, companyName, vacancy.getSalary());
        }
    }
}
