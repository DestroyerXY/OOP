// package ru.geekbrains.lesson3.task2;

// import java.lang.reflect.Array;
// import java.util.Arrays;
// import java.util.Random;

// public class Program {

//     static Random random = new Random();

//     /**
//      * TODO: Переработать метод generateEmployee в рамках домашнего задания,
//      *  метод должен генерировать рабочих (Employee) разных типов.
//      * @return
//      */
//     static Worker generateEmployee(){
//         String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
//         String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

//         int salary = random.nextInt(20000, 80000);
//         return new Worker(names[random.nextInt(2)], surnames[random.nextInt(surnames.length)], salary);
//     }


//     /**
//      * TODO: Придумать новые состояния для наших сотрудников
//      *   Придумать несколько Comparator'ов для сортировки сотрудников
//      *   по фамилии + имени или по возрасту + уровню зп.
//      * @param args
//      */
//     public static void main(String[] args) {

//         Employee[] employees = new Employee[10];
//         for (int i = 0; i < employees.length; i++)
//         {
//             employees[i] = generateEmployee();
//         }

//         Arrays.sort(employees);

//         for (Employee employee: employees) {
//             System.out.println(employee);
//         }



//     }

// }
//__________

package ru.geekbrains.lesson3.task2;

import java.util.Arrays;
import java.util.Random;


public class Program {
    static Random random = new Random();

/**
 * Генерирует случайного рабочего разных типов
 *
 * @return
 */
static Employee generateEmployee() {
    String[] names = new String[]{"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман"};
    String[] surnames = new String[]{"Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов"};

    int choice = random.nextInt(3);
    switch (choice) {
        case 0:
            return new Worker(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)], random.nextInt(20000, 80000), choice);
        case 1:
            return new Freelancer(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)], random.nextInt(20000, 80000), choice);
    }
    return null;
}

/**
 * Создает несколько сотрудников разных типов, сортирует их и выводит на экран
 * @param args
 */
public static void main(String[] args) {

    Employee[] employees = new Employee[10];
    for (int i = 0; i < employees.length; i++) {
        employees[i] = generateEmployee();
    }

    // Сортируем сотрудников по фамилии и имени
    Arrays.sort(employees);

    System.out.println("Сотрудники, отсортированные по фамилии и имени:");
    for (Employee employee : employees) {
        System.out.println(employee);
    }

    // Сортируем сотрудников по возрасту и зарплате
    Arrays.sort(employees);

    System.out.println("Сотрудники, отсортированные по возрасту и зарплате:");
    for (Employee employee : employees) {
        System.out.println(employee);
    }
}
}