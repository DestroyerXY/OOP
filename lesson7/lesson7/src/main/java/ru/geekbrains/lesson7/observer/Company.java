package ru.geekbrains.lesson7.observer;

import java.util.Random;

public class Company {

    private static  Random random = new Random();
    private String companyName;
    private  double maxSalary;
    private String vacancy;

    private Publisher jobAgency;


    public Company(String companyName, double maxSalary, Publisher jobAgency, String vacancy) {
        this.companyName = companyName;
        this.maxSalary = maxSalary;
        this.jobAgency = jobAgency;
        this.vacancy = vacancy;
    }

    public void needEmployee(){
        double salary = random.nextDouble(3000, maxSalary);
        jobAgency.sendOffer(companyName, companyName, salary, vacancy);
    }



}
