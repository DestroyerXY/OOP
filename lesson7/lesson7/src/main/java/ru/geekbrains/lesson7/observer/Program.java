package ru.geekbrains.lesson7.observer;

public class Program {

    /**
     * TODO: 1. Доработать приложение, поработать с шаблоном проектирования Observer,
     *  добавить свой собственный тип/типы соискателя.
     *  2**. Добавить новую сущность "Вакансия", компания должна рассылать вакансии.
     *  3**. Предусмотреть тип вакансии (enum)
     * @param args
     */
    public static void main(String[] args) {

        JobAgency jobAgency = new JobAgency();
        Company geekBrains = new Company("GeekBrains", 70000, jobAgency, "Уборщик");
        Company google = new Company("Google", 100000, jobAgency, "СЕО");
        Company yandex = new Company("Yandex", 120000, jobAgency, "Программист");

        Master ivanov = new Master("Ivanov");
        Master petrov = new Master("Petrov");
        Student sidorov = new Student("Sidorov");

        Vacancy janitor = new Vacancy("Уборщик", "Уборка помещений" );
        Vacancy CEO = new Vacancy("Управляющий директор", "Управление компанией");
        Vacancy programmer = new Vacancy("Программист", "Создание программ");


        jobAgency.registerObserver(ivanov);
        jobAgency.registerObserver(petrov);
        jobAgency.registerObserver(sidorov);

        jobAgency.registerVacancy(janitor);
        jobAgency.registerVacancy(CEO);
        jobAgency.registerVacancy(programmer);

        for (int i = 0; i < 3; i++){
            geekBrains.needEmployee();
            google.needEmployee();
            yandex.needEmployee();
        }
    }

}
