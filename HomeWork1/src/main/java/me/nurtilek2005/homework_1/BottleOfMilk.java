package me.nurtilek2005.homework_1;

public class BottleOfMilk extends Product {
    private double volume; // объем
    private int fatContent; // Содержание жирности

    public BottleOfMilk(String brand, String name, double price, double volume, int fatContent) {
        super(brand, name, price);
        this.volume = volume;
        this.fatContent = fatContent;
    }

    public double getVolume() {
        return this.volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getFatContent() {
        return this.fatContent;
    }

    public void setFatContent(int fatContent) {
        this.fatContent = fatContent;
    }

    @Override
    public String toString() {
        return String.format("[Бутылка]%s - %s - %f - [объем: %f; жирность: %d]", brand, name, price, volume, fatContent);
    }
}
