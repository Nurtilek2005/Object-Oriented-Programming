package me.nurtilek2005.homework7.observer;

import java.util.ArrayList;
import java.util.List;

public class JobAgency implements Publisher {
    List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void sendOffer(Vacancy vacancy) {
        for (Observer observer : observers) {
            observer.receiveOffer(vacancy);
        }
    }
}
