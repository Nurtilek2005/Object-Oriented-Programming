package me.nurtilek2005.homework5;

import me.nurtilek2005.homework5.models.Table;
import me.nurtilek2005.homework5.models.TableModel;
import me.nurtilek2005.homework5.presenters.BookingPresenter;
import me.nurtilek2005.homework5.presenters.Model;
import me.nurtilek2005.homework5.views.BookingView;

import java.util.Date;

public class Program {

    /**
     * TODO: Домашняя работа: Метод changeReservationTable ДОЛЖЕН ЗАРАБОТАТЬ!
     *
     * @param args
     */
    public static void main(String[] args) {
        Model tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableModel, bookingView);
        bookingPresenter.showTables();

        // Клиент нажимает на кнопку "Зарезервировать", возбуждается событие,
        // вызывается метод reservationTable()

        String reservationOwner1 = "Станислав";
        Date reservationDate1 = new Date();
        int reservationTableNo1 = 102;
        bookingView.reservationTable(reservationDate1, reservationTableNo1, reservationOwner1);

        String reservationOwner2 = "Станислав";
        Date reservationDate2 = new Date();
        int reservationTableNo2 = 102;
        bookingView.reservationTable(reservationDate2, reservationTableNo2, reservationOwner2);

        String reservationOwner3 = "Влад";
        Date reservationDate3 = new Date();
        int reservationTableNo3 = 103;
        bookingView.reservationTable(reservationDate3, reservationTableNo3, reservationOwner3);

        Table table1 = tableModel.getTable(reservationTableNo3);
        System.out.println(table1.getReservations());
        bookingView.changeReservationTable(9003, new Date(), 104, "Даниил");
        Table table2 = tableModel.getTable(reservationTableNo3);
        System.out.println(table2.getReservations());
        Table table3 = tableModel.getTable(104);
        System.out.println(table3.getReservations());
    }
}
