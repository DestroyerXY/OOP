// package ru.geekbrains.lesson3;

// import ru.geekbrains.lesson3.task2.Freelancer;
// import ru.geekbrains.lesson3.task2.Worker;

// public class Program {

//     public int a;

//     public static void main(String[] args) {
//         Freelancer freelancer1 = new Cat("Барсик", 100);
//         cat1.run(50);
//         System.out.println(cat1.getId());

//         Freelancer freelancer2 = new Cat("Персик", 200);
//         cat2.run(150);
//         System.out.println(cat2.getId());

//         Worker worker1 = new Cat("Бублик", 300);
//         cat3.run(200);
//         System.out.println(cat3.getId());

//         Worker worker2 = new Dog("Шарик", 200, 1000);

//         Worker worker3 = new Dog("Тузик", 210, 900);

//         System.out.printf("Было создано %d котов.\n", Cat.getCounter());
//         System.out.printf("Было создано %d собак.\n", Dog.getCounter());
//         System.out.printf("Было создано %d животных.\n", Animal.getCounter());

//     }

//}

package ru.geekbrains.lesson3;

import java.util.Arrays;

import ru.geekbrains.lesson3.task2.Employee;
import ru.geekbrains.lesson3.task2.Freelancer;
import ru.geekbrains.lesson3.task2.Worker;

public class Program {
    public static void main(String[] args) {
        Employee[] employees = {
                new Worker("Ivan", "Ivanov", 50000, 50),
                new Worker("Oleg", "Petrov", 60000,35),
                new Freelancer("Maria", "Sidorova", 30000, 27),
                new Freelancer("Alexey", "Gusev", 35000, 30),
        };
    
        Arrays.sort(employees);
    
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " " + employee.getSurname() +
                    ", возраст: " + employee.getAge() +
                    ", заработная плата: " + employee.calculateSalary());
        }
    }
    }
