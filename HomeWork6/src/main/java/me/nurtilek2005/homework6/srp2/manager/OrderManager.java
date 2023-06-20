package me.nurtilek2005.homework6.srp2.manager;

import me.nurtilek2005.homework6.srp2.Order;
import me.nurtilek2005.homework6.srp2.OrderList;
import me.nurtilek2005.homework6.srp2.provider.IProvider;
import me.nurtilek2005.homework6.srp2.provider.JsonProvider;

import java.util.List;

public class OrderManager {
    private final OrderList orderList = new OrderList();
    private IProvider provider;

    public OrderManager() {
        this.provider = new JsonProvider();
    }

    public OrderManager(IProvider provider) {
        this.provider = provider;
    }

    public void addOrder(Order order) {
        this.orderList.add(order);
    }

    public List<Order> getOrderList() {
        return this.orderList;
    }

    public IProvider getProvider() {
        return this.provider;
    }

    public void setProvider(IProvider provider) {
        if (provider == null) return;
        this.provider = provider;
    }
}
