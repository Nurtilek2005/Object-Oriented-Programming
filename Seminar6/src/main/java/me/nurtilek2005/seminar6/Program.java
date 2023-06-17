package me.nurtilek2005.seminar6;

import me.nurtilek2005.seminar6.srp2.Order;

public class Program {

    /**
     * TODO: Задача 1. Домашняя работа. Оптимизировать работу класса Order в  рамках принципа SRP.
     * @param args
     */
    public static void main(String[] args) {
        Order order = new Order();
        order.inputFromConsole();
        order.saveToJson();
    }

}
