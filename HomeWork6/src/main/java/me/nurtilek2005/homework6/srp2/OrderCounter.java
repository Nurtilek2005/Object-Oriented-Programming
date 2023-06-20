package me.nurtilek2005.homework6.srp2;

public class OrderCounter {
    private static int counter = 1;

    public int incrementValue() {
        return counter++;
    }

    public int getCounter() {
        return counter;
    }

    public int getValue() {
        return counter;
    }

    public static OrderCounter getInstance() {
        return new OrderCounter();
    }
}
