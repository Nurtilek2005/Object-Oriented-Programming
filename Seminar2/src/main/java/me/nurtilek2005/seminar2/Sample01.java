package me.nurtilek2005.seminar2;

import java.util.ArrayList;
import java.util.List;

public class Sample01 {

    public static void main(String[] args) {


        Cat cat1 = new Cat("Персик", "Рыжий");
        cat1.voice();
        ((Animal) cat1).jump();
        System.out.println(cat1.getColor());

        Dog dog1 = new Dog("Шарик", 8);
        dog1.voice();
        System.out.println(dog1.getWeight());

        List<Animal> animals = new ArrayList<>();
        animals.add(cat1);
        animals.add(dog1);

        processAnimals(animals);
    }

    static void processAnimals(List<Animal> animals) {
        for (Animal animal : animals) {
            animal.voice();
            animal.jump();
            if (animal instanceof Cat) System.out.println(((Cat) animal).getColor());

        }
    }

}

class Dog extends Animal {


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
}

class Cat extends Animal {

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
}

abstract class Animal {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal(String name) {
        this.name = name;
    }

    public abstract void voice();

    public void jump() {
        System.out.println("Животное прыгнуло.");
    }

}