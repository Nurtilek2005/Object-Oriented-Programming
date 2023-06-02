package me.nurtilek2005.homework_2;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety = false;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat() {}

    public String getName() {
        return this.name;
    }

    public int getAppetite() {
        return this.appetite;
    }

    public boolean isSatiety() {
        return this.satiety;
    }

    public void setSatiety() {
        this.satiety = true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Имя: " + this.name).append(", ");
        result.append("Аппетит: " + this.appetite);
        return result.toString();
    }
}
