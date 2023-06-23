package ru.geekbrains.lesson7.observer;

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
    public void sendOffer(String title, String companyName, double salary, String vacancy) {
        for (Observer observer: observers) {
            observer.receiveOffer(companyName, salary, vacancy);
        }
    }

    @Override
    public void registerVacancy(Vacancy vacancy) {
        vacancy.add(vacancy);
    }
}
