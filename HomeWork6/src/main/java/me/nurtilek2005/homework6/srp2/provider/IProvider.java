package me.nurtilek2005.homework6.srp2.provider;

import me.nurtilek2005.homework6.srp2.Order;
import me.nurtilek2005.homework6.srp2.OrderList;

public interface IProvider {
    default String getName() {
        return this.getClass().getSimpleName();
    }

    String read();

    void save(OrderList orderList);

    void save(Order orderList);
}
