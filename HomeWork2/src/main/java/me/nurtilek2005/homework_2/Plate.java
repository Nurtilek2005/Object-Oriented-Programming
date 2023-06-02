package me.nurtilek2005.homework_2;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFood() {
        return this.food;
    }
}
