package ru.geekbrains.lesson7.observer;

public interface Publisher {

    /**
     * Регистрация нового наблюдателя
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * Убрать наблюдателя из списка
     * @param observer
     */
    void removeObserver(Observer observer);

     /**
     * Регистрация нового наблюдателя
     * @param vacancy
     */
    void registerVacancy(Vacancy vacancy);


    /**
     * Компания отправляет новую вакансию
     * @param title
     * @param companyName
     * @param salary
     * @param vacancy
     */
    void sendOffer(String title, String companyName, double salary, String vacancy);


}
