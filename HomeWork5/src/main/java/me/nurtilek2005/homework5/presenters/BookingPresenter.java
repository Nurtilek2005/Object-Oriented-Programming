package me.nurtilek2005.homework5.presenters;

import me.nurtilek2005.homework5.models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model tableModel;
    private final View bookingView;

    public BookingPresenter(Model tableModel, View bookingView) {
        this.tableModel = tableModel;
        this.bookingView = bookingView;
        bookingView.setObserver(this);
    }

    private Collection<Table> loadTables() {
        return tableModel.loadTables();
    }

    public void showTables() {
        bookingView.showTables(loadTables());
    }

    public void printReservationTableResult(int reservationId) {
        bookingView.printReservationTableResult(reservationId);
    }

    public void printReservationTableError(String errorMessage) {
        bookingView.printReservationTableError(errorMessage);
    }

    public void printReservationTableChangeResult(int reservationId) {
        bookingView.printReservationTableChangeResult(reservationId);
    }

    public void printReservationTableChangeError(String errorMessage) {
        bookingView.printReservationTableChangeError(errorMessage);
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationId = tableModel.reservationTable(orderDate, tableNo, name);
            printReservationTableResult(reservationId);
        } catch (RuntimeException e) {
            printReservationTableError(e.getMessage());
        }

    }

    /**
     * TODO: реализовать функционал изменения бронирования столика самостоятельно в рамках домашнего задания
     * Действие клиента (пользователь нажал на кнопку изменения бронирования столика)
     *
     * @param oldReservation  идентификатор бронирования (старый)
     * @param reservationDate дата бронирования
     * @param tableNo         номер столика
     * @param name            имя
     */
    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        try {
            int reservationId = tableModel.changeReservationTable(oldReservation, reservationDate, tableNo, name);
            printReservationTableChangeResult(reservationId);
        } catch (RuntimeException e) {
            printReservationTableChangeError(e.getMessage());
        }

    }
}
