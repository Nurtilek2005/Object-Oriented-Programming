package me.nurtilek2005.seminar2.sample3;

public class Championship {

    public static void main(String[] args) {

        Runner[] runners = {
                new Cat(1500, 300, "Барсик"),
                new Cat(1700, 220, "Персик"),
                new Robot(99999, 0, "R2D2"),
                new Robot(5000, 50, "C3PO"),
                new Human(3500, 260, "Петя"),
                new Human(3500, 120, "Вася")
        };

        Obstacle[] obstacles = {
                new Track(1200),
                new Wall(30),
                new Track(2000),
                new Wall(140),
                new Track(3000),
                new Wall(250)
        };

        for (Runner runner : runners) {
            for (Obstacle obstacle : obstacles) {
                if (obstacle instanceof Track) {
                    if (!runner.run(obstacle.getLength()))
                        break;
                } else if (obstacle instanceof Wall) {
                    if (!runner.jump(obstacle.getHeight()))
                        break;
                }
            }
        }

    }

}
