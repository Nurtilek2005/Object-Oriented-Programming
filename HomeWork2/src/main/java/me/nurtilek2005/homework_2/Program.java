package me.nurtilek2005.homework_2;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private final List<Cat> cats = new ArrayList<>();

    public void run() {
        Plate plate = new Plate(10);
        cats.add(new Cat("Гарфилд", 5));
        cats.add(new Cat("Том", 10));
        cats.add(new Cat("Гудвин", 3));
        cats.add(new Cat("Рокки", 6));
        cats.add(new Cat("Саймон", 6));
        for (Cat cat : this.cats) {
            int appetite = cat.getAppetite();
            if (plate.getFood() > appetite) {
                if (cat.isSatiety()) {
                    System.out.format("%s уже сыт\n", cat.getName());
                    continue;
                }
                cat.eat();
                cat.setSatiety();
                plate.setFood(plate.getFood() - appetite);
                System.out.format("%s кушает\n", cat.getName());
            } else {
                System.out.format("%s не наестся\n", cat.getName());
            }
            System.out.format("осталось %s еды\n", plate.getFood());
        }
        List<Cat> satieryCats = new ArrayList<>();
        List<Cat> notSatieryCats = new ArrayList<>();
        for (Cat cat: this.cats) {
            if (cat.isSatiety()) satieryCats.add(cat);
            else notSatieryCats.add(cat);
        }
        System.out.println("Коты которые наелись");
        System.out.println(satieryCats);
        System.out.println("Коты которые не наелись");
        System.out.println(notSatieryCats);
    }

    public static void main(String[] args) {
        Program program = new Program();
        program.run();
    }
}
