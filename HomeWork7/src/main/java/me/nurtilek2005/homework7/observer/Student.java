package me.nurtilek2005.homework7.observer;

import java.util.Random;

public class Student implements Observer {
    private String name;
    private double minSalary;
    private Company company;

    public Student(String name) {
        this.name = name;
        Random random = new Random();
        minSalary = random.nextDouble(2000, 4000);
    }

    @Override
    public void receiveOffer(Vacancy vacancy) {
        Company company = vacancy.getCompany();
        StringBuilder message = new StringBuilder();
        message.append("Студент %s ".formatted(name));
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
}
