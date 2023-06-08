package me.nurtilek2005.seminar2.sample3;

public class Robot extends BaseRobot implements Runner {
    private final int maxRun;
    private final int maxJump;
    private final String name;

    @Override
    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public int getMaxJump() {
        return maxJump;
    }

    @Override
    public String getName() {
        return name;
    }

    public Robot(int maxRun, int maxJump, String name) {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
        this.name = name;
    }

    /*@Override
    public boolean jump(int height) {

        if (height <= maxJump) {
            System.out.printf("%s перепрыгнул через стену %d см\n", name, height);
            return true;
        } else {
            System.out.printf("%s не смог перепрыгнуть через стену %d см, остался на месте\n", name, height);
            return false;
        }
    }

    @Override
    public boolean run(int length) {
        if (length <= maxRun) {
            System.out.printf("%s пробежал по беговой дорожке %d метров\n", name, length);
            return true;
        } else {
            System.out.printf("%s не смог пробежать по беговой дорожке %d метров, он смог пробежать только %d метров\n", name, length, maxRun);
            return false;
        }
    }*/
}
