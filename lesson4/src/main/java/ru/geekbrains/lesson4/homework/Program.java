package ru.geekbrains.lesson4.homework;

public class Program {

    /**
     Домашняя работа, задача:
     ========================

     a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
     b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
     поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
     c. Для хранения фруктов внутри коробки можно использовать ArrayList;
     d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
     вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
     e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
     подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
     Можно сравнивать коробки с яблоками и апельсинами;
     f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
     Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
     Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
     g. Не забываем про метод добавления фрукта в коробку.
     */
    public static void main(String[] args) {
        Box box1 = new Box();
        //кладем в нее 3 яблока
        box1.add(new Apple());
        box1.add(new Apple());
        box1.add(new Apple());
        // проверяем сколько весит коробка
        System.out.println("Вес коробки №1: " + box1.getWeight());
        // Создаем другую коробку
        Box box2 = new Box();
        //кладем в нее 3 яблока
        box2.add(new Orange());
        box2.add(new Orange());
        box2.add(new Orange());
        // проверяем сколько весит коробка
        System.out.println("Вес коробки №2: " + box2.getWeight());
        // сравним две коробки
        System.out.println("Результат работы метода compare() класса Box, параметры (пример: box1.compare(box2))");
        System.out.println("Массы коробок " + (box1.compare(box2) ? "одинаковы" : "различны") + ".");
        // Проверка, а какие фрукты хранятся в каждой коробке
        // прямой способ получение ссылки на ArrayList и потом определение типа первого элемента
        // (аналог) открыли коробку и посмотрели что сверху
        System.out.println("В коробке Box1 хранятся " + box1.getProduct().get(0).getClass().getSimpleName());
        // создаем дополнительно еще одну коробку с яблоками
        Box box3 = new Box();
        //кладем в нее 3 яблока
        box3.add(new Apple());
        box3.add(new Apple());
        box3.add(new Apple());
        box3.add(new Apple());
        box3.add(new Apple());
        // проверяем сколько весит коробка
        System.out.println("Вес коробки №3: " + box3.getWeight());
        System.out.println("В коробке Box3 хранятся " + box3.getProduct().get(0).getClass().getSimpleName());
        // пересыпаем яблоки из коробки 1 в коробку 3
        box1.shiftSingleItem(box3);
        // проверяем сколько весит коробка 3
        System.out.println("Вес коробки №3: " + box3.getWeight());
        System.out.println("Вес коробки №1: " + box1.getWeight());
        // а теперь попробуем апельсины выгрузить в яблоки
        try {
            box2.shiftSingleItem(box3);
        } catch (BoxCustomException e) {
            System.out.println(e);
        }
        System.out.println("Вес коробки №3: " + box3.getWeight());
        System.out.println("Вес коробки №2: " + box2.getWeight());
        // попытаемся положить несколько апельсинов в коробку с яблоками
        try {
            box3.add(new Orange());
            box3.add(new Orange());
            box3.add(new Orange());
        } catch (BoxCustomException e) {
            System.out.println(e);
        }
        System.out.println("Вес коробки №3: " + box3.getWeight());

        // все работает
    }
}

//АЛЬТЕРНАТИВНЫЙ КОД
//public class Program 
// public static void main(String[] args) {
//     Box box1 = new Box();
//     Box box2 = new Box();
//     Apple apple1 = new Apple((float) 0.2);
//     Apple apple2 = new Apple((float) 0.1);
//     Orange orange1 = new Orange((float) 0.3);
//     Orange orange2 = new Orange((float) 0.2);

//     box1.add(apple1);
//     box1.add(apple2);
//     box1.add(orange1);

//     box2.add(orange2);
//     box2.add(apple2);
//     box2.add(orange1);

//     System.out.println("Вес коробки 1: " + box1.getWeight());
//     System.out.println("Вес коробки 2: " + box2.getWeight());

//     System.out.println("Коробки равны по весу: " + box1.compare(box2));

//     box1.shiftSingleItem(box2);

//     System.out.println("Вес коробки 1 после пересыпания: " + box1.getWeight());
//     System.out.println("Вес коробки 2 после пересыпания: " + box2.getWeight());
// }
// }