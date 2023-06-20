package me.nurtilek2005.homework6;

import me.nurtilek2005.homework6.srp2.Order;
import me.nurtilek2005.homework6.srp2.manager.InputManager;
import me.nurtilek2005.homework6.srp2.manager.OrderManager;
import me.nurtilek2005.homework6.srp2.provider.IProvider;
import me.nurtilek2005.homework6.srp2.provider.JsonProvider;

public class Program {

    /**
     * TODO: Задача 1. Домашняя работа. Оптимизировать работу класса Order в  рамках принципа SRP.
     * @param args
     */
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        OrderManager manager = new OrderManager();
        IProvider provider = new JsonProvider();
        Order order1 = inputManager.inputOrder();
        Order order2 = inputManager.inputOrder();
        System.out.println(order1);
        System.out.println(order2);
    }
}
