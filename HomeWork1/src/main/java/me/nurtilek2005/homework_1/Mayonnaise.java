package me.nurtilek2005.homework_1;

public class Mayonnaise extends Product {
    private final int weight;
    private final double fatContent;

    public Mayonnaise(String brand, String name, double price, int weight, double fatContent) {
        super(brand, name, price);
        this.weight = weight;
        this.fatContent = fatContent;
    }

    public int getWeight() {
        return this.weight;
    }

    public double getFatContent() {
        return this.fatContent;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Бренд: " + this.brand).append(", ");
        result.append("Имя: " + this.name).append(", ");
        result.append("Цена: " + this.price).append(", ");
        result.append("Вес: " + this.weight).append(", ");
        result.append("Жирность: " + this.fatContent + "%");
        return result.toString();
    }
}
