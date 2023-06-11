package me.nurtilek2005.homework_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Box {
    private final List<Fruit> fruitStorage = new ArrayList<>();

    public boolean addFruit(Fruit fruit) {
        if (this.fruitStorage.size() > 0) {
            Fruit value = this.fruitStorage.get(0);
            if (!Objects.equals(value, fruit)) {
                return false;
            }
        }
        this.fruitStorage.add(fruit);
        return true;
    }

    public float getWeight() {
        float weight = 0f;
        for (Fruit fruit: this.fruitStorage) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box box) {
        return box.getWeight() == this.getWeight();
    }

    public void interlard(Box box) {
        for (Fruit fruit : this.fruitStorage) {
            if (!box.addFruit(fruit)) return;
        }
        this.fruitStorage.clear();
    }

    public List<Fruit> getFruits() {
        return this.fruitStorage;
    }
}
