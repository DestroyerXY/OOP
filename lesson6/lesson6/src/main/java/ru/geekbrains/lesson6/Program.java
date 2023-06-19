// package ru.geekbrains.lesson6;

// import ru.geekbrains.lesson6.srp2.Order;

// public class Program {

//     /**
//      * TODO: Задача 1. Домашняя работа. Оптимизировать работу класса Order в  рамках принципа SRP.
//      * @param args
//      */
//     public static void main(String[] args) {
//         Order order = new Order(null);
//         order.inputFromConsole();
//         order.saveToJson();
//     }

// }

package ru.geekbrains.lesson6;

import ru.geekbrains.lesson6.srp2.Order;
import ru.geekbrains.lesson6.srp2.OrderInputUtils;
import ru.geekbrains.lesson6.srp2.OrderJsonWriter;

public class Program {
    /**
 * TODO: Задача 1. Домашняя работа. Оптимизировать работу класса Order в рамках принципа SRP.
 * @param args
 */
public static void main(String[] args) {
    OrderInputUtils inputUtils = new OrderInputUtils();
    OrderJsonWriter jsonWriter = new OrderJsonWriter();
    Order order = new Order(inputUtils);
    order.inputFromConsole();
    jsonWriter.writeToJson(order, "order.json");
}
}
