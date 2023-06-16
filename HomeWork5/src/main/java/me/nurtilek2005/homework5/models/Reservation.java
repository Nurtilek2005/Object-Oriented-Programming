package me.nurtilek2005.homework5.models;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Reservation {

    private static int counter = 9000;
    private final int id;

    private Date date;
    private String name;

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    {
        id = ++counter;
    }

    public Reservation(Date date, String name) {
        this.date = date;
        this.name = name;
    }

    @Override
    public String toString() {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
        String stringDate = DateFor.format(date);
        return "ID бронирования: %d; Дата бронирования: %s; Имя: %s".formatted(id, stringDate, name);
    }
}
