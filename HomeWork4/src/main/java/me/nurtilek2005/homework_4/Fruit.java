package me.nurtilek2005.homework_4;

import java.util.Objects;

public abstract class Fruit {
    protected final String name;
    protected final float weight;

    public Fruit(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public float getWeight() {
        return this.weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Fruit fruit)) return false;
        boolean isNameEquals = Objects.equals(fruit.name, this.name);
        boolean isWeightEquals = Objects.equals(fruit.weight, this.weight);
        return isNameEquals && isWeightEquals;
    }
}
