package me.nurtilek2005.homework_1;

public class Product {
    protected String name;
    protected String brand;
    protected double price;

    public Product() {
        this("product", 100);
    }

    public Product(String name, double price) {
        this("noname", name, price);
    }

    public Product(String brand, String name, double price) {
        if (!this.isPriceValid(price)) price = 100;
        if (name.length() < 5) {
            this.name = "product";
        } else {
            this.name = name;
        }
        this.brand = brand;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean setPrice(double price) {
        if (!this.isPriceValid(price)) return false;
        this.price = price;
        return true;
    }

    private boolean isPriceValid(double price) {
        if (price <= 0) return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s - %s- %f", brand, name, price);
    }
}
