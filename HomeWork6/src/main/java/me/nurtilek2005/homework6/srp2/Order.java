package me.nurtilek2005.homework6.srp2;

import me.nurtilek2005.json.Json;

public class Order {
    private int id;
    private String name;
    private String product;
    private int count;
    private int price;

    public Order(String name, String product, int count, int price) {
        this.id = OrderCounter.getInstance().incrementValue();
        this.name = name;
        this.product = product;
        this.count = count;
        this.price = price;
    }

    public Json toJson() {
        Json json = new Json();
        json.put("ID заказа", this.id);
        json.put("Имя клиента", this.name);
        json.put("Продукт", this.product);
        json.put("Кол-во", this.count);
        json.put("Цена", this.price);
        return json;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("ID заказа: " + this.id + "\n");
        result.append("Имя клиента: " + this.name + "\n");
        result.append("Продукт: " + this.product + "\n");
        result.append("Кол-во: " + this.count + "\n");
        result.append("Цена: " + this.price);
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Order order) {
            return order.getId() == this.id;
        }
        return false;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getProduct() {
        return this.product;
    }

    public int getCount() {
        return this.count;
    }

    public int getPrice() {
        return this.price;
    }
}
