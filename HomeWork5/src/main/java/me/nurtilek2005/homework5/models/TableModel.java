package me.nurtilek2005.homework5.models;

import me.nurtilek2005.homework5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;

    /**
     * Получить все столики
     *
     * @return
     */
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());

        }

        return tables;
    }

    /**
     * Бронирование столика
     *
     * @param reservationDate Дата бронирования
     * @param tableNo         Номер столика
     * @param name            Имя клиента
     */
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика.");
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
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        if (!this.isTableExists(tableNo)) {
            throw new RuntimeException("Некорректный номер столика.");
        }
        for (Table table : tables) {
            Collection<Reservation> reservations = table.getReservations();
            for (Reservation reservation : reservations) {
                System.out.println(table);
                if (reservation.getId() == oldReservation) {
                    reservations.remove(reservation);
                    return reservationTable(reservationDate, tableNo, name);
                }
            }
        }
        throw new RuntimeException("Бронирование %d не найден. Менять нечего.".formatted(oldReservation));
    }

    @Override
    public boolean isTableExists(int tableNo) {
        return this.getTable(tableNo) != null;
    }

    @Override
    public Table getTable(int tableNo) {
        for (Table table : this.tables) {
            if (table.getNo() != tableNo) continue;
            return table;
        }
        return null;
    }

    @Override
    public Collection<Table> getTables() {
        return this.tables;
    }
}
