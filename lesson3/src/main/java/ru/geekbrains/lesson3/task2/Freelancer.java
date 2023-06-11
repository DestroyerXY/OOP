// package ru.geekbrains.lesson3.task2;

// // 20 * 8

// /**
//  * TODO: Спроектировать класс Freelancer самостоятельно в рамках домашнего задания
//  */
// public class Freelancer extends Employee{

//     public Freelancer(String name, String surname, double salary) {
//         super(name, surname, salary);
//         //TODO Auto-generated constructor stub
//     }
   
//     @Override
//     public double calculateSalary() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'calculateSalary'");
//     }
// }
//  __________

package ru.geekbrains.lesson3.task2;

public class Freelancer extends Employee{
    public Freelancer(String name, String surname, double salary, int age) {
        super(name, surname, salary, age);
    }
    
    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; Среднемесячная заработная плата (фиксированная месячная оплата): %.2f (руб.): %.2f (лет)",
                surname, name, calculateSalary(), getAge());
    }
}
    // Реализован класс Freelancer, который наследует от класса Employee.
// В конструкторе присутствуют параметры name, surname, salary.
// Реализован метод calculateSalary(), который возвращает зарплату Фрилансера.