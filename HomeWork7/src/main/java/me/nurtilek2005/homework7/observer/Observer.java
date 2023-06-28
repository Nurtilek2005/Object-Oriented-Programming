package me.nurtilek2005.homework7.observer;

public interface Observer {
    void receiveOffer(Vacancy vacancy);

    String getName();

    double getMinSalary();
}
