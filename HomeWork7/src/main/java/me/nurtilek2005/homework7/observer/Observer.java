package me.nurtilek2005.homework7.observer;

public interface Observer {
    String getName();

    void receiveOffer(String companyName, Vacancy vacancy);
}
