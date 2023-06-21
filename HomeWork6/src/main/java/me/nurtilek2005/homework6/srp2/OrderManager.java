package me.nurtilek2005.homework6.srp2;

// Не знал как назвать правильнее

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManager {
    private List<Order> orderList = new ArrayList<>();

    public List<Order> getOrderList() {
        return this.orderList;
    }

    public Order inputOrder() {
        String clientName = prompt("Имя клиента: ");
        String product = prompt("Продукт: ");
        int qnt = Integer.parseInt(prompt("Кол-во: "));
        int price = Integer.parseInt(prompt("Цена: "));
        return new Order(clientName, product, qnt, price);
    }

    private String prompt(String message) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println(message);
        return iScanner.nextLine();
    }
}
