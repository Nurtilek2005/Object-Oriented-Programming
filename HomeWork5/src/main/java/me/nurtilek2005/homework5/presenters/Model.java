package me.nurtilek2005.homework5.presenters;

import me.nurtilek2005.homework5.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {
    Collection<Table> loadTables();

    /**
     * Бронирование столика
     *
     * @param reservationDate Дата бронирования
     * @param tableNo         Номер столика
     * @param name            Имя клиента
     */
    int reservationTable(Date reservationDate, int tableNo, String name);

    /**
     * TODO: реализовать функционал изменения бронирования столика самостоятельно в рамках домашнего задания
     * Действие клиента (пользователь нажал на кнопку изменения бронирования столика)
     *
     * @param oldReservation  идентификатор бронирования (старый)
     * @param reservationDate дата бронирования
     * @param tableNo         номер столика
     * @param name            имя
     */
    int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);

    boolean isTableExists(int tableNo);

    Table getTable(int tableNo);

    Collection<Table> getTables();
}
