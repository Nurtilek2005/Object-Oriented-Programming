package me.nurtilek2005.homework6.srp2;

import java.util.ArrayList;

public class OrderList extends ArrayList<Order> {
    public Order getById(int id) {
        for (Order order: this) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }
}
