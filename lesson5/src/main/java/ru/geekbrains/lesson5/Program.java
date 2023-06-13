package ru.geekbrains.lesson5;

import ru.geekbrains.lesson5.models.TableModel;
import ru.geekbrains.lesson5.presenters.BookingPresenter;
import ru.geekbrains.lesson5.presenters.Model;
import ru.geekbrains.lesson5.presenters.View;
import ru.geekbrains.lesson5.views.BookingView;

import java.util.Date;

public class Program {

    public static void main(String[] args) {
        Model tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableModel, bookingView);
        bookingPresenter.showTables();
    
        // Клиент нажимает на кнопку "Зарезервировать", возбуждается событие,
        // вызывается метод reservationTable()
        bookingView.reservationTable(new Date(), 1103, "Станислав");
    
        bookingView.reservationTable(new Date(), 102, "Станислав");
    
        // Клиент нажимает на кнопку "Изменить резервацию", возбуждается событие,
        // вызывается метод changeReservationTable()
        bookingView.changeReservationTable(0, new Date(), 102, "Анна");
    
        // Обновляем представление, чтобы отобразить новое состояние таблицы
        bookingPresenter.showTables();
    }
    

}
