package ru.geekbrains.lesson3.task2;

public class Worker extends Employee {

    public Worker(String name, String surname, double salary, int age) {
        super(name, surname, salary, age);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; Среднемесячная заработная плата (фиксированная месячная оплата): %.2f (руб.): %.2f (лет)",
                surname, name, calculateSalary(), getAge());
    }

    @Override
    public int getAge() {
        return age;
    }
}
