package me.nurtilek2005.homework_4;

public class Program {
    public void run() {
        Box box1 = new Box();
        box1.addFruit(new Apple());
        box1.addFruit(new Apple());
        System.out.println(box1.getWeight());

        Box box2 = new Box();
        box2.addFruit(new Orange());
        box1.interlard(box2);

        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());
    }

    public static void main(String[] args) {
        Program program = new Program();
        program.run();
    }
}