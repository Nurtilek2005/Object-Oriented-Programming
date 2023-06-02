package me.nurtilek2005.homework_1;

// Создать новый продукт на основе Product, создать ему хотя бы одно свойство
// (например, шоколад и калории) и включить в список продуктов в вендинг машину.
// Продемонстрировать работу класса по продаже товаров (как мы это делали на уроке).

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        Product mayonnaise1 = new Mayonnaise("3 Желания", "Провансаль", 250, 800, 67);
        Product mayonnaise2 = new Mayonnaise("3 Желания", "Парижанка", 40, 190, 35);
        Product mayonnaise5 = new Mayonnaise("Мечта хозяйки", "Классический", 50, 250, 50);
        Product mayonnaise3 = new Mayonnaise("3 Желания", "Завтрак на траве", 30, 190, 25);
        Product mayonnaise4 = new Mayonnaise("ЕЖК", "Провансаль", 45, 250, 67);

        List<Product> products = new ArrayList<>();
        products.add(mayonnaise1);
        products.add(mayonnaise2);
        products.add(mayonnaise3);
        products.add(mayonnaise4);

        VendingMachine vendingMachine = new VendingMachine(products);
        Mayonnaise mayonnaiseResult = vendingMachine.getMayonnaise(67.0);
        if (mayonnaiseResult != null) {
            System.out.println("Вы купили: ");
            System.out.println(mayonnaiseResult);
        } else {
            System.out.println("Такого майонеза нет в автомате.");
        }
    }

}
