package me.nurtilek2005.homework6.srp2.manager;

import me.nurtilek2005.homework6.srp2.Order;

import java.util.Scanner;

public class InputManager {
    public Order inputOrder() {
        String name = prompt("Имя клиента");
        String product = prompt("Продукт");
        int count = Integer.parseInt(prompt("Кол-во"));
        int price = Integer.parseInt(prompt("Цена"));
        return new Order(name, product, count, price);
    }

    private String prompt(String message){
        Scanner iScanner = new Scanner(System.in);
        message = message.strip();
        if (message != null) {
            System.out.print(message);
            if (message.length() > 0) {
                System.out.print(": ");
            }
        }
        return iScanner.nextLine();
    }
}
