package me.nurtilek2005.seminar2.sample2;


import java.util.ArrayList;
import java.util.List;

public class Sample02 {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Персик", "Рыжий");
        cat1.voice();

        //System.out.println(cat1.getColor());

        Dog dog1 = new Dog("Шарик", 8);
        dog1.voice();
        System.out.println(dog1.getWeight());

        List<Runnable> runners = new ArrayList<>();

        runners.add(cat1);
        runners.add(dog1);

        processAnimals(runners);
    }

    static void processAnimals(List<Runnable> animals) {
        for (Runnable animal : animals) {
            animal.run(20);
            animal.swim(50);
            if (animal instanceof Cat) System.out.println(((Cat) animal).getColor());

        }
    }

}

interface Runnable {

    void swim(int distance);

    void run(int distance);
}

abstract class BaseCat {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BaseCat(String name) {
        this.name = name;
    }

    public abstract void voice();

    public void jump() {
        System.out.println("Животное прыгнуло.");
    }

}

abstract class BaseDog {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BaseDog(String name) {
        this.name = name;
    }

    public abstract void voice();

    public void jump() {
        System.out.println("Животное прыгнуло.");
    }

}

class Dog extends BaseDog implements Runnable {


    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Dog(String name, int weight) {
        super(name);
        this.weight = weight;
    }

    @Override
    public void voice() {
        System.out.println("Собака лает");
    }

    @Override
    public void jump() {
        super.jump();
    }

    @Override
    public void swim(int distance) {
        System.out.printf("Собака проплыла %d метров\n", distance);
    }

    @Override
    public void run(int distance) {
        System.out.printf("Собака пробежала %d метров\n", distance);
    }
}

class Cat extends BaseCat implements Runnable {

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cat(String name, String color) {
        super(name);
        this.color = color;
    }

    @Override
    public void voice() {
        System.out.println("Кот мяукает");
    }

    @Override
    public void swim(int distance) {
        System.out.printf("Кот проплыл %d метров\n", distance);
    }

    @Override
    public void run(int distance) {
        System.out.printf("Кот пробежал %d метров\n", distance);
    }
}
