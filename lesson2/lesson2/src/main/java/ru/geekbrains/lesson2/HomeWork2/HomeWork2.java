package ru.geekbrains.lesson2.HomeWork2;


public class HomeWork2 {

}
class Cat {
private String name;
private int appetite;
private boolean fullness = false; // добавляем поле сытость
public Cat(String name, int appetite) {
this.name = name;
this.appetite = appetite;
}
public void eat(Plate plate) { // передаем тарелку в метод кота
if (plate.getFood() >= appetite) { // проверяем, достаточно ли еды в тарелке для кота
plate.setFood(plate.getFood() - appetite);
fullness = true; // если удалось покушать, меняем значение поля сытость
System.out.println(name + " поел");
} else {
System.out.println(name + " не поел");
}
}
public boolean isFull() {
return fullness;
}
public String getName() {
    return null;
}
}

class Plate {
private int food;
public Plate(int food) {
this.food = food;
}
public void info() {
System.out.println("plate: " + food);
}
public void setFood(int food) {
if (food >= 0) { // проверяем, чтобы в тарелке не было отрицательного количества еды
this.food = food;
} else {
System.out.println("Невозможно добавить отрицательное количество еды в тарелку");
}
}
public int getFood() {
return food;
}
public void addFood(int amount) {
setFood(food + amount); // добавляем указанное количество еды в тарелку
}
}

class MainClass {
    public static void main(String[] args) {
    Cat[] cats = {
    new Cat("Barsik", 5),
    new Cat("Murzik", 10),
    new Cat("Vasya", 3)
    };
    Plate plate = new Plate(20);
    plate.info();
    for (Cat cat : cats) {
    cat.eat(plate);
    }
    plate.addFood(10);
    plate.info();
    for (Cat cat : cats) {
    System.out.println(cat.getName() + " сытость: " + cat.isFull());
    }
    }
    }
