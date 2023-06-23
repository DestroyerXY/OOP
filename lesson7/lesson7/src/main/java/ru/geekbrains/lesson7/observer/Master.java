package ru.geekbrains.lesson7.observer;

import java.util.Random;

public class Master implements Observer {

    private static Random random = new Random();

    private String name;

    private double minSalary;

    public Master(String name) {
        this.name = name;
        minSalary = random.nextDouble(60000, 80000);
    }

    @Override
    public void receiveOffer(String companyName, double salary, String vacancy) {
        if (minSalary <= salary){
            System.out.printf("Рабочий %s (%f) >>> Мне нужна эта работа! [%s - %f]\n",
                    name, minSalary, companyName, salary, vacancy);
            minSalary = salary;
        }
        else {
            System.out.printf("Рабочий %s >>> Я найду работу получше (%f)! [%s - %f]\n",
                    name, minSalary, companyName, salary, vacancy);
        }
    }
}
