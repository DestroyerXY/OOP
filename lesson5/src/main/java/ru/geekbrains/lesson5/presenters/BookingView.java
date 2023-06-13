package ru.geekbrains.lesson5.presenters;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import ru.geekbrains.lesson5.models.Reservation;

public interface BookingView {
        void showTables();
        void reservationTable(Date date, int tableNumber, String clientName);
        void changeReservationTable(int reservationIndex, Date newDate, int newTableNumber, String newClientName);
    }
    public class BookingView implements ru.geekbrains.lesson5.views.BookingView {

        private List<Reservation> reservations = new ArrayList<>();
    
        @Override
        public void showTables() {
            // Отображение состояния таблицы
        }
    
        @Override
        public void reservationTable(Date date, int tableNumber, String clientName) {
            // Зарезервировать столик
            reservations.add(new Reservation(date, tableNumber, clientName));
            showTables();
        }
    
        @Override
        public void changeReservationTable(int reservationIndex, Date newDate, int newTableNumber, String newClientName) {
            // Изменить резервацию для указанного индекса
            Reservation reservation = reservations.get(reservationIndex);
            reservation.setDate(newDate);
            reservation.setTableNumber(newTableNumber);
            reservation.setClientName(newClientName);
            showTables();
        }
    }
    
