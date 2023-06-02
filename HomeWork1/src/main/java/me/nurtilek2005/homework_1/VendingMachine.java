package me.nurtilek2005.homework_1;

import java.util.List;

public class VendingMachine {
    private final List<Product> products;

    public VendingMachine(List<Product> products) {
        this.products = products;
    }

    public BottleOfWater getBottleOfWater(double volume) {
        for (Product product : this.products) {
            if (product instanceof BottleOfWater) {
                if (((BottleOfWater) product).getVolume() == volume) {
                    return (BottleOfWater) product;
                }
            }
        }
        return null;
    }

    public Mayonnaise getMayonnaise(int weight) {
        for (Product product : this.products) {
            if (product instanceof Mayonnaise) {
                if (((Mayonnaise) product).getWeight() == weight) {
                    return (Mayonnaise) product;
                }
            }
        }
        return null;
    }

    public Mayonnaise getMayonnaise(double fatContent) {
        for (Product product : this.products) {
            if (product instanceof Mayonnaise) {
                if (((Mayonnaise) product).getFatContent() == fatContent) {
                    return (Mayonnaise) product;
                }
            }
        }
        return null;
    }
}
