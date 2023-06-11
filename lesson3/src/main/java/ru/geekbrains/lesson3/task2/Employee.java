// package ru.geekbrains.lesson3.task2;

// public abstract class Employee implements Comparable<Employee> {

//     protected String name;
//     protected String surname;
//     protected double salary; // Ставка заработной платы
//     protected int age;

//     public String getName() {
//         return name;
//     }

//     public String getSurname() {
//         return surname;
//     }

//     public double getSalary() {
//         return salary;
//     }

//     public int getAge(){
//         return age;
//     }

//     public Employee(String name, String surname, double salary, int age) {
//         this.name = name;
//         this.surname = surname;
//         this.salary = salary;
//         this.age = age;
//     }

//     /**
//      * Расчет среднемесячной заработной платы
//      * @return
//      */
//     public abstract double calculateSalary();

//     @Override
//     public int compareTo(Employee o) {
//         int res = name.compareTo(o.name);
//         if (res == 0){
//             return Double.compare(calculateSalary(), o.calculateSalary());
//         }
//         return res;
//     }
// }

package ru.geekbrains.lesson3.task2;
public abstract class Employee implements Comparable<Employee> {

    protected String name;
    protected String surname;
    protected double salary; // Ставка заработной платы
    protected int age;

    public String getName() {
        return name;
}
    public String getSurname() {
        return surname;
    }
    public double getSalary() {
        return salary;
}
    public int getAge(){
        return age;
}
    public Employee(String name, String surname, double salary, int age) {
    this.name = name;
    this.surname = surname;
    this.salary = salary;
    this.age = age;
}
/**
* Расчет среднемесячной заработной платы
* @return
*/
public abstract double calculateSalary();
    @Override
public int compareTo(Employee o) {
    int res = Double.compare(getAge(), o.getAge());
        if (res == 0){
            res = name.compareTo(o.name);
}
return res;
}
}